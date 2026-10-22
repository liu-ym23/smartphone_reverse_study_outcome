package com.bytedance.android.shopping.store.hybridproduct.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends QUIModule {
    public final ViewGroup l;
    public final ECStoreViewModel m;

    public final List<QUIModule> i() {
        ECStoreViewModel r2 = this.m;
        ShoppingAsyncInflater.a r3 = ShoppingAsyncInflater.e;
        Context r4 = this.l.getContext();
        r3.getClass();
        return CollectionsKt.listOf(new QUIModule[]{new f(r2, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r4), 2131564765, this.l, 4)), new a(this.m, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(this.l.getContext()), 2131564906, null, 6))});
    }

    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        Fragment r1 = a().i();
        if (r1 == null) goto L5;
        r0.a(new ECShopSortBarAndFilterPresenter(r1, this.m));
    L5:
        return r0;
    }

    public o(ViewGroup r2, ECStoreViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
