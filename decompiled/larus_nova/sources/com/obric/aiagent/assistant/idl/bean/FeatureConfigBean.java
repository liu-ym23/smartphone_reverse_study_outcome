package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u0007J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006("}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/FeatureConfigBean;", "Landroid/os/Parcelable;", "enabled", "", "minRomVersion", "", "minRomReleaseDate", "", "maxRomVersion", "maxRomReleaseDate", "productNameList", "<init>", "(ZLjava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getEnabled", "()Z", "getMinRomVersion", "()Ljava/lang/String;", "getMinRomReleaseDate", "()I", "getMaxRomVersion", "getMaxRomReleaseDate", "getProductNameList", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureConfigBean implements Parcelable {
    public static final Parcelable.Creator<FeatureConfigBean> CREATOR = null;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("max_rom_release_date")
    private final int maxRomReleaseDate;

    @SerializedName("max_rom_version")
    private final String maxRomVersion;

    @SerializedName("min_rom_release_date")
    private final int minRomReleaseDate;

    @SerializedName("min_rom_version")
    private final String minRomVersion;

    @SerializedName("product_name_list")
    private final String productNameList;

    public static final class a implements Parcelable.Creator<FeatureConfigBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureConfigBean createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            return new FeatureConfigBean(r101, r100.readString(), r100.readInt(), r100.readString(), r100.readInt(), r100.readString());
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureConfigBean[] newArray(int r100) {
            return new FeatureConfigBean[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FeatureConfigBean() {
        this(false, null, 0, null, 0, null, 63, null);
    }

    public static /* synthetic */ FeatureConfigBean copy$default(FeatureConfigBean r100, boolean r101, String r102, int r103, String r104, int r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.enabled;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.minRomVersion;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.minRomReleaseDate;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.maxRomVersion;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.maxRomReleaseDate;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.productNameList;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.minRomVersion;
    }

    public final int component3() {
        return this.minRomReleaseDate;
    }

    public final String component4() {
        return this.maxRomVersion;
    }

    public final int component5() {
        return this.maxRomReleaseDate;
    }

    public final String component6() {
        return this.productNameList;
    }

    public final FeatureConfigBean copy(boolean r100, String r110, int r111, String r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "minRomVersion");
        Intrinsics.checkNotNullParameter(r112, "maxRomVersion");
        Intrinsics.checkNotNullParameter(r114, "productNameList");
        return new FeatureConfigBean(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeatureConfigBean) == true) goto L8;
        return false;
    L8:
        FeatureConfigBean r101 = (FeatureConfigBean) r100;
        if (this.enabled == r101.enabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minRomVersion, r101.minRomVersion) == true) goto L15;
        return false;
    L15:
        if (this.minRomReleaseDate == r101.minRomReleaseDate) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxRomVersion, r101.maxRomVersion) == true) goto L21;
        return false;
    L21:
        if (this.maxRomReleaseDate == r101.maxRomReleaseDate) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.productNameList, r101.productNameList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        if (this.enabled == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((((((r100 * 31) + this.minRomVersion.hashCode()) * 31) + this.minRomReleaseDate) * 31) + this.maxRomVersion.hashCode()) * 31) + this.maxRomReleaseDate) * 31) + this.productNameList.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "FeatureConfigBean(enabled=" + this.enabled + ", minRomVersion=" + this.minRomVersion + ", minRomReleaseDate=" + this.minRomReleaseDate + ", maxRomVersion=" + this.maxRomVersion + ", maxRomReleaseDate=" + this.maxRomReleaseDate + ", productNameList=" + this.productNameList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.enabled ? 1 : 0);
        r100.writeString(this.minRomVersion);
        r100.writeInt(this.minRomReleaseDate);
        r100.writeString(this.maxRomVersion);
        r100.writeInt(this.maxRomReleaseDate);
        r100.writeString(this.productNameList);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getMaxRomReleaseDate() {
        return this.maxRomReleaseDate;
    }

    public final String getMaxRomVersion() {
        return this.maxRomVersion;
    }

    public final int getMinRomReleaseDate() {
        return this.minRomReleaseDate;
    }

    public final String getMinRomVersion() {
        return this.minRomVersion;
    }

    public final String getProductNameList() {
        return this.productNameList;
    }

    public FeatureConfigBean(boolean r100, String r101, int r102, String r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "minRomVersion");
        Intrinsics.checkNotNullParameter(r103, "maxRomVersion");
        Intrinsics.checkNotNullParameter(r105, "productNameList");
        this.enabled = r100;
        this.minRomVersion = r101;
        this.minRomReleaseDate = r102;
        this.maxRomVersion = r103;
        this.maxRomReleaseDate = r104;
        this.productNameList = r105;
    }

    public /* synthetic */ FeatureConfigBean(boolean r100, String r101, int r102, String r103, int r104, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = true;
    L5:
        String r105 = "";
        if ((r111 & 2) == 0) goto L8;
        String r113 = "";
    L9:
        int r106 = 0;
        if ((r111 & 4) == 0) goto L12;
        int r107 = 0;
    L14:
        if ((r111 & 8) == 0) goto L16;
        String r108 = "";
    L18:
        if ((r111 & 16) != 0) goto L22;
        r106 = r104;
    L22:
        if ((r111 & 32) != 0) goto L25;
        r105 = r110;
    L25:
        this(r100, r113, r107, r108, r106, r105);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L9
    }
}
