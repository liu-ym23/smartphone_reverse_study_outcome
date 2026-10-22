package com.bytedance.applet.provider.impl;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.im.bean.message.Message;
import java.util.Map;
import k5.j;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import l3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements jw3.a {
    public static final a a = null;
    public static final Gson b = null;

    /* JADX INFO: renamed from: com.bytedance.applet.provider.impl.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0059a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PlayStateEnum.values().length];
            r0[PlayStateEnum.PLAY_STATE_STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[PlayStateEnum.PLAY_STATE_PREPARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[PlayStateEnum.PLAY_STATE_PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[PlayStateEnum.PLAY_STATE_PLAYING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[PlayStateEnum.PLAY_STATE_FAIL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class b implements j {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public final void a(AppletMonitorableEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            r3.f("questionId", this.a);
            r3.f("botId", this.b);
            r3.f("conversationId", this.c);
            r3.f("applet_id", this.d);
        }

        public b(String r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new Gson();
    }

    @Override // jw3.a
    public final boolean k() {
        return d.b("msg_indication");
    }

    @Override // jw3.a
    public final jw3.b e(PlayStateEnum r3) {
        Intrinsics.checkNotNullParameter(r3, "playState");
        int r4 = C0059a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        String r5 = "stopped";
    L19:
        w4.c r0 = new w4.c(r5);
        return new jw3.b("tts_status_changed", GsonProtectorUtils.toJson(b, r0));
    L5:
        if (r4 != 2) goto L7;
        r5 = "prepare";
        goto L19
    L7:
        if (r4 != 3) goto L9;
        r5 = "paused";
        goto L19
    L9:
        if (r4 != 4) goto L11;
        r5 = "playing";
        goto L19
    L11:
        if (r4 != 5) goto L14;
        r5 = "fail";
        goto L19
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @Override // jw3.a
    public final void i(Long r1) {
        com.bytedance.ai.utils.j.a r2 = com.bytedance.ai.utils.j.b(r1);
        if (r2 == null) goto L8;
        com.bytedance.ai.utils.j.c r3 = r2.s;
        if (r3 == null) goto L9;
        r3.a();
        return;
    L9:
        return;
    }

    @Override // jw3.a
    public final jw3.b b(Message r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if (r11 == false) goto L5;
        String r12 = "loading";
    L6:
        String r6 = r12;
        int r13 = r10.getMessageStatusLocal();
        if (r13 != 20) goto L9;
    L18:
        String r7 = "receiving";
    L19:
        String r0 = r10.getMessageId();
        if (r0 != null) goto L22;
        String r3 = "";
    L23:
        String r1 = r10.getReplyId();
        if (r1 != null) goto L26;
        String r5 = "";
    L27:
        String r14 = r10.getContent();
        if (r14 != null) goto L30;
        r14 = "";
    L30:
        MessageIndication r15 = new MessageIndication(false, r3, "", r5, "text", r6, r7, r14);
        return new jw3.b("msg_indication", GsonProtectorUtils.toJson(b, r15));
    L26:
        r5 = r1;
        goto L27
    L22:
        r3 = r0;
        goto L23
    L9:
        if (r13 == 21) goto L16;
        if (r13 == 23) goto L14;
        String r16 = "receive_failed";
    L13:
        r7 = r16;
        goto L19
    L14:
        r16 = "interrupt";
        goto L13
    L16:
        if (com.larus.bmhome.chat.bean.d.j0(r10) == false) goto L18;
        r16 = "received";
        goto L13
    L5:
        r12 = "msg";
        goto L6
    }

    @Override // jw3.a
    public final jw3.b d(Message r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "message");
        int r0 = r11.getMessageStatusLocal();
        if (r0 != 10) goto L5;
        String r1 = "sending";
    L9:
        String r8 = r1;
        String r2 = r11.getMessageId();
        if (r2 != null) goto L16;
        String r4 = "";
    L17:
        String r13 = r11.getLocalMessageId();
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        if (r12 != null) goto L23;
        String r9 = "";
    L24:
        MessageIndication r3 = new MessageIndication(true, r4, r13, "", "text", "msg", r8, r9);
        return new jw3.b("msg_indication", GsonProtectorUtils.toJson(b, r3));
    L23:
        r9 = r12;
        goto L24
    L16:
        r4 = r2;
        goto L17
    L5:
        if (r0 != 11) goto L7;
        r1 = "success";
        goto L9
    L7:
        if (r0 == 13) goto L10;
        r1 = "failed";
        goto L9
    L10:
        r1 = "interrupt";
        goto L9
    }

    @Override // jw3.a
    public final void f(String r5, jw3.b r6) {
        Intrinsics.checkNotNullParameter(r5, "botId");
        Intrinsics.checkNotNullParameter(r6, "payload");
        JsonObject r1 = (JsonObject) GsonProtectorUtils.fromJson(b, r6.b, JsonObject.class);
        r1.addProperty("botId", r5);
        Lazy r7 = d.a;
        d.c(new l3.a(r6.a, r1, 4));
    }

    @Override // jw3.a
    public final void j(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "questionId");
        Intrinsics.checkNotNullParameter(r3, "botId");
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "appletId");
        com.bytedance.ai.monitor.b.d("applet_local_plugin_ack", new b(r2, r3, r4, r5));
    }

    @Override // jw3.a
    public final void g(Object r2, String r3, String r4, Long r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "eventParam");
        if ((r2 instanceof w4.b) == false) goto L5;
        w4.b r7 = (w4.b) r2;
    L6:
        if (r7 == null) goto L9;
        r7.a(r3, r4, r5, r6);
        return;
    L9:
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // jw3.a
    public final void a(Object r1, String r2, String r3, String r4, Long r5, com.bytedance.applet.event.j r6) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "questionId");
        Intrinsics.checkNotNullParameter(r6, "responseCallback");
        if ((r1 instanceof w4.a) == false) goto L5;
        w4.a r7 = (w4.a) r1;
    L6:
        if (r7 == null) goto L9;
        r7.c(r2, r3, r4, r6);
        return;
    L9:
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // jw3.a
    public final void c(Object r15, String r16, String r17, String r18, String r19, String r20, Map r21, String r22, String r23, Long r24, Integer r25, com.bytedance.applet.event.j r26) {
        Intrinsics.checkNotNullParameter(r15, "listener");
        Intrinsics.checkNotNullParameter(r16, "botId");
        Intrinsics.checkNotNullParameter(r17, "conversationId");
        Intrinsics.checkNotNullParameter(r18, "mpAppId");
        Intrinsics.checkNotNullParameter(r19, "eventName");
        Intrinsics.checkNotNullParameter(r20, "data");
        Intrinsics.checkNotNullParameter(r22, "messageId");
        Intrinsics.checkNotNullParameter(r23, "questionId");
        Intrinsics.checkNotNullParameter(r26, "responseCallback");
        if ((r15 instanceof w4.a) == false) goto L5;
        w4.a r0 = (w4.a) r15;
    L6:
        w4.a r2 = r0;
        if (r2 == null) goto L10;
        r2.b(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        return;
    L10:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // jw3.a
    public final void h(Object r15, String r16, String r17, String r18, String r19, String r20, Map r21, String r22, String r23, Long r24, Integer r25, com.bytedance.applet.event.j r26) {
        Intrinsics.checkNotNullParameter(r15, "listener");
        Intrinsics.checkNotNullParameter(r16, "botId");
        Intrinsics.checkNotNullParameter(r17, "conversationId");
        Intrinsics.checkNotNullParameter(r18, "mpAppId");
        Intrinsics.checkNotNullParameter(r19, "apiName");
        Intrinsics.checkNotNullParameter(r20, "param");
        Intrinsics.checkNotNullParameter(r22, "messageId");
        Intrinsics.checkNotNullParameter(r23, "questionId");
        Intrinsics.checkNotNullParameter(r26, "responseCallback");
        if ((r15 instanceof w4.a) == false) goto L5;
        w4.a r0 = (w4.a) r15;
    L6:
        w4.a r2 = r0;
        if (r2 == null) goto L10;
        r2.a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        return;
    L10:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
