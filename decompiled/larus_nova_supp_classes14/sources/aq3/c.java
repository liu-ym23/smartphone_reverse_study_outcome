package aq3;

import android.view.View;
import com.bytedance.android.window.shop.innerflow.holder.element.presenter.ECWindowInnerFlowHotCommentElementPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends a {
    public final vp.c n;

    public final QIPresenter h() {
        return new ECWindowInnerFlowHotCommentElementPresenter(this.n);
    }

    public c(View r2, vp.c r3) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "hotElementPlayerProxy");
        super(r2, yp3.b.a);
        this.n = r3;
    }
}
