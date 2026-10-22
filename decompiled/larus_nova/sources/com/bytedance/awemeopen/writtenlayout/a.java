package com.bytedance.awemeopen.writtenlayout;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f199012a;

    static {
        f199012a = -1.0f;
    }

    public static int a(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        float r102 = f199012a;
        if (r102 > 0.0f) goto L7;
        DisplayMetrics r103 = new DisplayMetrics();
        Object r104 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) r104).getDefaultDisplay().getMetrics(r103);
        r102 = r103.density;
        f199012a = r102;
    L7:
        return (int) ((r101 * r102) + 0.5f);
    }
}
