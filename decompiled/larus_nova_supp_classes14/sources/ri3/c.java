package ri3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateProductListFragment;
import com.bytedance.android.shopping.store.aggregate.presenter.ShopAggregatePageProductGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends QUIModule {
    public final ViewGroup l;
    public final String m;

    public final List<QUIModule> i() {
        if (Intrinsics.areEqual(this.m, AggregatePageTypes.FULL_DISCOUNT.getType()) == false) goto L6;
        return CollectionsKt.listOf(new QUIModule[]{new a(th.a.d(th.a.e(this.l.getContext(), true), 2131564594, this.l, 4)), new d(this.l.findViewById(2131371124))});
    L6:
        return CollectionsKt.listOf(new QUIModule[]{new e(th.a.d(th.a.e(this.l.getContext(), true), 2131564594, this.l, 4)), new d(this.l.findViewById(2131371124))});
    }

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new ShopAggregatePageProductGroupPresenter((ShopAggregateProductListFragment) r0);
    }

    public c(ViewGroup r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
