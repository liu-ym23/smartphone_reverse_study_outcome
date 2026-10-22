package com.bytedance.awemeopen.apps.framework.utils;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l {
    public static void a(final View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.animate().scaleX(0.8f).scaleY(0.8f).setDuration(80).withEndAction(new k(r3)).start();
    }
}
