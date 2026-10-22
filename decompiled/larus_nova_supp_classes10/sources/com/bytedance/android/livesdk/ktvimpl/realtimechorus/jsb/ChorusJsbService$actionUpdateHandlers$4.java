package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$4 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$4(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "setRemoteUserPlaybackVolume", "setRemoteUserPlaybackVolume(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonObject r2 = new JsonObject();
        Float r3 = null;
        if (r9 == null) goto L7;
        JsonElement r4 = r9.get("interactId");
        if (r4 == null) goto L7;
        String r5 = r4.getAsString();
    L8:
        if (r9 == null) goto L12;
        JsonElement r6 = r9.get("volume");
        if (r6 == null) goto L12;
        r3 = Float.valueOf(r6.getAsFloat());
    L12:
        boolean r7 = false;
        if (r9 == null) goto L17;
        JsonElement r10 = r9.get("stream_index");
        if (r10 == null) goto L17;
        int r11 = r10.getAsInt();
    L18:
        ChorusJsbService.g("setRemoteUserPlaybackVolume, interactId: " + r5 + ", volume: " + r3);
        LiveWrappedStreamIndex r8 = LiveWrappedStreamIndex.STREAM_INDEX_MAIN;
        if (r11 == r8.value()) goto L24;
        LiveWrappedStreamIndex r12 = LiveWrappedStreamIndex.STREAM_INDEX_3RD;
        if (r11 != r12.value()) goto L24;
        r8 = r12;
    L24:
        if (r5 != null) goto L26;
    L27:
        r7 = true;
    L28:
        if (r7 == true) goto L34;
        if (r3 == null) goto L34;
        float r13 = r3.floatValue() * KtvSettingHelper.d().e();
        ld2.b r14 = r0.g;
        if (r14 == null) goto L33;
        r14.d(r5, (int) r13, r8);
    L33:
        int r15 = xe2.a.a;
        xe2.a.h(r5, r13, r3.floatValue(), "jsb");
    L34:
        return r2;
    L26:
        if (r5.length() != 0) goto L28;
    L17:
        r11 = 0;
    L7:
        r5 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
