package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.presenter.h;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ListItemRootModule extends QUIModule {
    public final gj2.a l;
    public final w83.d<? extends w83.c> m;
    public final Lazy<i> n;
    public final View o;
    public final LivePromotionCardArgs p;
    public final Map<PromotionCardModuleName, Integer> q;
    public final Function0<g> r;

    public static final class a implements w83.c {
        public a() {
        }
    }

    public final List<QUIModule> i() {
        return CollectionsKt.listOf(new QUIModule[]{new c(this.o.findViewById(2131375664), this.p, this.q, this.n), new com.bytedance.android.livesdk.livecommerce.promotion.card.module.a(this.o.findViewById(2131377849), this.p, this.m, this.n), new b(this.o.findViewById(2131378075), this.p, this.m, this.n)});
    }

    public final QIPresenter h() {
        return new h(this.p);
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.o;
    }

    public ListItemRootModule(View r2, LivePromotionCardArgs r3, Map<PromotionCardModuleName, Integer> r4, Function0<g> r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "argument");
        Intrinsics.checkNotNullParameter(r4, "moduleIdMap");
        Intrinsics.checkNotNullParameter(r5, "getPromotionParams");
        super(0);
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.r = r5;
        gj2.a r6 = new gj2.a(r3.e, r3.g, r5, r3.b);
        this.l = r6;
        int r7 = ECSdk.a;
        w83.g r8 = (w83.g) ECSdk.a(w83.g.class);
        if (r8 == null) goto L6;
        w83.d<? extends w83.c> r9 = r8.b(r6);
        if (r9 == null) goto L6;
    L7:
        this.m = r9;
        this.n = LazyKt.lazy(new ListItemRootModule$ligoViewManager$1(this));
        return;
    L6:
        r9 = new y83.b(new a());
        goto L7
    }
}
