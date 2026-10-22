package com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior;

import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.voicechat.toolbar.ToolbarInteractRoomBehavior;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ToolbarInteractKtvRoomBehavior extends ToolbarInteractRoomBehavior {
    public final void onMessage(d r1) {
    }

    public ToolbarInteractKtvRoomBehavior() {
    }

    public final void onClick(View r5) {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r6 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r6 == null) goto L5;
        r6.showInviteAndPermitDialog(false, "bottom", -1);
    L5:
        HashMap r7 = new HashMap();
        r7.put("action_type", "click");
        TalkRoomLogUtils.z0(r7, Integer.valueOf(je0.d.f()));
        j0.l().sendLog("livesdk_guest_connection_anchor", r7, new Object[]{IRoom.class});
    }
}
