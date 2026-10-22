package com.bytedance.pia.core.bridge.methods;

import com.bytedance.keva.Keva;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l47.a<h.d> f266191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f266192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f266193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f266194d;

    public i(m47.h r100, String r101, m47.i r102, String r103) {
        this.f266191a = r100;
        this.f266192b = r101;
        this.f266193c = r102;
        this.f266194d = r103;
    }

    public final void a() {
        Keva r100 = o47.f.f521975a;     // Catch: Exception -> L11
        boolean r101 = false;
        if (o47.f.f521979e.get() == true) goto L6;
        this.f266191a.accept(new h.d(false));     // Catch: Exception -> L11
        return;
    L6:
        Keva r102 = o47.f.d(this.f266192b);     // Catch: Exception -> L11
        if (r102 == null) goto L9;
        r101 = o47.f.b(this.f266194d, r102);     // Catch: Exception -> L11
    L9:
        this.f266191a.accept(new h.d(r101));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        this.f266193c.accept(new PiaMethod.Error("[Cache] PIA Cache Remove Failed, reason: (" + e.getMessage() + ')'));
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
