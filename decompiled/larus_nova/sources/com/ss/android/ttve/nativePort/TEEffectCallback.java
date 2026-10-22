package com.ss.android.ttve.nativePort;

import android.util.SparseArray;
import com.ss.android.medialib.presenter.IStickerRequestCallback;
import com.ss.android.vesdk.VEBachAlgorithmCallback;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VELandMarkDetectListener;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.VERecorder;
import com.ss.android.vesdk.a0;
import com.ss.android.vesdk.b0;
import com.ss.android.vesdk.faceinfo.VEFaceAttributeInfo;
import com.ss.android.vesdk.faceinfo.VEFaceDetectInfo;
import com.ss.android.vesdk.faceinfo.VESkeletonInfo;
import com.ss.android.vesdk.model.BefTextLayout;
import com.ss.android.vesdk.model.BefTextLayoutResult;
import com.ss.android.vesdk.v;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes38.dex */
public class TEEffectCallback {
    private static final int ARTEXT_BITMAP = 4;
    private static final int ARTEXT_CONTENT = 5;
    private static final int ARTEXT_LIMIT = 10;
    private static final int BACH_AFTEREFFECT_CALLBACK = 7;
    private static final int EFFECT_ALGORITHM_INFO = 8;
    private static final int FACE_DETECT_LISTENER = 1;
    private static final int FACE_INFO = 0;
    private static final int LANDMARK_DETECT_LISTENER = 3;
    private static final int REQUEST_STICKER_CALLBACK = 6;
    private static final int SKELETON_DETECT = 9;
    private static final int SMART_BEAUTY = 2;
    private static final String TAG = "TEEffectCallback";
    private final boolean fixCrashOpt;
    private VERecorder.OnARTextBitmapCallback mARTextBitmapCallback;
    private VERecorder.OnARTextCallback mARTextCallback;
    private VERecorder.OnARTextCallback mARTextLimitCountCallback;
    private List<VEBachAlgorithmCallback> mBachAlgorithmCallbacks;
    private VERecorder.VEEffectAlgorithmCallback mEffectAlgorithmCallback;
    private hic.a mFaceDetectListener;
    private a mFaceInfoCallback;
    private VELandMarkDetectListener mLandMarkDetectCallback;
    private byte[][] mResult;
    private VERecorder.VESkeletonDetectCallback mSkeletonDetectCallback;
    private VERecorder.h0 mSmartBeautyListener;
    private IStickerRequestCallback mStickerRequestCallback;

    public interface a {
    }

    public void setOnSmartBeautyListener(VERecorder.h0 r100) {
    }

    public void unregBachAlgorithmCallback() {
        this.mBachAlgorithmCallbacks = null;
    }

    public TEEffectCallback() {
        this.fixCrashOpt = VEConfigCenter.getInstance().getValue("veabtest_fix_crash_opt", false).booleanValue();
    }

    public void regBachAlgorithmCallback(List<VEBachAlgorithmCallback> r100) {
        this.mBachAlgorithmCallbacks = r100;
    }

    public void setARTextBitmapCallback(VERecorder.OnARTextBitmapCallback r100) {
        this.mARTextBitmapCallback = r100;
    }

    public void setARTextLimitCountCallback(VERecorder.OnARTextCallback r100) {
        this.mARTextLimitCountCallback = r100;
    }

    public void setARTextParagraphContentCallback(VERecorder.OnARTextCallback r100) {
        this.mARTextCallback = r100;
    }

    public void setEffectAlgorithmInfoCallback(VERecorder.VEEffectAlgorithmCallback r100) {
        this.mEffectAlgorithmCallback = r100;
    }

    public void setFaceDetectListener(hic.a r100) {
        this.mFaceDetectListener = r100;
    }

    public void setFaceInfoCallback(a r100) {
        this.mFaceInfoCallback = r100;
    }

    public void setLandmarkDetectListener(VELandMarkDetectListener r100) {
        this.mLandMarkDetectCallback = r100;
    }

    public void setSkeletonDetectCallback(VERecorder.VESkeletonDetectCallback r100) {
        this.mSkeletonDetectCallback = r100;
    }

    public void setStickerRequestCallback(IStickerRequestCallback r100) {
        this.mStickerRequestCallback = r100;
    }

