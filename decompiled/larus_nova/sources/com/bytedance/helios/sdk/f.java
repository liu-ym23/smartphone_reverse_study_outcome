package com.bytedance.helios.sdk;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.helios.sdk.detector.b f245575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f245576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PrivacyEvent f245577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f245578d;

    public f(com.bytedance.helios.sdk.detector.b r100, Throwable r101, PrivacyEvent r102, long r103) {
        this.f245575a = r100;
        this.f245576b = r101;
        this.f245577c = r102;
        this.f245578d = r103;
    }

    public final void a() {
        hz5.k.d("Helios-Log-Monitor-Ability-Api-Call", "handleInvoke id=" + this.f245577c.f245366c + " calledTime=" + this.f245578d + " eventSource=" + this.f245577c.f245364a);
        this.f245575a.f(this.f245577c, this.f245576b);
        hz5.g.f487690b.a(4, this.f245577c);
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
