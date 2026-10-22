package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.JsonObject;
import hg6.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionGetHandlers$4 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionGetHandlers$4(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "getAudioRoute", "getAudioRoute(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ChorusJsbService r6 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r0 = ChorusJsbService.l;
        r6.getClass();
        JsonObject r1 = new JsonObject();
        j1 r7 = r6.e();
        int r2 = 0;
        if (r7 == null) goto L9;
        cg6.a r8 = r7.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r8 == null) goto L9;
        g r9 = r8.getRtcManager();
        if (r9 == null) goto L9;
        int r10 = r9.b();
    L11:
        if (r10 != 1) goto L13;
    L18:
        r2 = 1;
    L19:
        ChorusJsbService.g("getAudioRoute, audioRoute: " + r10 + ", type: " + r2);
        r1.addProperty(LocationMonitorConst.TYPE, Integer.valueOf(r2));
        return r1;
    L13:
        if (r10 != 4) goto L15;
        r2 = 2;
        goto L19
    L15:
        if (r10 == 5) goto L18;
    L9:
        r10 = 0;
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
