package sj4;

import com.bytedance.dora.bwdl.session.Session;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import pk4.l;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, a> f542290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f542291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f542292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f542293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Session f542294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f542295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f542296g;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DatagramSocket f542297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f542298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f542299c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile int f542300d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final InetAddress f542301e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final LinkedBlockingQueue<tj4.b> f542302f;

        public a(int r100, int r101, int r102, InetAddress r103) {
            this.f542298b = r100;
            this.f542299c = r101;
            this.f542300d = r102;
            this.f542301e = r103;
            this.f542302f = new LinkedBlockingQueue();
            DatagramSocket r104 = new DatagramSocket(r101, r103);     // Catch: SocketException -> L5
            this.f542297a = r104;     // Catch: SocketException -> L5
            r104.setSendBufferSize(2097152);     // Catch: SocketException -> L5
            r104.setReceiveBufferSize(2097152);     // Catch: SocketException -> L5
            qj4.a.c("BWDLSocketProxy", "new BWDLSocketChannel: channelId: " + r100 + ", localPort: " + r104.getLocalPort() + ", targetPort: " + r102);     // Catch: SocketException -> L5
            return;
        L5:
            e = move-exception;
            qj4.a.a("BWDLSocketProxy", "error " + e);
            Map<String, Object> r105 = nj4.b.a(2);
            ((HashMap) r105).put("msg", e.toString());
            l.c("d_bt_rtc_error", r105);
        }
    }

    public final synchronized void d() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f542296g == false) goto L9;
        qj4.a.c("BWDLSocketProxy", "sessionRecvLoop already started");     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        this.f542296g = true;     // Catch: Throwable -> L12
        this.f542291b.execute(new d(this));     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public final void b() {
        qj4.a.c("BWDLSocketProxy", "closing BWDLSocketProxy");
        this.f542295f = false;
        this.f542296g = false;
        this.f542290a.forEach(new sj4.a());
        this.f542290a.clear();
        ExecutorService r100 = this.f542291b;
        if (r100 != null) goto L5;
    L7:
        ScheduledExecutorService r101 = this.f542293d;
        if (r101 != null) goto L10;
    L12:
        this.f542294e = null;
        return;
    L10:
        if (r101.isShutdown() == true) goto L12;
        this.f542293d.shutdownNow();
        goto L12
    L5:
        if (r100.isShutdown() == true) goto L7;
        this.f542291b.shutdownNow();
        goto L7
    }

    public f() {
        this.f542290a = new ConcurrentHashMap();
        this.f542291b = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("BWDLSocketProxy"));
        this.f542292c = new AtomicLong(0);
        this.f542295f = true;
        this.f542296g = false;
        qj4.a.a("BWDLSocketProxy", "create BWDLSocketProxy");
        ScheduledExecutorService r100 = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("BWDLSocketProxy"));
        this.f542293d = r100;
        r100.scheduleWithFixedDelay(new e(this), 1, 1, TimeUnit.SECONDS);
    }

    public final void c(tj4.b r100) {
        int r101 = r100.f546409a;
        a r102 = this.f542290a.get(Integer.valueOf(r101));
        if (r102 != null) goto L6;
        qj4.a.d("BWDLSocketProxy", "handleBwdlReceive: channel " + r101 + " not found, dropping data");
        return;
    L6:
        LinkedBlockingQueue<tj4.b> r103 = r102.f542302f;
        if (r103 != null) goto L10;
        qj4.a.b("BWDLSocketProxy", "handleBwdlReceive: receiveQueue is null for channel " + r101);
        return;
    L10:
        qj4.a.c("BWDLSocketProxy", "handleBwdlReceive, channelId: " + r101 + ", len: " + r100.f546410b.length);
        r103.add(r100);
    }

    public final boolean a(int r100, int r101, int r102, InetAddress r103) {
        qj4.a.c("BWDLSocketProxy", "addOrUpdateSocketChannel, channelID:" + r100 + ", localPort: " + r101 + ", targetPort: " + r102 + ", targetAddress: " + r103);
        a r104 = this.f542290a.get(Integer.valueOf(r100));
        if (r104 == null) goto L6;
        qj4.a.c("BWDLSocketProxy", "channelID is exist: " + r100 + ", tryUpdateTargetPort: " + r102 + ", currentTargetPort: " + r104.f542300d + "currentLocalPort: " + r104.f542299c);
        r104.f542300d = r102;
        return true;
    L6:
        final a r105 = new a(r100, r101, r102, r103);
        if (r105.f542297a != null) goto L10;
        qj4.a.b("BWDLSocketProxy", "Failed to create socket for channel " + r100);
        return false;
    L10:
        qj4.a.c("BWDLSocketProxy", "add new BWDLSocketChannel ID is:" + r100);
        this.f542290a.put(Integer.valueOf(r100), r105);
        this.f542291b.execute(new b(this, r105));
        this.f542291b.execute(new c(this, r105));
        return true;
    }
}
