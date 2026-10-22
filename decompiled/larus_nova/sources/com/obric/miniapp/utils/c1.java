package com.obric.miniapp.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c1 {
    public static final b1 a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new b1(r100, r101);
    }

    public static final View b(View r100, float r101, float r102) {
        int[] r103 = new int[2];
        r100.getLocationOnScreen(r103);
        int r104 = r103[0];
        int r105 = r103[1];
        int r106 = r100.getWidth() + r104;
        int r107 = r100.getHeight() + r105;
        if (r101 >= r104) goto L5;
        return null;
    L5:
        if (r101 <= r106) goto L7;
        return null;
    L7:
        if (r102 >= r105) goto L9;
        return null;
    L9:
        if (r102 <= r107) goto L12;
        return null;
    L12:
        if ((r100 instanceof ViewGroup) == false) goto L20;
        ViewGroup r108 = (ViewGroup) r100;
        int r109 = r108.getChildCount() - 1;
    L15:
        if ((-1) >= r109) goto L20;
        View r110 = r108.getChildAt(r109);
        Intrinsics.checkNotNull(r110);
        View r111 = b(r110, r101, r102);
        if (r111 != null) goto L18;
        r109 = r109 - 1;
        goto L15
    L18:
        return r111;
    L20:
        return r100;
    }
}
