package com.larus.dora.api.model;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.ttvideoengine.model.SubInfo;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0005\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u00108\u001a\u00020\tH\u0016J\u0013\u00109\u001a\u00020\u00152\b\u0010:\u001a\u0004\u0018\u00010;H\u0096\u0002J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010A\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010$J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\u000eHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010K\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00102J\u0016\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00106JÚ\u0001\u0010M\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010NJ\t\u0010O\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b&\u0010$R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b,\u0010\u001dR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b-\u0010\u001dR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b/\u0010\u001dR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b4\u00102R \u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106¨\u0006P"}, d2 = {"Lcom/larus/dora/api/model/MediaInfo;", "Ljava/io/Serializable;", "mediaId", "", "mediaType", "", SubInfo.KEY_FORMAT, "downloadUrl", "width", "", "height", "outVideoWidth", "outVideoHeight", "outputVideoCrop", "", "size", "duration", DBDefinition.MIME_TYPE, "createTime", "mediaName", "hasOcr", "", "hasThumbnail", "thumbnailTypes", "", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;IIDLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;[Ljava/lang/Byte;)V", "getMediaId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMediaType", "()Ljava/lang/String;", "getFormat", "getDownloadUrl", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getOutVideoWidth", "()I", "getOutVideoHeight", "getOutputVideoCrop", "()D", "getSize", "getDuration", "getMimeType", "getCreateTime", "getMediaName", "getHasOcr", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasThumbnail", "getThumbnailTypes", "()[Ljava/lang/Byte;", "[Ljava/lang/Byte;", "hashCode", "equals", "other", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;IIDLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;[Ljava/lang/Byte;)Lcom/larus/dora/api/model/MediaInfo;", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaInfo implements Serializable {

    @SerializedName("create_time")
    private final Long createTime;

    @SerializedName("url")
    private final String downloadUrl;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName(SubInfo.KEY_FORMAT)
    private final String format;

    @SerializedName("has_ocr")
    private final Boolean hasOcr;

    @SerializedName("has_thumbnail")
    private final Boolean hasThumbnail;

    @SerializedName("height")
    private final Integer height;

    @SerializedName(AppConstants.BUNDLE_MEDIA_ID)
    private final Long mediaId;

    @SerializedName("media_name")
    private final String mediaName;

    @SerializedName(a.KEY_MEDIA_TYPE)
    private final String mediaType;

    @SerializedName("mime_type")
    private final String mimeType;

    @SerializedName("out_video_height")
    private final int outVideoHeight;

    @SerializedName("out_video_width")
    private final int outVideoWidth;

    @SerializedName("out_video_crop_radio")
    private final double outputVideoCrop;

    @SerializedName("size")
    private final Long size;

    @SerializedName("thumbnail_types")
    private final Byte[] thumbnailTypes;

    @SerializedName("width")
    private final Integer width;

    public MediaInfo() {
        this(null, null, null, null, null, null, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ MediaInfo copy$default(MediaInfo r110, Long r111, String r112, String r210, String r211, Integer r212, Integer r213, int r214, int r215, double r216, Long r217, Long r218, String r310, Long r311, String r312, Boolean r313, Boolean r314, Byte[] r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        Long r100 = r110.mediaId;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.mediaType;
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = r110.format;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = r110.downloadUrl;
    L19:
        if ((r316 & 16) == 0) goto L21;
        Integer r104 = r110.width;
    L23:
        if ((r316 & 32) == 0) goto L25;
        Integer r105 = r110.height;
    L27:
        if ((r316 & 64) == 0) goto L29;
        int r106 = r110.outVideoWidth;
    L31:
        if ((r316 & 128) == 0) goto L33;
        int r107 = r110.outVideoHeight;
    L35:
        if ((r316 & 256) == 0) goto L37;
        double r113 = r110.outputVideoCrop;
    L39:
        if ((r316 & 512) == 0) goto L41;
        Long r114 = r110.size;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        Long r115 = r110.duration;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r116 = r110.mimeType;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        Long r117 = r110.createTime;
    L54:
        Long r318 = r117;
        if ((r316 & 8192) == 0) goto L57;
        String r118 = r110.mediaName;
    L58:
        String r319 = r118;
        if ((r316 & 16384) == 0) goto L61;
        Boolean r119 = r110.hasOcr;
    L62:
        Boolean r320 = r119;
        if ((r316 & 32768) == 0) goto L65;
        Boolean r120 = r110.hasThumbnail;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        Byte[] r108 = r110.thumbnailTypes;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r318, r319, r320, r120, r108);
    L69:
        r108 = r315;
        goto L71
    L65:
        r120 = r314;
        goto L67
    L61:
        r119 = r313;
        goto L62
    L57:
        r118 = r312;
        goto L58
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Long component1() {
        return this.mediaId;
    }

    public final Long component10() {
        return this.size;
    }

    public final Long component11() {
        return this.duration;
    }

    public final String component12() {
        return this.mimeType;
    }

    public final Long component13() {
        return this.createTime;
    }

    public final String component14() {
        return this.mediaName;
    }

    public final Boolean component15() {
        return this.hasOcr;
    }

    public final Boolean component16() {
        return this.hasThumbnail;
    }

    public final Byte[] component17() {
        return this.thumbnailTypes;
    }

    public final String component2() {
        return this.mediaType;
    }

    public final String component3() {
        return this.format;
    }

    public final String component4() {
        return this.downloadUrl;
    }

    public final Integer component5() {
        return this.width;
    }

    public final Integer component6() {
        return this.height;
    }

    public final int component7() {
        return this.outVideoWidth;
    }

    public final int component8() {
        return this.outVideoHeight;
    }

    public final double component9() {
        return this.outputVideoCrop;
    }

    public final MediaInfo copy(Long r210, String r211, String r212, String r213, Integer r214, Integer r215, int r216, int r217, double r218, Long r310, Long r311, String r312, Long r313, String r314, Boolean r315, Boolean r316, Byte[] r317) {
        return new MediaInfo(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317);
    }

    public String toString() {
        return "MediaInfo(mediaId=" + this.mediaId + ", mediaType=" + this.mediaType + ", format=" + this.format + ", downloadUrl=" + this.downloadUrl + ", width=" + this.width + ", height=" + this.height + ", outVideoWidth=" + this.outVideoWidth + ", outVideoHeight=" + this.outVideoHeight + ", outputVideoCrop=" + this.outputVideoCrop + ", size=" + this.size + ", duration=" + this.duration + ", mimeType=" + this.mimeType + ", createTime=" + this.createTime + ", mediaName=" + this.mediaName + ", hasOcr=" + this.hasOcr + ", hasThumbnail=" + this.hasThumbnail + ", thumbnailTypes=" + Arrays.toString(this.thumbnailTypes) + ')';
    }

    public int hashCode() {
        Long r100 = this.mediaId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.createTime;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getFormat() {
        return this.format;
    }

    public final Boolean getHasOcr() {
        return this.hasOcr;
    }

    public final Boolean getHasThumbnail() {
        return this.hasThumbnail;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Long getMediaId() {
        return this.mediaId;
    }

    public final String getMediaName() {
        return this.mediaName;
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getOutVideoHeight() {
        return this.outVideoHeight;
    }

    public final int getOutVideoWidth() {
        return this.outVideoWidth;
    }

    public final double getOutputVideoCrop() {
        return this.outputVideoCrop;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Byte[] getThumbnailTypes() {
        return this.thumbnailTypes;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MediaInfo) == false) goto L12;
        MediaInfo r101 = (MediaInfo) r100;
        if (Intrinsics.areEqual(this.mediaId, r101.mediaId) == true) goto L7;
    L9:
        return false;
    L7:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == false) goto L9;
        return true;
    L12:
        return super.equals(r100);
    }

    public MediaInfo(Long r100, String r101, String r102, String r103, Integer r104, Integer r105, int r110, int r111, double r112, Long r113, Long r114, String r115, Long r116, String r117, Boolean r118, Boolean r210, Byte[] r211) {
        this.mediaId = r100;
        this.mediaType = r101;
        this.format = r102;
        this.downloadUrl = r103;
        this.width = r104;
        this.height = r105;
        this.outVideoWidth = r110;
        this.outVideoHeight = r111;
        this.outputVideoCrop = r112;
        this.size = r113;
        this.duration = r114;
        this.mimeType = r115;
        this.createTime = r116;
        this.mediaName = r117;
        this.hasOcr = r118;
        this.hasThumbnail = r210;
        this.thumbnailTypes = r211;
    }

    public /* synthetic */ MediaInfo(Long r210, String r211, String r212, String r213, Integer r214, Integer r215, int r216, int r217, double r218, Long r310, Long r311, String r312, Long r313, String r314, Boolean r315, Boolean r316, Byte[] r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r318 & 16) == 0) goto L21;
        Integer r104 = 0;
    L23:
        if ((r318 & 32) == 0) goto L25;
        Integer r105 = 0;
    L27:
        if ((r318 & 64) == 0) goto L29;
        int r106 = TECameraUtils.CAPTURE_NORMAL;
    L31:
        if ((r318 & 128) == 0) goto L33;
        int r110 = 1440;
    L35:
        if ((r318 & 256) == 0) goto L37;
        double r111 = 0.8d;
    L39:
        if ((r318 & 512) == 0) goto L41;
        Long r112 = 0L;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        Long r107 = 0L;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r108 = null;
    L50:
        String r113 = r108;
        if ((r318 & 4096) == 0) goto L53;
        Long r109 = 0L;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r114 = null;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        Boolean r115 = Boolean.FALSE;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        Boolean r116 = Boolean.FALSE;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        Byte[] r117 = new Byte[0];
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r107, r113, r109, r114, r115, r116, r117);
        return;
    L69:
        r117 = r317;
        goto L70
    L65:
        r116 = r316;
        goto L67
    L61:
        r115 = r315;
        goto L63
    L57:
        r114 = r314;
        goto L59
    L53:
        r109 = r313;
        goto L55
    L49:
        r108 = r312;
        goto L50
    L45:
        r107 = r311;
        goto L47
    L41:
        r112 = r310;
        goto L43
    L37:
        r111 = r218;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
