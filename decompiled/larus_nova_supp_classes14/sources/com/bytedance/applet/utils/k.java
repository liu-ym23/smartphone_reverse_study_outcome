package com.bytedance.applet.utils;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.utils.p0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import m5.i1;
import m5.q0;
import m5.r0;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements com.bytedance.applet.event.n {
    public static final k a = null;

    public static final class a implements k5.j {
        public final /* synthetic */ Message a;

        public a(Message r1) {
            this.a = r1;
        }

        public final void a(AppletMonitorableEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            String r0 = this.a.getMessageId();
            if (r0 == null) goto L5;
            r4.f("message_id", r0);
        L5:
            String r1 = this.a.getReplyId();
            if (r1 == null) goto L8;
            r4.f("replyFor", r1);
        L8:
            r4.e("msgTime", this.a.getCreateTime());
            String r2 = "";
            if ((!AppHost.a.isTestChannel()) == true) goto L14;
            String r3 = this.a.getContent();
            if (r3 != null) goto L13;
            r3 = "";
        L13:
            r4.f("content", r3);
        L14:
            String r5 = this.a.getLocalMessageId();
            if (r5 == null) goto L18;
            r2 = r5;
        L18:
            r4.f("localMsgId", r2);
            r4.f("status", String.valueOf(this.a.getMessageStatusLocal()));
        }
    }

    public static final class b implements k5.j {
        public final /* synthetic */ Message a;

        public b(Message r1) {
            this.a = r1;
        }

        public final void a(AppletMonitorableEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            String r0 = this.a.getMessageId();
            if (r0 == null) goto L5;
            r4.f("message_id", r0);
        L5:
            String r1 = this.a.getReplyId();
            if (r1 == null) goto L8;
            r4.f("replyFor", r1);
        L8:
            r4.e("msgTime", this.a.getCreateTime());
            String r2 = "";
            if ((!AppHost.a.isTestChannel()) == true) goto L14;
            String r3 = this.a.getContent();
            if (r3 != null) goto L13;
            r3 = "";
        L13:
            r4.f("content", r3);
        L14:
            String r5 = this.a.getLocalMessageId();
            if (r5 == null) goto L18;
            r2 = r5;
        L18:
            r4.f("localMsgId", r2);
            r4.f("status", String.valueOf(this.a.getMessageStatus()));
        }
    }

    static {
        a = new k();
    }

    public k() {
    }

    @Override // com.bytedance.applet.event.n
    public final void a(String r9, Message r10) {
        Intrinsics.checkNotNullParameter(r9, "cid");
        Intrinsics.checkNotNullParameter(r10, "msg");
        if (r10.getMessageStatusLocal() != 11) goto L9;
        com.bytedance.ai.monitor.b.d("user_input", new a(r10));
        String r11 = r10.getMessageId();
        if (r11 == null) goto L27;
        i1 r12 = y0.a;
        Intrinsics.checkNotNullParameter(r11, "traceId");
        y0.r(new q0(r11, System.currentTimeMillis()));
        return;
    L27:
        return;
    L9:
        if (r10.getMessageStatusLocal() == 21) goto L11;
        return;
    L11:
        if (com.larus.bmhome.chat.bean.d.j0(r10) == false) goto L29;
        com.bytedance.ai.monitor.b.d("reply_message", new b(r10));
        String r3 = r10.getMessageId();
        String r4 = r10.getReplyId();
        LinkedHashMap r7 = new LinkedHashMap();
        Map r13 = r10.getExt();
        if (r13 == null) goto L23;
        String r14 = (String) r13.get("tea_tags_time_cost");
        if (r14 == null) goto L19;
        String r15 = p0.b(r14).optString("agent_tool");
        if (r15 == null) goto L19;
        r7.put("agent_tool", r15);
    L19:
        String r16 = (String) r13.get("is_dora");
        if (r16 != null) goto L22;
        r16 = "0";
    L22:
        r7.put("is_dora", r16);
    L23:
        if (r3 == null) goto L30;
        if (r4 == null) goto L31;
        i1 r17 = y0.a;
        Intrinsics.checkNotNullParameter(r3, "traceId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        y0.r(new r0(r3, r4, System.currentTimeMillis(), r7));
        return;
    L31:
        return;
    L30:
        return;
    }
}
