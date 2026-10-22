package com.suite.lark.component.navroute.group;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes40.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f<com.suite.lark.component.navroute.api.f<? extends com.suite.lark.component.navroute.api.a<?, ?>>> f460383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<com.suite.lark.component.navroute.api.f<? extends com.suite.lark.component.navroute.api.a<?, ?>>, f<com.suite.lark.component.navroute.api.f<? extends com.suite.lark.component.navroute.api.a<?, ?>>>> f460384b;

    public static final class a {
    }

    static {
    }

    public final List<com.suite.lark.component.navroute.a> a() {
        Set r100 = ((LinkedHashMap) this.f460384b).keySet();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((com.suite.lark.component.navroute.api.f) r102.next()).getNavController());
        goto L4
    L6:
        return r101;
    }

    public e() {
        this.f460384b = new LinkedHashMap();
    }
}
