package com.larus.audio.flow.client.cache;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import m58.h;
import m58.t;

/* JADX INFO: loaded from: classes24.dex */
public final class TtsCacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f289720a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f289721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f289722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f289723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f289724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f289725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f289726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f289727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f289728i;

    public TtsCacheManager() {
    }

    static {
        f289720a = LazyKt.lazy(new e());
    }

    public static final void a() {
        String r100 = "";
        if (f289727h == false) goto L9;
        a r101 = d();
        String r102 = f289728i;
        if (r102 == null) goto L8;
        r100 = r102;
    L8:
        r101.a(r100, true);
    L14:
        f289728i = null;
        return;
    L9:
        a r103 = d();
        String r104 = f289728i;
        if (r104 == null) goto L13;
        r100 = r104;
    L13:
        r103.a(r100, false);
        goto L14
    }

    public static a d() {
        return (a) f289720a.getValue();
    }

    public static void e() {
        t r100 = h.f512142m;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L13;
        c68.b.d("TtsCacheManager", "tts cache is disabled");
        return;
    L13:
        if (f289725f == false) goto L16;
        c68.b.d("TtsCacheManager", "tts cache is already init");
        return;
    L16:
        c68.b.a("TtsCacheManager", "registerListener");
        GlobalScope r102 = GlobalScope.INSTANCE;
        BuildersKt.launch$default(r102, Dispatchers.getIO(), null, new TtsCacheManager$registerTtsEventListener$1(null), 2, null);
        BuildersKt.launch$default(r102, Dispatchers.getIO(), null, new TtsCacheManager$registerTtsEventListener$2(null), 2, null);
        BuildersKt.launch$default(r102, Dispatchers.getIO(), null, new TtsCacheManager$registerTtsEventListener$3(null), 2, null);
        f289725f = true;
        return;
    L5:
        if (r100.enableTtsCache() != true) goto L7;
        r101 = true;
        goto L9
    }

    public static boolean b(String r100) {
        boolean r101 = d().contains(r100);
        int r102 = c68.b.f22600a;
        c68.b.a("TtsCacheManager", "contains key = " + r100 + " result = " + r101);
        return r101;
    }

    public static void c(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        int r102 = c68.b.f22600a;
        c68.b.d("TtsCacheManager", "deleteCacheByMessageId messageId = " + r100 + ", cacheId = " + f289728i);
        f289726g = r100;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new TtsCacheManager$deleteByKey$1(null), 2, null);
        return;
    L5:
        r101 = false;
        goto L6
    }
}
