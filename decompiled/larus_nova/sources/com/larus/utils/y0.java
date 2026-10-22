package com.larus.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 {
    public static final boolean d(Uri r100) {
        boolean r101 = false;
        if (r100 == null) goto L22;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(r100.getScheme(), "http") == false) goto L8;
    L9:
        r101 = true;
    L10:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L12
    L14:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L19;
        FLogger.f375446a.e("UrlExt", "isHttpUri err:" + r104.getMessage());
        r103 = Boolean.FALSE;
    L19:
        return ((Boolean) r103).booleanValue();
    L8:
        if (Intrinsics.areEqual(r100.getScheme(), "https") == false) goto L10;
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L22:
        return false;
    }

    public static final boolean e(String r100) {
        return d(j(r100));
    }

    public static final Uri h(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L13
        return r102;
    L13:
        Uri r103 = Uri.EMPTY;
        Intrinsics.checkNotNull(r103);
        return r103;
    L10:
        return Uri.EMPTY;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static final Uri i(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return Uri.EMPTY;
    L11:
        return UriProtector.parse(r100);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static final Uri j(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return null;
    L11:
        return UriProtector.parse(r100);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static final String k(Uri r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.toString();
    }

    public static final Uri a(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("gecko_access_key", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        String r102 = f(r100, "url");
        if (r102 != null) goto L5;
        return r100;
    L5:
        Uri r103 = UriProtector.parse(r102);
        Intrinsics.checkNotNull(r103);
        return l(r100, "url", l(r103, "gecko_access_key", r101).toString());
    }

    public static final String f(Uri r100, String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        Object r103 = null;
        if (r102 == true) goto L27;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        if (r100 == null) goto L14;
        String r105 = UriProtector.getQueryParameter(r100, r101);     // Catch: Throwable -> L17
    L15:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L17
    L19:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 != null) goto L22;
        r103 = r106;
    L24:
        return (String) r103;
    L22:
        FLogger.f375446a.e("UrlExt", "queryParameter err:" + r107.getMessage());
        goto L24
    L14:
        r105 = null;
    L17:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L27:
        return null;
    L4:
        if (r101.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    public static final Uri b(Uri r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r103 = true;
        if (r101.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L26;
        if (r102 != null) goto L9;
    L12:
        if (r103 == true) goto L27;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L16
        Object r106 = Result.m9449constructorimpl(r100.buildUpon().appendQueryParameter(r101, r102).build());     // Catch: Throwable -> L16
    L18:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 != null) goto L21;
        Object r108 = r106;
    L23:
        return (Uri) r108;
    L21:
        FLogger.f375446a.e("UrlExt", "appendQueryParameter err:" + r107.getMessage());
        r108 = r100;
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L27:
        return r100;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L12
    L26:
        return r100;
    L5:
        r104 = false;
        goto L6
    }

    public static final Uri c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return b(UriProtector.parse(r100), r101, r102);
    }

    public static final Uri g(Uri r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L38;
        return r100;
    L38:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L30
        Uri.Builder r105 = r100.buildUpon().clearQuery();     // Catch: Throwable -> L30
        Iterator<T> r106 = UriProtector.getQueryParameterNames(r100).iterator();     // Catch: Throwable -> L30
    L13:
        if (r106.hasNext() == false) goto L28;
        String r107 = (String) r106.next();     // Catch: Throwable -> L30
        if (Intrinsics.areEqual(r107, r101) == true) goto L16;
        Iterator<T> r108 = UriProtector.getQueryParameters(r100, r107).iterator();     // Catch: Throwable -> L30
    L26:
        if (r108.hasNext() == false) goto L13;
        r105.appendQueryParameter(r107, (String) r108.next());     // Catch: Throwable -> L30
        goto L26
    L16:
        if (r102 != null) goto L18;
    L21:
        boolean r109 = true;
    L22:
        if (r109 == true) goto L13;
        r105.appendQueryParameter(r107, r102);     // Catch: Throwable -> L30
        goto L13
    L18:
        if (r102.length() == 0) goto L21;
        r109 = false;
        goto L22
    L28:
        Object r110 = Result.m9449constructorimpl(r105.build());     // Catch: Throwable -> L30
    L32:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 != null) goto L35;
        Object r112 = r110;
    L37:
        return (Uri) r112;
    L35:
        FLogger.f375446a.e("UrlExt", "replaceQueryParameter err:" + r111.getMessage());
        r112 = r100;
    L30:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static final Uri l(Uri r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        Uri.Builder r104 = r100.buildUpon().clearQuery();     // Catch: Throwable -> L16
        Iterator<String> r105 = UriProtector.getQueryParameterNames(r100).iterator();     // Catch: Throwable -> L16
    L5:
        if (r105.hasNext() == false) goto L12;
        String r106 = r105.next();     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(r106, r101) == true) goto L5;
        Iterator<String> r107 = UriProtector.getQueryParameters(r100, r106).iterator();     // Catch: Throwable -> L16
    L10:
        if (r107.hasNext() == false) goto L5;
        r104.appendQueryParameter(r106, r107.next());     // Catch: Throwable -> L16
        goto L10
    L12:
        if (r102 == null) goto L14;
        r104.appendQueryParameter(r101, r102);     // Catch: Throwable -> L16
    L14:
        Object r108 = Result.m9449constructorimpl(r104.build());     // Catch: Throwable -> L16
    L18:
        Object r109 = r100;
        if (Result.m9452exceptionOrNullimpl(r108) != null) goto L22;
        r109 = r108;
    L22:
        return (Uri) r109;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
