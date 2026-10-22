package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowCroppedStyleAnimationPresenter extends AbsECWindowPresenter {
    public static final /* synthetic */ int B = 0;
    public boolean A;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public View u;
    public int v;
    public int w;
    public int x;
    public int y;
    public View z;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECWindowCroppedStyleAnimationPresenter a;

        public a(ECWindowCroppedStyleAnimationPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (((uq3.a) r3).a == null) goto L11;
            ECWindowCroppedStyleAnimationPresenter r4 = this.a;
            View r0 = com.bytedance.android.ec.window.base.utils.c.a((ViewGroup) r4.o.getValue(), ECWindowCroppedStyleAnimationPresenter$initUIOnce$1.INSTANCE);
            if (r0 == null) goto L9;
            r4.u = r0;
            r4.c0().post(new l(r4));
        L9:
            this.a.O().getCollapseProgress().observe(this.a.U(), new m(this));
            this.a.c0().post(new n(this));
            return;
        }
    }

    public final ViewGroup b0() {
        return (ViewGroup) this.m.getValue();
    }

    public final ViewGroup c0() {
        return (ViewGroup) this.n.getValue();
    }

    public final ViewGroup d0() {
        return (ViewGroup) this.p.getValue();
    }

    public final View e0() {
        return (View) this.q.getValue();
    }

    public ECWindowCroppedStyleAnimationPresenter() {
        this.m = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$croppedHeaderContainer$2(this));
        this.n = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$fullscreenHeaderContainer$2(this));
        this.o = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$headerContainer$2(this));
        this.p = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$pinListContainer$2(this));
        this.q = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$topbarContainer$2(this));
        this.r = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$bgContainer$2(this));
        this.s = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$adjustCard$2(this));
        this.t = LazyKt.lazy(new ECWindowCroppedStyleAnimationPresenter$tabContainer$2(this));
    }

    public static final void Z(ECWindowCroppedStyleAnimationPresenter r2) {
        r2.y = r2.w - r2.x;
        wg.a.d((View) r2.s.getValue(), r2.y);
        ((View) r2.t.getValue()).setTranslationY(-r2.y);
        r2.d0().setTranslationY(-r2.y);
    }

    public final void A(QModel r4) {
        wg.a.f(b0(), 0, G(), 0, 0);
        ViewExtensionsKt.g(b0(), 20.0f, 20.0f, 0.0f, 0.0f);
        b0().setVisibility(0);
        O().getHeaderResponse().a(U(), new a(this), false);
    }

    public final void a0(float r4) {
        if (this.A == false) goto L5;
        b0().setVisibility(0);
        this.A = false;
    L5:
        c0().setVisibility(0);
        c0().setAlpha(r4);
        e0().setVisibility(0);
        e0().setAlpha(r4);
        View r0 = this.u;
        if (r0 == null) goto L8;
        r0.setAlpha(1 - r4);
    L8:
        float r1 = 1 - r4;
        ((View) this.t.getValue()).setTranslationY(-(this.y * r1));
        d0().setTranslationY(-(this.y * r1));
    }
}
