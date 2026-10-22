package com.ss.android.token;

import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f449782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f449783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f449784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f449785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f449786e;

    public q(long r100, String r101, String r102, String r103, String r104) {
        this.f449782a = r100;
        this.f449783b = r101;
        this.f449784c = r102;
        this.f449785d = r103;
        this.f449786e = r104;
    }

    public final void a() {
        AuthTokenMultiProcessSharedProvider.b r100 = r.f449787a;
        Object r101 = r.f449798l;
        monitor-enter(r101);
        long r102 = SystemClock.elapsedRealtime() - this.f449782a;     // Catch: Throwable -> L21
        tb7.a.d("TokenFactory", "delayCheckSp(), start, scene: " + this.f449783b + ", checkInterval: " + r102);     // Catch: Throwable -> L21
        AuthTokenMultiProcessSharedProvider.b r103 = r.f449787a;     // Catch: Throwable -> L21
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L21
    L7:
        String r104 = r103.f(LoginVerifyService.X_TT_TOKEN);     // Catch: Throwable -> L21
        AuthTokenMultiProcessSharedProvider.b r105 = r.f449787a;     // Catch: Throwable -> L21
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L21
    L10:
        String r106 = r105.f("ts_sign");     // Catch: Throwable -> L21
        AuthTokenMultiProcessSharedProvider.b r107 = r.f449787a;     // Catch: Throwable -> L21
        if (r107 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L21
    L13:
        String r108 = r107.f("token_tlb_tag");     // Catch: Throwable -> L21
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r101);
        String r110 = "x-tt-token=" + r.a(this.f449784c, r104) + ",ts_sign=" + r.a(this.f449785d, r106) + ",token-tlb-tag=" + r.a(this.f449786e, r108);
        tb7.a.d("TokenFactory", "delayCheckSp(), start, scene: " + this.f449783b + ", checkResult: " + r110);
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L18
        r111.put("scene", this.f449783b);     // Catch: Exception -> L18
        r111.put(LocationMonitorConst.CHECK_RESULT, r110);     // Catch: Exception -> L18
        r111.put("check_interval", r102);     // Catch: Exception -> L18
        com.bytedance.sdk.account.monitor.a.a("passport_token_sp_check_result", r111);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        tb7.a.c("TokenFactory", "delayCheckSp error", e);
        return;
    L21:
        th = move-exception;
        throw th;
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
