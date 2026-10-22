package vl2;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f555650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f555651b;

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        return f.a(this.f555650a, this.f555651b);
    }

    public e(String r100) {
        this.f555650a = r100;
        this.f555651b = 5;
    }
}
