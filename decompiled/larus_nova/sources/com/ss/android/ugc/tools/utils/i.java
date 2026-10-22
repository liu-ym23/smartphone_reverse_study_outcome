package com.ss.android.ugc.tools.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f454862a = 0;

    static {
    }

    @JvmStatic
    public static final int b(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        Resources r101 = r100.getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r102 != null) goto L8;
        return 0;
    L8:
        return r102.widthPixels;
    }

    @JvmStatic
    public static final boolean c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (ViewCompat.getLayoutDirection(r100) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmStatic
    public static final float a(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    }
}
