package com.larus.canvas.feature.component.logic.helper;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.canvas.feature.component.base.HttpUrl;
import com.larus.canvas.feature.component.base.ImageRes;
import com.larus.canvas.feature.component.base.LocalFilePath;
import com.larus.utils.o0;
import com.larus.utils.y0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import ky8.j;

/* JADX INFO: loaded from: classes26.dex */
public final class e {
    public static final ImageRes a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ImageRes r101 = null;
        String r102 = "";
        if (o0.d(r100.f506720e) == false) goto L44;
        String r103 = r100.f506720e;
        if (r103 != null) goto L51;
        r103 = "";
    L51:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        Object r105 = Result.m9449constructorimpl(y0.j(r103));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == false) goto L14;
        r105 = null;
    L14:
        Uri r106 = (Uri) r105;
        if (r106 == null) goto L36;
        String r107 = r106.getScheme();
        if (r107 != null) goto L20;
    L25:
        Uri r108 = y0.j(a.a(r103));
        if (r108 == null) goto L28;
        String r109 = r108.getPath();
    L29:
        if (r109 != null) goto L31;
        r109 = "";
    L31:
        PolarisFileWrapper r110 = new PolarisFileWrapper(r109);
        if (r110.exists() == false) goto L36;
        if (r110.isFile() == false) goto L36;
    L35:
        boolean r111 = true;
    L37:
        if (r111 == false) goto L44;
        String r112 = r100.f506720e;
        if (r112 == null) goto L42;
        r102 = r112;
    L42:
        r101 = new LocalFilePath(r102);
    L50:
        return r101;
    L28:
        r109 = null;
        goto L29
    L20:
        if (r107.hashCode() != 951530617) goto L25;
        if (r107.equals("content") == false) goto L25;
    L36:
        r111 = false;
    L9:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L44:
        if (o0.d(r100.f506717b) == false) goto L50;
        String r114 = r100.f506717b;
        if (r114 == null) goto L49;
        r102 = r114;
    L49:
        r101 = new HttpUrl(r102);
        goto L50
    }
}
