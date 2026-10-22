package com.obric.assistant.dora;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;

/* JADX INFO: loaded from: classes33.dex */
public final class d {
    public static final DoraBleDevice b(DoraDevice r110) {
        return new DoraBleDevice(r110.f204389mac, r110.name, r110.charge, r110.battery, r110.version, r110.type, r110.f204390sn, r110.sku, r110.mode, r110.vendorId, r110.vendorCapabilities, r110.productId, r110.model);
    }

    public static final int a(int r100, int r101) {
        switch(r101) {
            case 16: goto L21;
            case 17: goto L20;
            case 18: goto L19;
            case 19: goto L18;
            default: goto L3;
        };
    L3:
        Integer r102 = Integer.valueOf(r100);
        if (r102.intValue() <= 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L17;
        return r102.intValue();
    L17:
        return ProductNameType.DORA_LITE.f204375id;
    L10:
        r103 = false;
        goto L11
    L18:
        return ProductNameType.DORA_G_PIN.f204375id;
    L19:
        return ProductNameType.DORA_G_AIR.f204375id;
    L20:
        return ProductNameType.DORA_G2.f204375id;
    L21:
        return ProductNameType.DORA_G.f204375id;
    }
}
