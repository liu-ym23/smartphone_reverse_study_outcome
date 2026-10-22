package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import vb6.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$16 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$16(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "initRTCAndLiveClient", "initRTCAndLiveClient(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r2 = r6.get("rtc_ext_info");
        String r3 = "";
        if (r2 == null) goto L6;
        String r4 = r2.getAsString();
        if (r4 == null) goto L6;
    L7:
        JsonElement r5 = r6.get("live_core_ext_info");
        if (r5 == null) goto L11;
        String r7 = r5.getAsString();
        if (r7 == null) goto L11;
    L12:
        JsonElement r8 = r6.get("source");
        if (r8 == null) goto L18;
        String r9 = r8.getAsString();
        if (r9 == null) goto L18;
        r3 = r9;
    L18:
        ChorusJsbService.g("initRTCAndLiveClient, rtcInfo: " + r4 + ", liveCoreInfo: " + r7 + ", source: " + r3);
        j1 r10 = r0.e();
        if (r10 == null) goto L25;
        cg6.a r11 = r10.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r11 == null) goto L25;
        g r12 = r11.O5();
        if (r12 == null) goto L25;
        r12.h1(r7, r4, r3);
    L25:
        xe2.a.d(r7, r4, r3);
        return new JsonObject();
    L11:
        r7 = "";
    L6:
        r4 = "";
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
