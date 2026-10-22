package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioAlignmentMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zf2.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$35 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$35(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "setAudioAlignment", "setAudioAlignment(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r2 = r9.get("uid");
        if (r2 == null) goto L6;
        String r3 = r2.getAsString();
        if (r3 == null) goto L6;
    L7:
        JsonElement r4 = r9.get("mode");
        boolean r5 = false;
        if (r4 == null) goto L10;
        int r6 = r4.getAsInt();
    L11:
        if (r6 != 0) goto L13;
        LiveWrappedAudioAlignmentMode r7 = LiveWrappedAudioAlignmentMode.AUDIO_ALIGNMENT_MODE_OFF;
    L14:
        JsonElement r10 = r9.get("stream_index");
        if (r10 == null) goto L17;
        int r11 = r10.getAsInt();
    L18:
        LiveWrappedStreamIndex r8 = LiveWrappedStreamIndex.STREAM_INDEX_MAIN;
        if (r11 == r8.value()) goto L24;
        LiveWrappedStreamIndex r12 = LiveWrappedStreamIndex.STREAM_INDEX_3RD;
        if (r11 != r12.value()) goto L24;
        r8 = r12;
    L24:
        ChorusJsbService.g("setAudioAlignment, leaderUid: " + r3 + ", mode: " + r6 + ", alignmentMode: " + r7.value());
        if (r3.length() <= 0) goto L27;
        r5 = true;
    L27:
        if (r5 == false) goto L40;
        ei6.a r13 = r0.d();
        if (r13 == null) goto L33;
        si6.b r14 = r13.b();
        if (r14 == null) goto L33;
        String r15 = r14.m();
    L34:
        String r16 = String.valueOf(r15);
        ei6.a r17 = r0.d();
        if (r17 == null) goto L40;
        ri6.b r18 = r17.r();
        if (r18 == null) goto L40;
        r18.j(new k0(r16, r3, r8), r7);
    L33:
        r15 = null;
    L40:
        return new JsonObject();
    L17:
        r11 = 0;
        goto L18
    L13:
        r7 = LiveWrappedAudioAlignmentMode.AUDIO_ALIGNMENT_MODE_AUDIOMIXING;
        goto L14
    L10:
        r6 = 0;
    L6:
        r3 = "";
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
