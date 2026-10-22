package com.ss.android.lark.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j0 {
    static {
    }

    @JvmStatic
    public static final Intent a(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        PackageManager r102 = r100.getPackageManager();
        if (r102 != null) goto L5;
        return null;
    L5:
        Intent r103 = r102.getLaunchIntentForPackage(r100.getPackageName());
        if (r103 != null) goto L8;
        return null;
    L8:
        r103.addFlags(335544320);
        r103.removeCategory("android.intent.category.LAUNCHER");
        r103.setAction(null);
        r103.putExtras(r101);
        return r103;
    }
}
