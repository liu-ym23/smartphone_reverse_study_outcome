package dq3;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.innerflow.presenter.ECWindowInnerFlowListPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends com.bytedance.android.window.shop.home.module.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f469657m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECWindowInnerFlowListPresenter();
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "moduleView");
        super(null);
        this.f469657m = r100;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r100) {
        return this.f469657m;
    }
}
