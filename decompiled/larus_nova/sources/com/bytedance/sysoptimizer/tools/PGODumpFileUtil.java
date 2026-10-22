package com.bytedance.sysoptimizer.tools;

import android.content.Context;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes22.dex */
public class PGODumpFileUtil {
    private static final String TAG = "PGODumpFileUtil";

    public PGODumpFileUtil() {
    }

    private static native int dump_pgo_profile(String r100, String r101);

    public static synchronized int dumpPGOProfile(Context r100, String r101, String r102) {
        monitor-enter(PGODumpFileUtil.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L18;
    L9:
        monitor-exit(PGODumpFileUtil.class);
        return -1;
    L18:
        int r103 = dump_pgo_profile(r101, r102);     // Catch: Throwable -> L15 Throwable -> L12
        monitor-exit(PGODumpFileUtil.class);
        return r103;
        goto L9
    }
}
