package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ KtvComponentAudienceLogicWidget a;

    public d(KtvComponentAudienceLogicWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (((Boolean) r3) == null) goto L8;
        DataCenter r4 = ((Widget) this.a).dataCenter;
        if (r4 == null) goto L9;
        r4.put("cmd_ktv_component_hide_lyrics_when_subtitle_open_switch_status_change", Boolean.TRUE);
        return;
    L9:
        return;
    }
}
