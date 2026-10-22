package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static void a() {
        StackTraceElement r100 = new Throwable().getStackTrace()[1];
        r100.getFileName();
        r100.getLineNumber();
        r100.getMethodName();
    }

    public static void b() {
        StackTraceElement r100 = new Throwable().getStackTrace()[1];
        r100.getFileName();
        r100.getLineNumber();
    }

    public static String d(View r100) {
        return r100.getContext().getResources().getResourceEntryName(r100.getId());
    L4:
        return "UNKNOWN";
    }

    public static String c(Context r100, int r101) {
        if (r101 != (-1)) goto L10;
        return "UNKNOWN";
    L10:
        return r100.getResources().getResourceEntryName(r101);
    L9:
        return "?" + r101;
    }

    public static String e(MotionLayout r100, int r101) {
        if (r101 != (-1)) goto L6;
        return "UNDEFINED";
    L6:
        return r100.getContext().getResources().getResourceEntryName(r101);
    }
}
