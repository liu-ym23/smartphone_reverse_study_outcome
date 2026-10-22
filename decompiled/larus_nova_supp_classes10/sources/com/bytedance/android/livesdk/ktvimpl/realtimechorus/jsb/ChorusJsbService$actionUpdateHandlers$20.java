package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import hg6.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$20 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$20(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "muteLocalAudio", "muteLocalAudio(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r2 = r5.get("reason");
        if (r2 == null) goto L6;
        String r3 = r2.getAsString();
        if (r3 == null) goto L6;
    L7:
        JsonElement r6 = r5.get("mute");
        if (r6 == null) goto L10;
        boolean r7 = r6.getAsBoolean();
    L11:
        ChorusJsbService.g("muteLocalAudio mute: " + r7 + ", source: " + r3);
        j1 r4 = r0.e();
        if (r4 == null) goto L22;
        cg6.a r8 = r4.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r8 == null) goto L22;
        g r9 = r8.getRtcManager();
        if (r9 == null) goto L22;
        ei6.a r10 = r9.V0();
        if (r10 == null) goto L22;
        ri6.b r11 = r10.r();
        if (r11 == null) goto L22;
        r11.s(bj6.a.b(r10), r7);
    L22:
        xe2.a.e(r7, r3);
        return new JsonObject();
    L10:
        r7 = true;
    L6:
        r3 = "";
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
