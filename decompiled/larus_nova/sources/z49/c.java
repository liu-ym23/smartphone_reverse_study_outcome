package z49;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0086\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0007HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u001a¨\u00065"}, d2 = {"Lcom/larus/dora/impl/device_v2/entity/HistoryDeviceListInfo;", "", "name", "", "icon", "mac", "productId", "", "earphoneName", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "softVersion", "sn", "selected", "", ECPromotion.SKU, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getName", "()Ljava/lang/String;", "getIcon", "getMac", "getProductId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEarphoneName", "setEarphoneName", "(Ljava/lang/Integer;)V", "getModel", "getSoftVersion", "getSn", "getSelected", "()Ljava/lang/Boolean;", "setSelected", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSku", "setSku", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/dora/impl/device_v2/entity/HistoryDeviceListInfo;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("earphone_name")
    private Integer earphoneName;

    @SerializedName("value")
    private final String icon;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    @SerializedName("mac")
    private final String f570041mac;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private final String model;

    @SerializedName("name")
    private final String name;

    @SerializedName("productId")
    private final Integer productId;

    @SerializedName("selected")
    private Boolean selected;

    @SerializedName(ECPromotion.SKU)
    private Integer sku;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    @SerializedName("sn")
    private final String f570042sn;

    @SerializedName("softVersion")
    private final String softVersion;

    public c() {
        this(null, null, null, 1, 0, null, null, null, Boolean.FALSE, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f570041mac, r101.f570041mac) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.earphoneName, r101.earphoneName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.softVersion, r101.softVersion) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f570042sn, r101.f570042sn) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.selected, r101.selected) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sku, r101.sku) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.icon;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f570041mac;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.productId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.earphoneName;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.model;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.softVersion;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f570042sn;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.selected;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.sku;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "HistoryDeviceListInfo(name=" + this.name + ", icon=" + this.icon + ", mac=" + this.f570041mac + ", productId=" + this.productId + ", earphoneName=" + this.earphoneName + ", model=" + this.model + ", softVersion=" + this.softVersion + ", sn=" + this.f570042sn + ", selected=" + this.selected + ", sku=" + this.sku + ')';
    }

    public final String b() {
        return this.f570041mac;
    }

    public final String c() {
        return this.name;
    }

    public final Integer d() {
        return this.productId;
    }

    public final Boolean e() {
        return this.selected;
    }

    public final Integer f() {
        return this.sku;
    }

    public static c a(c r110, Boolean r111) {
        String r100 = r110.name;
        String r101 = r110.icon;
        String r102 = r110.f570041mac;
        Integer r103 = r110.productId;
        Integer r104 = r110.earphoneName;
        String r105 = r110.model;
        String r106 = r110.softVersion;
        String r107 = r110.f570042sn;
        Integer r112 = r110.sku;
        r110.getClass();
        return new c(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112);
    }

    public c(String r100, String r101, String r102, Integer r103, Integer r104, String r105, String r106, String r107, Boolean r108, Integer r110) {
        this.name = r100;
        this.icon = r101;
        this.f570041mac = r102;
        this.productId = r103;
        this.earphoneName = r104;
        this.model = r105;
        this.softVersion = r106;
        this.f570042sn = r107;
        this.selected = r108;
        this.sku = r110;
    }
}
