package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "buttonType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("function_type2", "chorus");
        r0.put("function_type", "chorus");
        r0.put("play_mode", "music");
        r0.put("button_type", r4);
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L5;
        String r5 = "anchor";
    L6:
        r0.put("user_type", r5);
        j0.l().sendLog("livesdk_anchor_ksong_button_click", r0, new Object[]{IRoom.class});
        return;
    L5:
        r5 = "guest";
        goto L6
    }
}
