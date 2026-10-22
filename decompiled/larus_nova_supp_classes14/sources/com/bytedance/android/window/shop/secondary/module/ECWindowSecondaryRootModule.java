package com.bytedance.android.window.shop.secondary.module;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.home.module.a;
import com.bytedance.android.window.shop.home.module.b;
import com.bytedance.android.window.shop.home.module.c;
import com.bytedance.android.window.shop.secondary.presenter.ECWindowSecondaryContentPresenter;
import com.bytedance.android.window.shop.secondary.presenter.ECWindowSecondaryHeadPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowSecondaryRootModule extends a {
    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        r0.a(new ECWindowSecondaryContentPresenter());
        r0.a(new ECWindowSecondaryHeadPresenter());
        return r0;
    }

    public final List<QUIModule> i() {
        ArrayList r0 = new ArrayList();
        r0.add(new c(ECWindowSecondaryRootModule$subModules$1$1.INSTANCE));
        r0.add(new b(ECWindowSecondaryRootModule$subModules$1$2.INSTANCE));
        return r0;
    }

    public ECWindowSecondaryRootModule(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(null);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r1) {
        return l();
    }
}
