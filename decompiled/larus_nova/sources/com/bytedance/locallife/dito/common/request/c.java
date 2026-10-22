package com.bytedance.locallife.dito.common.request;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static String a(SsResponse r100, String r101, boolean r102, int r103) {
        String r104 = null;
        if ((r103 & 2) == 0) goto L5;
        String r105 = "";
    L7:
        if ((r103 & 4) == 0) goto L9;
        r102 = true;
    L9:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r105, "defaultValue");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        Iterator<T> r106 = r100.headers().iterator();
    L11:
        if (r106.hasNext() == false) goto L15;
        Object r107 = r106.next();
        if (StringsKt.equals(r101, ((Header) r107).getName(), r102) == false) goto L11;
    L16:
        Header r108 = (Header) r107;
        if (r108 == null) goto L19;
        r104 = r108.getValue();
    L19:
        if (r104 != null) goto L22;
        return r105;
    L22:
        return r104;
    L15:
        r107 = null;
        goto L16
    L5:
        r105 = null;
        goto L7
    }
}
