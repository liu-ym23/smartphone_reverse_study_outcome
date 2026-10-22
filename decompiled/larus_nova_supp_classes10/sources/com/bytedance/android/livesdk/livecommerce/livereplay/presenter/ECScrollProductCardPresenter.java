package com.bytedance.android.livesdk.livecommerce.livereplay.presenter;

import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.livesdk.livecommerce.livereplay.utils.a;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECScrollProductCardPresenter extends QPresenter {
    public final String e;
    public final ViewModelProvider.Factory f;

    public final void A(QModel r4) {
        int r5 = a.a;
        final AbsECScrollProductCardBaseVideModel r6 = a.a(u(), this.e, this.f);
        if (r6 != null) goto L5;
        return;
    L5:
        c.a(r6, u().e(), ECScrollProductCardPresenter$onBind$1.INSTANCE, new ECScrollProductCardPresenter$onBind$2(this, r6));
        com.bytedance.android.ec.core.arch.event.c.c(r6, u().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.a.h.class), new ECScrollProductCardPresenter$onBind$3(this));
        com.bytedance.android.ec.core.arch.event.c.c(r6, u().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.a.d.class), new ECScrollProductCardPresenter$onBind$4(this));
        r6.reportPageInfoForDebug(u().c());
    }

    public ECScrollProductCardPresenter(String r2, ViewModelProvider.Factory r3) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r3, "factory");
        this.e = r2;
        this.f = r3;
    }
}
