package com.larus.chat.gallery.impl.preview.datasource;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f324277a = null;

    static {
        f324277a = new n();
    }

    public n() {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        String r101 = StringsKt.trim(r100).toString();
        boolean r102 = true;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L28;
        return r101;
    L28:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L16
        String r105 = UriProtector.parse(r101).getScheme();     // Catch: Throwable -> L16
        if (r105 != null) goto L11;
    L13:
        r102 = false;
    L14:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L16
    L18:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L22;
        r106 = r107;
    L22:
        if (((Boolean) r106).booleanValue() == false) goto L25;
        return r101;
    L25:
        if (StringsKt.startsWith$default(r101, HTTP.URL_DEFAULT, false, 2, null) == false) goto L30;
        String r108 = Uri.fromFile(new PolarisFileWrapper(r101)).toString();
        Intrinsics.checkNotNull(r108);
        return r108;
    L30:
        return r101;
    L11:
        if ((!StringsKt.isBlank(r105)) != true) goto L13;
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        r103 = false;
        goto L6
    }

    public static String b(String r100) {
        if (r100 != null) goto L5;
    L12:
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        return a(r100);
    }

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        String r101 = StringsKt.trim(r100).toString();
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r101 = null;
    L10:
        if (r101 != null) goto L13;
        return null;
    L13:
        if (StringsKt.startsWith$default(r101, HTTP.URL_DEFAULT, false, 2, null) == false) goto L34;
        return r101;
    L34:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
        Object r104 = Result.m9449constructorimpl(UriProtector.parse(r101));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r104) == false) goto L22;
        r104 = null;
    L22:
        Uri r105 = (Uri) r104;
        if (r105 != null) goto L26;
        return null;
    L26:
        if (StringsKt.equals(r105.getScheme(), "file", true) == true) goto L28;
        return null;
    L28:
        String r106 = r105.getPath();
        if (r106 != null) goto L31;
        return null;
    L31:
        if ((!StringsKt.isBlank(r106)) == true) goto L33;
        return null;
    L33:
        return r106;
    L17:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L5:
        r102 = false;
        goto L7
    }

    public static String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        String r101 = StringsKt.trim(r100).toString();
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r101 = null;
    L10:
        if (r101 != null) goto L13;
        return null;
    L13:
        if (StringsKt.startsWith(r101, "content://", true) == false) goto L16;
        return null;
    L16:
        if (c(r101) == null) goto L18;
        return null;
    L18:
        return a(r101);
    L5:
        r102 = false;
        goto L7
    }
}
