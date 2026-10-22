package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011JJ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0005J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\"\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u0006/"}, d2 = {"Lcom/larus/bmhome/auth/UploadMultiEntityConfig;", "Landroid/os/Parcelable;", "maxFileSize", "", "maxFileCount", "", "maxImageSize", "maxImageCount", "maxTotalCount", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMaxFileSize", "()Ljava/lang/Long;", "setMaxFileSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxFileCount", "()Ljava/lang/Integer;", "setMaxFileCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMaxImageSize", "setMaxImageSize", "getMaxImageCount", "setMaxImageCount", "getMaxTotalCount", "setMaxTotalCount", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/auth/UploadMultiEntityConfig;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadMultiEntityConfig implements Parcelable {
    public static final Parcelable.Creator<UploadMultiEntityConfig> CREATOR = null;

    @SerializedName("max_file_cnt")
    private Integer maxFileCount;

    @SerializedName("max_file_size")
    private Long maxFileSize;

    @SerializedName("max_image_cnt")
    private Integer maxImageCount;

    @SerializedName("max_image_size")
    private Long maxImageSize;

    @SerializedName("max_total_cnt")
    private Integer maxTotalCount;

    public static final class a implements Parcelable.Creator<UploadMultiEntityConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UploadMultiEntityConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Long r101 = null;
        L7:
            if (r100.readInt() != 0) goto L9;
            Integer r102 = null;
        L11:
            if (r100.readInt() != 0) goto L13;
            Long r103 = null;
        L15:
            if (r100.readInt() != 0) goto L17;
            Integer r104 = null;
        L19:
            if (r100.readInt() != 0) goto L21;
            Integer r105 = null;
        L23:
            return new UploadMultiEntityConfig(r101, r102, r103, r104, r105);
        L21:
            r105 = Integer.valueOf(r100.readInt());
            goto L23
        L17:
            r104 = Integer.valueOf(r100.readInt());
            goto L19
        L13:
            r103 = Long.valueOf(r100.readLong());
            goto L15
        L9:
            r102 = Integer.valueOf(r100.readInt());
            goto L11
        L5:
            r101 = Long.valueOf(r100.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UploadMultiEntityConfig[] newArray(int r100) {
            return new UploadMultiEntityConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UploadMultiEntityConfig) == true) goto L8;
        return false;
    L8:
        UploadMultiEntityConfig r101 = (UploadMultiEntityConfig) r100;
        if (Intrinsics.areEqual(this.maxFileSize, r101.maxFileSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxFileCount, r101.maxFileCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxImageSize, r101.maxImageSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxImageCount, r101.maxImageCount) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.maxTotalCount, r101.maxTotalCount) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.maxFileSize;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.maxFileCount;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.maxImageSize;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.maxImageCount;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.maxTotalCount;
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

    public final String toString() {
        return "UploadMultiEntityConfig(maxFileSize=" + this.maxFileSize + ", maxFileCount=" + this.maxFileCount + ", maxImageSize=" + this.maxImageSize + ", maxImageCount=" + this.maxImageCount + ", maxTotalCount=" + this.maxTotalCount + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Long r102 = this.maxFileSize;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.maxFileCount;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Long r104 = this.maxImageSize;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Integer r105 = this.maxImageCount;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        Integer r106 = this.maxTotalCount;
        if (r106 != null) goto L21;
        r100.writeInt(0);
        return;
    L21:
        r100.writeInt(1);
        r100.writeInt(r106.intValue());
        return;
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.intValue());
        goto L18
    L13:
        r100.writeInt(1);
        r100.writeLong(r104.longValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public UploadMultiEntityConfig() {
        this(0L, 0, 0L, 0, 0);
    }

    public UploadMultiEntityConfig(Long r100, Integer r101, Long r102, Integer r103, Integer r104) {
        this.maxFileSize = r100;
        this.maxFileCount = r101;
        this.maxImageSize = r102;
        this.maxImageCount = r103;
        this.maxTotalCount = r104;
    }
}
