package q63;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.anchorv3.matchpurchase.presenter.x;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f531771l;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        Fragment r100 = a().i();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new x(r100);
    }

    public g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(R.id.match_purchase_buy_button_fl_container, null);
        this.f531771l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f531771l;
    }
}
