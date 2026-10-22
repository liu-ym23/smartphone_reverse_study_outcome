package com.larus.login.api.ecommerce;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f357030a = null;

    public static final class a implements com.larus.login.api.b {
        public a() {
        }

        @Override // com.larus.login.api.b
        public final void a(String r100, com.larus.login.api.i r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "currentPage");
            Intrinsics.checkNotNullParameter(r102, "extraParams");
            a r103 = i.f357030a;
            Intrinsics.checkNotNullParameter(r100, "currentPage");
            Intrinsics.checkNotNullParameter(r102, "extraParams");
            if (r101 == null) goto L5;
            b r104 = r101.f357052k;
        L6:
            if (r104 != null) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(r102.get("marketing_loc"), "binding_douyin_popup") == false) goto L17;
            com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
            JSONObject r106 = new JSONObject();
            i.b(r106, r102);
            r106.put("current_page", r100);
            if (r106.has("is_panel_unfold") == true) goto L14;
            r106.put("is_panel_unfold", "1");
        L14:
            Unit r107 = Unit.INSTANCE;
            r105.reportEvent("doubao_ecom_marketing_show", r106);
            return;
        L17:
            return;
        L5:
            r104 = null;
            goto L6
        }

        @Override // com.larus.login.api.b
        public final void b(String r100, com.larus.login.api.i r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "currentPage");
            Intrinsics.checkNotNullParameter(r102, "extraParams");
            a r103 = i.f357030a;
            Intrinsics.checkNotNullParameter(r100, "currentPage");
            Intrinsics.checkNotNullParameter(r102, "extraParams");
            if (r101 == null) goto L5;
            b r104 = r101.f357052k;
        L6:
            if (r104 != null) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(r102.get("marketing_loc"), "binding_douyin_popup") == false) goto L17;
            com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
            JSONObject r106 = new JSONObject();
            i.b(r106, r102);
            r106.put("current_page", r100);
            if (r106.has("click_pos") == true) goto L14;
            r106.put("click_pos", "bind_douyin");
        L14:
            Unit r107 = Unit.INSTANCE;
            r105.reportEvent("doubao_ecom_marketing_click", r106);
            return;
        L17:
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        f357030a = new a();
    }

    public static Map a(com.larus.login.api.i r100) {
        if (r100 == null) goto L72;
        b r101 = r100.f357052k;
        if (r101 == null) goto L72;
        Map r102 = MapsKt.createMapBuilder();
        Map<String, String> r103 = r100.f357053l;
        if (r103 != null) goto L9;
        r103 = MapsKt.emptyMap();
    L9:
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L10:
        boolean r105 = true;
        if (r104.hasNext() == false) goto L21;
        Map.Entry<String, String> r106 = r104.next();
        String r107 = r106.getKey();
        String r108 = r106.getValue();
        if (r108 != null) goto L15;
    L18:
        if (r105 == true) goto L10;
        r102.put(r107, r108);
        goto L10
    L15:
        if (StringsKt.isBlank(r108) == true) goto L18;
        r105 = false;
        goto L18
    L21:
        if (r102.containsKey("popup_type") == true) goto L24;
        r102.put("popup_type", "coupon_to_bind");
    L24:
        if (r102.containsKey("marketing_loc") == true) goto L27;
        r102.put("marketing_loc", "binding_douyin_popup");
    L27:
        if (r102.containsKey("show_type") == true) goto L30;
        r102.put("show_type", AnchorBenefitToast.TYPE_COUPON);
    L30:
        if (r102.containsKey(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE) == true) goto L33;
        r102.put(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, "platform_coupon");
    L33:
        if (r102.containsKey("is_douyin_auth") == true) goto L35;
        r102.put("is_douyin_auth", "0");
    L35:
        Long r109 = r101.h();
        if (r109 == null) goto L40;
        long r110 = r109.longValue();
        if (r102.containsKey("coupon_status") == true) goto L40;
        r102.put("coupon_status", String.valueOf(r110));
    L40:
        String r111 = r101.c();
        String r112 = null;
        if (r111 != null) goto L43;
    L50:
        String r113 = r101.d();
        if (r113 != null) goto L53;
    L60:
        String r114 = r101.e();
        if (r114 == null) goto L70;
        if ((!StringsKt.isBlank(r114)) == false) goto L65;
        r112 = r114;
    L65:
        if (r112 == null) goto L70;
        if (r102.containsKey("coupon_meta_id") == true) goto L70;
        r102.put("coupon_meta_id", r112);
    L70:
        return MapsKt.build(r102);
    L53:
        if ((!StringsKt.isBlank(r113)) == true) goto L56;
        r113 = null;
    L56:
        if (r113 == null) goto L60;
        if (r102.containsKey("coupon_id") == true) goto L60;
        r102.put("coupon_id", r113);
        goto L60
    L43:
        if ((!StringsKt.isBlank(r111)) == true) goto L46;
        r111 = null;
    L46:
        if (r111 == null) goto L50;
        if (r102.containsKey("bsk") == true) goto L50;
        r102.put("bsk", r111);
    L72:
        return MapsKt.emptyMap();
    }

    public static void b(JSONObject r100, Map r101) {
        if (r101.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L17;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if (r105 == null) goto L7;
        if (r100.has(r104) == true) goto L7;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L15
        Result.m9449constructorimpl(r100.put(r104, r105));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
