package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.ies.sdk.widgets.DataCenter;
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
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$17 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$17(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "startRtcEngine", "startRtcEngine(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r2 = r6.get("is_auto_publish");
        boolean r3 = true;
        if (r2 == null) goto L5;
        boolean r4 = r2.getAsBoolean();
    L6:
        JsonElement r5 = r6.get("is_user_visible");
        if (r5 == null) goto L9;
        r3 = r5.getAsBoolean();
    L9:
        JsonElement r7 = r6.get("source");
        if (r7 == null) goto L13;
        String r8 = r7.getAsString();
        if (r8 == null) goto L13;
    L14:
        ChorusJsbService.g("startRtcEngine, isAutoPublish: " + r4 + ", isUserVisible: " + r3 + ", source: " + r8);
        j1 r9 = r0.e();
        if (r9 == null) goto L21;
        cg6.a r10 = r9.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r10 == null) goto L21;
        g r11 = r10.O5();
        if (r11 == null) goto L21;
        g.a.a(r11, r3, r4, r8);
    L21:
        xe2.a.k(r4, r3, r8);
        DataCenter r12 = r0.k;
        if (r12 == null) goto L25;
        r12.put(ChorusJsbDataContext.CMD_START_RTC_ENGINE, Boolean.TRUE);
    L25:
        return new JsonObject();
    L13:
        r8 = "";
        goto L14
    L5:
        r4 = true;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
