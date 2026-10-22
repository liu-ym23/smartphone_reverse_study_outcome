package com.obric.assistant.cocreationreview;

import com.baidu.platform.comapi.map.MapController;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class CocreationCardViewCache<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, a<V>> f387001a;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0005`\u0006B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u000eH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationCardViewCache$LruMap;", "V", "", "Ljava/util/LinkedHashMap;", "", "Lcom/obric/assistant/cocreationreview/CocreationCardViewCache$CacheEntry;", "Lkotlin/collections/LinkedHashMap;", "maxSize", "", "<init>", "(I)V", "removeEldestEntry", "", "eldest", "", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LruMap<V> extends LinkedHashMap<String, a<V>> {
        private final int maxSize;

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, a<V>>> entrySet() {
            return (Set<Map.Entry<String, a<V>>>) getEntries();
        }

        public /* bridge */ Set<Map.Entry<String, a<Object>>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<a<Object>> getValues() {
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
        public final /* bridge */ Collection<a<V>> values() {
            return (Collection<a<V>>) getValues();
        }

        public LruMap(int r100) {
            super(16, 0.75f, true);
            this.maxSize = r100;
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
            if ((r100 instanceof a) == true) goto L7;
            return false;
        L7:
            return containsValue((a) r100);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ a<V> get(Object r100) {
            if ((r100 instanceof String) == true) goto L7;
            return null;
        L7:
            return (a<V>) get((String) r100);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ a<V> remove(Object r100) {
            if ((r100 instanceof String) == true) goto L7;
            return null;
        L7:
            return (a<V>) remove((String) r100);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, a<V>> r100) {
            Intrinsics.checkNotNullParameter(r100, "eldest");
            if (size() <= this.maxSize) goto L5;
            return true;
        L5:
            return false;
        }

        public /* bridge */ boolean containsKey(String r100) {
            return super.containsKey(r100);
        }

        public /* bridge */ boolean containsValue(a<Object> r100) {
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

        public /* bridge */ a<Object> get(String r100) {
            return (a) super.get(r100);
        }

        public /* bridge */ a<Object> remove(String r100) {
            return (a) super.remove(r100);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object r100, Object r101) {
            if ((r100 instanceof String) == true) goto L6;
            return r101;
        L6:
            return getOrDefault((String) r100, (a) r101);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r100, Object r101) {
            if ((r100 instanceof String) == true) goto L6;
            return false;
        L6:
            if ((r101 instanceof a) == true) goto L9;
            return false;
        L9:
            return remove((String) r100, (a) r101);
        }

        public final /* bridge */ a<V> getOrDefault(Object r100, a<V> r101) {
            if ((r100 instanceof String) == true) goto L6;
            return r101;
        L6:
            return (a<V>) getOrDefault((String) r100, r101);
        }

        public /* bridge */ boolean remove(String r100, a<Object> r101) {
            return super.remove(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ a<Object> getOrDefault(String r100, a<Object> r101) {
            return (a) super.getOrDefault(r100, r101);
        }
    }

    public static final class a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q5 f387002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f387003b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f387002a, r101.f387002a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f387003b, r101.f387003b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f387002a.hashCode() * 31) + this.f387003b.hashCode();
        }

        public final String toString() {
            return "CacheEntry(item=" + this.f387002a + ", view=" + this.f387003b + ')';
        }

        public a(q5 r100, V r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f387002a = r100;
            this.f387003b = r101;
        }
    }

    public CocreationCardViewCache() {
        this.f387001a = new LruMap(24);
    }
}
