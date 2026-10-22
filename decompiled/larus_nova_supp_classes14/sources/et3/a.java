package et3;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ float c;
    public final /* synthetic */ b d;

    public final void a() {
        b.a r0 = this.d.b.get(this.a);
        if (r0 != null) goto L5;
        this.d.b.put(this.a, new b.a(this.b, this.c));
        return;
    L5:
        r0.b += this.c;
        r0.d++;
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

    public a(b r1, String r2, Map r3, float r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
