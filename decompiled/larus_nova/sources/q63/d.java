package q63;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv3.matchpurchase.presenter.l;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l f531767l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewGroup f531768m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        l r100 = new l();
        this.f531767l = r100;
        return r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final List<QUIModule> i() {
        ShoppingAsyncInflater.a r100 = ShoppingAsyncInflater.f45268e;
        Context r101 = this.f531768m.getContext();
        r100.getClass();
        return CollectionsKt.listOf(new h(ShoppingAsyncInflater.a.a(r101).aU(R.layout.shopping_match_purchase_shop_brand_layout, this.f531768m, false)));
    }

    public d(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(0);
        this.f531768m = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f531768m;
    }
}
