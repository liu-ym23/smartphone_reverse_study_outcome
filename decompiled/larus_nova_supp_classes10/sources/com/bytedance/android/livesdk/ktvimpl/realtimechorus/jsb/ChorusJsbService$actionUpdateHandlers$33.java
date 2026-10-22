package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.sharedpref.c;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dg2.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$33 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$33(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "setCellularEnhancement", "setCellularEnhancement(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonObject r2 = new JsonObject();
        JsonElement r3 = r6.get("enhance_signaling");
        if (r3 == null) goto L5;
        boolean r4 = r3.getAsBoolean();
    L6:
        JsonElement r5 = r6.get("enhance_audio");
        if (r5 == null) goto L9;
        r5.getAsBoolean();
    L9:
        JsonElement r7 = r6.get("enhance_video");
        if (r7 == null) goto L12;
        r7.getAsBoolean();
    L12:
        JsonElement r8 = r6.get("enhance_screen_audio");
        if (r8 == null) goto L15;
        r8.getAsBoolean();
    L15:
        JsonElement r9 = r6.get("enhance_screen_video");
        if (r9 == null) goto L18;
        r9.getAsBoolean();
    L18:
        e r10 = c.N;
        Boolean r11 = Boolean.valueOf(r4);
        r10.getClass();
        f.d(r10, r11);
        ei6.a r12 = r0.d();
        if (r12 == null) goto L23;
        si6.b r13 = r12.b();
        if (r13 == null) goto L23;
        r13.l(new d(0));
    L23:
        return r2;
    L5:
        r4 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
