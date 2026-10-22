package com.larus.init.task.imsdk;

import com.larus.utils.logger.FLogger;
import gd9.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class q implements h {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    @Override // gd9.h
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.d(r2, r3);
    }

    @Override // gd9.h
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.e(r2, r3);
    }

    @Override // gd9.h
    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.i(r2, r3);
    }

    @Override // gd9.h
    public final void v(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.v(r2, r3);
    }

    @Override // gd9.h
    public final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.w(r2, r3);
    }

    @Override // gd9.h
    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.e(r2, r3, r4);
    }

    @Override // gd9.h
    public final void w(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.w(r2, r3, r4);
    }
}
