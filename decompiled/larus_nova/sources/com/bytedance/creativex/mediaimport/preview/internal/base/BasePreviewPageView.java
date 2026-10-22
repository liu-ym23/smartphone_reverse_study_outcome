package com.bytedance.creativex.mediaimport.preview.internal.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import bj4.k;
import bj4.r;
import bj4.s;
import com.bytedance.creativex.mediaimport.preview.internal.main.u;
import com.bytedance.creativex.mediaimport.preview.internal.main.y;
import com.bytedance.creativex.mediaimport.view.internal.validator.d;
import com.bytedance.creativex.mediaimport.widget.gesture.ScaleGestureLayout;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.widget.animation.CubicBezierInterpolator;
import com.ttnet.org.chromium.base.BaseSwitches;
import dj4.j;
import fi4.c;
import fi4.f;
import gi4.e;
import gi4.g;
import gi4.h;
import gi4.i;
import gi4.l;
import gi4.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public abstract class BasePreviewPageView<DATA> implements fi4.a<DATA>, ei4.a, d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f203430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f203431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c<DATA> f203432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f203433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f203434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<Boolean, DATA, Pair<View, Boolean>> f203435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<ei4.b<DATA>> f203436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PublishSubject f203437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PublishSubject f203438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PublishSubject f203439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f203440k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Function0<Unit>> f203441l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f203442m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f203443n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ScaleGestureLayout f203444o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DATA f203445p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final BasePreviewPageView$lifecycleObserver$1 f203446q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final gi4.c f203447r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final gi4.d f203448s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f203449t;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BasePreviewPageView<DATA> f203450a;

        public a(BasePreviewPageView<DATA> r100) {
            this.f203450a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            c<DATA> r101 = this.f203450a.f203432c;
            if (r101 == null) goto L7;
            MutableLiveData r102 = r101.va();
            if (r102 == null) goto L7;
            BasePreviewPageView<DATA> r103 = this.f203450a;
            r102.observe(r103.f203431b, r103.f203447r);
        L7:
            c<DATA> r104 = this.f203450a.f203432c;
            if (r104 == null) goto L12;
            MutableLiveData r105 = r104.a();
            if (r105 == null) goto L12;
            BasePreviewPageView<DATA> r106 = this.f203450a;
            r105.observe(r106.f203431b, r106.f203448s);
        L12:
            this.f203450a.f203431b.getLifecycle().addObserver(this.f203450a.g());
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f203450a.destroy();
        }
    }

    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BasePreviewPageView<DATA> f203451a;

        @Override // dj4.j
        public final void a() {
            this.f203451a.f203438i.onNext(fi4.a.AbstractC5910a.c.f477360a);
        }

        @Override // dj4.j
        public final void onClick() {
            this.f203451a.f203438i.onNext(fi4.a.AbstractC5910a.e.f477362a);
        }

        @Override // dj4.j
        public final void onExit() {
            this.f203451a.f203438i.onNext(fi4.a.AbstractC5910a.b.f477359a);
        }

        public b(BasePreviewPageView<DATA> r100) {
            this.f203451a = r100;
        }

        @Override // dj4.j
        public final void c(float r100) {
            this.f203451a.f203438i.onNext(new fi4.a.AbstractC5910a.C5911a(r100));
        }

        @Override // dj4.j
        public final void d(float r100) {
            this.f203451a.f203438i.onNext(fi4.a.AbstractC5910a.d.f477361a);
        }
    }

    public void h(DATA r100) {
    }

    public boolean p() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [gi4.e] */
    @Override // fi4.a
    public final Observable<f<DATA>> b() {
        Observable<T> r100 = this.f203439j.hide();
        final ?? r101 = new e(this);
        return r100.doOnSubscribe(new gi4.f(r101));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [gi4.i] */
    @Override // fi4.a
    public final Observable<fi4.a.AbstractC5910a> c() {
        Observable<T> r100 = this.f203438i.hide();
        final ?? r101 = new i(this);
        return r100.doOnSubscribe(new gi4.j(r101));
    }

    @Override // fi4.a
    public void destroy() {
        this.f203440k.clear();
        Iterator r100 = ((ArrayList) this.f203441l).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Function0) r100.next()).invoke();
        goto L4
    L6:
        ((ArrayList) this.f203441l).clear();
        c<DATA> r101 = this.f203432c;
        if (r101 == null) goto L11;
        MutableLiveData r102 = r101.va();
        if (r102 == null) goto L11;
        r102.removeObserver(this.f203447r);
    L11:
        c<DATA> r103 = this.f203432c;
        if (r103 == null) goto L16;
        MutableLiveData r104 = r103.a();
        if (r104 == null) goto L16;
        r104.removeObserver(this.f203448s);
    L16:
        this.f203431b.getLifecycle().removeObserver(g());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [gi4.g] */
    @Override // fi4.a
    public final Observable<DATA> e() {
        Observable<T> r100 = this.f203437h.hide();
        final ?? r101 = new g(this);
        return r100.doOnSubscribe(new h(r101));
    }

    public final ViewGroup f() {
        ViewGroup r100 = this.f203442m;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    public void j() {
        ViewGroup r100 = o(this.f203433d);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f203442m = r100;
        ViewGroup r101 = f();
        Intrinsics.checkNotNullParameter(r101, "content");
        ScaleGestureLayout r102 = (ScaleGestureLayout) r101.findViewById(R.id.gesture_layout);
        r102.I.f468912b = p();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f203444o = r102;
        ViewGroup r103 = f();
        Intrinsics.checkNotNullParameter(r103, "content");
        this.f203443n = r103.findViewById(R.id.iv_deleted);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k() {
        c<DATA> r100 = this.f203432c;
        Object r101 = null;
        if (r100 == null) goto L7;
        MutableLiveData r102 = r100.a();
        if (r102 == null) goto L7;
        Pair r103 = (Pair) r102.getValue();
    L8:
        if (r103 == null) goto L11;
        r101 = r103.getFirst();
    L11:
        if (r101 != this.f203445p) goto L13;
        return true;
    L13:
        return false;
    L7:
        r103 = null;
        goto L8
    }

    public cj4.a n() {
        cj4.a r100 = new cj4.a();
        r100.f23965e = 220;
        r100.f23966f = 220;
        r100.f23967g = 220;
        r100.f23968h = 220;
        Pair<? extends PointF, ? extends PointF> r101 = m.f481371a;
        PointF r102 = r101.component1();
        PointF r103 = r101.component2();
        CubicBezierInterpolator r104 = new CubicBezierInterpolator(r102, r103);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r100.f23961a = r104;
        CubicBezierInterpolator r105 = new CubicBezierInterpolator(r102, r103);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r100.f23962b = r105;
        CubicBezierInterpolator r106 = new CubicBezierInterpolator(r102, r103);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r100.f23963c = r106;
        CubicBezierInterpolator r107 = new CubicBezierInterpolator(r102, r103);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r100.f23964d = r107;
        return r100;
    }

    public j q() {
        return new b(this);
    }

    public bj4.d r() {
        return new bj4.b();
    }

    public final boolean t() {
        DATA r100 = this.f203445p;
        if (r100 == null) goto L17;
        String r101 = getPath(r100);
        Uri r102 = getUri(r100);
        if (ri4.b.a(r101, r102) == true) goto L7;
        m(r100);
        goto L17
    L7:
        List<ei4.b<DATA>> r103 = this.f203436g;
        if ((r103 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r104 = r103.iterator();
    L14:
        if (r104.hasNext() == false) goto L16;
        ((ei4.b) r104.next()).a(r100);
    L16:
        l(r100, r102);
        return true;
    L10:
        if (r103.isEmpty() == false) goto L12;
    L17:
        return false;
    }

    @Override // fi4.a
    public final View getContentView() {
        return f();
    }

    public LifecycleObserver g() {
        return this.f203446q;
    }

    public final Context getContext() {
        return this.f203430a;
    }

    @Override // fi4.a
    public final void a(u r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        ((ArrayList) this.f203441l).add(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ei4.a
    public final boolean d(final y r110) {
        Intrinsics.checkNotNullParameter(r110, "actualExit");
        FLogger r100 = FLogger.f375446a;
        r100.d("effect_platform", "BasePreviewPageView onExit isCurrentPage=" + k());
        if (k() == false) goto L61;
        StringBuilder r101 = new StringBuilder("BasePreviewPageView onExit isCurrentPage=");
        r101.append(k());
        r101.append(" transViewProvider=");
        if (this.f203435f != null) goto L7;
        boolean r102 = true;
    L8:
        r101.append(r102);
        r100.d("effect_platform", r101.toString());
        Function2<Boolean, DATA, Pair<View, Boolean>> r103 = this.f203435f;
        if (r103 == null) goto L61;
        Boolean r104 = Boolean.FALSE;
        c<DATA> r105 = this.f203432c;
        Rect r106 = null;
        if (r105 == null) goto L15;
        MutableLiveData r107 = r105.a();
        if (r107 == null) goto L15;
        Pair r108 = (Pair) r107.getValue();
    L16:
        if (r108 == null) goto L18;
        Object r109 = r108.getFirst();
    L19:
        Pair<View, Boolean> r111 = r103.invoke(r104, (DATA) r109);
        if (r111 == null) goto L61;
        View r112 = r111.component1();
        if (r112 == null) goto L61;
        l r113 = new l(r112);
        final ScaleGestureLayout r114 = this.f203444o;
        if (r114 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("gestureLayout");
        r114 = null;
    L28:
        Rect r115 = r113.b();
        View r116 = r113.a();
        if (r116 != null) goto L32;
    L35:
        bj4.d r117 = r();
        cj4.a r118 = n();
        r114.getClass();
        Intrinsics.checkNotNullParameter(r117, "listItemScaleType");
        Intrinsics.checkNotNullParameter(r118, "animationConfiguration");
        Intrinsics.checkNotNullParameter(r110, "endAction");
        r100.d("effect_platform", "animateDisappear started");
        if (ViewCompat.isAttachedToWindow(r114) == true) goto L38;
        r100.d("effect_platform", "animateDisappear Step1 view not attached to window");
        r110.invoke();
    L59:
        r100.d("effect_platform", "BasePreviewPageView onExit success isCurrentPage=" + k());
        return true;
    L38:
        Rect r119 = r114.f204203p;
        if (r119 == null) goto L41;
        boolean r120 = r119.isEmpty();
    L42:
        if (r115 == null) goto L44;
        boolean r121 = r115.isEmpty();
    L45:
        if (r106 == null) goto L47;
        boolean r122 = r106.isEmpty();
    L49:
        if (r120 == true) goto L58;
        if (r121 == true) goto L58;
        if (r122 == true) goto L58;
        if (r115 == null) goto L59;
        if (r106 == null) goto L59;
        int[] r123 = new int[2];
        r114.getLocationOnScreen(r123);
        r115.offset(-r123[0], -r123[1]);
        r106.offset(-r123[0], -r123[1]);
        AnimatorSet r124 = ej4.a.b(new Matrix(r114.f204201n), new Matrix(ej4.a.a(r115, r114.getWidth(), r114.getHeight(), r114.f204203p, r117)), r114.f204203p, r118, new bj4.j(r114));
        Animator r125 = r114.b(new Rect(r115), r106, 0.0f, true);
        r125.setDuration(r118.f23967g);
        r125.setInterpolator(r118.f23963c);
        Animator r126 = r114.i(0.0f);
        r126.setDuration(r118.f23967g);
        r126.setInterpolator(r118.f23963c);
        r100.d("effect_platform", "animateDisappear Step3 appearOrDisAppearAnimator start");
        AnimatorSet r127 = new AnimatorSet();
        r114.f204209v = r127;
        final Ref.BooleanRef r128 = new Ref.BooleanRef();
        r114.postDelayed(new k(r128, r114, r110), 600);
        r127.addListener(new s(r114, r128, r110));
        r127.playTogether(new Animator[]{r124, r125, r126});
        r127.setInterpolator(r114.B);
        r127.setDuration(200);
        r127.start();
    L58:
        ValueAnimator r129 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r129.addUpdateListener(new bj4.i(r114));
        r100.d("effect_platform", "animateDisappear Step2 appearOrDisAppearAnimator start");
        AnimatorSet r130 = new AnimatorSet();
        r114.f204209v = r130;
        r130.addListener(new r(r114, r110));
        r130.playTogether(new Animator[]{r129, r114.i(0.0f)});
        r130.setInterpolator(r114.B);
        r130.setDuration(200);
        r130.start();
        goto L59
    L47:
        r122 = true;
        goto L49
    L44:
        r121 = true;
        goto L45
    L41:
        r120 = true;
        goto L42
    L32:
        if (ViewCompat.isAttachedToWindow(r116) == false) goto L35;
        r106 = new Rect();
        r116.getGlobalVisibleRect(r106);
        goto L35
    L18:
        r109 = null;
    L15:
        r108 = null;
        goto L16
    L7:
        r102 = false;
    L61:
        return false;
    }

    public void i(boolean r100) {
        if (r100 == true) goto L4;
        return;
    L4:
        if (k() == true) goto L12;
        ScaleGestureLayout r101 = this.f203444o;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("gestureLayout");
        r101 = null;
    L9:
        r101.f204201n.reset();
        r101.f204207t = null;
        r101.f204209v = null;
        r101.f204208u = null;
        r101.k();
        r101.invalidate();
        return;
    }

    public void m(DATA r100) {
        this.f203437h.onNext(r100);
        View r101 = this.f203443n;
        if (r101 == null) goto L6;
        ci4.a.a(r101, true);
        return;
    }

    public ViewGroup o(ViewGroup r100) {
        View r101 = LayoutInflater.from(this.f203430a).inflate(R.layout.larus_tools_media_import_preview_image_root_view, r100, this.f203434e);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(DATA r110) {
        this.f203445p = r110;
        t();
        if (k() == false) goto L42;
        Function2<Boolean, DATA, Pair<View, Boolean>> r111 = this.f203435f;
        if (r111 == null) goto L42;
        Boolean r100 = Boolean.TRUE;
        c<DATA> r101 = this.f203432c;
        Rect r102 = null;
        if (r101 == null) goto L11;
        MutableLiveData r103 = r101.a();
        if (r103 == null) goto L11;
        Pair r104 = (Pair) r103.getValue();
    L12:
        if (r104 == null) goto L14;
        Object r105 = r104.getFirst();
    L15:
        Pair<View, Boolean> r112 = r111.invoke(r100, (DATA) r105);
        if (r112 == null) goto L42;
        View r106 = r112.component1();
        if (r112.component2().booleanValue() == false) goto L42;
        if (r106 == null) goto L42;
        gi4.k r113 = new gi4.k(r106);
        ScaleGestureLayout r107 = this.f203444o;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("gestureLayout");
        r107 = null;
    L26:
        Rect r108 = r113.b();
        View r114 = r113.a();
        if (r114 != null) goto L30;
    L31:
        Rect r109 = r102;
        bj4.d r115 = r();
        cj4.a r116 = n();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r115, "listItemScaleType");
        Intrinsics.checkNotNullParameter(r116, "animationConfiguration");
        r107.f204210w = new bj4.l(r107, r108, r109, r115, r116);
        if (r107.f204203p == null) goto L42;
        if (r107.getWidth() <= 0) goto L42;
        if (r107.getHeight() <= 0) goto L42;
        bj4.l r117 = r107.f204210w;
        if (r117 == null) goto L42;
        r117.run();
        goto L42
    L30:
        if (ViewCompat.isAttachedToWindow(r114) == false) goto L31;
        r102 = new Rect();
        r114.getGlobalVisibleRect(r102);
        goto L31
    L14:
        r105 = null;
    L11:
        r104 = null;
    L42:
        f().addOnAttachStateChangeListener(this.f203449t);
    }

    public final void u(DATA r100) {
        final ScaleGestureLayout r101 = this.f203444o;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("gestureLayout");
        r101 = null;
    L6:
        j r102 = q();
        int r103 = getWidth(r100);
        int r104 = getHeight(r100);
        r101.getClass();
        r101.f204203p = new Rect(0, 0, r103, r104);
        r101.post(new bj4.h(r101));
        r101.setZoomListener(r102);
    }

    public void l(DATA r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r101, "uri");
        View r102 = this.f203443n;
        if (r102 == null) goto L6;
        ci4.a.a(r102, false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.creativex.mediaimport.preview.internal.base.BasePreviewPageView$lifecycleObserver$1] */
    /* JADX WARN: Type inference failed for: r2v7, types: [gi4.c] */
    /* JADX WARN: Type inference failed for: r2v8, types: [gi4.d] */
    public BasePreviewPageView(Context r100, LifecycleOwner r101, c<DATA> r102, ViewGroup r103, boolean r104, Function2<? super Boolean, ? super DATA, ? extends Pair<? extends View, Boolean>> r105, List<? extends ei4.b<DATA>> r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r106, "validators");
        this.f203430a = r100;
        this.f203431b = r101;
        this.f203432c = r102;
        this.f203433d = r103;
        this.f203434e = r104;
        this.f203435f = r105;
        this.f203436g = r106;
        this.f203437h = PublishSubject.create();
        this.f203438i = PublishSubject.create();
        this.f203439j = PublishSubject.create();
        this.f203440k = new CompositeDisposable();
        this.f203441l = new ArrayList();
        this.f203446q = new BasePreviewPageView$lifecycleObserver$1();
        this.f203447r = new gi4.c(this);
        this.f203448s = new gi4.d(this);
        this.f203449t = new a(this);
    }
}
