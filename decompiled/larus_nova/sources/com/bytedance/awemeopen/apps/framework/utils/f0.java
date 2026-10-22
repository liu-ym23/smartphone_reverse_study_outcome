package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f197695a = 0;

    static {
    }

    public static boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }
}
