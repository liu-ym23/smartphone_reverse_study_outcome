package com.suite.lark.emm.impl.clipboard.utils;

import android.content.ClipboardManager;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d {
    public static final void a(ClipboardManager r100) {
        Intrinsics.checkNotNullParameter(r100, "clipboardManager");
        Method r101 = r100.getClass().getDeclaredMethod("reportPrimaryClipChanged", new Class[0]);     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        r101.invoke(r100, new Object[0]);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("SCClipboardManager", "forceReportWebviewClipChanged failed: " + e);
    }
}
