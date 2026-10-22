package com.bytedance.ies.xbridge.base.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f249457a = 0;

    static {
    }

    public static int a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return r100.getResources().getDimensionPixelSize(r101);
    }
}
