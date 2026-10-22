package com.larksuite.framework.ui;

import android.app.Activity;

/* JADX INFO: loaded from: classes24.dex */
public final class c {
    public static boolean a(Activity r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isDestroyed() == false) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r100.isFinishing() == true) goto L9;
        r101 = true;
        goto L10
    }
}
