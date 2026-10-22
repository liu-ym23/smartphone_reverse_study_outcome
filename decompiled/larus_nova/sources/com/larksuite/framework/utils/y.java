package com.larksuite.framework.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public final class y {

    public interface a<S, R> {
        R get(S r100);
    }

    public static <S, R> List<R> a(List<S> r100, a<S, R> r101) {
        ArrayList r102 = new ArrayList();
        if (r100 == null) goto L10;
        Iterator<S> r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        R r104 = r101.get(r103.next());
        if (r104 == null) goto L6;
        r102.add(r104);
    L10:
        return r102;
    }

    public static <S, R> Map<String, R> b(Map<String, S> r100, a<S, R> r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        if (r100 == null) goto L10;
        Iterator<String> r103 = r100.keySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();
        R r105 = r101.get(r100.get(r104));
        if (r105 == null) goto L6;
        r102.put(r104, r105);
    L10:
        return r102;
    }
}
