package zj3;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.router.hybridpage.holder.c;
import com.bytedance.android.shopping.store.router.hybridpage.presenter.product.HybridPageGeneralCardPresenter;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends rm.a {
    public final HybridPageViewModel m;
    public final c n;
    public final LayoutTypes o;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 == null) goto L5;
        QGroupPresenter r1 = new QGroupPresenter();
        r1.a(new HybridPageGeneralCardPresenter(r0, this.n, this.o, this.m));
        return r1;
    L5:
        return null;
    }

    public a(ViewGroup r2, HybridPageViewModel r3, c r4, LayoutTypes r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "viewInfoProxy");
        Intrinsics.checkNotNullParameter(r5, "layoutTypes");
        super(r2);
        this.m = r3;
        this.n = r4;
        this.o = r5;
    }
}
