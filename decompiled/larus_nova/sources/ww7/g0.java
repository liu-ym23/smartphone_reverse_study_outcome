package ww7;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes23.dex */
public final class g0 implements Callable<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f561657a;

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        k0 r100 = this.f561657a;
        d r101 = r100.f561669b;
        Context r102 = r100.f561668a;
        r101.getClass();
        m r103 = new m();     // Catch: Exception -> L5
        r103.f561706e = i.a();     // Catch: Exception -> L5
        y0 r104 = y0.f561725c;     // Catch: Exception -> L5
        r104.getClass();     // Catch: Exception -> L5
        f0<TResult> r105 = new f0();     // Catch: Exception -> L5
        r103.f561702a = r105;     // Catch: Exception -> L5
        Handler r106 = r104.f561726a;     // Catch: Exception -> L5
        r106.sendMessage(r106.obtainMessage(1, r103));     // Catch: Exception -> L5
        i.c(r105.f561656a);     // Catch: Exception -> L5
        n.f561683b.a(r102, null);     // Catch: Exception -> L5
        return null;
    L5:
        e = move-exception;
        throw i.b(e);
    }

    public g0(k0 r100) {
        this.f561657a = r100;
    }
}
