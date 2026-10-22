package com.bytedance.article.common.monitor.stack;

import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static void a(Throwable r100, String r101) {
        if (EnsureManager.getEnsureImpl() == null) goto L6;
        EnsureManager.ensureNotReachHere(r100, r101);
        return;
    }
}
