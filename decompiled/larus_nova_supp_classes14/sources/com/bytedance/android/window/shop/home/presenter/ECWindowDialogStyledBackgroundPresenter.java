package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowDialogStyledBackgroundPresenter extends AbsECWindowPresenter {
    public static final Pair<Integer, Integer> A = null;
    public static final Pair<IntRange, Pair<Integer, Integer>>[] z = null;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final float[][] w;
    public final float x;
    public final CompositeDisposable y;

    public static final class a {
    }

    public static final class b extends BasePostprocessor {
        public final float a;
        public final float b;
        public final Function1<int[], Unit> c;

        public final CloseableReference<Bitmap> process(Bitmap r12, PlatformBitmapFactory r13) {
            if (r12 == null) goto L4;
            if (r13 == null) goto L7;
            int r4 = (int) (this.a * r12.getHeight());
            CloseableReference r0 = r13.createBitmap(r12, 0, r4, r12.getWidth(), ((int) (this.b * r12.getHeight())) - r4);
            Function1<int[], Unit> r1 = this.c;
            if (r1 == null) goto L11;
            Bitmap r3 = (Bitmap) r0.get();
            int[] r2 = new int[r3.getWidth()];
            r3.getPixels(r2, 0, r3.getWidth(), 0, r3.getHeight() - 1, r3.getWidth(), 1);
            r1.invoke(r2);
        L11:
            CloseableReference<Bitmap> r5 = CloseableReference.cloneOrNull(r0);
            if (r5 == null) goto L14;
            return r5;
        L14:
            return super.process(r12, r13);
        L7:
            return super.process(r12, null);
        L4:
            return super.process(r12, r13);
        }

        public b(float r1, float r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter a;

        public c(ECWindowDialogStyledBackgroundPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r12) {
            uq3.a r13 = (uq3.a) r12;
            ECWindowDialogStyledBackgroundPresenter r0 = this.a;
            uq3.o r1 = r13.c;
            ECUrlModel r2 = null;
            if (r1 == null) goto L5;
            String r3 = r1.i;
        L6:
            r0.getClass();
            ECWindowDialogStyledBackgroundPresenter.a0(r0, ECWindowDialogStyledBackgroundPresenter.b0(r3), null);
            uq3.o r4 = r13.c;
            if (r4 == null) goto L9;
            ECUrlModel r5 = r4.g;
        L10:
            boolean r6 = false;
            if (r5 == null) goto L38;
            ECWindowDialogStyledBackgroundPresenter r7 = this.a;
            r7.getClass();
            int r8 = (int) (com.bytedance.android.ec.window.base.utils.c.a * 0.5612789f);
            if ((r8 - r7.i0().getHeight()) <= 0) goto L15;
            int r9 = r8 - r7.i0().getHeight();
        L16:
            wg.a.d(r7.c0(), r9);
            ((View) r7.s.getValue()).setVisibility(0);
            ((View) r7.t.getValue()).setVisibility(0);
            r7.h0().setVisibility(0);
            ECWindowDialogStyledBackgroundPresenter r10 = this.a;
            uq3.o r11 = r13.c;
            r10.getClass();
            if (r11 == null) goto L19;
            ECUrlModel r14 = r11.g;
        L20:
            if (r14 == null) goto L24;
            Integer r15 = r11.h;
            if (r15 == null) goto L24;
            int r16 = r15.intValue();
            View r17 = r10.w().b(2131370848).f();
            r17.setBackgroundColor(r16);
            r17.setVisibility(0);
        L24:
            ECWindowDialogStyledBackgroundPresenter r18 = this.a;
            uq3.o r19 = r13.c;
            if (r19 == null) goto L27;
            Integer r20 = r19.h;
        L28:
            r18.getClass();
            if (r20 == null) goto L31;
            r20.intValue();
            ((View) r18.s.getValue()).setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(138, Color.red(r20.intValue()), Color.green(r20.intValue()), Color.blue(r20.intValue())), r20.intValue()}));
            ((View) r18.t.getValue()).setBackgroundColor(r20.intValue());
        L31:
            ECWindowDialogStyledBackgroundPresenter r21 = this.a;
            uq3.o r22 = r13.c;
            if (r22 == null) goto L34;
            Integer r23 = r22.h;
        L35:
            r21.getClass();
            if (r23 == null) goto L38;
            r23.intValue();
            r21.h0().setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(71, Color.red(r23.intValue()), Color.green(r23.intValue()), Color.blue(r23.intValue())), Color.argb(138, Color.red(r23.intValue()), Color.green(r23.intValue()), Color.blue(r23.intValue()))}));
            goto L38
        L34:
            r23 = null;
            goto L35
        L27:
            r20 = null;
            goto L28
        L19:
            r14 = null;
            goto L20
        L15:
            r9 = 0;
        L38:
            ECWindowDialogStyledBackgroundPresenter r24 = this.a;
            uq3.o r110 = r13.c;
            if (r110 == null) goto L41;
            r2 = r110.g;
        L41:
            if (r2 == null) goto L43;
            r6 = true;
        L43:
            r24.O().getTopBarHeight().a(r24.U(), new o0(r24, r6), true);
            return;
        L9:
            r5 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter a;

        public d(ECWindowDialogStyledBackgroundPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Float r5 = (Float) r4;
            this.a.f0().setTranslationY((-this.a.d0().getHeight()) * r5.floatValue());
            this.a.h0().setTranslationY((-this.a.d0().getHeight()) * r5.floatValue());
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter a;

        public e(ECWindowDialogStyledBackgroundPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Float r7 = (Float) r6;
            ECWindowDialogStyledBackgroundPresenter r0 = this.a;
            float[] r1 = r0.e0(r7.floatValue());
            Drawable r2 = ((View) r0.r.getValue()).getBackground();
            Drawable r4 = null;
            if ((r2 instanceof GradientDrawable) == true) goto L5;
            r2 = null;
        L5:
            GradientDrawable r3 = (GradientDrawable) r2;
            if (r3 == null) goto L8;
            r3.setCornerRadii(r1);
            r3.invalidateSelf();
        L8:
            RoundingParams r5 = r0.c0().getHierarchy().getRoundingParams();
            if (r5 != null) goto L11;
            r5 = new RoundingParams();
        L11:
            r5.setCornersRadii(r1);
            r0.c0().getHierarchy().setRoundingParams(r5);
            Drawable r8 = ((View) r0.s.getValue()).getBackground();
            if ((r8 instanceof GradientDrawable) == false) goto L15;
            r4 = r8;
        L15:
            GradientDrawable r9 = (GradientDrawable) r4;
            if (r9 == null) goto L18;
            r9.setCornerRadii(r1);
        L18:
            this.a.f0().setAlpha(r7.floatValue());
            this.a.h0().setAlpha(r7.floatValue());
            this.a.i0().setAlpha(r7.floatValue());
            ((View) this.a.v.getValue()).setAlpha(1 - r7.floatValue());
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ SimpleDraweeView a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ Function1 d;

        public f(ECWindowDialogStyledBackgroundPresenter r1, SimpleDraweeView r2, float r3, float r4, Function1 r5) {
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final void onChanged(Object r7) {
            uq3.o r8 = ((uq3.a) r7).c;
            if (r8 == null) goto L9;
            ECUrlModel r9 = r8.g;
            if (r9 == null) goto L9;
            String r10 = r9.getFirstUrl();
            if (r10 == null) goto L9;
            this.a.setImageRequest(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r10)).setPostprocessor(new b(this.b, this.c, this.d)).build());
            return;
        L9:
            SimpleDraweeView r11 = this.a;
            ImageRequestBuilder r0 = ImageRequestBuilder.newBuilderWithResourceId(2131234882);
            float r2 = this.b;
            float r3 = this.c;
            Function1 r4 = this.d;
            com.bytedance.android.ec.core.utils.q.a(475);
            int r5 = com.bytedance.android.ec.window.base.utils.c.a;
            r11.setImageRequest(r0.setPostprocessor(new b(r2, r3, r4)).build());
        }
    }

    public final SimpleDraweeView c0() {
        return (SimpleDraweeView) this.u.getValue();
    }

    public final FrameLayout d0() {
        return (FrameLayout) this.p.getValue();
    }

    public final SimpleDraweeView f0() {
        return (SimpleDraweeView) this.n.getValue();
    }

    public final View h0() {
        return (View) this.o.getValue();
    }

    public final View i0() {
        return (View) this.m.getValue();
    }

    static {
        z = new Pair[]{new Pair(new IntRange(0, 60), new Pair(Integer.valueOf((int) 4284500019L), Integer.valueOf((int) 4283905836L))), new Pair(new IntRange(61, 180), new Pair(Integer.valueOf((int) 4282206261L), Integer.valueOf((int) 4281220147L))), new Pair(new IntRange(181, 240), new Pair(Integer.valueOf((int) 4280828262L), Integer.valueOf((int) 4280627288L))), new Pair(new IntRange(241, 300), new Pair(Integer.valueOf((int) 4280952390L), Integer.valueOf((int) 4281873241L))), new Pair(new IntRange(301, 360), new Pair(Integer.valueOf((int) 4284427067L), Integer.valueOf((int) 4282851108L)))};
        int r2 = (int) 4284374622L;
        A = new Pair(Integer.valueOf(r2), Integer.valueOf(r2));
    }

    public final void C() {
        this.y.clear();
    }

    public ECWindowDialogStyledBackgroundPresenter() {
        this.m = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$topBarView$2(this));
        this.n = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$topBarBackgroundImageView$2(this));
        this.o = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$topBarBackgroundMask$2(this));
        this.p = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaView$2(this));
        this.q = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaBgView$2(this));
        this.r = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaBackgroundImageView$2(this));
        this.s = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaBackgroundImageViewMask$2(this));
        this.t = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaBackgroundSecondPart$2(this));
        this.u = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$infoAreaBackgroundShaderImageView$2(this));
        this.v = LazyKt.lazy(new ECWindowDialogStyledBackgroundPresenter$dragIndicatorView$2(this));
        this.w = new float[101][];
        this.x = com.bytedance.android.ec.core.utils.q.a(12);
        this.y = new CompositeDisposable();
    }

    public static Pair b0(String r5) {
        int r0 = 0;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        float[] r3 = new float[3];
        Integer r6 = com.bytedance.android.ec.core.utils.s.b(r5);
        if (r6 == null) goto L33;
        Color.colorToHSV(r6.intValue(), r3);
        int r7 = (int) r3[0];
        float r1 = r3[1];
        float r4 = r3[2];
        float r8 = 100;
        float r9 = 10;
        if ((r1 * r8) <= r9) goto L31;
        if ((r4 * r8) <= r9) goto L31;
        Pair<IntRange, Pair<Integer, Integer>>[] r10 = z;
        int r11 = r10.length;
    L20:
        if (r0 >= r11) goto L25;
        Pair<IntRange, Pair<Integer, Integer>> r12 = r10[r0];
        if (((IntRange) r12.component1()).contains(r7) == true) goto L26;
        r0 = r0 + 1;
    L26:
        if (r12 == null) goto L37;
        Pair r13 = (Pair) r12.getSecond();
        if (r13 == null) goto L37;
        return r13;
    L37:
        return A;
    L25:
        r12 = null;
    L31:
        return A;
    L33:
        return A;
    L11:
        return A;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r2 = false;
        goto L9
    }

    public final void A(QModel r8) {
        if (com.bytedance.android.ec.window.base.utils.c.a(d0(), new ECWindowDialogStyledBackgroundPresenter$attachIndicatorView$1(this)) != null) goto L6;
        FrameLayout r9 = d0();
        View r2 = (View) this.v.getValue();
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(32), com.bytedance.android.shopping.extensions.b.b(4));
        r3.gravity = 1;
        r3.setMargins(0, com.bytedance.android.shopping.extensions.b.b(6), 0, 0);
        Unit r4 = Unit.INSTANCE;
        r9.addView(r2, r3);
    L6:
        FrameLayout r10 = (FrameLayout) w().b(2131370845).f();
        if (com.bytedance.android.ec.window.base.utils.c.a(r10, new ECWindowDialogStyledBackgroundPresenter$attachTopBarBackgroundView$1(this)) != null) goto L11;
        r10.addView(f0());
        View r5 = h0();
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -1);
        r6.gravity = 80;
        Unit r7 = Unit.INSTANCE;
        r10.addView(r5, -1, r6);
    L11:
        if (com.bytedance.android.ec.window.base.utils.c.a((FrameLayout) this.q.getValue(), new ECWindowDialogStyledBackgroundPresenter$attachInfoAreaBackgroundView$1(this)) != null) goto L14;
        ((FrameLayout) this.q.getValue()).addView((View) this.s.getValue(), 0, new ViewGroup.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(130)));
        FrameLayout r11 = (FrameLayout) this.q.getValue();
        View r12 = (View) this.t.getValue();
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-1, -1);
        r13.setMargins(0, com.bytedance.android.shopping.extensions.b.b(130), 0, 0);
        Unit r14 = Unit.INSTANCE;
        r11.addView(r12, 0, r13);
        ((FrameLayout) this.q.getValue()).addView(c0(), 0, new ViewGroup.LayoutParams(-1, -1));
        ((FrameLayout) this.q.getValue()).addView((View) this.r.getValue(), 0, new ViewGroup.LayoutParams(-1, -1));
    L14:
        O().getHeaderResponse().a(U(), new c(this), true);
        O().getSubCollapseProgress().observe(U(), new d(this));
        O().getCollapseProgress().observe(U(), new e(this));
        zn.b<uq3.a> r15 = O().getHeaderResponse();
        Intrinsics.checkNotNullParameter(r15, "source");
        Disposable r16 = Observable.zip(new AbsECWindowPresenter$observableSourceFromLiveData$1(this, r15), new k0(this), new l0(this)).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m0(this), n0.a);
        this.y.add(r16);
    }

    public final synchronized float[] e0(float r4) {
        monitor-enter(this);
        int r0 = 0;
        if (r4 > 0) goto L7;
    L20:
        float[] r1 = this.w[r0];     // Catch: Throwable -> L17
        if (r1 == null) goto L14;
        monitor-exit(this);
        return r1;
    L14:
        float r2 = this.x * (1 - r4);     // Catch: Throwable -> L17
        float[] r5 = com.bytedance.android.ec.window.base.utils.c.b(r2, r2, 0.0f, 0.0f);     // Catch: Throwable -> L17
        this.w[r0] = r5;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r5;
    L17:
        th = move-exception;
        throw th;
    L7:
        if (r4 < 1) goto L9;
        r0 = 100;
        goto L20
    L9:
        r0 = (int) (100 * r4);
        goto L20
    }

    public static final void Z(ECWindowDialogStyledBackgroundPresenter r4, final io.reactivex.Observer r5) {
        View r0 = r4.i0();
        Integer r1 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(88));
        int r2 = r0.getHeight();
        if (r2 > 0) goto L8;
        if (r1 != null) goto L7;
        r2 = 0;
        goto L8
    L7:
        r2 = r1.intValue();
    L8:
        float r3 = r2 / (com.bytedance.android.shopping.extensions.b.b(145) + r2);
        r4.j0(r4.f0(), 0.0f, r3, null);
        r4.j0(r4.c0(), r3, 1.0f, new ECWindowDialogStyledBackgroundPresenter$executeRenderCutBackground$1(r5));
    }

    public static final void a0(ECWindowDialogStyledBackgroundPresenter r6, Pair r7, Bitmap r8) {
        float r0 = r6.i0().getHeight() / (r6.i0().getHeight() + r6.d0().getHeight());
        int r1 = ((Number) r7.getFirst()).intValue();
        int r9 = ((Number) r7.getSecond()).intValue();
        int r2 = ColorUtils.blendARGB(r1, r9, r0);
        int[][] r3 = {new int[]{r1, r2}, new int[]{r2, r9}};
        GenericDraweeHierarchy r10 = r6.f0().getHierarchy();
        GradientDrawable r4 = new GradientDrawable();
        com.bytedance.android.ec.window.base.utils.c.e(r4, (int[]) r3[0].clone());
        Unit r5 = Unit.INSTANCE;
        r10.setBackgroundImage(r4);
        View r11 = (View) r6.r.getValue();
        GradientDrawable r12 = new GradientDrawable();
        com.bytedance.android.ec.window.base.utils.c.e(r12, (int[]) r3[1].clone());
        r12.setCornerRadii(r6.e0(0.0f));
        com.bytedance.android.ec.window.base.utils.c.d(r11, r12);
        if (r8 == null) goto L5;
        r6.O().getHeaderResponse().a(r6.U(), new p0(r6, r8), true);
        return;
    L5:
        r6.O().getHeaderResponse().a(r6.U(), new q0(r6, r3), true);
    }

    public final void j0(SimpleDraweeView r10, float r11, float r12, Function1<? super int[], Unit> r13) {
        O().getHeaderResponse().a(U(), new f(this, r10, r11, r12, r13), false);
    }
}
