package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends QUIModule {
    public final View l;
    public final LivePromotionCardArgs m;
    public final w83.d<?> n;
    public final Lazy<i> o;

    public final boolean d() {
        return true;
    }

    public final QIPresenter h() {
        return new com.bytedance.android.livesdk.livecommerce.promotion.card.presenter.c(this.m, this.n, this.o);
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }

    public a(View r2, LivePromotionCardArgs r3, w83.d<?> r4, Lazy<? extends i> r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "argument");
        Intrinsics.checkNotNullParameter(r4, "ligoContext");
        Intrinsics.checkNotNullParameter(r5, "ligoViewManager");
        super(0);
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
    }
}
