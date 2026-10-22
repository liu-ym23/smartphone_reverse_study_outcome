package com.bytedance.android.shopping.new_cart.repo;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.router.NewCartStarter;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.keva.Keva;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import wf3.b;
import wf3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J,\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0007J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u0001J\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\r2\u0006\u0010\f\u001a\u00020\u0010J\u0016\u0010\u0012\u001a\u0004\u0018\u00010\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J*\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u001d\u001a\u00020\u001c2\b\u0010\t\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u001e\u001a\u00020\u0003R\u0014\u0010\u001f\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/repo/CartRepository;", "", "Lcom/bytedance/retrofit2/SsResponse;", "", "response", "", "extra", "", "reportForNetworkErr", "sourceType", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "parseResponse", "req", "Lio/reactivex/Observable;", "Lwf3/b;", "queryForCoupon", "Lwf3/c;", "firstQuery", "transformToDTO", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "objectContainer", "queryScene", "", "versionCode", "query", "responseBody", "source", "setResponse", "", "isResponseValid", "getCacheSourceType", "LOG_ID_EVENT_NAME", "Ljava/lang/String;", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "cartKeva", "Lcom/bytedance/keva/Keva;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartRepository {
    public static final CartRepository INSTANCE = null;
    private static final String LOG_ID_EVENT_NAME = "cart_net_error_logid";
    private static final Keva cartKeva = null;

    public static final class a implements Runnable {
        public final /* synthetic */ SsResponse a;
        public final /* synthetic */ Map b;

        public a(SsResponse r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Iterator r0 = this.a.headers().iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((Header) r1).getName(), "x-tt-logid") == false) goto L4;
        L9:
            Header r2 = (Header) r1;
            if (r2 == null) goto L16;
            Map<String, ? extends Object> r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("x_tt_logid", r2.getValue())});
            r3.putAll(this.b);
            r3.put("error_body", this.a.errorBody().toString());
            r3.put("net_status", Integer.valueOf(this.a.code()));
            r3.put("content_length", Integer.valueOf(((String) this.a.body()).length()));
            bg3.a r4 = com.bytedance.android.shopping.new_cart.utils.a.a;
            Intrinsics.checkNotNullParameter(CartRepository.LOG_ID_EVENT_NAME, "name");
            Intrinsics.checkNotNullParameter(r3, "params");
            com.bytedance.android.shopping.new_cart.utils.a.a.a(CartRepository.LOG_ID_EVENT_NAME, r3, null, null);
            return;
        L16:
            return;
        L8:
            r1 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.repo.CartRepository$setResponse$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.shopping.new_cart.repo.CartRepository$setResponse$1", f = "CartRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $responseBody;
        final /* synthetic */ String $source;
        int label;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.repo.CartRepository$setResponse$1$a */
        public static final class a implements Runnable {
            public final /* synthetic */ C02811 a;

            public a(C02811 r1) {
                this.a = r1;
            }

            public final void a() {
                JSONObject r0 = z1.g(this.a.$responseBody);
                if (r0 == null) goto L9;
                JSONObject r1 = r0.optJSONObject("yata_data");
                if (r1 == null) goto L9;
                JSONObject r2 = r1.optJSONObject("global");
                if (r2 == null) goto L9;
                KtSafeMethodExtensionKt.safePut(r2, "load_from_cache", "1");
            L9:
                CartRepository r3 = CartRepository.INSTANCE;
                CartRepository.access$getCartKeva$p(r3).storeStringJustDisk("cart_query_response", String.valueOf(r0));
                CartRepository.access$getCartKeva$p(r3).storeLong("cart_query_response_timestamp", System.currentTimeMillis());
                CartRepository.access$getCartKeva$p(r3).storeString("cart_uid", r.a.getCurrentUserId());
                String r4 = this.a.$source;
                if (r4 == null) goto L12;
                CartRepository.access$getCartKeva$p(r3).storeString("cart_cache_source", r4);
            L12:
                bg3.a r5 = com.bytedance.android.shopping.new_cart.utils.a.a;
                String r6 = this.a.$source;
                if (r6 != null) goto L15;
                r6 = "";
            L15:
                com.bytedance.android.shopping.new_cart.utils.a.b("success", r6);
                e r7 = NewCartStarter.t;     // Catch: Exception -> L18
                NewCartStarter.t = (e) u0.b(String.valueOf(r0), e.class);     // Catch: Exception -> L18
                return;
            L18:
                e = move-exception;
                bg3.a r8 = com.bytedance.android.shopping.new_cart.utils.a.a;
                StringBuilder r9 = new StringBuilder();
                r9.append(e.getMessage());
                r9.append('-');
                Throwable r10 = e.getCause();
                if (r10 == null) goto L22;
                String r11 = r10.getMessage();
            L23:
                r9.append(r11);
                com.bytedance.android.shopping.new_cart.utils.a.j("cacheResponse transformToDTO", r9.toString(), null, 12);
                ECExceptionMonitor.e(e);
                return;
            L22:
                r11 = null;
                goto L23
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public C02811(String r1, String r2, Continuation r3) {
            this.$responseBody = r1;
            this.$source = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new C02811(this.$responseBody, this.$source, r4);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            com.bytedance.android.shopping.new_cart.utils.a.c.d("storage cache response", new a(this));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private CartRepository() {
    }

    static {
        INSTANCE = new CartRepository();
        cartKeva = Keva.getRepo("ecom_cart_storage", 1);
    }

    public final String getCacheSourceType() {
        return cartKeva.getString("cart_cache_source", "");
    }

    public static final /* synthetic */ Keva access$getCartKeva$p(CartRepository r0) {
        return cartKeva;
    }

    @JvmStatic
    public static final e parseResponse(String r9) {
        if (INSTANCE.isResponseValid(r9) == true) goto L5;
    L45:
        return null;
    L5:
        if (NewCartStarter.t != null) goto L45;
        Lazy r2 = CartCommonLog.a;
        CartCommonLog.a("NewCartStarter", AnonymousClass1.INSTANCE);
        Keva r3 = cartKeva;
        String r4 = r3.getStringJustDisk("cart_query_response", "");
        boolean r6 = false;
    L27:
        th = move-exception;
        ECExceptionMonitor.e(th);     // Catch: Throwable -> L38
        bg3.a r5 = com.bytedance.android.shopping.new_cart.utils.a.a;     // Catch: Throwable -> L38
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L38
        r7.append(th.getMessage());     // Catch: Throwable -> L38
        r7.append('-');     // Catch: Throwable -> L38
        Throwable r8 = th.getCause();     // Catch: Throwable -> L38
        if (r8 == null) goto L31;
        String r10 = r8.getMessage();     // Catch: Throwable -> L38
    L32:
        r7.append(r10);     // Catch: Throwable -> L38
        com.bytedance.android.shopping.new_cart.utils.a.j("transformToDTO", r7.toString(), null, 12);     // Catch: Throwable -> L38
        if (r6 == false) goto L37;
        if (r9 != null) goto L36;
        r9 = "";
    L36:
        com.bytedance.android.shopping.new_cart.utils.a.a("parse response to DownLinkDataResponse error", r9, cartKeva.getString("cart_cache_source", ""));
    L37:
        return null;
    L31:
        r10 = null;
    L38:
        th = move-exception;
        if (r6 == false) goto L44;
        bg3.a r11 = com.bytedance.android.shopping.new_cart.utils.a.a;
        if (r9 != null) goto L43;
        r9 = "";
    L43:
        com.bytedance.android.shopping.new_cart.utils.a.a("parse response to DownLinkDataResponse error", r9, cartKeva.getString("cart_cache_source", ""));
    L44:
        throw th;
    L9:
        if (r4.length() != 0) goto L11;
        r6 = true;
    L11:
        e r12 = (e) u0.b(r4, e.class);     // Catch: Throwable -> L27
        if (r12 == null) goto L14;
        Integer r13 = r12.a();     // Catch: Throwable -> L27
    L15:
        if (r13 != null) goto L18;
    L19:
        r6 = true;
    L20:
        NewCartStarter.t = r12;     // Catch: Throwable -> L27
        if (r6 == false) goto L26;
        bg3.a r14 = com.bytedance.android.shopping.new_cart.utils.a.a;
        if (r9 != null) goto L25;
        r9 = "";
    L25:
        com.bytedance.android.shopping.new_cart.utils.a.a("parse response to DownLinkDataResponse error", r9, r3.getString("cart_cache_source", ""));
    L26:
        return r12;
    L18:
        if (r13.intValue() == 0) goto L20;
    L14:
        r13 = null;
        goto L15
    }

    public final Observable<SsResponse<String>> firstQuery(c r4) {
        Intrinsics.checkNotNullParameter(r4, "req");
        CartApi.a.getClass();
        return ((CartApi) n.a.create(OrderCommonApi.API_HOST, CartApi.class)).getQuery(0, 10485760, r4);
    }

    public final boolean isResponseValid(String r11) {
        long r0 = System.currentTimeMillis();
        Keva r2 = cartKeva;
        long r1 = r0 - r2.getLong("cart_query_response_timestamp", 0);
        long r3 = ((long) ECSettingKeys.p().c()) * 1000;
        if (1 <= r1) goto L5;
    L14:
        String r4 = "cache_duration_invalid";
    L16:
        if (r4.length() != 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
        return true;
    L21:
        r2.clear();
        bg3.a r6 = com.bytedance.android.shopping.new_cart.utils.a.a;
        if (r11 != null) goto L24;
        r11 = "";
    L24:
        com.bytedance.android.shopping.new_cart.utils.a.a(r4, r11, r2.getString("cart_cache_source", ""));
        return false;
    L18:
        r5 = false;
        goto L19
    L5:
        if (r3 < r1) goto L14;
        if (r2.contains("cart_query_response") == true) goto L11;
        r4 = "cache_response_empty";
        goto L16
    L11:
        if ((!Intrinsics.areEqual(r2.getString("cart_uid", ""), r.a.getCurrentUserId())) == false) goto L13;
        r4 = "cache_not_current_user";
        goto L16
    L13:
        r4 = "";
        goto L16
    }

    public final Observable<b> queryForCoupon(Object r4) {
        Intrinsics.checkNotNullParameter(r4, "req");
        CartApi.a.getClass();
        return ((CartApi) n.a.create(OrderCommonApi.API_HOST, CartApi.class)).getCouponSchema(r4);
    }

    public final e transformToDTO(SsResponse<String> r9) {
        Intrinsics.checkNotNullParameter(r9, "response");
        Integer r1 = null;
        boolean r2 = false;
        boolean r4 = true;
        if (r9.isSuccessful() == true) goto L6;
    L10:
        r2 = true;
    L11:
        e r3 = (e) u0.b((String) r9.body(), e.class);     // Catch: Throwable -> L28
        if (r3 != null) goto L47;
        Integer r5 = null;
    L17:
        if (r5 == null) goto L23;
        if (r5.intValue() != 0) goto L23;
        r4 = r2;
    L14:
        Throwable th = th;
    L51:
        bg3.a r6 = com.bytedance.android.shopping.new_cart.utils.a.a;     // Catch: Throwable -> L41
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L41
        r7.append(th.getMessage());     // Catch: Throwable -> L41
        r7.append('-');     // Catch: Throwable -> L41
        Throwable r8 = th.getCause();     // Catch: Throwable -> L41
        if (r8 == null) goto L33;
        String r10 = r8.getMessage();     // Catch: Throwable -> L41
    L34:
        r7.append(r10);     // Catch: Throwable -> L41
        com.bytedance.android.shopping.new_cart.utils.a.j("transformToDTO", r7.toString(), null, 12);     // Catch: Throwable -> L41
        if (r2 == false) goto L40;
        if (r3 == null) goto L38;
        Integer r11 = r3.a();
    L39:
        reportForNetworkErr(r9, MapsKt.mapOf(TuplesKt.to("biz_status_code", r11)));
        goto L40
    L38:
        r11 = null;
    L40:
        return null;
    L33:
        r10 = null;
    L41:
        th = move-exception;
        if (r2 == false) goto L46;
        if (r3 == null) goto L45;
        r1 = r3.a();
    L45:
        reportForNetworkErr(r9, MapsKt.mapOf(TuplesKt.to("biz_status_code", r1)));
    L46:
        throw th;
    L23:
        if (r4 == false) goto L27;
        if (r3 == null) goto L26;
        r1 = r3.a();
    L26:
        reportForNetworkErr(r9, MapsKt.mapOf(TuplesKt.to("biz_status_code", r1)));
    L27:
        return r3;
    L47:
        r5 = r3.a();     // Catch: Throwable -> L14
        goto L17
    L6:
        if (((CharSequence) r9.body()).length() != 0) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
    L8:
        r12 = false;
    L28:
        th = move-exception;
        th = th;
        r3 = null;
        goto L51
    }

    private final void reportForNetworkErr(SsResponse<String> r3, Map<String, ? extends Object> r4) {
        com.bytedance.android.shopping.new_cart.utils.a.c.d("reportForNetworkErr", new a(r3, r4));
    }

    public final void setResponse(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "responseBody");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C02811(r8, r9, null), 3, null);
    }

    public final Observable<SsResponse<String>> query(CartObjectContainer r18, String r19, long r20) {
        Intrinsics.checkNotNullParameter(r18, "objectContainer");
        Intrinsics.checkNotNullParameter(r19, "queryScene");
        CartApi.a.getClass();
        CartApi r2 = (CartApi) n.a.create(OrderCommonApi.API_HOST, CartApi.class);
        Integer r3 = Integer.valueOf(!Intrinsics.areEqual(r19, "first_enter") ? 1 : 0);
        LinkedHashMap r5 = new LinkedHashMap();
        CartParams r6 = r18.e.c;
        if (r6 == null) goto L7;
        Map<String, String> r7 = r6.getSchemaParamsOrCreate();
        if (r7 == null) goto L7;
        r5.putAll(r7);
    L7:
        Pair[] r8 = new Pair[13];
        com.bytedance.android.shopping.new_cart.container.b r9 = r18.e;
        Intrinsics.checkNotNullParameter(r9, "$this$formatSelectedCartIds");
        r8[0] = TuplesKt.to("selected_cart_ids", CollectionsKt.joinToString$default(r9.f, ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.shopping.new_cart.container.b r10 = r18.e;
        Intrinsics.checkNotNullParameter(r10, "$this$formatSelectedShopIds");
        r8[1] = TuplesKt.to("selected_shop_ids", CollectionsKt.joinToString$default(r10.g, ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.shopping.new_cart.container.b r4 = r18.e;
        Intrinsics.checkNotNullParameter(r4, "$this$formatUnSelectedCartIds");
        r8[2] = TuplesKt.to("unselected_cart_ids", CollectionsKt.joinToString$default(r4.h, ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.shopping.new_cart.container.b r11 = r18.e;
        Intrinsics.checkNotNullParameter(r11, "$this$formatUnSelectedShopIds");
        r8[3] = TuplesKt.to("unselected_shop_ids", CollectionsKt.joinToString$default(r11.i, ",", null, null, 0, null, null, 62, null));
        r8[4] = TuplesKt.to("source_type", "104");
        r8[5] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_cart_page");
        r8[6] = TuplesKt.to("page_type", "YATA_Android");
        r8[7] = TuplesKt.to("query_scene", r19);
        CartParams r1 = r18.e.c;
        if (r1 == null) goto L11;
        String r12 = r1.getAnchorCartId();
        if (r12 == null) goto L11;
    L12:
        r8[8] = TuplesKt.to("anchor_cart_id", r12);
        r8[9] = TuplesKt.to("uplink_version", Long.valueOf(r20));
        CartParams r13 = r18.e.c;
        Map r14 = null;
        if (r13 == null) goto L15;
        String r15 = r13.getTransparentParams();
    L16:
        r8[10] = TuplesKt.to("transparent_params", r15);
        r8[11] = TuplesKt.to("session_id", r18.e.m);
        CartParams r16 = r18.e.c;
        if (r16 == null) goto L19;
        String r17 = r16.getSplitActivityScene();
    L20:
        r8[12] = TuplesKt.to("is_in_split_mode", Boolean.valueOf(k.c(r17)));
        Map r21 = MapsKt.mutableMapOf(r8);
        Iterator r22 = ((LinkedHashMap) r18.e.b).entrySet().iterator();
    L22:
        if (r22.hasNext() == false) goto L26;
        Map.Entry r23 = (Map.Entry) r22.next();
        if (r23.getValue() == null) goto L22;
        r21.put(r23.getKey(), r23.getValue());
        goto L22
    L26:
        Unit r24 = Unit.INSTANCE;
        r5.putAll(r21);
        Map r25 = MapsKt.toMap(r5);
        String r26 = ((AndroidYaTaInstance) r18.e.d.invoke()).m();
        if (r26 != null) goto L29;
        String r110 = "";
    L30:
        PackYataSdkConfig r27 = com.bytedance.kmp.ec.yata.common.init.b.a;
        AndroidYaTaInstance r28 = (AndroidYaTaInstance) r18.e.d.invoke();
        r28.getClass();
        String r29 = ea6.b.a(ea6.b.b(r28, null), r28, null, null);
        if (r29 != null) goto L33;
        String r111 = "";
    L34:
        CartParams r0 = r18.e.c;
        if (r0 == null) goto L40;
        YataPageInfo r30 = r0.getPageInfo();
        if (r30 == null) goto L40;
        r14 = r30.addAndGetYataProtocolInfo();
    L40:
        return r2.getQuery(r3, 10485760, new c(r25, r110, r111, r14, "1.23.7"));
    L33:
        r111 = r29;
        goto L34
    L29:
        r110 = r26;
        goto L30
    L19:
        r17 = null;
        goto L20
    L15:
        r15 = null;
    L11:
        r12 = "";
        goto L12
    }
}
