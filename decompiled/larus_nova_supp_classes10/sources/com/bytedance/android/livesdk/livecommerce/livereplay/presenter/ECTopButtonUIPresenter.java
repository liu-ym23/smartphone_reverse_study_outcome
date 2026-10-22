package com.bytedance.android.livesdk.livecommerce.livereplay.presenter;

import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.livesdk.livecommerce.livereplay.utils.a;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECTopButtonUIPresenter extends QPresenter {
    public final String e;
    public final ViewModelProvider.Factory f;

    public final void A(QModel r4) {
        int r5 = a.a;
        final AbsECScrollProductCardBaseVideModel r6 = a.a(u(), this.e, this.f);
        if (r6 != null) goto L5;
        return;
    L5:
        c.a(r6, u().e(), ECTopButtonUIPresenter$onBind$1.INSTANCE, new ECTopButtonUIPresenter$onBind$2(this, r6));
        f.a(w(), new ECTopButtonUIPresenter$onBind$3(r6));
    }

    public ECTopButtonUIPresenter(String r2, ViewModelProvider.Factory r3) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r3, "factory");
        this.e = r2;
        this.f = r3;
    }
}
