package com.bytedance.locallife.biz.perf;

import com.bytedance.locallife.dito.host.perf.PerfStandard;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f256842a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f256843a = null;

        static {
            int[] r100 = new int[PerfStandard.values().length];
            r100[PerfStandard.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[PerfStandard.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f256843a = r100;
        }
    }

    static {
        f256842a = new b();
    }

    public b() {
    }
}
