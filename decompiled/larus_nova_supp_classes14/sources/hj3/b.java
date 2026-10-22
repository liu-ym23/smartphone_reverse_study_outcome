package hj3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreLoadMorePresenter;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T extends BaseFollowStoreViewModel> extends QUIModule {
    public final View l;
    public final Fragment m;
    public final Class<T> n;

    public final QIPresenter h() {
        return new BaseFollowStoreLoadMorePresenter(this.m, this.n);
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }

    public b(View r3, Fragment r4, Class<T> r5) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        super(-1, null);
        this.l = r3;
        this.m = r4;
        this.n = r5;
    }
}
