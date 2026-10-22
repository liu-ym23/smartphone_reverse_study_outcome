package com.bytedance.common.jato.view.dump;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.bytedance.common.jato.view.InflateInfo;
import com.bytedance.common.jato.view.ViewInfo;
import com.bytedance.common.jato.view.ViewInfoListener;
import com.bytedance.common.jato.view.ViewInfoManager;
import com.bytedance.common.jato.view.ViewState;
import com.bytedance.common.jato.view.ViewUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes15.dex */
public class RenderInfoDump {
    public static ViewTypeEnum[] sViewTypes;
    private final Pools.Pool<ByteBuffer> bufferPool;
    private volatile boolean isStarted;
    private final AtomicLong mLastHistoryCheckTime;
    private final CopyOnWriteArrayList<OnViewDumpListener> mListeners;
    private final Rect tmpRect;
    private TypeGetter typeGetter;
    private final AtomicInteger uniqueId;
    private final ViewInfoListener<ViewInfo> viewInfoListener;

    public interface OnViewDumpListener {
        void onViewDumpAttached(RenderInfoDump r100, View r101, ViewInfo r102, boolean r103, boolean r104);

        void onViewDumpCreated(RenderInfoDump r100, View r101, ViewInfo r102, boolean r103);

        void onViewDumpDestroyed(RenderInfoDump r100, ViewInfo r101);

        void onViewDumpDetached(RenderInfoDump r100, View r101, ViewInfo r102, boolean r103);
    }

    public interface TypeGetter {
        int getType(View r100, ViewInfo r101);
    }

    private static native boolean nativeDump(long r100, int r101, long r102, ByteBuffer r103, int r104);

    private static native boolean nativeDumpExtra(long r100, long r101, short r102, short r103);

    private static native boolean nativeDumpFast(long r100, int r101, long r102);

    private static native boolean nativeDumpFastFloat(long r100, int r101, long r102, float r103);

    private static native boolean nativeDumpFastInt(long r100, int r101, long r102, int r103);

    private static native boolean nativeDumpFastLong(long r100, int r101, long r102, long r103);

    private static native boolean nativeDumpFastLongInt(long r100, int r101, long r102, long r103, int r104);

    private static native boolean nativeDumpFastRect(long r100, int r101, long r102, int r103, int r104, int r105, int r106);

    private static native ByteBuffer nativeGetChangedList();

    private static native short nativeGetStringIndex(String r100);

    private static native void nativeReleaseByteBuffer(long r100);

    private static native void nativeSetFrameInterval(long r100);

    private static native boolean nativeStartDump(String r100, ByteBuffer r101, int r102, int r103);

    private static native ByteBuffer nativeStopDump();

    public ByteBuffer acquireByteBuffer() {
        ByteBuffer r100 = this.bufferPool.acquire();
        if (r100 != null) goto L5;
        r100 = ByteBuffer.allocateDirect(4096);
        r100.order(ByteOrder.nativeOrder());
    L5:
        r100.clear();
        return r100;
    }

    static {
        sViewTypes = ViewTypeEnum.values();
    }

    public RenderInfoDump() {
        this.uniqueId = new AtomicInteger();
        this.bufferPool = new Pools.SynchronizedPool(10);
        this.tmpRect = new Rect();
        this.mLastHistoryCheckTime = new AtomicLong(0);
        this.mListeners = new CopyOnWriteArrayList();
        this.viewInfoListener = new AnonymousClass1(this);
    }

    private void checkNativeHistoryList(boolean r100) {
        if (r100 == true) goto L9;
        long r101 = System.currentTimeMillis();
    L4:
        long r102 = this.mLastHistoryCheckTime.get();
        if ((r101 - r102) < 2000) goto L6;
        if (this.mLastHistoryCheckTime.compareAndSet(r102, r101) == false) goto L4;
    L6:
        return;
    L9:
        ByteBuffer r103 = nativeGetChangedList();
        if (r103 != null) goto L12;
        return;
    L12:
        r103.order(ByteOrder.nativeOrder());
        long r104 = r103.getLong();
        int r105 = r103.getInt();
        int r106 = 0;
    L13:
        if (r106 >= r105) goto L21;
        long r107 = r103.getLong();
        ViewInfo r108 = ViewInfoManager.getInstance().getViewInfo(null, r107);
        if (r108 == null) goto L20;
        View r109 = r108.getView();
        if (r109 == null) goto L19;
        dumpViewHistory(r109, r108, r108.getState());
        goto L20
    L19:
        dumpViewLifeHistory(null, r108);
    L20:
        r106 = r106 + 1;
        goto L13
    L21:
        nativeReleaseByteBuffer(r104);
    }

