package yz3;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import c04.h;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends FrameLayout {
    public final int a;
    public final AoImageView b;
    public final AoImageView c;
    public final FrameLayout d;
    public final yz3.a e;
    public final b f;
    public final ValueAnimator g;
    public List<String> h;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r6) {
            if (r6 != null) goto L4;
            return;
        L4:
            float r0 = r6.getAnimatedFraction();
            if (r0 > 0.5f) goto L7;
            float r1 = 1.0f - ((r0 / 0.5f) * 0.08f);
        L8:
            this.a.d.setScaleX(r1);
            this.a.d.setScaleY(r1);
            Object r7 = r6.getAnimatedValue();
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Int");
            int r8 = ((Integer) r7).intValue();
            boolean r2 = false;
            if (r8 >= 0) goto L11;
        L13:
            if (r2 == false) goto L16;
            this.a.e.setFractionWithAlpha((r8 * 1.0f) / 640);
            return;
        L16:
            return;
        L11:
            if (r8 >= 641) goto L13;
            r2 = true;
            goto L13
        L7:
            r1 = (((r0 - 0.5f) / 0.5f) * 0.08f) + 0.92f;
            goto L8
        }
    }

    static {
    }

    public final List<String> getAvatarUrls() {
        return this.h;
    }

    public final ValueAnimator.AnimatorUpdateListener getListener() {
        return this.f;
    }

    public c(WeakReference<Context> r7) {
        Intrinsics.checkNotNullParameter(r7, "contextRef");
        new LinkedHashMap();
        Context r8 = r7.get();
        Intrinsics.checkNotNull(r8);
        super(r8);
        Resources r0 = Resources.getSystem();
        this.a = MathKt.roundToInt(TypedValue.applyDimension(1, 50, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics())));
        FrameLayout r9 = new FrameLayout(getContext());
        View r1 = new AoImageView(getContext());
        this.b = r1;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
        r2.gravity = 1;
        Unit r4 = Unit.INSTANCE;
        r9.addView(r1, r2);
        AoImageView r3 = new AoImageView(getContext());
        this.c = r3;
        r3.setScaleType(ImageView.ScaleType.FIT_XY);
        r3.setImageResource(2131231456);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.gravity = 1;
        r9.addView(r3, r5);
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 17;
        addView(r9, r6);
        this.d = r9;
        yz3.a r10 = new yz3.a(getContext());
        Resources r11 = Resources.getSystem();
        int r12 = MathKt.roundToInt(TypedValue.applyDimension(1, 3, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics())));
        r10.setPadding(r12, r12, r12, r12);
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 17;
        addView(r10, r13);
        this.e = r10;
        this.f = new b(this);
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{0, 800});
        r14.setRepeatCount(-1);
        r14.setRepeatMode(1);
        r14.setDuration(800);
        r14.addUpdateListener((ValueAnimator.AnimatorUpdateListener) h.a(this.f));
        this.g = r14;
        setClipChildren(false);
    }

    public final void setAvatarUrls(List<String> r6) {
        this.h = r6;
        AoImageView r0 = this.b;
        com.bytedance.awemeopen.infra.base.image.b r1 = new com.bytedance.awemeopen.infra.base.image.b(r6);
        r1.b(2131231483);
        r1.r = true;
        r1.m = ImageView.ScaleType.CENTER_CROP;
        Resources r3 = Resources.getSystem();
        r1.t = MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        r1.u = getContext().getResources().getColor(2131100362);
        r0.j(r1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r7, int r8) {
        int r0 = View.MeasureSpec.getMode(r7);
        int r1 = View.MeasureSpec.getMode(r8);
        int r2 = View.MeasureSpec.getSize(r7);
        int r3 = View.MeasureSpec.getSize(r8);
        if (r0 == Integer.MIN_VALUE) goto L7;
        if (r0 != 0) goto L8;
        r2 = this.a;
    L8:
        if (r1 == Integer.MIN_VALUE) goto L12;
        if (r1 != 0) goto L13;
        r3 = this.a;
    L13:
        int r4 = Math.min(r2 - (getPaddingLeft() + getPaddingRight()), r3 - (getPaddingTop() + getPaddingBottom()));
        ViewGroup.LayoutParams r5 = this.b.getLayoutParams();
        double r6 = r4;
        int r9 = (int) (0.78d * r6);
        r5.width = r9;
        r5.height = r9;
        ViewGroup.LayoutParams r10 = this.c.getLayoutParams();
        r10.width = (int) (0.62d * r6);
        r10.height = (int) (r6 * 0.26d);
        ViewGroup.LayoutParams r11 = this.e.getLayoutParams();
        r11.width = r4;
        r11.height = r4;
        super.onMeasure(r7, r8);
        return;
    L12:
        r3 = Math.min(r3, this.a);
        goto L13
    L7:
        r2 = Math.min(r2, this.a);
        goto L8
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 != 0) goto L5;
        this.g.start();
        return;
    L5:
        this.g.pause();
    }
}
