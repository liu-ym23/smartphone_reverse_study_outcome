package com.bytedance.android.shopping.mall.homepage.tools;

import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b0 {
    public final Map<String, String> a;
    public final String b;

    public static final class a {
    }

    static {
    }

    public final String a() {
        if (this.b.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        String r1 = this.b;
        Iterator<Map.Entry<String, String>> r2 = this.a.entrySet().iterator();
        String r3 = r1;
    L11:
        if (r2.hasNext() == false) goto L13;
        Map.Entry<String, String> r4 = r2.next();
        r3 = StringsKt.replace$default(r3, r4.getKey(), r4.getValue(), false, 4, null);
        goto L11
    L13:
        return r3;
    L8:
        return this.b;
    L5:
        r0 = false;
        goto L6
    }

    public b0(String r9, z r10) {
        Intrinsics.checkNotNullParameter(r9, "rawSchema");
        Intrinsics.checkNotNullParameter(r10, "replaceArgument");
        this.b = r9;
        Map<String, String> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("{indexPlaceholder}", String.valueOf(r10.a))});
        Map<String, Object> r11 = r10.b;
        if (r11 != null) goto L5;
    L24:
        Unit r12 = Unit.INSTANCE;
        this.a = r0;
        return;
    L5:
        if ((!r11.isEmpty()) == true) goto L8;
        r11 = null;
    L8:
        if (r11 == null) goto L24;
        Iterator<T> r1 = r11.keySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L24;
        String r4 = (String) r1.next();
        Object r5 = r11.get(r4);
        if (r5 == null) goto L15;
        String r6 = r5.toString();
    L16:
        if (r6 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == true) goto L11;
        Intrinsics.checkNotNull(r6);
        r0.put("{" + r4 + "Placeholder}", r6);
        goto L11
    L18:
        if (r6.length() == 0) goto L21;
        r7 = false;
        goto L22
    L15:
        r6 = null;
        goto L16
    }
}
