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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$12 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$12(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "intiTuningInfo", "intiTuningInfo(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ChorusJsbService r5 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r0 = ChorusJsbService.l;
        j1 r1 = r5.e();
        if (r1 == null) goto L11;
        cg6.a r2 = r1.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r2 == null) goto L11;
        g r3 = r2.getRtcManager();
        if (r3 == null) goto L11;
        ec6.b r6 = r3.R();
        if (r6 == null) goto L11;
        d r7 = gc6.b.a(r6);
    L12:
        ChorusJsbService.g("intiTuningInfo, liveStream: " + r7);
        if (r7 == null) goto L24;
        ld2.a r8 = r5.f;
        if (r8 == null) goto L17;
        r8.destroy();
    L17:
        ld2.a r9 = r5.f;
        if (r9 == null) goto L20;
        r9.a(r7);
    L20:
        ld2.a r10 = r5.f;
        if (r10 == null) goto L24;
        r10.c();
    L24:
        return new JsonObject();
    L11:
        r7 = null;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
