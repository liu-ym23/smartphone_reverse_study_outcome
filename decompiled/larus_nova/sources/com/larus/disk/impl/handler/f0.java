package com.larus.disk.impl.handler;

import com.larus.disk.api.CacheHandlerBiz;
import com.larus.disk.api.CacheHandlerBusiness;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 implements com.larus.disk.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<File> f330697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f330698b;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return CacheHandlerBiz.BIZ_TTNET_DEBUG_LOG;
    }

    @Override // com.larus.disk.api.c
    public final String business() {
        return CacheHandlerBusiness.APP_TECH;
    }

    @Override // com.larus.disk.api.d
    public final boolean e(boolean r100) {
        return false;
    }

    @Override // com.larus.disk.api.d
    public final boolean f() {
        return true;
    }

    @Override // com.larus.disk.api.d
    public final boolean g() {
        return false;
    }

    @Override // com.larus.disk.api.c
    public final boolean i() {
        return true;
    }

    @Override // com.larus.disk.api.c
    public final String a() {
        return this.f330698b.getAbsolutePath();
    }

    @Override // com.larus.disk.api.c
    public final long getCacheSize() {
        if (this.f330698b.isFile() == true) goto L5;
        return 0;
    L5:
        return RangesKt.coerceAtLeast(this.f330698b.length(), 0);
    }

    @Override // com.larus.disk.api.d
    public final long d() {
        return getCacheSize();
    }

    public f0(Object r100) {
        Function0<File> r101 = new e0();
        Intrinsics.checkNotNullParameter(r101, "debugLogProvider");
        this.f330697a = r101;
        this.f330698b = (File) r101.invoke();
    }

    @Override // com.larus.disk.api.c
    public final long b(boolean r100) {
        return getCacheSize();
    }

    @Override // com.larus.disk.api.d
    public final boolean c(boolean r100, boolean r101) {
        return com.larus.disk.api.d.a.a(this, r100, r101);
    }

    @Override // com.larus.disk.api.c
    public final void h(boolean r100, boolean r101) {
        if (r101 == false) goto L35;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(this.f330698b.isFile()));     // Catch: Throwable -> L5
    L7:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L11;
        r103 = r104;
    L11:
        if (((Boolean) r103).booleanValue() == false) goto L37;
    L22:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L24:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L28;
        r106 = r107;
    L28:
        if (((Boolean) r106).booleanValue() == true) goto L36;
        FLogger.f375446a.w("TTNetDebugLogHandler", "Failed to delete stale TTNet debug log");
        return;
    L36:
        return;
    L14:
        if (this.f330698b.delete() == false) goto L16;
    L19:
        boolean r108 = true;
    L20:
        r106 = Result.m9449constructorimpl(Boolean.valueOf(r108));     // Catch: Throwable -> L22
        goto L24
    L16:
        if (this.f330698b.exists() == false) goto L19;
        r108 = false;
        goto L20
    L37:
        return;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
