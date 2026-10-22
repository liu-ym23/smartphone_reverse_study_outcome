package com.bytedance.locallife.dito.helper;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final String a(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = r100.get(r101);
        if ((r102 instanceof String) == false) goto L7;
        return (String) r102;
    L7:
        if ((r102 instanceof Boolean) == true) goto L9;
        return null;
    L9:
        if (((Boolean) r102).booleanValue() == false) goto L11;
        return "true";
    L11:
        return "false";
    }
}
