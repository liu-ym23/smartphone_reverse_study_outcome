package com.larus.dora.impl.core;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class x0 {
    public static final String b(boolean r100) {
        if (r100 == false) goto L4;
        return "on";
    L4:
        return "off";
    }

    public static final Map<String, String> a(boolean r100) {
        String r101 = b(r100);
        Pair[] r102 = new Pair[3];
        boolean r103 = false;
        r102[0] = TuplesKt.to("dora_g_natural_wakeup_switch", r101);
        r102[1] = TuplesKt.to("dora_natural_wakeup_switch", r101);
        DoraDevice r104 = kj4.a.g().c();
        if (r104 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L10;
        String r106 = "dora_h";
    L17:
        r102[2] = TuplesKt.to("dora_product_type", r106);
        return MapsKt.mapOf(r102);
    L10:
        if (r104 != null) goto L12;
    L14:
        if (r103 == false) goto L16;
        r106 = "dora_g";
        goto L17
    L16:
        r106 = "dora_d";
        goto L17
    L12:
        if (r104.productId != ProductNameType.DORA_G.f204375id) goto L14;
        r103 = true;
        goto L14
    L5:
        if (r104.vendorId != 4096) goto L7;
        r105 = true;
        goto L8
    }
}
