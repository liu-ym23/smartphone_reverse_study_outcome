package jj3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.moments.module.presenter.ECStoreShortVideoLoadMorePresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends QUIModule {
    public final View l;
    public final com.bytedance.android.shopping.store.moments.a m;
    public final Fragment n;

    public final QIPresenter h() {
        ECStoreShortVideoLoadMorePresenter r0 = new ECStoreShortVideoLoadMorePresenter(this.n);
        this.m.a = r0;
        return r0;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }

    public b(View r3, com.bytedance.android.shopping.store.moments.a r4, Fragment r5) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "shortVideoProxy");
        Intrinsics.checkNotNullParameter(r5, "fragment");
        super(-1, null);
        this.l = r3;
        this.m = r4;
        this.n = r5;
    }
}
