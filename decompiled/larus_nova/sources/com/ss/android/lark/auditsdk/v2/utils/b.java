package com.ss.android.lark.auditsdk.v2.utils;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f409697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f409698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f409699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f409700d;

    public b(Integer r100, String r101, Integer r102, Context r103) {
        this.f409697a = r100;
        this.f409698b = r101;
        this.f409699c = r102;
        this.f409700d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lazy r100 = AuditUtilsV2.f409687a;     // Catch: Throwable -> L6
        String r101 = AuditUtilsV2.a(this.f409697a, this.f409698b, this.f409699c);     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        Context r102 = this.f409700d;     // Catch: Throwable -> L6
        Log.i("AuditUtilsV2", "Show authorization failed toast, msg = ".concat(r101));     // Catch: Throwable -> L6
        UDToast.show(r102, r101);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
