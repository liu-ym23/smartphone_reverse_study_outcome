package com.obric.aiagent.product.feature;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jo\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/obric/aiagent/product/feature/ProductInfoConfig;", "Landroid/os/Parcelable;", "manufacturer", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "brand", "model", "name", "device", "policy", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getManufacturer", "()Ljava/util/List;", "getBrand", "getModel", "getName", "getDevice", "getPolicy", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", XmlPullParser.NO_NAMESPACE, "equals", XmlPullParser.NO_NAMESPACE, "other", XmlPullParser.NO_NAMESPACE, "hashCode", "toString", "writeToParcel", XmlPullParser.NO_NAMESPACE, "dest", "Landroid/os/Parcel;", "flags", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ProductInfoConfig implements Parcelable {
    public static final Parcelable.Creator<ProductInfoConfig> CREATOR = null;

    @SerializedName("ro.product.brand")
    private final List<String> brand;

    @SerializedName("ro.product.device")
    private final List<String> device;

    @SerializedName("ro.product.manufacturer")
    private final List<String> manufacturer;

    @SerializedName("ro.product.model")
    private final List<String> model;

    @SerializedName("ro.product.name")
    private final List<String> name;

    @SerializedName("policy")
    private final String policy;

    static {
        CREATOR = new a();
    }

    public ProductInfoConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductInfoConfig copy$default(ProductInfoConfig r4, List r5, List r6, List r7, List r8, List r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.manufacturer;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.brand;
    L8:
        List r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.model;
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.name;
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.device;
    L17:
        List r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.policy;
    L20:
        List r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
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

    public final ProductInfoConfig copy(List<String> r9, List<String> r10, List<String> r11, List<String> r12, List<String> r13, String r14) {
        return new ProductInfoConfig(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ProductInfoConfig) == true) goto L8;
        return false;
    L8:
        ProductInfoConfig r6 = (ProductInfoConfig) r5;
        if (Intrinsics.areEqual(this.manufacturer, r6.manufacturer) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.brand, r6.brand) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.model, r6.model) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.device, r6.device) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.policy, r6.policy) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.manufacturer;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.brand;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.model;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.name;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.device;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.policy;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ProductInfoConfig(manufacturer=" + this.manufacturer + ", brand=" + this.brand + ", model=" + this.model + ", name=" + this.name + ", device=" + this.device + ", policy=" + this.policy + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeStringList(this.manufacturer);
        r1.writeStringList(this.brand);
        r1.writeStringList(this.model);
        r1.writeStringList(this.name);
        r1.writeStringList(this.device);
        r1.writeString(this.policy);
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

    public ProductInfoConfig(List<String> r1, List<String> r2, List<String> r3, List<String> r4, List<String> r5, String r6) {
        this.manufacturer = r1;
        this.brand = r2;
        this.model = r3;
        this.name = r4;
        this.device = r5;
        this.policy = r6;
    }

    public /* synthetic */ ProductInfoConfig(List r5, List r6, List r7, List r8, List r9, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = CollectionsKt.emptyList();
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = CollectionsKt.emptyList();
    L8:
        List r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = CollectionsKt.emptyList();
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = CollectionsKt.emptyList();
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = CollectionsKt.emptyList();
    L17:
        List r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = "and";
    L20:
        List r14 = r5;
        this(r14, r13, r0, r1, r2, r10);
    }
}
