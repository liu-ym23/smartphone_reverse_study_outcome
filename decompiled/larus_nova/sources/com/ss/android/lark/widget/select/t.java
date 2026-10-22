package com.ss.android.lark.widget.select;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.larksuite.framework.utils.RomUtils;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.utils.i0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class t {
    static {
    }

    @JvmStatic
    public static final int a(int r100, Context r101) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return r100;
    L5:
        if ((r101 instanceof Activity) == true) goto L7;
        return r100;
    L7:
        if (RomUtils.h() == false) goto L19;
        int r102 = i0.f444722a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r101.getResources().getConfiguration().screenLayout & 15) < 3) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L16;
        if (((Activity) r101).isInMultiWindowMode() == true) goto L16;
        return r100;
    L16:
        return r100 - StatusBarUtil.getStatusBarHeight(r101);
    L11:
        r103 = false;
        goto L12
    L19:
        return r100;
    }
}
