package com.bytedance.android.shopping.new_cart.monitor;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0014¨\u0006\t"}, d2 = {"com/bytedance/android/shopping/new_cart/monitor/ECCartMonitorReporter$ttnetExtraInfoMap$1", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/android/shopping/new_cart/monitor/b;", "Lkotlin/collections/LinkedHashMap;", "", "eldest", "", "removeEldestEntry", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCartMonitorReporter$ttnetExtraInfoMap$1 extends LinkedHashMap<String, b> {
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, b>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<b> values() {
        return getValues();
    }

    public ECCartMonitorReporter$ttnetExtraInfoMap$1() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r2) {
        if ((r2 instanceof b) == true) goto L7;
        return false;
    L7:
        return containsValue((b) r2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, b> r2) {
        if (size() <= 3) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(b r1) {
        return super.containsValue(r1);
    }

    public /* bridge */ b get(String r1) {
        return (b) super.get(r1);
    }

    public /* bridge */ b remove(String r1) {
        return (b) super.remove(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, (b) r3);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r3, Object r4) {
        boolean r0 = true;
        if (r3 == null) goto L5;
        boolean r1 = r3 instanceof String;
    L6:
        if (r1 == false) goto L13;
        if (r4 == null) goto L9;
        r0 = r4 instanceof b;
    L9:
        if (r0 == true) goto L12;
        return false;
    L12:
        return remove((String) r3, (b) r4);
    L13:
        return false;
    L5:
        r1 = true;
        goto L6
    }

    public /* bridge */ b getOrDefault(String r1, b r2) {
        return (b) super.getOrDefault(r1, r2);
    }

    public /* bridge */ boolean remove(String r1, b r2) {
        return super.remove(r1, r2);
    }
}
