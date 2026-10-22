package com.bytedance.awemeopen.apps.framework.utils;

import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class l {
    public static void a(final View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.animate().scaleX(0.8f).scaleY(0.8f).setDuration(80).withEndAction(new k(r100)).start();
    }
}
