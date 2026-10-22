package jz0;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes47.dex */
public final class c<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f501096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f501097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f501098c;

    public c(b r100) {
        this.f501096a = r100;
        this.f501097b = "__version__";
        this.f501098c = "";
    }

    @Override // java.util.concurrent.Callable
    public final String call() {
        return this.f501096a.d(this.f501097b, this.f501098c);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
