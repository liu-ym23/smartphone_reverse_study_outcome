package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.fileselector.bean.FileBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class m0 {
    public static final List<FileBean> a(List<ew4.f> r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r110.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L24;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ew4.f r105 = (ew4.f) r103;
        String r106 = r105.f474544b;
        FileBean r107 = null;
        if ((!StringsKt.isBlank(r106)) == false) goto L11;
        String r111 = r106;
    L12:
        if (r111 == null) goto L21;
        Integer r108 = r105.f474543a;
        if (r108 == null) goto L17;
        r102 = r108.intValue();
    L17:
        int r109 = r102;
        String r112 = r105.f474545c;
        if (r112 != null) goto L20;
        r112 = "";
    L20:
        r107 = new FileBean(r109, r111, r112, r105.f474546d, r105.f474547e, r105.f474548f, r105.f474549g);
    L21:
        if (r107 == null) goto L23;
        r100.add(r107);
    L23:
        r102 = r104;
        goto L4
    L11:
        r111 = null;
        goto L12
    L24:
        return r100;
    }
}
