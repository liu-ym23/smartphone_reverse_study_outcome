package com.bytedance.bdnavigationsdk.navigation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f200105a = 0;

    static {
    }

    public static List a(List r100) {
        List r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L14:
        if (r104.hasNext() == false) goto L25;
        com.bytedance.bdnavigationsdk.pojo.d r105 = (com.bytedance.bdnavigationsdk.pojo.d) r104.next();
        com.bytedance.bdnavigationsdk.pojo.a r106 = r105.f200353a;
        if (r106 != null) goto L18;
    L22:
        com.bytedance.bdnavigationsdk.pojo.a r107 = r105.f200354b;
        if (r107 == null) goto L14;
        r103.add(r107);
        goto L14
    L18:
        if (r103.isEmpty() == false) goto L20;
    L21:
        r103.add(r106);
        goto L22
    L20:
        if (Intrinsics.areEqual(CollectionsKt.last(r103), r106) == true) goto L22;
    L25:
        return r103;
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
