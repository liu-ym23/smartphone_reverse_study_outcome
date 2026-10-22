package com.larus.bmhome.view.actionbar.gaokao.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\nHÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceConfResponse;", "", "provinceList", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceList;", "typeList", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoTypeList;", "currentProvinceKey", "", "currentProvinceName", "preferencesAfterGraduation", "", "<init>", "(Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceList;Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoTypeList;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getProvinceList", "()Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceList;", "getTypeList", "()Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoTypeList;", "getCurrentProvinceKey", "()Ljava/lang/String;", "getCurrentProvinceName", "getPreferencesAfterGraduation", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoProvinceConfResponse {

    @SerializedName("current_province_key")
    private final String currentProvinceKey;

    @SerializedName("current_province_name")
    private final String currentProvinceName;

    @SerializedName("preferences_after_graduation")
    private final List<String> preferencesAfterGraduation;

    @SerializedName("province_list")
    private final GaokaoProvinceList provinceList;

    @SerializedName("type_list")
    private final GaokaoTypeList typeList;

    public GaokaoProvinceConfResponse() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GaokaoProvinceConfResponse copy$default(GaokaoProvinceConfResponse r100, GaokaoProvinceList r101, GaokaoTypeList r102, String r103, String r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.provinceList;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.typeList;
    L8:
        GaokaoTypeList r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.currentProvinceKey;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.currentProvinceName;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.preferencesAfterGraduation;
    L17:
        GaokaoProvinceList r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final GaokaoProvinceList component1() {
        return this.provinceList;
    }

    public final GaokaoTypeList component2() {
        return this.typeList;
    }

    public final String component3() {
        return this.currentProvinceKey;
    }

    public final String component4() {
        return this.currentProvinceName;
    }

    public final List<String> component5() {
        return this.preferencesAfterGraduation;
    }

    public final GaokaoProvinceConfResponse copy(GaokaoProvinceList r100, GaokaoTypeList r101, String r110, String r111, List<String> r112) {
        return new GaokaoProvinceConfResponse(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GaokaoProvinceConfResponse) == true) goto L8;
        return false;
    L8:
        GaokaoProvinceConfResponse r101 = (GaokaoProvinceConfResponse) r100;
        if (Intrinsics.areEqual(this.provinceList, r101.provinceList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.typeList, r101.typeList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.currentProvinceKey, r101.currentProvinceKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.currentProvinceName, r101.currentProvinceName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.preferencesAfterGraduation, r101.preferencesAfterGraduation) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        GaokaoProvinceList r100 = this.provinceList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        GaokaoTypeList r104 = this.typeList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.currentProvinceKey;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.currentProvinceName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.preferencesAfterGraduation;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "GaokaoProvinceConfResponse(provinceList=" + this.provinceList + ", typeList=" + this.typeList + ", currentProvinceKey=" + this.currentProvinceKey + ", currentProvinceName=" + this.currentProvinceName + ", preferencesAfterGraduation=" + this.preferencesAfterGraduation + ')';
    }

    public final String getCurrentProvinceKey() {
        return this.currentProvinceKey;
    }

    public final String getCurrentProvinceName() {
        return this.currentProvinceName;
    }

    public final List<String> getPreferencesAfterGraduation() {
        return this.preferencesAfterGraduation;
    }

    public final GaokaoProvinceList getProvinceList() {
        return this.provinceList;
    }

    public final GaokaoTypeList getTypeList() {
        return this.typeList;
    }

    public GaokaoProvinceConfResponse(GaokaoProvinceList r100, GaokaoTypeList r101, String r102, String r103, List<String> r104) {
        this.provinceList = r100;
        this.typeList = r101;
        this.currentProvinceKey = r102;
        this.currentProvinceName = r103;
        this.preferencesAfterGraduation = r104;
    }

    public /* synthetic */ GaokaoProvinceConfResponse(GaokaoProvinceList r100, GaokaoTypeList r101, String r102, String r103, List r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        GaokaoProvinceList r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        GaokaoTypeList r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        List r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
