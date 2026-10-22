package com.ss.android.ad.applinksdk.core;

import com.ss.android.ad.applinksdk.utils.LruCache;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
public final class AppLinkDataManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppLinkDataCache f406352a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ad/applinksdk/core/AppLinkDataManager$AppLinkDataCache;", "Lcom/ss/android/ad/applinksdk/utils/LruCache;", "", "Lira/a;", "<init>", "()V", "applinksdk_release"}, k = 1, mv = {1, 4, 0})
    public static final class AppLinkDataCache extends LruCache<Long, ira.a> {
        public AppLinkDataCache() {
            super(8, 8);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<Long, ira.a>> entrySet() {
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
        public final /* bridge */ Set<Long> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<ira.a> values() {
            return getValues();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r100) {
            if (r100 == null) goto L4;
            boolean r101 = r100 instanceof Long;
        L5:
            if (r101 == true) goto L7;
            return false;
        L7:
            return containsKey((Long) r100);
        L4:
            r101 = true;
            goto L5
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r100) {
            if (r100 == null) goto L4;
            boolean r101 = r100 instanceof ira.a;
        L5:
            if (r101 == true) goto L7;
            return false;
        L7:
            return containsValue((ira.a) r100);
        L4:
            r101 = true;
            goto L5
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object r100) {
            if (r100 == null) goto L4;
            boolean r101 = r100 instanceof Long;
        L5:
            if (r101 == true) goto L7;
            return null;
        L7:
            return get((Long) r100);
        L4:
            r101 = true;
            goto L5
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object r100) {
            if (r100 == null) goto L4;
            boolean r101 = r100 instanceof Long;
        L5:
            if (r101 == true) goto L7;
            return null;
        L7:
            return remove((Long) r100);
        L4:
            r101 = true;
            goto L5
        }

        public /* bridge */ boolean containsKey(Long r100) {
            return super.containsKey(r100);
        }

        public /* bridge */ boolean containsValue(ira.a r100) {
            return super.containsValue(r100);
        }

        public /* bridge */ ira.a get(Long r100) {
            return (ira.a) super.get(r100);
        }

        public /* bridge */ ira.a remove(Long r100) {
            return (ira.a) super.remove(r100);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
            if (r100 == null) goto L4;
            boolean r102 = r100 instanceof Long;
        L5:
            if (r102 == true) goto L7;
            return r101;
        L7:
            return getOrDefault((Long) r100, (ira.a) r101);
        L4:
            r102 = true;
            goto L5
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r100, Object r101) {
            boolean r102 = true;
            if (r100 == null) goto L5;
            boolean r103 = r100 instanceof Long;
        L6:
            if (r103 == false) goto L12;
            if (r101 == null) goto L9;
            r102 = r101 instanceof ira.a;
        L9:
            if (r102 == true) goto L11;
            return false;
        L11:
            return remove((Long) r100, (ira.a) r101);
        L12:
            return false;
        L5:
            r103 = true;
            goto L6
        }

        public /* bridge */ ira.a getOrDefault(Long r100, ira.a r101) {
            return (ira.a) super.getOrDefault(r100, r101);
        }

        public /* bridge */ boolean remove(Long r100, ira.a r101) {
            return super.remove(r100, r101);
        }
    }

    static {
        f406352a = new AppLinkDataCache();
    }
}
