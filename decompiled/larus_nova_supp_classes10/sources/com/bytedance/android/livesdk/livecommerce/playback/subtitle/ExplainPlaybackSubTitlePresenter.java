package com.bytedance.android.livesdk.livecommerce.playback.subtitle;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackSubTitlePresenter extends QFragmentPresenter {
    public static final /* synthetic */ int g = 0;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public final ExplainPlaybackViewModel d0() {
        return (ExplainPlaybackViewModel) this.f.getValue();
    }

    public ExplainPlaybackSubTitlePresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ExplainPlaybackSubTitlePresenter$viewModel$2(this));
    }

    public final void b0(QModel r4) {
        if (d0().canEnableSubTitle() == true) goto L5;
        return;
    L5:
        c.a(d0(), Y().e(), ExplainPlaybackSubTitlePresenter$onBind$1.INSTANCE, new ExplainPlaybackSubTitlePresenter$onBind$2(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.m.class), new ExplainPlaybackSubTitlePresenter$onBind$3(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.b.class), new ExplainPlaybackSubTitlePresenter$onBind$4(this));
    }
}
