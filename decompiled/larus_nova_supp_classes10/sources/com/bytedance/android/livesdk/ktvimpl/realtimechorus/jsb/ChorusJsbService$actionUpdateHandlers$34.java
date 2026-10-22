package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.message.model.RTChorusOperateType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fd2.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$34 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$34(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "handleJoinChorusPermission", "handleJoinChorusPermission(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r8) {
        Intrinsics.checkNotNullParameter(r8, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r2 = r8.get("status_code");
        if (r2 == null) goto L5;
        int r3 = r2.getAsInt();
    L6:
        JsonElement r4 = r8.get(LocationMonitorConst.TYPE);
        if (r4 == null) goto L9;
        int r5 = r4.getAsInt();
    L10:
        JsonElement r6 = r8.get("music_id");
        String r7 = "";
        if (r6 == null) goto L14;
        String r9 = r6.getAsString();
        if (r9 == null) goto L14;
    L15:
        JsonElement r10 = r8.get("order_user_id");
        if (r10 == null) goto L21;
        String r11 = r10.getAsString();
        if (r11 == null) goto L21;
        r7 = r11;
    L21:
        RTChorusOperateType r12 = RTChorusOperateType.JOIN_CHORUS;
        if (r5 == r12.getValue()) goto L25;
        r12 = RTChorusOperateType.ORDER_SONG;
    L25:
        boolean r13 = true;
        if (r9.length() <= 0) goto L28;
        boolean r14 = true;
    L29:
        if (r14 == false) goto L39;
        if (r7.length() > 0) goto L34;
        r13 = false;
    L34:
        if (r13 == false) goto L39;
        d r15 = r0.h;
        if (r15 == null) goto L39;
        r15.a(r3, r12, r9, r7);
    L39:
        return new JsonObject();
    L28:
        r14 = false;
    L14:
        r9 = "";
        goto L15
    L9:
        r5 = 2;
        goto L10
    L5:
        r3 = 4004521;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
