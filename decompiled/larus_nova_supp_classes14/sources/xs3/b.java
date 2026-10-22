package xs3;

import com.larus.apm.impl.protector.RunnableProtector;
import ff7.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ JSONObject f;
    public final /* synthetic */ e g;

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.a, this.b, this.c, this.d, this.e, this.f, null, this.g);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(String r1, String r2, String r3, String r4, String r5, e r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = null;
        this.g = r6;
    }
}
