package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<SenderTenantMap, Unit> f417843a;

    /* JADX WARN: Multi-variable type inference failed */
    public r(Function1<? super SenderTenantMap, Unit> r100) {
        this.f417843a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.storage.kv.repo.a r100 = y.f417932a;     // Catch: Throwable -> L8
        if (r100 == null) goto L5;
        SenderTenantMap r101 = (SenderTenantMap) r100.getJSONObject("SenderTenantIdMap", SenderTenantMap.class);     // Catch: Throwable -> L8
    L6:
        this.f417843a.invoke(r101);     // Catch: Throwable -> L8
        return;
    L5:
        r101 = null;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
