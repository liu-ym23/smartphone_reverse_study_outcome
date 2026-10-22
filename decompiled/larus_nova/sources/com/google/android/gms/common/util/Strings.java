package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: classes23.dex */
public class Strings {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private static final Pattern f274606zza = null;

    static {
        f274606zza = PatternProtector.compile("\\$\\{(.*?)\\}");
    }

    private Strings() {
    }

    public static String emptyToNull(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        return r100;
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = false)
    public static boolean isEmptyOrWhitespace(String r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.trim().isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }
}
