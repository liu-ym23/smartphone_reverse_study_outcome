package com.larus.media.focus;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements Map<String, Map<String, Object>>, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f359059a;

    /* JADX INFO: renamed from: com.larus.media.focus.a$a, reason: collision with other inner class name */
    public static final class C4420a {
    }

    static {
    }

    @Override // java.util.Map
    public final void clear() {
        this.f359059a.clear();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f359059a.isEmpty();
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends Map<String, Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f359059a.putAll(r100);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, Map<String, Object>>> entrySet() {
        return this.f359059a.entrySet();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f359059a.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f359059a.size();
    }

    @Override // java.util.Map
    public final Collection<Map<String, Object>> values() {
        return this.f359059a.values();
    }

    public a(Map r100) {
        this.f359059a = r100;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f359059a.containsKey(r101);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        if (TypeIntrinsics.isMutableMap(r100) == true) goto L6;
        return false;
    L6:
        Map r101 = (Map) r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        return this.f359059a.containsValue(r101);
    }

    @Override // java.util.Map
    public final Map<String, Object> get(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return null;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f359059a.get(r101);
    }

    @Override // java.util.Map
    public final Map<String, Object> remove(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return null;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f359059a.remove(r101);
    }

    @Override // java.util.Map
    public final Map<String, Object> put(String r100, Map<String, Object> r101) {
        String r102 = r100;
        Map<String, Object> r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "value");
        return this.f359059a.put(r102, r103);
    }
}
