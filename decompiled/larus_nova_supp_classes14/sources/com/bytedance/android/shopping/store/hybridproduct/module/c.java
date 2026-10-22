package com.bytedance.android.shopping.store.hybridproduct.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends QUIModule {
    public final ViewGroup l;

    public final QIPresenter h() {
        return new com.bytedance.android.shopping.store.hybridproduct.presenter.o(this.l);
    }

    public c(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        super(-1, null);
        this.l = r3;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
