package fqa;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends c implements Animatable, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f478470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f478471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f478472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ValueAnimator f478473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f478474f;

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f478473e.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        if (this.f478473e.isRunning() == true) goto L6;
        this.f478473e.addUpdateListener(this);
        this.f478473e.start();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        if (this.f478473e.isRunning() == false) goto L6;
        this.f478473e.removeAllListeners();
        this.f478473e.removeAllUpdateListeners();
        this.f478473e.cancel();
        return;
    }

    public d() {
        this.f478470b = 0;
        this.f478471c = 0;
        this.f478472d = 0;
        this.f478474f = new Path();
        ValueAnimator r100 = ValueAnimator.ofInt(new int[]{30, AnnouncementViewModel.HOUR_DURATION});
        this.f478473e = r100;
        r100.setDuration(10000);
        r100.setInterpolator(null);
        r100.setRepeatCount(-1);
        r100.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Rect r100 = getBounds();
        int r101 = r100.width();
        int r102 = r100.height();
        float r103 = r101;
        float r104 = Math.max(1.0f, r103 / 22.0f);
        if (this.f478470b == r101) goto L5;
    L6:
        this.f478474f.reset();
        float r105 = r103 - r104;
        float r111 = r102 / 2.0f;
        this.f478474f.addCircle(r105, r111, r104, Path.Direction.CW);
        float r106 = r103 - (5.0f * r104);
        this.f478474f.addRect(r106, r111 - r104, r105, r111 + r104, Path.Direction.CW);
        this.f478474f.addCircle(r106, r111, r104, Path.Direction.CW);
        this.f478470b = r101;
        this.f478471c = r102;
    L7:
        r110.save();
        float r107 = r103 / 2.0f;
        float r108 = r102 / 2.0f;
        r110.rotate(this.f478472d, r107, r108);
        int r109 = 0;
    L9:
        if (r109 >= 12) goto L11;
        this.f478469a.setAlpha((r109 + 5) * 17);
        r110.rotate(30.0f, r107, r108);
        r110.drawPath(this.f478474f, this.f478469a);
        r109 = r109 + 1;
        goto L9
    L11:
        r110.restore();
        return;
    L5:
        if (this.f478471c == r102) goto L7;
        goto L6
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        this.f478472d = (((Integer) r100.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }
}
