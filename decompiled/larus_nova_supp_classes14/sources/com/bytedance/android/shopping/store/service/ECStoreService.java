package com.bytedance.android.shopping.store.service;

import android.app.Activity;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.h0;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.store.api.IECStoreService;
import com.bytedance.android.ec.store.api.IShopEventListener;
import com.bytedance.android.ec.store.api.ITabKitEventListener;
import com.bytedance.android.ec.store.preload.DomainPreloadConfig;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.home.ECStoreTabKitFragmentBase;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreDataManager;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreTabKitAPIDataCacheManager;
import com.bytedance.android.shopping.store.home.preload.data.e;
import com.bytedance.android.shopping.store.home.preload.net.ECStoreNetPreloadManager;
import com.bytedance.android.shopping.store.hybrid.download.b;
import com.bytedance.android.shopping.store.lifecycle.ResPreloadConfig;
import com.bytedance.android.shopping.store.lifecycle.ShopEventListenCenter;
import com.bytedance.android.shopping.store.router.ShopHelper;
import com.bytedance.android.shopping.store.search.router.ECShopSearchRouter;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.shopfeed.router.ECShopFeedRouter;
import com.bytedance.android.shopping.store.tabkit.brandmall.HybridTabKitFragment;
import com.bytedance.android.shopping.store.tabkit.container.TabKitActivity;
import com.bytedance.android.shopping.store.tabkit.container.TabKitCompactActivity;
import com.bytedance.android.shopping.store.tabkit.events.TabKitEventCenter;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import hj3.f;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jj4.a;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import si3.c;
import si3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreService implements IECStoreService {
    public final Fragment createStoreShellFragment(String r1, int r2, String r3, Object r4, Map<String, String> r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r4, "handler");
        return null;
    }

    public final List<Class<? extends Activity>> getLivePlayActivityClass() {
        return CollectionsKt.listOf(new Class[]{TabKitActivity.class, TabKitCompactActivity.class});
    }

    public final Map<String, Object> getBizComponentFetchers() {
        return MapsKt.mapOf(TuplesKt.to("ec_isv", b.a));
    }

    public final String getFollowXTabSettings() {
        Lazy r0 = ECSettingKeys.a;
        int r1 = p.a;
        Object r2 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/ecom/lynx/client_ecom_follow_store/app/template.js?theme_mode=2&follow_tab=1&follow_tab_fullscreen=0";
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
        Object r5 = a.a("ec_follow_group_lynx_url", String.class, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/ecom/lynx/client_ecom_follow_store/app/template.js?theme_mode=2&follow_tab=1&follow_tab_fullscreen=0", false);     // Catch: Throwable -> L7
        if (r5 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r5;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == true) goto L12;
        r2 = r7;
    L12:
        r5 = r2;
        goto L14
    }

    public final void onStoreEntranceShow() {
        ECStoreNetPreloadManager r0 = (ECStoreNetPreloadManager) ECStoreNetPreloadManager.b.getValue();
        r0.getClass();
        if ((System.currentTimeMillis() - r0.a) <= 90000) goto L22;
        r0.a = System.currentTimeMillis();
        JsonElement r1 = ECStoreSettings.b();
        if (r1 == null) goto L23;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        int r3 = t0.a;     // Catch: Throwable -> L16
        List r4 = ((DomainPreloadConfig) t0.a.a.fromJson(r1, DomainPreloadConfig.class)).getShopCoreHost();     // Catch: Throwable -> L16
        if (r4 == null) goto L13;
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L16
    L10:
        if (r5.hasNext() == false) goto L12;
        h0.a((String) r5.next());     // Catch: Throwable -> L16
        goto L10
    L12:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Result.constructor-impl(r6);     // Catch: Throwable -> L16
        return;
    L13:
        r6 = null;
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L23:
        return;
    }

    public ECStoreService() {
        bf.a.a(new com.bytedance.android.shopping.store.router.a());
        bf.a.a(new com.bytedance.android.shopping.store.tabkit.brandmall.a());
        bf.a.a(new com.bytedance.android.shopping.store.tabkit.a());
        bf.a.a(new ECShopSearchRouter());
        bf.a.a(new c());
        bf.a.a(new si3.b());
        bf.a.a(new d());
        bf.a.a(new ECShopFeedRouter());
    }

    public final ITabKitEventListener getTabKitEventListener(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        return TabKitEventCenter.a(r2);
    }

    public final void preloadResource(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(UriProtector.getQueryParameter(UriProtector.parse(r5), "entrance_location"));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r6) == false) goto L10;
        r6 = null;
    L10:
        final String r7 = (String) r6;
        if (r7 != null) goto L13;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == false) goto L24;
        return;
    L24:
        int r2 = t0.a;     // Catch: Throwable -> L21
        Object r3 = t0.a.a.fromJson(ECStoreSettings.d(), ResPreloadConfig.class);     // Catch: Throwable -> L21
        final ResPreloadConfig r4 = (ResPreloadConfig) r3;     // Catch: Throwable -> L21
        Lazy r8 = ECTaskManager.b;     // Catch: Throwable -> L21
        ECTaskManager r9 = ECTaskManager.a.a();     // Catch: Throwable -> L21
        Function0<Unit> r10 = new ECStoreService$preloadResource$$inlined$runCatching$lambda$1(r4, r7);     // Catch: Throwable -> L21
        r9.getClass();     // Catch: Throwable -> L21
        ECTaskManager.b(r10);     // Catch: Throwable -> L21
        Result.constructor-impl((ResPreloadConfig) r3);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L13:
        if (r7.length() == 0) goto L16;
        r1 = false;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final boolean shouldRefreshShopCache(String r9) {
        boolean r0 = true;
        if (r9 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        Lazy r3 = ECStoreDataManager.c;
        ECStoreDataManager r4 = ECStoreDataManager.a.a();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r9, "url");
        if (ECStoreFoldPhoneHelper.g() == true) goto L42;
        int r5 = ShopHelper.a;
        ECStoreParam r10 = ShopHelper.c(UriProtector.parse(r9), null);
        ECStoreTabKitAPIDataCacheManager r6 = r4.a();
        String r11 = ShopHelper.d(r10);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r11, "uniqueId");
        Triple<ECShopHeadInfoBlock, Long, fl.b> r7 = r6.b.get(r11);
        if (r7 == null) goto L24;
        fl.b r8 = (fl.b) r7.getThird();
        long r12 = ((Number) r7.getSecond()).longValue();
        Integer r13 = r8.a;
        if (r13 == null) goto L19;
        int r14 = r13.intValue();
    L21:
        if (((r12 + ((long) (r14 * ECDraweeView.SQUARE))) - System.currentTimeMillis()) < 0) goto L24;
        boolean r15 = false;
    L25:
        if (r15 == true) goto L41;
        Triple<ECStoreHomeTabResponseTabkit[], Long, fl.b> r16 = r6.c.get(r11);
        if (r16 == null) goto L36;
        fl.b r17 = (fl.b) r16.getThird();
        long r18 = ((Number) r16.getSecond()).longValue();
        Integer r19 = r17.a;
        if (r19 == null) goto L31;
        int r20 = r19.intValue();
    L33:
        if (((r18 + ((long) (r20 * ECDraweeView.SQUARE))) - System.currentTimeMillis()) < 0) goto L36;
        boolean r21 = false;
    L37:
        if (r21 == true) goto L41;
        r0 = false;
        goto L41
    L31:
        r20 = 0;
    L36:
        r21 = true;
    L41:
        return r0;
    L19:
        r14 = 0;
    L24:
        r15 = true;
        goto L25
    L42:
        return false;
    L5:
        if (r9.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void unregisterShopFragmentListener(String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Lazy r1 = ShopEventListenCenter.a;
        Intrinsics.checkNotNullParameter(r3, "id");
        if (StringsKt.isBlank(r3) == true) goto L7;
        ShopEventListenCenter.a().remove(r3);
        return;
    }

    public final void unregisterTabKitEventListener(String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Lazy r1 = TabKitEventCenter.a;
        Intrinsics.checkNotNullParameter(r3, "id");
        if (StringsKt.isBlank(r3) == true) goto L7;
        ((ConcurrentHashMap) TabKitEventCenter.a.getValue()).remove(r3);
        return;
    }

    public final void notifyFollowStoreVideoMiss(String r2, String r3) {
        s0.a(new f(r2, r3));
    }

    public final void preFetchShopAPI(String r6, fl.b r7) {
        Intrinsics.checkNotNullParameter(r7, "shopAPIPreloadConfig");
        if (k.c(r6) == false) goto L14;
        Lazy r1 = ECStoreDataManager.c;
        ECStoreDataManager r2 = ECStoreDataManager.a.a();
        Intrinsics.checkNotNull(r6);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r7, "shopPreloadConfig");
        if (ECStoreFoldPhoneHelper.g() == true) goto L15;
        int r3 = ShopHelper.a;
        ECStoreParam r8 = ShopHelper.c(UriProtector.parse(r6), null);
        ECStoreTabKitAPIDataCacheManager r4 = r2.a();
        String r5 = ShopHelper.d(r8);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r8, "storeParam");
        Intrinsics.checkNotNullParameter(r5, "uniqueId");
        Intrinsics.checkNotNullParameter(r7, "shopAPIPreloadConfig");
        r7.getClass();
        if ((!Intrinsics.areEqual(null, Boolean.TRUE)) == true) goto L17;
        r4.a.a(r8, 1, "/shop/preload/sws/info/").subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.shopping.store.home.preload.data.b(r4, r5, r7));
        ECShopABSettings.k.getClass();
        if (ECShopABSettings.h() == false) goto L12;
        r4.a.d(r8, 1, "/shop/bff/tab/stream/").subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.shopping.store.home.preload.data.d(r4, r5, r7));
        return;
    L12:
        r4.a.c(r8, 1, "/shop/preload/home/tab/").subscribeOn(Schedulers.io()).subscribe(new e(r4, r5, r7));
        return;
    L17:
        return;
    L15:
        return;
    }

    public final void registerShopFragmentListener(String r4, IShopEventListener r5) {
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "listener");
        Lazy r2 = ShopEventListenCenter.a;
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (StringsKt.isBlank(r4) == false) goto L6;
        return;
    L6:
        if (ShopEventListenCenter.a().containsKey(r4) == false) goto L8;
        dm.a.a("ShopEventCenter").b("register listener error! duplicate id: " + r4, null);
        return;
    L8:
        ShopEventListenCenter.a().put(r4, r5);
    }

    public final void registerTabKitEventListener(String r4, ITabKitEventListener r5) {
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "listener");
        Lazy r2 = TabKitEventCenter.a;
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (StringsKt.isBlank(r4) == true) goto L11;
        Lazy r0 = TabKitEventCenter.a;
        if (((ConcurrentHashMap) r0.getValue()).containsKey(r4) == false) goto L8;
        dm.a.a("TabKitEventCenter").b("register listener error! duplicate id: " + r4, null);
        return;
    L8:
        ((ConcurrentHashMap) r0.getValue()).put(r4, r5);
        return;
    }

    public final void addBrandMallFractionListener(Function2<? super String, ? super WindowManager, Unit> r2, Function2<? super String, ? super Integer, Unit> r3, Function1<? super String, Unit> r4) {
        WeakReference<Function2<String, WindowManager, Unit>> r0 = ECStoreTabKitFragmentBase.o;
        ECStoreTabKitFragmentBase.o = new WeakReference(r2);
        ECStoreTabKitFragmentBase.p = new WeakReference(r4);
        WeakReference<Function2<String, WindowManager, Unit>> r1 = HybridTabKitFragment.j;
        new WeakReference(r3);
        HybridTabKitFragment.k = new WeakReference(r4);
        HybridTabKitFragment.j = new WeakReference(r2);
    }
}
