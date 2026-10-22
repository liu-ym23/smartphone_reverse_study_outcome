package com.bytedance.android.window.shop.home.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends QUIModule {

    public static final class a extends QPresenter {
        public a() {
        }

        public final void A(QModel r3) {
            ECQuickUtilKt.d(u(), ECWindowViewModel.class, ECWindowDialogFragment.class).mayEmitHeaderResponse();
        }
    }

    public g() {
        super(-1, null);
    }

    public final QIPresenter h() {
        return new a();
    }

    public final View f(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r4 = new View(r2);
        r4.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        return r4;
    }
}
