package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedSimilaritySingScoringMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$9 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$9(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "openVoiceSimilarScore", "openVoiceSimilarScore(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(LiveWrappedSimilaritySingScoringMode.SING_SCORING_MODE_SPECTRAL_SIMILARITY, "<set-?>");
        if (r6 == null) goto L7;
        JsonElement r2 = r6.get("score_interval_ms");
        if (r2 == null) goto L7;
        int r3 = r2.getAsInt();
    L8:
        m r4 = o3.f().getRoom();
        String r5 = BDLocationException.ERROR_TIMEOUT;
        if (r4 == null) goto L14;
        IRoom r7 = (IRoom) r4.getValue();
        if (r7 == null) goto L14;
        String r8 = r7.getIdStr();
        if (r8 == null) goto L14;
    L15:
        if (r6 == null) goto L22;
        JsonElement r9 = r6.get("interactId");
        if (r9 == null) goto L22;
        String r10 = r9.getAsString();
        if (r10 == null) goto L22;
        r5 = r10;
    L22:
        LiveWrappedStreamIndex r11 = LiveWrappedStreamIndex.STREAM_INDEX_MAIN;
        Intrinsics.checkNotNullParameter(r8, "roomID");
        Intrinsics.checkNotNullParameter(r5, "userID");
        Intrinsics.checkNotNullParameter(r11, "streamIndex");
        ChorusJsbService.g("openVoiceSimilarScore, roomId: " + r8 + ", userId: " + r5 + ", Ms: " + r3);
        ei6.a r12 = r0.d();
        if (r12 == null) goto L28;
        ChorusManager r13 = r12.i();
        if (r13 == null) goto L28;
        r13.q();
    L28:
        return new JsonObject();
    L14:
        r8 = BDLocationException.ERROR_TIMEOUT;
    L7:
        r3 = 0;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
