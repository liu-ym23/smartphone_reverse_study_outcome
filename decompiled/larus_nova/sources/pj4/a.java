package pj4;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.LinkedBlockingQueue;
import rj4.d;
import rj4.e;
import rj4.g;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements tj4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<tj4.b> f529458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f529459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f529460c;

    /* JADX INFO: renamed from: pj4.a$a, reason: collision with other inner class name */
    public class C7200a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f529461a;

        public C7200a(a r100) {
            this.f529461a = r100;
        }

        @Override // rj4.d.a
        public final void a(int r100, byte[] r101, int r102) {
            qj4.a.c("ByteLinkChannel", "onBWDLRecvData, channelId: " + r100 + ", len: " + r102);
            if (r101 != null) goto L5;
        L7:
            this.f529461a.f529458a.add(new tj4.b(r100, r101, r102));
            return;
        L5:
            if (r101.length != r102) goto L7;
            this.f529461a.f529458a.add(new tj4.b(r100, r101));
        }
    }

    public class b implements e.a {
        public b() {
        }

        @Override // rj4.e.a
        public final void a(byte[] r100, int r101, int r102) {
            ak4.a.d().e(r102, r100);
        }
    }

    @Override // tj4.a
    public final int open(Object r100) {
        return 0;
    }

    @Override // tj4.a
    public final tj4.b a() {
        return this.f529458a.take();
    L8:
        e = move-exception;
        qj4.a.d("ByteLinkChannel", "recvQueue interrupted: " + e.getMessage());
        ThreadMethodProxy.currentThread().interrupt();
        return null;
    L5:
        e = move-exception;
        qj4.a.b("ByteLinkChannel", "recvQueue take exception: " + e.getMessage());
        return null;
    }

    @Override // tj4.a
    public final int close() {
        qj4.a.c("ByteLinkChannel", "closing ByteLinkChannel");
        this.f529459b.k((byte) 0);     // Catch: Exception -> L5
        this.f529459b.k((byte) 1);     // Catch: Exception -> L5
        this.f529459b.k((byte) 2);     // Catch: Exception -> L5
        this.f529460c.c((byte) 0);     // Catch: Exception -> L5
        this.f529460c.c((byte) 1);     // Catch: Exception -> L5
        this.f529460c.c((byte) 2);     // Catch: Exception -> L5
        this.f529458a.clear();     // Catch: Exception -> L5
        return 0;
    L5:
        e = move-exception;
        qj4.a.b("ByteLinkChannel", "Error closing ByteLinkChannel: " + e.getMessage());
        return -1;
    }

    public a() {
        this.f529458a = new LinkedBlockingQueue();
        d r100 = d.e();
        this.f529459b = r100;
        g r101 = g.a();
        this.f529460c = r101;
        C7200a r102 = new C7200a(this);
        r100.j((byte) 0, r102);
        r100.j((byte) 1, r102);
        r100.j((byte) 2, r102);
        b r103 = new b();
        r101.b((byte) 0, r103);
        r101.b((byte) 1, r103);
        r101.b((byte) 2, r103);
    }

    @Override // tj4.a
    public final int b(tj4.b r100) {
        byte[] r101 = r100.f546410b;
        new rj4.a(r101, (short) r101.length, (byte) r100.f546409a).l();
        return r100.f546410b.length;
    }
}
