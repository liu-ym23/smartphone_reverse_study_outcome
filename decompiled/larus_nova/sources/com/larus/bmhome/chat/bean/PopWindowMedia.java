package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jz\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\u0003J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0007HÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00066"}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowMedia;", "Landroid/os/Parcelable;", "mediaType", "", "size", "Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;", "mediaUri", "", "mediaUrl", "mediaDarkUri", "mediaDarkUrl", "videoCoverUri", "videoCoverUrl", "color", "Lcom/larus/bmhome/chat/bean/PopWindowColor;", "<init>", "(Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/PopWindowColor;)V", "getMediaType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSize", "()Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;", "getMediaUri", "()Ljava/lang/String;", "getMediaUrl", "getMediaDarkUri", "getMediaDarkUrl", "getVideoCoverUri", "getVideoCoverUrl", "getColor", "()Lcom/larus/bmhome/chat/bean/PopWindowColor;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/PopWindowColor;)Lcom/larus/bmhome/chat/bean/PopWindowMedia;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopWindowMedia implements Parcelable {
    public static final Parcelable.Creator<PopWindowMedia> CREATOR = null;

    @SerializedName("color")
    private final PopWindowColor color;

    @SerializedName("media_dark_uri")
    private final String mediaDarkUri;

    @SerializedName("media_dark_url")
    private final String mediaDarkUrl;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE)
    private final Integer mediaType;

    @SerializedName("media_uri")
    private final String mediaUri;

    @SerializedName("media_url")
    private final String mediaUrl;

    @SerializedName("size")
    private final PopWindowMediaSize size;

    @SerializedName("video_cover_uri")
    private final String videoCoverUri;

    @SerializedName("video_cover_url")
    private final String videoCoverUrl;

    public static final class a implements Parcelable.Creator<PopWindowMedia> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowMedia createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            PopWindowColor r100 = null;
            if (r110.readInt() != 0) goto L5;
            Integer r101 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            PopWindowMediaSize r102 = null;
        L10:
            PopWindowMediaSize r103 = r102;
            String r104 = r110.readString();
            String r105 = r110.readString();
            String r106 = r110.readString();
            String r107 = r110.readString();
            String r108 = r110.readString();
            String r111 = r110.readString();
            if (r110.readInt() == 0) goto L15;
            r100 = PopWindowColor.CREATOR.createFromParcel(r110);
        L15:
            return new PopWindowMedia(r101, r103, r104, r105, r106, r107, r108, r111, r100);
        L9:
            r102 = PopWindowMediaSize.CREATOR.createFromParcel(r110);
            goto L10
        L5:
            r101 = Integer.valueOf(r110.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowMedia[] newArray(int r100) {
            return new PopWindowMedia[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowMedia() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ PopWindowMedia copy$default(PopWindowMedia r110, Integer r111, PopWindowMediaSize r112, String r113, String r114, String r115, String r116, String r117, String r118, PopWindowColor r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Integer r100 = r110.mediaType;
    L7:
        if ((r210 & 2) == 0) goto L9;
        PopWindowMediaSize r101 = r110.size;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.mediaUri;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.mediaUrl;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.mediaDarkUri;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.mediaDarkUrl;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.videoCoverUri;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.videoCoverUrl;
    L35:
        if ((r210 & 256) == 0) goto L37;
        PopWindowColor r108 = r110.color;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Integer component1() {
        return this.mediaType;
    }

    public final PopWindowMediaSize component2() {
        return this.size;
    }

    public final String component3() {
        return this.mediaUri;
    }

    public final String component4() {
        return this.mediaUrl;
    }

    public final String component5() {
        return this.mediaDarkUri;
    }

    public final String component6() {
        return this.mediaDarkUrl;
    }

    public final String component7() {
        return this.videoCoverUri;
    }

    public final String component8() {
        return this.videoCoverUrl;
    }

    public final PopWindowColor component9() {
        return this.color;
    }

    public final PopWindowMedia copy(Integer r110, PopWindowMediaSize r111, String r112, String r113, String r114, String r115, String r116, String r117, PopWindowColor r210) {
        return new PopWindowMedia(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PopWindowMedia) == true) goto L8;
        return false;
    L8:
        PopWindowMedia r101 = (PopWindowMedia) r100;
        if (Intrinsics.areEqual(this.mediaType, r101.mediaType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mediaUri, r101.mediaUri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mediaUrl, r101.mediaUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mediaDarkUri, r101.mediaDarkUri) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mediaDarkUrl, r101.mediaDarkUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.videoCoverUri, r101.videoCoverUri) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.videoCoverUrl, r101.videoCoverUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.mediaType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PopWindowMediaSize r104 = this.size;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.mediaUri;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.mediaUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.mediaDarkUri;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.mediaDarkUrl;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.videoCoverUri;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.videoCoverUrl;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        PopWindowColor r125 = this.color;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "PopWindowMedia(mediaType=" + this.mediaType + ", size=" + this.size + ", mediaUri=" + this.mediaUri + ", mediaUrl=" + this.mediaUrl + ", mediaDarkUri=" + this.mediaDarkUri + ", mediaDarkUrl=" + this.mediaDarkUrl + ", videoCoverUri=" + this.videoCoverUri + ", videoCoverUrl=" + this.videoCoverUrl + ", color=" + this.color + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Integer r102 = this.mediaType;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        PopWindowMediaSize r103 = this.size;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.mediaUri);
        r100.writeString(this.mediaUrl);
        r100.writeString(this.mediaDarkUri);
        r100.writeString(this.mediaDarkUrl);
        r100.writeString(this.videoCoverUri);
        r100.writeString(this.videoCoverUrl);
        PopWindowColor r104 = this.color;
        if (r104 != null) goto L13;
        r100.writeInt(0);
        return;
    L13:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        return;
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final PopWindowColor getColor() {
        return this.color;
    }

    public final String getMediaDarkUri() {
        return this.mediaDarkUri;
    }

    public final String getMediaDarkUrl() {
        return this.mediaDarkUrl;
    }

    public final Integer getMediaType() {
        return this.mediaType;
    }

    public final String getMediaUri() {
        return this.mediaUri;
    }

    public final String getMediaUrl() {
        return this.mediaUrl;
    }

    public final PopWindowMediaSize getSize() {
        return this.size;
    }

    public final String getVideoCoverUri() {
        return this.videoCoverUri;
    }

    public final String getVideoCoverUrl() {
        return this.videoCoverUrl;
    }

    public PopWindowMedia(Integer r100, PopWindowMediaSize r101, String r102, String r103, String r104, String r105, String r106, String r107, PopWindowColor r108) {
        this.mediaType = r100;
        this.size = r101;
        this.mediaUri = r102;
        this.mediaUrl = r103;
        this.mediaDarkUri = r104;
        this.mediaDarkUrl = r105;
        this.videoCoverUri = r106;
        this.videoCoverUrl = r107;
        this.color = r108;
    }

    public /* synthetic */ PopWindowMedia(Integer r110, PopWindowMediaSize r111, String r112, String r113, String r114, String r115, String r116, String r117, PopWindowColor r118, int r210, DefaultConstructorMarker r211) {
        PopWindowColor r100 = null;
        if ((r210 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        PopWindowMediaSize r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
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
}
