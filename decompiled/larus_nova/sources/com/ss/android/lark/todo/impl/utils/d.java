package com.ss.android.lark.todo.impl.utils;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444279a = 0;

    static {
    }

    public static boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100 instanceof Activity) == true) goto L5;
    L7:
        return false;
    L5:
        if (com.ss.android.lark.base.embedded.b.b((Activity) r100) == false) goto L7;
        return true;
    }
}
