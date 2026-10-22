package com.bytedance.android.shopping.sku.outer.business.cart.core;

import android.text.TextUtils;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAddCartChain;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAptChain;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import com.bytedance.android.shopping.sku.outer.business.cart.repo.SkuOuterAddToCartResponse;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ SkuOuterAddToCartHelper a;
    public final /* synthetic */ String b;
    public final /* synthetic */ th3.b c;

    public h(SkuOuterAddToCartHelper r1, String r2, th3.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r30) {
        SkuOuterAddToCartResponse r1 = (SkuOuterAddToCartResponse) r30;
        String r7 = "";
        if (r1.getStatusCode() != 0) goto L67;
        LinkedHashMap r2 = new LinkedHashMap();
        Map<String, Object> r8 = this.a.c.g();
        if (r8 == null) goto L7;
        r2.putAll(r8);
    L7:
        r2.put("add_cart_opt_live", this.a.c.d.getAddCartOptLive());
        Function0<Unit> r9 = this.a.g;
        if (r9 == null) goto L10;
        Unit r10 = (Unit) r9.invoke();
    L10:
        EventBus r15 = EventBus.getDefault();
        int r11 = r1.getCount();
        String r12 = this.a.c.a.j();
        Integer r13 = Integer.valueOf(this.a.c.e());
        String r14 = this.a.c.c();
        if (r14 != null) goto L13;
        String r16 = "";
    L14:
        List<CartNumWithBusinessLine> r17 = r1.getCartNumWithBusinessLine();
        String r18 = this.a.c.a();
        String r19 = this.a.c.a.c();
        this.a.c.d.isSchemaOpen();
        Integer r21 = Integer.valueOf(this.a.c.c);
        String r22 = r1.getAddCartNextSchema();
        String r25 = r1.getCartId();
        Map<String, Object> r20 = r1.getToastBar();
        if (r20 == null) goto L17;
        JSONObject r28 = z1.a(r20);
    L18:
        r15.post(new hl.b(r11, r12, r13, r16, r17, r18, r19, null, r2, null, null, r21, r22, null, false, r25, r28, null, 628352));
        EventBus.getDefault().post(new hl.d(r1.getCount()));
        EventBus.getDefault().post(new hl.g(r1.getCount(), true));
        EventBus.getDefault().post(new hl.h(r1.getCount(), this.a.c.a.j(), this.a.c.d()));
        SkuOuterAddToCartHelper r3 = this.a;
        SkuOuterAddToCartHelper.a(r3, this.b, r3.c.c(), r1.getCartId(), Integer.valueOf(this.a.c.e()));
        Function1<SkuCartResult, Unit> r4 = this.a.e;
        if (r4 == null) goto L21;
        Unit r5 = (Unit) r4.invoke(new SkuCartResult("", "", r1.getCount(), 0, null, this.a.c.a.d(), this.a.c.a.e(), this.a.c.g(), 24, null));
    L21:
        SkuOuterAddToCartHelper r6 = this.a;
        if (r6.c.d.isFromVideoFeed() == false) goto L26;
        if (r6.c.d.getAddToastType() != 0) goto L26;
    L27:
        boolean r23 = true;
    L30:
        if (r23 == true) goto L32;
        int r24 = this.a.c.d.getAddToastType();
        if (r24 == 0) goto L45;
        if (r24 != 1) goto L46;
        SkuCommonToast.c("添加成功，上滑后可查看购物车");
    L46:
        Map<String, Object> r26 = this.a.c.g();
        if (r26 != null) goto L49;
    L98:
        this.a.f.c(r1, null);
        if (r1.getStatusCode() == 0) goto L109;
        mh3.a r27 = this.a.a;
        if (r27 == null) goto L109;
        com.bytedance.android.shopping.sku.common.monitor.error.a r29 = r27.c;
        if (r29 == null) goto L109;
        SkuErrorMonitorType r31 = SkuErrorMonitorType.ADD_CART_API_ERROR;
        String r32 = "code:" + r1.getStatusCode() + "   msg:" + r1.getStatusMsg();
        JSONObject r33 = new JSONObject();
        r33.put("error_code", String.valueOf(r1.getStatusCode()));
        String r34 = r1.getStatusMsg();
        if (r34 == null) goto L108;
        r7 = r34;
    L108:
        r33.put("error_msg", r7);
        r33.put("is_new_api", 0);
        r33.put("log_id", r1.getLogId());
        Unit r35 = Unit.INSTANCE;
        r29.a(r31, r32, r33);
    L109:
        mh3.a r36 = this.a.a;
        if (r36 != null) goto L112;
    L114:
        mh3.a r37 = this.a.a;
        if (r37 == null) goto L120;
        SkuYataAptChain r38 = r37.f;
        if (r38 == null) goto L121;
        r38.c(this.c, r1);
        return;
    L121:
        return;
    L120:
        return;
    L112:
        if (r36.e == null) goto L114;
        SkuYataAddCartChain.c(r1, null);
        goto L114
    L49:
        if ((!r26.isEmpty()) != true) goto L98;
        Map<String, Object> r39 = this.a.c.g();
        if (r39 == null) goto L53;
        Object r40 = r39.get("buy_to_add");
    L55:
        if ((r40 instanceof Map) == true) goto L57;
        r40 = null;
    L57:
        Map r41 = (Map) r40;
        if (r41 == null) goto L98;
        if ((!r41.isEmpty()) != true) goto L98;
        Object r42 = r41.get("success_toast");
        if ((r42 instanceof String) == true) goto L64;
        r42 = null;
    L64:
        String r43 = (String) r42;
        if (TextUtils.isEmpty(r43) == true) goto L98;
        SkuCommonToast.c(r43);
        goto L98
    L53:
        r40 = null;
        goto L55
    L45:
        SkuCommonToast.c("添加成功，在购物车等你");
        goto L46
    L32:
        if (this.a.c.e() != 302) goto L46;
        SkuCommonToast.c("添加成功，在购物车等你");
        int r44 = ECSdk.a;
        IEShoppingService r45 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r45 == null) goto L37;
        n83.h r46 = r45.getECMallService();
    L38:
        if (r46 == null) goto L46;
        r46.a();
        goto L46
    L37:
        r46 = null;
    L26:
        if (r6.c.d.isFromMallFeed() == true) goto L27;
        r23 = false;
        goto L30
    L17:
        r28 = null;
        goto L18
    L13:
        r16 = r14;
        goto L14
    L67:
        String r47 = r1.getStatusMsg();
        if (r47 != null) goto L70;
    L73:
        boolean r48 = true;
    L74:
        if (r48 == false) goto L76;
        SkuCommonToast.c("添加失败，请稍后重试");
    L77:
        Map<String, Object> r49 = this.a.c.g();
        if (r49 == null) goto L98;
        if ((!r49.isEmpty()) != true) goto L98;
        Map<String, Object> r50 = this.a.c.g();
        if (r50 == null) goto L84;
        Object r51 = r50.get("buy_to_add");
    L86:
        if ((r51 instanceof Map) == true) goto L88;
        r51 = null;
    L88:
        Map r52 = (Map) r51;
        if (r52 == null) goto L98;
        if ((!r52.isEmpty()) != true) goto L98;
        Object r53 = r52.get("fail_toast");
        if ((r53 instanceof String) == true) goto L95;
        r53 = null;
    L95:
        String r54 = (String) r53;
        if (TextUtils.isEmpty(r54) == true) goto L98;
        SkuCommonToast.c(r54);
        goto L98
    L84:
        r51 = null;
        goto L86
    L76:
        int r55 = SkuCommonToast.a;
        SkuCommonToast.c(r1.getStatusMsg());
        goto L77
    L70:
        if (StringsKt.isBlank(r47) == true) goto L73;
        r48 = false;
        goto L74
    }
}
