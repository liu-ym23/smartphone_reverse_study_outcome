package ek3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.hybridproduct.holder.e;
import com.bytedance.android.shopping.store.shopfeed.presenter.ShopInnerflowSliceCardPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends QUIModule {
    public final ViewGroup l;
    public final e m;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new ShopInnerflowSliceCardPresenter(r0, this.m);
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }

    public b(Fragment r2, ViewGroup r3, e r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "viewInfoProxy");
        super(0);
        this.l = r3;
        this.m = r4;
    }
}
