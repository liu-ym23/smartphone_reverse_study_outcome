package com.bytedance.android.livesdk.livecommerce.playback.header;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackHeaderPresenter extends QFragmentPresenter {
    public final Lazy f;

    public final ExplainPlaybackViewModel d0() {
        return (ExplainPlaybackViewModel) this.f.getValue();
    }

    public ExplainPlaybackHeaderPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ExplainPlaybackHeaderPresenter$viewModel$2(this));
    }

    public final void b0(QModel r4) {
        c.a(d0(), g.a(Y()), ExplainPlaybackHeaderPresenter$onBind$1.INSTANCE, new ExplainPlaybackHeaderPresenter$onBind$2(this));
        c.a(d0(), g.a(Y()), ExplainPlaybackHeaderPresenter$onBind$3.INSTANCE, new ExplainPlaybackHeaderPresenter$onBind$4(this));
        c.a(d0(), g.a(Y()), ExplainPlaybackHeaderPresenter$observeTopRight$1.INSTANCE, new ExplainPlaybackHeaderPresenter$observeTopRight$2(this));
    }
}
