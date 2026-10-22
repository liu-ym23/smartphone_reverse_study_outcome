package com.larus.bmhome.clarification;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class y1 {
    public static final ze8.c a(z1 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
        r101 = r100.f310655l.f310541b;
    L5:
        boolean r102 = false;
        if (r101.length() <= 0) goto L8;
        boolean r103 = true;
    L9:
        boolean r104 = !StringsKt.isBlank(r101);
        boolean r105 = !r100.f310655l.f310540a.isEmpty();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f310652i == false) goto L12;
    L15:
        boolean r106 = true;
    L16:
        boolean r107 = !r103;
        boolean r108 = !r104;
        if (r104 == true) goto L22;
        if (r105 == true) goto L22;
        if (r106 == true) goto L22;
        boolean r109 = false;
    L23:
        if (r104 == true) goto L28;
        if (r105 == true) goto L28;
        if (r106 == true) goto L28;
        r102 = true;
    L28:
        return new ze8.c(r107, r108, r109, r102);
    L22:
        r109 = true;
        goto L23
    L12:
        if ((!r100.f310655l.f310543d.isEmpty()) == true) goto L15;
        r106 = false;
        goto L16
    L8:
        r103 = false;
        goto L9
    }
}