    public void nativeCallback(byte[][] r100, int r101) {
        int r102 = 0;
        if (r101 != 0) goto L5;
        a r103 = this.mFaceInfoCallback;
        if (r103 != null) goto L96;
        VELogUtil.e(TAG, "face info callback is null");
        return;
    L96:
        a0 r104 = (a0) r103;
        if (r100 != null) goto L102;
        Iterator r105 = ((CopyOnWriteArrayList) r104.f455730a.f455591c).iterator();
    L100:
        if (r105.hasNext() == false) goto L127;
        ((VERecorder.VEFaceInfoCallback) r105.next()).onResult(null, null);
        goto L100
    L127:
        return;
    L102:
        r104.getClass();
        VEFaceAttributeInfo r106 = new VEFaceAttributeInfo();
        r106.setParcelWrapper(new e(r100[0]));
        r106.readFromParcel();
        VEFaceDetectInfo r107 = new VEFaceDetectInfo();
        r107.setParcelWrapper(new e(r100[1]));
        r107.readFromParcel();
        Iterator r108 = ((CopyOnWriteArrayList) r104.f455730a.f455591c).iterator();
    L104:
        if (r108.hasNext() == false) goto L128;
        ((VERecorder.VEFaceInfoCallback) r108.next()).onResult(r106, r107);
        goto L104
    L128:
        return;
    L5:
        if (r101 == 1) goto L84;
        if (r101 == 3) goto L77;
        switch(r101) {
            case 5: goto L62;
            case 6: goto L50;
            case 7: goto L39;
            case 8: goto L30;
            case 9: goto L26;
            case 10: goto L11;
            default: goto L125;
        };
    L26:
        VERecorder.VESkeletonDetectCallback r109 = this.mSkeletonDetectCallback;
        if (r109 == null) goto L114;
        r109.onResult(VESkeletonInfo.convert(r100));
        return;
    L114:
        return;
    L39:
        List<VEBachAlgorithmCallback> r110 = this.mBachAlgorithmCallbacks;
        if (r110 != null) goto L43;
        VELogUtil.e(TAG, "bach algorithm callbacks is null");
        return;
    L43:
        Iterator<VEBachAlgorithmCallback> r111 = r110.iterator();
    L45:
        if (r111.hasNext() == false) goto L126;
        VEBachAlgorithmCallback r112 = r111.next();
        if (r112.getAlgorithmType() != VEBachAlgorithmCallback.VEBachAlgorithmType.AFTER_EFFECT) goto L45;
        e r113 = new e(r100[0]);
        r113.c();
        r113.b();
        r113.b();
        r113.b();
        r113.b();
        r113.b();
        r113.b();
        v r114 = (v) r112;
        return;
    L126:
        return;
    L125:
        return;
    L11:
        if (this.mARTextLimitCountCallback != null) goto L14;
        VELogUtil.e(TAG, "artext limit callback is null");
        return;
    L14:
        if (r100 != null) goto L17;
        VELogUtil.e(TAG, "artext limit param is null");
        return;
    L17:
        byte[] r115 = r100[0];
        if ((0 + 4) <= r115.length) goto L20;
        VELogUtil.e("TEParcel", "out of border");
        int r116 = -1;
    L25:
        this.mARTextLimitCountCallback.onLimitCountResult(r116);
        return;
    L20:
        int r117 = (((r115[0] & UByte.MAX_VALUE) | ((r115[1 + 0] & UByte.MAX_VALUE) << 8)) | ((r115[0 + 2] & UByte.MAX_VALUE) << 16)) | ((r115[0 + 3] & ByteCompanionObject.MAX_VALUE) << 24);
        if ((r115[0 + 3] >> 7) == 0) goto L24;
        r117 = r117 - Integer.MIN_VALUE;
    L24:
        r116 = r117;
        goto L25
    L30:
        if (this.mEffectAlgorithmCallback != null) goto L33;
        VELogUtil.e(TAG, "effect algorithm listener is null");
        return;
    L33:
        if (r100 != null) goto L35;
        return;
    L35:
        e r118 = new e(r100[0]);
        float r119 = r118.b();
        int r120 = r118.c();
        SparseArray<Long> r121 = new SparseArray();
    L36:
        if (r102 >= r120) goto L38;
        r121.put((int) r118.e().longValue(), Long.valueOf(r118.e().longValue()));
        r102 = r102 + 1;
        goto L36
    L38:
        this.mEffectAlgorithmCallback.onResult(r121, r119);
        return;
    L50:
        if (this.mStickerRequestCallback != null) goto L53;
        VELogUtil.e(TAG, "sticker request callback listener is null");
        return;
    L53:
        if (r100 != null) goto L55;
        return;
    L55:
        e r122 = new e(r100[0]);
        boolean r123 = r122.a();
        long r124 = r122.e().longValue();
        if (this.fixCrashOpt == false) goto L60;
        IStickerRequestCallback r125 = this.mStickerRequestCallback;
        if (r125 == null) goto L118;
        r125.onStickerRequested(r124, r123);
        return;
    L118:
        return;
    L60:
        this.mStickerRequestCallback.onStickerRequested(r124, r123);
        return;
    L62:
        if (this.mARTextCallback != null) goto L65;
        VELogUtil.e(TAG, "artext content listener is null");
        return;
    L65:
        if (r100 != null) goto L67;
    L74:
        VELogUtil.e(TAG, "artext param is null");
        return;
    L67:
        if (r100.length == 0) goto L74;
        VELogUtil.i(TAG, "artext param.length is " + r100.length);
        String[] r126 = new String[r100.length];
    L71:
        if (r102 >= r100.length) goto L73;
        r126[r102] = new e(r100[r102]).f();
        VELogUtil.i(TAG, "artext param[" + r102 + "] " + r126[r102] + ", " + r100[r102].length);
        r102 = r102 + 1;
        goto L71
    L73:
        this.mARTextCallback.onContentResult(r126);
        return;
    L77:
        if (this.mLandMarkDetectCallback != null) goto L80;
        VELogUtil.e(TAG, "detect listener is null");
        return;
    L80:
        if (r100 != null) goto L82;
        return;
    L82:
        this.mLandMarkDetectCallback.onLandMark(new e(r100[0]).a());
        return;
    L84:
        if (this.mFaceDetectListener != null) goto L87;
        VELogUtil.e(TAG, "detect listener is null");
        return;
    L87:
        if (r100 != null) goto L89;
        return;
    L89:
        e r127 = new e(r100[0]);
        int r128 = r127.c();
        int r129 = r127.c();
        VERecorder.DetectListener r130 = ((b0) this.mFaceDetectListener).f455758a;
        if (r130 == null) goto L123;
        r130.onResult(r128, r129);
        return;
    }

