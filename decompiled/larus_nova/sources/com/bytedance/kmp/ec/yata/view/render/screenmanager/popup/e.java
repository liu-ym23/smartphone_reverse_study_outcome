package com.bytedance.kmp.ec.yata.view.render.screenmanager.popup;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.View;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.view.render.screenmanager.popup.view.MaxHeightFrameLayout;
import com.bytedance.kmp.ec.yata.view.render.screenmanager.popup.view.RoundFrameLayout;
import com.bytedance.kmp.ec.yata.view.render.tree.RenderTreeManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements ga6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.view.c f252047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ga6.c f252048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ga6.b f252049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f252050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f252051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f252052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f252053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f252054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f252055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f252056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f252057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f252058l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f252059m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BottomSheetBehavior<?> f252060n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ObjectAnimator f252061o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f252062p;

    public final MaxHeightFrameLayout c() {
        return (MaxHeightFrameLayout) this.f252055i.getValue();
    }

    public final View d() {
        return (View) this.f252051e.getValue();
    }

    @Override // ga6.a
    public final void dismiss() {
        this.f252049c.c(this);
        g(false);
        BottomSheetBehavior<?> r100 = this.f252060n;
        if (r100 == null) goto L7;
        r100.setState(5);
        return;
    }

    public final RoundFrameLayout e() {
        return (RoundFrameLayout) this.f252056j.getValue();
    }

    @Override // ga6.a
    public void update() {
        h r100 = (h) this.f252048b.getData();
        if (r100 == null) goto L5;
        RenderTreeManager r101 = (RenderTreeManager) this.f252062p.getValue();
        ba6.g r102 = r100.f252069a;
        ba6.e r103 = r100.f252070b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "storeData");
        Intrinsics.checkNotNullParameter(r103, "renderTree");
        r101.f252105d.update(r102, r103, new com.bytedance.kmp.ec.yata.view.render.tree.c(null, r101, r102, r103));
    L5:
        this.f252049c.b(this);
    }

    @Override // ga6.a
    public final View b() {
        return d();
    }

    @Override // ga6.a
    public final ga6.c getConfig() {
        return this.f252048b;
    }

    public final void g(boolean r100) {
        ObjectAnimator r101 = this.f252061o;
        if (r101 == null) goto L6;
        r101.cancel();
    L6:
        if (r100 == false) goto L8;
        ObjectAnimator r102 = ObjectAnimator.ofFloat((View) this.f252053g.getValue(), View.ALPHA, new float[]{0.0f, 1.0f});
    L9:
        this.f252061o = r102;
        if (r102 == null) goto L13;
        r102.setDuration(200);
    L13:
        ObjectAnimator r103 = this.f252061o;
        if (r103 == null) goto L17;
        r103.start();
        return;
    L17:
        return;
    L8:
        r102 = ObjectAnimator.ofFloat((View) this.f252053g.getValue(), View.ALPHA, new float[]{1.0f, 0.0f});
        goto L9
    }

    public static Integer f(String r100, Function0 r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L20;
        return null;
    L20:
    L18:
        r101.invoke();
        return null;
    L14:
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L16;
        r100 = "#" + r100;     // Catch: Exception -> L18
    L16:
        return Integer.valueOf(Color.parseColor(r100));
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L10
    }

    public final void a(String r100, Function0<Unit> r101) {
        if (com.bytedance.kmp.ec.yata.common.init.b.b() == false) goto L14;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        r101.invoke();     // Catch: Throwable -> L6
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r103) == false) goto L15;
        YataErrorManager r104 = this.f252047a.f251821d;
        com.bytedance.kmp.ec.yata.common.error.d r105 = com.bytedance.kmp.ec.yata.common.error.c.b();
        r105.c("popup_params_" + r100 + "_crash");
        r105.i(Result.m9452exceptionOrNullimpl(r103));
        r105.d("popup配置的" + r100 + "出现不兼容问题，32.4.0版本修复，之前版本会Crash");
        r105.f251413p = true;
        r104.c(r105);
        return;
    L15:
        return;
    L6:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public e(com.bytedance.kmp.ec.yata.view.c r100, f r101, PopupScreenManager$createPopupCard$card$1 r102) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "cardCallback");
        this.f252047a = r100;
        this.f252048b = r101;
        this.f252049c = r102;
        Object r103 = r101.d("fit_content");
        if ((r103 instanceof Boolean) == false) goto L5;
        Boolean r104 = (Boolean) r103;
    L6:
        if (r104 == null) goto L8;
        boolean r105 = r104.booleanValue();
    L9:
        this.f252050d = r105;
        this.f252051e = LazyKt.lazy(new PopupCard$rootView$2(this));
        this.f252052f = LazyKt.lazy(new PopupCard$container1$2(this));
        this.f252053g = LazyKt.lazy(new PopupCard$maskView$2(this));
        this.f252054h = LazyKt.lazy(new PopupCard$coordinator$2(this));
        this.f252055i = LazyKt.lazy(new PopupCard$behaviorPayloadView$2(this));
        this.f252056j = LazyKt.lazy(new PopupCard$yataPositionContainer$2(this));
        this.f252057k = LazyKt.lazy(new PopupCard$headView$2(this));
        this.f252058l = LazyKt.lazy(new PopupCard$footerView$2(this));
        this.f252059m = LazyKt.lazy(new PopupCard$bodyView$2(this));
        this.f252062p = LazyKt.lazy(new PopupCard$treeManager$2(this));
        return;
    L8:
        r105 = false;
        goto L9
    L5:
        r104 = null;
        goto L6
    }
}
