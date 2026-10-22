package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import xi6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$45 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$45(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "updateUserSubscribeVideoStreamIndex", "updateUserSubscribeVideoStreamIndex(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r6) {
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        r0.getClass();
        if (r6 == null) goto L8;
        JsonElement r1 = r6.get("uid");
        if (r1 == null) goto L8;
        String r2 = r1.getAsString();
        if (r2 == null) goto L8;
    L9:
        if (r6 == null) goto L13;
        JsonElement r7 = r6.get("stream_index");
        if (r7 == null) goto L13;
        int r8 = r7.getAsInt();
    L14:
        ChorusJsbService.g("updateUserSubscribeVideoStreamIndex, leaderUid: " + r2 + ", stream: " + r8);
        LiveWrappedStreamIndex r3 = LiveWrappedStreamIndex.STREAM_INDEX_MAIN;
        if (r8 == r3.value()) goto L20;
        LiveWrappedStreamIndex r4 = LiveWrappedStreamIndex.STREAM_INDEX_3RD;
        if (r8 != r4.value()) goto L20;
        r3 = r4;
    L20:
        ei6.a r9 = r0.d();
        if (r9 == null) goto L28;
        c r10 = r9.t();
        if (r10 == null) goto L28;
        com.bytedance.live.livelink.kmp.impl.core.video.c r11 = r10.d();
        if (r11 == null) goto L28;
        r11.t(r2, r3);
    L28:
        return new JsonObject();
    L13:
        r8 = 0;
    L8:
        r2 = BDLocationException.ERROR_TIMEOUT;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
