package com.bytedance.badger.network;

import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class w {
    public static final String a(List<Pair<String, String>> r100, String r101, boolean r102) {
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (StringsKt.equals((String) ((Pair) r104).getFirst(), r101, r102) == false) goto L4;
    L9:
        Pair r105 = (Pair) r104;
        if (r105 != null) goto L12;
        return null;
    L12:
        return (String) r105.getSecond();
    L8:
        r104 = null;
        goto L9
    }
}
