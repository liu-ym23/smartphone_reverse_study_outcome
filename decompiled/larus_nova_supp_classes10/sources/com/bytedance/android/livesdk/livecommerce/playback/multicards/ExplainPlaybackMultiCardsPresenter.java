package com.bytedance.android.livesdk.livecommerce.playback.multicards;

import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.playback.AuthorInfo;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.playback.model.ExplainPlaybackFinalParams;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackMultiCardsPresenter extends QFragmentPresenter {
    public FrameLayout f;
    public tk.a g;
    public final Lazy h;

    public final ExplainPlaybackViewModel e0() {
        return (ExplainPlaybackViewModel) this.h.getValue();
    }

    public final void c0() {
        tk.a r0 = this.g;
        if (r0 == null) goto L5;
        r0.onUnload();
    L5:
        this.g = null;
    }

    public ExplainPlaybackMultiCardsPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.h = LazyKt.lazy(new ExplainPlaybackMultiCardsPresenter$viewModel$2(this));
    }

    public final void b0(QModel r4) {
        FrameLayout r5 = (FrameLayout) Z().b(2131372793).f();
        this.f = r5;
        r5.setVisibility(0);
        com.bytedance.android.ec.core.arch.state.c.a(e0(), g.a(Y()), ExplainPlaybackMultiCardsPresenter$onBind$1.INSTANCE, new ExplainPlaybackMultiCardsPresenter$onBind$2(this));
    }

    public final Map<String, String> d0(String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        ExplainPlaybackFinalParams r1 = e0().getExplainPlaybackFinalFinalParams();
        if (r1 == null) goto L9;
        AuthorInfo r2 = r1.getUserInfo();
        if (r2 == null) goto L9;
        if ((r2 instanceof AuthorInfo) == false) goto L9;
        r0.put("follow_status", String.valueOf(r2.getFollowStatus()));
    L9:
        if (r4 == null) goto L13;
        JSONObject r5 = com.bytedance.android.livesdk.livecommerce.playback.main.c.c(r4);
        if (r5 == null) goto L13;
        r0.putAll(z1.j(r5));
    L13:
        return r0;
    }
}
