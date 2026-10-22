package com.larus.bmhome.double_post.cache;

import com.bytedance.keva.Keva;
import com.larus.bmhome.video.Content;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.k;
import com.larus.platform.api.r2;
import com.larus.platform.service.AccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ip8.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes26.dex */
public final class AwemeDoublePostCacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AwemeDoublePostCacheManager f311406a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f311407b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f311408c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Content> f311409d = null;

    public AwemeDoublePostCacheManager() {
    }

    static {
        f311406a = new AwemeDoublePostCacheManager();
        f311407b = LazyKt.lazy(new a());
        f311408c = LazyKt.lazy(new b());
        f311409d = new ArrayList();
    }

    public static Keva b() {
        return (Keva) f311407b.getValue();
    }

    public static void c() {
        ArrayList r100 = (ArrayList) f311409d;
        if ((!r100.isEmpty()) == false) goto L17;
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (d.a((Content) r103) == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AwemeDoublePostCacheManager$doSaveContentList$1(r101, "aweme_double_post_cache_data_".concat(AccountService.f365697a.getUserId()), null), 2, null);
        return;
    }

    public final Object a(Continuation<? super List<Content>> r100) {
        if ((r100 instanceof AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1) == false) goto L7;
        AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1 r101 = (AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L20:
        return (List) r103;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        String r106 = "aweme_double_post_cache_data_".concat(AccountService.f365697a.getUserId());
        if (b().contains(r106) == false) goto L21;
        CoroutineDispatcher r107 = Dispatchers.getIO();
        AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$cacheData$1 r108 = new AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$cacheData$1(null);
        r101.label = 1;
        r103 = BuildersKt.withContext(r107, r108, r101);
        if (r103 != r104) goto L20;
        return r104;
    L21:
        return null;
    L7:
        r101 = new AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1(this, r100);
        goto L8
    }

    public static void d(List r110, String r111, Long r112) {
        if (r110 == null) goto L6;
        List r100 = CollectionsKt.takeLast(r110, 2);
        if (r100 == null) goto L6;
    L7:
        List r101 = r100;
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        String r104 = ((Content) r103.next()).getItemId();
        if (r104 == null) goto L9;
        r102.add(r104);
        goto L9
    L14:
        if (r110 == null) goto L18;
        Content r105 = (Content) CollectionsKt.firstOrNull(r110);
        if (r105 == null) goto L18;
        String r106 = r105.getRequestId();
    L20:
        if (r106 != null) goto L22;
        r106 = "";
    L22:
        HashMap r107 = new HashMap();
        Iterator r108 = r102.iterator();
    L24:
        if (r108.hasNext() == false) goto L26;
        r107.put((String) r108.next(), r106);
        goto L24
    L26:
        HashMap r113 = new HashMap();
        Iterator r109 = r101.iterator();
    L27:
        boolean r114 = true;
        if (r109.hasNext() == false) goto L45;
        Content r115 = (Content) r109.next();
        String r116 = r115.getItemId();
        if (r116 == null) goto L27;
        Integer r117 = r115.getRecChannelId();
        if (r117 != null) goto L34;
    L43:
        String r118 = "414";
    L44:
        r113.put(r116, r118);
        goto L27
    L34:
        if (r117.intValue() != 0) goto L37;
        r114 = false;
    L37:
        if (r114 == true) goto L40;
        r117 = null;
    L40:
        if (r117 == null) goto L43;
        r118 = r117.toString();
        if (r118 != null) goto L44;
    L45:
        if (r111 != null) goto L47;
        String r119 = "";
    L48:
        if (r112 == null) goto L50;
        long r120 = r112.longValue();
    L51:
        k r121 = new k(r107, r119, r120, new ArrayList(r102), CachedVideosPreloadFrom.UNLIMITED_FLOW, 1, r113);
        IFlowSdkDepend r122 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r122 == null) goto L68;
        r2 r123 = r122.A0();
        if (r123 == null) goto L69;
        r123.o(r121, true);
        return;
    L69:
        return;
    L68:
        return;
    L50:
        r120 = AppHost.f326268a.getAppClock().currentTimeMillis();
        goto L51
    L47:
        r119 = r111;
    L18:
        r106 = null;
    L6:
        r100 = CollectionsKt.emptyList();
        goto L7
    }
}
