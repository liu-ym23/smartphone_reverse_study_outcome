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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends Drawable implements Animatable {
    public final Paint a;
    public final float b;
    public final float c;
    public final float[] d;
    public ValueAnimator e;

    public static final class a {
    }

    /* JADX INFO: renamed from: ev4.b$b, reason: collision with other inner class name */
    public static final class C0221b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ b a;

        public C0221b(b r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r6) {
            Intrinsics.checkNotNullParameter(r6, "it");
            Object r7 = r6.getAnimatedValue();
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Float");
            float r8 = ((Float) r7).floatValue();
            int r0 = 0;
        L4:
            if (r0 >= 3) goto L6;
            this.a.d[r0] = (((float) ((Math.sin(((double) (((r0 / 3.0f) + r8) % 1.0f)) * 6.283185307179586d) * 0.5d) + 0.5d)) * 0.8f) + 0.2f;
            r0 = r0 + 1;
            goto L4
        L6:
            this.a.invalidateSelf();
        }
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) (2 * this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) ((6 * this.b) + (2 * this.c));
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator r0 = this.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isRunning() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r2.setDuration(1200);
        r2.setRepeatCount(-1);
        r2.setInterpolator(new LinearInterpolator());
        r2.addUpdateListener(new C0221b(this));
        r2.start();
        this.e = r2;
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator r0 = this.e;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.e = null;
    }

    public b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Paint r0 = new Paint(1);
        r0.setColor(ContextCompat.getColor(r4, 2131102420));
        this.a = r0;
        this.b = n.c(2.0f);
        this.c = n.c(3.0f);
        float[] r1 = new float[3];
        int r2 = 0;
    L3:
        if (r2 >= 3) goto L5;
        r1[r2] = 0.2f;
        r2 = r2 + 1;
        goto L3
    L5:
        this.d = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        float r0 = getBounds().exactCenterY();
        float r1 = (2 * this.b) + this.c;
        float r2 = getBounds().left + this.b;
        int r4 = 0;
    L4:
        if (r4 >= 3) goto L6;
        this.a.setAlpha(RangesKt.coerceIn((int) (this.d[r4] * 255), 0, 255));
        r10.drawCircle(r2, r0, this.b, this.a);
        r2 = r2 + r1;
        r4 = r4 + 1;
        goto L4
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
    }
}
