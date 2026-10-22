package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$32 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$32(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "updateMixedChorusRole", "updateMixedChorusRole(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r6) {
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        boolean r2 = false;
        if (r6 == null) goto L7;
        JsonElement r3 = r6.get("role");
        if (r3 == null) goto L7;
        int r4 = r3.getAsInt();
    L8:
        if (r6 == null) goto L13;
        JsonElement r7 = r6.get("uid");
        if (r7 == null) goto L13;
        String r8 = r7.getAsString();
        if (r8 == null) goto L13;
    L15:
        if (r8.length() != 0) goto L17;
        r2 = true;
    L17:
        if (r2 == true) goto L35;
        if (r4 == 0) goto L28;
        if (r4 != 1) goto L21;
        zi6.a.d r5 = zi6.a.c.a;
    L29:
        ei6.a r9 = r0.d();
        if (r9 == null) goto L35;
        ChorusManager r10 = r9.i();
        if (r10 == null) goto L35;
        r10.H(r5, r8);
        goto L35
    L21:
        if (r4 != 2) goto L23;
        r5 = zi6.a.e.a;
        goto L29
    L23:
        if (r4 == 3) goto L25;
        r5 = zi6.a.d.a;
        goto L29
    L25:
        r5 = zi6.a.b.a;
        goto L29
    L28:
        r5 = zi6.a.d.a;
    L35:
        return new JsonObject();
    L13:
        r8 = "";
    L7:
        r4 = 0;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
