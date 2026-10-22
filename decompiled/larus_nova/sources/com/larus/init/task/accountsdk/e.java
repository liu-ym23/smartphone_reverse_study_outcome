package com.larus.init.task.accountsdk;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements d48.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f351141a = null;

    static {
        f351141a = new e();
    }

    public e() {
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.e(r100, r101);
    }

    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.i(r100, r101);
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.v(r100, r101);
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.w(r100, r101);
    }

    public final void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.e(r100, r101, r102);
    }

    public final void f(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.w(r100, r101, r102);
    }
}
