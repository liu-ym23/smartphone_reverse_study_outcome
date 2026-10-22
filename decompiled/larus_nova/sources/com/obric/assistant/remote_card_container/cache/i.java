package com.obric.assistant.remote_card_container.cache;

import androidx.collection.LruCache;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f391243a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, String> f391244b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f391245c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f391246d = null;

    public i() {
    }

    static {
        f391243a = new i();
        f391244b = new LruCache(100);
        f391245c = LazyKt.lazy(new f());
        f391246d = SetsKt.setOf(AppHost.f326268a.getApplication().getPackageName());
    }

    public static void b(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "cardUri");
        p9a.e r101 = p9a.b.f528329a;
        p9a.b.a("DiskCache", "removeCache: " + r100);
        CardCacheManager r102 = CardCacheManager.f391235a;
        CardCacheManager.b(new g(r100));
    }

    public static Set c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pkgName");
        LinkedHashSet r101 = new LinkedHashSet();
        m r102 = m.f391249a;
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter(r100, "pkgName");     // Catch: Throwable -> L42
        LinkedHashMap r103 = new LinkedHashMap();     // Catch: Throwable -> L42
        Map<String, j> r104 = m.f391252d.snapshot();     // Catch: Throwable -> L42
        LinkedHashMap r105 = new LinkedHashMap();     // Catch: Throwable -> L42
        Iterator<Map.Entry<String, j>> r106 = r104.entrySet().iterator();     // Catch: Throwable -> L42
    L6:
        if (r106.hasNext() == false) goto L10;
        Map.Entry<String, j> r107 = r106.next();     // Catch: Throwable -> L42
        if (Intrinsics.areEqual(UriProtector.parse(r107.getKey()).getHost(), r100) == false) goto L6;
        r105.put(r107.getKey(), r107.getValue());     // Catch: Throwable -> L42
        goto L6
    L10:
        Iterator r108 = r105.entrySet().iterator();     // Catch: Throwable -> L42
    L12:
        if (r108.hasNext() == false) goto L14;
        Map.Entry r109 = (Map.Entry) r108.next();     // Catch: Throwable -> L42
        r103.put(r109.getKey(), r109.getValue());     // Catch: Throwable -> L42
        goto L12
    L14:
        Set<String> r110 = m.f391250b.getAll().keySet();     // Catch: Throwable -> L42
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L42
        Iterator<T> r112 = r110.iterator();     // Catch: Throwable -> L42
    L16:
        if (r112.hasNext() == false) goto L25;
        Object r113 = r112.next();     // Catch: Throwable -> L42
        String r114 = (String) r113;     // Catch: Throwable -> L42
        Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L42
        if (Intrinsics.areEqual(UriProtector.parse(r114).getHost(), r100) == true) goto L20;
    L22:
        boolean r115 = false;
    L23:
        if (r115 == false) goto L16;
        r111.add(r113);     // Catch: Throwable -> L42
        goto L16
    L20:
        if (r103.containsKey(r114) == true) goto L22;
        r115 = true;
        goto L23
    L25:
        Iterator r116 = r111.iterator();     // Catch: Throwable -> L42
    L26:
        if (r116.hasNext() == false) goto L32;
        String r117 = (String) r116.next();     // Catch: Throwable -> L42
        j r118 = m.f391249a.a(r117);     // Catch: Throwable -> L42
        if (r118 == null) goto L26;
        r103.put(r117, r118);     // Catch: Throwable -> L42
        goto L26
    L32:
        monitor-exit(r102);
        ArrayList r119 = new ArrayList(r103.size());
        Iterator r120 = r103.entrySet().iterator();
    L35:
        if (r120.hasNext() == false) goto L37;
        r119.add(((j) ((Map.Entry) r120.next()).getValue()).c());
        goto L35
    L37:
        Iterator r121 = CollectionsKt.filterNotNull(r119).iterator();
    L39:
        if (r121.hasNext() == false) goto L41;
        String r122 = (String) r121.next();
        r101.add(r122);
        b(r122);
        goto L39
    L41:
        return r101;
    L42:
        th = move-exception;
        throw th;
    }

    public static String d(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        byte[] r102 = MessageDigest.getInstance("SHA-256").digest(r100.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L7
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L7
        int r104 = r102.length;     // Catch: Throwable -> L7
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        byte r106 = r102[r105];     // Catch: Throwable -> L7
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L7
        r103.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r106)}, 1)));     // Catch: Throwable -> L7
        r105 = r105 + 1;     // Catch: Throwable -> L7
        goto L3
    L5:
        Object r108 = Result.m9449constructorimpl(r103.toString());     // Catch: Throwable -> L7
    L10:
        if (Result.m9452exceptionOrNullimpl(r108) == null) goto L13;
        p9a.e r109 = p9a.b.f528329a;
        p9a.b.b("DiskCache", "stringToSHA256 failed, input: " + r100);
    L13:
        if (Result.m9455isFailureimpl(r108) == false) goto L16;
        r108 = "";
    L16:
        return (String) r108;
    L7:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final synchronized String a(String r100) {
        monitor-enter(this);
        LruCache<String, String> r101 = f391244b;     // Catch: Throwable -> L16
        String r102 = r101.get(r100);     // Catch: Throwable -> L16
        if (r102 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        monitor-exit(this);
        return r102;
    L13:
        String r104 = d(r100);     // Catch: Throwable -> L16
        r101.put(r100, r104);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r104;
    L6:
        if (r102.length() == 0) goto L9;
        r103 = false;
    L16:
        th = move-exception;
        throw th;
    }
}
