package com.ss.android.lark.permission;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static boolean a(Context r100, String r101) {
        if (ContextCompat.checkSelfPermission(r100, r101) != 0) goto L6;
        return true;
    L6:
        return false;
    }
}
