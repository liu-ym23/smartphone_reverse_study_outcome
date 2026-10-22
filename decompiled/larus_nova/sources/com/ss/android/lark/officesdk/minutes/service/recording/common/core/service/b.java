package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f434409a;

    public b(Function0<Unit> r100) {
        this.f434409a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MinutesForegroundService.Companion r100 = MinutesForegroundService.f434224h;     // Catch: Throwable -> L4
        MinutesForegroundService.Companion.e(this.f434409a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
