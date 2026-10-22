package com.larus.bot.impl.feature.edit.feature.firstmet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class k {
    public static final boolean a(Triple<String, String, String> r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if (StringsKt.isBlank(r100.getFirst()) == false) goto L12;
        if (StringsKt.isBlank(r100.getSecond()) == false) goto L12;
        if (StringsKt.isBlank(r100.getThird()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static final Triple<String, String, String> b(Triple<String, String, String> r100) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        return new Triple("", "", "");
    }

    public static final List<String> c(Triple<String, String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List r101 = TuplesKt.toList(r100);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(StringsKt.trim((String) r103.next()).toString());
        goto L4
    L6:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        if (StringsKt.isBlank((String) r106) == true) goto L8;
        r104.add(r106);
        goto L8
    L12:
        return r104;
    }

    public static final Triple<String, String, String> d(List<String> r100) {
        if (r100 == null) goto L14;
        String r101 = (String) CollectionsKt.getOrNull(r100, 0);
        String r102 = "";
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        String r103 = (String) CollectionsKt.getOrNull(r100, 1);
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        String r104 = (String) CollectionsKt.getOrNull(r100, 2);
        if (r104 == null) goto L13;
        r102 = r104;
    L13:
        Triple r105 = new Triple(r101, r103, r102);
    L16:
        return b(r105);
    L14:
        r105 = null;
        goto L16
    }
}
