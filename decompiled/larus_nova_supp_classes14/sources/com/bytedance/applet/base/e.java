package com.bytedance.applet.base;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements g2.d {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.d(r2, r3);
    }

    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.e(r2, r3);
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.i(r2, r3);
    }

    public final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.w(r2, r3);
    }

    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.e(r2, r3, r4);
    }

    public final void w(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.w(r2, r3, r4);
    }
}
