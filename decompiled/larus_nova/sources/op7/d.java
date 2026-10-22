package op7;

import com.bytedance.vmsdk.worker.JsWorker;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import rp7.e;
import rp7.g;
import rp7.h;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile pp7.d f524732h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile e f524733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f524734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsWorker f524735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f524736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qp7.a f524737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f524738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<c> f524739g;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f524734b, this.f524736d});
    }

    public d(JsWorker r100) {
        if (f524732h != null) goto L5;
        f524732h = new pp7.d();
        final pp7.d r101 = f524732h;
        r101.getClass();
        ThreadMethodProxy.start(new PthreadThreadV2(new pp7.c(r101), "LocalSocketServer"));
    L5:
        this.f524739g = new LinkedList();
        if (r100.EngineType() != JsWorker.EngineType.V8) goto L8;
        String r102 = "V8";
    L9:
        this.f524734b = "VMSDK_JSWorker_".concat(r102);
        String r103 = "/inspector/" + r100.getNativePtr();
        this.f524736d = r103;
        this.f524735c = r100;
        qp7.a r104 = new qp7.a(r103);
        this.f524737e = r104;
        g r105 = new g(new a(this));
        this.f524738f = r105;
        pp7.d r106 = f524732h;
        b r107 = r106.f530219d;
        List<d> r108 = r107.f524731b;
        monitor-enter(r108);
    L17:
        th = move-exception;
        throw th;
    L12:
        if (((ArrayList) r107.f524731b).contains(this) == true) goto L14;
        ((ArrayList) r107.f524731b).add(this);     // Catch: Throwable -> L17
    L14:
        monitor-exit(r108);     // Catch: Throwable -> L17
        r106.f530220e.a(r104, r105);
        return;
    L8:
        r102 = "QuickJS";
        goto L9
    }

    @Override // op7.c
    public final void a(h r100) {
        this.f524733a = r100;
        Iterator<c> r101 = this.f524739g.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a(r100);
        goto L4
    L6:
        this.f524735c.onOpenInspectorSession();
    }

    @Override // op7.c
    public final void c(e r100) {
        this.f524733a = null;
        this.f524735c.onCloseInspectorSession();
        Iterator<c> r101 = this.f524739g.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().c(r100);
        goto L4
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (d.class != r100.getClass()) goto L17;
        d r101 = (d) r100;
        if (Objects.equals(this.f524734b, r101.f524734b) == true) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.f524736d, r101.f524736d) == false) goto L15;
        return true;
    }

    @Override // op7.c
    public final boolean b(h r100, String r101) {
        Iterator<c> r102 = this.f524739g.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r102.next().b(r100, r101) == false) goto L4;
        return true;
    L9:
        this.f524735c.onInspectorMessage(r101);
        return false;
    }
}
