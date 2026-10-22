package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.presenter.ListItemGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends QUIModule {
    public final View l;
    public final LivePromotionCardArgs m;
    public final Map<PromotionCardModuleName, Integer> n;
    public final Lazy<i> o;

    public final QIPresenter h() {
        return new ListItemGroupPresenter(this.m, this.n);
    }

    public final List<QUIModule> i() {
        return CollectionsKt.listOf(new e(this.l.findViewById(2131372875), this.o));
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }

    public c(View r2, LivePromotionCardArgs r3, Map<PromotionCardModuleName, Integer> r4, Lazy<? extends i> r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "argument");
        Intrinsics.checkNotNullParameter(r4, "moduleIdMap");
        Intrinsics.checkNotNullParameter(r5, "ligoViewManager");
        super(0);
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
    }
}
