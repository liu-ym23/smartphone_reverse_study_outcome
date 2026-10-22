package com.larus.dora.impl.onboarding;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class x {
    public static final boolean a(DoraOnboardingDevice r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L18;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (r100.f336558h != ProductNameType.H_FREE_CLIP_2_HE.f204375id) goto L13;
        r102 = true;
        goto L14
    L18:
        return true;
    L5:
        if (r100.f336558h != ProductNameType.H_FREE_CLIP_2.f204375id) goto L7;
        r101 = true;
        goto L8
    }

    public static final DoraDevice b(DoraOnboardingDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DoraDevice r101 = new DoraDevice();
        r101.name = r100.f336551a;
        r101.f204389mac = r100.f336552b;
        r101.f204390sn = r100.f336553c;
        r101.type = r100.getType();
        r101.sku = r100.f336555e;
        r101.battery = r100.f336556f;
        r101.charge = r100.f336557g;
        r101.productId = r100.f336558h;
        r101.vendorId = r100.f336559i;
        return r101;
    }

    public static final DoraOnboardingDevice c(DoraDevice r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.name;
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        String r102 = r110.f204389mac;
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        String r104 = r110.f204390sn;
        if (r104 != null) goto L13;
        String r105 = "";
    L14:
        int r106 = r110.sku;
        return new DoraOnboardingDevice(r101, r103, r105, r110.type, r106, r110.battery, r110.charge, r110.productId, r110.vendorId);
    L13:
        r105 = r104;
        goto L14
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }
}
