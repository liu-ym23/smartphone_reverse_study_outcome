package aq3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.innerflow.holder.element.presenter.ECWindowInnerFlowFloatLynxPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends QUIModule {
    public h() {
        super(0);
    }

    public final QIPresenter h() {
        return new ECWindowInnerFlowFloatLynxPresenter();
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return new View(a().getContext());
    }
}
