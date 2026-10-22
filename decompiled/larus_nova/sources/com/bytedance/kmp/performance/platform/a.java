package com.bytedance.kmp.performance.platform;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final Window a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Activity) == false) goto L6;
        return ((Activity) r100).getWindow();
    L6:
        if ((r100 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return a(((ContextWrapper) r100).getBaseContext());
    }
}
