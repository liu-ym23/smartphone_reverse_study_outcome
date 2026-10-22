package com.bytedance.pia.core.bridge.methods;

import android.net.Uri;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f266199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f266200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JsonObject f266201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List<String> f266202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l47.a<j.d> f266203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f266204f;

    public k(Uri r100, String r101, JsonObject r102, List r103, m47.h r104, m47.i r105) {
        this.f266199a = r100;
        this.f266200b = r101;
        this.f266201c = r102;
        this.f266202d = r103;
        this.f266203e = r104;
        this.f266204f = r105;
    }

    public final void a() {
        Keva r100 = o47.f.f521975a;     // Catch: Exception -> L7
        if (o47.f.f521979e.get() == true) goto L5;
        o47.f.e();     // Catch: Exception -> L7
    L5:
        this.f266203e.accept(new j.d(o47.f.p(this.f266199a, this.f266200b, this.f266201c, this.f266202d)));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        this.f266204f.accept(new PiaMethod.Error("[Cache] PIA Cache Save Failed, reason: (" + e.getMessage() + ')'));
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
