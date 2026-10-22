package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter.ECSimpleProductCardPresenter;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends QUIModule {
    public final ni2.b l;

    public final QIPresenter h() {
        ni2.b r1 = this.l;
        return new ECSimpleProductCardPresenter(r1.h, r1.j);
    }

    public g(ni2.b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        super(0);
        this.l = r2;
    }

    public final int j(QModel r4) {
        if (r4 != null) goto L6;
        return 0;
    L6:
        if ((r4 instanceof ni2.a) == true) goto L8;
        r4 = null;
    L8:
        ni2.a r5 = (ni2.a) r4;
        if (r5 != null) goto L12;
        return 8;
    L12:
        if (r5.m == false) goto L15;
        return 0;
    L15:
        if (r5.a == false) goto L18;
        return 8;
    L18:
        return 0;
    }

    public final View f(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ShoppingAsyncInflater.e.getClass();
        return ShoppingAsyncInflater.a.a(r3).aU(2131560985, r4, false);
    }
}
