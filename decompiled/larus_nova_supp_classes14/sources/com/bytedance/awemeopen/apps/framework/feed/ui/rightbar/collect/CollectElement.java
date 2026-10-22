package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import android.app.Activity;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.collect.serviceapi.AoCollectService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CollectElement extends BaseElement<g, i, tz3.a, jz3.a> {
    public final Activity g;
    public final o h;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b i;
    public final o24.b j;
    public final Lazy k;
    public jz3.a l;
    public boolean m;
    public boolean n;
    public final a o;

    public static final class a implements o24.a {
        public final /* synthetic */ CollectElement a;

        public a(CollectElement r1) {
            this.a = r1;
        }

        public final void onChange(String r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "aid");
            jz3.a r3 = this.a.l;
            if (r3 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r3 = null;
        L6:
            if (Intrinsics.areEqual(r1, r3.a.c()) == false) goto L9;
            this.a.r(true);
            return;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new g();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new i();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new CollectElementView(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        this.j.T(this.o);
        CollectionSuccessSnackBarManager.b();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        g r0 = g();
        Observer<Unit> r1 = new com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect.a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.a.d;
    }

    public final Activity getActivity() {
        return this.g;
    }

    public static final boolean q(CollectElement r2) {
        if (r2.h.getPageConfig().isTeenagerModel() == true) goto L11;
        AoCollectService r3 = (AoCollectService) r2.k.getValue();
        if (r3 == null) goto L7;
        boolean r4 = r3.u();
    L8:
        if (r4 == true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r4 = false;
        goto L8
    L11:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r3) {
        jz3.a r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        z44.a r0 = AosExtConfig.b.b0();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
    L12:
        j();
        return;
    L10:
        if (this.h.getPageConfig().getShowCollect() == false) goto L12;
        p();
        this.l = r4;
        this.m = false;
        this.n = false;
        r(false);
        this.j.l2(this.o);
        return;
    L5:
        if (r0.a == true) goto L7;
        r1 = true;
        goto L8
    }

    public final void r(boolean r6) {
        if (Intrinsics.areEqual(this.f.c, Boolean.TRUE) == false) goto L13;
        h().d.b(Boolean.valueOf(r6));
        i r7 = h();
        o24.b r0 = this.j;
        Activity r1 = this.g;
        jz3.a r2 = this.l;
        jz3.a r3 = null;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r2 = null;
    L7:
        r7.b.b(Long.valueOf(r0.q(r1, r2.a)));
        i r8 = h();
        o24.b r4 = this.j;
        Activity r5 = this.g;
        jz3.a r9 = this.l;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L11:
        r8.c.b(Boolean.valueOf(r4.v1(r5, r3.a)));
        return;
    L10:
        r3 = r9;
        goto L11
    }

    public CollectElement(Activity r2, o r3, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "pageOwner");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        d14.a r5 = b14.a.a;
        this.j = b14.a.a(o24.b.class);
        this.k = LazyKt.lazy(CollectElement$bdpCollectService$2.INSTANCE);
        this.o = new a(this);
    }
}
