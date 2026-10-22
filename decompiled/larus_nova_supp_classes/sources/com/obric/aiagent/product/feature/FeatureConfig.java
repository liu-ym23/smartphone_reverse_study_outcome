package com.obric.aiagent.product.feature;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.EventsUtils;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012 \b\u0002\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J!\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000bHÆ\u0003Jo\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072 \b\u0002\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000bHÆ\u0001J\u0006\u0010 \u001a\u00020!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020!HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020!R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R.\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Lcom/obric/aiagent/product/feature/FeatureConfig;", "Landroid/os/Parcelable;", "enabled", XmlPullParser.NO_NAMESPACE, "defaultState", XmlPullParser.NO_NAMESPACE, "dependencyOsFeatureList", XmlPullParser.NO_NAMESPACE, "productBlackList", "productWhiteList", "productSpecialList", XmlPullParser.NO_NAMESPACE, "Lcom/obric/aiagent/product/feature/ProductSpecialConfig;", "<init>", "(ZLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getEnabled", "()Z", "getDefaultState", "()Ljava/lang/String;", "getDependencyOsFeatureList", "()Ljava/util/List;", "getProductBlackList", "getProductWhiteList", "getProductSpecialList", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", XmlPullParser.NO_NAMESPACE, "equals", "other", XmlPullParser.NO_NAMESPACE, "hashCode", "toString", "writeToParcel", XmlPullParser.NO_NAMESPACE, "dest", "Landroid/os/Parcel;", "flags", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
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
        public final FeatureConfig createFromParcel(Parcel r17) {
            Intrinsics.checkNotNullParameter(r17, "parcel");
            if (r17.readInt() == 0) goto L5;
            boolean r4 = true;
        L6:
            String r5 = r17.readString();
            ArrayList<String> r6 = r17.createStringArrayList();
            ArrayList<String> r7 = r17.createStringArrayList();
            ArrayList<String> r8 = r17.createStringArrayList();
            int r1 = r17.readInt();
            LinkedHashMap r9 = new LinkedHashMap(r1);
            int r3 = 0;
        L7:
            if (r3 == r1) goto L13;
            String r10 = r17.readString();
            int r11 = r17.readInt();
            LinkedHashMap r12 = new LinkedHashMap(r11);
            int r13 = 0;
        L9:
            if (r13 == r11) goto L11;
            r12.put(r17.readString(), ProductSpecialConfig.CREATOR.createFromParcel(r17));
            r13 = r13 + 1;
            goto L9
        L11:
            r9.put(r10, r12);
            r3 = r3 + 1;
            goto L7
        L13:
            return new FeatureConfig(r4, r5, r6, r7, r8, r9);
        L5:
            r4 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureConfig[] newArray(int r1) {
            return new FeatureConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public FeatureConfig() {
        this(false, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeatureConfig copy$default(FeatureConfig r4, boolean r5, String r6, List r7, List r8, List r9, Map r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.enabled;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.defaultState;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.dependencyOsFeatureList;
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.productBlackList;
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.productWhiteList;
    L17:
        List r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.productSpecialList;
    L20:
        boolean r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
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

    public final FeatureConfig copy(boolean r9, String r10, List<String> r11, List<String> r12, List<String> r13, Map<String, ? extends Map<String, ProductSpecialConfig>> r14) {
        Intrinsics.checkNotNullParameter(r10, "defaultState");
        Intrinsics.checkNotNullParameter(r11, "dependencyOsFeatureList");
        Intrinsics.checkNotNullParameter(r12, "productBlackList");
        Intrinsics.checkNotNullParameter(r13, "productWhiteList");
        Intrinsics.checkNotNullParameter(r14, "productSpecialList");
        return new FeatureConfig(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FeatureConfig) == true) goto L8;
        return false;
    L8:
        FeatureConfig r6 = (FeatureConfig) r5;
        if (this.enabled == r6.enabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultState, r6.defaultState) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.dependencyOsFeatureList, r6.dependencyOsFeatureList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.productBlackList, r6.productBlackList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.productWhiteList, r6.productWhiteList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.productSpecialList, r6.productSpecialList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        if (this.enabled == false) goto L5;
        int r0 = 1231;
    L7:
        return (((((((((r0 * 31) + this.defaultState.hashCode()) * 31) + this.dependencyOsFeatureList.hashCode()) * 31) + this.productBlackList.hashCode()) * 31) + this.productWhiteList.hashCode()) * 31) + this.productSpecialList.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public String toString() {
        return "FeatureConfig(enabled=" + this.enabled + ", defaultState=" + this.defaultState + ", dependencyOsFeatureList=" + this.dependencyOsFeatureList + ", productBlackList=" + this.productBlackList + ", productWhiteList=" + this.productWhiteList + ", productSpecialList=" + this.productSpecialList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeInt(this.enabled ? 1 : 0);
        r5.writeString(this.defaultState);
        r5.writeStringList(this.dependencyOsFeatureList);
        r5.writeStringList(this.productBlackList);
        r5.writeStringList(this.productWhiteList);
        Map<String, Map<String, ProductSpecialConfig>> r0 = this.productSpecialList;
        r5.writeInt(r0.size());
        Iterator<Map.Entry<String, Map<String, ProductSpecialConfig>>> r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Map.Entry<String, Map<String, ProductSpecialConfig>> r2 = r1.next();
        r5.writeString(r2.getKey());
        Map<String, ProductSpecialConfig> r3 = r2.getValue();
        r5.writeInt(r3.size());
        Iterator<Map.Entry<String, ProductSpecialConfig>> r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        Map.Entry<String, ProductSpecialConfig> r7 = r4.next();
        r5.writeString(r7.getKey());
        r7.getValue().writeToParcel(r5, r6);
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
    public FeatureConfig(boolean r2, String r3, List<String> r4, List<String> r5, List<String> r6, Map<String, ? extends Map<String, ProductSpecialConfig>> r7) {
        Intrinsics.checkNotNullParameter(r3, "defaultState");
        Intrinsics.checkNotNullParameter(r4, "dependencyOsFeatureList");
        Intrinsics.checkNotNullParameter(r5, "productBlackList");
        Intrinsics.checkNotNullParameter(r6, "productWhiteList");
        Intrinsics.checkNotNullParameter(r7, "productSpecialList");
        this.enabled = r2;
        this.defaultState = r3;
        this.dependencyOsFeatureList = r4;
        this.productBlackList = r5;
        this.productWhiteList = r6;
        this.productSpecialList = r7;
    }

    public /* synthetic */ FeatureConfig(boolean r5, String r6, List r7, List r8, List r9, Map r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = true;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = "enabled";
    L8:
        String r13 = r6;
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
        r10 = MapsKt.emptyMap();
    L20:
        boolean r14 = r5;
        this(r14, r13, r0, r1, r2, r10);
    }
}
