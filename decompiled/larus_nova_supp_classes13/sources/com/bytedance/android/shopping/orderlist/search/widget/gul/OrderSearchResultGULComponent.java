package com.bytedance.android.shopping.orderlist.search.widget.gul;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.search.container.OrderSearchResultActivity;
import com.bytedance.android.shopping.orderlist.search.starter.OrderSearchResultParams;
import com.bytedance.android.shopping.orderlist.search.viewmodel.OrderSearchResultViewModel;
import com.bytedance.android.shopping.orderlist.search.viewmodel.d;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderSearchResultGULComponent implements jg3.a {
    public l a;
    public Function0<Unit> b;
    public final Context c;
    public final ViewGroup d;

    public final OrderCommonBusinessMonitor c() {
        Object r0 = d0.a.getActivity(this.c);
        if ((r0 instanceof OrderSearchResultActivity) == true) goto L5;
        r0 = null;
    L5:
        OrderSearchResultActivity r1 = (OrderSearchResultActivity) r0;
        if (r1 == null) goto L11;
        ig3.a r2 = r1.B;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.c;
    L11:
        return null;
    }

    @Override // jg3.a
    public final void release() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultGULComponent", AnonymousClass1.INSTANCE);
        l r1 = this.a;
        if (r1 == null) goto L6;
        r1.release();
        return;
    }

    public final String b() {
        Map<String, String> r4 = null;
        if (StringsKt.contains$default(ECSettingKeys.F().getOrderSearchGULUrl(), "url=", false, 2, null) == false) goto L5;
        String r0 = ECSettingKeys.F().getOrderSearchGULUrl();
    L6:
        Uri.Builder r1 = UriProtector.parse(UriProtector.getQueryParameter(UriProtector.parse(r0), "url")).buildUpon();
        Object r3 = d0.a.getActivity(this.c);
        if ((r3 instanceof OrderSearchResultActivity) == true) goto L9;
        r3 = null;
    L9:
        OrderSearchResultActivity r5 = (OrderSearchResultActivity) r3;
        if (r5 == null) goto L18;
        OrderSearchResultViewModel r6 = r5.I1();
        if (r6 == null) goto L18;
        d r7 = r6.getStaticState();
        if (r7 == null) goto L18;
        OrderSearchResultParams r8 = r7.g;
        if (r8 == null) goto L18;
        r4 = r8.getSchemaParamsMap();
    L18:
        List r9 = CollectionsKt.listOf("technology");
        if (r4 == null) goto L30;
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r11 = r4.entrySet().iterator();
    L22:
        if (r11.hasNext() == false) goto L26;
        Map.Entry<String, String> r12 = r11.next();
        if ((!r9.contains(r12.getKey())) == false) goto L22;
        r10.put(r12.getKey(), r12.getValue());
        goto L22
    L26:
        Iterator r13 = r10.entrySet().iterator();
    L28:
        if (r13.hasNext() == false) goto L30;
        Map.Entry r14 = (Map.Entry) r13.next();
        r1.appendQueryParameter((String) r14.getKey(), (String) r14.getValue());
    L30:
        final String r2 = l0.c(UriProtector.parse(r0), "url", r1.build().toString()).buildUpon().build().toString();
        Lazy r15 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultGULComponent", new OrderSearchResultGULComponent$buildUrl$1(r2));
        return r2;
    L5:
        r0 = "sslocal://webcast_webview?type=fullscreen&url=https%3A%2F%2Fffh.jinritemai.com%2Fforest%2Frender%2Ffe%2Ftemplate%2Fchannel%2Fecommerce_orders_yata%2Fhtml%2Fsearch_gyl.html%3F__pia_manifest__%3D%257B%2522page_name%2522%253A%2522search_gyl%2522%252C%2522public_path%2522%253A%2522https%253A%252F%252Flf-webcast-sourcecdn-tos.bytegecko.com%252Fobj%252Fbyte-gurd-source%252F10181%252Fgecko%252Fresource%252Fecommerce_orders_yata%252F%2522%257D&disable_host_jsb_method=1&disable_thread_spread=1&warmup_pia_worker=1&loader_name=forest&hide_nav_bar=1&status_bar_color=black&trans_status_bar=1&web_bg_color=%23FFFFFF&disable_input_scroll=1&use_pia=1&use_wk_falcon=1";
        goto L6
    }

    @Override // jg3.a
    public final void a(Function0<Unit> r19) {
        OrderCommonBusinessMonitor r1 = c();
        l r2 = null;
        if (r1 == null) goto L5;
        r1.c = System.currentTimeMillis();
        r1.c("load_gul_start", null);
    L5:
        this.b = r19;
        if (this.a != null) goto L11;
        final long r4 = System.currentTimeMillis();
        ViewGroup r9 = this.d;
        Context r6 = this.c;
        ECLiveHybridUtil.HybridType r11 = ECLiveHybridUtil.HybridType.WEB;
        String r7 = b();
        JSONObject r3 = new JSONObject();
        r3.put("module_param", new JSONObject());
        r3.put("mob_data", new JSONObject());
        Unit r8 = Unit.INSTANCE;
        l r5 = ECLiveHybridUtil.b(r6, r7, com.bytedance.android.shopping.hybrid.a.b(r3), r9, new b(this), r11, null, false, null, null, false, 4032);
        if (r5 == null) goto L10;
        r5.registerMethod("x.publishEvent", new a(this));
        r2 = r5;
    L10:
        this.a = r2;
        Lazy r10 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultGULComponent", new OrderSearchResultGULComponent$initOrReload$1(r4));
        return;
    L11:
        final long r12 = System.currentTimeMillis();
        l r13 = this.a;
        if (r13 == null) goto L14;
        r13.loadUrl(b());
    L14:
        Lazy r14 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultGULComponent", new OrderSearchResultGULComponent$initOrReload$2(r12));
    }

    public OrderSearchResultGULComponent(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "container");
        this.c = r2;
        this.d = r3;
    }
}
