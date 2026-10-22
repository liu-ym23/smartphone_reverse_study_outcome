package com.bytedance.android.ui.ec.widget.photodraweeview.gestures;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u000e\u0010'\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020)2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010.\u001a\u00020)2\u0006\u0010$\u001a\u00020%H\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0011\u0010\u0015\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000bR\u0011\u0010!\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000b¨\u00060"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/MultiPointerGestureDetector;", "", "()V", "<set-?>", "", "curPointerCount", "getCurPointerCount", "()I", "currentX", "", "getCurrentX", "()[F", "currentY", "getCurrentY", "", "isGestureInProgress", "()Z", "lastPointCount", "getLastPointCount", "lastX", "getLastX", "lastY", "getLastY", "listener", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/GestureListener;", "getListener", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/GestureListener;", "setListener", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/GestureListener;)V", "mId", "", "startX", "getStartX", "startY", "getStartY", "getPressedPointerIndex", "event", "Landroid/view/MotionEvent;", "i", "onTouchEvent", "reset", "", "startGesture", "stopGesture", "updateGesture", "updatePointersOnMove", "updatePointersOnTap", "Companion", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiPointerGestureDetector {
    public static final Companion Companion = null;
    private static final int MAX_POINTERS = 2;
    private int curPointerCount;
    private final float[] currentX;
    private final float[] currentY;
    private boolean isGestureInProgress;
    private int lastPointCount;
    private final float[] lastX;
    private final float[] lastY;
    private GestureListener<MultiPointerGestureDetector> listener;
    private final int[] mId;
    private final float[] startX;
    private final float[] startY;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/MultiPointerGestureDetector$Companion;", "", "()V", "MAX_POINTERS", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void reset() {
        int r0 = 0;
        this.isGestureInProgress = false;
        this.curPointerCount = 0;
        this.lastPointCount = 0;
    L4:
        if (r0 >= 2) goto L6;
        this.mId[r0] = -1;
        this.startX[r0] = 0.0f;
        this.startY[r0] = 0.0f;
        this.currentX[r0] = 0.0f;
        this.currentY[r0] = 0.0f;
        this.lastX[r0] = 0.0f;
        this.lastY[r0] = 0.0f;
        r0 = r0 + 1;
        goto L4
    }

    private final void startGesture() {
        this.isGestureInProgress = true;
        GestureListener<MultiPointerGestureDetector> r0 = this.listener;
        if (r0 == null) goto L6;
        r0.onGestureBegin(this);
        return;
    }

    private final void stopGesture() {
        GestureListener<MultiPointerGestureDetector> r0 = this.listener;
        if (r0 == null) goto L5;
        r0.onGestureEnd(this);
    L5:
        reset();
    }

    private final void updateGesture() {
        GestureListener<MultiPointerGestureDetector> r0 = this.listener;
        if (r0 == null) goto L6;
        r0.onGestureUpdate(this);
        return;
    }

    public MultiPointerGestureDetector() {
        this.mId = new int[2];
        this.startX = new float[2];
        this.startY = new float[2];
        this.currentX = new float[2];
        this.currentY = new float[2];
        this.lastX = new float[2];
        this.lastY = new float[2];
    }

    public final int getCurPointerCount() {
        return this.curPointerCount;
    }

    public final float[] getCurrentX() {
        return this.currentX;
    }

    public final float[] getCurrentY() {
        return this.currentY;
    }

    public final int getLastPointCount() {
        return this.lastPointCount;
    }

    public final float[] getLastX() {
        return this.lastX;
    }

    public final float[] getLastY() {
        return this.lastY;
    }

    public final GestureListener<MultiPointerGestureDetector> getListener() {
        return this.listener;
    }

    public final float[] getStartX() {
        return this.startX;
    }

    public final float[] getStartY() {
        return this.startY;
    }

    public final boolean isGestureInProgress() {
        return this.isGestureInProgress;
    }

    private final void updatePointersOnMove(MotionEvent r6) {
        this.lastPointCount = this.curPointerCount;
        int r0 = 0;
    L4:
        if (r0 >= 2) goto L9;
        int r1 = r6.findPointerIndex(this.mId[r0]);
        if (r1 == (-1)) goto L8;
        float[] r2 = this.lastX;
        float[] r3 = this.currentX;
        r2[r0] = r3[r0];
        this.lastY[r0] = this.currentY[r0];
        r3[r0] = r6.getX(r1);
        this.currentY[r0] = r6.getY(r1);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    private final void updatePointersOnTap(MotionEvent r5) {
        r5.getAction();
        this.lastPointCount = this.curPointerCount;
        int r0 = 0;
        this.curPointerCount = 0;
    L4:
        if (r0 >= 2) goto L10;
        int r1 = getPressedPointerIndex(r5, r0);
        if (r1 != (-1)) goto L8;
        this.mId[r0] = -1;
    L9:
        r0 = r0 + 1;
        goto L4
    L8:
        this.mId[r0] = r5.getPointerId(r1);
        this.lastX[r0] = r5.getX(r1);
        float[] r2 = this.startX;
        float r3 = this.lastX[r0];
        r2[r0] = r3;
        this.currentX[r0] = r3;
        this.lastY[r0] = r5.getY(r1);
        float[] r4 = this.startY;
        float r6 = this.lastY[r0];
        r4[r0] = r6;
        this.currentY[r0] = r6;
        this.curPointerCount++;
        goto L9
    }

    public final boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        int r0 = r4.getActionMasked();
        if (r0 == 0) goto L27;
        if (r0 != 1) goto L6;
        updatePointersOnTap(r4);
        if (this.curPointerCount != 0) goto L26;
        stopGesture();
    L28:
        return true;
    L26:
        updateGesture();
        goto L28
    L6:
        if (r0 != 2) goto L8;
        updatePointersOnMove(r4);
        GestureListener<MultiPointerGestureDetector> r5 = this.listener;
        if (r5 == null) goto L28;
        r5.onGestureUpdate(this);
        goto L28
    L8:
        if (r0 != 3) goto L10;
        stopGesture();
        goto L28
    L10:
        if (r0 != 5) goto L12;
        updatePointersOnTap(r4);
        updateGesture();
        goto L28
    L12:
        if (r0 != 6) goto L28;
        updatePointersOnTap(r4);
        if (this.curPointerCount != 0) goto L17;
        stopGesture();
        goto L28
    L17:
        updateGesture();
        goto L28
    L27:
        startGesture();
        updatePointersOnTap(r4);
        goto L28
    }

    public final void setListener(GestureListener<MultiPointerGestureDetector> r1) {
        this.listener = r1;
    }

    private final int getPressedPointerIndex(MotionEvent r4, int r5) {
        int r0 = r4.getPointerCount();
        int r1 = r4.getActionMasked();
        int r6 = r4.getActionIndex();
        if (r1 != 1) goto L5;
    L6:
        if (r5 < r6) goto L8;
        r5 = r5 + 1;
    L8:
        if (r5 < r0) goto L12;
        return -1;
    L12:
        return r5;
    L5:
        if (r1 != 6) goto L8;
        goto L6
    }
}
