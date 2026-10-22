package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class l0 implements com.lynx.tasm.base.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f383476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.lynx.tasm.base.e f383477b;

    public /* synthetic */ l0(AtomicBoolean r100, k0 r101) {
        this.f383476a = r100;
        this.f383477b = r101;
    }

    @Override // com.lynx.tasm.base.e
    public final void accept(Object r100) {
        AtomicBoolean r101 = this.f383476a;
        com.lynx.tasm.base.e r102 = this.f383477b;
        r0 r103 = (r0) r100;
        if (r101.compareAndSet(false, true) == false) goto L11;
        r102.accept(r103);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        LLog.e("LynxMemoryCollector", "Failed to handle Lynx memory usage fetcher result: " + th.getMessage());
        return;
    }
}
