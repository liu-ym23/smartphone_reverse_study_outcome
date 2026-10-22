package com.larus.avlink.gallery.model;

import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.larus.platform.model.GeoLocationInfo;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\t\u0010?\u001a\u00020\u0017HÆ\u0003Jµ\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017HÆ\u0001J\u0013\u0010A\u001a\u00020\u00172\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\fHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010.¨\u0006F"}, d2 = {"Lcom/larus/avlink/gallery/model/ThumbnailMetadata;", "Ljava/io/Serializable;", "fileId", "", "filePath", "fileName", "fileSize", "", "sn", "imageUuid", "mediaType", "width", "", "height", "duration", "createTime", "modifyTime", DBDefinition.DOWNLOAD_TIME, "geoLocationInfo", "Lcom/larus/platform/model/GeoLocationInfo;", "sourceType", "processingStatus", "isSynced", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;IIJJJJLcom/larus/platform/model/GeoLocationInfo;Ljava/lang/String;IZ)V", "getFileId", "()Ljava/lang/String;", "getFilePath", "getFileName", "getFileSize", "()J", "getSn", "getImageUuid", "getMediaType", "getWidth", "()I", "getHeight", "getDuration", "getCreateTime", "getModifyTime", "getDownloadTime", "getGeoLocationInfo", "()Lcom/larus/platform/model/GeoLocationInfo;", "getSourceType", "getProcessingStatus", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbnailMetadata implements Serializable {
    public static final int $stable = 8;
    private final long createTime;
    private final long downloadTime;
    private final long duration;
    private final String fileId;
    private final String fileName;
    private final String filePath;
    private final long fileSize;
    private final GeoLocationInfo geoLocationInfo;
    private final int height;
    private final long imageUuid;
    private final boolean isSynced;
    private final String mediaType;
    private final long modifyTime;
    private final int processingStatus;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    private final String f292621sn;
    private final String sourceType;
    private final int width;

    public static /* synthetic */ ThumbnailMetadata copy$default(ThumbnailMetadata r110, String r111, String r112, String r210, long r211, String r212, long r213, String r214, int r215, int r216, long r217, long r310, long r311, long r312, GeoLocationInfo r313, String r314, int r315, boolean r410, int r411, Object r412) {
        if ((r411 & 1) == 0) goto L5;
        String r100 = r110.fileId;
    L7:
        if ((r411 & 2) == 0) goto L9;
        String r101 = r110.filePath;
    L11:
        if ((r411 & 4) == 0) goto L13;
        String r102 = r110.fileName;
    L15:
        if ((r411 & 8) == 0) goto L17;
        long r103 = r110.fileSize;
    L19:
        if ((r411 & 16) == 0) goto L21;
        String r104 = r110.f292621sn;
    L23:
        if ((r411 & 32) == 0) goto L25;
        long r105 = r110.imageUuid;
    L27:
        if ((r411 & 64) == 0) goto L29;
        String r113 = r110.mediaType;
    L31:
        if ((r411 & 128) == 0) goto L33;
        int r114 = r110.width;
    L35:
        if ((r411 & 256) == 0) goto L37;
        int r115 = r110.height;
    L39:
        if ((r411 & 512) == 0) goto L41;
        long r116 = r110.duration;
    L42:
        long r218 = r116;
        if ((r411 & 1024) == 0) goto L45;
        long r117 = r110.createTime;
    L46:
        long r316 = r117;
        if ((r411 & 2048) == 0) goto L49;
        long r118 = r110.modifyTime;
    L50:
        long r317 = r118;
        if ((r411 & 4096) == 0) goto L53;
        long r119 = r110.downloadTime;
    L55:
        if ((r411 & 8192) == 0) goto L57;
        GeoLocationInfo r120 = r110.geoLocationInfo;
    L58:
        GeoLocationInfo r318 = r120;
        if ((r411 & 16384) == 0) goto L61;
        String r121 = r110.sourceType;
    L62:
        String r319 = r121;
        if ((r411 & 32768) == 0) goto L65;
        int r122 = r110.processingStatus;
    L67:
        if ((r411 & 65536) == 0) goto L69;
        boolean r106 = r110.isSynced;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r113, r114, r115, r218, r316, r317, r119, r318, r319, r122, r106);
    L69:
        r106 = r410;
        goto L71
    L65:
        r122 = r315;
        goto L67
    L61:
        r121 = r314;
        goto L62
    L57:
        r120 = r313;
        goto L58
    L53:
        r119 = r312;
        goto L55
    L49:
        r118 = r311;
        goto L50
    L45:
        r117 = r310;
        goto L46
    L41:
        r116 = r217;
        goto L42
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
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

    public final String component1() {
        return this.fileId;
    }

    public final long component10() {
        return this.duration;
    }

    public final long component11() {
        return this.createTime;
    }

    public final long component12() {
        return this.modifyTime;
    }

    public final long component13() {
        return this.downloadTime;
    }

    public final GeoLocationInfo component14() {
        return this.geoLocationInfo;
    }

    public final String component15() {
        return this.sourceType;
    }

    public final int component16() {
        return this.processingStatus;
    }

    public final boolean component17() {
        return this.isSynced;
    }

    public final String component2() {
        return this.filePath;
    }

    public final String component3() {
        return this.fileName;
    }

    public final long component4() {
        return this.fileSize;
    }

    public final String component5() {
        return this.f292621sn;
    }

    public final long component6() {
        return this.imageUuid;
    }

    public final String component7() {
        return this.mediaType;
    }

    public final int component8() {
        return this.width;
    }

    public final int component9() {
        return this.height;
    }

    public final ThumbnailMetadata copy(String r210, String r211, String r212, long r310, String r311, long r312, String r313, int r314, int r315, long r316, long r410, long r411, long r412, GeoLocationInfo r413, String r414, int r415, boolean r416) {
        Intrinsics.checkNotNullParameter(r210, "fileId");
        Intrinsics.checkNotNullParameter(r211, "filePath");
        Intrinsics.checkNotNullParameter(r212, "fileName");
        Intrinsics.checkNotNullParameter(r311, "sn");
        Intrinsics.checkNotNullParameter(r313, "mediaType");
        Intrinsics.checkNotNullParameter(r414, "sourceType");
        return new ThumbnailMetadata(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ThumbnailMetadata) == true) goto L8;
        return false;
    L8:
        ThumbnailMetadata r101 = (ThumbnailMetadata) r100;
        if (Intrinsics.areEqual(this.fileId, r101.fileId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.filePath, r101.filePath) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L18;
        return false;
    L18:
        if (this.fileSize == r101.fileSize) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f292621sn, r101.f292621sn) == true) goto L24;
        return false;
    L24:
        if (this.imageUuid == r101.imageUuid) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.mediaType, r101.mediaType) == true) goto L30;
        return false;
    L30:
        if (this.width == r101.width) goto L33;
        return false;
    L33:
        if (this.height == r101.height) goto L36;
        return false;
    L36:
        if (this.duration == r101.duration) goto L39;
        return false;
    L39:
        if (this.createTime == r101.createTime) goto L42;
        return false;
    L42:
        if (this.modifyTime == r101.modifyTime) goto L45;
        return false;
    L45:
        if (this.downloadTime == r101.downloadTime) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.geoLocationInfo, r101.geoLocationInfo) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.sourceType, r101.sourceType) == true) goto L54;
        return false;
    L54:
        if (this.processingStatus == r101.processingStatus) goto L57;
        return false;
    L57:
        if (this.isSynced == r101.isSynced) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.fileId.hashCode() * 31) + this.filePath.hashCode()) * 31) + this.fileName.hashCode()) * 31;
        long r101 = this.fileSize;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f292621sn.hashCode()) * 31;
        long r103 = this.imageUuid;
        int r104 = (((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.mediaType.hashCode()) * 31) + this.width) * 31) + this.height) * 31;
        long r105 = this.duration;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.createTime;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.modifyTime;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.downloadTime;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        GeoLocationInfo r113 = this.geoLocationInfo;
        if (r113 != null) goto L5;
        int r114 = 0;
    L6:
        int r115 = (((((r112 + r114) * 31) + this.sourceType.hashCode()) * 31) + this.processingStatus) * 31;
        if (this.isSynced == false) goto L9;
        int r116 = 1231;
    L11:
        return r115 + r116;
    L9:
        r116 = 1237;
        goto L11
    L5:
        r114 = r113.hashCode();
        goto L6
    }

    public String toString() {
        return "ThumbnailMetadata(fileId=" + this.fileId + ", filePath=" + this.filePath + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", sn=" + this.f292621sn + ", imageUuid=" + this.imageUuid + ", mediaType=" + this.mediaType + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", createTime=" + this.createTime + ", modifyTime=" + this.modifyTime + ", downloadTime=" + this.downloadTime + ", geoLocationInfo=" + this.geoLocationInfo + ", sourceType=" + this.sourceType + ", processingStatus=" + this.processingStatus + ", isSynced=" + this.isSynced + ')';
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getDownloadTime() {
        return this.downloadTime;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final GeoLocationInfo getGeoLocationInfo() {
        return this.geoLocationInfo;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getImageUuid() {
        return this.imageUuid;
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    public final long getModifyTime() {
        return this.modifyTime;
    }

    public final int getProcessingStatus() {
        return this.processingStatus;
    }

    public final String getSn() {
        return this.f292621sn;
    }

    public final String getSourceType() {
        return this.sourceType;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isSynced() {
        return this.isSynced;
    }

    public ThumbnailMetadata(String r100, String r110, String r111, long r112, String r113, long r114, String r115, int r116, int r117, long r210, long r211, long r212, long r213, GeoLocationInfo r214, String r215, int r310, boolean r311) {
        Intrinsics.checkNotNullParameter(r100, "fileId");
        Intrinsics.checkNotNullParameter(r110, "filePath");
        Intrinsics.checkNotNullParameter(r111, "fileName");
        Intrinsics.checkNotNullParameter(r113, "sn");
        Intrinsics.checkNotNullParameter(r115, "mediaType");
        Intrinsics.checkNotNullParameter(r215, "sourceType");
        this.fileId = r100;
        this.filePath = r110;
        this.fileName = r111;
        this.fileSize = r112;
        this.f292621sn = r113;
        this.imageUuid = r114;
        this.mediaType = r115;
        this.width = r116;
        this.height = r117;
        this.duration = r210;
        this.createTime = r211;
        this.modifyTime = r212;
        this.downloadTime = r213;
        this.geoLocationInfo = r214;
        this.sourceType = r215;
        this.processingStatus = r310;
        this.isSynced = r311;
    }

    public /* synthetic */ ThumbnailMetadata(String r210, String r211, String r212, long r310, String r311, long r312, String r313, int r314, int r315, long r316, long r410, long r411, long r412, GeoLocationInfo r413, String r414, int r415, boolean r416, int r510, DefaultConstructorMarker r511) {
        if ((r510 & 8192) == 0) goto L5;
        GeoLocationInfo r213 = null;
    L7:
        if ((r510 & 16384) == 0) goto L9;
        String r214 = DocCallbackImpl.KEY_THUMBNAIL;
    L11:
        if ((32768 & r510) == 0) goto L13;
        int r215 = 0;
    L15:
        if ((r510 & 65536) == 0) goto L17;
        boolean r216 = false;
    L18:
        this(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r213, r214, r215, r216);
        return;
    L17:
        r216 = r416;
        goto L18
    L13:
        r215 = r415;
        goto L15
    L9:
        r214 = r414;
        goto L11
    L5:
        r213 = r413;
        goto L7
    }
}
