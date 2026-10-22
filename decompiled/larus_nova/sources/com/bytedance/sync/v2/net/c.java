package com.bytedance.sync.v2.net;

import android.content.Context;
import android.os.Handler;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.v2.protocal.BsyncProtocol;
import com.bytedance.sync.v2.protocal.Flag;
import hg7.e;
import hg7.g;
import hg7.j;
import hg7.m;
import java.util.concurrent.LinkedBlockingQueue;
import xf7.k;
import yf7.f;
import yf7.l;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements g, d.a, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f270452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f270453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f270454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f270455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedBlockingQueue<WsChannelMsg> f270456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f270457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f270458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f270459h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f270460a;

        @Override // java.lang.Runnable
        public final void run() {
            zf7.b.c("wait 15000 don't receive msg ,so try send msg again");     // Catch: Throwable -> L4
            WsChannelMsg r100 = this.f270460a.f270456e.poll();     // Catch: Throwable -> L4
            this.f270460a.f270454c.b(r100);     // Catch: Throwable -> L4
            return;
        }

        public a(c r100) {
            this.f270460a = r100;
        }
    }

    @Override // hg7.g
    public final boolean l() {
        return false;
    }

    @Override // hg7.j
    public final void z0() {
        this.f270456e.clear();     // Catch: Throwable -> L4
        return;
    }

    @Override // hg7.g
    public final void F(ig7.a r110) {
        if (r110.f489741c == false) goto L6;
        this.f270457f.F(r110);
        return;
    L6:
        BsyncProtocol r100 = r110.f489739a;
        if (r100 != null) goto L10;
        zf7.b.b("[SendMsg] msg is null ,not send");
        return;
    L10:
        int r101 = com.bytedance.sync.v2.utils.a.a(r100).intValue();
        WsChannelMsg r102 = ((e) rgc.b.a(e.class)).P(this.f270455d, r110.f489739a);
        if (r102 != null) goto L15;
        zf7.b.b("[SendMsg] convert msg error, not send");
        return;
    L15:
        if (this.f270454c.a() == false) goto L64;
        this.f270453b = false;
        this.f270454c.b(r102);
        G0(r110.f489742d, 1, r101, true);
        zf7.b.a("[SendMsg] send msg to ws " + jg7.d.M(r110.f489739a));
        return;
    L64:
        Object r103 = this.f270452a;     // Catch: InterruptedException -> L39
        monitor-enter(r103);     // Catch: InterruptedException -> L39
    L36:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L39
    L20:
        if (this.f270453b == true) goto L22;
    L25:
        boolean r104 = true;
    L26:
        if (r104 == false) goto L33;
        zf7.b.a("[SendMsg] ws not connect, sleep...");     // Catch: Throwable -> L36
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L36
        this.f270452a.wait(5000);     // Catch: Throwable -> L36
        if ((System.currentTimeMillis() - r105) >= 5000) goto L30;
        boolean r106 = true;
    L31:
        if (r106 == true) goto L34;
        this.f270453b = true;     // Catch: Throwable -> L36
    L34:
        monitor-exit(r103);     // Catch: Throwable -> L36
    L42:
        if (this.f270454c.a() == false) goto L53;
        this.f270454c.b(r102);
        if (cg7.b.c(this.f270455d).b().k() > 0) goto L47;
    L50:
        this.f270456e.clear();     // Catch: Throwable -> L60
    L61:
        goto L51
    L47:
        if (r101 != Flag.Poll.getValue()) goto L50;
        this.f270456e.offer(r102);     // Catch: Throwable -> L60
        this.f270458g.postDelayed(this.f270459h, 15000);     // Catch: Throwable -> L60
        zf7.b.c("send poll pkg retry task ");     // Catch: Throwable -> L60
    L51:
        G0(r110.f489742d, 1, r101, true);
        zf7.b.a("[SendMsg] send msg to ws again " + jg7.d.M(r110.f489739a));
        return;
    L53:
        if (r110.f489740b == false) goto L58;
        zf7.b.a("[SendMsg] ws not connect, fallback to http...");
        if (((k) rgc.b.a(k.class)).O(this.f270455d) == false) goto L57;
        ig7.a r107 = new ig7.a();
        r107.f489739a = r110.f489739a;
        r107.f489740b = false;
        r107.f489742d = r110.f489742d;
        this.f270457f.F(r107);
        return;
    L57:
        zf7.b.b("[SendMsg] net not available,throw msg " + jg7.d.M(r110.f489739a));
        NetTrace r108 = r110.f489742d;
        int r109 = com.bytedance.sync.v2.utils.a.f270548a;
        G0(r108, 3, com.bytedance.sync.v2.utils.a.a(r110.f489739a).intValue(), false);
        return;
    L58:
        zf7.b.b("[SendMsg] send payload failed with ws " + jg7.d.M(r110.f489739a) + ", throw it");
        G0(r110.f489742d, 2, r101, false);
        return;
    L30:
        r106 = false;
        goto L31
    L33:
        zf7.b.a("[SendMsg] ws not connect, but waiting timeout, so not sleep");     // Catch: Throwable -> L36
        goto L34
    L22:
        if (r110.f489740b == false) goto L25;
        r104 = false;
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L42
    }

    @Override // com.bytedance.sync.v2.net.d.a
    public final void M(boolean r100) {
        if (r100 == false) goto L11;
        Object r101 = this.f270452a;
        monitor-enter(r101);
        zf7.b.a("[SendMsg] notify ws connected");     // Catch: Throwable -> L8
        this.f270452a.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public c(Context r100, xf7.g r101, jg7.b r102) {
        this.f270452a = new Object();
        this.f270456e = new LinkedBlockingQueue();
        this.f270459h = new a(this);
        this.f270455d = r100;
        this.f270454c = r101.f563456c;
        this.f270457f = r102;
        this.f270458g = new Handler(((f) rgc.b.a(f.class)).get());
        ((m) rgc.b.a(m.class)).o0(this);
        ((hg7.f) rgc.b.a(hg7.f.class)).c0(this);
    }

    public static void G0(NetTrace r100, int r101, int r102, boolean r103) {
        if (r100 == null) goto L5;
        r100.f270441a = 1;
        r100.f270442b = r101;
        r100.f270443c = r102;
        r100.f270444d = r103 ? 1 : 0;
        r100.a();
    L5:
        int r104 = com.bytedance.sync.v2.utils.a.f270548a;
        if (Flag.Sync.getValue() != r102) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L16;
        ((hg7.l) rgc.b.a(hg7.l.class)).C(1, System.currentTimeMillis());
        return;
    L16:
        return;
    L9:
        r105 = false;
        goto L10
    }
}
