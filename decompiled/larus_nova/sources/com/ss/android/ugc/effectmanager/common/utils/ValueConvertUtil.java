package com.ss.android.ugc.effectmanager.common.utils;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes40.dex */
public class ValueConvertUtil {
    public ValueConvertUtil() {
    }

    public static long ConvertStringToLong(String r100, long r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (r100.isEmpty() == true) goto L14;
        return CastLongProtector.valueOf(r100).longValue();
    L8:
        e = move-exception;
        e.printStackTrace();
        return r101;
    L14:
        return r101;
    }
}
