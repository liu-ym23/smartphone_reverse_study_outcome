package com.bytedance.android.shopping.new_cart.yata.abilities;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.new_cart.container.s;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements h {
    public final Map<String, Object> a;
    public final boolean b;
    public final PageFinder c;
    public final Function2<String, Map<String, Object>, Unit> d;

    public final void b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "btm");
        Lazy r0 = ECAppInfoService.a;
        if (ECAppInfoService.m() == true) goto L5;
    L7:
        BtmSDK.INSTANCE.createBtmChain(new BtmItemBuilder(r8, Boolean.TRUE).withPageFinder(this.c).build());
        return;
    L5:
        if (this.b == true) goto L7;
        int r1 = s.a;
        r8 = StringsKt.replace$default(r8, "a1.b4001.", "a1.b98956.", false, 4, null);
        goto L7
    }

    public final void c(Map<String, ? extends Object> r2) {
        PageFinder r0 = this.c;
        if (r0 == null) goto L6;
        com.bytedance.android.bcm.api.b.f(r0, r2);
        return;
    }

    public final void a(String r9, Map<String, Object> r10) {
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Intrinsics.checkNotNullParameter(r10, "params");
        Object r1 = r10.get("btm");
        if ((r1 instanceof String) == true) goto L5;
        r1 = null;
    L5:
        String r2 = (String) r1;
        if (r2 == null) goto L15;
        Lazy r3 = ECAppInfoService.a;
        if (ECAppInfoService.m() == true) goto L11;
    L13:
        r10.put("btm", r2);
        goto L15
    L11:
        if (this.b == true) goto L13;
        int r4 = s.a;
        r2 = StringsKt.replace$default(r2, "a1.b4001.", "a1.b98956.", false, 4, null);
    L15:
        if (ECAppInfoService.e.isDebug() == false) goto L17;
        r10.put("cart_android_track_debug", "true");
    L17:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this.a);
        r0.putAll(r10);
        this.d.invoke(r9, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(boolean r2, PageFinder r3, Function2<? super String, ? super Map<String, Object>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "trackCallback");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("area_type", "104"), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_cart_page")});
    }
}
