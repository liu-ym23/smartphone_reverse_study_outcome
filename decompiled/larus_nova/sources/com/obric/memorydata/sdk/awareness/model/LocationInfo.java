package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0006\u0010\u0015\u001a\u00020\u0003J\b\u0010\u0016\u001a\u00020\u0000H\u0002J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0013HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006$"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/LocationInfo;", "Landroid/os/Parcelable;", "locationType", "", "aoiInfo", "Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "updateSource", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;Ljava/lang/String;)V", "getLocationType", "()Ljava/lang/String;", "getAoiInfo", "()Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "getUpdateSource", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "toJson", "withCompatibleDefaults", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "AoiInfo", "CREATOR", "UpdateSource", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationInfo implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("aoi_info")
    private final AoiInfo aoiInfo;

    @SerializedName("location_type")
    private final String locationType;

    @SerializedName("update_source")
    private final String updateSource;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0006\u0010\u0013\u001a\u00020\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0011HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "Landroid/os/Parcelable;", "aoiId", "", "aoiName", "aoiType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAoiId", "()Ljava/lang/String;", "getAoiName", "getAoiType", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "toJson", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AoiInfo implements Parcelable {
        public static final a CREATOR = null;

        @SerializedName("aoi_id")
        private final String aoiId;

        @SerializedName("aoi_name")
        private final String aoiName;

        @SerializedName("aoi_type")
        private final String aoiType;

        /* JADX INFO: loaded from: classes33.dex */
        public static final class a implements Parcelable.Creator<AoiInfo> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final AoiInfo createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                String r101 = r100.readString();
                int r102 = 0;
                if (r101 != null) goto L5;
            L8:
                boolean r103 = true;
            L9:
                AoiInfo r104 = null;
                Object r105 = null;
                if (r103 == false) goto L28;
            L25:
                if (r104 == null) goto L27;
                return r104;
            L27:
                return new AoiInfo(r102);
            L28:
                Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L18
                AoiInfo r107 = (AoiInfo) com.obric.memorydata.sdk.awareness.model.a.f397137a.fromJson(r101, AoiInfo.class);     // Catch: Throwable -> L18
                if (r107 == null) goto L15;
                AoiInfo r108 = com.obric.memorydata.sdk.awareness.model.a.a(r107);     // Catch: Throwable -> L18
            L16:
                Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L18
            L21:
                if (Result.m9455isFailureimpl(r109) == true) goto L24;
                r105 = r109;
            L24:
                r104 = (AoiInfo) r105;
                goto L25
            L15:
                r108 = null;
            L18:
                th = move-exception;
                Result.Companion r110 = Result.Companion;
                r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
                goto L21
            L5:
                if (StringsKt.isBlank(r101) == true) goto L8;
                r103 = false;
                goto L9
            }

            @Override // android.os.Parcelable.Creator
            public final AoiInfo[] newArray(int r100) {
                return new AoiInfo[r100];
            }
        }

        public AoiInfo() {
            this(0);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AoiInfo) == true) goto L8;
            return false;
        L8:
            AoiInfo r101 = (AoiInfo) r100;
            if (Intrinsics.areEqual(this.aoiId, r101.aoiId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.aoiName, r101.aoiName) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.aoiType, r101.aoiType) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.aoiId.hashCode() * 31) + this.aoiName.hashCode()) * 31) + this.aoiType.hashCode();
        }

        public final String toString() {
            return "AoiInfo(aoiId=" + this.aoiId + ", aoiName=" + this.aoiName + ", aoiType=" + this.aoiType + ')';
        }

        static {
            CREATOR = new a();
        }

        public final String a() {
            return this.aoiId;
        }

        public final String b() {
            return this.aoiName;
        }

        public final String c() {
            return this.aoiType;
        }

        public /* synthetic */ AoiInfo(int r100) {
            this("", "", "");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            r100.writeString(GsonProtectorUtils.toJson(com.obric.memorydata.sdk.awareness.model.a.f397137a, this));
        }

        public AoiInfo(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "aoiId");
            Intrinsics.checkNotNullParameter(r101, "aoiName");
            Intrinsics.checkNotNullParameter(r102, "aoiType");
            this.aoiId = r100;
            this.aoiName = r101;
            this.aoiType = r102;
        }
    }

    public static final class a implements Parcelable.Creator<LocationInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocationInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            int r102 = 0;
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            LocationInfo r104 = null;
            Object r105 = null;
            if (r103 == false) goto L28;
        L25:
            if (r104 == null) goto L27;
            return r104;
        L27:
            return new LocationInfo(r102);
        L28:
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L18
            LocationInfo r107 = (LocationInfo) com.obric.memorydata.sdk.awareness.model.a.f397137a.fromJson(r101, LocationInfo.class);     // Catch: Throwable -> L18
            if (r107 == null) goto L15;
            LocationInfo r108 = LocationInfo.a(r107);     // Catch: Throwable -> L18
        L16:
            Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L18
        L21:
            if (Result.m9455isFailureimpl(r109) == true) goto L24;
            r105 = r109;
        L24:
            r104 = (LocationInfo) r105;
            goto L25
        L15:
            r108 = null;
        L18:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L21
        L5:
            if (StringsKt.isBlank(r101) == true) goto L8;
            r103 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final LocationInfo[] newArray(int r100) {
            return new LocationInfo[r100];
        }
    }

    public LocationInfo() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocationInfo) == true) goto L8;
        return false;
    L8:
        LocationInfo r101 = (LocationInfo) r100;
        if (Intrinsics.areEqual(this.locationType, r101.locationType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aoiInfo, r101.aoiInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.updateSource, r101.updateSource) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.locationType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        AoiInfo r104 = this.aoiInfo;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.updateSource.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocationInfo(locationType=" + this.locationType + ", aoiInfo=" + this.aoiInfo + ", updateSource=" + this.updateSource + ')';
    }

    static {
        CREATOR = new a();
    }

    public /* synthetic */ LocationInfo(int r100) {
        this(null, null, "");
    }

    public static final LocationInfo a(LocationInfo r100) {
        String r101 = r100.locationType;
        AoiInfo r102 = r100.aoiInfo;
        if (r102 == null) goto L5;
        AoiInfo r103 = com.obric.memorydata.sdk.awareness.model.a.a(r102);
    L6:
        String r104 = r100.updateSource;
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        return new LocationInfo(r101, r103, r104);
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(GsonProtectorUtils.toJson(com.obric.memorydata.sdk.awareness.model.a.f397137a, this));
    }

    public LocationInfo(String r100, AoiInfo r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "updateSource");
        this.locationType = r100;
        this.aoiInfo = r101;
        this.updateSource = r102;
    }
}
