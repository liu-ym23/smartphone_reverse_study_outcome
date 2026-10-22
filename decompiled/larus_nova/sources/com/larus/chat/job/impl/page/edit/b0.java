package com.larus.chat.job.impl.page.edit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f325233a = 0;

    static {
    }

    public static String a(Set r100) {
        Intrinsics.checkNotNullParameter(r100, "weekdays");
        ChatJobEditWeekday[] r101 = ChatJobEditWeekday.values();
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        ChatJobEditWeekday r105 = r101[r104];
        if (r100.contains(r105) == false) goto L7;
        r102.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r107 = r102.iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        r106.add(((ChatJobEditWeekday) r107.next()).getLabel());
        goto L10
    L12:
        gz8.d.f483418a.getClass();
        Intrinsics.checkNotNullParameter(r106, "labels");
        return gz8.f.h(r106);
    }
}
