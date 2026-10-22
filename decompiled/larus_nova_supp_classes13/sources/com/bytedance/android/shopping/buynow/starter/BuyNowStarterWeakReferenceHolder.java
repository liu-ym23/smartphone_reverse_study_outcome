package com.bytedance.android.shopping.buynow.starter;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u0005B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/buynow/starter/BuyNowStarterWeakReferenceHolder;", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/shopping/buynow/starter/n;", "Lkotlin/collections/HashMap;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class BuyNowStarterWeakReferenceHolder extends HashMap<String, WeakReference<n>> {
    public static final BuyNowStarterWeakReferenceHolder INSTANCE = null;

    static {
        INSTANCE = new BuyNowStarterWeakReferenceHolder();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, WeakReference<n>>> entrySet() {
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

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<WeakReference<n>> values() {
        return getValues();
    }

    private BuyNowStarterWeakReferenceHolder() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r2) {
        if ((r2 instanceof WeakReference) == true) goto L7;
        return false;
    L7:
        return containsValue((WeakReference) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ WeakReference<n> get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ WeakReference<n> remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(WeakReference r1) {
        return super.containsValue(r1);
    }

    public /* bridge */ WeakReference get(String r1) {
        return (WeakReference) super.get(r1);
    }

    public /* bridge */ WeakReference remove(String r1) {
        return (WeakReference) super.remove(r1);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object r2, Object r3) {
        if (r2 == null) goto L4;
        boolean r0 = r2 instanceof String;
    L5:
        if (r0 == true) goto L8;
        return r3;
    L8:
        return getOrDefault((String) r2, (WeakReference) r3);
    L4:
        r0 = true;
        goto L5
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r3, Object r4) {
        boolean r0 = true;
        if (r3 == null) goto L5;
        boolean r1 = r3 instanceof String;
    L6:
        if (r1 == false) goto L13;
        if (r4 == null) goto L9;
        r0 = r4 instanceof WeakReference;
    L9:
        if (r0 == true) goto L12;
        return false;
    L12:
        return remove((String) r3, (WeakReference) r4);
    L13:
        return false;
    L5:
        r1 = true;
        goto L6
    }

    public /* bridge */ WeakReference getOrDefault(String r1, WeakReference r2) {
        return (WeakReference) super.getOrDefault(r1, r2);
    }

    public /* bridge */ boolean remove(String r1, WeakReference r2) {
        return super.remove(r1, r2);
    }
}
