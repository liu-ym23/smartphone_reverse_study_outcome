package ry2;

import bz2.c;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f539896a;

    public a(Function0 r100) {
        this.f539896a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f539896a.invoke();     // Catch: Throwable -> L4 Exception -> L6
    L12:
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L6:
        c.a();     // Catch: Throwable -> L4
        goto L12
    }
}
