package com.bytedance.kmp.ec.yata.store.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.bytedance.kmp.ec.yata.store.node.c> f251736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<com.bytedance.kmp.ec.yata.store.node.c>> f251737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<com.bytedance.kmp.ec.yata.store.node.f>> f251738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<com.bytedance.kmp.ec.yata.store.node.f>> f251739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, List<String>> f251740e;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Map<String, ? extends com.bytedance.kmp.ec.yata.store.node.c> r100, Map<String, ? extends List<? extends com.bytedance.kmp.ec.yata.store.node.c>> r101, Map<String, ? extends List<? extends com.bytedance.kmp.ec.yata.store.node.f>> r102, Map<String, ? extends List<? extends com.bytedance.kmp.ec.yata.store.node.f>> r103) {
        Intrinsics.checkNotNullParameter(r100, "dfsRenderObjectsByKey");
        Intrinsics.checkNotNullParameter(r101, "renderObjectByNodeName");
        Intrinsics.checkNotNullParameter(r102, "upScreenNodesByPosition");
        Intrinsics.checkNotNullParameter(r103, "autoExposureGroupNodes");
        this.f251736a = r100;
        this.f251737b = r101;
        this.f251738c = r102;
        this.f251739d = r103;
        LinkedHashMap r104 = new LinkedHashMap(MapsKt.mapCapacity(r102.size()));
        Iterator r105 = ((LinkedHashMap) r102).entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L10;
        Map.Entry r106 = (Map.Entry) r105.next();
        Object r107 = r106.getKey();
        Iterable r108 = (Iterable) r106.getValue();
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r110 = r108.iterator();
    L7:
        if (r110.hasNext() == false) goto L9;
        r109.add(((com.bytedance.kmp.ec.yata.store.node.f) r110.next()).f251781a);
        goto L7
    L9:
        r104.put(r107, r109);
        goto L4
    L10:
        this.f251740e = r104;
    }
}
