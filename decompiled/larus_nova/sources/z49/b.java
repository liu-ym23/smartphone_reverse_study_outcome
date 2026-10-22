package z49;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.dora.device.DoraDevice;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003Jz\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0006HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\"\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00069"}, d2 = {"Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "", "name", "", "mac", "productId", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "softVersion", "sn", ECPromotion.SKU, "caseSoftVersion", "doraDevice", "Lcom/bytedance/dora/device/DoraDevice;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/dora/device/DoraDevice;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getMac", "setMac", "getProductId", "()Ljava/lang/Integer;", "setProductId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getModel", "setModel", "getSoftVersion", "setSoftVersion", "getSn", "setSn", "getSku", "setSku", "getCaseSoftVersion", "setCaseSoftVersion", "getDoraDevice", "()Lcom/bytedance/dora/device/DoraDevice;", "setDoraDevice", "(Lcom/bytedance/dora/device/DoraDevice;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/dora/device/DoraDevice;)Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DoraDevice f570038a;

    @SerializedName("caseSoftVersion")
    private String caseSoftVersion;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    @SerializedName("mac")
    private String f570039mac;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private String model;

    @SerializedName("name")
    private String name;

    @SerializedName("productId")
    private Integer productId;

    @SerializedName(ECPromotion.SKU)
    private Integer sku;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    @SerializedName("sn")
    private String f570040sn;

    @SerializedName("softVersion")
    private String softVersion;

    public b() {
        this(null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f570039mac, r101.f570039mac) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.softVersion, r101.softVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f570040sn, r101.f570040sn) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sku, r101.sku) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.caseSoftVersion, r101.caseSoftVersion) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f570038a, r101.f570038a) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f570039mac;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.productId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.model;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.softVersion;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f570040sn;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.sku;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.caseSoftVersion;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        DoraDevice r125 = this.f570038a;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
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
        return "DoraSimpleDeviceV2(name=" + this.name + ", mac=" + this.f570039mac + ", productId=" + this.productId + ", model=" + this.model + ", softVersion=" + this.softVersion + ", sn=" + this.f570040sn + ", sku=" + this.sku + ", caseSoftVersion=" + this.caseSoftVersion + ", doraDevice=" + this.f570038a + ')';
    }

    public final String b() {
        return this.caseSoftVersion;
    }

    public final String c() {
        return this.f570039mac;
    }

    public final String d() {
        return this.model;
    }

    public final String e() {
        return this.name;
    }

    public final Integer f() {
        return this.productId;
    }

    public final Integer g() {
        return this.sku;
    }

    public final String h() {
        return this.f570040sn;
    }

    public final String i() {
        return this.softVersion;
    }

    public static b a(b r110, DoraDevice r111) {
        String r100 = r110.name;
        String r101 = r110.f570039mac;
        Integer r102 = r110.productId;
        String r103 = r110.model;
        String r104 = r110.softVersion;
        String r105 = r110.f570040sn;
        Integer r106 = r110.sku;
        String r107 = r110.caseSoftVersion;
        r110.getClass();
        return new b(r100, r101, r102, r103, r104, r105, r106, r107, r111);
    }

    public /* synthetic */ b(String r110, String r111, String r112, Integer r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Integer r102 = 1;
    L15:
        if ((r114 & 16) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r114 & 32) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r114 & 64) == 0) goto L25;
        Integer r115 = 0;
    L27:
        if ((r114 & 128) == 0) goto L29;
        String r116 = "";
    L30:
        this(r100, r101, r102, null, r103, r104, r115, r116, null);
        return;
    L29:
        r116 = null;
        goto L30
    L25:
        r115 = r113;
        goto L27
    L21:
        r104 = r112;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public b(String r100, String r101, Integer r102, String r103, String r104, String r105, Integer r106, String r107, DoraDevice r108) {
        this.name = r100;
        this.f570039mac = r101;
        this.productId = r102;
        this.model = r103;
        this.softVersion = r104;
        this.f570040sn = r105;
        this.sku = r106;
        this.caseSoftVersion = r107;
        this.f570038a = r108;
    }
}
