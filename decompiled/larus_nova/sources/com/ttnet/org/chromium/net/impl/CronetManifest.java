package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public final class CronetManifest {
    static final String METRICS_OPT_IN_META_DATA_STR = "com.ttnet.org.chromium.net.CronetMetricsOptIn";

    private CronetManifest() {
    }

    public static boolean isAppOptedInForTelemetry(Context r100, CronetLogger.CronetSource r101) {
        Bundle r102 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData;     // Catch: PackageManager.NameNotFoundException -> L8
        if (r102 == null) goto L11;
        return r102.getBoolean(METRICS_OPT_IN_META_DATA_STR);
    L11:
        return false;
    L12:
        return false;
    }
}
