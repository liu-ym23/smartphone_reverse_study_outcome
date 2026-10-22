package nj2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.LivePromotionListTabPresenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f519426l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Fragment f519427m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f519428n;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new LivePromotionListTabPresenter(this.f519427m, this.f519428n);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f519426l;
    }

    public e(View r100, Fragment r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        super(0);
        this.f519426l = r100;
        this.f519427m = r101;
        this.f519428n = r102;
    }
}
