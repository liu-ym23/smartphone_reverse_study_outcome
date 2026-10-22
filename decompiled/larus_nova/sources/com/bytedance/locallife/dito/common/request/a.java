package com.bytedance.locallife.dito.common.request;

import com.bytedance.locallife.dito.common.settings.DitoCommonSettings;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f257658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f257659b;

    static {
    }

    public static boolean a(boolean r100) {
        if ((f257658a + f257659b) < DitoCommonSettings.a().getDitoChunkDowngradeThreshold()) goto L7;
        return false;
    L7:
        return !r100;
    }
}
