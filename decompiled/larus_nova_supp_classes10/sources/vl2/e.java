package vl2;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements Callable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        return f.a(this.a, this.b);
    }

    public e(String r1) {
        this.a = r1;
        this.b = 5;
    }
}
