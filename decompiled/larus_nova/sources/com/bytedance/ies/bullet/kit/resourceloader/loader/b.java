package com.bytedance.ies.bullet.kit.resourceloader.loader;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f246865a = 0;

    static {
    }

    public static double b(PolarisFileWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "f");
        if (r100.exists() == true) goto L5;
    L36:
        int r101 = 0;
    L38:
        return ((double) MathKt.roundToInt((((double) r101) / 1024.0d) * ((double) 100))) / 100.0d;
    L5:
        if (r100.isDirectory() == true) goto L36;
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L18 Exception -> L20
        r101 = r103.available();     // Catch: Throwable -> L14 Exception -> L16
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r103.close();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L16:
        e = e;
        r102 = r103;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r102 == null) goto L36;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.close();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
    L14:
        th = th;
    L29:
        if (r103 == null) goto L35;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r103.close();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L35:
        throw th;
    L20:
        e = e;
    L18:
        th = th;
        r103 = r102;
        goto L29
    }

    public static String c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isHierarchical() == false) goto L5;
        return r100.buildUpon().clearQuery().toString();
    L9:
        return r100.toString();
    L5:
        return r100.toString();
    }

    public static boolean d(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "bundle");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r100;
    L9:
        return r100 + '/' + StringsKt.removePrefix(r101, HTTP.URL_DEFAULT);
    L5:
        r102 = false;
        goto L6
    }
}
