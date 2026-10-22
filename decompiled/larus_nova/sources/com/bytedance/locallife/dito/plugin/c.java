package com.bytedance.locallife.dito.plugin;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static final boolean a(View r100) {
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getWidth() <= 1) goto L9;
        if (r100.getHeight() <= 1) goto L9;
        return true;
    }
}
