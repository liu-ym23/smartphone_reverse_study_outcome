package com.suite.component.logger;

import com.suite.component.logger.api.h;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Deprecated(message = "in gray progress, do not use it directly for the moment")
public final class Log {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.suite.component.logger.api.b f460087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h f460088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f460089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f460090d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static com.suite.lark.component.logger.dynamic.a f460091e;

    static {
        a.C5516a r100 = new a.C5516a(new b(0));
        com.suite.component.logger.api.g r101 = new com.suite.component.logger.api.g();
        Intrinsics.checkNotNullParameter(r101, "printer");
        r100.f460104f.add(r101);
        f460087a = r100;
        f460088b = r100.a();
        f460090d = LazyKt.lazy(Log$loggerCache$2.INSTANCE);
    }

    public static void a(String r100, Throwable r101, int r102) {
        if ((r102 & 4) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter("KevaSharedPreferences", "tag");
        h r103 = f460088b;
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        r103.g("KevaSharedPreferences", r100, r101, false);
    }
}
