package zt4;

import com.bytedance.ee.bear.bitable.load.dataloader.BitableAppLoader;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f573588a;

    public d(BitableAppLoader r100, String r101) {
        this.f573588a = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f573588a;     // Catch: Throwable -> L11
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        com.bytedance.ee.bear.bitable.rust.c.f215261a.getClass();     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(com.bytedance.ee.bear.bitable.rust.c.c(r100)));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);     // Catch: Throwable -> L11
        if (r103 == null) goto L14;
        tt5.a.l("BitableAppLoader", "refreshClientVarsOnDestroy async failed", r103);     // Catch: Throwable -> L11
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }
}
