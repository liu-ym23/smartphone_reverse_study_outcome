package k74;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.b f502001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f502002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f502003c;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<a> r100 = this.f502001a.f502012b.keySet().iterator();     // Catch: Throwable -> L9
    L4:
        if (r100.hasNext() == false) goto L20;
        if (this.f502002b != r100.next()) goto L4;
        this.f502002b.a(this.f502003c);     // Catch: Throwable -> L9
        return;
    L20:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }

    public b(c.b r100, a r101, Object r102) {
        this.f502001a = r100;
        this.f502002b = r101;
        this.f502003c = r102;
    }
}
