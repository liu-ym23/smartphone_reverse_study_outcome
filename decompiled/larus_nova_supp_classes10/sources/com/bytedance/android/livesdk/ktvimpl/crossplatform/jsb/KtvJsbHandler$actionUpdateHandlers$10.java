package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvJsbHandler$actionUpdateHandlers$10 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public KtvJsbHandler$actionUpdateHandlers$10(b r8) {
        super(1, r8, b.class, "sendSei", "sendSei(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r11) {
        Intrinsics.checkNotNullParameter(r11, "p1");
        final b r0 = (b) ((CallableReference) this).receiver;
        int r1 = b.g;
        r0.getClass();
        JsonObject r8 = new JsonObject();
        JsonElement r2 = r11.get("key");
        if (r2 == null) goto L5;
        String r3 = r2.getAsString();
    L6:
        final String r4 = r3;
        JsonElement r5 = r11.get("value");
        if (r5 == null) goto L10;
        String r6 = r5.getAsString();
        if (r6 == null) goto L10;
    L11:
        final String r7 = r6;
        JsonElement r9 = r11.get("send_times");
        boolean r10 = true;
        if (r9 == null) goto L14;
        final int r12 = r9.getAsInt();
    L15:
        JsonElement r13 = r11.get("key_frame_only");
        if (r13 != null) goto L18;
    L20:
        boolean r14 = false;
    L21:
        JsonElement r15 = r11.get("can_be_covered");
        if (r15 != null) goto L24;
    L26:
        boolean r16 = false;
    L28:
        if (r7.length() > 0) goto L31;
        r10 = false;
    L31:
        if (r10 == false) goto L33;
        final boolean r17 = r14;
        final boolean r18 = r16;
        UtilityKotlinExtentionsKt.b(r0, new KtvJsbHandler$sendSei$1(r0, r7, r4, r12, r17, r18));
    L33:
        return r8;
    L24:
        if (r15.getAsBoolean() != true) goto L26;
        r16 = true;
        goto L28
    L18:
        if (r13.getAsBoolean() != true) goto L20;
        r14 = true;
        goto L21
    L14:
        r12 = 1;
    L10:
        r6 = "";
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
