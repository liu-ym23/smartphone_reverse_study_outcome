package com.bytedance.article.common.monitor.stack;

import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static void a(Throwable r1, String r2) {
        if (EnsureManager.getEnsureImpl() == null) goto L6;
        EnsureManager.ensureNotReachHere(r1, r2);
        return;
    }
}
