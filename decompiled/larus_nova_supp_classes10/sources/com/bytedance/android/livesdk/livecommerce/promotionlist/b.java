package com.bytedance.android.livesdk.livecommerce.promotionlist;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final Lazy a;
    public final Lazy b;
    public final i c;
    public final j d;
    public final d e;
    public final c f;
    public final LivePromotionListSubscriberDelegate$clickBuyOrItemJsEventSubscriber$1 g;
    public final h h;
    public final e i;
    public final f j;
    public final k k;
    public final g l;
    public final Lazy m;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.a n;

    public static final class a {
    }

    static {
    }

    public b(LivePromotionListFragment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.n = r2;
        this.a = LazyKt.lazy(new LivePromotionListSubscriberDelegate$freshPromotionListJsEventSubscriber$2(this));
        this.b = LazyKt.lazy(new LivePromotionListSubscriberDelegate$addressUpdateBackJsEventSubscriber$2(this));
        this.c = new i(this);
        this.d = new j(this);
        this.e = new d(this);
        this.f = new c(this);
        this.g = new LivePromotionListSubscriberDelegate$clickBuyOrItemJsEventSubscriber$1(this);
        this.h = new h(this);
        this.i = new e(this);
        this.j = new f(this);
        this.k = new k(this);
        this.l = new g(this);
        this.m = LazyKt.lazy(new LivePromotionListSubscriberDelegate$orientationListener$2(this));
    }

    public static final void a(b r2, boolean r3) {
        LivePromotionListViewModel r0 = r2.n.f();
        if (r0 != null) goto L5;
    L7:
        ViewGroup r4 = r2.n.getRootView();
        if (r4 != null) goto L10;
        return;
    L10:
        if (r3 == false) goto L12;
        r4.animate().translationY(0.0f).setDuration(300).start();
        return;
    L12:
        r4.animate().translationY(r4.getMeasuredHeight()).setDuration(300).start();
        return;
    L5:
        if (r0.isInSplitScreen() != true) goto L7;
    }
}
