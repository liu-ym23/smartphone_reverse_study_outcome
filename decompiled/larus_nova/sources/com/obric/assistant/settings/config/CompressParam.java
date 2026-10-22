package com.obric.assistant.settings.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0001&BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0006J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lcom/obric/assistant/settings/config/CompressParam;", "Landroid/os/Parcelable;", "scene", "", "id", "shortSize", "", GearStrategyConsts.EV_QUALITY, "compressThreshold", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getScene", "()Ljava/lang/String;", "getId", "getShortSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuality", "getCompressThreshold", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/assistant/settings/config/CompressParam;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CompressParam implements Parcelable {
    public static final Parcelable.Creator<CompressParam> CREATOR = null;
    public static final a Companion = null;
    public static final String ID_NO_COMPRESS = "no_compress";

    @SerializedName("compress_threshold")
    private final Integer compressThreshold;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f392011id;

    @SerializedName(GearStrategyConsts.EV_QUALITY)
    private final Integer quality;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("short_size")
    private final Integer shortSize;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Parcelable.Creator<CompressParam> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final CompressParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Integer r103 = null;
        L7:
            if (r100.readInt() != 0) goto L9;
            Integer r104 = null;
        L11:
            if (r100.readInt() != 0) goto L13;
            Integer r105 = null;
        L15:
            return new CompressParam(r101, r102, r103, r104, r105);
        L13:
            r105 = Integer.valueOf(r100.readInt());
            goto L15
        L9:
            r104 = Integer.valueOf(r100.readInt());
            goto L11
        L5:
            r103 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CompressParam[] newArray(int r100) {
            return new CompressParam[r100];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    public CompressParam() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CompressParam copy$default(CompressParam r100, String r101, String r102, Integer r103, Integer r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.scene;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.f392011id;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.shortSize;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.quality;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.compressThreshold;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.scene;
    }

    public final String component2() {
        return this.f392011id;
    }

    public final Integer component3() {
        return this.shortSize;
    }

    public final Integer component4() {
        return this.quality;
    }

    public final Integer component5() {
        return this.compressThreshold;
    }

    public final CompressParam copy(String r100, String r101, Integer r110, Integer r111, Integer r112) {
        return new CompressParam(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CompressParam) == true) goto L8;
        return false;
    L8:
        CompressParam r101 = (CompressParam) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392011id, r101.f392011id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.shortSize, r101.shortSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.quality, r101.quality) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.compressThreshold, r101.compressThreshold) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.scene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f392011id;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.shortSize;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.quality;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.compressThreshold;
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
        return "CompressParam(scene=" + this.scene + ", id=" + this.f392011id + ", shortSize=" + this.shortSize + ", quality=" + this.quality + ", compressThreshold=" + this.compressThreshold + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.scene);
        r100.writeString(this.f392011id);
        Integer r102 = this.shortSize;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.quality;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Integer r104 = this.compressThreshold;
        if (r104 != null) goto L13;
        r100.writeInt(0);
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final Integer getCompressThreshold() {
        return this.compressThreshold;
    }

    public final String getId() {
        return this.f392011id;
    }

    public final Integer getQuality() {
        return this.quality;
    }

    public final String getScene() {
        return this.scene;
    }

    public final Integer getShortSize() {
        return this.shortSize;
    }

    public CompressParam(String r100, String r101, Integer r102, Integer r103, Integer r104) {
        this.scene = r100;
        this.f392011id = r101;
        this.shortSize = r102;
        this.quality = r103;
        this.compressThreshold = r104;
    }

    public /* synthetic */ CompressParam(String r100, String r101, Integer r102, Integer r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Integer r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Integer r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
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
