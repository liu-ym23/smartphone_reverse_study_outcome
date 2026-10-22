package com.bytedance.locallife.dito.common.plugin;

import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes21.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualRefreshPageTask f257593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f257594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Throwable f257595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f257596d;

    public z(VirtualRefreshPageTask r100, String r101, Throwable r102, int r103) {
        this.f257593a = r100;
        this.f257594b = r101;
        this.f257595c = r102;
        this.f257596d = r103;
    }

    public final void a() {
        VirtualRefreshPageTask r100 = this.f257593a;
        String r101 = this.f257594b;
        Throwable r102 = this.f257595c;
        int r103 = this.f257596d;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        ((r) r100.f257538p.getValue()).e();     // Catch: Throwable -> L8
        s r105 = r100.f257525c;     // Catch: Throwable -> L8
        if (r105 == null) goto L6;
        r105.GL(r101, r102, r103);     // Catch: Throwable -> L8
    L6:
        r100.g(false, r103, "error:" + r101 + ",param:" + r100.f257524b + ",stack trace:\n" + Log.getStackTraceString(r102));     // Catch: Throwable -> L8
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L16;
        VirtualRefreshPageTask r108 = this.f257593a;
        r108.g(false, this.f257596d, "error:" + r107.getMessage() + ",param:" + r108.f257524b + ",onFailed error,stack trace:\n" + Log.getStackTraceString(this.f257595c));
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
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
