package com.bytedance.ies.bullet.flow;

import android.os.Bundle;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bH\u0014¨\u0006\t"}, d2 = {"com/bytedance/ies/bullet/flow/FlowContainerLoaderControl$flowContextMap$1", "Ljava/util/LinkedHashMap;", "", "Landroid/os/Bundle;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class FlowContainerLoaderControl$flowContextMap$1 extends LinkedHashMap<String, Bundle> {
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Bundle>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, Bundle>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Bundle> getValues() {
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
    public final /* bridge */ Collection<Bundle> values() {
        return getValues();
    }

    public FlowContainerLoaderControl$flowContextMap$1(int r100) {
        super(r100, 0.75f, true);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if (r100 != null) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == true) goto L9;
        return false;
    L9:
        return containsValue((Bundle) r100);
    L4:
        r101 = r100 instanceof Bundle;
        goto L5
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Bundle get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Bundle remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, Bundle> r100) {
        Intrinsics.checkNotNullParameter(r100, "eldest");
        int r101 = size();
        FlowContainerLoaderControl$flowContainerLoader$1 r102 = FlowContainerLoaderControl.f246607a;
        if (r101 <= 3) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(Bundle r100) {
        return super.containsValue(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public /* bridge */ Bundle get(String r100) {
        return (Bundle) super.get(r100);
    }

    public /* bridge */ Bundle remove(String r100) {
        return (Bundle) super.remove(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, (Bundle) r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        return false;
    L11:
        return remove((String) r100, (Bundle) r101);
    L7:
        r102 = r101 instanceof Bundle;
        goto L8
    }

    public final /* bridge */ Bundle getOrDefault(Object r100, Bundle r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, r101);
    }

    public /* bridge */ boolean remove(String r100, Bundle r101) {
        return super.remove(r100, r101);
    }

    public /* bridge */ Bundle getOrDefault(String r100, Bundle r101) {
        return (Bundle) super.getOrDefault(r100, r101);
    }
}
