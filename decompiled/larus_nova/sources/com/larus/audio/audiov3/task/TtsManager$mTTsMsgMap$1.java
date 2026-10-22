package com.larus.audio.audiov3.task;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"com/larus/audio/audiov3/task/TtsManager$mTTsMsgMap$1", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsManager$mTTsMsgMap$1 extends LinkedHashMap<String, String> {
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<String> getValues() {
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
    public final /* bridge */ Collection<String> values() {
        return getValues();
    }

    public TtsManager$mTTsMsgMap$1() {
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
        return containsValue((String) r100);
    L4:
        r101 = r100 instanceof String;
        goto L5
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

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, String> r100) {
        if (size() <= 10) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r100) {
        return super.containsKey(r100);
    }

    public /* bridge */ boolean containsValue(String r100) {
        return super.containsValue(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ String get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r100);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ String remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r100);
    }

    public /* bridge */ String get(String r100) {
        return (String) super.get(r100);
    }

    public /* bridge */ String remove(String r100) {
        return (String) super.remove(r100);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, (String) r101);
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
        return remove((String) r100, (String) r101);
    L7:
        r102 = r101 instanceof String;
        goto L8
    }

    public final /* bridge */ String getOrDefault(Object r100, String r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return getOrDefault((String) r100, r101);
    }

    public /* bridge */ boolean remove(String r100, String r101) {
        return super.remove(r100, r101);
    }

    public /* bridge */ String getOrDefault(String r100, String r101) {
        return (String) super.getOrDefault(r100, r101);
    }
}
