package defpackage;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wu.q1;
import yr.c;

/* JADX INFO: loaded from: classes42.dex */
public final class KevaLRUCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f1215a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1216b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AnonymousClass1 f1217c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReentrantLock f1218d = null;

    /* JADX INFO: renamed from: KevaLRUCache$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"KevaLRUCache$1", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends LinkedHashMap<String, String> {
        final /* synthetic */ KevaLRUCache this$0;

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
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
        public final /* bridge */ Collection<String> values() {
            return getValues();
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
            if ((r100 instanceof String) == true) goto L7;
            return false;
        L7:
            return containsValue((String) r100);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object r100) {
            if ((r100 instanceof String) == true) goto L7;
            return null;
        L7:
            return get((String) r100);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object r100) {
            if ((r100 instanceof String) == true) goto L7;
            return null;
        L7:
            return remove((String) r100);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "eldest");
            int r101 = size();
            Keva r102 = KevaLRUCache.f1215a;
            if (r101 <= KevaLRUCache.f1216b) goto L5;
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

        public /* bridge */ String get(String r100) {
            return (String) super.get(r100);
        }

        public /* bridge */ String remove(String r100) {
            return (String) super.remove(r100);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
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
            if ((r101 instanceof String) == true) goto L8;
            return false;
        L8:
            return remove((String) r100, (String) r101);
        }

        public /* bridge */ String getOrDefault(String r100, String r101) {
            return (String) super.getOrDefault(r100, r101);
        }

        public /* bridge */ boolean remove(String r100, String r101) {
            return super.remove(r100, r101);
        }

        public AnonymousClass1(KevaLRUCache r100, int r101, float r102, boolean r103) {
            this.this$0 = r100;
            super(r101, r102, r103);
        }
    }

    public KevaLRUCache() {
    }

    static {
        KevaLRUCache r100 = new KevaLRUCache();
        ReentrantLock r101 = new ReentrantLock();
        f1218d = r101;
        r101.lock();
        Keva r102 = Keva.getRepo("gamecp_game_apk_md5", 1);     // Catch: Throwable -> L16
        f1215a = r102;     // Catch: Throwable -> L16
        Integer r103 = q1.f561373a.getValue().h();     // Catch: Throwable -> L16
        if (r103 != null) goto L6;
    L8:
        int r104 = 32;
    L9:
        f1216b = r104;     // Catch: Throwable -> L16
        c.e("game_apk_md5_KevaLRUCache", "kevaLruCache max size: " + r104);     // Catch: Throwable -> L16
        f1217c = new AnonymousClass1(r100, 8, 0.75f, true);     // Catch: Throwable -> L16
        c.e("game_apk_md5_KevaLRUCache", "KevaLRUCache init cache-----start");     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, ?>> r105 = r102.getAll().entrySet().iterator();     // Catch: Throwable -> L16
    L11:
        if (r105.hasNext() == false) goto L13;
        Map.Entry<String, ?> r106 = r105.next();     // Catch: Throwable -> L16
        String r107 = r106.getKey();     // Catch: Throwable -> L16
        Object r108 = r106.getValue();     // Catch: Throwable -> L16
        f1217c.put(r107, String.valueOf(r108));     // Catch: Throwable -> L16
        c.e("game_apk_md5_KevaLRUCache", "key:" + r107 + "  value: " + r108);     // Catch: Throwable -> L16
        goto L11
    L13:
        c.e("game_apk_md5_KevaLRUCache", "KevaLRUCache init cache------end");     // Catch: Throwable -> L16
        f1218d.unlock();
        return;
    L6:
        if (r103.intValue() <= 0) goto L8;
        r104 = r103.intValue();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        f1218d.unlock();
        throw th;
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ReentrantLock r101 = f1218d;
        r101.lock();
        AnonymousClass1 r102 = f1217c;     // Catch: Throwable -> L9
        String r103 = (String) r102.get(r100);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        r102.put(r100, r103);     // Catch: Throwable -> L9
    L7:
        c.e("game_apk_md5_KevaLRUCache", "KevaLRUCache.get()  key:" + r100 + "  value: " + r103);     // Catch: Throwable -> L9
        r101.unlock();
        return r103;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        c.c("game_apk_md5_KevaLRUCache", "KevaLRUCache.get() error", th);     // Catch: Throwable -> L13
        f1218d.unlock();
        return null;
    L13:
        th = move-exception;
        f1218d.unlock();
        throw th;
    }

    public static void c(String r100) {
        String r101 = (String) ListProtector.get(StringsKt.split$default(r100, new String[]{"_"}, false, 0, 6, null), 0);
        Set<String> r102 = f1217c.keySet();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (StringsKt.startsWith$default((String) r105, r101 + "_", false, 2, null) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        Iterator r106 = r103.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        String r107 = (String) r106.next();
        f1217c.remove(r107);
        f1215a.erase(r107);
        c.e("game_apk_md5_KevaLRUCache", "KevaLRUCache.removeOldVersionMd5() remove key: " + r107);
        goto L10
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        ReentrantLock r102 = f1218d;
        r102.lock();
        AnonymousClass1 r103 = f1217c;     // Catch: Throwable -> L9
        if (r103.size() < f1216b) goto L7;
        String r104 = (String) CollectionsKt.first(r103.keySet());     // Catch: Throwable -> L9
        r103.remove(r104);     // Catch: Throwable -> L9
        f1215a.erase(r104);     // Catch: Throwable -> L9
        c.e("game_apk_md5_KevaLRUCache", "KevaLRUCache.put()  key:" + r100 + "  value:" + r101 + ", remove eldestKey:" + r104);     // Catch: Throwable -> L9
    L7:
        c(r100);     // Catch: Throwable -> L9
        r103.put(r100, r101);     // Catch: Throwable -> L9
        f1215a.storeString(r100, r101);     // Catch: Throwable -> L9
        c.e("game_apk_md5_KevaLRUCache", "KevaLRUCache.put() real put, key:" + r100 + "  value:" + r101);     // Catch: Throwable -> L9
        r102.unlock();
        return;
    L9:
        th = move-exception;
        c.c("game_apk_md5_KevaLRUCache", "KevaLRUCache.put() error", th);     // Catch: Throwable -> L13
        f1218d.unlock();
        return;
    L13:
        th = move-exception;
        f1218d.unlock();
        throw th;
    }
}
