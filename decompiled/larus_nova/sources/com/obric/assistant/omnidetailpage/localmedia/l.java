package com.obric.assistant.omnidetailpage.localmedia;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f390838a = null;

    static {
        f390838a = new l();
    }

    public l() {
    }

    public static String b(String r100) {
        boolean r101 = true;
        if (r100 == null) goto L33;
        String r102 = StringsKt.trim(r100).toString();
        if (r102 == null) goto L33;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L33;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L27
        if (StringsKt.startsWith(r102, "content://", true) == false) goto L19;
    L24:
        r102 = null;
    L25:
        Object r105 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r105) == false) goto L32;
        r105 = null;
    L32:
        String r106 = (String) r105;
    L34:
        if (r106 != null) goto L36;
        return null;
    L36:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106);
        String r108 = r107.getAbsolutePath();
        if (r107.isFile() == true) goto L39;
    L41:
        r101 = false;
    L42:
        if (r101 == true) goto L44;
        return null;
    L44:
        return r108;
    L39:
        if (r107.canRead() == false) goto L41;
    L19:
        if (StringsKt.startsWith(r102, MSkiaImageRegionDecoder.FILE_PREFIX, true) == false) goto L22;
        r102 = UriProtector.parse(r102).getPath();     // Catch: Throwable -> L27
        goto L25
    L22:
        if (StringsKt.startsWith$default(r102, HTTP.URL_DEFAULT, false, 2, null) == false) goto L24;
    L27:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L9:
        r103 = false;
    L33:
        r106 = null;
        goto L34
    }

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return Uri.fromFile(new PolarisFileWrapper(r100)).toString();
    }

    public static void a(String r100, String r101, String r102) {
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("filter local resource, blockId=");
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r104.append(r100);
        r104.append(", type=");
        r104.append(r101);
        r104.append(", reason=");
        r104.append(r102);
        r103.i("OmniLocalResourceAccess", r104.toString());
    }
}
