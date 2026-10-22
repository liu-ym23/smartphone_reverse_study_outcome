package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.model.message.x0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes47.dex */
public class c extends y81.b {
    public static final /* synthetic */ int M = 0;
    public TextSwitcher A;
    public TextSwitcher B;
    public TextSwitcher C;
    public TextSwitcher D;
    public TextSwitcher E;
    public TextSwitcher F;
    public TextView G;
    public TextSwitcher H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public List<TextSwitcher> f566673J;
    public Disposable K;
    public final CompositeDisposable L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f566674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f566675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f566676l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f566677m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f566678n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f566679o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f566680p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f566681q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewGroup f566682r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewGroup f566683s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public HSImageView f566684t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RelativeLayout f566685u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f566686v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LottieAnimationView f566687w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ValueAnimator f566688x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ValueAnimator f566689y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ValueAnimator f566690z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f566691a;

        public b(c r100) {
            this.f566691a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            c r101 = (c) r100;
            List<TextSwitcher> r102 = this.f566691a.f566673J;
            if (r102 == null) goto L18;
            Iterator<T> r103 = r102.iterator();
        L6:
            if (r103.hasNext() == false) goto L18;
            TextSwitcher r104 = (TextSwitcher) r103.next();
            if (r104 == null) goto L10;
            View r105 = r104.getCurrentView();
        L12:
            if ((r105 instanceof TextView) == false) goto L6;
            View r106 = r104.getCurrentView();
            if (r106 == null) goto L17;
            ((TextView) r106).setTextColor(s1.h(R.color.ttlive_dou_plus_end_data_color));
            goto L6
        L17:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        L10:
            r105 = null;
        L18:
            TextView r107 = this.f566691a.G;
            if (r107 == null) goto L28;
            r107.setTextColor(s1.h(R.color.ttlive_start_live_select_yellow));
            return;
        }
    }

    /* JADX INFO: renamed from: y81.c$c, reason: collision with other inner class name */
    public static final class C8311c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f566692a;

        public C8311c(c r100) {
            this.f566692a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            c r101 = (c) r100;
            c r102 = this.f566692a;
            if (r102.f566676l != 2) goto L22;
            ViewGroup r103 = r102.f566683s;
            if (r103 != null) goto L7;
        L11:
            TextSwitcher r104 = this.f566692a.H;
            if (r104 != null) goto L14;
        L18:
            TextSwitcher r105 = this.f566692a.H;
            if (r105 == null) goto L23;
            r105.setCurrentText(s1.B(R.string.ttlive_dou_plus_indicator_off));
            return;
        L23:
            return;
        L14:
            if (r104.getVisibility() != 8) goto L18;
            TextSwitcher r106 = this.f566692a.H;
            if (r106 == null) goto L18;
            r106.setVisibility(0);
            goto L18
        L7:
            if (r103.getVisibility() != 0) goto L11;
            ViewGroup r107 = this.f566692a.f566683s;
            if (r107 == null) goto L11;
            r107.setVisibility(8);
            goto L11
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f566693a;

        public d(c r100) {
            this.f566693a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            c r101 = (c) r100;
            c r102 = this.f566693a;
            if (r102.f566676l == 2) goto L5;
        L35:
            this.f566693a.i(0);
            return;
        L5:
            if (r102.f566665c == false) goto L35;
            if (r102.f566669g.getVisibility() != 0) goto L35;
            c r103 = this.f566693a;
            ValueAnimator r104 = r103.f566688x;
            if (r104 == null) goto L11;
            r104.cancel();
        L11:
            ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            r103.f566688x = r105;
            if (r105 == null) goto L14;
            r105.addListener(new y81.d(r103));
            r105.addUpdateListener(new y81.e(r105, r103));
            r105.setStartDelay(200);
            r105.setDuration(500);
        L14:
            ValueAnimator r106 = r103.f566688x;
            if (r106 == null) goto L17;
            r106.start();
        L17:
            ValueAnimator r107 = r103.f566690z;
            if (r107 == null) goto L20;
            r107.cancel();
        L20:
            ValueAnimator r108 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#80000000")), Integer.valueOf(ColorProtector.parseColor("#26000000"))});
            r103.f566690z = r108;
            if (r108 == null) goto L23;
            r108.addListener(new y81.f(r103));
            r108.addUpdateListener(new y81.g(r108, r103));
            r108.setStartDelay(200);
            r108.setDuration(300);
        L23:
            ValueAnimator r109 = r103.f566690z;
            if (r109 == null) goto L26;
            r109.start();
        L26:
            ValueAnimator r110 = r103.f566689y;
            if (r110 == null) goto L29;
            r110.cancel();
        L29:
            ValueAnimator r111 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            r103.f566689y = r111;
            if (r111 == null) goto L32;
            r111.addListener(new y81.h(r103));
            r111.addUpdateListener(new y81.i(r111, r103));
            r111.setDuration(200);
        L32:
            ValueAnimator r112 = r103.f566689y;
            if (r112 == null) goto L37;
            r112.start();
            return;
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f566694a;

        public e(c r100) {
            this.f566694a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ViewGroup r101 = this.f566694a.f566681q;
            if (r101 == null) goto L6;
            ViewGroup.LayoutParams r102 = r101.getLayoutParams();
            r102.width = (int) UtilityKotlinExtentionsKt.h(52);
            r101.setLayoutParams(r102);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ViewGroup r102 = this.f566694a.f566681q;
            if (r102 == null) goto L5;
            r102.setVisibility(0);
        L5:
            this.f566694a.j();
            c r103 = this.f566694a;
            if (r103.f566676l != 1) goto L12;
            TextSwitcher r104 = r103.H;
            if (r104 == null) goto L10;
            r104.setCurrentText(s1.B(R.string.ttlive_dou_plus_indicator_on));
        L10:
            c r105 = this.f566694a;
            r105.r(r105.f566682r, 0.0f);
            c r106 = this.f566694a;
            c.k(r106, r106.f566681q, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
            return;
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f566695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f566696b;

        public f(ValueAnimator r100, c r101) {
            this.f566695a = r100;
            this.f566696b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
            Object r101 = this.f566695a.getAnimatedValue();
            if (r101 == null) goto L9;
            float r102 = ((Float) r101).floatValue();
            ViewGroup r103 = this.f566696b.f566681q;
            if (r103 == null) goto L10;
            ViewGroup.LayoutParams r104 = r103.getLayoutParams();
            r104.width = (int) (UtilityKotlinExtentionsKt.h(52) * r102);
            r103.setLayoutParams(r104);
            return;
        L10:
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f566697a;

        public g(c r100) {
            this.f566697a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            c r101 = this.f566697a;
            tlc.d r102 = r101.f566667e;
            String r103 = null;
            if ((r102 instanceof x0) == true) goto L5;
            r102 = null;
        L5:
            x0 r104 = (x0) r102;
            HashMap r105 = new HashMap();
            r105.put("biz_type", "4");
            int r106 = x81.c.f562885a;
            DataCenter r107 = r101.f566668f;
            if (r104 == null) goto L8;
            r103 = r104.getExtra();
        L8:
            x81.c.a("livesdk_new_anchor_support_plan_click", r107, r103, r105);
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f566698a;

        public h(c r100) {
            this.f566698a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            c r101 = this.f566698a;
            c.k(r101, r101.f566681q, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#80ff356f"));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            c r102 = this.f566698a;
            c.k(r102, r102.f566681q, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
        }
    }

    public static final class i implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f566699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f566700b;

        public i(ValueAnimator r100, c r101) {
            this.f566699a = r100;
            this.f566700b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = this.f566699a.getAnimatedValue();
            if (r101 == null) goto L7;
            int r102 = ((Integer) r101).intValue();
            c r103 = this.f566700b;
            c.k(r103, r103.f566681q, ColorProtector.parseColor("#26000000"), r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class j extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f566701a;

        public j(c r100) {
            this.f566701a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            c r101 = this.f566701a;
            r101.r(r101.f566682r, 1.0f);
            c r102 = this.f566701a;
            r102.f566679o = false;
            r102.f566675k = 1;
            r102.h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            c r101 = this.f566701a;
            r101.f566679o = false;
            r101.f566675k = 1;
            LottieAnimationView r102 = r101.f566687w;
            if (r102 == null) goto L5;
            r102.setVisibility(0);
        L5:
            LottieAnimationView r103 = r101.f566687w;
            if (r103 == null) goto L8;
            r103.addAnimatorListener(new y81.j(r103, r101));
            r103.setAnimation("rank_indicator_sweep.json");
            r103.setImageAssetsFolder("rank_indicator/");
            r103.loop(false);
        L8:
            r101.K = ((ObservableSubscribeProxy) du2.a.b(0, 1, TimeUnit.MINUTES).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r101.f566669g))).subscribe(new y81.k(r101), RxUtil.getNoOpThrowable());
            c r104 = this.f566701a;
            if (r104.f566676l != 1) goto L16;
            TextSwitcher r105 = r104.H;
            if (r105 == null) goto L13;
            r105.setCurrentText(s1.B(R.string.ttlive_dou_plus_indicator_on));
        L13:
            c r106 = this.f566701a;
            int r107 = r106.f566677m;
            if (r107 <= 0) goto L16;
            r106.o(r107);
        L16:
            this.f566701a.h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ViewGroup r102 = this.f566701a.f566682r;
            if (r102 == null) goto L5;
            r102.setVisibility(0);
        L5:
            c r103 = this.f566701a;
            r103.r(r103.f566682r, 0.0f);
        }
    }

    public static final class k implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f566702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f566703b;

        public k(ValueAnimator r100, c r101) {
            this.f566702a = r100;
            this.f566703b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = this.f566702a.getAnimatedValue();
            if (r101 == null) goto L7;
            float r102 = ((Float) r101).floatValue();
            c r103 = this.f566703b;
            r103.r(r103.f566682r, r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public final void l() {
        i(1);
        Disposable r100 = this.K;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.L.clear();
        LottieAnimationView r101 = this.f566687w;
        if (r101 == null) goto L8;
        r101.cancelAnimation();
    L8:
        LottieAnimationView r102 = this.f566687w;
        if (r102 == null) goto L11;
        r102.setVisibility(8);
    L11:
        CompositeDisposable r103 = this.L;
        Observable r104 = Observable.just(this);
        TimeUnit r105 = TimeUnit.MILLISECONDS;
        r103.add(r104.delay(300, r105).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), RxUtil.getNoOpThrowable()));
        this.L.add(Observable.just(this).delay(5000, r105).compose(RxUtil.rxSchedulerHelper()).subscribe(new C8311c(this), RxUtil.getNoOpThrowable()));
        this.L.add(Observable.just(this).delay(9000, r105).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), RxUtil.getNoOpThrowable()));
    }

    public final void m() {
        this.f566679o = true;
        ValueAnimator r100 = this.f566690z;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = this.f566688x;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.L.clear();
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f566688x = r102;
        if (r102 == null) goto L14;
        r102.addListener(new e(this));
        r102.addUpdateListener(new f(r102, this));
        if (this.f566665c == true) goto L13;
        r102.setDuration(0);
        goto L14
    L13:
        r102.setDuration(500);
    L14:
        ValueAnimator r103 = this.f566688x;
        if (r103 == null) goto L17;
        r103.start();
    L17:
        p();
    }

    public final void q() {
        this.f566678n = -1;
        this.f566677m = 0;
        this.I = null;
        ValueAnimator r100 = this.f566690z;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = this.f566688x;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f566676l = 1;
        this.f566675k = 0;
        TextSwitcher r102 = this.H;
        if (r102 == null) goto L11;
        r102.setCurrentText("");
    L11:
        ViewGroup r103 = this.f566681q;
        if (r103 == null) goto L14;
        r103.setVisibility(8);
    L14:
        j();
        Disposable r104 = this.K;
        if (r104 == null) goto L17;
        r104.dispose();
    L17:
        this.L.clear();
        LottieAnimationView r105 = this.f566687w;
        if (r105 == null) goto L20;
        r105.setVisibility(8);
    L20:
        List<TextSwitcher> r106 = this.f566673J;
        if (r106 == null) goto L36;
        Iterator<T> r107 = r106.iterator();
    L24:
        if (r107.hasNext() == false) goto L36;
        TextSwitcher r108 = (TextSwitcher) r107.next();
        if (r108 == null) goto L28;
        View r109 = r108.getCurrentView();
    L30:
        if ((r109 instanceof TextView) == false) goto L24;
        View r110 = r108.getCurrentView();
        if (r110 == null) goto L35;
        ((TextView) r110).setTextColor(s1.h(R.color.commonui_white));
        goto L24
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L28:
        r109 = null;
    L36:
        TextView r111 = this.G;
        if (r111 == null) goto L39;
        r111.setTextColor(s1.h(R.color.commonui_white));
    L39:
        ViewGroup r112 = this.f566683s;
        if (r112 != null) goto L42;
    L46:
        TextSwitcher r113 = this.H;
        if (r113 != null) goto L49;
        return;
    L49:
        if (r113.getVisibility() != 8) goto L61;
        TextSwitcher r114 = this.H;
        if (r114 == null) goto L62;
        r114.setVisibility(0);
        return;
    L62:
        return;
    L61:
        return;
    L42:
        if (r112.getVisibility() != 0) goto L46;
        ViewGroup r115 = this.f566683s;
        if (r115 == null) goto L46;
        r115.setVisibility(8);
        goto L46
    }

    @Override // u81.d
    public final com.bytedance.android.live.room.incentiveinfo.c c() {
        return new com.bytedance.android.live.room.incentiveinfo.c();
    }

    @Override // u81.d
    public final v81.b e() {
        return new v81.b();
    }

    @Override // u81.d
    public final void onInit() {
        View r100 = this.f566670h;
        TextView r101 = null;
        if (r100 == null) goto L5;
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.online_info_root_view);
    L6:
        this.f566680p = r102;
        View r103 = this.f566670h;
        if (r103 == null) goto L9;
        ViewGroup r104 = (ViewGroup) r103.findViewById(R.id.dou_plus_root_view);
    L10:
        this.f566681q = r104;
        View r105 = this.f566669g;
        if (r105 == null) goto L13;
        ViewGroup r106 = (ViewGroup) r105.findViewById(R.id.alpha_change_area);
    L14:
        this.f566682r = r106;
        View r107 = this.f566669g;
        if (r107 == null) goto L17;
        ViewGroup r108 = (ViewGroup) r107.findViewById(R.id.data_info_area);
    L18:
        this.f566683s = r108;
        View r109 = this.f566670h;
        if (r109 == null) goto L21;
        LottieAnimationView r110 = (LottieAnimationView) r109.findViewById(R.id.sweep_anim);
    L22:
        this.f566687w = r110;
        View r111 = this.f566669g;
        if (r111 == null) goto L25;
        HSImageView r112 = (HSImageView) r111.findViewById(R.id.indicator_dou);
    L26:
        this.f566684t = r112;
        View r113 = this.f566669g;
        if (r113 == null) goto L29;
        View r114 = r113.findViewById(R.id.indicator_boundary);
    L30:
        this.f566686v = r114;
        View r115 = this.f566670h;
        if (r115 == null) goto L33;
        RelativeLayout r116 = (RelativeLayout) r115.findViewById(R.id.online_info_area);
    L34:
        this.f566685u = r116;
        View r117 = this.f566670h;
        if (r117 == null) goto L37;
        StrokeTextView r118 = (StrokeTextView) r117.findViewById(R.id.online_info);
    L37:
        View r119 = this.f566669g;
        if (r119 == null) goto L40;
        TextSwitcher r120 = (TextSwitcher) r119.findViewById(R.id.plus);
    L41:
        this.F = r120;
        View r121 = this.f566669g;
        if (r121 == null) goto L44;
        TextSwitcher r122 = (TextSwitcher) r121.findViewById(R.id.bits);
    L45:
        this.B = r122;
        View r123 = this.f566669g;
        if (r123 == null) goto L48;
        TextSwitcher r124 = (TextSwitcher) r123.findViewById(R.id.decade);
    L49:
        this.C = r124;
        View r125 = this.f566669g;
        if (r125 == null) goto L52;
        TextSwitcher r126 = (TextSwitcher) r125.findViewById(R.id.hundreds);
    L53:
        this.D = r126;
        View r127 = this.f566669g;
        if (r127 == null) goto L56;
        TextSwitcher r128 = (TextSwitcher) r127.findViewById(R.id.thousand);
    L57:
        this.E = r128;
        View r129 = this.f566669g;
        if (r129 == null) goto L60;
        TextSwitcher r130 = (TextSwitcher) r129.findViewById(R.id.unit);
    L61:
        this.A = r130;
        View r131 = this.f566669g;
        if (r131 == null) goto L64;
        TextSwitcher r132 = (TextSwitcher) r131.findViewById(R.id.info_label);
    L65:
        this.H = r132;
        View r133 = this.f566669g;
        if (r133 == null) goto L68;
        r101 = (TextView) r133.findViewById(R.id.point);
    L68:
        this.G = r101;
        this.f566673J = CollectionsKt.mutableListOf(new TextSwitcher[]{this.A, this.B, this.C, this.D, this.E, this.F});
        q();
        ViewGroup r134 = this.f566682r;
        if (r134 == null) goto L72;
        r134.setOnClickListener(new g(this));
        return;
    L72:
        return;
    L64:
        r132 = null;
        goto L65
    L60:
        r130 = null;
        goto L61
    L56:
        r128 = null;
        goto L57
    L52:
        r126 = null;
        goto L53
    L48:
        r124 = null;
        goto L49
    L44:
        r122 = null;
        goto L45
    L40:
        r120 = null;
        goto L41
    L33:
        r116 = null;
        goto L34
    L29:
        r114 = null;
        goto L30
    L25:
        r112 = null;
        goto L26
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void p() {
        ValueAnimator r100 = this.f566690z;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.L.clear();
        ValueAnimator r101 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#26000000")), Integer.valueOf(ColorProtector.parseColor("#80ff356f"))});
        this.f566690z = r101;
        if (r101 == null) goto L11;
        r101.addListener(new h(this));
        r101.addUpdateListener(new i(r101, this));
        if (this.f566665c == true) goto L10;
        r101.setStartDelay(0);
        r101.setDuration(0);
        goto L11
    L10:
        r101.setStartDelay(200);
        r101.setDuration(300);
    L11:
        ValueAnimator r102 = this.f566690z;
        if (r102 == null) goto L14;
        r102.start();
    L14:
        List<TextSwitcher> r103 = this.f566673J;
        if (r103 == null) goto L30;
        Iterator<T> r104 = r103.iterator();
    L18:
        if (r104.hasNext() == false) goto L30;
        TextSwitcher r105 = (TextSwitcher) r104.next();
        if (r105 == null) goto L22;
        View r106 = r105.getCurrentView();
    L24:
        if ((r106 instanceof TextView) == false) goto L18;
        View r107 = r105.getCurrentView();
        if (r107 == null) goto L29;
        ((TextView) r107).setTextColor(s1.h(R.color.commonui_white));
        goto L18
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L22:
        r106 = null;
    L30:
        TextView r108 = this.G;
        if (r108 == null) goto L33;
        r108.setTextColor(s1.h(R.color.commonui_white));
    L33:
        ValueAnimator r109 = this.f566689y;
        if (r109 == null) goto L36;
        r109.cancel();
    L36:
        ValueAnimator r110 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f566689y = r110;
        if (r110 == null) goto L39;
        r110.addListener(new j(this));
        r110.addUpdateListener(new k(r110, this));
        r110.setStartDelay(500);
        r110.setDuration(200);
    L39:
        ValueAnimator r111 = this.f566689y;
        if (r111 == null) goto L49;
        r111.start();
        return;
    }

    @Override // y81.b, u81.d
    public final void onDestroy() {
        super.onDestroy();
        this.L.clear();
        Disposable r100 = this.K;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        LottieAnimationView r101 = this.f566687w;
        if (r101 == null) goto L8;
        r101.cancelAnimation();
    L8:
        ValueAnimator r102 = this.f566688x;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        ValueAnimator r103 = this.f566689y;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        ValueAnimator r104 = this.f566690z;
        if (r104 == null) goto L17;
        r104.cancel();
    L17:
        q();
    }

    @Override // u81.d
    public final int getItemType() {
        return this.f566674j;
    }

    @Override // u81.d
    public final void f(String r100) {
        this.f566666d = r100;
        if (r100 == null) goto L6;
        ImageLoader.bindImage(this.f566684t, r100);
        return;
    }

    @Override // u81.d
    public void g(w81.a r100) {
        Long r101 = null;
        if (r100 == null) goto L5;
        tlc.d r102 = r100.f558609a;
    L6:
        this.f566667e = r102;
        if (r100 == null) goto L9;
        tlc.d r103 = r100.f558609a;
    L11:
        if ((r103 instanceof x0) == true) goto L13;
        r103 = null;
    L13:
        x0 r104 = (x0) r103;
        StringBuilder r105 = new StringBuilder("process holder binding, status: ");
        if (r104 == null) goto L16;
        r101 = r104.getStatus();
    L16:
        r105.append(r101);
        r105.append(", curStatus: ");
        r105.append(this.f566676l);
        r105.append(", showStatus: ");
        r105.append(this.f566675k);
        ALogger.d("CommonIncentiveHolder", r105.toString());
        if (r104 != null) goto L19;
        return;
    L19:
        Boolean r106 = r100.f558610b;
        if (r106 == null) goto L22;
        boolean r107 = r106.booleanValue();
    L23:
        this.f566665c = r107;
        Long r108 = r104.getStatus();
        if (r108 != null) goto L26;
    L36:
        Long r109 = r104.getStatus();
        if (r109 != null) goto L39;
    L48:
        Long r110 = r104.getStatus();
        int r111 = 0;
        if (r110 != null) goto L51;
    L64:
        i(0);
        return;
    L51:
        if (((int) r110.longValue()) != 1) goto L64;
        if (this.f566675k != 1) goto L64;
        Long r112 = r104.getNumber();
        if (r112 == null) goto L58;
        this.f566677m = (int) r112.longValue();
    L58:
        if (this.f566676l != 2) goto L60;
        this.f566676l = 1;
        p();
    L60:
        Long r113 = r104.getNumber();
        if (r113 == null) goto L63;
        r111 = (int) r113.longValue();
    L63:
        n(r111);
        this.f566676l = 1;
        return;
    L39:
        if (((int) r109.longValue()) != 2) goto L48;
        if (this.f566675k != 1) goto L48;
        this.f566676l = 2;
        Long r114 = r104.getNumber();
        if (r114 == null) goto L47;
        int r115 = (int) r114.longValue();
        if (r115 <= this.f566677m) goto L47;
        this.f566677m = r115;
    L47:
        n(this.f566677m);
        l();
        return;
    L26:
        if (((int) r108.longValue()) != 1) goto L36;
        if (this.f566675k != 0) goto L36;
        if (this.f566679o == true) goto L36;
        this.f566676l = 1;
        m();
        Long r116 = r104.getNumber();
        if (r116 == null) goto L66;
        int r117 = (int) r116.longValue();
        if (r117 <= 0) goto L67;
        this.f566677m = r117;
        return;
    L67:
        return;
    L66:
        return;
    L22:
        r107 = true;
        goto L23
    L9:
        r103 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public final void n(int r100) {
        if (r100 <= 0) goto L4;
        o(r100);
        return;
    L4:
        String r101 = s1.B(R.string.ttlive_dou_plus_indicator_on);
        ViewGroup r102 = this.f566683s;
        if (r102 != null) goto L7;
    L11:
        TextSwitcher r103 = this.H;
        if (r103 != null) goto L14;
    L18:
        TextSwitcher r104 = this.H;
        if (r104 == null) goto L23;
        r104.setCurrentText(r101);
        return;
    L23:
        return;
    L14:
        if (r103.getVisibility() != 8) goto L18;
        TextSwitcher r105 = this.H;
        if (r105 == null) goto L18;
        r105.setVisibility(0);
        goto L18
    L7:
        if (r102.getVisibility() != 0) goto L11;
        ViewGroup r106 = this.f566683s;
        if (r106 == null) goto L11;
        r106.setVisibility(8);
        goto L11
    }

    public final void o(int r100) {
        ViewGroup r101 = this.f566683s;
        if (r101 != null) goto L5;
    L9:
        TextSwitcher r102 = this.H;
        if (r102 == null) goto L20;
        if (r102.getVisibility() != 0) goto L20;
        TextSwitcher r103 = this.H;
        if (r103 == null) goto L16;
        r103.setVisibility(8);
    L16:
        TextSwitcher r104 = this.H;
        if (r104 == null) goto L20;
        r104.setCurrentText("");
    L20:
        if (TextUtils.equals(Marker.ANY_NON_NULL_MARKER, this.I) == true) goto L26;
        TextSwitcher r105 = this.F;
        if (r105 == null) goto L24;
        r105.setText(Marker.ANY_NON_NULL_MARKER);
    L24:
        this.I = Marker.ANY_NON_NULL_MARKER;
    L26:
        if (r100 < 10000) goto L56;
        TextView r106 = this.G;
        if (r106 == null) goto L30;
        r106.setVisibility(0);
    L30:
        TextSwitcher r107 = this.A;
        if (r107 != null) goto L33;
    L37:
        TextSwitcher r108 = this.A;
        if (r108 == null) goto L41;
        r108.setText("万");
    L41:
        if (r100 < 10000000) goto L43;
        r100 = 9999000;
    L43:
        if (r100 < 100000) goto L53;
        Integer r109 = com.bytedance.android.live.core.setting.k0.f65336a.getValue();
        if (r109 == null) goto L53;
        if (r109.intValue() != 1) goto L53;
        TextSwitcher r110 = this.A;
        if (r110 == null) goto L52;
        r110.setText("万+");
    L52:
        r100 = 100000;
    L53:
        int r111 = r100 / 1000;
        if ((r100 % 1000) < 500) goto L66;
        r111 = r111 + 1;
    L66:
        if (r100 < 100000) goto L78;
        Integer r112 = com.bytedance.android.live.core.setting.k0.f65336a.getValue();
        if (r112 == null) goto L78;
        if (r112.intValue() != 1) goto L78;
        TextView r113 = this.G;
        if (r113 == null) goto L75;
        r113.setVisibility(8);
    L75:
        TextSwitcher r114 = this.B;
        if (r114 == null) goto L79;
        r114.setVisibility(8);
    L79:
        s(this.C, r111, 10);
        s(this.D, r111, 100);
        s(this.E, r111, 1000);
        this.f566678n = r111;
        return;
    L78:
        s(this.B, r111, 1);
        goto L79
    L33:
        if (r107.getVisibility() != 8) goto L37;
        TextSwitcher r115 = this.A;
        if (r115 == null) goto L37;
        r115.setVisibility(0);
        goto L37
    L56:
        TextView r116 = this.G;
        if (r116 == null) goto L59;
        r116.setVisibility(8);
    L59:
        TextSwitcher r117 = this.A;
        if (r117 == null) goto L62;
        r117.setText("");
    L62:
        TextSwitcher r118 = this.A;
        if (r118 == null) goto L65;
        r118.setVisibility(8);
    L65:
        r111 = r100;
        goto L66
    L5:
        if (r101.getVisibility() != 8) goto L9;
        ViewGroup r119 = this.f566683s;
        if (r119 == null) goto L9;
        r119.setVisibility(0);
        goto L9
    }

    public final void r(View r100, float r101) {
        if ((r100 instanceof ViewGroup) == false) goto L8;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        r(r102.getChildAt(r104), r101);
        r104 = r104 + 1;
        goto L5
    L13:
        return;
    L8:
        if ((r100 instanceof View) == false) goto L12;
        r100.setAlpha(r101);
        return;
    }

    public final void s(TextSwitcher r100, int r101, int r102) {
        if (r100 == null) goto L19;
        int r103 = this.f566678n;
        if (r103 == (-1)) goto L7;
        r103 = (r103 / r102) % 10;
    L7:
        int r104 = (r101 / r102) % 10;
        if (r104 != 0) goto L14;
        if (r101 >= (r102 * 10)) goto L14;
        r100.setText("");
        r100.setVisibility(8);
        return;
    L14:
        if (r100.getVisibility() != 8) goto L16;
        r100.setVisibility(0);
    L16:
        if (r104 == r103) goto L21;
        r100.setText(String.valueOf(r104));
        return;
    L21:
        return;
    }

    public c(DataCenter r100, View r101, int r102, View r103) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r103, "parentView");
        super(r100, r101, r103);
        this.f566674j = r102;
        this.f566676l = 1;
        this.f566678n = -1;
        this.L = new CompositeDisposable();
    }

    public static final void k(c r100, ViewGroup r101, int r102, int r103) {
        r100.getClass();
        Drawable r104 = null;
        if (r101 == null) goto L5;
        Drawable r105 = r101.getBackground();
    L7:
        if ((r105 instanceof GradientDrawable) == false) goto L14;
        if (r101 == null) goto L10;
        r104 = r101.getBackground();
    L10:
        GradientDrawable r106 = (GradientDrawable) r104;
        if (r106 == null) goto L15;
        r106.setColors(new int[]{r102, r103});
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r105 = null;
        goto L7
    }
}
