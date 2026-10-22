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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/aiagent/product/feature/ProductSpecialConfig;", "Landroid/os/Parcelable;", "minRomVersion", XmlPullParser.NO_NAMESPACE, "maxRomVersion", "romVersionBlackList", XmlPullParser.NO_NAMESPACE, "minRomReleaseDate", XmlPullParser.NO_NAMESPACE, "maxRomReleaseDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JJ)V", "getMinRomVersion", "()Ljava/lang/String;", "getMaxRomVersion", "getRomVersionBlackList", "()Ljava/util/List;", "getMinRomReleaseDate", "()J", "getMaxRomReleaseDate", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", XmlPullParser.NO_NAMESPACE, "equals", XmlPullParser.NO_NAMESPACE, "other", XmlPullParser.NO_NAMESPACE, "hashCode", "toString", "writeToParcel", XmlPullParser.NO_NAMESPACE, "dest", "Landroid/os/Parcel;", "flags", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
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
        public final ProductSpecialConfig createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new ProductSpecialConfig(r10.readString(), r10.readString(), r10.createStringArrayList(), r10.readLong(), r10.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final ProductSpecialConfig[] newArray(int r1) {
            return new ProductSpecialConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProductSpecialConfig() {
        this(null, null, null, 0, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductSpecialConfig copy$default(ProductSpecialConfig r5, String r6, String r7, List r8, long r9, long r11, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.minRomVersion;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.maxRomVersion;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.romVersionBlackList;
    L11:
        List r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.minRomReleaseDate;
    L14:
        long r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.maxRomReleaseDate;
    L17:
        String r10 = r6;
        return r5.copy(r10, r15, r0, r1, r11);
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

    public final ProductSpecialConfig copy(String r10, String r11, List<String> r12, long r13, long r15) {
        Intrinsics.checkNotNullParameter(r10, "minRomVersion");
        Intrinsics.checkNotNullParameter(r11, "maxRomVersion");
        Intrinsics.checkNotNullParameter(r12, "romVersionBlackList");
        return new ProductSpecialConfig(r10, r11, r12, r13, r15);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ProductSpecialConfig) == true) goto L8;
        return false;
    L8:
        ProductSpecialConfig r9 = (ProductSpecialConfig) r8;
        if (Intrinsics.areEqual(this.minRomVersion, r9.minRomVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxRomVersion, r9.maxRomVersion) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.romVersionBlackList, r9.romVersionBlackList) == true) goto L18;
        return false;
    L18:
        if (this.minRomReleaseDate == r9.minRomReleaseDate) goto L21;
        return false;
    L21:
        if (this.maxRomReleaseDate == r9.maxRomReleaseDate) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.minRomVersion.hashCode() * 31) + this.maxRomVersion.hashCode()) * 31) + this.romVersionBlackList.hashCode()) * 31;
        long r1 = this.minRomReleaseDate;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.maxRomReleaseDate;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public String toString() {
        return "ProductSpecialConfig(minRomVersion=" + this.minRomVersion + ", maxRomVersion=" + this.maxRomVersion + ", romVersionBlackList=" + this.romVersionBlackList + ", minRomReleaseDate=" + this.minRomReleaseDate + ", maxRomReleaseDate=" + this.maxRomReleaseDate + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.minRomVersion);
        r3.writeString(this.maxRomVersion);
        r3.writeStringList(this.romVersionBlackList);
        r3.writeLong(this.minRomReleaseDate);
        r3.writeLong(this.maxRomReleaseDate);
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

    public ProductSpecialConfig(String r2, String r3, List<String> r4, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r2, "minRomVersion");
        Intrinsics.checkNotNullParameter(r3, "maxRomVersion");
        Intrinsics.checkNotNullParameter(r4, "romVersionBlackList");
        this.minRomVersion = r2;
        this.maxRomVersion = r3;
        this.romVersionBlackList = r4;
        this.minRomReleaseDate = r5;
        this.maxRomReleaseDate = r7;
    }

    public /* synthetic */ ProductSpecialConfig(String r5, String r6, List r7, long r8, long r10, int r12, DefaultConstructorMarker r13) {
        int r14 = r12 & 1;
        String r0 = XmlPullParser.NO_NAMESPACE;
        if (r14 == 0) goto L5;
        String r15 = XmlPullParser.NO_NAMESPACE;
    L7:
        if ((r12 & 2) != 0) goto L11;
        r0 = r6;
    L11:
        if ((r12 & 4) == 0) goto L13;
        r7 = CollectionsKt.emptyList();
    L13:
        List r1 = r7;
        if ((r12 & 8) == 0) goto L16;
        long r2 = 0;
    L18:
        if ((r12 & 16) == 0) goto L20;
        long r11 = 0;
    L21:
        this(r15, r0, r1, r2, r11);
        return;
    L20:
        r11 = r10;
        goto L21
    L16:
        r2 = r8;
        goto L18
    L5:
        r15 = r5;
        goto L7
    }
}
