package ti3;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.marketing.sdk.api.ECMarketingSDK;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreActivityConfig;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeActivityResponse;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeConfig;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabRenderConfig;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabSourceConfig;
import com.bytedance.android.shopping.store.home.entity.n;
import com.bytedance.android.shopping.store.home.preload.data.AIPreloadType;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreDataFutureManager;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreDataManager;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreTabKitAPIDataCacheManager;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.moments.dto.ECStoreMomentResponse;
import com.bytedance.android.shopping.store.router.ShopHelper;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.utils.x;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements ti3.d {

    /* JADX INFO: renamed from: ti3.a$a, reason: collision with other inner class name */
    public static final class C0171a<T, R> implements Function {
        public final /* synthetic */ ECStoreParam a;

        public C0171a(ECStoreParam r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            ECShopHeadInfoBlock r4 = (ECShopHeadInfoBlock) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            Map<Long, m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
            m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getLifecycleMonitorId()));
            if (r1 == null) goto L5;
            r1.o(r4);
        L5:
            return r4;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ECStoreParam a;

        public b(ECStoreParam r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ECShopHeadInfoBlock r3 = (ECShopHeadInfoBlock) r2;
            int r0 = n.r;
            r3.setHeaderInfoBlockVO(n.a.a(r3, this.a));
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ int a;

        public c(int r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            ECShopHeadInfoBlock r5 = (ECShopHeadInfoBlock) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            int r0 = ECMonitorService.b;
            JSONObject r1 = new JSONObject();
            r1.put("preload_request", this.a);
            Unit r2 = Unit.INSTANCE;
            ECMonitorService.a.a("ec_shop_info_request", r1, null, null);
            return r5;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ECStoreParam a;

        public d(ECStoreParam r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ECShopHeadInfoBlock r3 = (ECShopHeadInfoBlock) r2;
            int r0 = n.r;
            r3.setHeaderInfoBlockVO(n.a.a(r3, this.a));
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ int a;

        public e(int r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            ECShopHeadInfoBlock r5 = (ECShopHeadInfoBlock) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            int r0 = ECMonitorService.b;
            JSONObject r1 = new JSONObject();
            r1.put("preload_request", this.a);
            Unit r2 = Unit.INSTANCE;
            ECMonitorService.a.a("ec_shop_info_request", r1, null, null);
            return r5;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ECStoreParam a;

        public f(ECStoreParam r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ECStoreHomeTabResponseTabkit r4 = (ECStoreHomeTabResponseTabkit) r3;
            Map<Long, m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
            m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getLifecycleMonitorId()));
            if (r1 == null) goto L5;
            r1.j();
        L5:
            ECShopABSettings.k.getClass();
            if (ECShopABSettings.g() == false) goto L9;
            com.bytedance.android.shopping.store.home.preload.data.f.a(r4);
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ ECStoreParam a;

        public g(ECStoreParam r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ECStoreHomeTabResponseTabkit r4 = (ECStoreHomeTabResponseTabkit) r3;
            Map<Long, m> r5 = com.bytedance.android.shopping.store.lifecycle.a.a;
            m r6 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getLifecycleMonitorId()));
            if (r6 == null) goto L6;
            r6.j();
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ ECStoreParam a;

        public h(ECStoreParam r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.chunkstreamprediction.network.b r4 = (com.bytedance.android.chunkstreamprediction.network.b) r3;
            Map<Long, m> r5 = com.bytedance.android.shopping.store.lifecycle.a.a;
            m r6 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getLifecycleMonitorId()));
            if (r6 == null) goto L6;
            r6.j();
            return;
        }
    }

    public static final class i<T, R> implements Function {
        public final /* synthetic */ ECStoreParam a;

        public i(ECStoreParam r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            ECStorePreloadInfoResponse r4 = (ECStorePreloadInfoResponse) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            Map<Long, m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
            m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getLifecycleMonitorId()));
            if (r1 == null) goto L5;
            r1.h(r4);
        L5:
            return r4;
        }
    }

    public a() {
    }

    public static Map c(Object r8) {
        String r9 = u0.d(r8);
        Object r3 = null;
        if ((!Intrinsics.areEqual(r9, "{}")) == true) goto L7;
        r9 = null;
    L7:
        if (r9 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L86;
        return null;
    L86:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L78
        JsonObject r10 = (JsonObject) u0.b(r9, JsonObject.class);     // Catch: Throwable -> L78
        LinkedHashMap r6 = new LinkedHashMap();     // Catch: Throwable -> L78
        Iterator r11 = r10.entrySet().iterator();     // Catch: Throwable -> L78
    L17:
        if (r11.hasNext() == false) goto L73;
        Map.Entry r7 = (Map.Entry) r11.next();     // Catch: Throwable -> L78
        CharSequence r12 = (CharSequence) r7.getKey();     // Catch: Throwable -> L78
        if (r12 != null) goto L21;
    L24:
        boolean r13 = true;
    L25:
        if (r13 == true) goto L43;
        JsonElement r14 = (JsonElement) r7.getValue();     // Catch: Throwable -> L78
        if (r14 == null) goto L43;
        if (r14.isJsonPrimitive() != true) goto L43;
        String r15 = ((JsonElement) r7.getValue()).getAsString();     // Catch: Throwable -> L78
        if (r15 != null) goto L33;
    L36:
        boolean r16 = true;
    L38:
        if ((!r16) == true) goto L41;
        r15 = null;
    L41:
        if (r15 == null) goto L17;
        r6.put(r7.getKey(), r15);     // Catch: Throwable -> L78
        goto L17
    L33:
        if (StringsKt.isBlank(r15) == true) goto L36;
        r16 = false;
    L43:
        CharSequence r17 = (CharSequence) r7.getKey();     // Catch: Throwable -> L78
        if (r17 != null) goto L46;
    L49:
        boolean r18 = true;
    L50:
        if (r18 == true) goto L17;
        JsonElement r19 = (JsonElement) r7.getValue();     // Catch: Throwable -> L78
        if (r19 == null) goto L17;
        if (r19.isJsonObject() != true) goto L17;
        String r20 = u0.d(r7.getValue());     // Catch: Throwable -> L78
        if (r20 != null) goto L58;
    L61:
        boolean r21 = true;
    L62:
        if (r21 == false) goto L64;
    L66:
        boolean r22 = false;
    L67:
        if (r22 == true) goto L70;
        r20 = null;
    L70:
        if (r20 == null) goto L17;
        r6.put(r7.getKey(), r20);     // Catch: Throwable -> L78
        goto L17
    L64:
        if ((!Intrinsics.areEqual(r20, "{}")) == false) goto L66;
        r22 = true;
        goto L67
    L58:
        if (StringsKt.isBlank(r20) == true) goto L61;
        r21 = false;
        goto L62
    L46:
        if (StringsKt.isBlank(r17) == true) goto L49;
        r18 = false;
        goto L50
    L21:
        if (StringsKt.isBlank(r12) == true) goto L24;
        r13 = false;
        goto L25
    L73:
        if ((!r6.isEmpty()) == true) goto L76;
        r6 = null;
    L76:
        Object r23 = Result.constructor-impl(r6);     // Catch: Throwable -> L78
    L81:
        if (Result.isFailure-impl(r23) == true) goto L85;
        r3 = r23;
    L85:
        return (Map) r3;
    L78:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L81
    L9:
        if (StringsKt.isBlank(r9) == true) goto L12;
        r4 = false;
        goto L13
    }

    public static Observable j(ECStoreParam r9) {
        Intrinsics.checkNotNullParameter(r9, "storeParam");
        Map<Long, m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r9.getLifecycleMonitorId()));
        if (r1 == null) goto L5;
        r1.n();
    L5:
        int r2 = x.a;
        x.a("/shop/preload/info/", r9.getSecShopId());
        ECStoreApi.a.getClass();
        ECStoreApi r3 = ECStoreApi.a.a;
        if (r3 == null) goto L12;
        Observable<ECStorePreloadInfoResponse> r4 = r3.getPreloadInfo(r9.getSecShopId(), r9.getTabId(), (String) r9.getPassThroughParam("pass_through_api"), r9.getEntranceLocation(), r9.getStoreSourcePage(), r9.getStoreGroupType(), r9.getFlagSupportNestedTab());
        if (r4 == null) goto L12;
        Observable r10 = r4.map(new i(r9));
        if (r10 == null) goto L12;
        return r10;
    L12:
        return Observable.error(new Throwable("getPreloadInfo failed : network service not found"));
    }

    public static Observable f(ECStoreParam r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        int r0 = x.a;
        x.a("/shop/moments/", r2.getSecShopId());
        ECStoreApi.a.getClass();
        ECStoreApi r1 = ECStoreApi.a.a;
        if (r1 == null) goto L7;
        Observable<ECStoreMomentResponse> r4 = r1.getMoments(r2.getSecShopId(), Long.valueOf(r3), 20, r2.getSearchParams());
        if (r4 == null) goto L7;
        return r4;
    L7:
        return Observable.error(new Throwable());
    }

    @Override // ti3.d
    public final Observable<ECStoreHomeActivityResponse> b(ECStoreParam r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "storeParam");
        int r1 = x.a;
        x.a("/shop/home/activity/", r14.getSecShopId());
        ECStoreApi.a.getClass();
        ECStoreApi r2 = ECStoreApi.a.a;
        if (r2 == null) goto L17;
        String r3 = r14.getSecShopId();
        ECStoreActivityConfig.Companion.getClass();
        Intrinsics.checkNotNullParameter(r14, "storeParam");
        ECStoreActivityConfig r0 = new ECStoreActivityConfig();
        r0.setTmpId(r14.getProductBasicRequestParam().getTmpId());
        r0.setToken(r14.getProductBasicRequestParam().getToken());
        Map<String, String> r4 = c(r0);
        if (r4 != null) goto L7;
        r4 = new LinkedHashMap();
    L7:
        Map<String, String> r5 = r4;
        String r6 = (String) r14.getPassThroughParam("pass_through_api");
        String r7 = r14.getExtraSchema();
        String r8 = r14.getProductBasicRequestParam().getCustomIds();
        Integer r9 = r14.getProductBasicRequestParam().getCustomIdType();
        String r10 = k.d(ECShopABSettings.k.b());
        String r16 = r14.getMarketInfo();
        if (r16 != null) goto L10;
        r16 = "";
    L10:
        String r11 = r16;
        IMarketingServiceV2 r17 = ECMarketingSDK.c();
        if (r17 == null) goto L13;
        String r18 = r17.c();
    L14:
        Observable<ECStoreHomeActivityResponse> r19 = r2.getHomeActivityByPost(r3, r5, r6, r7, r8, r9, r15, r10, r11, r18);
        if (r19 == null) goto L17;
        return r19;
    L13:
        r18 = null;
    L17:
        return Observable.error(new Throwable("getHomeActivity failed : network service not found"));
    }

    public static Observable g(ECStoreParam r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "storeParam");
        Intrinsics.checkNotNullParameter(r15, "path");
        ECStoreHomeConfig.Companion.getClass();
        Map r0 = c(ECStoreHomeConfig.a.a(r13));
        if (r0 != null) goto L5;
        r0 = new LinkedHashMap();
    L5:
        Map r1 = MapsKt.plus(r0, MapsKt.mutableMapOf(new Pair[]{new Pair("sec_shop_id", r13.getSecShopId())}));
        Map<Long, m> r2 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r3 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r13.getLifecycleMonitorId()));
        if (r3 == null) goto L8;
        r3.H();
    L8:
        ECShopABSettings r4 = ECShopABSettings.k;
        r4.getClass();
        if (ECShopABSettings.g() == false) goto L19;
        ECStoreApi.a.getClass();
        ECStoreApi r5 = ECStoreApi.a.b;
        if (r5 == null) goto L30;
        Observable<ECShopHeadInfoBlock> r16 = r5.getHomeBlock(r15, k.d(r1), (String) r13.getPassThroughParam("pass_through_api"), k.d(com.bytedance.android.shopping.store.settings.b.a(r4, r13)), new LinkedHashMap(), r13.getClientParams(), r13.getLocalVersionWithoutContent());
        if (r16 == null) goto L30;
        Observable r17 = r16.doOnNext(new b(r13));
        if (r17 == null) goto L30;
        Observable r18 = r17.map(new c(r14));
        if (r18 == null) goto L30;
        return r18;
    L30:
        return Observable.error(new Throwable("getHomeInfo failed : network service not found"));
    L19:
        ECStoreApi.a.getClass();
        ECStoreApi r6 = ECStoreApi.a.b;
        if (r6 == null) goto L28;
        Observable<ECShopHeadInfoBlock> r19 = r6.getHomeBlockByPost(r15, k.d(r1), (String) r13.getPassThroughParam("pass_through_api"), k.d(com.bytedance.android.shopping.store.settings.b.a(r4, r13)), new LinkedHashMap(), r13.getClientParams(), r13.getLocalVersionWithoutContent());
        if (r19 == null) goto L28;
        Observable r110 = r19.doOnNext(new d(r13));
        if (r110 == null) goto L28;
        Observable r111 = r110.map(new e(r14));
        if (r111 == null) goto L28;
        return r111;
    L28:
        return Observable.error(new Throwable("getHomeInfo failed : network service not found"));
    }

    public static Observable h(ECStoreParam r19, int r20, String r21) {
        Intrinsics.checkNotNullParameter(r19, "storeParam");
        Intrinsics.checkNotNullParameter(r21, "path");
        int r1 = x.a;
        x.a("/shop/bff/tab/", r19.getSecShopId());
        Map<Long, m> r2 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r3 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r19.getLifecycleMonitorId()));
        if (r3 == null) goto L5;
        r3.b();
    L5:
        ECShopABSettings r4 = ECShopABSettings.k;
        r4.getClass();
        if (ECShopABSettings.f() == false) goto L8;
        ECStoreApi.a.getClass();
        ECStoreApi r5 = ECStoreApi.a.c;
    L9:
        JSONObject r6 = null;
        if (ECShopABSettings.g() == false) goto L26;
        if (r5 == null) goto L43;
        String r7 = r19.getSecShopId();
        int r9 = r19.getFlagSupportNestedTab();
        ECStoreTabRenderConfig.Companion.getClass();
        Map<String, String> r10 = c(ECStoreTabRenderConfig.a.a(r19));
        if (r10 != null) goto L15;
        r10 = new LinkedHashMap();
    L15:
        ECStoreTabSourceConfig.Companion.getClass();
        Map<String, String> r11 = c(ECStoreTabSourceConfig.a.a(r19));
        if (r11 != null) goto L18;
        r11 = new LinkedHashMap();
    L18:
        JSONObject r8 = k.c((String) r19.getPassThroughParam("pass_through_api"));
        if (r8 == null) goto L21;
        r8.put("is_first_enter", 1);
        Unit r12 = Unit.INSTANCE;
        r6 = r8;
    L21:
        Map<String, String> r13 = r10;
        Map<String, String> r14 = r11;
        Observable<ECStoreHomeTabResponseTabkit> r15 = r5.getHomeTabBFF(r21, r7, r9, r13, r14, String.valueOf(r6), r19.getSearchParams(), 1, r19.getShuffleProductIds(), r20, k.d(com.bytedance.android.shopping.store.settings.b.a(r4, r19)), ECStoreSettings.h(), r19.getClientParams(), r19.getLocalVersionWithoutContent());
        if (r15 == null) goto L43;
        Observable r0 = r15.doOnNext(new f(r19));
        if (r0 == null) goto L43;
        return r0;
    L43:
        return Observable.error(new Throwable());
    L26:
        if (r5 == null) goto L41;
        String r16 = r19.getSecShopId();
        int r17 = r19.getFlagSupportNestedTab();
        ECStoreTabRenderConfig.Companion.getClass();
        Map<String, String> r18 = c(ECStoreTabRenderConfig.a.a(r19));
        if (r18 != null) goto L30;
        r18 = new LinkedHashMap();
    L30:
        ECStoreTabSourceConfig.Companion.getClass();
        Map<String, String> r110 = c(ECStoreTabSourceConfig.a.a(r19));
        if (r110 != null) goto L33;
        r110 = new LinkedHashMap();
    L33:
        JSONObject r22 = k.c((String) r19.getPassThroughParam("pass_through_api"));
        if (r22 == null) goto L36;
        r22.put("is_first_enter", 1);
        Unit r23 = Unit.INSTANCE;
        r6 = r22;
    L36:
        Map<String, String> r24 = r18;
        Map<String, String> r25 = r110;
        Observable<ECStoreHomeTabResponseTabkit> r26 = r5.getHomeTabBFFByPost(r21, r16, r17, r24, r25, String.valueOf(r6), r19.getSearchParams(), 1, r19.getShuffleProductIds(), r20, k.d(com.bytedance.android.shopping.store.settings.b.a(r4, r19)), ECStoreSettings.h(), r19.getClientParams(), r19.getLocalVersionWithoutContent());
        if (r26 == null) goto L41;
        Observable r27 = r26.doOnNext(new g(r19));
        if (r27 == null) goto L41;
        return r27;
    L41:
        return Observable.error(new Throwable());
    L8:
        ECStoreApi.a.getClass();
        r5 = ECStoreApi.a.b;
        goto L9
    }

    public static Observable i(ECStoreParam r17, int r18, String r19) {
        Intrinsics.checkNotNullParameter(r17, "storeParam");
        Intrinsics.checkNotNullParameter(r19, "path");
        int r1 = x.a;
        x.a("/shop/bff/tab/", r17.getSecShopId());
        Map<Long, m> r2 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r3 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r17.getLifecycleMonitorId()));
        if (r3 == null) goto L5;
        r3.b();
    L5:
        ECShopABSettings r4 = ECShopABSettings.k;
        r4.getClass();
        if (ECShopABSettings.f() == false) goto L8;
        ECStoreApi.a.getClass();
        ECStoreApi r5 = ECStoreApi.a.c;
    L9:
        if (r5 == null) goto L25;
        String r6 = r17.getSecShopId();
        int r7 = r17.getFlagSupportNestedTab();
        ECStoreTabRenderConfig.Companion.getClass();
        Map<String, String> r8 = c(ECStoreTabRenderConfig.a.a(r17));
        if (r8 != null) goto L13;
        r8 = new LinkedHashMap();
    L13:
        ECStoreTabSourceConfig.Companion.getClass();
        Map<String, String> r9 = c(ECStoreTabSourceConfig.a.a(r17));
        if (r9 != null) goto L16;
        r9 = new LinkedHashMap();
    L16:
        JSONObject r10 = k.c((String) r17.getPassThroughParam("pass_through_api"));
        if (r10 == null) goto L19;
        r10.put("is_first_enter", 1);
        Unit r11 = Unit.INSTANCE;
    L20:
        Observable<com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit>> r12 = r5.getHomeTabBFFByPostChunk(r19, r6, r7, r8, r9, String.valueOf(r10), r17.getSearchParams(), 1, r17.getShuffleProductIds(), r18, k.d(com.bytedance.android.shopping.store.settings.b.a(r4, r17)), ECStoreSettings.h(), r17.getClientParams(), r17.getLocalVersionWithoutContent());
        if (r12 == null) goto L25;
        Observable r0 = r12.doOnNext(new h(r17));
        if (r0 == null) goto L25;
        return r0;
    L19:
        r10 = null;
    L25:
        return Observable.error(new Throwable());
    L8:
        ECStoreApi.a.getClass();
        r5 = ECStoreApi.a.b;
        goto L9
    }

    @Override // ti3.d
    public final Observable<ECShopHeadInfoBlock> a(ECStoreParam r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "storeParam");
        Intrinsics.checkNotNullParameter(r11, "path");
        Lazy r1 = ECStoreDataManager.c;
        ECStoreDataManager r2 = ECStoreDataManager.a.a();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "storeParam");
        ECStoreTabKitAPIDataCacheManager r3 = r2.a();
        int r4 = ShopHelper.a;
        String r5 = ShopHelper.d(r9);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "uniqueId");
        Intrinsics.checkNotNullParameter(r9, "storeParam");
        Triple<ECShopHeadInfoBlock, Long, fl.b> r0 = r3.b.get(r5);
        Observable r6 = null;
        if (r0 != null) goto L5;
    L8:
        Observable r7 = null;
    L9:
        if (r7 == null) goto L11;
        r6 = r7;
    L14:
        if (r6 != null) goto L17;
        r6 = g(r9, r10, r11);
    L17:
        return r6.map(new C0171a(r9));
    L11:
        if (r2.b().a(r9) == false) goto L14;
        ECStoreDataFutureManager r8 = r2.b();
        Observable r12 = Observable.fromFuture(r8.c);
        r8.c = null;
        r6 = r12;
        goto L14
    L5:
        if (ECStoreTabKitAPIDataCacheManager.a(((Number) r0.getSecond()).longValue(), (fl.b) r0.getThird()) == true) goto L7;
        r9.setInfoAIPreloadType(AIPreloadType.AI_PRELOAD_SUCCESS);
        r7 = Observable.just(r0.getFirst());
        goto L9
    L7:
        r9.setInfoAIPreloadType(AIPreloadType.AI_PRELOAD_EXPIRED);
        r3.b.remove(r5);
        goto L8
    }

    public final Observable<ECStoreHomeTabResponseTabkit> d(ECStoreParam r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "storeParam");
        Intrinsics.checkNotNullParameter(r13, "path");
        Lazy r1 = ECStoreDataManager.c;
        ECStoreDataManager r2 = ECStoreDataManager.a.a();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r11, "storeParam");
        ECStoreTabKitAPIDataCacheManager r3 = r2.a();
        int r4 = ShopHelper.a;
        String r5 = ShopHelper.d(r11);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "uniqueId");
        Intrinsics.checkNotNullParameter(r11, "storeParam");
        Triple<ECStoreHomeTabResponseTabkit[], Long, fl.b> r6 = r3.c.get(r5);
        boolean r7 = false;
        Observable<ECStoreHomeTabResponseTabkit> r8 = null;
        if (r6 == null) goto L8;
        ((fl.b) r6.getThird()).getClass();
        r11.setApiPreloadType(null);
        if (ECStoreTabKitAPIDataCacheManager.a(((Number) r6.getSecond()).longValue(), (fl.b) r6.getThird()) == true) goto L7;
        r11.setTabAIPreloadType(AIPreloadType.AI_PRELOAD_SUCCESS);
        Observable<ECStoreHomeTabResponseTabkit> r9 = Observable.just(((ECStoreHomeTabResponseTabkit[]) r6.getFirst())[0]);
    L9:
        if (r9 != null) goto L23;
        ECStoreDataFutureManager r10 = r2.b();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "storeParam");
        String r0 = r11.getSecShopId();
        ECStoreParam r14 = r10.b;
        if (r14 == null) goto L13;
        String r15 = r14.getSecShopId();
    L15:
        if (Intrinsics.areEqual(r0, r15) == false) goto L21;
        io.reactivex.internal.observers.h<ECStoreHomeTabResponseTabkit> r16 = r10.e;
        if (r16 == null) goto L21;
        if (r16.isCancelled() == true) goto L21;
        r7 = true;
    L21:
        if (r7 == false) goto L24;
        ECStoreDataFutureManager r17 = r2.b();
        Observable<ECStoreHomeTabResponseTabkit> r18 = Observable.fromFuture(r17.e);
        r17.e = null;
        r8 = r18;
    L24:
        if (r8 == null) goto L26;
        return r8;
    L26:
        return h(r11, r12, r13);
    L13:
        r15 = null;
        goto L15
    L23:
        r8 = r9;
        goto L24
    L7:
        r11.setTabAIPreloadType(AIPreloadType.AI_PRELOAD_EXPIRED);
        r3.c.remove(r5);
    L8:
        r9 = null;
        goto L9
    }

    public final Observable<com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit>> e(ECStoreParam r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        Intrinsics.checkNotNullParameter(r12, "path");
        Lazy r1 = ECStoreDataManager.c;
        ECStoreDataManager r2 = ECStoreDataManager.a.a();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        ECStoreTabKitAPIDataCacheManager r3 = r2.a();
        int r4 = ShopHelper.a;
        String r5 = ShopHelper.d(r10);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "uniqueId");
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        Triple<ECStoreHomeTabResponseTabkit[], Long, fl.b> r6 = r3.c.get(r5);
        Observable<com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit>> r7 = null;
        if (r6 == null) goto L8;
        ((fl.b) r6.getThird()).getClass();
        r10.setApiPreloadType(null);
        if (ECStoreTabKitAPIDataCacheManager.a(((Number) r6.getSecond()).longValue(), (fl.b) r6.getThird()) == true) goto L7;
        r10.setTabAIPreloadType(AIPreloadType.AI_PRELOAD_SUCCESS);
        Observable<com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit>> r8 = Observable.just(new com.bytedance.android.chunkstreamprediction.network.b(new com.bytedance.android.shopping.store.home.preload.data.a(r6)));
    L9:
        if (r8 != null) goto L24;
        ECStoreDataFutureManager r9 = r2.b();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        String r0 = r10.getSecShopId();
        ECStoreParam r13 = r9.b;
        if (r13 == null) goto L13;
        String r14 = r13.getSecShopId();
    L15:
        if (Intrinsics.areEqual(r0, r14) == false) goto L21;
        io.reactivex.internal.observers.h<com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit>> r15 = r9.f;
        if (r15 == null) goto L21;
        if (r15.isCancelled() == true) goto L21;
        boolean r16 = true;
    L22:
        if (r16 == false) goto L25;
        ECStoreDataFutureManager r17 = r2.b();
        Observable<com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit>> r18 = Observable.fromFuture(r17.f);
        r17.f = null;
        r7 = r18;
    L25:
        if (r7 == null) goto L27;
        return r7;
    L27:
        return i(r10, r11, r12);
    L21:
        r16 = false;
        goto L22
    L13:
        r14 = null;
        goto L15
    L24:
        r7 = r8;
        goto L25
    L7:
        r10.setTabAIPreloadType(AIPreloadType.AI_PRELOAD_EXPIRED);
        r3.c.remove(r5);
    L8:
        r8 = null;
        goto L9
    }
}
