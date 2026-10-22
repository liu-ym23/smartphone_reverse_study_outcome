package com.bytedance.bdp.bdpbase.util;

import android.text.format.DateUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends DateUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f201334a = 0;

    public static String a(int r100) {
        if (r100 >= 10) goto L5;
        StringBuilder r101 = new StringBuilder("0");
    L6:
        r101.append(r100);
        return r101.toString();
    L5:
        r101 = new StringBuilder("");
        goto L6
    }

    public static int b(String r100) throws NumberFormatException {
    L7:
        e = move-exception;
        throw e;
    L3:
        if (r100.startsWith("0") == false) goto L5;
        r100 = r100.substring(1);     // Catch: NumberFormatException -> L7
    L5:
        return CastIntegerProtector.parseInt(r100);
    }
}
