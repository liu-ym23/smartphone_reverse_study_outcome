package com.bytedance.ee.bear.bitable.lynx;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableCCMLynxPlugin.a f214624a;

    public b(BitableCCMLynxPlugin.a r100) {
        this.f214624a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BitableCCMLynxPlugin.a r100 = this.f214624a;     // Catch: Throwable -> L11
        ActionPayload r101 = r100.f214620g;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        m r102 = r100.f214619f;     // Catch: Throwable -> L11
        if (r102 == null) goto L7;
        r102.a(r101);     // Catch: Throwable -> L11
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L8:
        if (r103 == null) goto L9;
        return;
    L7:
        r103 = null;
    L9:
        this.f214624a.a();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
