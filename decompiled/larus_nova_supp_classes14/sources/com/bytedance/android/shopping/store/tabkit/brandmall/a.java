package com.bytedance.android.shopping.store.tabkit.brandmall;

import android.content.Context;
import android.net.Uri;
import bf.c;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.store.tabkit.events.RouterParamErrorEvent;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements c {
    public a() {
    }

    public final void a() {
    }

    public final String b() {
        return "brand_mall";
    }

    public final boolean c(Context r24, Uri r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r25, "uri");
        TabKitRouterParams r3 = new TabKitRouterParams();
        Set r4 = UriProtector.getQueryParameterNames(r25);
        if (r4 == null) goto L8;
        Iterator r0 = r4.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        String r5 = (String) r0.next();
        r3.getParamsMap().put(r5, UriProtector.getQueryParameter(r25, r5));
    L8:
        Uri.Builder r6 = new Uri.Builder();
        r6.scheme("sslocal");
        r6.encodedAuthority("ecom_tabkit");
        if (r4.contains("biz_tag") == true) goto L12;
        r6.appendQueryParameter("biz_tag", "ecom_brand_channel");
    L12:
        if (r4.contains("api_url") == true) goto L15;
        r6.appendQueryParameter("api_url", "https://ecom.snssdk.com/aweme/v2/commerce/brand/homepage");
    L15:
        if (r4.contains("api_params") == true) goto L63;
        Lazy r1 = ECSettingKeys.a;
        int r2 = p.a;
        Object r8 = "[\"page_modal\",\"enter_from\",\"previous_page\"]";
        boolean r9 = false;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L21
        jj4.b r11 = jj4.b.b;     // Catch: Throwable -> L21
        Object r7 = jj4.a.a("ec_brand_mall_router_params", String.class, "[\"page_modal\",\"enter_from\",\"previous_page\"]", false);     // Catch: Throwable -> L21
        if (r7 != null) goto L27;
        Intrinsics.throwNpe();     // Catch: Throwable -> L21
    L27:
        List r12 = StringsKt.split$default(StringsKt.replace$default(StringsKt.removeSurrounding((String) r7, "[", "]"), "\"", "", false, 4, null), new String[]{","}, false, 0, 6, null);
        HashMap<String, String> r13 = r3.getParamsMap();
        if (r13 == null) goto L30;
        JSONObject r14 = cd.a.c(r13);
    L31:
        if (r14 == null) goto L40;
        Iterator<String> r15 = r14.keys();
        LinkedList r16 = new LinkedList();
    L34:
        if (r15.hasNext() == false) goto L36;
        r16.add(r15.next());
        goto L34
    L36:
        r16.removeAll(r12);
        Iterator r17 = r16.iterator();
    L38:
        if (r17.hasNext() == false) goto L40;
        r14.remove((String) r17.next());
    L40:
        if (r14 == null) goto L42;
        String r18 = r14.toString();
    L43:
        if (r18 != null) goto L45;
    L46:
        r9 = true;
    L47:
        if (r9 == false) goto L49;
    L50:
        RouterParamErrorEvent r19 = new RouterParamErrorEvent();
        HashMap<String, String> r20 = r3.getParamsMap();
        if (r20 == null) goto L53;
        String r21 = cd.a.c(r20).toString();
    L54:
        r19.setRouterParam(r21);
        r19.setAnchorTabId(String.valueOf(r3.getAnchorTabId()));
        r19.post(null, null);
    L55:
        if (r18 != null) goto L57;
        r18 = "";
    L57:
        HashMap r22 = new HashMap();
        r22.put("router_params", r18);
        Integer r23 = r3.getAnchorTabId();
        if (r23 == null) goto L61;
        String r27 = String.valueOf(r23.intValue());
        if (r27 == null) goto L61;
    L62:
        r22.put("anchor_tab_id", r27);
        r6.appendQueryParameter("api_params", k.d(r22));
    L61:
        r27 = "0";
        goto L62
    L53:
        r21 = null;
        goto L54
    L49:
        if (Intrinsics.areEqual(r18, "{}") == false) goto L55;
    L45:
        if (r18.length() != 0) goto L47;
    L42:
        r18 = null;
        goto L43
    L30:
        r14 = null;
    L21:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Object r28 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r28) == true) goto L26;
        r8 = r28;
    L26:
        r7 = r8;
    L63:
        Iterator r29 = r4.iterator();
    L65:
        if (r29.hasNext() == false) goto L67;
        String r30 = (String) r29.next();
        r6.appendQueryParameter(r30, UriProtector.getQueryParameter(r25, r30));
        goto L65
    L67:
        new com.bytedance.android.shopping.store.tabkit.a().c(r24, r6.build(), r26);
        return true;
    }
}
