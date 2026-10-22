package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.prepurchase.arch.container.state.ObservableData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpDataStore {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final ObservableData H;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<com.bytedance.android.shopping.prepurchase.arch.container.intf.l<n>> I;
    public final ObservableData a;
    public final ObservableData b;
    public final ObservableData c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
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
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public final com.bytedance.android.shopping.prepurchase.arch.container.state.e<CommonMeta> a() {
        return (com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.d.getValue();
    }

    public final com.bytedance.android.shopping.prepurchase.arch.container.state.e<List<com.bytedance.android.ecom.arch.slice.adapter.b>> b() {
        return (com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.A.getValue();
    }

    public final Control c() {
        return (Control) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.F.getValue()).a();
    }

    public final String d() {
        n r0 = (n) this.a.a();
        if (r0 == null) goto L6;
        String r1 = r0.c;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final ObservableData e() {
        return this.I.d(PdpDataStore$logIdObservable$1.INSTANCE);
    }

    public final ObservableData f() {
        return this.a.f(PdpDataStore$subscribeSearchTopBannerDataChange$1.INSTANCE, PdpDataStore$subscribeSearchTopBannerDataChange$2.INSTANCE, PdpDataStore$subscribeSearchTopBannerDataChange$3.INSTANCE);
    }

    public PdpDataStore(com.bytedance.android.shopping.prepurchase.arch.container.state.d<com.bytedance.android.shopping.prepurchase.arch.container.intf.l<n>> r2) {
        Intrinsics.checkNotNullParameter(r2, "responseWithState");
        this.I = r2;
        this.a = r2.d(PdpDataStore$responseData$1.INSTANCE);
        this.b = r2.d(PdpDataStore$pageMetaObservable$1.INSTANCE);
        this.c = r2.d(PdpDataStore$commonMetaAndControlObservable$1.INSTANCE);
        this.d = LazyKt.lazy(new PdpDataStore$commonMetaObservable$2(this));
        this.e = LazyKt.lazy(new PdpDataStore$topNavigationVOObservable$2(this));
        this.f = LazyKt.lazy(new PdpDataStore$collapseInfoObservable$2(this));
        this.g = LazyKt.lazy(new PdpDataStore$backgroundColorObservable$2(this));
        this.h = LazyKt.lazy(new PdpDataStore$topRightControlsVOObservable$2(this));
        this.i = LazyKt.lazy(new PdpDataStore$scrollNodesObservable$2(this));
        this.j = LazyKt.lazy(new PdpDataStore$searchSuggestInfoObservable$2(this));
        this.k = LazyKt.lazy(new PdpDataStore$bottomNavVOObservable$2(this));
        this.l = LazyKt.lazy(new PdpDataStore$bottomButtonVOObservable$2(this));
        this.m = LazyKt.lazy(new PdpDataStore$playBackObservable$2(this));
        this.n = LazyKt.lazy(new PdpDataStore$headMoreVideoObservable$2(this));
        this.o = LazyKt.lazy(new PdpDataStore$pendantContainerObservable$2(this));
        this.p = LazyKt.lazy(new PdpDataStore$oldPendantContainerObservable$2(this));
        this.q = LazyKt.lazy(new PdpDataStore$shopFloatEntryObservable$2(this));
        this.r = LazyKt.lazy(new PdpDataStore$backToTopEntryObservable$2(this));
        this.s = LazyKt.lazy(new PdpDataStore$questionnaireEntranceObservable$2(this));
        this.t = LazyKt.lazy(new PdpDataStore$smallVideoWindowObservable$2(this));
        this.u = LazyKt.lazy(new PdpDataStore$detailImagesObservable$2(this));
        this.v = LazyKt.lazy(new PdpDataStore$headDataObservable$2(this));
        this.w = LazyKt.lazy(new PdpDataStore$findSameGoodsObservable$2(this));
        this.x = LazyKt.lazy(new PdpDataStore$galleryVOObservable$2(this));
        this.y = LazyKt.lazy(new PdpDataStore$commentPreloadDataObservable$2(this));
        this.z = LazyKt.lazy(new PdpDataStore$templatesObservable$2(this));
        this.A = LazyKt.lazy(new PdpDataStore$componentsVOsObservable$2(this));
        this.B = LazyKt.lazy(new PdpDataStore$actionStorage$2(this));
        this.C = LazyKt.lazy(new PdpDataStore$globalActionObservable$2(this));
        this.D = LazyKt.lazy(new PdpDataStore$pdpLynxDataAfterPackObservable$2(this));
        this.E = LazyKt.lazy(new PdpDataStore$auctionInfoObservable$2(this));
        this.F = LazyKt.lazy(new PdpDataStore$controlObservable$2(this));
        this.G = LazyKt.lazy(new PdpDataStore$halfScreenTransitionAnimationEnabledObservable$2(this));
        this.H = r2.d(PdpDataStore$mainFeedObservable$1.INSTANCE);
    }
}
