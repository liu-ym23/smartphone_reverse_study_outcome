package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<String, d> f417926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f417927b;

    public u(Map<String, d> r100, String r101) {
        this.f417926a = r100;
        this.f417927b = r101;
    }

    public final void a() {
        String r100 = com.ss.android.lark.security.compliance.infra.util.f.c(this.f417926a);     // Catch: Exception -> L4
    L6:
        com.ss.android.lark.storage.kv.repo.a r101 = y.f417934c;
        if (r101 == null) goto L12;
        r101.putString("object_" + this.f417927b, r100);
        return;
    L12:
        return;
    L4:
        e = move-exception;
        int r102 = ScsLogger.f440428a;
        ScsLogger.c("SecurityPolicy_PolicyStorage", "saveDynamicObjectResult(), trans data to dataStr error, e:" + e.getMessage());
        r100 = "";
        goto L6
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
