package com.larus.bmhome.view.actionbar.gaokao.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\u001b\u0010#\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010&\u001a\u00020'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020'HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020'R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R(\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R0\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u00063"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/model/GaokaoType;", "Landroid/os/Parcelable;", "code", "", "name", "selectedMajor", "", "reselectedMajor", "selectedMajorRankTypeMap", "", "defaultRankType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getName", "setName", "getSelectedMajor", "()Ljava/util/List;", "setSelectedMajor", "(Ljava/util/List;)V", "getReselectedMajor", "setReselectedMajor", "getSelectedMajorRankTypeMap", "()Ljava/util/Map;", "setSelectedMajorRankTypeMap", "(Ljava/util/Map;)V", "getDefaultRankType", "setDefaultRankType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoType implements Parcelable {
    public static final Parcelable.Creator<GaokaoType> CREATOR = null;

    @SerializedName("code")
    private String code;

    @SerializedName("default_rank_type")
    private String defaultRankType;

    @SerializedName("name")
    private String name;

    @SerializedName("reselected_major")
    private List<String> reselectedMajor;

    @SerializedName("selected_major")
    private List<String> selectedMajor;

    @SerializedName("selected_major_rank_type_map")
    private Map<String, String> selectedMajorRankTypeMap;

    public static final class a implements Parcelable.Creator<GaokaoType> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GaokaoType createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            ArrayList<String> r102 = r110.createStringArrayList();
            ArrayList<String> r103 = r110.createStringArrayList();
            if (r110.readInt() != 0) goto L5;
            LinkedHashMap r104 = null;
        L10:
            return new GaokaoType(r100, r101, r102, r103, r104, r110.readString());
        L5:
            int r105 = r110.readInt();
            LinkedHashMap r106 = new LinkedHashMap(r105);
            int r107 = 0;
        L6:
            if (r107 == r105) goto L8;
            r106.put(r110.readString(), r110.readString());
            r107 = r107 + 1;
            goto L6
        L8:
            r104 = r106;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final GaokaoType[] newArray(int r100) {
            return new GaokaoType[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public GaokaoType() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GaokaoType copy$default(GaokaoType r100, String r101, String r102, List r103, List r104, Map r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.name;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.selectedMajor;
    L11:
        List r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.reselectedMajor;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.selectedMajorRankTypeMap;
    L17:
        Map r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.defaultRankType;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.name;
    }

    public final List<String> component3() {
        return this.selectedMajor;
    }

    public final List<String> component4() {
        return this.reselectedMajor;
    }

    public final Map<String, String> component5() {
        return this.selectedMajorRankTypeMap;
    }

    public final String component6() {
        return this.defaultRankType;
    }

    public final GaokaoType copy(String r100, String r110, List<String> r111, List<String> r112, Map<String, String> r113, String r114) {
        return new GaokaoType(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GaokaoType) == true) goto L8;
        return false;
    L8:
        GaokaoType r101 = (GaokaoType) r100;
        if (Intrinsics.areEqual(this.code, r101.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.selectedMajor, r101.selectedMajor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reselectedMajor, r101.reselectedMajor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.selectedMajorRankTypeMap, r101.selectedMajorRankTypeMap) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.defaultRankType, r101.defaultRankType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.code;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.selectedMajor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.reselectedMajor;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.selectedMajorRankTypeMap;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.defaultRankType;
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
        return "GaokaoType(code=" + this.code + ", name=" + this.name + ", selectedMajor=" + this.selectedMajor + ", reselectedMajor=" + this.reselectedMajor + ", selectedMajorRankTypeMap=" + this.selectedMajorRankTypeMap + ", defaultRankType=" + this.defaultRankType + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.code);
        r100.writeString(this.name);
        r100.writeStringList(this.selectedMajor);
        r100.writeStringList(this.reselectedMajor);
        Map<String, String> r102 = this.selectedMajorRankTypeMap;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        r100.writeString(this.defaultRankType);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, String> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeString(r104.getValue());
        goto L7
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDefaultRankType() {
        return this.defaultRankType;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getReselectedMajor() {
        return this.reselectedMajor;
    }

    public final List<String> getSelectedMajor() {
        return this.selectedMajor;
    }

    public final Map<String, String> getSelectedMajorRankTypeMap() {
        return this.selectedMajorRankTypeMap;
    }

    public final void setCode(String r100) {
        this.code = r100;
    }

    public final void setDefaultRankType(String r100) {
        this.defaultRankType = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setReselectedMajor(List<String> r100) {
        this.reselectedMajor = r100;
    }

    public final void setSelectedMajor(List<String> r100) {
        this.selectedMajor = r100;
    }

    public final void setSelectedMajorRankTypeMap(Map<String, String> r100) {
        this.selectedMajorRankTypeMap = r100;
    }

    public GaokaoType(String r100, String r101, List<String> r102, List<String> r103, Map<String, String> r104, String r105) {
        this.code = r100;
        this.name = r101;
        this.selectedMajor = r102;
        this.reselectedMajor = r103;
        this.selectedMajorRankTypeMap = r104;
        this.defaultRankType = r105;
    }

    public /* synthetic */ GaokaoType(String r100, String r101, List r102, List r103, Map r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r112 & 4) == 0) goto L13;
        r102 = new ArrayList();
    L13:
        List r105 = r102;
        if ((r112 & 8) == 0) goto L16;
        r103 = new ArrayList();
    L16:
        List r106 = r103;
        if ((r112 & 16) == 0) goto L19;
        r110 = MapsKt.emptyMap();
    L19:
        Map r107 = r110;
        if ((r112 & 32) == 0) goto L22;
        String r115 = "";
    L23:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L22:
        r115 = r111;
        goto L23
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
