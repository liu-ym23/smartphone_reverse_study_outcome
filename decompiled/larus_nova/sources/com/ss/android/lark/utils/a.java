package com.ss.android.lark.utils;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static boolean a(Context r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if ((r100 instanceof Activity) == true) goto L8;
        return true;
    L8:
        Activity r101 = (Activity) r100;
        if (r101.isDestroyed() == false) goto L11;
    L12:
        return false;
    L11:
        if (r101.isFinishing() == true) goto L12;
        return true;
    }
}
