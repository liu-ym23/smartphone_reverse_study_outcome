package com.bytedance.salamander.anniex;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.relax.relaxframework.RelaxFrameworkKt;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes20.dex */
public abstract class AnnieXCommonUIViewModel extends AnnieXBaseViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakReference<f3> f267812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<? extends h> f267813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<? super Function1<? super h, ? extends h>, Unit> f267814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i f267815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t f267816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AnnieXLoadingViewModel f267817k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AnnieXNavBarViewModel f267818l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final w1 f267819m;

    public static final class a {
    }

    static {
    }

    public abstract AnnieXUIComponentType g();

    public final void d() {
        WeakReference<f3> r100 = this.f267812f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_commonUICoordinator");
        r100 = null;
    L5:
        f3 r101 = r100.get();
        if (r101 == null) goto L9;
        r101.close();
        return;
    }

    public final boolean e() {
        Function0<? extends h> r100 = this.f267813g;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_commonUIModelGetter");
        r100 = null;
    L6:
        return r100.invoke().f268098b;
    }

    public final i f() {
        i r100 = this.f267815i;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_commonUIProps");
        return null;
    L6:
        return r100;
    }

    public final AnnieXContainerUIService h() {
        int r100 = s1.f268368a;
        i r101 = this.f267815i;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_commonUIProps");
        r101 = null;
    L5:
        k3 r102 = AnnieXAnnieXServiceCenterKt.a(r101.f268055e);
        if ((r102 instanceof AnnieXContainerUIService) == true) goto L8;
        return null;
    L8:
        return (AnnieXContainerUIService) r102;
    }

    public final AnnieXNavBarViewModel i() {
        AnnieXNavBarViewModel r100 = this.f267818l;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_navBarViewModel");
        return null;
    L6:
        return r100;
    }

    public final void k() {
        Function1<? super Function1<? super h, ? extends h>, Unit> r100 = this.f267814h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_commonUIModelSetter");
        r100 = null;
    L5:
        r100.invoke(new AnnieXCommonUIViewModel$setBgColor$1(this));
    }

    public final boolean j() {
        if (e() == false) goto L13;
        LinkedHashMap r100 = new LinkedHashMap();
        i r101 = this.f267815i;
        g3 r102 = null;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("_commonUIProps");
        r101 = null;
    L7:
        com.bytedance.rts.foundation.m.e(r100, "containerID", r101.f268055e);
        o r103 = a();
        r103.getClass();
        Intrinsics.checkNotNullParameter("bulletOnBackPressAction", "eventName");
        Intrinsics.checkNotNullParameter(r100, "params");
        g3 r104 = r103.f268260a;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("_engine");
    L11:
        r102.sendEvent("bulletOnBackPressAction", r100);
        goto L13
    L10:
        r102 = r104;
    L13:
        return e();
    }

    public final void l(final g r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        AnnieXNavBarViewModel r101 = this.f267818l;
        Function1<? super Function1<? super i0, ? extends i0>, Unit> r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_navBarViewModel");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "color");
        Function1<? super Function1<? super i0, ? extends i0>, Unit> r103 = r101.f267834b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("_stateSetter");
    L9:
        r102.invoke(new AnnieXNavBarViewModel$setBackgroundColor$1(r100));
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void n(final g r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        if (h() == null) goto L5;
        Intrinsics.checkNotNullParameter(this, "viewModel");
    L5:
        AnnieXNavBarViewModel r101 = this.f267818l;
        Function1<? super Function1<? super i0, ? extends i0>, Unit> r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("_navBarViewModel");
        r101 = null;
    L8:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "titleColor");
        Function1<? super Function1<? super i0, ? extends i0>, Unit> r103 = r101.f267834b;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("_stateSetter");
    L12:
        r102.invoke(new AnnieXNavBarViewModel$setTitleColor$1(r100));
        return;
    L11:
        r102 = r103;
        goto L12
    }

    public final void o(boolean r100) {
        AnnieXNavBarViewModel r101 = this.f267818l;
        Function1<? super Function1<? super v1, ? extends v1>, Unit> r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_navBarViewModel");
        r101 = null;
    L5:
        r101.a(r100);
        w1 r103 = this.f267819m;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("_statusBarViewModel");
        r103 = null;
    L9:
        if ((!r100) == false) goto L16;
        WeakReference<h3> r104 = r103.f268476a;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("_platformStatusBar");
        r104 = null;
    L13:
        h3 r105 = r104.get();
        if (r105 == null) goto L16;
        final double r106 = r105.b();
    L17:
        Function1<? super Function1<? super v1, ? extends v1>, Unit> r107 = r103.f268478c;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("_stateSetter");
    L21:
        r102.invoke(new AnnieXStatusBarViewModel$adjustHeight$1(r106));
        return;
    L20:
        r102 = r107;
    L16:
        r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L17
    }

    public final void p(final g r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        w1 r101 = this.f267819m;
        Function1<? super Function1<? super v1, ? extends v1>, Unit> r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_statusBarViewModel");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "color");
        Function1<? super Function1<? super v1, ? extends v1>, Unit> r103 = r101.f268478c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("_stateSetter");
    L9:
        r102.invoke(new AnnieXStatusBarViewModel$setBackgroundColor$1(r100));
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void q(final boolean r100) {
        w1 r101 = this.f267819m;
        Function1<? super Function1<? super v1, ? extends v1>, Unit> r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_statusBarViewModel");
        r101 = null;
    L5:
        Function0<? extends v1> r103 = r101.f268477b;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("_stateGetter");
        r103 = null;
    L9:
        if (r103.invoke().f268417a == r100) goto L22;
        WeakReference<h3> r104 = r101.f268476a;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("_platformStatusBar");
        r104 = null;
    L13:
        h3 r105 = r104.get();
        if (r105 == null) goto L16;
        r105.c(r100);
    L16:
        Function1<? super Function1<? super v1, ? extends v1>, Unit> r106 = r101.f268478c;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("_stateSetter");
    L20:
        r102.invoke(new AnnieXStatusBarViewModel$setHidden$1(r100));
        return;
    L19:
        r102 = r106;
        goto L20
    }

    public final void r(final AnnieXStatusFontMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        w1 r101 = this.f267819m;
        Function1<? super Function1<? super v1, ? extends v1>, Unit> r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_statusBarViewModel");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "fontMode");
        Function0<? extends v1> r103 = r101.f268477b;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("_stateGetter");
        r103 = null;
    L9:
        if (r103.invoke().f268420d == r100) goto L22;
        WeakReference<h3> r104 = r101.f268476a;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("_platformStatusBar");
        r104 = null;
    L13:
        h3 r105 = r104.get();
        if (r105 == null) goto L16;
        r105.d(r100);
    L16:
        Function1<? super Function1<? super v1, ? extends v1>, Unit> r106 = r101.f268478c;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("_stateSetter");
    L20:
        r102.invoke(new AnnieXStatusBarViewModel$setFontMode$1(r100));
        return;
    L19:
        r102 = r106;
        goto L20
    }

    public final void s(final boolean r100) {
        t r101 = this.f267816j;
        Function1<? super Function1<? super r, ? extends r>, Unit> r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_errorViewModel");
        r101 = null;
    L6:
        if (r101.f268376a == false) goto L20;
        Function0<? extends r> r103 = r101.f268377b;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("_stateGetter");
        r103 = null;
    L12:
        if (r103.invoke().f268337b == r100) goto L21;
        Function1<? super Function1<? super r, ? extends r>, Unit> r104 = r101.f268378c;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("_stateSetter");
    L18:
        r102.invoke(new AnnieXErrorViewModel$setVisible$1(r100));
        return;
    L17:
        r102 = r104;
        goto L18
    L21:
        return;
    }

    public final void t(final boolean r100) {
        Function0<? extends h> r101 = this.f267813g;
        Function1<? super Function1<? super h, ? extends h>, Unit> r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_commonUIModelGetter");
        r101 = null;
    L6:
        if (r101.invoke().f268098b == r100) goto L13;
        Function1<? super Function1<? super h, ? extends h>, Unit> r103 = this.f267814h;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("_commonUIModelSetter");
    L11:
        r102.invoke(new AnnieXCommonUIViewModel$updateBlockBackPress$1(r100));
        return;
    L10:
        r102 = r103;
        goto L11
    }

    public AnnieXCommonUIViewModel(i r100, f3 r101) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Intrinsics.checkNotNullParameter(r101, "coordinator");
        super(r100);
        String r102 = r100.f268055e;
        j r103 = r100.b();
        this.f267812f = new WeakReference(r101);
        h r104 = new h(r103.a());
        r104.f268098b = r103.f268138g;
        Object[] r105 = RelaxFrameworkKt.i0(r104);
        Object r106 = r105[0];
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Function0<com.bytedance.salamander.anniex.AnnieXCommonUIModel>{ com.relax.relaxframework.RelaxFrameworkKt.StateGetter<com.bytedance.salamander.anniex.AnnieXCommonUIModel> }");
        Function0<? extends h> r107 = (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r106, 0);
        Object r108 = r105[1];
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"fn\")] kotlin.Function1<@[ParameterName(name = \"v\")] com.bytedance.salamander.anniex.AnnieXCommonUIModel, com.bytedance.salamander.anniex.AnnieXCommonUIModel>, kotlin.Unit>{ com.relax.relaxframework.RelaxFrameworkKt.StateSetter<com.bytedance.salamander.anniex.AnnieXCommonUIModel> }");
        Function1<? super Function1<? super h, ? extends h>, Unit> r109 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r108, 1);
        this.f267813g = r107;
        this.f267814h = r109;
        this.f267815i = r100;
        this.f267816j = new t(r102, r103.f268136e);
        this.f267817k = new AnnieXLoadingViewModel(r102, r103.f268137f);
        i0 r110 = r100.f268104j;
        if (r110 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("navBarModel");
        r110 = null;
    L6:
        this.f267818l = new AnnieXNavBarViewModel(r110);
        v1 r111 = new v1();
        r111.f268417a = r103.f268142k;
        g r112 = new g();
        com.bytedance.anniex.bd.foundation.impl.m r113 = r103.f268144m;
        if (r113 != null) goto L9;
        r113 = r103.f268145n;
    L9:
        if (r113 == null) goto L11;
        r112.f268073a = r113;
        r112.f268075c = r113;
        r112.f268074b = r113;
    L11:
        Intrinsics.checkNotNullParameter(r112, "statusBarBgColor");
        r111.f268418b = r112;
        AnnieXStatusFontMode r114 = r103.f268146o;
        Intrinsics.checkNotNullParameter(r114, "statusFontMode");
        r111.f268420d = r114;
        if (r103.b() == true) goto L14;
        r111.f268419c = r101.b();
    L14:
        this.f267819m = new w1(r111, r101);
    }

    public final void m(final String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        if (h() == null) goto L5;
        Intrinsics.checkNotNullParameter(this, "viewModel");
    L5:
        AnnieXNavBarViewModel r102 = this.f267818l;
        Function1<? super Function1<? super i0, ? extends i0>, Unit> r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("_navBarViewModel");
        r102 = null;
    L8:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "title");
        if (r101 == true) goto L16;
        Function0<? extends i0> r104 = r102.f267833a;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("_stateGetter");
        r104 = null;
    L14:
        if (r104.invoke().f268112h == true) goto L16;
        return;
    L16:
        Function0<? extends i0> r105 = r102.f267833a;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("_stateGetter");
        r105 = null;
    L20:
        if (Intrinsics.areEqual(r105.invoke().f268110f, r100) == true) goto L27;
        Function1<? super Function1<? super i0, ? extends i0>, Unit> r106 = r102.f267834b;
        if (r106 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("_stateSetter");
    L25:
        r103.invoke(new AnnieXNavBarViewModel$setTitle$1(r100));
        return;
    L24:
        r103 = r106;
        goto L25
    }
}
