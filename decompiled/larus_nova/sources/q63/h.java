package q63;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.anchorv3.matchpurchase.presenter.b0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f531772l;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new b0();
    }

    public h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(R.id.fl_shop_brand_container, null);
        this.f531772l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f531772l;
    }
}
