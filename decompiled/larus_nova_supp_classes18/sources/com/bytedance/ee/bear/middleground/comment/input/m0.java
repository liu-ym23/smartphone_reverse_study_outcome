package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.fileselector.bean.FileBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m0 {
    public static final List<FileBean> a(List<ew4.f> r18) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        ArrayList r1 = new ArrayList();
        Iterator<T> r0 = r18.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L24;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ew4.f r5 = (ew4.f) r3;
        String r6 = r5.b;
        FileBean r7 = null;
        if ((!StringsKt.isBlank(r6)) == false) goto L11;
        String r10 = r6;
    L12:
        if (r10 == null) goto L21;
        Integer r8 = r5.a;
        if (r8 == null) goto L17;
        r2 = r8.intValue();
    L17:
        int r9 = r2;
        String r11 = r5.c;
        if (r11 != null) goto L20;
        r11 = "";
    L20:
        r7 = new FileBean(r9, r10, r11, r5.d, r5.e, r5.f, r5.g);
    L21:
        if (r7 == null) goto L23;
        r1.add(r7);
    L23:
        r2 = r4;
        goto L4
    L11:
        r10 = null;
        goto L12
    L24:
        return r1;
    }
}
