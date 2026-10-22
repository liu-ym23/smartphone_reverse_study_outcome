package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import android.os.SystemClock;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.utils.w0;
import com.ss.android.lark.chat.utils.x0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.perf.PerfMessageReceiveMonitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class o implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f414634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f414635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f414636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x0 f414637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m6b.u f414638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PerfMessageReceiveMonitor f414639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AndroidThrottle<Chat> f414640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f414641h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f414642i;

    public class a extends aqb.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<String, MessageInfo> f414643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f414644b;

        public a(o r100) {
            this.f414644b = r100;
            this.f414643a = new ConcurrentHashMap();
        }

        @Override // aqb.k
        public final void a(Chat r100) {
            if (this.f414644b.f414634a.equals(r100.getId()) == false) goto L6;
            o.a(this.f414644b).d(r100);
            return;
        }

        @Override // aqb.k
        public final void b(Chat r100) {
            if (com.ss.android.lark.chat.utils.h0.c(this.f414644b.f414634a, r100.getId()) == true) goto L5;
            return;
        L5:
            this.f414644b.f414635b.onPushChatRemoveMe(r100);
        }

        @Override // aqb.k
        public final void d(g1 r100) {
            MessageInfo r101 = r100.f410246a;
            h7b.l.e(r101);
            if (this.f414644b.f414634a.equals(r101.getMessage().getChatId()) == false) goto L15;
            if (this.f414644b.f414635b == null) goto L15;
            List<ReactionInfo> r102 = r101.getReactionInfoList();
            if (r102 == null) goto L9;
            int r103 = r102.size();
        L10:
            Log.i("ChatRelationPushHandler", "onPushMessage id:" + r101.getId() + ",reactionCount:" + r103);
            this.f414643a.put(r101.getId(), r101);
            ArrayList r104 = new ArrayList();
            r104.add(r101);
            Intrinsics.checkNotNullParameter(r101, "<this>");
            if (kkb.a.a(r101.getMessage()) == true) goto L13;
            this.f414644b.f414639f.a(r104);
        L13:
            this.f414644b.f414635b.onPushMessage(r104, false);
            CopyOnWriteArrayList<com.ss.android.lark.statistics.perf.a> r105 = com.ss.android.lark.statistics.perf.b.f440768a;
            com.ss.android.lark.statistics.perf.b.a(this.f414644b.f414634a, r101, SystemClock.elapsedRealtime());
            goto L15
        L9:
            r103 = 0;
        L15:
            if (r101.getMessage().getStreamStatus() == MessageStreamStatus.Transport) goto L17;
            o.a(this.f414644b).d(r100.f410247b);
            return;
        L17:
            Log.i("ChatRelationPushHandler", "message streaming, id:" + r101.getId());
            if ((r101.getMessage().getContent() instanceof PostContent) == false) goto L22;
            Log.i("ChatRelationPushHandler", "message streaming, RichText:" + com.ss.android.lark.widget.richtext.i.l(((PostContent) r101.getMessage().getContent()).getRichText()));
            return;
        }

        @Override // aqb.k
        public final void f(final PushMessageReactions r100) {
            if (com.ss.android.lark.chat.utils.h0.c(this.f414644b.f414634a, r100.chat_id) == true) goto L5;
            return;
        L5:
            CoreThreadPool.getBackgroundHandler().post(new l(this, r100));
        }

        @Override // aqb.k
        public final void g(final PushMessageReadStates r100) {
            CoreThreadPool.getBackgroundHandler().postDelayed(new k(this, r100), 300);
        }

        @Override // aqb.k
        public final void c(Chat r100, Map<String, ? extends Chatter> r101) {
            if (com.ss.android.lark.chat.utils.h0.c(this.f414644b.f414634a, r100.getId()) == true) goto L5;
            return;
        L5:
            this.f414644b.f414635b.onPushChatRemoveChatters(r100, r101);
        }
    }

    public class b implements com.ss.android.lark.chat.service.impl.g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f414645a;

        public b(o r100) {
            this.f414645a = r100;
        }

        @Override // com.ss.android.lark.chat.service.impl.g0
        public final void c(MessageInfo r100) {
            o r101 = this.f414645a;
            if (Objects.equals(r101.f414634a, r100.getMessage().getChatId()) == true) goto L5;
            return;
        L5:
            if (r101.f414635b == null) goto L9;
            ArrayList r102 = new ArrayList();
            r102.add(r100);
            r101.f414635b.onPushMessage(r102, true);
            return;
        }
    }

    public interface c {
        MessageInfo getMessageById(String r100);
    }

    public interface d {
        void onPushChat(Chat r100);

        void onPushChatRemoveChatters(Chat r100, Map<String, ? extends Chatter> r101);

        void onPushChatRemoveMe(Chat r100);

        void onPushMessage(List<MessageInfo> r100, boolean r101);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        x0 r100 = this.f414637d;
        String r101 = String.valueOf(hashCode());
        String r102 = this.f414634a;
        a r103 = this.f414641h;
        r100.f416749a.W1(r101, r102, new w0(r103));
        this.f414638e.K3(this.f414642i);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        x0 r100 = this.f414637d;
        String r101 = String.valueOf(hashCode());
        String r102 = this.f414634a;
        r100.f416749a.V(r101, r102);
        this.f414638e.kd(this.f414642i);
        this.f414639f.f440758d.clear();
    }

    public static AndroidThrottle a(final o r100) {
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (r100.f414640g != null) goto L6;
        AndroidThrottle.a r101 = new AndroidThrottle.a();     // Catch: Throwable -> L9
        r101.f285878b = 300;     // Catch: Throwable -> L9
        r101.f285877a = CoreThreadPool.getNonblockingHandler();     // Catch: Throwable -> L9
        r101.f285880d = new com.ss.android.lark.chat.chatwindow.chat.model.push.a();     // Catch: Throwable -> L9
        r101.f285881e = new j(r100);     // Catch: Throwable -> L9
        r100.f414640g = r101.a();     // Catch: Throwable -> L9
    L6:
        AndroidThrottle<Chat> r102 = r100.f414640g;     // Catch: Throwable -> L9
        monitor-exit(r100);
        return r102;
    }

    public o(Chat r100, x0 r101, m6b.u r102, d r103, c r104) {
        this.f414641h = new a(this);
        this.f414642i = new b(this);
        this.f414634a = r100.getId();
        this.f414637d = r101;
        this.f414638e = r102;
        this.f414635b = r103;
        this.f414636c = r104;
        this.f414639f = new PerfMessageReceiveMonitor(r100);
    }
}
