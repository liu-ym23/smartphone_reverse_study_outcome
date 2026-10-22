package px4;

import android.app.Dialog;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a0 implements Runnable {
    public final /* synthetic */ w a;
    public final /* synthetic */ String b;

    public a0(w r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        w r0 = this.a;
        jx4.u r1 = r0.b;
        if (r1 != null) goto L8;
        r0.b = new jx4.u(r0.a, this.b);
        jx4.u r2 = this.a.b;
        Intrinsics.checkNotNull(r2);
        Dialog r3 = r2.b;
        if (r3 == null) goto L7;
        r3.setCancelable(false);
    L7:
        jx4.u r4 = this.a.b;
        Intrinsics.checkNotNull(r4);
        r4.c();
        return;
    L8:
        Intrinsics.checkNotNull(r1);
        String r5 = this.b;
        Dialog r6 = r1.b;
        if (r6 != null) goto L11;
        return;
    L11:
        if (r6.isShowing() == false) goto L16;
        r1.c.setText(r5);
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
}
