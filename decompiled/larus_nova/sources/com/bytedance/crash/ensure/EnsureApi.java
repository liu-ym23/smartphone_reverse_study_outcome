package com.bytedance.crash.ensure;

import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.IEnsure;

/* JADX INFO: loaded from: classes3.dex */
public final class EnsureApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f203193a;

    public static void a() {
        if (f203193a == false) goto L5;
        return;
    L5:
        f203193a = true;
        IEnsure r100 = new AnonymousClass1();     // Catch: Throwable -> L8
        ServiceManager.registerService(IEnsure.class, r100);     // Catch: Throwable -> L8
        EnsureManager.setEnsureImpl(r100);     // Catch: Throwable -> L8
        return;
    }
}
