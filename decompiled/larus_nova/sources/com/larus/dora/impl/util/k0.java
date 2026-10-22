package com.larus.dora.impl.util;

import com.larus.utils.logger.FLogger;
import com.ss.android.agilelogger.ALog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class k0 implements pk4.g {
    public k0() {
    }

    @Override // pk4.g
    public final void a(String r100) {
        Lazy r101 = q.f338153a;
        Intrinsics.checkNotNullParameter("LinkWrapper@8321b42", "tag");
        Intrinsics.checkNotNullParameter(r100, "message");
        ALog.p r102 = (ALog.p) q.f338153a.getValue();
        if (r102 == null) goto L5;
        r102.b("LinkWrapper@8321b42", r100);
        return;
    L5:
        FLogger.f375446a.i("LinkWrapper@8321b42", r100);
    }

    @Override // pk4.g
    public final void d(String r100, String r101) {
        FLogger.f375446a.d("" + r100, r101);
    }

    @Override // pk4.g
    public final void e(String r100, String r101) {
        FLogger.f375446a.e(r100, r101);
    }

    @Override // pk4.g
    public final void i(String r100, String r101) {
        FLogger.f375446a.i(r100, r101);
    }

    @Override // pk4.g
    public final void v(String r100, String r101) {
        FLogger.f375446a.v(r100, r101);
    }

    @Override // pk4.g
    public final void w(String r100, String r101) {
        FLogger.f375446a.w(r100, r101);
    }

    @Override // pk4.g
    public final void w(String r100, Throwable r101) {
        FLogger.f375446a.w(r100, r101);
    }

    @Override // pk4.g
    public final void e(String r100, String r101, Throwable r102) {
        FLogger.f375446a.e(r100, r101, r102);
    }

    @Override // pk4.g
    public final void i(String r100, String r101, Throwable r102) {
        FLogger.f375446a.i(r100, r101 + r102);
    }

    @Override // pk4.g
    public final void w(String r100, String r101, Throwable r102) {
        FLogger.f375446a.w(r100, r101, r102);
    }
}
