package ss3;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import is3.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class j$a implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ int[] b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ThreadGroup e;

    public final void a() {
        if (this.a == true) goto L24;
        int[] r0 = this.b;
        int r2 = r0[0];
        if (r2 < j.j) goto L24;
        if (j.i == false) goto L24;
        Thread[] r3 = new Thread[r2 + (r2 / 2)];
        r0[0] = this.e.enumerate(r3);
        StringBuilder r1 = new StringBuilder();
        int r4 = 0;
    L10:
        int r5 = this.b[0];
        if (r4 >= r5) goto L22;
        String r6 = r3[r4].getName();
        if (TextUtils.isEmpty(r6) == true) goto L15;
        r1.append(r6);
        r1.append(",");
    L15:
        r4 = r4 + 1;
        goto L10
    L22:
        JSONObject r7 = j.i(this.c, this.d, r5, r1.toString());     // Catch: Throwable -> L20
        a.h().b(new js3.e(r7));     // Catch: Throwable -> L20
        return;
    L28:
        return;
    L24:
        JSONObject r8 = j.i(this.c, this.d, this.b[0], null);     // Catch: Exception -> L21
        a.h().b(new js3.e(r8));     // Catch: Exception -> L21
        return;
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

    public j$a(boolean r1, int[] r2, String r3, int r4, ThreadGroup r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
