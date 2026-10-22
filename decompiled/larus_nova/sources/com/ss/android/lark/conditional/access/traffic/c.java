package com.ss.android.lark.conditional.access.traffic;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f418432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f418433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ byte[] f418434c;

    public c(String r100, a r101, byte[] r102) {
        this.f418432a = r100;
        this.f418433b = r101;
        this.f418434c = r102;
    }

    public final void a() {
        String r100 = this.f418432a;
        a r101 = this.f418433b;
        byte[] r102 = this.f418434c;
        String r103 = qqb.a.d();     // Catch: Throwable -> L9
        qqb.a.f(r100);     // Catch: Throwable -> L7
        a.a(r101, r102);     // Catch: Throwable -> L7
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r103, "traceId");
        qqb.a.g(r103);
        return;
    L7:
        th = th;
    L11:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r103, "traceId");
        qqb.a.g(r103);
        throw th;
    L9:
        th = th;
        r103 = "";
        goto L11
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
