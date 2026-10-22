package com.ss.android.ugc.aweme.shortvideo.beauty;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.creativex.model.mapping.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016Bc\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003Jg\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020+HÖ\u0001J\t\u00100\u001a\u00020\u0004HÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020+HÖ\u0001R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R \u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u00067"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/beauty/BeautifySegmentInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "mobShootBeautifyName", "", "mobShootBeautifyValue", "mobShootBeautifyCategory", "mobShootMakeupName", "mobShootMakeupValue", "mobShootBodyShapeNameList", "mobShootBodyShapeValueList", "isBeautify", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setBeautify", "(Z)V", "getMobShootBeautifyCategory", "()Ljava/lang/String;", "setMobShootBeautifyCategory", "(Ljava/lang/String;)V", "getMobShootBeautifyName", "setMobShootBeautifyName", "getMobShootBeautifyValue", "setMobShootBeautifyValue", "getMobShootBodyShapeNameList", "setMobShootBodyShapeNameList", "getMobShootBodyShapeValueList", "setMobShootBodyShapeValueList", "getMobShootMakeupName", "setMobShootMakeupName", "getMobShootMakeupValue", "setMobShootMakeupValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class BeautifySegmentInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<BeautifySegmentInfo> CREATOR = null;
    public static final Companion Companion = null;

    @SerializedName("is_beautify")
    private boolean isBeautify;

    @SerializedName("shoot_beautify_category")
    private String mobShootBeautifyCategory;

    @SerializedName("shoot_beautify_name")
    private String mobShootBeautifyName;

    @SerializedName("shoot_beautify_value")
    private String mobShootBeautifyValue;

    @SerializedName("shoot_body_shape_name_list")
    private String mobShootBodyShapeNameList;

    @SerializedName("shoot_body_shape_value_list")
    private String mobShootBodyShapeValueList;

    @SerializedName("shoot_makeup_name")
    private String mobShootMakeupName;

    @SerializedName("shoot_makeup_value")
    private String mobShootMakeupValue;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/beauty/BeautifySegmentInfo$Companion;", "", "<init>", "()V", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<BeautifySegmentInfo> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final BeautifySegmentInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            String r105 = r110.readString();
            String r106 = r110.readString();
            if (r110.readInt() == 0) goto L5;
            boolean r107 = true;
        L7:
            return new BeautifySegmentInfo(r100, r101, r102, r103, r104, r105, r106, r107);
        L5:
            r107 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BeautifySegmentInfo[] newArray(int r100) {
            return new BeautifySegmentInfo[r100];
        }
    }

    static {
        Companion = new Companion(0);
        CREATOR = new Creator();
    }

    public BeautifySegmentInfo() {
        this(null, null, null, null, null, null, null, false, 255, null);
    }

    public static /* synthetic */ BeautifySegmentInfo copy$default(BeautifySegmentInfo r100, String r110, String r111, String r112, String r113, String r114, String r115, String r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.mobShootBeautifyName;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.mobShootBeautifyValue;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.mobShootBeautifyCategory;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.mobShootMakeupName;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.mobShootMakeupValue;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.mobShootBodyShapeNameList;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.mobShootBodyShapeValueList;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.isBeautify;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.mobShootBeautifyName;
    }

    public final String component2() {
        return this.mobShootBeautifyValue;
    }

    public final String component3() {
        return this.mobShootBeautifyCategory;
    }

    public final String component4() {
        return this.mobShootMakeupName;
    }

    public final String component5() {
        return this.mobShootMakeupValue;
    }

    public final String component6() {
        return this.mobShootBodyShapeNameList;
    }

    public final String component7() {
        return this.mobShootBodyShapeValueList;
    }

    public final boolean component8() {
        return this.isBeautify;
    }

    public final BeautifySegmentInfo copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, boolean r117) {
        return new BeautifySegmentInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BeautifySegmentInfo) == false) goto L22;
        BeautifySegmentInfo r101 = (BeautifySegmentInfo) r100;
        if (Intrinsics.areEqual(this.mobShootBeautifyName, r101.mobShootBeautifyName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mobShootBeautifyValue, r101.mobShootBeautifyValue) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mobShootBeautifyCategory, r101.mobShootBeautifyCategory) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mobShootMakeupName, r101.mobShootMakeupName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.mobShootMakeupValue, r101.mobShootMakeupValue) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.mobShootBodyShapeNameList, r101.mobShootBodyShapeNameList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mobShootBodyShapeValueList, r101.mobShootBodyShapeValueList) == true) goto L20;
        return false;
    L20:
        if (this.isBeautify == r101.isBeautify) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.mobShootBeautifyName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.mobShootBeautifyValue;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.mobShootBeautifyCategory;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.mobShootMakeupName;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.mobShootMakeupValue;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.mobShootBodyShapeNameList;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.mobShootBodyShapeValueList;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        int r120 = (r118 + r101) * 31;
        boolean r121 = this.isBeautify;
        ?? r122 = r121;
        if (r121 == false) goto L33;
        r122 = 1;
    L33:
        return r120 + r122;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "BeautifySegmentInfo(mobShootBeautifyName=" + this.mobShootBeautifyName + ", mobShootBeautifyValue=" + this.mobShootBeautifyValue + ", mobShootBeautifyCategory=" + this.mobShootBeautifyCategory + ", mobShootMakeupName=" + this.mobShootMakeupName + ", mobShootMakeupValue=" + this.mobShootMakeupValue + ", mobShootBodyShapeNameList=" + this.mobShootBodyShapeNameList + ", mobShootBodyShapeValueList=" + this.mobShootBodyShapeValueList + ", isBeautify=" + this.isBeautify + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.mobShootBeautifyName);
        r100.writeString(this.mobShootBeautifyValue);
        r100.writeString(this.mobShootBeautifyCategory);
        r100.writeString(this.mobShootMakeupName);
        r100.writeString(this.mobShootMakeupValue);
        r100.writeString(this.mobShootBodyShapeNameList);
        r100.writeString(this.mobShootBodyShapeValueList);
        r100.writeInt(this.isBeautify ? 1 : 0);
    }

    public final String getMobShootBeautifyCategory() {
        return this.mobShootBeautifyCategory;
    }

    public final String getMobShootBeautifyName() {
        return this.mobShootBeautifyName;
    }

    public final String getMobShootBeautifyValue() {
        return this.mobShootBeautifyValue;
    }

    public final String getMobShootBodyShapeNameList() {
        return this.mobShootBodyShapeNameList;
    }

    public final String getMobShootBodyShapeValueList() {
        return this.mobShootBodyShapeValueList;
    }

    public final String getMobShootMakeupName() {
        return this.mobShootMakeupName;
    }

    public final String getMobShootMakeupValue() {
        return this.mobShootMakeupValue;
    }

    public final boolean isBeautify() {
        return this.isBeautify;
    }

    @JvmStatic
    public static final void register(a r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "mapping");
        r100.a(BeautifySegmentInfo.class);
    }

    public final void setBeautify(boolean r100) {
        this.isBeautify = r100;
    }

    public final void setMobShootBeautifyCategory(String r100) {
        this.mobShootBeautifyCategory = r100;
    }

    public final void setMobShootBeautifyName(String r100) {
        this.mobShootBeautifyName = r100;
    }

    public final void setMobShootBeautifyValue(String r100) {
        this.mobShootBeautifyValue = r100;
    }

    public final void setMobShootBodyShapeNameList(String r100) {
        this.mobShootBodyShapeNameList = r100;
    }

    public final void setMobShootBodyShapeValueList(String r100) {
        this.mobShootBodyShapeValueList = r100;
    }

    public final void setMobShootMakeupName(String r100) {
        this.mobShootMakeupName = r100;
    }

    public final void setMobShootMakeupValue(String r100) {
        this.mobShootMakeupValue = r100;
    }

    public BeautifySegmentInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107) {
        this.mobShootBeautifyName = r100;
        this.mobShootBeautifyValue = r101;
        this.mobShootBeautifyCategory = r102;
        this.mobShootMakeupName = r103;
        this.mobShootMakeupValue = r104;
        this.mobShootBodyShapeNameList = r105;
        this.mobShootBodyShapeValueList = r106;
        this.isBeautify = r107;
    }

    public /* synthetic */ BeautifySegmentInfo(String r110, String r111, String r112, String r113, String r114, String r115, String r116, boolean r117, int r118, DefaultConstructorMarker r119) {
        String r100 = "";
        if ((r118 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r118 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r107 = false;
    L34:
        this(r101, r102, r103, r104, r105, r106, r100, r107);
        return;
    L33:
        r107 = r117;
        goto L34
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
