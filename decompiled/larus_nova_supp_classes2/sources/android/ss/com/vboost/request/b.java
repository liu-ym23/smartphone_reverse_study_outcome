package android.ss.com.vboost.request;

import android.ss.com.vboost.utils.LogUtil;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class b implements Callable<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f153b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f154a;

    public b(d r1) {
        this.f154a = r1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        if (android.ss.com.vboost.i.c.e().a(this.f154a) == true) goto L5;
        LogUtil.debug(f153b, "no provider support this ability " + this.f154a.f158a);
    L9:
        RequestManager.getInstance().completeRequest(this.f154a, false);
        return null;
    L5:
        if (this.f154a.f165j == true) goto L7;
        android.ss.com.vboost.i.c.e().b(this.f154a);
        goto L9
    L7:
        android.ss.com.vboost.i.c.e().c(this.f154a);
        goto L9
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Integer call() {
        return call();
    }
}
