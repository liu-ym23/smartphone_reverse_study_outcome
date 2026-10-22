package rr3;

import android.location.Location;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ Location b;
    public final /* synthetic */ int c;

    public b(a r1, Location r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a.n == true) goto L5;
        return;
    L5:
        a r0 = this.a;
        r0.m = System.currentTimeMillis();
        Function1<? super a.AbstractC0166a, Unit> r1 = this.a.g;
        if (r1 == null) goto L8;
        Unit r2 = (Unit) r1.invoke(new a.AbstractC0166a.b(this.b, this.c));
    L8:
        a r3 = this.a;
        Handler r4 = r3.a;
        if (r4 == null) goto L12;
        r4.postDelayed(r3.s, r3.b);
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
