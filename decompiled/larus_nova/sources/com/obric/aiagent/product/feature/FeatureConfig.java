package com.obric.aiagent.product.feature;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012 \b\u0002\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J!\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000bHÆ\u0003Jo\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072 \b\u0002\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000bHÆ\u0001J\u0006\u0010 \u001a\u00020!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020!HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020!R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R.\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Lcom/obric/aiagent/product/feature/FeatureConfig;", "Landroid/os/Parcelable;", "enabled", "", "defaultState", "", "dependencyOsFeatureList", "", "productBlackList", "productWhiteList", "productSpecialList", "", "Lcom/obric/aiagent/product/feature/ProductSpecialConfig;", "<init>", "(ZLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getEnabled", "()Z", "getDefaultState", "()Ljava/lang/String;", "getDependencyOsFeatureList", "()Ljava/util/List;", "getProductBlackList", "getProductWhiteList", "getProductSpecialList", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureConfig implements Parcelable {
    public static final Parcelable.Creator<FeatureConfig> CREATOR = null;

    @SerializedName("default_state")
    private final String defaultState;

    @SerializedName("dependency_os_feature_list")
    private final List<String> dependencyOsFeatureList;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("product_black_list")
    private final List<String> productBlackList;

    @SerializedName("product_special_list")
    private final Map<String, Map<String, ProductSpecialConfig>> productSpecialList;

    @SerializedName("product_white_list")
    private final List<String> productWhiteList;

    public static final class a implements Parcelable.Creator<FeatureConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            if (r110.readInt() == 0) goto L5;
            boolean r100 = true;
        L6:
            String r101 = r110.readString();
            ArrayList<String> r102 = r110.createStringArrayList();
            ArrayList<String> r103 = r110.createStringArrayList();
            ArrayList<String> r104 = r110.createStringArrayList();
            int r105 = r110.readInt();
            LinkedHashMap r106 = new LinkedHashMap(r105);
            int r107 = 0;
        L7:
            if (r107 == r105) goto L13;
            String r111 = r110.readString();
            int r112 = r110.readInt();
            LinkedHashMap r113 = new LinkedHashMap(r112);
            int r114 = 0;
        L9:
            if (r114 == r112) goto L11;
            r113.put(r110.readString(), ProductSpecialConfig.CREATOR.createFromParcel(r110));
            r114 = r114 + 1;
            goto L9
        L11:
            r106.put(r111, r113);
            r107 = r107 + 1;
            goto L7
        L13:
            return new FeatureConfig(r100, r101, r102, r103, r104, r106);
        L5:
            r100 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureConfig[] newArray(int r100) {
            return new FeatureConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FeatureConfig() {
        this(false, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeatureConfig copy$default(FeatureConfig r100, boolean r101, String r102, List r103, List r104, List r105, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.enabled;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.defaultState;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.dependencyOsFeatureList;
    L11:
        List r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.productBlackList;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.productWhiteList;
    L17:
        List r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.productSpecialList;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.defaultState;
    }

    public final List<String> component3() {
        return this.dependencyOsFeatureList;
    }

    public final List<String> component4() {
        return this.productBlackList;
    }

    public final List<String> component5() {
        return this.productWhiteList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> component6() {
        return this.productSpecialList;
    }

    public final FeatureConfig copy(boolean r100, String r110, List<String> r111, List<String> r112, List<String> r113, Map<String, ? extends Map<String, ProductSpecialConfig>> r114) {
        Intrinsics.checkNotNullParameter(r110, "defaultState");
        Intrinsics.checkNotNullParameter(r111, "dependencyOsFeatureList");
        Intrinsics.checkNotNullParameter(r112, "productBlackList");
        Intrinsics.checkNotNullParameter(r113, "productWhiteList");
        Intrinsics.checkNotNullParameter(r114, "productSpecialList");
        return new FeatureConfig(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeatureConfig) == true) goto L8;
        return false;
    L8:
        FeatureConfig r101 = (FeatureConfig) r100;
        if (this.enabled == r101.enabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultState, r101.defaultState) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.dependencyOsFeatureList, r101.dependencyOsFeatureList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.productBlackList, r101.productBlackList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.productWhiteList, r101.productWhiteList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.productSpecialList, r101.productSpecialList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        if (this.enabled == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((((((r100 * 31) + this.defaultState.hashCode()) * 31) + this.dependencyOsFeatureList.hashCode()) * 31) + this.productBlackList.hashCode()) * 31) + this.productWhiteList.hashCode()) * 31) + this.productSpecialList.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "FeatureConfig(enabled=" + this.enabled + ", defaultState=" + this.defaultState + ", dependencyOsFeatureList=" + this.dependencyOsFeatureList + ", productBlackList=" + this.productBlackList + ", productWhiteList=" + this.productWhiteList + ", productSpecialList=" + this.productSpecialList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.enabled ? 1 : 0);
        r100.writeString(this.defaultState);
        r100.writeStringList(this.dependencyOsFeatureList);
        r100.writeStringList(this.productBlackList);
        r100.writeStringList(this.productWhiteList);
        Map<String, Map<String, ProductSpecialConfig>> r102 = this.productSpecialList;
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, Map<String, ProductSpecialConfig>>> r103 = r102.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, Map<String, ProductSpecialConfig>> r104 = r103.next();
        r100.writeString(r104.getKey());
        Map<String, ProductSpecialConfig> r105 = r104.getValue();
        r100.writeInt(r105.size());
        Iterator<Map.Entry<String, ProductSpecialConfig>> r106 = r105.entrySet().iterator();
    L7:
        if (r106.hasNext() == false) goto L4;
        Map.Entry<String, ProductSpecialConfig> r107 = r106.next();
        r100.writeString(r107.getKey());
        r107.getValue().writeToParcel(r100, r101);
        goto L7
    }

    public final String getDefaultState() {
        return this.defaultState;
    }

    public final List<String> getDependencyOsFeatureList() {
        return this.dependencyOsFeatureList;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> getProductBlackList() {
        return this.productBlackList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> getProductSpecialList() {
        return this.productSpecialList;
    }

    public final List<String> getProductWhiteList() {
        return this.productWhiteList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeatureConfig(boolean r100, String r101, List<String> r102, List<String> r103, List<String> r104, Map<String, ? extends Map<String, ProductSpecialConfig>> r105) {
        Intrinsics.checkNotNullParameter(r101, "defaultState");
        Intrinsics.checkNotNullParameter(r102, "dependencyOsFeatureList");
        Intrinsics.checkNotNullParameter(r103, "productBlackList");
        Intrinsics.checkNotNullParameter(r104, "productWhiteList");
        Intrinsics.checkNotNullParameter(r105, "productSpecialList");
        this.enabled = r100;
        this.defaultState = r101;
        this.dependencyOsFeatureList = r102;
        this.productBlackList = r103;
        this.productWhiteList = r104;
        this.productSpecialList = r105;
    }

    public /* synthetic */ FeatureConfig(boolean r100, String r101, List r102, List r103, List r104, Map r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = "enabled";
    L8:
        String r113 = r101;
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
        r110 = MapsKt.emptyMap();
    L20:
        boolean r108 = r100;
        this(r108, r113, r105, r106, r107, r110);
    }
}
