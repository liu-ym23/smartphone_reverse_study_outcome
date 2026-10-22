package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.promotion.card.presenter.j;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends QUIModule {
    public final View l;
    public final Lazy<i> m;

    public final boolean d() {
        return true;
    }

    public final QIPresenter h() {
        return new j(this.m);
    }

    public e(View r2, Lazy<? extends i> r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "ligoViewManager");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
