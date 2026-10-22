package com.bytedance.ug.sdk.luckycat.impl.settings;

import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f271485a = null;

    static {
        f271485a = new f();
    }

    public f() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Result.m9449constructorimpl(DogSettingsManager.f271481f.b(m.a.f271349a.f()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
