package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ KtvInteractElementWidget a;

    public o(KtvInteractElementWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        sh6.b r6 = (sh6.b) r5;
        KtvInteractElementWidget r0 = this.a;
        Object r1 = null;
        if (r6 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r7 = (com.bytedance.android.livesdk.ktvimpl.base.sei.a) sh6.c.b(r6);
    L7:
        if (r0.j != null) goto L27;
        pd2.d.n.getClass();
        pd2.d.w(LinkMonitorData.BusinessShowContribute, new JSONObject());
        if ((r7 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.n) == false) goto L28;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r2 = r0.r;
        if ((r2 instanceof View) == false) goto L16;
        r1 = r2;
    L16:
        View r3 = (View) r1;
        if (r3 == null) goto L19;
        r3.setVisibility(0);
    L19:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r4 = r0.r;
        if (r4 == null) goto L22;
        r4.F5((com.bytedance.android.livesdk.ktvimpl.base.sei.n) r7);
    L22:
        View r8 = r0.t;
        if (r8 == null) goto L25;
        r8.setVisibility(0);
    L25:
        ALogger.i("onSongFeedbackShow", "onSongFeedbackShow2:3000");
        com.bytedance.android.live.core.utils.i0.c().postDelayed(new x(r0), KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION);
        return;
    L28:
        return;
    L27:
        return;
    L5:
        r7 = null;
        goto L7
    }
}
