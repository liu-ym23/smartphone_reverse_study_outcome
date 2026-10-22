package dq5;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<V> implements Callable {
    public final /* synthetic */ ce5.a a;

    public k(ce5.a r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final up5.b<String> call() {
        String r0 = j.a(this.a);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        int r2 = up5.b.b;
        return up5.b.a.a();
    L12:
        return new up5.b(r0);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
