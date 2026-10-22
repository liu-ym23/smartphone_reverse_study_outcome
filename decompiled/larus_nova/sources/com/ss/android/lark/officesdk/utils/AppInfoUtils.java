package com.ss.android.lark.officesdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.ss.android.lark.officesdk.utils.di.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes37.dex */
public final class AppInfoUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PackageInfo f437184a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface VERSION_TYPE {
        public static final String VERSION_ALPHA = "alpha";
        public static final String VERSION_BETA = "beta";
        public static final String VERSION_RELEASE = "release";
    }

    public static String a(Context r100) {
        if (f437184a == null) goto L13;
    L8:
        PackageInfo r101 = f437184a;
        if (r101 != null) goto L12;
        return "";
    L12:
        return r101.versionName;
    L13:
        f437184a = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        j.f("InfoProviderUtils", th.toString());
        goto L8
    }
}
