package io.ktor.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes41.dex */
public final class e<Value> implements Map<String, Value>, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<f, Value> f491957a;

    @Override // java.util.Map
    public final void clear() {
        ((LinkedHashMap) this.f491957a).clear();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, Value>> entrySet() {
        return new l(((LinkedHashMap) this.f491957a).entrySet(), CaseInsensitiveMap$entries$1.INSTANCE, CaseInsensitiveMap$entries$2.INSTANCE);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f491957a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f491957a.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return new l(((LinkedHashMap) this.f491957a).keySet(), CaseInsensitiveMap$keys$1.INSTANCE, CaseInsensitiveMap$keys$2.INSTANCE);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f491957a.size();
    }

    @Override // java.util.Map
    public final Collection<Value> values() {
        return ((LinkedHashMap) this.f491957a).values();
    }

    public e() {
        this.f491957a = new LinkedHashMap();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f491957a.containsKey(new f(r101));
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return ((LinkedHashMap) this.f491957a).containsValue(r100);
    }

    @Override // java.util.Map
    public final boolean equals(Object r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if ((r100 instanceof e) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(((e) r100).f491957a, this.f491957a);
    }

    @Override // java.util.Map
    public final Value get(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return null;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        Map<f, Value> r102 = this.f491957a;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        return (Value) r103.get(t.a(r101));
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends Value> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Iterator<Map.Entry<? extends String, ? extends Value>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<? extends String, ? extends Value> r102 = r101.next();
        String r103 = r102.getKey();
        Value r104 = r102.getValue();
        Intrinsics.checkNotNullParameter(r103, "key");
        Intrinsics.checkNotNullParameter(r104, "value");
        this.f491957a.put(t.a(r103), r104);
        goto L4
    }

    @Override // java.util.Map
    public final Value remove(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return null;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f491957a.remove(t.a(r101));
    }

    @Override // java.util.Map
    public final Object put(String r100, Object r101) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        return this.f491957a.put(t.a(r102), r101);
    }
}
