package com.ss.android.floatbubble.util;

import android.text.TextUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import xta.a;

/* JADX INFO: loaded from: classes34.dex */
public final class RomUtils {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RomName {
    }

    public static String a(String r100) {
        Method r101 = a.f565074a;
        if (r101 != null) goto L17;
        return null;
    L17:
        String r102 = (String) r101.invoke(null, new Object[]{r100});     // Catch: Exception -> L16
        if (r102 != null) goto L8;
        String r103 = null;
    L9:
        if (TextUtils.isEmpty(r103) == false) goto L12;
        r103 = null;
    L12:
        if (r103 != null) goto L15;
        return null;
    L15:
        return r103;
    L8:
        r103 = r102.trim();     // Catch: Exception -> L16
    L21:
        return null;
    }
}
