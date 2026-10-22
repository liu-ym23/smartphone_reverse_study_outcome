package com.bytedance.android.livesdk.livecommerce.playback.banner;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackTopBannerPresenter extends QFragmentPresenter {
    public final Lazy f;

    public ExplainPlaybackTopBannerPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ExplainPlaybackTopBannerPresenter$viewModel$2(this));
    }

    public final void b0(QModel r4) {
        c.a((ExplainPlaybackViewModel) this.f.getValue(), Y().e(), ExplainPlaybackTopBannerPresenter$onBind$1.INSTANCE, new ExplainPlaybackTopBannerPresenter$onBind$2(this));
    }
}
