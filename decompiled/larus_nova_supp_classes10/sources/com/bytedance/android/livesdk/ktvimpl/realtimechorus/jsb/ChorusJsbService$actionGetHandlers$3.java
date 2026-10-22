package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.google.gson.JsonObject;
import hg6.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionGetHandlers$3 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionGetHandlers$3(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "getAudioDeviceModuleStats", "getAudioDeviceModuleStats(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ChorusJsbService r5 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r0 = ChorusJsbService.l;
        r5.getClass();
        JsonObject r1 = new JsonObject();
        j1 r6 = r5.e();
        if (r6 == null) goto L15;
        cg6.a r7 = r6.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r7 == null) goto L15;
        g r8 = r7.getRtcManager();
        if (r8 == null) goto L15;
        ec6.b r9 = r8.R();
        if (r9 == null) goto L15;
        d r10 = gc6.b.a(r9);
        if (r10 == null) goto L15;
        d0 r11 = r10.getLiveCore();
        if (r11 == null) goto L15;
        r11.h();
    L15:
        r1.addProperty("fps", Double.valueOf(0.0d));
        return r1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
