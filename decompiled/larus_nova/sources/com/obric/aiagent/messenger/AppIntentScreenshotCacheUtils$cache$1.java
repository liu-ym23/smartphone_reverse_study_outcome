package com.obric.aiagent.messenger;

import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/obric/aiagent/messenger/AppIntentScreenshotCacheUtils$cache$1", "Ljava/util/LinkedHashMap;", "", "Lcom/obric/aiagent/messenger/AppIntentScreenshotCacheUtils$Entry;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppIntentScreenshotCacheUtils$cache$1 extends LinkedHashMap<String, AppIntentScreenshotCacheUtils.c> {
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, AppIntentScreenshotCacheUtils.c>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, AppIntentScreenshotCacheUtils.c>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<AppIntentScreenshotCacheUtils.c> getValues() {
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
    public final /* bridge */ Collection<AppIntentScreenshotCacheUtils.c> values() {
        return getValues();
    }

    public AppIntentScreenshotCacheUtils$cache$1(int r100) {
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
        if ((r100 instanceof AppIntentScreenshotCacheUtils.c) == true) goto L7;
        return false;
    L7:
        return containsValue((AppIntentScreenshotCacheUtils.c) r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ AppIntentScreenshotCacheUtils.c get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ AppIntentScreenshotCacheUtils.c remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, AppIntentScreenshotCacheUtils.c> r100) {
        boolean r101 = false;
        if (r100 == null) goto L9;
        AppIntentScreenshotCacheUtils.c r102 = r100.getValue();
        if (r102 == null) goto L9;
        if (r102.a() != true) goto L9;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L14;
        FLogger.f375446a.w("AppIntentScreenshotCacheUtils", "remove by invalid " + r100.getKey());
        r101 = true;
    L14:
        if (size() <= AppIntentScreenshotCacheUtils.f384753e) goto L21;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("remove by size ");
        if (r100 == null) goto L18;
        String r106 = r100.getKey();
    L19:
        r105.append(r106);
        r104.w("AppIntentScreenshotCacheUtils", r105.toString());
        return true;
    L18:
        r106 = null;
        goto L19
    L21:
        return r101;
    L9:
        r103 = false;
        goto L11
    }

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(AppIntentScreenshotCacheUtils.c r100) {
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

    public /* bridge */ AppIntentScreenshotCacheUtils.c get(String r100) {
        return (AppIntentScreenshotCacheUtils.c) super.get(r100);
    }

    public /* bridge */ AppIntentScreenshotCacheUtils.c remove(String r100) {
        return (AppIntentScreenshotCacheUtils.c) super.remove(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, (AppIntentScreenshotCacheUtils.c) r101);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r101 instanceof AppIntentScreenshotCacheUtils.c) == true) goto L9;
        return false;
    L9:
        return remove((String) r100, (AppIntentScreenshotCacheUtils.c) r101);
    }

    public final /* bridge */ AppIntentScreenshotCacheUtils.c getOrDefault(Object r100, AppIntentScreenshotCacheUtils.c r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, r101);
    }

    public /* bridge */ boolean remove(String r100, AppIntentScreenshotCacheUtils.c r101) {
        return super.remove(r100, r101);
    }

    public /* bridge */ AppIntentScreenshotCacheUtils.c getOrDefault(String r100, AppIntentScreenshotCacheUtils.c r101) {
        return (AppIntentScreenshotCacheUtils.c) super.getOrDefault(r100, r101);
    }
}
