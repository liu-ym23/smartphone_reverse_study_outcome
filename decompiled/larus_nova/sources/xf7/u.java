package xf7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sync.net.SyncNetServiceImpl;
import com.bytedance.sync.v2.MsgNotifier;
import com.bytedance.sync.v2.presistence.DBServiceImplV2;
import com.bytedance.sync.v2.process.ProtocolProcessor;
import com.bytedance.sync.v2.protocal.BsyncProtocol;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements yf7.i, o.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f563498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xf7.d f563499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProtocolProcessor f563500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.sync.v2.protocal.a f563501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MsgNotifier f563502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final og7.c f563503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.sync.v2.d f563504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f563505h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f563506i;

    public class a extends n<Handler> {
        public a() {
        }

        @Override // xf7.n
        public final Handler a(Object[] r100) {
            return new Handler(((yf7.f) rgc.b.a(yf7.f.class)).get());
        }
    }

    public class b implements yf7.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f563507a;

        public b(u r100) {
            this.f563507a = r100;
        }
    }

    public class c implements yf7.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f563508a;

        public class a extends n<Looper> {
            public a() {
            }

            @Override // xf7.n
            public final Looper a(Object[] r100) {
                PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("sync-sdk-v2");
                ThreadMethodProxy.start(r101);
                return r101.getLooper();
            }
        }

        @Override // yf7.f
        public final Looper get() {
            return this.f563508a.b(new Object[0]);
        }

        public c() {
            this.f563508a = new a();
        }
    }

    public class d implements hg7.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f563509a;

        public d(u r100) {
            this.f563509a = r100;
        }

        @Override // hg7.i
        public final void a(int r100, BsyncProtocol r101) {
            this.f563509a.f563500c.a(1, r101);
        }
    }

    public final yf7.j a(com.bytedance.sync.a r100) {
        zf7.b.a("register business " + r100.f270349a);
        xf7.d r101 = this.f563499b;
        monitor-enter(r101);
        o r102 = (o) ((ConcurrentHashMap) r101.f563450b).get(Long.valueOf(r100.f270349a));     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        r102.a(r100.f270350b);     // Catch: Throwable -> L10
        yf7.j r103 = ((o) ((ConcurrentHashMap) r101.f563450b).get(Long.valueOf(r100.f270349a))).f563487b;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r103;
    L7:
        yf7.o r104 = r101.f563449a;     // Catch: Throwable -> L10
        Long r105 = Long.valueOf(r100.f270349a);     // Catch: Throwable -> L10
        b r106 = (b) r104;     // Catch: Throwable -> L10
        r106.getClass();     // Catch: Throwable -> L10
        p r107 = new p(r105, r106.f563507a.f563499b);     // Catch: Throwable -> L10
        o r108 = new o(r100, r107, r101.f563451c);     // Catch: Throwable -> L10
        r108.a(r100.f270350b);     // Catch: Throwable -> L10
        r108.b(r100.f270351c);     // Catch: Throwable -> L10
        ((ConcurrentHashMap) r101.f563450b).put(Long.valueOf(r100.f270349a), r108);     // Catch: Throwable -> L10
        r103 = r107;
    L10:
        th = move-exception;
        throw th;
    }

    public u(Context r100, g r101) {
        this.f563505h = new AtomicBoolean(false);
        this.f563506i = new a();
        this.f563498a = r100;
        xf7.d r102 = new xf7.d(this, new b(this));
        this.f563499b = r102;
        MsgNotifier r103 = new MsgNotifier(r101, r102);
        this.f563502e = r103;
        com.bytedance.sync.v2.protocal.a r104 = new com.bytedance.sync.v2.protocal.a(r101.f563458e, r101.f563459f);
        this.f563501d = r104;
        ProtocolProcessor r105 = new ProtocolProcessor(r100, r101);
        this.f563500c = r105;
        dg7.a r106 = new dg7.a(r100, r101.f563457d);
        rgc.b.b(yf7.c.class, r106);
        rgc.b.b(yf7.f.class, new c());
        rgc.b.b(hg7.e.class, r104);
        rgc.b.b(hg7.b.class, new DBServiceImplV2(r100, r101));
        rgc.b.b(hg7.m.class, new com.bytedance.sync.v2.net.d(r101));
        rgc.b.b(hg7.a.class, new fg7.d(r100, r101, new d(this)));
        rgc.b.b(hg7.f.class, new com.bytedance.sync.v2.b());
        rgc.b.b(hg7.g.class, new jg7.d(r100, r101, r105));
        rgc.b.b(hg7.k.class, new com.bytedance.sync.v2.protocal.b((hg7.g) rgc.b.a(hg7.g.class)));
        rgc.b.b(j.class, r101.f563455b);
        rgc.b.b(yf7.d.class, new h(r100));
        rgc.b.b(hg7.d.class, new com.bytedance.sync.v2.process.b(r100, r103));
        rgc.b.b(hg7.h.class, new com.bytedance.sync.v2.upstream.c(r100, r101, r106, r102));
        rgc.b.b(hg7.c.class, new com.bytedance.sync.v2.process.a());
        rgc.b.b(yf7.k.class, new SyncNetServiceImpl(r101));
        rgc.b.b(hg7.l.class, new com.bytedance.sync.v2.c());
        rgc.b.b(k.class, new f(r101));
        rgc.b.b(gg7.b.class, new gg7.a(r100, r101));
        this.f563503f = new og7.c();
    }
}
