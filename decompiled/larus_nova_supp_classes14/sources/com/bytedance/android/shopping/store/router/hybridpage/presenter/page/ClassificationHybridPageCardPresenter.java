package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopProductListBffResponseDTO;
import com.bytedance.android.shopping.store.router.hybridpage.event.PageCardEventManager;
import com.bytedance.android.shopping.store.router.hybridpage.event.SliceEventManager;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/presenter/page/ClassificationHybridPageCardPresenter;", "Lcom/bytedance/android/shopping/store/router/hybridpage/presenter/page/HybridPageCardPresenter;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClassificationHybridPageCardPresenter extends HybridPageCardPresenter {

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ClassificationHybridPageCardPresenter a;

        public b(ClassificationHybridPageCardPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            ECShopProductListBffResponseDTO r6 = (ECShopProductListBffResponseDTO) r5;
            dm.a.b r0 = dm.a.a("ClassificationHybridPageCardPresenter");
            StringBuilder r1 = new StringBuilder("product/bff success, hasMore=");
            r1.append(r6.getHasMore());
            r1.append(", sections=");
            ECHybridListDTO r2 = r6.getHybridList();
            if (r2 == null) goto L7;
            List r3 = r2.getSections();
            if (r3 == null) goto L7;
            Integer r4 = Integer.valueOf(r3.size());
        L8:
            r1.append(r4);
            r0.i(r1.toString());
            ClassificationHybridPageCardPresenter r7 = this.a;
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L14
            Gson r9 = r7.h;     // Catch: Throwable -> L14
            Object r10 = r9.fromJson(r9.toJson(r6), Map.class);     // Catch: Throwable -> L14
            if ((r10 instanceof Map) == true) goto L12;
            r10 = null;
        L12:
            Object r11 = Result.constructor-impl((Map) r10);     // Catch: Throwable -> L14
        L17:
            if (Result.isFailure-impl(r11) == false) goto L19;
            r11 = null;
        L19:
            Map r12 = (Map) r11;
            if (r12 != null) goto L22;
            r12 = MapsKt.emptyMap();
        L22:
            ReentrantReadWriteLock r13 = PageCardEventManager.a;
            PageCardEventManager.b(this.a.j0().getSceneId(), r12, null);
            return;
        L14:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
        L7:
            r4 = null;
            goto L8
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ClassificationHybridPageCardPresenter a;

        public c(ClassificationHybridPageCardPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            dm.a.a("ClassificationHybridPageCardPresenter").b("product/bff failed, msg=" + r5.getMessage(), null);
            ReentrantReadWriteLock r0 = PageCardEventManager.a;
            PageCardEventManager.b(this.a.j0().getSceneId(), null, r5.getMessage());
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.presenter.page.HybridPageCardPresenter
    public final Map<String, Object> h0() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("ec_shop_classification_second_refactor", Integer.valueOf(((Number) HybridPageConfigSetting.e.getValue()).intValue()));
        return r0;
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.presenter.page.HybridPageCardPresenter
    public final String i0() {
        return ShopSliceUniqueId.CLASSIFICATION_SECOND_PAGE.getId();
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.presenter.page.HybridPageCardPresenter
    public final void k0() {
        Map<String, Object> r0 = j0().getRouterQuery();
        LinkedHashMap r2 = null;
        if (r0 == null) goto L5;
        Object r3 = r0.get("sec_shop_id");
    L7:
        if ((r3 instanceof String) == true) goto L9;
        r3 = null;
    L9:
        String r4 = (String) r3;
        boolean r5 = true;
        if (r4 != null) goto L12;
    L15:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L20;
        dm.a.a("ClassificationHybridPageCardPresenter").w("onConfigJsonReady abort, sec_shop_id missing", null);
        return;
    L20:
        Object r8 = r0.get("material_title");
        if ((r8 instanceof String) == true) goto L23;
        r8 = null;
    L23:
        String r9 = (String) r8;
        if (r9 != null) goto L26;
    L29:
        boolean r10 = true;
    L30:
        if (r10 == true) goto L33;
        ReentrantReadWriteLock r11 = SliceEventManager.a;
        SliceEventManager.b(j0().getSceneId(), MapsKt.mapOf(TuplesKt.to("data_source", MapsKt.mapOf(TuplesKt.to("material_title", r9)))));
    L33:
        Object r7 = r0.get("pass_through_api");
        if ((r7 instanceof String) == true) goto L36;
        r7 = null;
    L36:
        String r12 = (String) r7;
        JSONObject r13 = new JSONObject();
        r13.put("order", 0);
        r13.put("sort_type", 0);
        String r14 = r13.toString();
        JSONObject r15 = new JSONObject();
        r15.put("size", 10);
        r15.put("cursor", 0);
        Object r1 = r0.get("page_params");
        if ((r1 instanceof String) == true) goto L39;
        r1 = null;
    L39:
        String r16 = (String) r1;
        if (r16 != null) goto L42;
    L50:
        String r17 = r15.toString();
        LinkedHashMap r18 = new LinkedHashMap();
        JSONObject r19 = (JSONObject) j0().getConfigJson().getValue();
        if (r19 == null) goto L69;
        JSONObject r110 = r19.optJSONObject("api_config");
        if (r110 == null) goto L69;
        JSONObject r111 = r110.optJSONObject("apis");
        if (r111 == null) goto L69;
        JSONObject r112 = r111.optJSONObject("search");
        if (r112 == null) goto L69;
        JSONObject r113 = r112.optJSONObject("params");
        if (r113 == null) goto L69;
        r2 = new LinkedHashMap();
        Iterator<String> r114 = r113.keys();
    L67:
        if (r114.hasNext() == false) goto L69;
        String r115 = r114.next();
        r2.put(r115, r113.opt(r115));
    L69:
        if (r2 == null) goto L76;
        Iterator r20 = r2.entrySet().iterator();
    L72:
        if (r20.hasNext() == false) goto L76;
        Map.Entry r116 = (Map.Entry) r20.next();
        String r117 = (String) r116.getKey();
        Object r118 = r116.getValue();
        if (r118 == null) goto L72;
        r18.put(r117, r118.toString());
    L76:
        r18.put("sec_shop_id", r4);
        r18.put("filter_params", r14);
        r18.put("pagination_params", r17);
        r18.put("request_tab_type", String.valueOf(400));
        if (r12 == null) goto L79;
        r18.put("passthrough_api", r12);
    L79:
        CharSequence r21 = (CharSequence) r18.get("custom_ids");
        if (r21 != null) goto L82;
    L85:
        boolean r22 = true;
    L86:
        if (r22 == false) goto L88;
        r18.remove("custom_ids");
    L88:
        CharSequence r23 = (CharSequence) r18.get("custom_id_type");
        if (r23 != null) goto L91;
    L94:
        if (r5 == false) goto L96;
        r18.remove("custom_id_type");
    L96:
        dm.a.a("ClassificationHybridPageCardPresenter").i("onConfigJsonReady, request /aweme/v1/store/product/bff/, fields=" + r18.keySet());
        ECStoreApi.a.getClass();
        ECStoreApi r24 = ECStoreApi.a.b;
        if (r24 == null) goto L100;
        Observable<ECShopProductListBffResponseDTO> r25 = r24.getProductListBFFByFieldMap(r18);
        if (r25 == null) goto L100;
    L101:
        r25.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
        return;
    L100:
        r25 = Observable.error(new Throwable("network service not found"));
        goto L101
    L91:
        if (r23.length() == 0) goto L94;
        r5 = false;
        goto L94
    L82:
        if (r21.length() == 0) goto L85;
        r22 = false;
        goto L86
    L42:
        if (r16.length() <= 0) goto L44;
        boolean r119 = true;
    L45:
        if (r119 == true) goto L48;
        r16 = null;
    L48:
        if (r16 == null) goto L50;
        JSONObject r120 = new JSONObject();
        r120.put("page_params", r16);
        Unit r26 = Unit.INSTANCE;
        r15.put("biz_extra", r120);
        goto L50
    L44:
        r119 = false;
        goto L45
    L26:
        if (r9.length() == 0) goto L29;
        r10 = false;
        goto L30
    L12:
        if (r4.length() == 0) goto L15;
        r6 = false;
        goto L17
    L5:
        r3 = null;
        goto L7
    }

    public ClassificationHybridPageCardPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }
}
