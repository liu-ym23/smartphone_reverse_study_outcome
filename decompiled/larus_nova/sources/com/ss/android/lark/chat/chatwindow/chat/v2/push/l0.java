package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2.MessageListViewModelV2;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.service.impl.k2;
import com.ss.android.lark.chat.utils.w0;
import com.ss.android.lark.chat.utils.x0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.perf.PerfMessageReceiveMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class l0 implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f414605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f414606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile ThreadTopic f414607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o.d f414608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f414609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o.c f414610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x0 f414611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m6b.u f414612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PerfMessageReceiveMonitor f414613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m6b.q f414614j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final x4b.d f414615k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AndroidThrottle<Chat> f414616l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AndroidThrottle<ThreadTopic> f414617m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f414618n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f414619o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f414620p;

    public class a extends aqb.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<String, MessageInfo> f414621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l0 f414622b;

        public a(l0 r100) {
            this.f414622b = r100;
            this.f414621a = new ConcurrentHashMap();
        }

        @Override // aqb.k
        public final void a(Chat r100) {
            if (this.f414622b.f414605a.equals(r100.getId()) == false) goto L15;
            final l0 r101 = this.f414622b;
            monitor-enter(r101);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (r101.f414616l != null) goto L9;
            AndroidThrottle.a r102 = new AndroidThrottle.a();     // Catch: Throwable -> L12
            r102.f285878b = 300;     // Catch: Throwable -> L12
            r102.f285877a = CoreThreadPool.getNonblockingHandler();     // Catch: Throwable -> L12
            r102.f285880d = new com.ss.android.lark.chat.chatwindow.chat.model.push.a();     // Catch: Throwable -> L12
            r102.f285881e = new f0(r101);     // Catch: Throwable -> L12
            r101.f414616l = new AndroidThrottle(r102);     // Catch: Throwable -> L12
        L9:
            AndroidThrottle<Chat> r103 = r101.f414616l;     // Catch: Throwable -> L12
            monitor-exit(r101);
            r103.d(r100);
            return;
        }

        @Override // aqb.k
        public final void b(Chat r100) {
            if (com.ss.android.lark.chat.utils.h0.c(this.f414622b.f414605a, r100.getId()) == true) goto L5;
            return;
        L5:
            this.f414622b.f414608d.onPushChatRemoveMe(r100);
        }

        @Override // aqb.k
        public final void d(g1 r100) {
            MessageInfo r101 = r100.f410246a;
            h7b.l.e(r101);
            boolean r102 = true;
            if (this.f414622b.f414605a.equals(r101.getMessage().getChatId()) == false) goto L19;
            l0 r103 = this.f414622b;
            String r104 = r101.getMessage().getThreadId();
            String r105 = r103.f414606b;
            if (r105 == null) goto L7;
            boolean r106 = Objects.equals(r104, r105);
        L8:
            if (r106 == false) goto L19;
            if (this.f414622b.f414608d == null) goto L19;
            List<ReactionInfo> r107 = r101.getReactionInfoList();
            if (r107 == null) goto L14;
            int r108 = r107.size();
        L15:
            Log.i("ThreadDetailPushHandler", "onPushMessage id:" + r101.getId() + ",reactionCount:" + r108);
            this.f414621a.put(r101.getId(), r101);
            ArrayList r109 = new ArrayList();
            r109.add(r101);
            Intrinsics.checkNotNullParameter(r101, "<this>");
            if (kkb.a.a(r101.getMessage()) == true) goto L18;
            this.f414622b.f414613i.a(r109);
        L18:
            this.f414622b.f414608d.onPushMessage(r109, false);
            CopyOnWriteArrayList<com.ss.android.lark.statistics.perf.a> r110 = com.ss.android.lark.statistics.perf.b.f440768a;
            com.ss.android.lark.statistics.perf.b.a(this.f414622b.f414605a, r101, SystemClock.elapsedRealtime());
            goto L19
        L14:
            r108 = 0;
            goto L15
        L7:
            r106 = true;
        L19:
            ThreadTopic r111 = r100.f410248c;
            if (r111 == null) goto L27;
            l0 r112 = this.f414622b;
            String r113 = r111.getId();
            String r114 = r112.f414606b;
            if (r114 == null) goto L24;
            r102 = Objects.equals(r113, r114);
        L24:
            if (r102 == false) goto L28;
            this.f414622b.a(r111);
            return;
        L28:
            return;
        }

        @Override // aqb.k
        public final void f(final PushMessageReactions r100) {
            if (com.ss.android.lark.chat.utils.h0.c(this.f414622b.f414605a, r100.chat_id) == true) goto L5;
            return;
        L5:
            CoreThreadPool.getBackgroundHandler().post(new h0(this, r100));
        }

        @Override // aqb.k
        public final void g(final PushMessageReadStates r100) {
            CoreThreadPool.getBackgroundHandler().postDelayed(new i0(this, r100), 300);
        }

        @Override // aqb.k
        public final void h(ThreadTopic r100) {
            this.f414622b.a(r100);
        }

        @Override // aqb.k
        public final void c(Chat r100, Map<String, ? extends Chatter> r101) {
            if (com.ss.android.lark.chat.utils.h0.c(this.f414622b.f414605a, r100.getId()) == true) goto L5;
            return;
        L5:
            this.f414622b.f414608d.onPushChatRemoveChatters(r100, r101);
        }
    }

    public class b implements k2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l0 f414623a;

        public b(l0 r100) {
            this.f414623a = r100;
        }

        @Override // com.ss.android.lark.chat.service.impl.k2.b
        public final void a(JSONObject r100) {
            final l0 r101 = this.f414623a;
            r101.getClass();
            if (r100 == null) goto L31;
            final n5b.a r102 = (n5b.a) r100.get(MonitorConstants.EXTRA_DOWNLOAD_THREAD_INFO);     // Catch: Exception -> L21 JSONException -> L23
            if (r102 == null) goto L26;
            ThreadTopic r103 = r102.f518077b;     // Catch: Exception -> L21 JSONException -> L23
            if (r103 == null) goto L26;
            if (Objects.equals(r101.f414606b, r103.getId()) == false) goto L26;
            Log.i("ThreadDetailPushHandler", "onPushThreads:" + r102.getId());     // Catch: Exception -> L21 JSONException -> L23
            if (r102.isNoTraceDelete() == false) goto L17;
            Log.i("ThreadDetailPushHandler", "get no trace delete push");     // Catch: Exception -> L21 JSONException -> L23
            goto L26
        L17:
            if (r101.f414607c != null) goto L19;
            Log.i("ThreadDetailPushHandler", "origin thread is null");     // Catch: Exception -> L21 JSONException -> L23
            goto L26
        L19:
            r101.f414615k.execute(new g0(r101, r102));     // Catch: Exception -> L21 JSONException -> L23
        L26:
            return;
        L23:
            e = move-exception;
            e.printStackTrace();
            return;
        L21:
            e = move-exception;
            e.printStackTrace();
            return;
        }
    }

    public class c implements com.ss.android.lark.chat.service.impl.g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l0 f414624a;

        public c(l0 r100) {
            this.f414624a = r100;
        }

        @Override // com.ss.android.lark.chat.service.impl.g0
        public final void c(MessageInfo r100) {
            l0 r101 = this.f414624a;
            if (Objects.equals(r101.f414605a, r100.getMessage().getChatId()) == false) goto L13;
            String r102 = r100.getMessage().getThreadId();
            String r103 = r101.f414606b;
            if (r103 == null) goto L7;
            boolean r104 = Objects.equals(r102, r103);
        L8:
            if (r104 == true) goto L10;
            return;
        L10:
            if (r101.f414608d == null) goto L15;
            ArrayList r105 = new ArrayList();
            r105.add(r100);
            r101.f414608d.onPushMessage(r105, true);
            return;
        L15:
            return;
        L7:
            r104 = true;
            goto L8
        }
    }

    public interface d {
        MessageInfo getTopicMessageInfo();

        void onPushThreadTopic(ThreadTopic r100);

        void onPushUpdateThreadInfo(n5b.a r100);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        x0 r100 = this.f414611g;
        String r101 = String.valueOf(hashCode());
        String r102 = this.f414605a;
        a r103 = this.f414618n;
        r100.f416749a.W1(r101, r102, new w0(r103));
        this.f414612h.K3(this.f414620p);
        this.f414614j.G1(this.f414619o);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        x0 r100 = this.f414611g;
        String r101 = String.valueOf(hashCode());
        String r102 = this.f414605a;
        r100.f416749a.V(r101, r102);
        this.f414612h.kd(this.f414620p);
        this.f414614j.Ia(this.f414619o);
        this.f414613i.f440758d.clear();
    }

    public final void a(final ThreadTopic r100) {
        if (TextUtils.equals(this.f414606b, r100.getId()) == true) goto L5;
        return;
    L5:
        this.f414615k.execute(new e0(this, r100));
    }

    public l0(Chat r100, ThreadTopic r101, x0 r102, m6b.u r103, m6b.q r104, x4b.d r105, o.d r106, d r107, MessageListViewModelV2.s r110) {
        this.f414618n = new a(this);
        this.f414619o = new b(this);
        this.f414620p = new c(this);
        this.f414605a = r100.getId();
        this.f414607c = r101;
        if (r101 == null) goto L5;
        String r108 = r101.getId();
    L6:
        this.f414606b = r108;
        this.f414611g = r102;
        this.f414612h = r103;
        this.f414614j = r104;
        this.f414615k = r105;
        this.f414608d = r106;
        this.f414609e = r107;
        this.f414610f = r110;
        this.f414613i = new PerfMessageReceiveMonitor(r100);
        AndroidThrottle.a r109 = new AndroidThrottle.a();
        r109.f285877a = CoreThreadPool.getNonblockingHandler();
        r109.f285878b = 100;
        r109.f285881e = new d0(this);
        this.f414617m = new AndroidThrottle(r109);
        return;
    L5:
        r108 = null;
        goto L6
    }
}
