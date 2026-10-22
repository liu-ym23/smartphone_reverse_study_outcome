package com.bytedance.android.livesdk.livecommerce.playback.bottomliving;

import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.playback.video.ExplainPlaybackVideoViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackBottomLivingPresenter extends QFragmentPresenter {
    public FrameLayout f;
    public ExplainPlaybackVideoViewModel g;
    public final Lazy h;

    public ExplainPlaybackBottomLivingPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.h = LazyKt.lazy(new ExplainPlaybackBottomLivingPresenter$viewModel$2(this));
    }

    public final void b0(QModel r6) {
        this.g = Y().g(ExplainPlaybackVideoViewModel.class);
        this.f = (FrameLayout) Z().b(2131367499).f();
        final TextView r7 = (TextView) Z().b(2131370676).f();
        LottieAnimationView r0 = Z().b(2131371937).f();
        r0.setVisibility(0);
        r0.setAnimation("ec_live_explain_lottie.json");
        r0.setRepeatCount(-1);
        r0.playAnimation();
        final FrameLayout r1 = this.f;
        if (r1 == null) goto L6;
        r1.setVisibility(0);
        c.a((ExplainPlaybackViewModel) this.h.getValue(), g.a(Y()), ExplainPlaybackBottomLivingPresenter$onBind$1$1.INSTANCE, new ExplainPlaybackBottomLivingPresenter$onBind$$inlined$let$lambda$1(r1, this, r7));
        return;
    }
}
