package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f411298a = 0;

    public d() {
    }

    static {
        int r100 = com.ss.android.lark.officesdk.utils.di.d.f437220a;
        Resources r101 = com.ss.android.lark.officesdk.utils.di.d.a.a().getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        f411298a = (((long) r102.widthPixels) * ((long) r102.heightPixels)) * 4;
    }

    public static boolean a() {
        long r100 = f411298a + ((long) BmLocated.ALIGN_RIGHT_BOTTOM);
        Runtime r101 = Runtime.getRuntime();
        long r102 = r101.freeMemory();
        long r103 = r101.totalMemory();
        long r104 = r101.maxMemory();
        long r105 = r104 - (r103 - r102);
        j.a("CML_TAG_MemoryUtils", "isAppHeapLow, free: " + r102 + ", total: " + r103 + ", max: " + r104 + ", remain: " + r105 + ", requiredBytes: " + r100);
        if (r105 >= r100) goto L5;
        return true;
    L5:
        return false;
    }
}
