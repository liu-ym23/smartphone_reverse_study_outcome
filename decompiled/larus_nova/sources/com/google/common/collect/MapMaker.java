package com.google.common.collect;

import com.google.common.base.Equivalence;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class MapMaker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f275202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f275203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f275204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @CheckForNull
    public MapMakerInternalMap.Strength f275205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @CheckForNull
    public MapMakerInternalMap.Strength f275206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @CheckForNull
    public Equivalence<Object> f275207f;

    public static final enum Dummy extends Enum<Dummy> {
        public static final Dummy VALUE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Dummy[] f275208a = null;

        static {
            Dummy r100 = new Dummy();
            VALUE = r100;
            f275208a = new Dummy[]{r100};
        }

        public Dummy() {
            super("VALUE", 0);
        }

        public static Dummy[] values() {
            return (Dummy[]) f275208a.clone();
        }

        public static Dummy valueOf(String r100) {
            return (Dummy) r27.a.a(Dummy.class, r100);
        }
    }

    public final MapMakerInternalMap.Strength a() {
        return (MapMakerInternalMap.Strength) com.google.common.base.j.a(this.f275205d, MapMakerInternalMap.Strength.STRONG);
    }

    public final MapMakerInternalMap.Strength b() {
        return (MapMakerInternalMap.Strength) com.google.common.base.j.a(this.f275206e, MapMakerInternalMap.Strength.STRONG);
    }

    public final <K, V> ConcurrentMap<K, V> c() {
        if (this.f275202a == true) goto L13;
        int r100 = this.f275203b;
        if (r100 != (-1)) goto L7;
        r100 = 16;
    L7:
        int r101 = this.f275204c;
        if (r101 != (-1)) goto L11;
        r101 = 4;
    L11:
        return new ConcurrentHashMap(r100, 0.75f, r101);
    L13:
        return MapMakerInternalMap.create(this);
    }

    public final void e() {
        d(MapMakerInternalMap.Strength.WEAK);
    }

    public final void f() {
        MapMakerInternalMap.Strength r100 = MapMakerInternalMap.Strength.WEAK;
        MapMakerInternalMap.Strength r101 = this.f275206e;
        if (r101 != null) goto L5;
        boolean r102 = true;
    L6:
        com.google.common.base.m.s(r102, "Value strength was already set to %s", r101);
        r100.getClass();
        this.f275206e = r100;
        if (r100 == MapMakerInternalMap.Strength.STRONG) goto L10;
        this.f275202a = true;
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public MapMaker() {
        this.f275203b = -1;
        this.f275204c = -1;
    }

    public final String toString() {
        com.google.common.base.j.a r100 = com.google.common.base.j.b(this);
        int r101 = this.f275203b;
        if (r101 == (-1)) goto L5;
        r100.c("initialCapacity", String.valueOf(r101));
    L5:
        int r102 = this.f275204c;
        if (r102 == (-1)) goto L8;
        r100.c("concurrencyLevel", String.valueOf(r102));
    L8:
        MapMakerInternalMap.Strength r103 = this.f275205d;
        if (r103 == null) goto L11;
        r100.b("keyStrength", com.google.common.base.a.a(r103.toString()));
    L11:
        MapMakerInternalMap.Strength r104 = this.f275206e;
        if (r104 == null) goto L15;
        r100.b("valueStrength", com.google.common.base.a.a(r104.toString()));
    L15:
        if (this.f275207f == null) goto L18;
        r100.d("keyEquivalence");
    L18:
        return r100.toString();
    }

    public final void d(MapMakerInternalMap.Strength r100) {
        MapMakerInternalMap.Strength r101 = this.f275205d;
        if (r101 != null) goto L5;
        boolean r102 = true;
    L6:
        com.google.common.base.m.s(r102, "Key strength was already set to %s", r101);
        r100.getClass();
        this.f275205d = r100;
        if (r100 == MapMakerInternalMap.Strength.STRONG) goto L10;
        this.f275202a = true;
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
