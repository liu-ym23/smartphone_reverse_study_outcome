package android.ss.com.vboost.request;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class h implements Callable<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ScheduledFuture<Integer> f174b;

    public h(d r1) {
        this.f173a = r1;
    }

    public ScheduledFuture<Integer> a() {
        return this.f174b;
    }

    public void a(ScheduledFuture<Integer> r1) {
        this.f174b = r1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        if (this.f173a.b() != g.f171c) goto L5;
    L7:
        RequestManager.getInstance().completeRequest(this.f173a, true);
        return null;
    L5:
        if (this.f173a.b() == g.f169a) goto L7;
        this.f173a.f165j = true;
        android.ss.com.vboost.i.c.e().c(this.f173a);
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Integer call() {
        return call();
    }
}
