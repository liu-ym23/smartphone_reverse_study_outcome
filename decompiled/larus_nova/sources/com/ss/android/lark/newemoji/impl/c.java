package com.ss.android.lark.newemoji.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmojiService2 f433042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set<qsb.a> f433043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f433044c;

    public c(EmojiService2 r100, Set<qsb.a> r101, Integer r102) {
        this.f433042a = r100;
        this.f433043b = r101;
        this.f433044c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        rsb.a r100 = this.f433042a.f433033c;     // Catch: Throwable -> L4
        Set<qsb.a> r101 = this.f433043b;     // Catch: Throwable -> L4
        Integer r102 = this.f433044c;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L4
        r100.V8(r101, r102.intValue());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
