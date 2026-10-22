package com.bytedance.android.livesdk.livecommerce.playback.interaction;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackInteractionPresenter extends QFragmentPresenter {
    public final Lazy f;
    public InteractionAutoRecycleView g;

    public ExplainPlaybackInteractionPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ExplainPlaybackInteractionPresenter$viewModel$2(this));
    }

    public final void b0(QModel r4) {
        if (ECLiveABUtils.INSTANCE.getECOM_ENABLE_REPLAY_INTERACTION() == true) goto L5;
        return;
    L5:
        Z().g(0);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.d(80));
        r5.leftMargin = UtilityKotlinExtentionsKt.d(12);
        r5.rightMargin = UtilityKotlinExtentionsKt.d(80);
        r5.bottomMargin = UtilityKotlinExtentionsKt.d(8);
        this.g = new InteractionAutoRecycleView(Y().c());
        View r0 = a0();
        if ((r0 instanceof FrameLayout) == true) goto L8;
        r0 = null;
    L8:
        FrameLayout r1 = (FrameLayout) r0;
        if (r1 == null) goto L11;
        r1.addView(this.g, r5);
    L11:
        com.bytedance.android.ec.core.arch.state.c.a((ExplainPlaybackViewModel) this.f.getValue(), Y().e(), ExplainPlaybackInteractionPresenter$onBind$1.INSTANCE, new ExplainPlaybackInteractionPresenter$onBind$2(this));
        com.bytedance.android.ec.core.arch.event.c.c((ExplainPlaybackViewModel) this.f.getValue(), Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.b.class), new ExplainPlaybackInteractionPresenter$onBind$3(this));
    }
}
