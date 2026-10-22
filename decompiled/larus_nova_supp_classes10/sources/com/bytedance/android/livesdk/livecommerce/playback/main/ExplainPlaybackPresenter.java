package com.bytedance.android.livesdk.livecommerce.playback.main;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.model.playback.LogExtraData;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackPresenter extends QFragmentPresenter {
    public final Lazy f;

    public ExplainPlaybackPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ExplainPlaybackPresenter$viewModel$2(this));
    }

    public final void b0(QModel r4) {
        b r5 = ((ExplainPlaybackViewModel) this.f.getValue()).getExplainPlaybackOriginParams();
        if (r5 == null) goto L7;
        LogExtraData r6 = r5.d;
        if (r6 == null) goto L7;
        String r7 = r6.getEnterScene();
    L9:
        if (ExplainPlaybackUtils.d() == false) goto L11;
    L13:
        boolean r8 = false;
    L14:
        if (r8 == false) goto L17;
        bj2.a.b("ExplainPlaybackPresenter", "initMultiCardsView");
        ((FrameLayout) Z().b(2131372698).f()).setVisibility(8);
        Z().b(2131367492).f().setVisibility(8);
        ((RelativeLayout) Z().b(2131367500).f()).setVisibility(8);
        ((FrameLayout) Z().b(2131372793).f()).setVisibility(0);
    L17:
        ExplainPlaybackViewModel r9 = (ExplainPlaybackViewModel) this.f.getValue();
        Fragment r0 = Y().a;
        if (r0 == null) goto L21;
        LifecycleOwner r1 = r0.getViewLifecycleOwner();
        if (r1 == null) goto L21;
    L22:
        com.bytedance.android.ec.core.arch.state.c.a(r9, r1, ExplainPlaybackPresenter$onBind$1.INSTANCE, new ExplainPlaybackPresenter$onBind$2(this));
        ExplainPlaybackViewModel r10 = (ExplainPlaybackViewModel) this.f.getValue();
        Fragment r2 = Y().a;
        if (r2 == null) goto L26;
        LifecycleOwner r3 = r2.getViewLifecycleOwner();
        if (r3 == null) goto L26;
    L27:
        com.bytedance.android.ec.core.arch.state.c.a(r10, r3, ExplainPlaybackPresenter$onBind$3.INSTANCE, new ExplainPlaybackPresenter$onBind$4(this));
        com.bytedance.android.ec.core.arch.event.c.c((ExplainPlaybackViewModel) this.f.getValue(), com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), Reflection.getOrCreateKotlinClass(a.C0082a.class), new ExplainPlaybackPresenter$onBind$5(this));
        return;
    L26:
        r3 = Y().e();
    L21:
        r1 = Y().e();
        goto L22
    L11:
        if (ExplainPlaybackUtils.e(r7) == true) goto L13;
        r8 = true;
    L7:
        r7 = null;
        goto L9
    }
}
