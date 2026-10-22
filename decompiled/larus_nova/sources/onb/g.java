package onb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.vmsdk.worker.JsWorker;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements nnb.c.b, pnb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nnb.c f524408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f524409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f524410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public pnb.b f524411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f524412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final onb.c f524413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f524414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f524415h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f524416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f524417b;

        public final void a() {
            onb.b r100 = this.f524417b.f524414g.create();
            r100.b(this.f524416a);
            g r101 = this.f524417b;
            List<c> r102 = r101.f524410c;
            monitor-enter(r102);
            ArrayList r103 = new ArrayList(r101.f524410c);     // Catch: Throwable -> L12
            monitor-exit(r102);     // Catch: Throwable -> L12
            Iterator r104 = r103.iterator();
        L8:
            if (r104.hasNext() == false) goto L10;
            ((c) r104.next()).b(r100);
            goto L8
        L10:
            rnb.c.a("RNBridge->JSBridgeConnector", "responseFromJs responseId: " + r100.a());
            return;
        L12:
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

        public a(g r100, String r101) {
            this.f524417b = r100;
            this.f524416a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f524418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f524419b;

        public final void a() {
            onb.b r100 = this.f524419b.f524415h.create();
            r100.b(this.f524418a);
            g r101 = this.f524419b;
            List<c> r102 = r101.f524410c;
            monitor-enter(r102);
            ArrayList r103 = new ArrayList(r101.f524410c);     // Catch: Throwable -> L12
            monitor-exit(r102);     // Catch: Throwable -> L12
            Iterator r104 = r103.iterator();
        L8:
            if (r104.hasNext() == false) goto L10;
            ((c) r104.next()).b(r100);
            goto L8
        L10:
            rnb.c.a("RNBridge->JSBridgeConnector", "responseFromDocs responseId: " + r100.a());
            return;
        L12:
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

        public b(g r100, String r101) {
            this.f524419b = r100;
            this.f524418a = r101;
        }
    }

    public interface c<T extends onb.b> {
        void a();

        void b(T r100);

        void disconnect();
    }

    public final void d() {
        if (this.f524409b.get() != 1) goto L11;
        this.f524409b.set(2);
        final nnb.c r100 = this.f524408a;
        r100.getClass();
        rnb.c.c("BridgeEngine", "start() called with: listener = [" + this + "]");
        com.ss.android.lark.jsruntime.vmsdk.j r101 = r100.f519692a;
        if (r101 == null) goto L13;
        tnb.e r102 = new nnb.a(r100, this);
        Intrinsics.checkNotNullParameter(r102, "callback");
        rnb.c.c("VMSDK_VMSDKEngine", "addReadyListener() called with: callback = " + r102 + " isReady:" + r101.f428179f);
        ((ArrayList) r101.f428178e).add(r102);
        if (r101.f428179f == false) goto L12;
        r102.onReady();
        return;
    L12:
        return;
    L13:
        return;
    }

    public final void e() {
        com.ss.android.lark.jsruntime.vmsdk.j r100 = this.f524408a.f519692a;
        if (r100 == null) goto L9;
        rnb.c.c("VMSDK_VMSDKEngine", "terminate: ");
        JsWorker r101 = r100.f428176c;
        if (r101 == null) goto L7;
        r101.terminate();
    L7:
        r100.f428176c = null;
        r100.f428183j = false;
        ((ArrayList) r100.f428180g).clear();
        ((ArrayList) r100.f428181h).clear();
        ((ArrayList) r100.f428182i).clear();
        ((ArrayList) r100.f428178e).clear();
        r100.f428179f = false;
    L9:
        if (this.f524409b.get() != 3) goto L24;
        pnb.b r102 = this.f524408a.f519693b;
        if (pnb.c.f530002c == false) goto L13;
        r102.getClass();
        rnb.c.a("bridge_connector", "unRegisterDataChangeListener: listener size=" + ((CopyOnWriteArraySet) r102.f529993c).size());
    L13:
        pnb.b.a r103 = r102.f529992b;
        int r104 = pnb.b.a.f529996b;
        r103.getClass();
        r103.sendMessage(Message.obtain(r103, 2, this));
        List<c> r105 = this.f524410c;
        monitor-enter(r105);
        ArrayList r106 = new ArrayList(this.f524410c);     // Catch: Throwable -> L21
        monitor-exit(r105);     // Catch: Throwable -> L21
        Iterator r107 = r106.iterator();
    L19:
        if (r107.hasNext() == false) goto L24;
        ((c) r107.next()).disconnect();
    L21:
        th = move-exception;
        throw th;
    L24:
        this.f524413f.destroy();
        this.f524409b.set(1);
    }

    @Override // pnb.d
    public final void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.f524413f.submit(new a(this, r100));
    }

    @Override // pnb.d
    public final void b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.f524413f.submit(new b(this, r100));
    }

    public final void c(c r100) {
        List<c> r101 = this.f524410c;
        monitor-enter(r101);
        if (r100 != null) goto L13;
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        if (((ArrayList) this.f524410c).contains(r100) == true) goto L8;
        ((ArrayList) this.f524410c).add(r100);     // Catch: Throwable -> L10
        goto L8
    }

    public final void f(c r100) {
        List<c> r101 = this.f524410c;
        monitor-enter(r101);
        ((ArrayList) this.f524410c).remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public g(nnb.c r100, n r101, d r102, d r103) {
        this.f524409b = new AtomicInteger(1);
        this.f524410c = new ArrayList();
        this.f524412e = new Handler(Looper.getMainLooper());
        this.f524408a = r100;
        this.f524413f = r101;
        this.f524414g = r102;
        this.f524415h = r103;
    }
}
