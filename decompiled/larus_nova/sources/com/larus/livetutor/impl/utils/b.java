package com.larus.livetutor.impl.utils;

import android.content.Context;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes30.dex */
public final class b {
    public static final boolean a(Context r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Lazy r101 = we8.j.f559406a;
        int r102 = we8.j.f559408c;
        if (r102 != (-1)) goto L11;
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L14;
    L12:
        return true;
    L14:
        return false;
    L11:
        if (r102 == 2) goto L12;
        return false;
    }
}
