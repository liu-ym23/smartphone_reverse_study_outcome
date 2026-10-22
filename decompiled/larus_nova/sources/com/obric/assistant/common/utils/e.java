package com.obric.assistant.common.utils;

import android.os.Bundle;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class e {
    public static final String a(Object r110) {
        if (r110 != null) goto L5;
        return "null";
    L5:
        if ((r110 instanceof Bundle) == false) goto L8;
        return b((Bundle) r110);
    L8:
        if ((r110 instanceof Object[]) == false) goto L11;
        return ArraysKt.joinToString$default((Object[]) r110, null, "[", "]", 0, null, new d(), 25, null);
    L11:
        if ((r110 instanceof int[]) == false) goto L14;
        return ArraysKt.joinToString$default((int[]) r110, null, "[", "]", 0, null, null, 57, null);
    L14:
        if ((r110 instanceof long[]) == false) goto L17;
        return ArraysKt.joinToString$default((long[]) r110, null, "[", "]", 0, null, null, 57, null);
    L17:
        if ((r110 instanceof float[]) == false) goto L20;
        return ArraysKt.joinToString$default((float[]) r110, null, "[", "]", 0, null, null, 57, null);
    L20:
        if ((r110 instanceof double[]) == false) goto L23;
        return ArraysKt.joinToString$default((double[]) r110, null, "[", "]", 0, null, null, 57, null);
    L23:
        if ((r110 instanceof boolean[]) == false) goto L26;
        return ArraysKt.joinToString$default((boolean[]) r110, null, "[", "]", 0, null, null, 57, null);
    L26:
        if ((r110 instanceof byte[]) == false) goto L29;
        return ArraysKt.joinToString$default((byte[]) r110, null, "[", "]", 0, null, null, 57, null);
    L29:
        if ((r110 instanceof short[]) == false) goto L32;
        return ArraysKt.joinToString$default((short[]) r110, null, "[", "]", 0, null, null, 57, null);
    L32:
        if ((r110 instanceof char[]) == false) goto L35;
        return ArraysKt.joinToString$default((char[]) r110, null, "[", "]", 0, null, null, 57, null);
    L35:
        return r110.toString();
    }

    public static final String b(final Bundle r110) {
        if (r110 == null) goto L9;
        Set<String> r100 = r110.keySet();
        if (r100 == null) goto L9;
        List r101 = CollectionsKt.sorted(r100);
        if (r101 == null) goto L9;
        String r111 = CollectionsKt.joinToString$default(r101, null, "{", com.alipay.sdk.m.u.i.f25855d, 0, null, new c(r110), 25, null);
        if (r111 == null) goto L9;
        return r111;
    L9:
        return "null";
    }
}
