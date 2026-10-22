package com.larus.bmhome.view.actionbar.custom.cache;

import android.os.SystemClock;
import android.util.LruCache;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel;
import com.larus.bmhome.view.actionbar.custom.l;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes26.dex */
public final class ActionBarCacheStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ActionBarCacheStore f315858a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f315859b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f315860c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<String, List<z0>> f315861d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f315862e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CompletableDeferred<List<z0>>> f315863f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final MutexImpl f315864g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Pair<String, ? extends List<z0>> f315865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final LruCache<String, List<z0>> f315866i = null;

    public ActionBarCacheStore() {
    }

    static {
        f315858a = new ActionBarCacheStore();
        f315859b = Keva.getRepo(CustomActionBarViewModel.CACHE_FILE);
        f315860c = LazyKt.lazy(new a());
        f315861d = new LruCache(10);
        f315862e = new Object();
        f315863f = new ConcurrentHashMap();
        f315864g = kotlinx.coroutines.sync.b.a();
        f315866i = new LruCache(10);
    }

    public static ConcurrentHashMap g() {
        return (ConcurrentHashMap) f315860c.getValue();
    }

    public static List e(String r100) {
        Object r101 = f315862e;
        monitor-enter(r101);
        List<z0> r102 = f315861d.get(r100);     // Catch: Throwable -> L11
        if (r102 == null) goto L8;
        List r103 = CollectionsKt.toList(r102);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);
        return r103;
    L8:
        r103 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean i(String r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L18;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (StringsKt.contains$default(r100, "aippt", false, 2, null) != true) goto L13;
        r102 = true;
        goto L14
    L18:
        return true;
    L5:
        if (StringsKt.contains$default(r100, "doc", false, 2, null) != true) goto L7;
        r101 = true;
        goto L8
    }

    public static List d(String r100, boolean r110) {
        long r101 = SystemClock.elapsedRealtime();
        String r102 = f315859b.getString(r100, "");
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L29;
        FLogger.f375446a.i("ActionBarCacheStore", "getCacheConfig, has no cache");
        return null;
    L29:
        List r104 = (List) xt7.d.f565073b.c(kuc.a.d(kuc.a.b(z0.Companion.serializer())), r102);     // Catch: Exception -> L24
        if (r104 != null) goto L16;
        r104 = CollectionsKt.emptyList();     // Catch: Exception -> L24
    L16:
        FLogger.f375446a.d("ActionBarCacheStore", "get cache and json parse cache cost: " + (SystemClock.elapsedRealtime() - r101));     // Catch: Exception -> L24
        ArrayList r105 = new ArrayList();     // Catch: Exception -> L24
        Iterator r106 = r104.iterator();     // Catch: Exception -> L24
    L17:
        if (r106.hasNext() == false) goto L23;
        Object r107 = r106.next();     // Catch: Exception -> L24
        if (o0.d(((z0) r107).f295609e) == false) goto L17;
        r105.add(r107);     // Catch: Exception -> L24
        goto L17
    L23:
        return r105;
    L24:
        e = move-exception;
        FLogger.f375446a.e("ActionBarCacheStore", "getCacheConfig, err.msg=" + e.getMessage());
        if (r110 == true) goto L28;
        return null;
    L28:
        return new ArrayList();
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public static List h(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "parseCallback");
        Pair<String, ? extends List<z0>> r102 = f315865h;
        if (r102 == null) goto L5;
        String r103 = r102.getFirst();
    L7:
        if (Intrinsics.areEqual(r100, r103) == false) goto L12;
        Pair<String, ? extends List<z0>> r104 = f315865h;
        if (r104 != null) goto L11;
        return null;
    L11:
        return r104.getSecond();
    L12:
        LruCache<String, List<z0>> r105 = f315866i;
        List<z0> r106 = r105.get(r100);
        if (r106 != null) goto L17;
        r106 = (List) r101.invoke(r100);
        if (r106 == null) goto L17;
        r105.put(r100, r106);
    L17:
        f315865h = TuplesKt.to(r100, r106);
        return r106;
    L5:
        r103 = null;
        goto L7
    }

    public final Object j(Function0<Unit> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ActionBarCacheStore$runRemoteStoreOnIo$1) == false) goto L7;
        ActionBarCacheStore$runRemoteStoreOnIo$1 r102 = (ActionBarCacheStore$runRemoteStoreOnIo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L20;
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L18;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
    L27:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r107.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        kotlinx.coroutines.sync.a r109 = r107;
        th = th;
    L32:
        r109.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r110 = (kotlinx.coroutines.sync.a) r102.L$1;
        Function0<Unit> r111 = (Function0) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r109 = r110;
        r100 = r111;
    L36:
        CoroutineDispatcher r112 = Dispatchers.getIO();     // Catch: Throwable -> L31
        ActionBarCacheStore$runRemoteStoreOnIo$2$1 r113 = new ActionBarCacheStore$runRemoteStoreOnIo$2$1(r100, null);     // Catch: Throwable -> L31
        r102.L$0 = r109;     // Catch: Throwable -> L31
        r102.L$1 = null;     // Catch: Throwable -> L31
        r102.label = 2;     // Catch: Throwable -> L31
        if (BuildersKt.withContext(r112, r113, r102) != r105) goto L26;
        return r105;
    L26:
        r107 = r109;
    L31:
        th = th;
        goto L32
    L20:
        ResultKt.throwOnFailure(r104);
        r109 = f315864g;
        r102.L$0 = r100;
        r102.L$1 = r109;
        r102.label = 1;
        if (r109.a(null, r102) != r105) goto L36;
        return r105;
    L7:
        r102 = new ActionBarCacheStore$runRemoteStoreOnIo$1(this, r101);
        goto L8
    }

    public static void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "langCode");
        String r103 = AccountService.f365697a.getUserId();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        String r104 = f(r103, r100, r101, r102);
        FLogger.f375446a.i("ActionBarCacheStore", "clearMemoryCache, cacheKey=" + r104);
        g().remove(r104);
        Object r105 = f315862e;
        monitor-enter(r105);
        List<z0> r106 = f315861d.remove(r104);     // Catch: Throwable -> L12
        monitor-exit(r105);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static List b(String r100, String r101, String r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "langCode");
        String r104 = AccountService.f365697a.getUserId();
        if (r101 != null) goto L6;
        return null;
    L6:
        if (i(r102) == false) goto L8;
        return null;
    L8:
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        String r105 = f(r104, r100, r101, r102);
        boolean r106 = false;
        if (com.larus.platform.exp.a.f365360a == false) goto L50;
        List<z0> r107 = e(r105);
        if (r107 != null) goto L34;
        CompletableDeferred<List<z0>> r108 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        ConcurrentHashMap<String, CompletableDeferred<List<z0>>> r109 = f315863f;
        if (r109.putIfAbsent(r105, r108) == null) goto L80;
        r107 = e(r105);
        goto L34
    L80:
        List<z0> r110 = e(r105);     // Catch: Throwable -> L46
        if (r110 != null) goto L31;
        List<z0> r111 = d(r105, false);     // Catch: Throwable -> L46
        if (r111 == null) goto L30;
        g().remove(r105);     // Catch: Throwable -> L46
        Object r112 = f315862e;     // Catch: Throwable -> L46
        monitor-enter(r112);     // Catch: Throwable -> L46
        List<z0> r113 = f315861d.put(r105, CollectionsKt.toList(r111));     // Catch: Throwable -> L27
        monitor-exit(r112);     // Catch: Throwable -> L46
    L32:
        r109.remove(r105, r108);     // Catch: Throwable -> L46
        r108.complete(r111);     // Catch: Throwable -> L46
        r107 = r111;
        goto L34
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L30:
        r111 = null;
        goto L32
    L31:
        r111 = r110;
    L46:
        th = move-exception;
        f315863f.remove(r105, r108);
        r108.completeExceptionally(th);
        throw th;
    L34:
        if (r107 != null) goto L36;
        return null;
    L36:
        if (r103 == null) goto L44;
        ArrayList r114 = new ArrayList();
        Iterator r115 = r107.iterator();
    L39:
        if (r115.hasNext() == false) goto L43;
        Object r116 = r115.next();
        if (((Boolean) r103.invoke(r116)).booleanValue() == false) goto L39;
        r114.add(r116);
        goto L39
    L43:
        r107 = r114;
    L44:
        FLogger.f375446a.i("ActionBarCacheStore", "getCacheConfig, cacheKey=" + r105 + ", result=" + r107.size());
        return r107;
    L50:
        if (g().containsKey(r105) == false) goto L54;
        FLogger.f375446a.i("ActionBarCacheStore", "getCacheConfig, hit cache");
        ArrayList r117 = new ArrayList();
        List r118 = (List) g().get(r105);
        List r119 = r117;
        if (r118 == null) goto L55;
        r117.addAll(r118);
        r119 = r117;
    L55:
        if (r119 != null) goto L57;
    L58:
        r106 = true;
    L59:
        if (r106 == false) goto L61;
        r119 = d(r105, true);
    L61:
        FLogger r120 = FLogger.f375446a;
        StringBuilder r121 = new StringBuilder("getCacheConfig, cacheKey=");
        r121.append(r105);
        r121.append(", result=");
        if (r119 == null) goto L64;
        Integer r122 = Integer.valueOf(r119.size());
    L65:
        r121.append(r122);
        r120.i("ActionBarCacheStore", r121.toString());
        List r123 = r119;
        if (r119 != null) goto L68;
        return null;
    L68:
        if (r103 == null) goto L76;
        ArrayList r124 = new ArrayList();
        Iterator r125 = r119.iterator();
    L71:
        if (r125.hasNext() == false) goto L75;
        Object r126 = r125.next();
        if (((Boolean) r103.invoke(r126)).booleanValue() == false) goto L71;
        r124.add(r126);
        goto L71
    L75:
        r123 = r124;
    L76:
        g().put(r105, r123);
        return r123;
    L64:
        r122 = null;
        goto L65
    L57:
        if (r119.isEmpty() == false) goto L59;
    L54:
        r119 = null;
        goto L55
    }

    public static String f(String r100, String r101, String r102, String r103) {
        if (r103.length() != 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L15;
        IActionBarService r105 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r105 == null) goto L11;
        String r106 = r105.n();
    L13:
        return r100 + '-' + r101 + '-' + r102 + r106;
    L11:
        r106 = null;
        goto L13
    L15:
        return r100 + '-' + r101 + '-' + r102 + '-' + r103;
    L5:
        r104 = false;
        goto L7
    }

    public static void k(String r100, String r101, String r102, List r103) {
        Intrinsics.checkNotNullParameter(r100, "langCode");
        Intrinsics.checkNotNullParameter(r103, "actionBarItemList");
        String r104 = AccountService.f365697a.getUserId();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        String r105 = f(r104, r100, r101, r102);
        FLogger.f375446a.i("ActionBarCacheStore", "storeMemoryCache, cacheKey=" + r105 + " actionBarItemSize=" + r103.size());
        if (com.larus.platform.exp.a.f365360a == false) goto L17;
        g().remove(r105);
        Object r106 = f315862e;
        monitor-enter(r106);
        List<z0> r107 = f315861d.put(r105, CollectionsKt.toList(r103));     // Catch: Throwable -> L14
        monitor-exit(r106);
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        g().put(r105, r103);
    }

    public static /* synthetic */ List c(String r100, String r101, String r102, com.larus.bmhome.view.actionbar.custom.k r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L12;
        r103 = null;
    L12:
        return b(r100, r101, r102, r103);
    }
}
