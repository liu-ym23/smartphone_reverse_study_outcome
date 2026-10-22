package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvJsbHandler$actionUpdateHandlers$23 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public KtvJsbHandler$actionUpdateHandlers$23(b r8) {
        super(1, r8, b.class, "notifySingStateChanged", "notifySingStateChanged(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r26) {
        Intrinsics.checkNotNullParameter(r26, "p1");
        b r2 = (b) ((CallableReference) this).receiver;
        int r3 = b.g;
        r2.getClass();
        JsonObject r7 = new JsonObject();
        JsonElement r8 = r26.get("sing_state");     // Catch: Throwable -> L34 Exception -> L36
        String r9 = null;
        if (r8 == null) goto L6;
        Integer r10 = Integer.valueOf(r8.getAsInt());     // Catch: Throwable -> L34 Exception -> L36
    L7:
        JsonElement r11 = r26.get("sing_play_progress");     // Catch: Throwable -> L34 Exception -> L36
        if (r11 == null) goto L10;
        long r13 = r11.getAsLong();     // Catch: Throwable -> L34 Exception -> L36
    L11:
        JsonElement r12 = r26.get("music_id");     // Catch: Throwable -> L34 Exception -> L36
        if (r12 == null) goto L14;
        String r14 = r12.getAsString();     // Catch: Throwable -> L34 Exception -> L36
    L15:
        JsonElement r15 = r26.get("extra_data");     // Catch: Throwable -> L34 Exception -> L36
        if (r15 == null) goto L18;
        JsonObject r16 = r15.getAsJsonObject();     // Catch: Throwable -> L34 Exception -> L36
    L19:
        JsonElement r17 = r26.get("room_id");     // Catch: Throwable -> L34 Exception -> L36
        if (r17 == null) goto L22;
        r9 = r17.getAsString();     // Catch: Throwable -> L34 Exception -> L36
    L22:
        JsonElement r18 = r26.get("current_time");     // Catch: Throwable -> L34 Exception -> L36
        if (r18 == null) goto L25;
        long r19 = r18.getAsLong();     // Catch: Throwable -> L34 Exception -> L36
    L26:
        long r110 = System.currentTimeMillis() - r19;     // Catch: Throwable -> L34 Exception -> L36
        if (r13 > 0) goto L29;
    L38:
        String r111 = "notifySingStateChanged exception: ";
        JsonObject r112 = r7;
    L39:
        long r6 = r13;
    L135:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvJsbHandler", "notifySingStateChanged, diff: " + r110 + ", source progress: " + r13 + ", target progress: " + r6);     // Catch: Throwable -> L34 Exception -> L84
        jd2.c r1 = r2.e.f();     // Catch: Throwable -> L34 Exception -> L84
        if (r1 == null) goto L86;
        if (r10 == null) goto L45;
        int r20 = r10.intValue();     // Catch: Throwable -> L34 Exception -> L84
    L46:
        if (r14 != null) goto L48;
        r14 = r1.c;     // Catch: Throwable -> L34 Exception -> L84
    L48:
        jd2.c.b r21 = r1.d;     // Catch: Throwable -> L34 Exception -> L84
        if (r16 == null) goto L53;
        JsonElement r113 = r16.get("is_singer");     // Catch: Throwable -> L34 Exception -> L84
        if (r113 == null) goto L53;
        boolean r114 = r113.getAsBoolean();     // Catch: Throwable -> L34 Exception -> L84
    L54:
        boolean r115 = r114;
        if (r16 == null) goto L59;
        JsonElement r116 = r16.get("ui_layout");     // Catch: Throwable -> L34 Exception -> L84
        if (r116 == null) goto L59;
        int r117 = r116.getAsInt();     // Catch: Throwable -> L34 Exception -> L84
    L60:
        int r22 = r117;
        if (r16 == null) goto L66;
        JsonElement r118 = r16.get("id_str");     // Catch: Throwable -> L34 Exception -> L84
        if (r118 == null) goto L66;
        String r119 = r118.getAsString();     // Catch: Throwable -> L34 Exception -> L84
        if (r119 == null) goto L66;
    L67:
        if (r16 == null) goto L72;
        JsonElement r120 = r16.get("lyric_url");     // Catch: Throwable -> L34 Exception -> L84
        if (r120 == null) goto L72;
        String r121 = r120.getAsString();     // Catch: Throwable -> L34 Exception -> L84
        if (r121 == null) goto L72;
    L73:
        if (r16 == null) goto L77;
        JsonElement r5 = r16.get("lyric_type");     // Catch: Throwable -> L34 Exception -> L84
        if (r5 == null) goto L77;
        int r23 = r5.getAsInt();     // Catch: Throwable -> L34 Exception -> L84
    L78:
        r21.getClass();     // Catch: Throwable -> L34 Exception -> L84
        Intrinsics.checkNotNullParameter(r119, "idStr");     // Catch: Throwable -> L34 Exception -> L84
        Intrinsics.checkNotNullParameter(r121, "lyricUrl");     // Catch: Throwable -> L34 Exception -> L84
        jd2.c.b r24 = new jd2.c.b(r115, r22, r119, r121, r23);     // Catch: Throwable -> L34 Exception -> L84
        JsonElement r0 = r26.get("room_id");     // Catch: Throwable -> L34 Exception -> L84
        if (r0 == null) goto L82;
        String r4 = r0.getAsString();     // Catch: Throwable -> L34 Exception -> L84
        if (r4 == null) goto L82;
    L83:
        r2.e.q(jd2.c.a(r20, r6, r14, r24, r4));     // Catch: Throwable -> L34 Exception -> L84
    L133:
        return r112;
    L82:
        r4 = r1.e;     // Catch: Throwable -> L34 Exception -> L84
    L77:
        r23 = r1.d.e;     // Catch: Throwable -> L34 Exception -> L84
    L72:
        r121 = r1.d.d;     // Catch: Throwable -> L34 Exception -> L84
    L66:
        r119 = r1.d.c;     // Catch: Throwable -> L34 Exception -> L84
    L59:
        r117 = r1.d.b;     // Catch: Throwable -> L34 Exception -> L84
    L53:
        r114 = r1.d.a;     // Catch: Throwable -> L34 Exception -> L84
        goto L54
    L45:
        r20 = r1.a;     // Catch: Throwable -> L34 Exception -> L84
        goto L46
    L86:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r25 = r2.e;     // Catch: Throwable -> L34 Exception -> L84
        if (r10 == null) goto L90;
        int r27 = r10.intValue();     // Catch: Throwable -> L34 Exception -> L84
    L92:
        if (r14 != null) goto L95;
        r14 = "";
    L95:
        if (r16 == null) goto L99;
        JsonElement r122 = r16.get("is_singer");     // Catch: Throwable -> L34 Exception -> L84
        if (r122 == null) goto L99;
        boolean r123 = r122.getAsBoolean();     // Catch: Throwable -> L34 Exception -> L84
    L100:
        if (r16 == null) goto L104;
        JsonElement r124 = r16.get("ui_layout");     // Catch: Throwable -> L34 Exception -> L84
        if (r124 == null) goto L104;
        int r28 = r124.getAsInt();     // Catch: Throwable -> L34 Exception -> L84
    L105:
        if (r16 == null) goto L112;
        JsonElement r125 = r16.get("id_str");     // Catch: Throwable -> L34 Exception -> L84
        if (r125 == null) goto L112;
        String r126 = r125.getAsString();     // Catch: Throwable -> L34 Exception -> L84
        if (r126 == null) goto L112;
        String r29 = r126;
    L113:
        if (r16 == null) goto L120;
        JsonElement r127 = r16.get("lyric_url");     // Catch: Throwable -> L34 Exception -> L84
        if (r127 == null) goto L120;
        String r128 = r127.getAsString();     // Catch: Throwable -> L34 Exception -> L84
        if (r128 == null) goto L120;
        String r210 = r128;
    L121:
        if (r16 == null) goto L125;
        JsonElement r30 = r16.get("lyric_type");     // Catch: Throwable -> L34 Exception -> L84
        if (r30 == null) goto L125;
        int r211 = r30.getAsInt();     // Catch: Throwable -> L34 Exception -> L84
    L126:
        jd2.c.b r212 = new jd2.c.b(r123, r28, r29, r210, r211);     // Catch: Throwable -> L34 Exception -> L84
        if (r9 != null) goto L129;
        String r129 = "";
    L130:
        r25.q(new jd2.c(r27, r6, r14, r212, r129));     // Catch: Throwable -> L34 Exception -> L84
        goto L133
    L129:
        r129 = r9;
    L125:
        r211 = 0;
    L120:
        r210 = "";
    L112:
        r29 = "";
    L104:
        r28 = 0;
    L99:
        r123 = false;
        goto L100
    L90:
        r27 = 0;
    L84:
        e = e;
    L132:
        w.a("KtvJsbHandler", r111 + e.getMessage());     // Catch: Throwable -> L34
        goto L133
    L29:
        if (r110 <= 0) goto L38;
        r111 = "notifySingStateChanged exception: ";
        r112 = r7;
        if (r110 >= ((Number) r2.a.getValue()).intValue()) goto L39;
        r6 = r13 + r110;
        goto L135
    L25:
        r19 = 0;
        goto L26
    L18:
        r16 = null;
        goto L19
    L14:
        r14 = null;
        goto L15
    L10:
        r13 = 0;
        goto L11
    L6:
        r10 = null;
    L34:
        th = move-exception;
        throw th;
    L36:
        e = e;
        r111 = "notifySingStateChanged exception: ";
        r112 = r7;
        goto L132
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
