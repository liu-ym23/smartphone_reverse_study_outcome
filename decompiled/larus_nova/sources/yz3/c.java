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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f569531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AoImageView f569532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AoImageView f569533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f569534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final yz3.a f569535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f569536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ValueAnimator f569537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f569538h;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f569539a;

        public b(c r100) {
            this.f569539a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            float r101 = r100.getAnimatedFraction();
            if (r101 > 0.5f) goto L7;
            float r102 = 1.0f - ((r101 / 0.5f) * 0.08f);
        L8:
            this.f569539a.f569534d.setScaleX(r102);
            this.f569539a.f569534d.setScaleY(r102);
            Object r103 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Int");
            int r104 = ((Integer) r103).intValue();
            boolean r105 = false;
            if (r104 >= 0) goto L11;
        L13:
            if (r105 == false) goto L16;
            this.f569539a.f569535e.setFractionWithAlpha((r104 * 1.0f) / 640);
            return;
        L16:
            return;
        L11:
            if (r104 >= 641) goto L13;
            r105 = true;
            goto L13
        L7:
            r102 = (((r101 - 0.5f) / 0.5f) * 0.08f) + 0.92f;
            goto L8
        }
    }

    static {
    }

    public final List<String> getAvatarUrls() {
        return this.f569538h;
    }

    public final ValueAnimator.AnimatorUpdateListener getListener() {
        return this.f569536f;
    }

    public c(WeakReference<Context> r100) {
        Intrinsics.checkNotNullParameter(r100, "contextRef");
        new LinkedHashMap();
        Context r101 = r100.get();
        Intrinsics.checkNotNull(r101);
        super(r101);
        Resources r102 = Resources.getSystem();
        this.f569531a = MathKt.roundToInt(TypedValue.applyDimension(1, 50, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
        FrameLayout r103 = new FrameLayout(getContext());
        AoImageView r104 = new AoImageView(getContext());
        this.f569532b = r104;
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 1;
        Unit r106 = Unit.INSTANCE;
        r103.addView(r104, r105);
        AoImageView r107 = new AoImageView(getContext());
        this.f569533c = r107;
        r107.setScaleType(ImageView.ScaleType.FIT_XY);
        r107.setImageResource(R.drawable.aos_feed_ic_avatar_live);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-2, -2);
        r108.gravity = 1;
        r103.addView(r107, r108);
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-2, -2);
        r109.gravity = 17;
        addView(r103, r109);
        this.f569534d = r103;
        yz3.a r110 = new yz3.a(getContext());
        Resources r111 = Resources.getSystem();
        int r112 = MathKt.roundToInt(TypedValue.applyDimension(1, 3, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics())));
        r110.setPadding(r112, r112, r112, r112);
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(-2, -2);
        r113.gravity = 17;
        addView(r110, r113);
        this.f569535e = r110;
        this.f569536f = new b(this);
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{0, 800});
        r114.setRepeatCount(-1);
        r114.setRepeatMode(1);
        r114.setDuration(800);
        r114.addUpdateListener((ValueAnimator.AnimatorUpdateListener) h.a(this.f569536f));
        this.f569537g = r114;
        setClipChildren(false);
    }

    public final void setAvatarUrls(List<String> r100) {
        this.f569538h = r100;
        AoImageView r101 = this.f569532b;
        com.bytedance.awemeopen.infra.base.image.b r102 = new com.bytedance.awemeopen.infra.base.image.b(r100);
        r102.b(R.drawable.aos_ic_img_signin_defaultavatar);
        r102.f198637r = true;
        r102.f198632m = ImageView.ScaleType.CENTER_CROP;
        Resources r103 = Resources.getSystem();
        r102.f198639t = MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        r102.f198640u = getContext().getResources().getColor(R.color.aos_white);
        r101.j(r102);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getSize(r101);
        if (r102 == Integer.MIN_VALUE) goto L7;
        if (r102 != 0) goto L8;
        r104 = this.f569531a;
    L8:
        if (r103 == Integer.MIN_VALUE) goto L12;
        if (r103 != 0) goto L13;
        r105 = this.f569531a;
    L13:
        int r106 = Math.min(r104 - (getPaddingLeft() + getPaddingRight()), r105 - (getPaddingTop() + getPaddingBottom()));
        ViewGroup.LayoutParams r107 = this.f569532b.getLayoutParams();
        double r108 = r106;
        int r109 = (int) (0.78d * r108);
        r107.width = r109;
        r107.height = r109;
        ViewGroup.LayoutParams r110 = this.f569533c.getLayoutParams();
        r110.width = (int) (0.62d * r108);
        r110.height = (int) (r108 * 0.26d);
        ViewGroup.LayoutParams r111 = this.f569535e.getLayoutParams();
        r111.width = r106;
        r111.height = r106;
        super.onMeasure(r100, r101);
        return;
    L12:
        r105 = Math.min(r105, this.f569531a);
        goto L13
    L7:
        r104 = Math.min(r104, this.f569531a);
        goto L8
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (r101 != 0) goto L5;
        this.f569537g.start();
        return;
    L5:
        this.f569537g.pause();
    }
}
