package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import hg6.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import xi6.c;
import zf2.l0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$21 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$21(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "setRemoteVideoConfig", "setRemoteVideoConfig(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r8) {
        Intrinsics.checkNotNullParameter(r8, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r2 = r8.get("interactId");
        if (r2 == null) goto L5;
        String r3 = r2.getAsString();
    L6:
        JsonElement r4 = r8.get("width");
        if (r4 == null) goto L9;
        int r5 = r4.getAsInt();
    L10:
        JsonElement r6 = r8.get("height");
        if (r6 == null) goto L13;
        int r7 = r6.getAsInt();
    L14:
        JsonElement r9 = r8.get("frame_rate");
        if (r9 == null) goto L17;
        int r10 = r9.getAsInt();
    L18:
        ChorusJsbService.g("setRemoteVideoConfig, width: " + r5 + ", height: " + r7 + ", frameRate: " + r10);
        j1 r11 = r0.e();
        if (r11 == null) goto L30;
        cg6.a r12 = r11.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r12 == null) goto L30;
        g r13 = r12.getRtcManager();
        if (r13 == null) goto L30;
        ei6.a r14 = r13.V0();
        if (r14 == null) goto L30;
        c r15 = r14.t();
        if (r15 == null) goto L30;
        r15.i(bj6.a.b(r14), r3, LiveWrappedStreamIndex.STREAM_INDEX_MAIN, new l0(r5, r7, r10));
    L30:
        return new JsonObject();
    L17:
        r10 = 15;
        goto L18
    L13:
        r7 = 1280;
        goto L14
    L9:
        r5 = 720;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
