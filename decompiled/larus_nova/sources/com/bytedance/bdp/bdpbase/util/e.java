package com.bytedance.bdp.bdpbase.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f201335a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f201336b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static float f201337c = -1.0f;

    public static float a(Context r100) {
        float r101 = f201337c;
        if (r101 < 0.0f) goto L9;
        return r101;
    L9:
        DisplayMetrics r102 = new DisplayMetrics();     // Catch: Exception -> L7
        ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getMetrics(r102);     // Catch: Exception -> L7
        float r103 = r102.density;     // Catch: Exception -> L7
        f201337c = r103;     // Catch: Exception -> L7
        return r103;
    L7:
        return 2.0f;
    }
}
