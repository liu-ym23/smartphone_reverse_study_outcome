package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if ((r1.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }
}
