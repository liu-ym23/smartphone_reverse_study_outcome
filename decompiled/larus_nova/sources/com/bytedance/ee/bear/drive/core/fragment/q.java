package com.bytedance.ee.bear.drive.core.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes16.dex */
public final class q {
    public static final Activity a(Context r100) {
        if ((r100 instanceof Activity) == false) goto L6;
        return (Activity) r100;
    L6:
        if ((r100 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return a(((ContextWrapper) r100).getBaseContext());
    }
}
