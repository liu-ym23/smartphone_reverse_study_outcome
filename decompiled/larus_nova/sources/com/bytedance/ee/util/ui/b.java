package com.bytedance.ee.util.ui;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static boolean a(Activity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isDestroyed() == false) goto L8;
        return false;
    L8:
        if (r100.isFinishing() == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean b(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Activity) == false) goto L12;
        Activity r101 = (Activity) r100;
        if (r101.isDestroyed() == false) goto L10;
    L11:
        return false;
    L10:
        if (r101.isFinishing() == true) goto L11;
        return true;
    L12:
        return true;
    }
}
