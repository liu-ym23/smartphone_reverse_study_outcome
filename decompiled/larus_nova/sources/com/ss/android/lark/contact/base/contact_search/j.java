package com.ss.android.lark.contact.base.contact_search;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f418810a;

    @Override // java.lang.Runnable
    public final void run() {
        s r100 = this.f418810a;     // Catch: Throwable -> L6
        ApiUtils.a<Boolean> r101 = r100.f418823p;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.consume(Boolean.valueOf(r100.B));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public j(s r100) {
        this.f418810a = r100;
    }
}
