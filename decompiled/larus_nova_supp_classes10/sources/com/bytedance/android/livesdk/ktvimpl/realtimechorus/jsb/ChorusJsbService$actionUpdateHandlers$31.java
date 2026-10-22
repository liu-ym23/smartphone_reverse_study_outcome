package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$31 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$31(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "updateMixStreamConfigForPcChorus", "updateMixStreamConfigForPcChorus(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r10) {
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        if (r10 == null) goto L8;
        JsonElement r2 = r10.get("lead_singer_rtc_uid");
        if (r2 == null) goto L8;
        String r3 = r2.getAsString();
        if (r3 == null) goto L8;
    L9:
        if (r10 == null) goto L13;
        JsonElement r4 = r10.get("base_stream_start_delay_ms");
        if (r4 == null) goto L13;
        int r7 = r4.getAsInt();
    L14:
        if (r10 == null) goto L18;
        JsonElement r11 = r10.get("stream_index");
        if (r11 == null) goto L18;
        int r12 = r11.getAsInt();
    L19:
        LiveWrappedStreamIndex r5 = LiveWrappedStreamIndex.STREAM_INDEX_MAIN;
        if (r12 == r5.value()) goto L25;
        LiveWrappedStreamIndex r6 = LiveWrappedStreamIndex.STREAM_INDEX_3RD;
        if (r12 != r6.value()) goto L25;
        LiveWrappedStreamIndex r8 = r6;
    L26:
        ChorusJsbService.g("UpdateMixStreamConfigForPcChorus leadSingerRtcUid ".concat(r3));
        ei6.a r13 = r0.d();
        if (r13 == null) goto L37;
        ChorusManager r9 = r13.i();
        if (r9 == null) goto L37;
        m r14 = o3.f().getRoom();
        if (r14 == null) goto L35;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L35;
        String r16 = r15.getIdStr();
    L36:
        r9.F(false, BDLocationException.ERROR_TIMEOUT, String.valueOf(r16), r3, r7, r8);
    L35:
        r16 = null;
    L37:
        ei6.a r17 = r0.d();
        if (r17 == null) goto L43;
        ChorusManager r18 = r17.i();
        if (r18 == null) goto L43;
        r18.H(zi6.a.d.a, r3);
    L43:
        return new JsonObject();
    L25:
        r8 = r5;
    L18:
        r12 = 0;
    L13:
        r7 = MonitorLevel.FATAL;
    L8:
        r3 = "";
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
