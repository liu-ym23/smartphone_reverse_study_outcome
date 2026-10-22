package jj3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.moments.ECStoreMixFragment;
import com.bytedance.android.shopping.store.moments.module.presenter.ECStoreMomentPresenter;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends QUIModule {
    public final ECStoreViewModel l;
    public final View m;
    public final ECStoreMixFragment n;
    public final StoreTabConfig o;

    public final QIPresenter h() {
        return new ECStoreMomentPresenter(this.n, this.l, this.o);
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.m;
    }

    public a(ECStoreViewModel r2, View r3, ECStoreMixFragment r4, StoreTabConfig r5) {
        Intrinsics.checkNotNullParameter(r2, "storeViewModel");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        super(0);
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
    }
}
