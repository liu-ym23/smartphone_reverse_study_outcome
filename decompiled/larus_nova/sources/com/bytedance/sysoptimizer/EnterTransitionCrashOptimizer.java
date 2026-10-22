package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public class EnterTransitionCrashOptimizer {
    private static Context sContext;

    public EnterTransitionCrashOptimizer() {
    }

    public static Context getContext() {
        return sContext;
    }

    public static void fix(Context r100) {
        sContext = r100;
    }
}
