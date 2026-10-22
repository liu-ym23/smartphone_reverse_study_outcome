package vq3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.search.presenter.WindowSearchTitlePresenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f556769l;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new WindowSearchTitlePresenter();
    }

    public k(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(-1, null);
        this.f556769l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f556769l;
    }
}
