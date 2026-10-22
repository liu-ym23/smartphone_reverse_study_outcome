package com.bytedance.applet.utils;

import com.bytedance.applet.event.EventDispatcher;
import com.larus.bmhome.chat.model.repo.a2;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PendingPushMessageQueue implements com.bytedance.applet.event.n {
    public static final Map<String, List<a>> a = null;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final List<a2> d;
        public final List<String> e;
        public final List<String> f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.d.hashCode()) * 31;
            List<String> r5 = this.e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            List<String> r8 = this.f;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "PendingMessages(botId=" + this.a + ", conversationId=" + this.b + ", questionId=" + this.c + ", messageContents=" + this.d + ", suggests=" + this.e + ", suggestsV2=" + this.f + ')';
        }

        public a(String r2, String r3, String r4, List<a2> r5, List<String> r6, List<String> r7) {
            Intrinsics.checkNotNullParameter(r2, "botId");
            Intrinsics.checkNotNullParameter(r3, "conversationId");
            Intrinsics.checkNotNullParameter(r5, "messageContents");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public PendingPushMessageQueue() {
    }

    static {
        PendingPushMessageQueue r0 = new PendingPushMessageQueue();
        a = new ConcurrentHashMap();
        EventDispatcher r1 = EventDispatcher.a;
        Intrinsics.checkNotNullParameter(r0, "listener");
        EventDispatcher.h.add(r0);
    }

    @Override // com.bytedance.applet.event.n
    public final void a(String r7, Message r8) {
        Intrinsics.checkNotNullParameter(r7, "cid");
        Intrinsics.checkNotNullParameter(r8, "msg");
        FLogger.a.i("PendingPushMessageQueue", "onMessage msg id " + r8.getMessageId() + " replyId: " + r8.getReplyId() + " statusLocal " + r8.getMessageStatusLocal() + " msg ");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PendingPushMessageQueue$onMessage$1(r8, null), 3, null);
    }

    public static void b(String r12, String r13, String r14, List r15, List r16, List r17) {
        Intrinsics.checkNotNullParameter(r12, "botId");
        Intrinsics.checkNotNullParameter(r13, "conversationId");
        Intrinsics.checkNotNullParameter(r15, "messageContents");
        if (r14 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L14;
        FLogger.a.w("PendingPushMessageQueue", "questionId is null, botId " + r12 + " messageContents is " + r15);
        return;
    L14:
        if (((ArrayList) r15).isEmpty() == false) goto L17;
        FLogger.a.w("PendingPushMessageQueue", "questionId " + r14 + " botId " + r12 + " messageContents is empty, it is not create widget case?!");
        return;
    L17:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PendingPushMessageQueue$addMessage$1(r12, r13, r14, r15, r16, r17, null), 3, null);
        return;
    L5:
        if (r14.length() == 0) goto L8;
        r0 = false;
        goto L10
    }
}
