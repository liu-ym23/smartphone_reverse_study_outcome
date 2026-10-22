package aq3;

import android.view.View;
import com.bytedance.android.window.shop.innerflow.holder.element.presenter.ECWindowInnerFlowRecommendTextElementPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends a {
    public final QIPresenter h() {
        return new ECWindowInnerFlowRecommendTextElementPresenter();
    }

    public e(View r2) {
        Intrinsics.checkNotNullParameter(r2, "root");
        super(r2, yp3.g.a);
    }
}
