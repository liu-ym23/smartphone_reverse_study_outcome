package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;
import xe2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ JsonObject b;

    public d(b r1, JsonObject r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        KtvMusic r11 = (KtvMusic) r10;
        JsonObject r0 = this.b;
        boolean r1 = false;
        if (r0 == null) goto L7;
        JsonElement r2 = r0.get("enable_mixer");
        if (r2 == null) goto L7;
        boolean r3 = r2.getAsBoolean();
    L8:
        JsonObject r4 = this.b;
        if (r4 == null) goto L13;
        JsonElement r5 = r4.get("enable_ktv_accurate_progress");
        if (r5 == null) goto L13;
        r1 = r5.getAsBoolean();
    L13:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvJsbHandler", "setBGMMusic, music: " + r11 + ", enableMixer: " + r3 + ", enableKtvAccurateProgress: " + r1);
        if (r11 == null) goto L18;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b r6 = this.a.c();
        if (r6 == null) goto L18;
        r6.l(new com.bytedance.android.livesdk.ktvimpl.crossplatform.player.a(r11, r3, r1));
    L18:
        int r7 = g.a;
        String r8 = null;
        if (r11 == null) goto L21;
        String r9 = r11.getMIdStr();
    L22:
        if (r11 == null) goto L24;
        r8 = r11.getMTitle();
    L24:
        String r12 = r11.getOrderUserIdString();
        JSONObject r13 = new JSONObject();
        if (r9 == null) goto L27;
        r13.put("music_id", r9);
    L27:
        if (r8 == null) goto L29;
        r13.put("music_name", r8);
    L29:
        if (r12 == null) goto L31;
        r13.put("order_user_id", r12);
    L31:
        int r14 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.JoinChorus, "CreateMusicPlayer", 0, null, r13, 88);
        return;
    L21:
        r9 = null;
    L7:
        r3 = false;
        goto L8
    }
}