    public ByteBuffer nativeCallbackWithResult(byte[][] r100, int r101) {
        if (r101 == 4) goto L6;
    L22:
        return null;
    L6:
        if (this.mARTextBitmapCallback != null) goto L9;
        VELogUtil.e(TAG, "artext bitmap listener is null");
        return null;
    L9:
        if (r100 != null) goto L11;
        return null;
    L11:
        boolean r102 = false;
        e r103 = new e(r100[0]);
        BefTextLayout r104 = new BefTextLayout();
        r104.setCharSize(r103.c());
        r104.setLetterSpacing(r103.c());
        r104.setLineWidth(r103.c());
        r104.setLineHeight(r103.b());
        r104.setTextAlign(r103.c());
        r104.setTextIndent(r103.c());
        r104.setSplit(r103.c());
        r104.setLineCount(r103.c());
        r104.setTextColor(r103.c());
        r104.setBackColor(r103.c());
        if (1 != r103.c()) goto L14;
        r102 = true;
    L14:
        r104.setPlaceholder(r102);
        r104.setFamilyName(r103.f());
        String r105 = r103.f();
        if (r105 != null) goto L18;
        VELogUtil.e(TAG, "Read content failed.");
        return null;
    L18:
        BefTextLayoutResult r106 = this.mARTextBitmapCallback.onBefTextLayoutResult(r105, r104);
        if (r106 == null) goto L22;
        ByteBuffer r107 = ByteBuffer.allocate(r106.getBitmap().getByteCount());
        r106.getBitmap().copyPixelsToBuffer(r107);
        f r108 = new f(r106.getBitmap().getByteCount() + 16);
        r108.h(r106.getWidth());
        r108.h(r106.getHeight());
        r108.h(r106.getLineCount());
        r108.h(r106.getBitmap().getByteCount());
        r108.f449976c.put(r107.array());
        r108.f449976c.rewind();
        return r108.f449976c;
    }
}
