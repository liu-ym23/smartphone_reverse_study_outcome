package com.bytedance.awemeopen.infra.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f198964a = -1.0f;

    public static int a(Context r100, float r101) {
        float r102 = f198964a;
        if (r102 >= 0.0f) goto L9;
        DisplayMetrics r103 = new DisplayMetrics();     // Catch: Exception -> L7
        ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getMetrics(r103);     // Catch: Exception -> L7
        r102 = r103.density;     // Catch: Exception -> L7
        f198964a = r102;     // Catch: Exception -> L7
    L7:
        r102 = 2.0f;
    L9:
        return (int) ((r101 * r102) + 0.5f);
    }
}
