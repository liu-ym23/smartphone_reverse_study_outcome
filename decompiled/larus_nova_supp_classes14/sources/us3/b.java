package us3;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ vs3.b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ e c;

    public final void a() {
        e r2 = this.c;     // Catch: Exception -> L28
    L4:
        vs3.b r3 = (vs3.b) r2.b.poll();     // Catch: Exception -> L28
        if (r3 == null) goto L8;
        ((CopyOnWriteArraySet) r2.c).remove(r3.a);     // Catch: Exception -> L28
        goto L4
    L8:
        if ((!((CopyOnWriteArraySet) this.c.c).contains(this.a.a)) == true) goto L10;
        e r1 = this.c;     // Catch: Exception -> L28
        if (r1.d.a == false) goto L26;
        e.a(r1);     // Catch: Exception -> L28
        e r4 = this.c;     // Catch: Exception -> L28
    L16:
        vs3.b r5 = (vs3.b) r4.b.poll();     // Catch: Exception -> L28
        if (r5 == null) goto L20;
        ((CopyOnWriteArraySet) r4.c).remove(r5.a);     // Catch: Exception -> L28
        goto L16
    L20:
        if ((!((CopyOnWriteArraySet) this.c.c).contains(this.a.a)) == true) goto L22;
        e.b(this.c, this.a, this.b);     // Catch: Exception -> L28
        return;
    L22:
        if (com.bytedance.apm.d.j() == false) goto L35;
        ps3.b.a(new String[]{"No Leak:" + this.b});     // Catch: Exception -> L28
        return;
    L35:
        return;
    L26:
        e.b(r1, this.a, this.b);     // Catch: Exception -> L28
        return;
    L10:
        if (com.bytedance.apm.d.j() == false) goto L34;
        ps3.b.a(new String[]{"No Leak First Check:" + this.b});     // Catch: Exception -> L28
        return;
    L34:
        return;
    L28:
        e = move-exception;
        e.printStackTrace();
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

    public b(e r1, vs3.b r2, String r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
