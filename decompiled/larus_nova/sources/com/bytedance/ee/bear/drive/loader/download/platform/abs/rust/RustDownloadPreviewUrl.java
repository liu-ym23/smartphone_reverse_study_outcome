package com.bytedance.ee.bear.drive.loader.download.platform.abs.rust;

import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$DownloadPriority;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.java.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J_\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/abs/rust/RustDownloadPreviewUrl;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/abs/rust/IRustDownload;", "localFilePath", "", "fileSize", "", "previewUrl", "dataVersion", "mountPoint", "extra", "priority", "Lcom/bytedance/ee/bear/middleground/drive/export/DrivePriority$DownloadPriority;", "downloadCallback", "Lcom/bytedance/ee/bear/middleground/drive/export/DownloadCallback;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/middleground/drive/export/DrivePriority$DownloadPriority;Lcom/bytedance/ee/bear/middleground/drive/export/DownloadCallback;)V", "getLocalFilePath", "()Ljava/lang/String;", "getFileSize", "()J", "getPreviewUrl", "getDataVersion", "getMountPoint", "getExtra", "getPriority", "()Lcom/bytedance/ee/bear/middleground/drive/export/DrivePriority$DownloadPriority;", "getDownloadCallback", "()Lcom/bytedance/ee/bear/middleground/drive/export/DownloadCallback;", "execute", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RustDownloadPreviewUrl implements IRustDownload {
    private final String dataVersion;
    private final DownloadCallback downloadCallback;
    private final String extra;
    private final long fileSize;
    private final String localFilePath;
    private final String mountPoint;
    private final String previewUrl;
    private final DrivePriority$DownloadPriority priority;

    public RustDownloadPreviewUrl(String r110, long r111, String r112, String r113, String r114, DrivePriority$DownloadPriority r210, DownloadCallback r211) {
        Intrinsics.checkNotNullParameter(r110, "localFilePath");
        Intrinsics.checkNotNullParameter(r113, "dataVersion");
        Intrinsics.checkNotNullParameter(r210, "priority");
        Intrinsics.checkNotNullParameter(r211, "downloadCallback");
        this(r110, r111, r112, r113, null, r114, r210, r211, 16, null);
    }

    public RustDownloadPreviewUrl(String r110, String r111, String r112, String r113, DrivePriority$DownloadPriority r114, DownloadCallback r115) {
        Intrinsics.checkNotNullParameter(r110, "localFilePath");
        Intrinsics.checkNotNullParameter(r112, "dataVersion");
        Intrinsics.checkNotNullParameter(r114, "priority");
        Intrinsics.checkNotNullParameter(r115, "downloadCallback");
        this(r110, 0, r111, r112, null, r113, r114, r115, 18, null);
    }

    public static /* synthetic */ RustDownloadPreviewUrl copy$default(RustDownloadPreviewUrl r110, String r111, long r112, String r113, String r114, String r115, String r116, DrivePriority$DownloadPriority r117, DownloadCallback r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.localFilePath;
    L7:
        if ((r210 & 2) == 0) goto L9;
        long r101 = r110.fileSize;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.previewUrl;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.dataVersion;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.mountPoint;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.extra;
    L27:
        if ((r210 & 64) == 0) goto L29;
        DrivePriority$DownloadPriority r106 = r110.priority;
    L31:
        if ((r210 & 128) == 0) goto L33;
        DownloadCallback r107 = r110.downloadCallback;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
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

    public final String component1() {
        return this.localFilePath;
    }

    public final long component2() {
        return this.fileSize;
    }

    public final String component3() {
        return this.previewUrl;
    }

    public final String component4() {
        return this.dataVersion;
    }

    public final String component5() {
        return this.mountPoint;
    }

    public final String component6() {
        return this.extra;
    }

    public final DrivePriority$DownloadPriority component7() {
        return this.priority;
    }

    public final DownloadCallback component8() {
        return this.downloadCallback;
    }

    public final RustDownloadPreviewUrl copy(String r110, long r111, String r112, String r113, String r114, String r115, DrivePriority$DownloadPriority r116, DownloadCallback r210) {
        Intrinsics.checkNotNullParameter(r110, "localFilePath");
        Intrinsics.checkNotNullParameter(r113, "dataVersion");
        Intrinsics.checkNotNullParameter(r116, "priority");
        Intrinsics.checkNotNullParameter(r210, "downloadCallback");
        return new RustDownloadPreviewUrl(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RustDownloadPreviewUrl) == true) goto L8;
        return false;
    L8:
        RustDownloadPreviewUrl r101 = (RustDownloadPreviewUrl) r100;
        if (Intrinsics.areEqual(this.localFilePath, r101.localFilePath) == true) goto L12;
        return false;
    L12:
        if (this.fileSize == r101.fileSize) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewUrl, r101.previewUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dataVersion, r101.dataVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mountPoint, r101.mountPoint) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L27;
        return false;
    L27:
        if (this.priority == r101.priority) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.downloadCallback, r101.downloadCallback) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = this.localFilePath.hashCode() * 31;
        long r101 = this.fileSize;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.previewUrl;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (((r102 + r105) * 31) + this.dataVersion.hashCode()) * 31;
        String r107 = this.mountPoint;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.extra;
        if (r110 == null) goto L15;
        r104 = r110.hashCode();
    L15:
        return ((((r109 + r104) * 31) + this.priority.hashCode()) * 31) + this.downloadCallback.hashCode();
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public String toString() {
        return "RustDownloadPreviewUrl(localFilePath=" + this.localFilePath + ", fileSize=" + this.fileSize + ", previewUrl=" + this.previewUrl + ", dataVersion=" + this.dataVersion + ", mountPoint=" + this.mountPoint + ", extra=" + this.extra + ", priority=" + this.priority + ", downloadCallback=" + this.downloadCallback + ')';
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.rust.IRustDownload
    public String execute() {
        DrivePriority$DownloadPriority.DEFAULT.getPriority();
        DownloadRequestInfo.DownloadType r100 = DownloadRequestInfo.DownloadType.DRIVE;
        DriveBizScene r210 = DriveBizScene.DriveBizScene_UNKNOWN;
        String r101 = this.localFilePath;
        String r102 = this.previewUrl;
        String r103 = this.dataVersion;
        String r104 = this.mountPoint;
        String r105 = this.extra;
        DownloadCallback r110 = this.downloadCallback;
        DownloadRequestInfo r106 = new DownloadRequestInfo(r101, "", "", r104, this.priority.getPriority(), r103, r100, r102, this.fileSize, true, "", 2, r110, null, false, r105, null, r210, null);
        return ((f) a.c(f.class, null, null, 6)).d0().f(r106);
    }

    public final String getDataVersion() {
        return this.dataVersion;
    }

    public final DownloadCallback getDownloadCallback() {
        return this.downloadCallback;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    public final String getMountPoint() {
        return this.mountPoint;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final DrivePriority$DownloadPriority getPriority() {
        return this.priority;
    }

    public RustDownloadPreviewUrl(String r100, long r101, String r102, String r103, String r104, String r105, DrivePriority$DownloadPriority r106, DownloadCallback r110) {
        Intrinsics.checkNotNullParameter(r100, "localFilePath");
        Intrinsics.checkNotNullParameter(r103, "dataVersion");
        Intrinsics.checkNotNullParameter(r106, "priority");
        Intrinsics.checkNotNullParameter(r110, "downloadCallback");
        this.localFilePath = r100;
        this.fileSize = r101;
        this.previewUrl = r102;
        this.dataVersion = r103;
        this.mountPoint = r104;
        this.extra = r105;
        this.priority = r106;
        this.downloadCallback = r110;
    }

    public /* synthetic */ RustDownloadPreviewUrl(String r110, long r111, String r112, String r113, String r114, String r115, DrivePriority$DownloadPriority r210, DownloadCallback r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 2) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r212 & 16) == 0) goto L9;
        String r101 = "";
    L10:
        this(r110, r100, r112, r113, r101, r115, r210, r211);
        return;
    L9:
        r101 = r114;
        goto L10
    L5:
        r100 = r111;
        goto L7
    }
}
