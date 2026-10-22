package com.larus.dora.obric.device_management.device_home;

import com.bytedance.dora.annotation.ProductNameType;

/* JADX INFO: loaded from: classes27.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f339197a = 0;

    static {
    }

    public static DoraObricDeviceModeEntryProduct a(Integer r100, Integer r101) {
        int r102 = ProductNameType.DORA_G.f204375id;
        if (r100 != null) goto L6;
    L8:
        int r103 = ProductNameType.DORA_G2.f204375id;
        if (r100 != null) goto L12;
    L14:
        int r104 = ProductNameType.DORA_G_AIR.f204375id;
        if (r100 != null) goto L18;
    L20:
        int r105 = ProductNameType.DORA_G_PIN.f204375id;
        if (r100 != null) goto L24;
    L26:
        DoraObricDeviceModeEntryProduct r106 = DoraObricDeviceModeEntryProduct.UNSUPPORTED;
    L27:
        DoraObricDeviceModeEntryProduct r107 = DoraObricDeviceModeEntryProduct.UNSUPPORTED;
        if (r106 == r107) goto L30;
        boolean r108 = true;
    L31:
        if (r108 == true) goto L34;
        r106 = null;
    L34:
        if (r106 != null) goto L57;
        if (r101 != null) goto L38;
    L40:
        if (r101 != null) goto L43;
    L45:
        if (r101 != null) goto L48;
    L50:
        if (r101 != null) goto L53;
    L56:
        return r107;
    L53:
        if (r101.intValue() != 19) goto L56;
        r107 = DoraObricDeviceModeEntryProduct.G_PIN;
        goto L56
    L48:
        if (r101.intValue() != 18) goto L50;
        r107 = DoraObricDeviceModeEntryProduct.G_AIR;
        goto L56
    L43:
        if (r101.intValue() != 17) goto L45;
        r107 = DoraObricDeviceModeEntryProduct.G2;
        goto L56
    L38:
        if (r101.intValue() != 16) goto L40;
        r107 = DoraObricDeviceModeEntryProduct.G1;
        goto L56
    L57:
        return r106;
    L30:
        r108 = false;
        goto L31
    L24:
        if (r100.intValue() != r105) goto L26;
        r106 = DoraObricDeviceModeEntryProduct.G_PIN;
        goto L27
    L18:
        if (r100.intValue() != r104) goto L20;
        r106 = DoraObricDeviceModeEntryProduct.G_AIR;
        goto L27
    L12:
        if (r100.intValue() != r103) goto L14;
        r106 = DoraObricDeviceModeEntryProduct.G2;
        goto L27
    L6:
        if (r100.intValue() != r102) goto L8;
        r106 = DoraObricDeviceModeEntryProduct.G1;
        goto L27
    }
}
