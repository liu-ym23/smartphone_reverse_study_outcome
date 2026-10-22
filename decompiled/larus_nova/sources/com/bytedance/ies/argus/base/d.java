package com.bytedance.ies.argus.base;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f245942a = 0;

    static {
    }

    public d() {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        HybridLogger r102 = HybridLogger.f246343a;
        HybridLogger.f("Argus", "[" + r100 + ']' + r101, null, 8);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        HybridLogger r102 = HybridLogger.f246343a;
        HybridLogger.m("Argus", "[" + r100 + ']' + r101, null, null, 8);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        HybridLogger r102 = HybridLogger.f246343a;
        HybridLogger.p("Argus", "[" + r100 + ']' + r101, null, 8);
    }

    public static void b(String r100, String r101, Exception r102, int r103) {
        if ((r103 & 8) == 0) goto L5;
        r102 = null;
    L5:
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102 != null) goto L8;
        HybridLogger r104 = HybridLogger.f246343a;
        HybridLogger.i("Argus", "[" + r100 + ']' + r101, null, 8);
        return;
    L8:
        HybridLogger r105 = HybridLogger.f246343a;
        HybridLogger.i("Argus", "[" + r100 + "][crash]" + r101 + ",e=" + r102 + ',' + ExceptionsKt.stackTraceToString(r102), null, 8);
    }
}