    public static int getViewType(View r100) {
        ViewTypeEnum[] r101 = sViewTypes;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        ViewTypeEnum r104 = r101[r103];
        if (r104.type.isInstance(r100) == true) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        return r104.index;
    L9:
        return 0;
    }

    public void dumpViewDestroyed(ViewInfo r100) {
        if (this.isStarted == true) goto L6;
        return;
    L6:
        if (nativeDumpFast(r100.getPtr(), RenderLifeType.destroyView.index(), r100.getDetachedTime()) == false) goto L9;
        dumpViewLifeHistory(null, r100);
    L9:
        if (this.mListeners.isEmpty() == true) goto L14;
        Iterator<OnViewDumpListener> r101 = this.mListeners.iterator();
    L12:
        if (r101.hasNext() == false) goto L16;
        r101.next().onViewDumpDestroyed(this, r100);
        goto L12
    L16:
        return;
    }

    public short getStringIndex(String r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return nativeGetStringIndex(r100);
    }

    public void releaseByteBuffer(ByteBuffer r100) {
        r100.clear();
        this.bufferPool.release(r100);
    }

    public static /* synthetic */ void access$000(RenderInfoDump r100, boolean r101) {
        r100.checkNativeHistoryList(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dumpViewAttached(View r110, ViewInfo r210) {
        if (r110 != null) goto L5;
    L7:
        long r100 = 0;
    L8:
        long r111 = r100;
        if (r210.isFirstAttached() == true) goto L11;
    L13:
        int r112 = 0;
    L14:
        if (r112 == 0) goto L17;
        r210.setFlag(65536);
    L17:
        if (nativeDumpFastLongInt(r210.getPtr(), RenderLifeType.attachedToWindow.index(), r210.getAttachedTime(), r111, r112) == false) goto L20;
        if (r110 == null) goto L20;
        dumpViewHistory(r110, r210, ViewState.Created);
        boolean r101 = true;
    L22:
        if (this.mListeners.isEmpty() == true) goto L27;
        Iterator<OnViewDumpListener> r113 = this.mListeners.iterator();
    L25:
        if (r113.hasNext() == false) goto L29;
        r113.next().onViewDumpAttached(this, r110, r210, r112, r101);
        goto L25
    L29:
        return;
    L27:
        return;
    L20:
        r101 = false;
        goto L22
    L11:
        if (r210.hasFlag(65536) == true) goto L13;
        r112 = 1;
        goto L14
    L5:
        if ((r110.getParent() instanceof ViewGroup) == false) goto L7;
        r100 = ViewUtils.getRenderNodePtr((ViewGroup) r110.getParent());
        goto L8
    }

    public void dumpViewDetached(View r110, ViewInfo r111) {
        if (r110 != null) goto L4;
    L6:
        long r100 = 0;
    L7:
        long r101 = r100;
        if (nativeDumpFastLong(r111.getPtr(), RenderLifeType.detachedFromWindow.index(), r111.getDetachedTime(), r101) == false) goto L11;
        if (r110 == null) goto L11;
        dumpViewHistory(r110, r111, ViewState.Attached);
        boolean r102 = true;
    L13:
        if (this.mListeners.isEmpty() == true) goto L18;
        Iterator<OnViewDumpListener> r103 = this.mListeners.iterator();
    L16:
        if (r103.hasNext() == false) goto L20;
        r103.next().onViewDumpDetached(this, r110, r111, r102);
        goto L16
    L20:
        return;
    L18:
        return;
    L11:
        r102 = false;
        goto L13
    L4:
        if ((r110.getParent() instanceof ViewGroup) == false) goto L6;
        r100 = ViewUtils.getRenderNodePtr((ViewGroup) r110.getParent());
        goto L7
    }

    public void dumpViewLifeHistory(View r100, ViewInfo r101) {
        if (this.isStarted == true) goto L5;
        return;
    L5:
        ViewState r102 = r101.getState();
        dumpViewCreated(r100, r101, true);
        ViewState r103 = ViewState.Attached;
        if (r103.notGreaterThan(r101.getState()) == false) goto L11;
        if (r102 != null) goto L9;
    L10:
        dumpViewAttached(r100, r101);
        goto L11
    L9:
        if (r103.lessThan(r102) == false) goto L10;
    L11:
        ViewState r104 = ViewState.Detached;
        if (r104.notGreaterThan(r101.getState()) == false) goto L18;
        if (r102 != null) goto L15;
    L16:
        dumpViewDetached(r100, r101);
        return;
    L15:
        if (r104.lessThan(r102) == false) goto L16;
        return;
    }

    public void dumpViewCreated(View r210, ViewInfo r211, boolean r212) {
        if (this.isStarted == true) goto L5;
        return;
    L5:
        short r100 = getStringIndex(r211.getName());
        short r101 = getStringIndex(r211.getScene());
        short r102 = getStringIndex(r211.getThreadName());
        short r103 = getStringIndex(r211.getActivity());
        int r104 = r211.getId();
        InflateInfo r105 = r211.getInflateInfo();
        long r106 = r211.getCreateTime();
        if (r105 == null) goto L10;
        int r110 = r105.getId();
        if (r105.getFirstViewInfo() != r211) goto L11;
        long r111 = r105.getStart();
        long r107 = r105.getEnd();
    L12:
        ByteBuffer r112 = acquireByteBuffer();
        r112.putShort(r100);
        r112.putShort(r101);
        r112.putShort(r102);
        r112.putShort(r103);
        r112.putInt(r211.getThreadId());
        r112.putInt(r110);
        r112.putInt(r104);
        TypeGetter r108 = this.typeGetter;
        if (r108 == null) goto L15;
        r112.putInt(r108.getType(r210, r211));
    L16:
        r112.flip();
        if (r107 == 0) goto L19;
        nativeDump(r211.getPtr(), RenderLifeType.createStart.index(), r111, r112, r112.limit());
        nativeDumpFast(r211.getPtr(), RenderLifeType.createEnd.index(), r107);
    L20:
        releaseByteBuffer(r112);
        if (this.mListeners.isEmpty() == true) goto L26;
        Iterator<OnViewDumpListener> r109 = this.mListeners.iterator();
    L24:
        if (r109.hasNext() == false) goto L28;
        r109.next().onViewDumpCreated(this, r210, r211, r212);
        goto L24
    L28:
        return;
    L26:
        return;
    L19:
        nativeDump(r211.getPtr(), RenderLifeType.createView.index(), r111, r112, r112.limit());
        goto L20
    L15:
        r112.putInt(getViewType(r210));
    L11:
        r111 = r106;
        r107 = 0;
        goto L12
    L10:
        r110 = 0;
        goto L11
    }

    public void dumpViewHistory(View r110, ViewInfo r111, ViewState r210) {
        if (this.isStarted == true) goto L5;
        return;
    L5:
        dumpViewCreated(r110, r111, true);
        if (r110.getWidth() <= 0) goto L8;
    L9:
        nativeDumpFastRect(r111.getPtr(), RenderLifeType.layoutEnd.index(), 0, r110.getLeft(), r110.getTop(), r110.getRight(), r110.getBottom());
    L11:
        if (r110.getClipToOutline() == false) goto L14;
        nativeDumpFast(r111.getPtr(), RenderOpType.nSetClipToOutline.boolTrue(), 0);
    L14:
        if (r110.getLayerType() == 0) goto L16;
        nativeDumpFastInt(r111.getPtr(), RenderOpType.nSetLayerType.index(), 0, r110.getLayerType());
    L16:
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 23) goto L19;
    L21:
        Drawable r101 = r110.getBackground();
        if (r100 < 29) goto L27;
        if (r101 == null) goto L27;
        if (r101.isProjected() == false) goto L27;
        nativeDumpFast(r111.getPtr(), RenderOpType.nSetProjectBackwards.boolTrue(), 0);
    L27:
        if (r101 == null) goto L30;
        nativeDumpFast(r111.getPtr(), RenderOpType.nSetProjectionReceiver.boolTrue(), 0);
    L30:
        if (r110.isAttachedToWindow() == true) goto L32;
    L34:
        ViewState r102 = ViewState.Detached;
        if (r102.lessThan(r210) == true) goto L40;
        if (r111.getState() != r102) goto L40;
        dumpViewDetached(r110, r111);
    L40:
        if ((1.0f - r110.getAlpha()) <= 1.0E-5f) goto L43;
        nativeDumpFastFloat(r111.getPtr(), RenderOpType.nSetAlpha.index(), 0, r110.getAlpha());
    L43:
        if (r100 < 24) goto L48;
        if (r110.getHasOverlappingRendering() == false) goto L48;
        nativeDumpFast(r111.getPtr(), RenderOpType.nSetHasOverlappingRendering.boolTrue(), 0);
    L48:
        if (Math.abs(r110.getTranslationX()) <= 1.0E-5f) goto L51;
        nativeDumpFastFloat(r111.getPtr(), RenderOpType.nSetTranslationX.index(), 0, r110.getTranslationX());
    L51:
        if (Math.abs(r110.getTranslationY()) <= 1.0E-5f) goto L54;
        nativeDumpFastFloat(r111.getPtr(), RenderOpType.nSetTranslationY.index(), 0, r110.getTranslationY());
    L54:
        if (Math.abs(r110.getTranslationZ()) <= 1.0E-5f) goto L57;
        nativeDumpFastFloat(r111.getPtr(), RenderOpType.nSetTranslationZ.index(), 0, r110.getTranslationZ());
    L57:
        if (Math.abs(r110.getRotation()) <= 1.0E-5f) goto L60;
        nativeDumpFastFloat(r111.getPtr(), RenderOpType.nSetRotation.index(), 0, r110.getRotation());
    L60:
        if (Math.abs(r110.getRotationX()) <= 1.0E-5f) goto L63;
        nativeDumpFastFloat(r111.getPtr(), RenderOpType.nSetRotationX.index(), 0, r110.getRotationX());
    L63:
        if (Math.abs(r110.getRotationY()) <= 1.0E-5f) goto L66;
        nativeDumpFastFloat(r111.getPtr(), RenderOpType.nSetRotationY.index(), 0, r110.getRotationY());
    L66:
        if (Math.abs(r110.getScaleX() - 1.0f) <= 1.0E-5f) goto L69;
        nativeDumpFastFloat(r111.getPtr(), RenderOpType.nSetScaleX.index(), 0, r110.getScaleX());
    L69:
        if (Math.abs(r110.getScaleY() - 1.0f) <= 1.0E-5f) goto L72;
        nativeDumpFastFloat(r111.getPtr(), RenderOpType.nSetScaleY.index(), 0, r110.getScaleY());
    L72:
        if (Math.abs(r110.getPivotX() - (r110.getWidth() / 2.0f)) <= 1.0E-5f) goto L75;
        nativeDumpFastFloat(r111.getPtr(), RenderOpType.nSetPivotX.index(), 0, r110.getPivotX());
    L75:
        if (Math.abs(r110.getPivotY() - (r110.getHeight() / 2.0f)) <= 1.0E-5f) goto L78;
        nativeDumpFastFloat(r111.getPtr(), RenderOpType.nSetPivotY.index(), 0, r110.getPivotY());
    L78:
        if ((r110 instanceof ViewGroup) == true) goto L80;
        return;
    L80:
        if (((ViewGroup) r110).getClipChildren() == true) goto L84;
        nativeDumpFast(r111.getPtr(), RenderOpType.nSetClipToBounds.boolFalse(), 0);
        return;
    L84:
        return;
    L32:
        if (ViewState.Attached.lessThan(r210) == true) goto L34;
        dumpViewAttached(r110, r111);
        goto L34
    L19:
        if (r110.getClipBounds(this.tmpRect) == false) goto L21;
        long r103 = r111.getPtr();
        int r112 = RenderOpType.nSetClipBounds.index();
        Rect r104 = this.tmpRect;
        nativeDumpFastRect(r103, r112, 0, r104.left, r104.top, r104.right, r104.bottom);
        goto L21
    L8:
        if (r110.getHeight() <= 0) goto L11;
        goto L9
    }
}
