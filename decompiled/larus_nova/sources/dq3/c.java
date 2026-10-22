package dq3;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.innerflow.presenter.ECWindowInnerFlowToolbarPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends com.bytedance.android.window.shop.home.module.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f469659m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECWindowInnerFlowToolbarPresenter();
    }

    public c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "moduleView");
        super(null);
        this.f469659m = r100;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r100) {
        return this.f469659m;
    }
}
