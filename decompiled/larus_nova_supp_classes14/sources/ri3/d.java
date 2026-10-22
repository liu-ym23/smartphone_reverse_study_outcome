package ri3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateProductListFragment;
import com.bytedance.android.shopping.store.aggregate.presenter.ShopAggregatePageProductListPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends QUIModule {
    public final View l;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new ShopAggregatePageProductListPresenter((ShopAggregateProductListFragment) r0);
    }

    public d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(0);
        this.l = r2;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
