package com.ss.android.lark.chat.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.entity.chat.Chat;

/* JADX INFO: loaded from: classes35.dex */
public final class j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IChatService f416684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Chat f416685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i7b.b f416686c;

    public j0(IChatService r100, Chat r101, i7b.b r102) {
        this.f416684a = r100;
        this.f416685b = r101;
        this.f416686c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IChatService r100 = this.f416684a;     // Catch: Throwable -> L4
        String r101 = this.f416685b.getId();     // Catch: Throwable -> L4
        i7b.b r102 = this.f416686c;     // Catch: Throwable -> L4
        r100.t8(r101, r102.f488515a, r102.f488516b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
