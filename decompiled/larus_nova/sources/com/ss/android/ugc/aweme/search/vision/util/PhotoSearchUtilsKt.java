package com.ss.android.ugc.aweme.search.vision.util;

import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ec-search-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class PhotoSearchUtilsKt {
    public static final String a(PhotoEnterModel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getDetection");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        String r102 = r100.getClientParams();     // Catch: Throwable -> L16
        if (r102 != null) goto L6;
        return null;
    L6:
        String r103 = new JSONObject(r102).optString("detection");     // Catch: Throwable -> L16
        if (r103 == null) goto L12;
        if (r103.length() == 0) goto L12;
        boolean r104 = false;
    L13:
        if (r104 == false) goto L15;
        return null;
    L15:
        return r103;
    L12:
        r104 = true;
    L16:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static final Integer b(PhotoEnterModel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getDetectionIndex");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        String r102 = r100.getClientParams();     // Catch: Throwable -> L11
        if (r102 != null) goto L6;
        return null;
    L6:
        int r103 = new JSONObject(r102).optInt(PhotoEnterModel.DETECTION_INDEX, -1);     // Catch: Throwable -> L11
        if (r103 != (-1)) goto L9;
        return null;
    L9:
        return Integer.valueOf(r103);
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }
}
