package com.larus.im.internal.database.utils;

import com.larus.im.internal.database.entity.MessageEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l {
    public static final Map<String, List<MessageEntity>> a(List<MessageEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        List<MessageEntity> r102 = r100;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        String r105 = ((MessageEntity) r104.next()).getConversationId();
        if (r105 == null) goto L4;
        r103.add(r105);
        goto L4
    L8:
        Iterator r106 = CollectionsKt.distinct(r103).iterator();
    L10:
        if (r106.hasNext() == false) goto L18;
        String r107 = (String) r106.next();
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r102.iterator();
    L13:
        if (r109.hasNext() == false) goto L17;
        Object r110 = r109.next();
        if (Intrinsics.areEqual(((MessageEntity) r110).getConversationId(), r107) == false) goto L13;
        r108.add(r110);
        goto L13
    L17:
        r101.put(r107, r108);
        goto L10
    L18:
        return r101;
    }
}
