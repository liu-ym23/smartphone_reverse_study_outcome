package com.ss.android.ugc.aweme.poi.utils;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"locallife-saas-common_release"}, k = 2, mv = {1, 4, 3})
public final class TypeExtKt {
    public static final Boolean a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Boolean) == true) goto L17;
        boolean r101 = true;
        if ((r100 instanceof String) == false) goto L13;
        String r102 = ((String) r100).toLowerCase(Locale.US);
        if (Intrinsics.areEqual(r102, "true") == true) goto L18;
        r101 = Intrinsics.areEqual(r102, "1");
    L18:
        return Boolean.valueOf(r101);
    L13:
        if ((r100 instanceof Number) == true) goto L19;
        return null;
    L19:
        return Boolean.valueOf(Intrinsics.areEqual(r100, 1));
    L17:
        return (Boolean) r100;
    }
}
