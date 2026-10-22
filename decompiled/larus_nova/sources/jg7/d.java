package jg7;

import android.content.Context;
import com.bytedance.sync.v2.process.ProtocolProcessor;
import com.bytedance.sync.v2.protocal.BsyncProtocol;
import com.bytedance.sync.v2.protocal.BsyncTopic;
import com.bytedance.sync.v2.protocal.Flag;
import com.larus.apm.impl.protector.RunnableProtector;
import hg7.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f499035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<ig7.a> f499036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.sync.v2.net.b f499037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.sync.v2.net.c f499038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f499039e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f499040a;

        public final void a() {
            cg7.a r100 = cg7.b.c(this.f499040a.f499039e).b();
            zf7.b.d("[SendMsg] start send msg to server....");
        L3:
            ig7.a r101 = this.f499040a.f499036b.poll();
            if (r101 == null) goto L5;
            if (r101.f489741c == true) goto L27;
            if (r101.f489742d != null) goto L27;
            r101.f489742d = new jg7.a();
        L27:
            if (r100.n() == false) goto L32;
            if (r101.f489741c == true) goto L32;
            this.f499040a.f499038d.F(r101);
        L32:
            this.f499040a.f499037c.F(r101);
            goto L3
        L5:
            d r102 = this.f499040a;
            monitor-enter(r102);
            boolean r103 = this.f499040a.f499036b.isEmpty();     // Catch: Throwable -> L14
            AtomicBoolean r104 = this.f499040a.f499035a;     // Catch: Throwable -> L14
            if (r103 == true) goto L10;
            boolean r105 = true;
        L11:
            r104.set(r105);     // Catch: Throwable -> L14
            if (r103 == true) goto L16;
            a r106 = new a(this.f499040a);     // Catch: Throwable -> L14
            e.f499041a.b(new Object[0]).submit(r106);     // Catch: Throwable -> L14
        L16:
            monitor-exit(r102);     // Catch: Throwable -> L14
            zf7.b.d("[SendMsg] send msg to server finish");
            return;
        L10:
            r105 = false;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100) {
            this.f499040a = r100;
        }
    }

    @Override // hg7.g
    public final boolean l() {
        monitor-enter(d.class);
        Iterator r100 = new ArrayList(this.f499036b).iterator();     // Catch: Throwable -> L20
    L6:
        if (r100.hasNext() == false) goto L17;
        BsyncProtocol r101 = ((ig7.a) r100.next()).f489739a;     // Catch: Throwable -> L20
        if (r101 == null) goto L6;
        Iterator<BsyncTopic> r102 = r101.topics.iterator();     // Catch: Throwable -> L20
    L11:
        if (r102.hasNext() == false) goto L6;
        if (r102.next().flag != Flag.Data) goto L11;
        monitor-exit(d.class);     // Catch: Throwable -> L20
        return true;
    L17:
        monitor-exit(d.class);     // Catch: Throwable -> L20
        return false;
    L20:
        th = move-exception;
        throw th;
    }

    public static String M(BsyncProtocol r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.toString();
    }

    @Override // hg7.g
    public final void F(ig7.a r100) {
        zf7.b.a("[SendMsg] offer msg to dequeue : " + M(r100.f489739a) + ", can fallback: " + r100.f489740b);
        this.f499036b.offer(r100);
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f499035a.compareAndSet(false, true) == false) goto L7;
        e.f499041a.b(new Object[0]).submit(new a(this));     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
    }

    public d(Context r100, xf7.g r101, ProtocolProcessor r102) {
        this.f499035a = new AtomicBoolean(false);
        this.f499036b = new LinkedBlockingQueue();
        this.f499039e = r100;
        this.f499038d = new com.bytedance.sync.v2.net.c(r100, r101, new b(this));
        this.f499037c = new com.bytedance.sync.v2.net.b(r100, r101, r102, new c(this));
    }
}
