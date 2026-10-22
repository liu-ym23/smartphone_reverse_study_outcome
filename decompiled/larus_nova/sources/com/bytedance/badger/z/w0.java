package com.bytedance.badger.z;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f199492a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f199493b = null;

    static {
        f199492a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(w0.class, "badger-core_release"), "internalModules", "getInternalModules()Ljava/util/Map;"))};
        f199493b = LazyKt.lazy(n.f199484a);
    }

    public static final void b() {
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.m r100 = com.bytedance.badger.v.d.f199327k;
        KProperty r101 = com.bytedance.badger.v.d.f199311a[10];
        Collection r102 = (Collection) r100.a();
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Integer r105 = StringsKt.toIntOrNull((String) r104.next());
        if (r105 == null) goto L4;
        r103.add(r105);
        goto L4
    L8:
        Lazy r106 = f199493b;
        KProperty r107 = f199492a[0];
        Iterator r108 = ((Map) r106.getValue()).entrySet().iterator();
    L10:
        if (r108.hasNext() == false) goto L16;
        Map.Entry r109 = (Map.Entry) r108.next();
        int r110 = ((Number) r109.getKey()).intValue();
        u0 r111 = (u0) r109.getValue();
        if (r103.contains(Integer.valueOf(r110)) == true) goto L13;
        if (r111 == null) goto L10;
        r r112 = new r(r110);
        com.bytedance.badger.t.c r113 = new com.bytedance.badger.t.c(901594402);
        r112.invoke(r113);
        r113.a(r111);
        goto L10
    L13:
        com.bytedance.badger.e.g("BadgerModules", "registerModules: " + r110 + " is disabled");
        goto L10
    }

    public static final Pair a(int r100, u0 r101) {
        if (r100 > 0) goto L4;
    L6:
        boolean r102 = false;
    L7:
        if (r102 == false) goto L11;
        return new Pair(Integer.valueOf(r100), r101);
    L11:
        throw new IllegalArgumentException("FeatureID must be in range of Short".toString());
    L4:
        if (r100 > 65535) goto L6;
        r102 = true;
        goto L7
    }
}
