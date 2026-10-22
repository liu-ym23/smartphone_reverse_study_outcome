package com.ss.bytertc.engine.video;

/* JADX INFO: loaded from: classes40.dex */
public class EffectResourceFinderAdapter {
    public static IRtcResourceFinder sFinder;

    public EffectResourceFinderAdapter() {
    }

    public static long CreateNativeResourceFinder(long r100) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        IRtcResourceFinder r101 = sFinder;
        if (r101 != null) goto L9;
        return 0;
    L9:
        return r101.createNativeResourceFinder(r100);
    }

    public static void ReleaseNativeResourceFinder(long r100) {
        sFinder.release(r100);
    }
}
