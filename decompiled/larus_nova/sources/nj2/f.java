package nj2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.LivePromotionListTopPresenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f519429l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Fragment f519430m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f519431n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f519432o;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new LivePromotionListTopPresenter(this.f519430m, this.f519432o);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final int j(QModel r100) {
        if (this.f519431n == false) goto L5;
        return 8;
    L5:
        return 0;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f519429l;
    }

    public f(View r100, Fragment r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        super(0);
        this.f519429l = r100;
        this.f519430m = r101;
        this.f519431n = r102;
        this.f519432o = r103;
    }
}
