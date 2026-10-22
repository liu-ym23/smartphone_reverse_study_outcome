package com.obric.aiagent.product.feature;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.crypto.platform.PlatformConst;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jo\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/obric/aiagent/product/feature/ProductInfoConfig;", "Landroid/os/Parcelable;", "manufacturer", "", "", "brand", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "name", "device", "policy", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getManufacturer", "()Ljava/util/List;", "getBrand", "getModel", "getName", "getDevice", "getPolicy", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProductInfoConfig implements Parcelable {
    public static final Parcelable.Creator<ProductInfoConfig> CREATOR = null;

    @SerializedName("ro.product.brand")
    private final List<String> brand;

    @SerializedName("ro.product.device")
    private final List<String> device;

    @SerializedName(PlatformConst.PROP_MANUFACTURER)
    private final List<String> manufacturer;

    @SerializedName("ro.product.model")
    private final List<String> model;

    @SerializedName("ro.product.name")
    private final List<String> name;

    @SerializedName("policy")
    private final String policy;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a implements Parcelable.Creator<ProductInfoConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProductInfoConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ProductInfoConfig(r100.createStringArrayList(), r100.createStringArrayList(), r100.createStringArrayList(), r100.createStringArrayList(), r100.createStringArrayList(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ProductInfoConfig[] newArray(int r100) {
            return new ProductInfoConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProductInfoConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductInfoConfig copy$default(ProductInfoConfig r100, List r101, List r102, List r103, List r104, List r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.manufacturer;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.brand;
    L8:
        List r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.model;
    L11:
        List r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.name;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.device;
    L17:
        List r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.policy;
    L20:
        List r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final List<String> component1() {
        return this.manufacturer;
    }

    public final List<String> component2() {
        return this.brand;
    }

    public final List<String> component3() {
        return this.model;
    }

    public final List<String> component4() {
        return this.name;
    }

    public final List<String> component5() {
        return this.device;
    }

    public final String component6() {
        return this.policy;
    }

    public final ProductInfoConfig copy(List<String> r100, List<String> r110, List<String> r111, List<String> r112, List<String> r113, String r114) {
        return new ProductInfoConfig(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProductInfoConfig) == true) goto L8;
        return false;
    L8:
        ProductInfoConfig r101 = (ProductInfoConfig) r100;
        if (Intrinsics.areEqual(this.manufacturer, r101.manufacturer) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.brand, r101.brand) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.device, r101.device) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.policy, r101.policy) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.manufacturer;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.brand;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.model;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.name;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.device;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.policy;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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

    public String toString() {
        return "ProductInfoConfig(manufacturer=" + this.manufacturer + ", brand=" + this.brand + ", model=" + this.model + ", name=" + this.name + ", device=" + this.device + ", policy=" + this.policy + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeStringList(this.manufacturer);
        r100.writeStringList(this.brand);
        r100.writeStringList(this.model);
        r100.writeStringList(this.name);
        r100.writeStringList(this.device);
        r100.writeString(this.policy);
    }

    public final List<String> getBrand() {
        return this.brand;
    }

    public final List<String> getDevice() {
        return this.device;
    }

    public final List<String> getManufacturer() {
        return this.manufacturer;
    }

    public final List<String> getModel() {
        return this.model;
    }

    public final List<String> getName() {
        return this.name;
    }

    public final String getPolicy() {
        return this.policy;
    }

    public ProductInfoConfig(List<String> r100, List<String> r101, List<String> r102, List<String> r103, List<String> r104, String r105) {
        this.manufacturer = r100;
        this.brand = r101;
        this.model = r102;
        this.name = r103;
        this.device = r104;
        this.policy = r105;
    }

    public /* synthetic */ ProductInfoConfig(List r100, List r101, List r102, List r103, List r104, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        List r113 = r101;
        if ((r111 & 4) == 0) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        List r105 = r102;
        if ((r111 & 8) == 0) goto L14;
        r103 = CollectionsKt.emptyList();
    L14:
        List r106 = r103;
        if ((r111 & 16) == 0) goto L17;
        r104 = CollectionsKt.emptyList();
    L17:
        List r107 = r104;
        if ((r111 & 32) == 0) goto L20;
        r110 = "and";
    L20:
        List r108 = r100;
        this(r108, r113, r105, r106, r107, r110);
    }
}
