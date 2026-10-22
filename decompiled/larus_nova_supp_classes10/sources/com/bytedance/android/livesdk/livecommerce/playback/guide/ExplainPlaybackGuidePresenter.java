package com.bytedance.android.livesdk.livecommerce.playback.guide;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackGuidePresenter extends QFragmentPresenter {
    public ExplainPlaybackViewModel f;

    public ExplainPlaybackGuidePresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public static final void d0(ExplainPlaybackGuidePresenter r3) {
        r3.getClass();
        bj2.a.b("ExplainPlaybackGuidePresenter", "hideBigProductCard");
        int r0 = com.bytedance.android.livesdk.livecommerce.playback.utils.a.a;
        q.a.c("ec_commerce_playback_live_guide_show", true);
        ExplainPlaybackViewModel r4 = r3.f;
        if (r4 == null) goto L6;
        com.bytedance.android.ec.core.arch.event.c.d(r4, new com.bytedance.android.livesdk.livecommerce.playback.main.a.k());
        return;
    }

    public final void b0(QModel r4) {
        ExplainPlaybackViewModel r5 = Y().g(ExplainPlaybackViewModel.class);
        this.f = r5;
        if (r5 == null) goto L6;
        com.bytedance.android.ec.core.arch.state.c.a(r5, g.a(Y()), ExplainPlaybackGuidePresenter$onBind$1.INSTANCE, new ExplainPlaybackGuidePresenter$onBind$2(this));
        return;
    }
}
