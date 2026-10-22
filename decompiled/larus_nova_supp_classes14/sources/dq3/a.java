package dq3;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.innerflow.presenter.ECWindowInnerFlowListPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends com.bytedance.android.window.shop.home.module.a {
    public final View m;

    public final QIPresenter h() {
        return new ECWindowInnerFlowListPresenter();
    }

    public a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "moduleView");
        super(null);
        this.m = r2;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r1) {
        return this.m;
    }
}
