package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l47.a<f.d> f266182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f266183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f266184c;

    public g(m47.h r100, String r101, m47.i r102) {
        this.f266182a = r100;
        this.f266183b = r101;
        this.f266184c = r102;
    }

    public final void a() {
    L14:
        e = move-exception;
        this.f266184c.accept(new PiaMethod.Error("[Cache] PIA Cache Get Headers Failed, reason: (" + e.getMessage() + ')'));
        return;
    L3:
        if (o47.f.f521979e.get() == true) goto L6;
        this.f266182a.accept(new f.d(new JsonObject()));     // Catch: Exception -> L14
        return;
    L6:
        JsonObject r100 = null;
        o47.a.C7013a r101 = o47.f.l(this.f266183b, null);     // Catch: Exception -> L14
        if (r101 == null) goto L9;
        r100 = r101.h();     // Catch: Exception -> L14
    L9:
        l47.a<f.d> r102 = this.f266182a;     // Catch: Exception -> L14
        if (r100 != null) goto L12;
        r100 = new JsonObject();     // Catch: Exception -> L14
    L12:
        r102.accept(new f.d(r100));     // Catch: Exception -> L14
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
