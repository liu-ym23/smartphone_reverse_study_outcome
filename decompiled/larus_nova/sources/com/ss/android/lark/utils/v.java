package com.ss.android.lark.utils;

import android.content.Intent;

/* JADX INFO: loaded from: classes38.dex */
public final class v {
    public static Intent a(Intent r100) {
        int r101 = EasyIntent.f444661a;
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof EasyIntent) == false) goto L9;
        return r100;
    L9:
        return new EasyIntent(r100);
    }
}
