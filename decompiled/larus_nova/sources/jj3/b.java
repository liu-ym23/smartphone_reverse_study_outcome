package jj3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.moments.module.presenter.ECStoreShortVideoLoadMorePresenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f499317l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.shopping.store.moments.a f499318m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Fragment f499319n;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        ECStoreShortVideoLoadMorePresenter r100 = new ECStoreShortVideoLoadMorePresenter(this.f499319n);
        this.f499318m.f185633a = r100;
        return r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f499317l;
    }

    public b(View r100, com.bytedance.android.shopping.store.moments.a r101, Fragment r102) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "shortVideoProxy");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        super(-1, null);
        this.f499317l = r100;
        this.f499318m = r101;
        this.f499319n = r102;
    }
}
