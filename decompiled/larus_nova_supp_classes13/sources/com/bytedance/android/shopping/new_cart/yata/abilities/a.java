package com.bytedance.android.shopping.new_cart.yata.abilities;

import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import v96.j;
import v96.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements v96.a {
    public final CartObjectContainer a;
    public final CartViewModel b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.yata.abilities.a$a, reason: collision with other inner class name */
    public static final class C0135a {
    }

    static {
    }

    public a(CartObjectContainer r3) {
        CartViewModel r0 = r3.d;
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        Intrinsics.checkNotNullParameter(r0, "cartVM");
        this.a = r3;
        this.b = r0;
    }

    public final j a(m r12) {
        Intrinsics.checkNotNullParameter(r12, "info");
        LinkedHashMap r13 = new LinkedHashMap();
        CartParams r0 = this.a.e.c;
        if (r0 == null) goto L7;
        Map<String, String> r1 = r0.getSchemaParamsOrCreate();
        if (r1 == null) goto L7;
        r13.putAll(r1);
    L7:
        Pair[] r2 = new Pair[12];
        com.bytedance.android.shopping.new_cart.container.b r3 = this.a.e;
        Intrinsics.checkNotNullParameter(r3, "$this$formatSelectedCartIds");
        r2[0] = TuplesKt.to("selected_cart_ids", CollectionsKt.joinToString$default(r3.f, ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.shopping.new_cart.container.b r4 = this.a.e;
        Intrinsics.checkNotNullParameter(r4, "$this$formatSelectedShopIds");
        r2[1] = TuplesKt.to("selected_shop_ids", CollectionsKt.joinToString$default(r4.g, ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.shopping.new_cart.container.b r5 = this.a.e;
        Intrinsics.checkNotNullParameter(r5, "$this$formatUnSelectedCartIds");
        r2[2] = TuplesKt.to("unselected_cart_ids", CollectionsKt.joinToString$default(r5.h, ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.shopping.new_cart.container.b r6 = this.a.e;
        Intrinsics.checkNotNullParameter(r6, "$this$formatUnSelectedShopIds");
        r2[3] = TuplesKt.to("unselected_shop_ids", CollectionsKt.joinToString$default(r6.i, ",", null, null, 0, null, null, 62, null));
        r2[4] = TuplesKt.to("source_type", "104");
        r2[5] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_cart_page");
        r2[6] = TuplesKt.to("page_type", "YATA_Android");
        vf3.a r7 = this.b.getMultiUpdateImpl();
        String r8 = null;
        if (r7 == null) goto L10;
        Long r9 = Long.valueOf(r7.o());
    L11:
        r2[7] = TuplesKt.to("uplink_version", r9);
        CartParams r10 = this.a.e.c;
        if (r10 == null) goto L14;
        String r11 = r10.getTransparentParams();
    L15:
        r2[8] = TuplesKt.to("transparent_params", r11);
        r2[9] = TuplesKt.to("session_id", this.a.e.m);
        r2[10] = TuplesKt.to("current_cart_height_percent", String.valueOf(this.a.e.q));
        CartParams r14 = this.a.e.c;
        if (r14 == null) goto L18;
        r8 = r14.getSplitActivityScene();
    L18:
        r2[11] = TuplesKt.to("is_in_split_mode", Boolean.valueOf(k.c(r8)));
        Map r15 = MapsKt.mutableMapOf(r2);
        Iterator r16 = ((LinkedHashMap) this.a.e.b).entrySet().iterator();
    L20:
        if (r16.hasNext() == false) goto L24;
        Map.Entry r17 = (Map.Entry) r16.next();
        if (r17.getValue() == null) goto L20;
        r15.put(r17.getKey(), r17.getValue());
        goto L20
    L24:
        Unit r18 = Unit.INSTANCE;
        r13.putAll(r15);
        return new j("/cart/yata/update", r13);
    L14:
        r11 = null;
        goto L15
    L10:
        r9 = null;
        goto L11
    }
}
