package com.bytedance.android.shopping.store.moments.module.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ability.p0;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.store.moments.holder.ECStoreShortVideoViewHolderNew;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends p0 {
    public final /* synthetic */ ECStoreMomentPresenter b;

    public g(ECStoreMomentPresenter r1) {
        this.b = r1;
        super(null);
    }

    public final BaseViewHolder n(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r1 = ECStoreShortVideoViewHolderNew.s;
        ECStoreMomentPresenter r2 = this.b;
        ECStoreViewModel r3 = r2.i;
        Fragment r6 = ((QFragmentPresenter) r2).e;
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r6, "fragment");
        QUIManager r0 = new QUIManager();
        View r4 = LayoutInflater.from(r10.getContext()).inflate(2131564808, null);
        com.bytedance.android.shopping.store.moments.a r5 = new com.bytedance.android.shopping.store.moments.a();
        ECStoreShortVideoViewHolderNew r7 = new ECStoreShortVideoViewHolderNew(r0, r4, r5, r10);
        r0.a = r6;
        r0.l(new jj3.c(r3, r4, r5, r6, r7), r10.getContext(), true);
        return r7;
    }
}
