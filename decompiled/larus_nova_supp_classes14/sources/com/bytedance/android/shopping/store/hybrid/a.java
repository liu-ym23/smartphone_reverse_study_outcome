package com.bytedance.android.shopping.store.hybrid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends QUIModule {
    public final View l;
    public final StoreTabConfig m;
    public final ECStoreViewModel n;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new ECStoreHybridTabPresenter(r0, this.m, this.n);
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }

    public a(View r2, StoreTabConfig r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "tabConfig");
        super(0);
        this.l = r2;
        this.m = r3;
        this.n = r4;
    }
}
