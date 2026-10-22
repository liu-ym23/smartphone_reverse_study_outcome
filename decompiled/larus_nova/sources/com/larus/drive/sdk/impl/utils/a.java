package com.larus.drive.sdk.impl.utils;

import com.bytedance.android.ec.slice.SliceInitService;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static final Integer a(DriveFileItem r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        String r102 = r100.f341575l;     // Catch: Throwable -> L7
        if (r102 != null) goto L5;
        r102 = SliceInitService.DEFAULT_SWITCH;
    L5:
        Object r103 = Result.m9449constructorimpl(new JSONObject(r102));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L12;
        r103 = null;
    L12:
        JSONObject r104 = (JSONObject) r103;
        if (r104 != null) goto L15;
        return null;
    L15:
        if (r104.has("originBaseBizType") == false) goto L28;
        Object r105 = r104.opt("originBaseBizType");
        if (r105 == null) goto L26;
        String r106 = r105.toString();
        if (r106 != null) goto L22;
        return null;
    L22:
        return StringsKt.toIntOrNull(r106);
    L26:
        return null;
    L28:
        return null;
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static final Integer b(DriveFileItem r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f341567d != 8) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == true) goto L12;
        return null;
    L12:
        Integer r102 = a(r100);
        if (r102 != null) goto L18;
        int r103 = bq9.b.f20091a;
        if (bq9.b.b(r100.f341568e) == true) goto L20;
        return null;
    L20:
        return 1;
    L18:
        return r102;
    L5:
        if (r100.f341573j == DriveFileType.BITABLE) goto L8;
        r101 = false;
        goto L10
    }
}
