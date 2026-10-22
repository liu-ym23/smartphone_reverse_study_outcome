package jj3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.moments.holder.ECStoreShortVideoViewHolderNew;
import com.bytedance.android.shopping.store.moments.module.presenter.ECStoreShortVideoPresenterNew;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends QUIModule {
    public final ECStoreViewModel l;
    public final View m;
    public final com.bytedance.android.shopping.store.moments.a n;
    public final Fragment o;
    public final ECStoreShortVideoViewHolderNew p;

    public final QIPresenter h() {
        ECStoreShortVideoPresenterNew r0 = new ECStoreShortVideoPresenterNew(this.o, this.l, this.p);
        this.n.a = r0;
        return r0;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.m;
    }

    public c(ECStoreViewModel r3, View r4, com.bytedance.android.shopping.store.moments.a r5, Fragment r6, ECStoreShortVideoViewHolderNew r7) {
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Intrinsics.checkNotNullParameter(r5, "shortVideoProxy");
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r7, "viewHolder");
        super(-1, null);
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        this.p = r7;
    }
}
