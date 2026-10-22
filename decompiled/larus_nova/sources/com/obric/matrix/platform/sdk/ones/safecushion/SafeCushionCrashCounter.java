package com.obric.matrix.platform.sdk.ones.safecushion;

import hka.b;
import hka.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class SafeCushionCrashCounter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f397007a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f397008b = null;

    static {
        new b();
        Lazy r100 = LazyKt.lazy(SafeCushionCrashCounter$isMainProcess$2.INSTANCE);
        f397007a = r100;
        Lazy r101 = LazyKt.lazy(SafeCushionCrashCounter$isSafeProcess$2.INSTANCE);
        f397008b = r101;
        if (((Boolean) r100.getValue()).booleanValue() == false) goto L12;
        Intrinsics.checkNotNullParameter("supposeCrash", "crashFileNamePrefix");
        c.b("supposeCrash");
        Intrinsics.checkNotNullParameter("crashInfo", "crashFileNamePrefix");
        c.b("crashInfo");
        if (((Boolean) r100.getValue()).booleanValue() == false) goto L12;
        if (((Boolean) r100.getValue()).booleanValue() == false) goto L12;
        int r102 = a.f397009a;
        a.C4652a.a();
        throw null;
    L12:
        if (((Boolean) r101.getValue()).booleanValue() == false) goto L15;
        int r103 = c.f485612a;
        Intrinsics.checkNotNullParameter("safeModeFlag", "fileNamePrefix");
        c.b("safeModeFlag");
        b.a("repair");
        return;
    }
}
