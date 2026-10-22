package com.bytedance.kmp.ec.yata.store.core;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class RenderTreeStruct implements ba6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.store.node.a f251706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f251707b;

    @Override // ba6.e
    public final com.bytedance.kmp.ec.yata.store.node.c c() {
        return this.f251706a.f251780g;
    }

    public final f d() {
        return (f) this.f251707b.getValue();
    }

    @Override // ba6.e
    public final Map<String, List<com.bytedance.kmp.ec.yata.store.node.f>> a() {
        f r100 = d();
        r100.getClass();
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<String, List<com.bytedance.kmp.ec.yata.store.node.f>>> r102 = r100.f251738c.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, List<com.bytedance.kmp.ec.yata.store.node.f>> r103 = r102.next();
        String r104 = r103.getKey();
        List<com.bytedance.kmp.ec.yata.store.node.f> r105 = r103.getValue();
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L7:
        if (r107.hasNext() == false) goto L9;
        r106.add(((com.bytedance.kmp.ec.yata.store.node.f) r107.next()).t());
        goto L7
    L9:
        r101.put(r104, r106);
        goto L4
    L10:
        return r101;
    }

    @Override // ba6.e
    public final Map<String, List<String>> b() {
        Map<String, List<com.bytedance.kmp.ec.yata.store.node.f>> r100 = d().f251739d;
        LinkedHashMap r101 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        Iterable r105 = (Iterable) r103.getValue();
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L7:
        if (r107.hasNext() == false) goto L9;
        r106.add(((com.bytedance.kmp.ec.yata.store.node.f) r107.next()).f251781a);
        goto L7
    L9:
        r101.put(r104, r106);
        goto L4
    L10:
        return r101;
    }

    public final Map<String, List<String>> e() {
        return d().f251740e;
    }

    public final Map<String, List<com.bytedance.kmp.ec.yata.store.node.f>> f() {
        return d().f251738c;
    }

    public RenderTreeStruct(com.bytedance.kmp.ec.yata.store.node.a r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f251706a = r100;
        this.f251707b = LazyKt.lazy(new RenderTreeStruct$assembleRenderNode$2(this));
    }
}
