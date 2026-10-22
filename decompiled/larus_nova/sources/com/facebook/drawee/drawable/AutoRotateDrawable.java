package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class AutoRotateDrawable extends ForwardingDrawable implements Runnable, CloneableDrawable {
    private static final int DEGREES_IN_FULL_ROTATION = 360;
    private static final int FRAME_INTERVAL_MS = 20;
    private boolean mClockwise;
    private int mInterval;
    private boolean mIsScheduled;
    float mRotationAngle;

    public void com_facebook_drawee_drawable_AutoRotateDrawable__run$___twin___() {
        this.mIsScheduled = false;
        this.mRotationAngle += getIncrement();
        invalidateSelf();
    }

    public void reset() {
        this.mRotationAngle = 0.0f;
        this.mIsScheduled = false;
        unscheduleSelf(this);
        invalidateSelf();
    }

    @Override // java.lang.Runnable
    public void run() {
        com_facebook_drawee_drawable_AutoRotateDrawable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    private int getIncrement() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }

    private void scheduleNextFrame() {
        if (this.mIsScheduled == true) goto L6;
        this.mIsScheduled = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        return;
    }

    @Override // com.facebook.drawee.drawable.CloneableDrawable
    public AutoRotateDrawable cloneDrawable() {
        return new AutoRotateDrawable(DrawableUtils.cloneDrawable(getDrawable()), this.mInterval, this.mClockwise);
    }

    @Override // com.facebook.drawee.drawable.CloneableDrawable
    public /* bridge */ /* synthetic */ Drawable cloneDrawable() {
        return cloneDrawable();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_facebook_drawee_drawable_AutoRotateDrawable_com_larus_apm_impl_protector_RunnableLancet_run(AutoRotateDrawable r100) {
        r100.com_facebook_drawee_drawable_AutoRotateDrawable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        int r101 = r100.save();
        Rect r102 = getBounds();
        int r103 = r102.right;
        int r104 = r102.left;
        int r105 = r103 - r104;
        int r106 = r102.bottom;
        int r107 = r102.top;
        int r108 = r106 - r107;
        float r109 = this.mRotationAngle;
        if (this.mClockwise == true) goto L5;
        r109 = 360.0f - r109;
    L5:
        r100.rotate(r109, r104 + (r105 / 2), r107 + (r108 / 2));
        super.draw(r100);
        r100.restoreToCount(r101);
        scheduleNextFrame();
    }

    public void setClockwise(boolean r100) {
        this.mClockwise = r100;
    }

    public AutoRotateDrawable(Drawable r100, int r101) {
        this(r100, r101, true);
    }

    public AutoRotateDrawable(Drawable r100, int r101, boolean r102) {
        super((Drawable) Preconditions.checkNotNull(r100));
        this.mRotationAngle = 0.0f;
        this.mIsScheduled = false;
        this.mInterval = r101;
        this.mClockwise = r102;
    }
}
