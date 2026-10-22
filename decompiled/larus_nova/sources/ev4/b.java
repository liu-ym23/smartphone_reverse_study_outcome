package ev4;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends Drawable implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f474248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f474249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f474250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f474251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f474252e;

    public static final class a {
    }

    /* JADX INFO: renamed from: ev4.b$b, reason: collision with other inner class name */
    public static final class C5823b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f474253a;

        public C5823b(b r100) {
            this.f474253a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            float r102 = ((Float) r101).floatValue();
            int r103 = 0;
        L4:
            if (r103 >= 3) goto L6;
            this.f474253a.f474251d[r103] = (((float) ((Math.sin(((double) (((r103 / 3.0f) + r102) % 1.0f)) * 6.283185307179586d) * 0.5d) + 0.5d)) * 0.8f) + 0.2f;
            r103 = r103 + 1;
            goto L4
        L6:
            this.f474253a.invalidateSelf();
        }
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) (2 * this.f474249b);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) ((6 * this.f474249b) + (2 * this.f474250c));
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator r100 = this.f474252e;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isRunning() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator r100 = this.f474252e;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r102.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r102.setRepeatCount(-1);
        r102.setInterpolator(new LinearInterpolator());
        r102.addUpdateListener(new C5823b(this));
        r102.start();
        this.f474252e = r102;
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator r100 = this.f474252e;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f474252e = null;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Paint r101 = new Paint(1);
        r101.setColor(ContextCompat.getColor(r100, R.color.icon_n3));
        this.f474248a = r101;
        this.f474249b = n.c(2.0f);
        this.f474250c = n.c(3.0f);
        float[] r102 = new float[3];
        int r103 = 0;
    L3:
        if (r103 >= 3) goto L5;
        r102[r103] = 0.2f;
        r103 = r103 + 1;
        goto L3
    L5:
        this.f474251d = r102;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = getBounds().exactCenterY();
        float r101 = (2 * this.f474249b) + this.f474250c;
        float r102 = getBounds().left + this.f474249b;
        int r103 = 0;
    L4:
        if (r103 >= 3) goto L6;
        this.f474248a.setAlpha(RangesKt.coerceIn((int) (this.f474251d[r103] * 255), 0, 255));
        r110.drawCircle(r102, r100, this.f474249b, this.f474248a);
        r102 = r102 + r101;
        r103 = r103 + 1;
        goto L4
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f474248a.setColorFilter(r100);
    }
}
