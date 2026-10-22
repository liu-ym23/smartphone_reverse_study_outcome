package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011JD\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\bJ\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\bHÖ\u0001J\t\u0010(\u001a\u00020\u0004HÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\bR&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006."}, d2 = {"Lcom/larus/bmhome/auth/AudioUploadMultiEntityConfig;", "Landroid/os/Parcelable;", "allowedTypes", "", "", "maxFileSize", "", "maxFileCount", "", "maxDuration", "<init>", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;)V", "getAllowedTypes", "()Ljava/util/List;", "setAllowedTypes", "(Ljava/util/List;)V", "getMaxFileSize", "()Ljava/lang/Long;", "setMaxFileSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxFileCount", "()Ljava/lang/Integer;", "setMaxFileCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMaxDuration", "setMaxDuration", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/larus/bmhome/auth/AudioUploadMultiEntityConfig;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioUploadMultiEntityConfig implements Parcelable {
    public static final Parcelable.Creator<AudioUploadMultiEntityConfig> CREATOR = null;

    @SerializedName("allow_types")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<String> allowedTypes;

    @SerializedName("max_duration")
    private Long maxDuration;

    @SerializedName("max_cnt")
    private Integer maxFileCount;

    @SerializedName(DownloadSettingKeys.MaxDiskSizeLimit.MAX_SIZE)
    private Long maxFileSize;

    public static final class a implements Parcelable.Creator<AudioUploadMultiEntityConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AudioUploadMultiEntityConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ArrayList<String> r101 = r100.createStringArrayList();
            Long r102 = null;
            if (r100.readInt() != 0) goto L5;
            Long r103 = null;
        L7:
            if (r100.readInt() != 0) goto L9;
            Integer r104 = null;
        L11:
            if (r100.readInt() == 0) goto L15;
            r102 = Long.valueOf(r100.readLong());
        L15:
            return new AudioUploadMultiEntityConfig(r101, r103, r104, r102);
        L9:
            r104 = Integer.valueOf(r100.readInt());
            goto L11
        L5:
            r103 = Long.valueOf(r100.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AudioUploadMultiEntityConfig[] newArray(int r100) {
            return new AudioUploadMultiEntityConfig[r100];
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
        if ((r100 instanceof AudioUploadMultiEntityConfig) == true) goto L8;
        return false;
    L8:
        AudioUploadMultiEntityConfig r101 = (AudioUploadMultiEntityConfig) r100;
        if (Intrinsics.areEqual(this.allowedTypes, r101.allowedTypes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxFileSize, r101.maxFileSize) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxFileCount, r101.maxFileCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxDuration, r101.maxDuration) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.allowedTypes;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.maxFileSize;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.maxFileCount;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.maxDuration;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "AudioUploadMultiEntityConfig(allowedTypes=" + this.allowedTypes + ", maxFileSize=" + this.maxFileSize + ", maxFileCount=" + this.maxFileCount + ", maxDuration=" + this.maxDuration + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeStringList(this.allowedTypes);
        Long r102 = this.maxFileSize;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.maxFileCount;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Long r104 = this.maxDuration;
        if (r104 != null) goto L13;
        r100.writeInt(0);
        return;
    L13:
        r100.writeInt(1);
        r100.writeLong(r104.longValue());
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public AudioUploadMultiEntityConfig() {
        this(null, 0L, 0, 0L);
    }

    public AudioUploadMultiEntityConfig(List<String> r100, Long r101, Integer r102, Long r103) {
        this.allowedTypes = r100;
        this.maxFileSize = r101;
        this.maxFileCount = r102;
        this.maxDuration = r103;
    }
}
