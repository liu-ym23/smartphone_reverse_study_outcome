package vu1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ju1.l;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, c> f557323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, e> f557324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, f> f557325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a.InterfaceC8042a f557326d;

    @Override // vu1.a
    public final Iterator<f> a() {
        return this.f557325c.values().iterator();
    }

    @Override // vu1.a
    public final Iterator<e> b() {
        return this.f557324b.values().iterator();
    }

    @Override // vu1.a
    public final Iterator<c> d() {
        return this.f557323a.values().iterator();
    }

    public d() {
        this.f557323a = new ConcurrentHashMap();
        this.f557324b = new ConcurrentHashMap();
        this.f557325c = new ConcurrentHashMap();
    }

    @Override // vu1.a
    public final ju1.c<Object> c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        c r101 = this.f557323a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f557320a;
    }

    @Override // vu1.a
    public final List<ju1.h> e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ConcurrentHashMap<String, f> r101 = this.f557325c;
        ArrayList r102 = new ArrayList();
        Iterator<Map.Entry<String, f>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        Map.Entry<String, f> r104 = r103.next();
        if (r104.getValue().f557327a.e().contains(r100) == false) goto L9;
        ju1.h r105 = r104.getValue().f557327a;
    L12:
        if (r105 == null) goto L4;
        r102.add(r105);
        goto L4
    L9:
        if (r104.getValue().f557327a.c().contains(r100) == false) goto L11;
        r105 = r104.getValue().f557327a;
        goto L12
    L11:
        r105 = null;
        goto L12
    L15:
        return CollectionsKt.toList(r102);
    }

    @Override // vu1.a
    public final List<l> f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ConcurrentHashMap<String, e> r101 = this.f557324b;
        ArrayList r102 = new ArrayList();
        Iterator<Map.Entry<String, e>> r103 = r101.entrySet().iterator();
        if (r103.hasNext() == false) goto L5;
        r103.next().getValue().getClass();
        throw null;
    L5:
        return CollectionsKt.toList(r102);
    }

    @Override // vu1.a
    public final void g(h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f557326d = r100;
    }
}
