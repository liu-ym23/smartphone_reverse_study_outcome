package com.bytedance.helios.common.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final String a(Set<String> r100) {
        Set<String> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        r102.add("\"" + ((String) r103.next()) + Typography.quote);
        goto L4
    L7:
        return r102.toString();
    }
}
