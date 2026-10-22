package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$46 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$46(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "muteAllRemoteAudioStreams", "muteAllRemoteAudioStreams(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r6) {
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonObject r2 = new JsonObject();
        if (r6 == null) goto L7;
        JsonElement r7 = r6.get("mute");
        if (r7 == null) goto L7;
        boolean r8 = r7.getAsBoolean();
    L8:
        m r3 = o3.f().getRoom();
        if (r3 == null) goto L14;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L14;
        String r5 = r4.getIdStr();
        if (r5 == null) goto L14;
    L15:
        ChorusJsbService.g("muteAllRemoteAudioStreams, mute: " + r8);
        ei6.a r9 = r0.d();
        if (r9 == null) goto L20;
        ri6.b r10 = r9.r();
        if (r10 == null) goto L20;
        r10.p(r5, r8, "chorus jsb call");
    L20:
        return r2;
    L14:
        r5 = BDLocationException.ERROR_TIMEOUT;
    L7:
        r8 = false;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
