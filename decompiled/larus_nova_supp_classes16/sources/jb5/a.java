package jb5;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Runnable {
    public final /* synthetic */ x18.b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(x18.b r1, String r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
