package com.bytedance.awemeopen.apps.framework.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Activity a(Context r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof Application) == false) goto L9;
        return null;
    L9:
        if ((r2 instanceof Activity) == false) goto L13;
        return (Activity) r2;
    L13:
        if ((r2 instanceof ContextWrapper) == true) goto L15;
        return null;
    L15:
        return a(((ContextWrapper) r2).getBaseContext());
    }

    public static boolean b(r14.c r1) {
        d14.a r0 = b14.a.a;
        if (b14.a.a(x24.a.class).G2(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (b14.a.a(x24.a.class).f2(r1) == true) goto L8;
        return false;
    }
}
