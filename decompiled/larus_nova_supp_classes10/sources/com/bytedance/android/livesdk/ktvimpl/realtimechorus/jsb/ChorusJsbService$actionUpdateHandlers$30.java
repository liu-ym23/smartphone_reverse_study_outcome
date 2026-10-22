package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.ChorusStreamMixService;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.d;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$30 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$30(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "updateMixedStreamConfig", "updateMixedStreamConfig(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r11) {
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        int r2 = 0;
        if (r11 == null) goto L7;
        JsonElement r3 = r11.get("is_accompanist");
        if (r3 == null) goto L7;
        boolean r4 = r3.getAsBoolean();
    L9:
        if (r11 == null) goto L14;
        JsonElement r5 = r11.get("sub_room_id");
        if (r5 == null) goto L14;
        String r6 = r5.getAsString();
        if (r6 == null) goto L14;
    L15:
        if (r11 == null) goto L22;
        JsonElement r7 = r11.get("lead_singer_rtc_uid");
        if (r7 == null) goto L22;
        String r8 = r7.getAsString();
        if (r8 == null) goto L22;
        String r9 = r8;
    L23:
        if (r11 == null) goto L27;
        JsonElement r10 = r11.get("base_stream_start_delay_ms");
        if (r10 == null) goto L27;
        int r12 = r10.getAsInt();
    L28:
        if (r11 == null) goto L32;
        JsonElement r13 = r11.get("stream_index");
        if (r13 == null) goto L32;
        r2 = r13.getAsInt();
    L32:
        LiveWrappedStreamIndex r14 = LiveWrappedStreamIndex.STREAM_INDEX_MAIN;
        if (r2 == r14.value()) goto L38;
        LiveWrappedStreamIndex r15 = LiveWrappedStreamIndex.STREAM_INDEX_3RD;
        if (r2 != r15.value()) goto L38;
        LiveWrappedStreamIndex r16 = r15;
    L39:
        ChorusJsbService.g("updateMixedStreamConfig isAccompanist " + r4 + " subRoomId " + r6 + " leadSingerRtcUid " + r9);
        ChorusStreamMixService r17 = r0.c;
        if (r17 == null) goto L57;
        Intrinsics.checkNotNullParameter(r6, "subRoomId");
        Intrinsics.checkNotNullParameter(r9, "leaderSingerRtcUid");
        Intrinsics.checkNotNullParameter(r16, "streamIndex");
        d r18 = new d(r9, r4, r6);
        r17.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "config");
        if (r4 == false) goto L50;
        m r19 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r19 == null) goto L48;
        IRoom r20 = (IRoom) r19.getValue();
        if (r20 == null) goto L48;
        String r21 = r20.getIdStr();
    L49:
        String r22 = String.valueOf(r21);
    L51:
        ei6.a r23 = r17.a();
        if (r23 == null) goto L57;
        ChorusManager r24 = r23.i();
        if (r24 == null) goto L57;
        r24.F(r4, String.valueOf(r17.b), r22, r9, r12, r16);
    L48:
        r21 = null;
        goto L49
    L50:
        r22 = r6;
    L57:
        return new JsonObject();
    L38:
        r16 = r14;
    L27:
        r12 = MonitorLevel.FATAL;
    L22:
        r9 = "";
    L14:
        r6 = "";
    L7:
        r4 = false;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
