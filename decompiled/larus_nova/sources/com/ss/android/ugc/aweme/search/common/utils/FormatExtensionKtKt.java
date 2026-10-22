package com.ss.android.ugc.aweme.search.common.utils;

import com.ss.android.ugc.aweme.search.utils.GsonUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tv5.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"trade-search-impl_release"}, k = 2, mv = {1, 4, 3})
public final class FormatExtensionKtKt {
    public static final JSONObject a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return a.a(GsonUtil.a(), r100);
    L6:
        return new JSONObject();
    }

    public static final JSONObject b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new JSONObject(r100);
    L6:
        return new JSONObject();
    }
}
