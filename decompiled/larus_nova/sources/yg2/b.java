package yg2;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f567487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ xg2.b f567488b;

    public b(a r100, xg2.b r101) {
        this.f567487a = r100;
        this.f567488b = r101;
    }

    public final void a() {
        String r100 = this.f567487a.c(this.f567488b);
        if (r100 != null) goto L5;
        return;
    L5:
        xg2.b r101 = this.f567488b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f563596a = r100;
        xg2.b r102 = this.f567488b;
        System.currentTimeMillis();
        r102.getClass();
        LinkedList r103 = (LinkedList) ((ConcurrentHashMap) this.f567487a.f567484b).get(r100);
        if (r103 == null) goto L9;
        r103.add(this.f567488b);
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
