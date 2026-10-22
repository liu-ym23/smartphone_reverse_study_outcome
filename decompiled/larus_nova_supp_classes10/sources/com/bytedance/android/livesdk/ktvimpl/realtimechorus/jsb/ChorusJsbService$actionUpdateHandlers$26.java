package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.e;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$26 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$26(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "setUserMixStreamVolume", "setUserMixStreamVolume(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r2 = r5.get("volume");
        if (r2 == null) goto L5;
        int r3 = r2.getAsInt();
    L6:
        JsonElement r6 = r5.get("rtc_uid");
        if (r6 == null) goto L10;
        String r7 = r6.getAsString();
        if (r7 == null) goto L10;
    L11:
        e r4 = r0.d;
        if (r4 == null) goto L15;
        Intrinsics.checkNotNullParameter(r7, "interactId");
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusMixStreamVolumeService", "setUserMixStreamVolume: " + r7 + ", " + r3);
        r4.b.put(r7, Integer.valueOf(r3));
    L15:
        return new JsonObject();
    L10:
        r7 = "";
        goto L11
    L5:
        r3 = 100;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
