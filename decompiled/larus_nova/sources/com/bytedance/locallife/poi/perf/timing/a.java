package com.bytedance.locallife.poi.perf.timing;

import java.util.Arrays;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f263713a = 0;

    static {
    }

    public static void a(String r100, Pair... r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        int r102 = PoiTimingLogger.f263711a;
        Pair[] r103 = (Pair[]) Arrays.copyOf(r101, r101.length);
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r103, "extra");
    }

    public static void b(String r100, Pair... r101) {
        Intrinsics.checkNotNullParameter(r100, "markName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        int r102 = PoiTimingLogger.f263711a;
        Pair[] r103 = (Pair[]) Arrays.copyOf(r101, r101.length);
        Intrinsics.checkNotNullParameter(r100, "markName");
        Intrinsics.checkNotNullParameter(r103, "extra");
    }

    public static void c(String r100, Pair... r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        int r102 = PoiTimingLogger.f263711a;
        Pair[] r103 = (Pair[]) Arrays.copyOf(r101, r101.length);
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r103, "extra");
    }
}
