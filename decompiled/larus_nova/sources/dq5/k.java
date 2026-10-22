package dq5;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes18.dex */
public final class k<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ce5.a f469676a;

    public k(ce5.a r100) {
        this.f469676a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final up5.b<String> call() {
        String r100 = j.a(this.f469676a);
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        int r102 = up5.b.f551047b;
        return up5.b.a.a();
    L12:
        return new up5.b(r100);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
