package com.bytedance.ug.sdk.luckycat.impl.manager;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f271375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<zl7.m> f271376b = null;

    static {
        f271376b = new ArrayList();
    }

    public static String a() {
        StringBuilder r100 = new StringBuilder();
        Iterator r101 = CollectionsKt.reversed(f271376b).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L14;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        StringBuilder r105 = new StringBuilder();
        r105.append(((zl7.m) r103).f572794a);
        if (r102 != (((ArrayList) f271376b).size() - 1)) goto L11;
        String r106 = "";
    L12:
        r105.append(r106);
        r100.append(r105.toString());
        r102 = r104;
        goto L4
    L11:
        r106 = "#";
        goto L12
    L14:
        return r100.toString();
    }

    public static String b() {
        StringBuilder r100 = new StringBuilder();
        Iterator r101 = CollectionsKt.reversed(f271376b).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L14;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        StringBuilder r105 = new StringBuilder();
        r105.append(((zl7.m) r103).toString());
        if (r102 != (((ArrayList) f271376b).size() - 1)) goto L11;
        String r106 = "";
    L12:
        r105.append(r106);
        r100.append(r105.toString());
        r102 = r104;
        goto L4
    L11:
        r106 = "#";
        goto L12
    L14:
        return r100.toString();
    }

    public static void c(String r100) {
        ArrayList r101 = (ArrayList) f271376b;
        ListIterator r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(((zl7.m) r102.previous()).f572794a, r100) == false) goto L4;
        int r103 = r102.nextIndex();
    L9:
        if (r103 < 0) goto L19;
        List<zl7.m> r104 = f271376b;
        ArrayList r105 = (ArrayList) r104;
        if (r103 >= r105.size()) goto L20;
        ListProtector.remove(r104, r103);
        if (r105.size() != 1) goto L21;
        r105.clear();
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L8:
        r103 = -1;
        goto L9
    }
}
