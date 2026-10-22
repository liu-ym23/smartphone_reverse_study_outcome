package com.bytedance.ee.bear.drive.biz.comment;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d1 implements Function4<String, Integer, String, Integer, Unit> {
    public final /* synthetic */ a1 a;

    public d1(a1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4, Object r5, Object r6) {
        String r7 = (String) r3;
        Integer r8 = (Integer) r4;
        String r9 = (String) r5;
        Integer r10 = (Integer) r6;
        Iterator r11 = ((HashSet) this.a.v).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((p1.a) r11.next()).a(r7, r9, r10.intValue());
        goto L4
    L6:
        return null;
    }
}
