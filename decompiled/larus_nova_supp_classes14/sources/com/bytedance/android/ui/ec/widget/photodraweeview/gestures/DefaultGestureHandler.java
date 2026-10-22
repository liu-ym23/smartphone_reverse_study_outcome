package com.bytedance.android.ui.ec.widget.photodraweeview.gestures;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.android.ui.ec.widget.photodraweeview.ScaleFactorRetriever;
import com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableControllerImp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/DefaultGestureHandler;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "zoomableControllerImp", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ZoomableControllerImp;", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/ZoomableControllerImp;)V", "doubleTapViewPoint", "Landroid/graphics/PointF;", "isDoubleClickScaleEnabled", "", "()Z", "setDoubleClickScaleEnabled", "(Z)V", "scaleFactorRetriever", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;", "getScaleFactorRetriever", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;", "setScaleFactorRetriever", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;)V", "onDoubleTapEvent", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onSingleTapConfirmed", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DefaultGestureHandler extends GestureDetector.SimpleOnGestureListener {
    private final PointF doubleTapViewPoint;
    private boolean isDoubleClickScaleEnabled;
    private ScaleFactorRetriever scaleFactorRetriever;
    private final ZoomableControllerImp zoomableControllerImp;

    public final ScaleFactorRetriever getScaleFactorRetriever() {
        return this.scaleFactorRetriever;
    }

    public final boolean isDoubleClickScaleEnabled() {
        return this.isDoubleClickScaleEnabled;
    }

    public DefaultGestureHandler(ZoomableControllerImp r2) {
        Intrinsics.checkNotNullParameter(r2, "zoomableControllerImp");
        this.zoomableControllerImp = r2;
        this.doubleTapViewPoint = new PointF();
        this.isDoubleClickScaleEnabled = true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "e");
        if (this.isDoubleClickScaleEnabled == true) goto L5;
        return false;
    L5:
        ScaleFactorRetriever r0 = this.scaleFactorRetriever;
        if (r0 != null) goto L8;
        return false;
    L8:
        ZoomableControllerImp r1 = this.zoomableControllerImp;
        PointF r2 = new PointF(r6.getX(), r6.getY());
        int r7 = r6.getActionMasked();
        if (r7 == 0) goto L13;
        if (r7 != 1) goto L14;
        r1.zoomToPoint(r0.nextFactor(r1.getScaleFactor()), r2, null, null);
    L14:
        return true;
    L13:
        this.doubleTapViewPoint.set(r2);
        goto L14
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        super.onLongPress(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        return super.onSingleTapConfirmed(r2);
    }

    public final void setDoubleClickScaleEnabled(boolean r1) {
        this.isDoubleClickScaleEnabled = r1;
    }

    public final void setScaleFactorRetriever(ScaleFactorRetriever r1) {
        this.scaleFactorRetriever = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
        Intrinsics.checkNotNullParameter(r3, "e2");
        ZoomableControllerImp r6 = this.zoomableControllerImp;
        if (r6.getScaleFactor() <= r6.getMinScaleFactor()) goto L7;
        r6.fling((int) r4, (int) r5);
        return false;
    L7:
        return false;
    }
}
