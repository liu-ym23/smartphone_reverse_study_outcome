package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import vb6.g;
import yb6.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$7 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$7(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "setAudioSelect", "setAudioSelect(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r7) {
        Intrinsics.checkNotNullParameter(r7, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonObject r2 = new JsonObject();
        if (r7 == null) goto L9;
        JsonElement r3 = r7.get("enable");
        if (r3 == null) goto L9;
        boolean r4 = true;
        if (r3.getAsBoolean() != true) goto L9;
    L10:
        if (r7 == null) goto L14;
        JsonElement r5 = r7.get("count");
        if (r5 == null) goto L14;
        Integer r6 = Integer.valueOf(r5.getAsInt());
    L15:
        if (r7 == null) goto L20;
        JsonElement r8 = r7.get("source");
        if (r8 == null) goto L20;
        String r9 = r8.getAsString();
        if (r9 == null) goto L20;
    L21:
        ChorusJsbService.g("setAudioSelect, enable: " + r4 + ", selectCount: " + r6 + ", source: " + r9);
        if (r6 == null) goto L32;
        j1 r10 = r0.e();
        if (r10 == null) goto L32;
        cg6.a r11 = r10.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r11 == null) goto L32;
        g r12 = r11.O5();
        if (r12 == null) goto L32;
        e r13 = r12.j();
        if (r13 == null) goto L32;
        r13.b0(r4, r6.intValue(), new ArrayList(), r9);
    L32:
        return r2;
    L20:
        r9 = "RTCHorus";
    L14:
        r6 = null;
    L9:
        r4 = false;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
