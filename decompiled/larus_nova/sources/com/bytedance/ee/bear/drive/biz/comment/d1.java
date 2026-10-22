package com.bytedance.ee.bear.drive.biz.comment;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes16.dex */
public final class d1 implements Function4<String, Integer, String, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f222735a;

    public d1(a1 r100) {
        this.f222735a = r100;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Unit invoke(String r100, Integer r101, String r102, Integer r103) {
        String r104 = r100;
        String r105 = r102;
        Integer r106 = r103;
        Iterator r107 = ((HashSet) this.f222735a.f222693v).iterator();
    L4:
        if (r107.hasNext() == false) goto L6;
        ((p1.a) r107.next()).a(r104, r105, r106.intValue());
        goto L4
    L6:
        return null;
    }
}
