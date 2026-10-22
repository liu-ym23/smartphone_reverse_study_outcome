package com.bytedance.frameworks.baselib.netx.partner.mutable;

import com.bytedance.retrofit2.client.Header;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<Header>> f244841a;

    public b(List<Header> r100) {
        Intrinsics.checkNotNullParameter(r100, "originHeaders");
        this.f244841a = new LinkedHashMap();
        Iterator<Header> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Header r102 = r101.next();
        String r103 = r102.getName();
        Map<String, List<Header>> r104 = this.f244841a;
        String r105 = a(r103);
        LinkedHashMap r106 = (LinkedHashMap) r104;
        Object r107 = r106.get(r105);
        if (r107 != null) goto L8;
        r107 = new ArrayList();
        r106.put(r105, r107);
    L8:
        ((List) r107).add(r102);
        goto L4
    }

    public static String a(String r100) {
        Locale r101 = Locale.getDefault();
        if (r100 == null) goto L7;
        return r100.toLowerCase(r101);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        Map<String, List<Header>> r102 = this.f244841a;
        String r103 = a(r100);
        LinkedHashMap r104 = (LinkedHashMap) r102;
        Object r105 = r104.get(r103);
        if (r105 != null) goto L5;
        r105 = new ArrayList();
        r104.put(r103, r105);
    L5:
        List r106 = (List) r105;
        r106.clear();
        r106.add(new Header(r100, r101));
    }
}
