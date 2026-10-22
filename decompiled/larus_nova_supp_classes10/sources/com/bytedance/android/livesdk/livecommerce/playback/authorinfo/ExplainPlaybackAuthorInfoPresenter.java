package com.bytedance.android.livesdk.livecommerce.playback.authorinfo;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.model.playback.LogExtraData;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackAuthorInfoPresenter extends QFragmentPresenter {
    public final Lazy f;

    public final ExplainPlaybackViewModel d0() {
        return (ExplainPlaybackViewModel) this.f.getValue();
    }

    public final void c0() {
        bj2.a.b("ExplainPlaybackAuthorInfoPresenter", "onUnBind");
    }

    public ExplainPlaybackAuthorInfoPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ExplainPlaybackAuthorInfoPresenter$viewModel$2(this));
    }

    public final void b0(QModel r6) {
        bj2.a.b("ExplainPlaybackAuthorInfoPresenter", "onBind");
        com.bytedance.android.livesdk.livecommerce.playback.main.b r0 = d0().getExplainPlaybackOriginParams();
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L7;
        LogExtraData r2 = r0.d;
        if (r2 == null) goto L7;
        String r3 = r2.getEnterScene();
    L9:
        if (ExplainPlaybackUtils.d() == true) goto L11;
    L14:
        final FrameLayout r7 = (FrameLayout) Z().b(2131367540).f();
        if (ExplainPlaybackUtils.e(r3) == true) goto L24;
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        r1 = r4;
    L21:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r1;
        if (r5 == null) goto L24;
        r5.width = -1;
        r5.topMargin = (int) UtilityKotlinExtentionsKt.c(8);
        r7.setLayoutParams(r5);
    L24:
        com.bytedance.android.ec.core.arch.state.c.a(d0(), g.a(Y()), ExplainPlaybackAuthorInfoPresenter$onBind$1.INSTANCE, new ExplainPlaybackAuthorInfoPresenter$onBind$2(this, r7));
        if (ExplainPlaybackUtils.e(r3) == true) goto L28;
        com.bytedance.android.ec.core.arch.state.c.a(d0(), g.a(Y()), ExplainPlaybackAuthorInfoPresenter$onBind$3.INSTANCE, new ExplainPlaybackAuthorInfoPresenter$onBind$4(this, r7));
        return;
    L28:
        return;
    L11:
        if (ExplainPlaybackUtils.e(r3) == true) goto L14;
        bj2.a.b("ExplainPlaybackAuthorInfoPresenter", "IsExpireZero or equals search");
        return;
    L7:
        r3 = null;
        goto L9
    }
}
