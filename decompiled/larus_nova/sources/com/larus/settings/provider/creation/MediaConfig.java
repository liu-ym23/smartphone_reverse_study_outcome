package com.larus.settings.provider.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 42\u00020\u0001:\u00014Be\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u000e\u0010\u0012J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001eJl\u0010-\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001e¨\u00065"}, d2 = {"Lcom/larus/settings/provider/creation/MediaConfig;", "Landroid/os/Parcelable;", "type", "", "lightModeUrl", "", "darkModeUrl", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "lightVideoModel", "darkVideoModel", "showTrumpet", "", "videoDefaultMute", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getType", "()I", "getLightModeUrl", "()Ljava/lang/String;", "getDarkModeUrl", "getRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLightVideoModel", "getDarkVideoModel", "getShowTrumpet", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVideoDefaultMute", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/settings/provider/creation/MediaConfig;", "equals", "other", "", "hashCode", "toString", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaConfig implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("dark_mode_url")
    private final String darkModeUrl;

    @SerializedName("dark_video_model")
    private final String darkVideoModel;

    @SerializedName("light_mode_url")
    private final String lightModeUrl;

    @SerializedName("light_video_model")
    private final String lightVideoModel;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    private final Float ratio;

    @SerializedName("show_trumpet")
    private final Boolean showTrumpet;

    @SerializedName("type")
    private final int type;

    @SerializedName("video_default_mute")
    private final Boolean videoDefaultMute;

    public static final class a implements Parcelable.Creator<MediaConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MediaConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = r110.readInt();
            String r101 = r110.readString();
            String r102 = r110.readString();
            Float r103 = Float.valueOf(r110.readFloat());
            String r104 = r110.readString();
            String r105 = r110.readString();
            Class r106 = Boolean.TYPE;
            Object r107 = r110.readValue(r106.getClassLoader());
            Boolean r108 = null;
            if ((r107 instanceof Boolean) == false) goto L5;
            Boolean r109 = (Boolean) r107;
        L6:
            Object r111 = r110.readValue(r106.getClassLoader());
            if ((r111 instanceof Boolean) == false) goto L10;
            r108 = (Boolean) r111;
        L10:
            return new MediaConfig(r100, r101, r102, r103, r104, r105, r109, r108);
        L5:
            r109 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final MediaConfig[] newArray(int r100) {
            return new MediaConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public MediaConfig() {
        this(0, null, null, null, null, null, Boolean.FALSE, Boolean.TRUE);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaConfig) == true) goto L8;
        return false;
    L8:
        MediaConfig r101 = (MediaConfig) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lightModeUrl, r101.lightModeUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.darkModeUrl, r101.darkModeUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ratio, r101.ratio) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lightVideoModel, r101.lightVideoModel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.darkVideoModel, r101.darkVideoModel) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.showTrumpet, r101.showTrumpet) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.videoDefaultMute, r101.videoDefaultMute) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.type * 31;
        String r101 = this.lightModeUrl;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.darkModeUrl;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Float r108 = this.ratio;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.lightVideoModel;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.darkVideoModel;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Boolean r117 = this.showTrumpet;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Boolean r120 = this.videoDefaultMute;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MediaConfig(type=" + this.type + ", lightModeUrl=" + this.lightModeUrl + ", darkModeUrl=" + this.darkModeUrl + ", ratio=" + this.ratio + ", lightVideoModel=" + this.lightVideoModel + ", darkVideoModel=" + this.darkVideoModel + ", showTrumpet=" + this.showTrumpet + ", videoDefaultMute=" + this.videoDefaultMute + ')';
    }

    public final String a() {
        return this.darkModeUrl;
    }

    public final String b() {
        return this.darkVideoModel;
    }

    public final String c() {
        return this.lightModeUrl;
    }

    public final String d() {
        return this.lightVideoModel;
    }

    public final Float e() {
        return this.ratio;
    }

    public final Boolean g() {
        return this.showTrumpet;
    }

    public final int getType() {
        return this.type;
    }

    public final Boolean h() {
        return this.videoDefaultMute;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.type);
        r100.writeString(this.lightModeUrl);
        r100.writeString(this.darkModeUrl);
        Float r102 = this.ratio;
        if (r102 == null) goto L5;
        float r103 = r102.floatValue();
    L6:
        r100.writeFloat(r103);
        r100.writeString(this.lightVideoModel);
        r100.writeString(this.darkVideoModel);
        r100.writeValue(this.showTrumpet);
        r100.writeValue(this.videoDefaultMute);
        return;
    L5:
        r103 = 1.0f;
        goto L6
    }

    public MediaConfig(@MediaType int r100, String r101, String r102, Float r103, String r104, String r105, Boolean r106, Boolean r107) {
        this.type = r100;
        this.lightModeUrl = r101;
        this.darkModeUrl = r102;
        this.ratio = r103;
        this.lightVideoModel = r104;
        this.darkVideoModel = r105;
        this.showTrumpet = r106;
        this.videoDefaultMute = r107;
    }
}
