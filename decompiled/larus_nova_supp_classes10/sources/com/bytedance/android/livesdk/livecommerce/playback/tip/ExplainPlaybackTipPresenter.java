package com.bytedance.android.livesdk.livecommerce.playback.tip;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackTipPresenter extends QFragmentPresenter {
    public ExplainPlaybackViewModel f;
    public final bk2.b g;

    public final void c0() {
        this.g.clearDisposable();
    }

    public ExplainPlaybackTipPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.g = new bk2.b();
    }

    public final void b0(QModel r4) {
        ExplainPlaybackViewModel r5 = Y().g(ExplainPlaybackViewModel.class);
        this.f = r5;
        if (r5 == null) goto L6;
        c.a(r5, g.a(Y()), ExplainPlaybackTipPresenter$onBind$1.INSTANCE, new ExplainPlaybackTipPresenter$onBind$2(this));
        return;
    }
}
