package com.larus.dora.impl.ota.g2;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    private final String buildTime;
    private final String buildType;
    private final boolean debug;
    private final String model;
    private final String osVersion;
    private final int packageType;
    private final String product;
    private final String romVersion;
    private final String softVersion;

    public g() {
        this(null, null, null, null, null, null, 0, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.product, r101.product) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.osVersion, r101.osVersion) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.romVersion, r101.romVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.softVersion, r101.softVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buildTime, r101.buildTime) == true) goto L27;
        return false;
    L27:
        if (this.packageType == r101.packageType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.buildType, r101.buildType) == true) goto L33;
        return false;
    L33:
        if (this.debug == r101.debug) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((this.product.hashCode() * 31) + this.model.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.romVersion.hashCode()) * 31) + this.softVersion.hashCode()) * 31) + this.buildTime.hashCode()) * 31) + this.packageType) * 31) + this.buildType.hashCode()) * 31;
        if (this.debug == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DeviceVersionSnapshot(product=" + this.product + ", model=" + this.model + ", osVersion=" + this.osVersion + ", romVersion=" + this.romVersion + ", softVersion=" + this.softVersion + ", buildTime=" + this.buildTime + ", packageType=" + this.packageType + ", buildType=" + this.buildType + ", debug=" + this.debug + ')';
    }

    public final String b() {
        return this.osVersion + '|' + this.romVersion + '|' + this.softVersion + '|' + this.buildTime + '|' + this.packageType + '|' + this.buildType;
    }

    public final boolean l() {
        if ((!StringsKt.isBlank(this.product)) == true) goto L5;
    L13:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.model)) == false) goto L13;
        if ((!StringsKt.isBlank(this.osVersion)) == false) goto L13;
        if ((!StringsKt.isBlank(this.romVersion)) == false) goto L13;
        if ((!StringsKt.isBlank(this.buildTime)) == false) goto L13;
        return true;
    }

    public final String c() {
        return this.buildTime;
    }

    public final String d() {
        return this.buildType;
    }

    public final boolean e() {
        return this.debug;
    }

    public final String f() {
        return this.model;
    }

    public final String g() {
        return this.osVersion;
    }

    public final int h() {
        return this.packageType;
    }

    public final String i() {
        return this.product;
    }

    public final String j() {
        return this.romVersion;
    }

    public final String k() {
        return this.softVersion;
    }

    public final String m(boolean r100) {
        if (r100 == false) goto L5;
        return this.softVersion;
    L5:
        return this.osVersion;
    }

    public static g a(g r110, String r111, String r112, String r113, int r114, boolean r115, int r210) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = r110.product;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = r110.model;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = r110.osVersion;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = r110.romVersion;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = r110.softVersion;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r116 = r110.buildTime;
    L27:
        if ((r210 & 64) == 0) goto L29;
        int r117 = r110.packageType;
    L31:
        if ((r210 & 128) == 0) goto L33;
        r100 = r110.buildType;
    L33:
        String r118 = r100;
        if ((r210 & 256) == 0) goto L36;
        boolean r119 = r110.debug;
    L37:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "product");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r103, "osVersion");
        Intrinsics.checkNotNullParameter(r104, "romVersion");
        Intrinsics.checkNotNullParameter(r105, "softVersion");
        Intrinsics.checkNotNullParameter(r116, "buildTime");
        Intrinsics.checkNotNullParameter(r118, "buildType");
        return new g(r101, r102, r103, r104, r105, r116, r117, r118, r119);
    L36:
        r119 = r115;
        goto L37
    L29:
        r117 = r114;
        goto L31
    L25:
        r116 = r113;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ g(String r110, String r111, String r112, String r113, String r114, String r115, int r210, String r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r116 = 0;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r117 = "user";
    L34:
        this(r100, r101, r102, r103, r104, r105, r116, r117, false);
        return;
    L33:
        r117 = r211;
        goto L34
    L29:
        r116 = r210;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public g(String r100, String r101, String r102, String r103, String r104, String r105, int r106, String r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "product");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "osVersion");
        Intrinsics.checkNotNullParameter(r103, "romVersion");
        Intrinsics.checkNotNullParameter(r104, "softVersion");
        Intrinsics.checkNotNullParameter(r105, "buildTime");
        Intrinsics.checkNotNullParameter(r107, "buildType");
        this.product = r100;
        this.model = r101;
        this.osVersion = r102;
        this.romVersion = r103;
        this.softVersion = r104;
        this.buildTime = r105;
        this.packageType = r106;
        this.buildType = r107;
        this.debug = r110;
    }
}
