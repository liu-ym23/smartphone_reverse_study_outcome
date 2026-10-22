package com.obric.aiagent.product.feature;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/aiagent/product/feature/ProductSpecialConfig;", "Landroid/os/Parcelable;", "minRomVersion", "", "maxRomVersion", "romVersionBlackList", "", "minRomReleaseDate", "", "maxRomReleaseDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JJ)V", "getMinRomVersion", "()Ljava/lang/String;", "getMaxRomVersion", "getRomVersionBlackList", "()Ljava/util/List;", "getMinRomReleaseDate", "()J", "getMaxRomReleaseDate", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProductSpecialConfig implements Parcelable {
    public static final Parcelable.Creator<ProductSpecialConfig> CREATOR = null;

    @SerializedName("max_rom_release_date")
    private final long maxRomReleaseDate;

    @SerializedName("max_rom_version")
    private final String maxRomVersion;

    @SerializedName("min_rom_release_date")
    private final long minRomReleaseDate;

    @SerializedName("min_rom_version")
    private final String minRomVersion;

    @SerializedName("rom_version_black_list")
    private final List<String> romVersionBlackList;

    public static final class a implements Parcelable.Creator<ProductSpecialConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProductSpecialConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new ProductSpecialConfig(r110.readString(), r110.readString(), r110.createStringArrayList(), r110.readLong(), r110.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final ProductSpecialConfig[] newArray(int r100) {
            return new ProductSpecialConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProductSpecialConfig() {
        this(null, null, null, 0, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductSpecialConfig copy$default(ProductSpecialConfig r100, String r101, String r102, List r103, long r104, long r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.minRomVersion;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.maxRomVersion;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.romVersionBlackList;
    L11:
        List r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.minRomReleaseDate;
    L14:
        long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.maxRomReleaseDate;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final String component1() {
        return this.minRomVersion;
    }

    public final String component2() {
        return this.maxRomVersion;
    }

    public final List<String> component3() {
        return this.romVersionBlackList;
    }

    public final long component4() {
        return this.minRomReleaseDate;
    }

    public final long component5() {
        return this.maxRomReleaseDate;
    }

    public final ProductSpecialConfig copy(String r110, String r111, List<String> r112, long r113, long r114) {
        Intrinsics.checkNotNullParameter(r110, "minRomVersion");
        Intrinsics.checkNotNullParameter(r111, "maxRomVersion");
        Intrinsics.checkNotNullParameter(r112, "romVersionBlackList");
        return new ProductSpecialConfig(r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProductSpecialConfig) == true) goto L8;
        return false;
    L8:
        ProductSpecialConfig r101 = (ProductSpecialConfig) r100;
        if (Intrinsics.areEqual(this.minRomVersion, r101.minRomVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxRomVersion, r101.maxRomVersion) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.romVersionBlackList, r101.romVersionBlackList) == true) goto L18;
        return false;
    L18:
        if (this.minRomReleaseDate == r101.minRomReleaseDate) goto L21;
        return false;
    L21:
        if (this.maxRomReleaseDate == r101.maxRomReleaseDate) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.minRomVersion.hashCode() * 31) + this.maxRomVersion.hashCode()) * 31) + this.romVersionBlackList.hashCode()) * 31;
        long r101 = this.minRomReleaseDate;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.maxRomReleaseDate;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public String toString() {
        return "ProductSpecialConfig(minRomVersion=" + this.minRomVersion + ", maxRomVersion=" + this.maxRomVersion + ", romVersionBlackList=" + this.romVersionBlackList + ", minRomReleaseDate=" + this.minRomReleaseDate + ", maxRomReleaseDate=" + this.maxRomReleaseDate + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.minRomVersion);
        r100.writeString(this.maxRomVersion);
        r100.writeStringList(this.romVersionBlackList);
        r100.writeLong(this.minRomReleaseDate);
        r100.writeLong(this.maxRomReleaseDate);
    }

    public final long getMaxRomReleaseDate() {
        return this.maxRomReleaseDate;
    }

    public final String getMaxRomVersion() {
        return this.maxRomVersion;
    }

    public final long getMinRomReleaseDate() {
        return this.minRomReleaseDate;
    }

    public final String getMinRomVersion() {
        return this.minRomVersion;
    }

    public final List<String> getRomVersionBlackList() {
        return this.romVersionBlackList;
    }

    public ProductSpecialConfig(String r100, String r101, List<String> r102, long r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "minRomVersion");
        Intrinsics.checkNotNullParameter(r101, "maxRomVersion");
        Intrinsics.checkNotNullParameter(r102, "romVersionBlackList");
        this.minRomVersion = r100;
        this.maxRomVersion = r101;
        this.romVersionBlackList = r102;
        this.minRomReleaseDate = r103;
        this.maxRomReleaseDate = r104;
    }

    public /* synthetic */ ProductSpecialConfig(String r100, String r101, List r102, long r103, long r110, int r111, DefaultConstructorMarker r112) {
        String r104 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) != 0) goto L11;
        r104 = r101;
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = CollectionsKt.emptyList();
    L13:
        List r105 = r102;
        if ((r111 & 8) == 0) goto L16;
        long r106 = 0;
    L18:
        if ((r111 & 16) == 0) goto L20;
        long r114 = 0;
    L21:
        this(r113, r104, r105, r106, r114);
        return;
    L20:
        r114 = r110;
        goto L21
    L16:
        r106 = r103;
        goto L18
    L5:
        r113 = r100;
        goto L7
    }
}
