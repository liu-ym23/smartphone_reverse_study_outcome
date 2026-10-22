package com.bytedance.android.livesdk.livecommerce.playback.authorinfo;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.ec.sdk.plugin.e;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ Context b;

    public b(c r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        e.getActivity(this.b).finish();
        this.a.b.setClosePageByUser(true);
        com.bytedance.android.livesdk.livecommerce.playback.main.b r6 = this.a.b.getExplainPlaybackOriginParams();
        if (r6 == null) goto L7;
        ExplainPlaybackRequest r7 = r6.a;
        if (r7 == null) goto L7;
        String r8 = r7.getAuthorId();
    L8:
        cj2.c r1 = cj2.a.a;
        HashMap r2 = new HashMap();
        r2.put("ecom_entrance_form", "replay_popup_card");
        if (r8 == null) goto L11;
        r2.put("anchor_id", r8);
    L11:
        cj2.a.a("livesdk_explain_replay_close", r2, null, null);
        return;
    L7:
        r8 = null;
        goto L8
    }
}
