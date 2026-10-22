package com.bytedance.ee.bear.drive.loader.download.platform.abs.rust;

import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$DownloadPriority;
import com.bytedance.lark.pb.space.drive.v1.CoverDownloadInfo;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.obric.sva.sdk.data.ISmModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.java.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\n\u0010&\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\u000eHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0083\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/abs/rust/RustDownloadToken;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/abs/rust/IRustDownload;", "localFilePath", "", "fileToken", "dataVersion", "mountPoint", "mountNodePoint", "extra", "downloadType", "Lcom/bytedance/ee/bear/middleground/drive/export/DownloadRequestInfo$DownloadType;", "priority", "Lcom/bytedance/ee/bear/middleground/drive/export/DrivePriority$DownloadPriority;", "downloadCallback", "Lcom/bytedance/ee/bear/middleground/drive/export/DownloadCallback;", "driveBizScene", "Lcom/bytedance/lark/pb/space/drive/v1/DriveBizScene;", "driveWatermarkScene", "Lcom/bytedance/lark/pb/space/drive/v1/DriveWatermarkScene;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/middleground/drive/export/DownloadRequestInfo$DownloadType;Lcom/bytedance/ee/bear/middleground/drive/export/DrivePriority$DownloadPriority;Lcom/bytedance/ee/bear/middleground/drive/export/DownloadCallback;Lcom/bytedance/lark/pb/space/drive/v1/DriveBizScene;Lcom/bytedance/lark/pb/space/drive/v1/DriveWatermarkScene;)V", "getLocalFilePath", "()Ljava/lang/String;", "getFileToken", "getDataVersion", "getMountPoint", "getMountNodePoint", "getExtra", "getDownloadType", "()Lcom/bytedance/ee/bear/middleground/drive/export/DownloadRequestInfo$DownloadType;", "getPriority", "()Lcom/bytedance/ee/bear/middleground/drive/export/DrivePriority$DownloadPriority;", "getDownloadCallback", "()Lcom/bytedance/ee/bear/middleground/drive/export/DownloadCallback;", "getDriveBizScene", "()Lcom/bytedance/lark/pb/space/drive/v1/DriveBizScene;", "getDriveWatermarkScene", "()Lcom/bytedance/lark/pb/space/drive/v1/DriveWatermarkScene;", "execute", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "", "toString", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RustDownloadToken implements IRustDownload {
    private final String dataVersion;
    private final DownloadCallback downloadCallback;
    private final DownloadRequestInfo.DownloadType downloadType;
    private final DriveBizScene driveBizScene;
    private final DriveWatermarkScene driveWatermarkScene;
    private final String extra;
    private final String fileToken;
    private final String localFilePath;
    private final String mountNodePoint;
    private final String mountPoint;
    private final DrivePriority$DownloadPriority priority;

    public RustDownloadToken(String r110, String r111, String r112, String r113, DownloadRequestInfo.DownloadType r210, DrivePriority$DownloadPriority r211, DownloadCallback r212) {
        Intrinsics.checkNotNullParameter(r110, "localFilePath");
        Intrinsics.checkNotNullParameter(r112, "dataVersion");
        Intrinsics.checkNotNullParameter(r210, "downloadType");
        Intrinsics.checkNotNullParameter(r211, "priority");
        Intrinsics.checkNotNullParameter(r212, "downloadCallback");
        this(r110, r111, r112, null, null, r113, r210, r211, r212, null, null, 1560, null);
    }

    public RustDownloadToken(String r110, String r111, String r112, String r113, String r210, DownloadRequestInfo.DownloadType r211, DrivePriority$DownloadPriority r212, DownloadCallback r213) {
        Intrinsics.checkNotNullParameter(r110, "localFilePath");
        Intrinsics.checkNotNullParameter(r112, "dataVersion");
        Intrinsics.checkNotNullParameter(r211, "downloadType");
        Intrinsics.checkNotNullParameter(r212, "priority");
        Intrinsics.checkNotNullParameter(r213, "downloadCallback");
        this(r110, r111, r112, r113, null, r210, r211, r212, r213, null, null, 1552, null);
    }

    public RustDownloadToken(String r110, String r111, String r112, String r113, String r210, String r211, DownloadRequestInfo.DownloadType r212, DrivePriority$DownloadPriority r213, DownloadCallback r214) {
        Intrinsics.checkNotNullParameter(r110, "localFilePath");
        Intrinsics.checkNotNullParameter(r112, "dataVersion");
        Intrinsics.checkNotNullParameter(r212, "downloadType");
        Intrinsics.checkNotNullParameter(r213, "priority");
        Intrinsics.checkNotNullParameter(r214, "downloadCallback");
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, null, null, ISmModel.VERSION_0600, null);
    }

    public RustDownloadToken(String r110, String r111, String r112, String r113, String r210, String r211, DownloadRequestInfo.DownloadType r212, DrivePriority$DownloadPriority r213, DownloadCallback r214, DriveBizScene r215) {
        Intrinsics.checkNotNullParameter(r110, "localFilePath");
        Intrinsics.checkNotNullParameter(r112, "dataVersion");
        Intrinsics.checkNotNullParameter(r212, "downloadType");
        Intrinsics.checkNotNullParameter(r213, "priority");
        Intrinsics.checkNotNullParameter(r214, "downloadCallback");
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, null, 1024, null);
    }

    public static /* synthetic */ RustDownloadToken copy$default(RustDownloadToken r110, String r111, String r112, String r113, String r114, String r115, String r116, DownloadRequestInfo.DownloadType r117, DrivePriority$DownloadPriority r210, DownloadCallback r211, DriveBizScene r212, DriveWatermarkScene r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.localFilePath;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.fileToken;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.dataVersion;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.mountPoint;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.mountNodePoint;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.extra;
    L27:
        if ((r214 & 64) == 0) goto L29;
        DownloadRequestInfo.DownloadType r106 = r110.downloadType;
    L31:
        if ((r214 & 128) == 0) goto L33;
        DrivePriority$DownloadPriority r107 = r110.priority;
    L35:
        if ((r214 & 256) == 0) goto L37;
        DownloadCallback r118 = r110.downloadCallback;
    L39:
        if ((r214 & 512) == 0) goto L41;
        DriveBizScene r119 = r110.driveBizScene;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        DriveWatermarkScene r108 = r110.driveWatermarkScene;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final DriveBizScene component10() {
        return this.driveBizScene;
    }

    public final DriveWatermarkScene component11() {
        return this.driveWatermarkScene;
    }

    public final String component2() {
        return this.fileToken;
    }

    public final String component3() {
        return this.dataVersion;
    }

    public final String component4() {
        return this.mountPoint;
    }

    public final String component5() {
        return this.mountNodePoint;
    }

    public final String component6() {
        return this.extra;
    }

    public final DownloadRequestInfo.DownloadType component7() {
        return this.downloadType;
    }

    public final DrivePriority$DownloadPriority component8() {
        return this.priority;
    }

    public final DownloadCallback component9() {
        return this.downloadCallback;
    }

    public final RustDownloadToken copy(String r110, String r111, String r112, String r113, String r114, String r115, DownloadRequestInfo.DownloadType r210, DrivePriority$DownloadPriority r211, DownloadCallback r212, DriveBizScene r213, DriveWatermarkScene r214) {
        Intrinsics.checkNotNullParameter(r110, "localFilePath");
        Intrinsics.checkNotNullParameter(r112, "dataVersion");
        Intrinsics.checkNotNullParameter(r210, "downloadType");
        Intrinsics.checkNotNullParameter(r211, "priority");
        Intrinsics.checkNotNullParameter(r212, "downloadCallback");
        return new RustDownloadToken(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RustDownloadToken) == true) goto L8;
        return false;
    L8:
        RustDownloadToken r101 = (RustDownloadToken) r100;
        if (Intrinsics.areEqual(this.localFilePath, r101.localFilePath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileToken, r101.fileToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.dataVersion, r101.dataVersion) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mountPoint, r101.mountPoint) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mountNodePoint, r101.mountNodePoint) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L27;
        return false;
    L27:
        if (this.downloadType == r101.downloadType) goto L30;
        return false;
    L30:
        if (this.priority == r101.priority) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.downloadCallback, r101.downloadCallback) == true) goto L36;
        return false;
    L36:
        if (this.driveBizScene == r101.driveBizScene) goto L39;
        return false;
    L39:
        if (this.driveWatermarkScene == r101.driveWatermarkScene) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r100 = this.localFilePath.hashCode() * 31;
        String r101 = this.fileToken;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.dataVersion.hashCode()) * 31;
        String r105 = this.mountPoint;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.mountNodePoint;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.extra;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((((((r110 + r112) * 31) + this.downloadType.hashCode()) * 31) + this.priority.hashCode()) * 31) + this.downloadCallback.hashCode()) * 31;
        DriveBizScene r114 = this.driveBizScene;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        DriveWatermarkScene r117 = this.driveWatermarkScene;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
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

    public String toString() {
        return "RustDownloadToken(localFilePath=" + this.localFilePath + ", fileToken=" + this.fileToken + ", dataVersion=" + this.dataVersion + ", mountPoint=" + this.mountPoint + ", mountNodePoint=" + this.mountNodePoint + ", extra=" + this.extra + ", downloadType=" + this.downloadType + ", priority=" + this.priority + ", downloadCallback=" + this.downloadCallback + ", driveBizScene=" + this.driveBizScene + ", driveWatermarkScene=" + this.driveWatermarkScene + ')';
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.rust.IRustDownload
    public String execute() {
        DownloadRequestInfo.a r100 = new DownloadRequestInfo.a();
        r100.f232444a = this.localFilePath;
        r100.f232445b = this.fileToken;
        r100.f232448e = this.dataVersion;
        r100.f232447d = this.mountPoint;
        r100.f232446c = this.mountNodePoint;
        r100.f232458o = this.extra;
        r100.f232449f = this.downloadType;
        r100.f232455l = this.downloadCallback;
        int r101 = this.priority.getPriority();
        DriveBizScene r102 = this.driveBizScene;
        DriveWatermarkScene r110 = this.driveWatermarkScene;
        DownloadRequestInfo.DownloadType r111 = r100.f232449f;
        boolean r103 = false;
        if (r111 != DownloadRequestInfo.DownloadType.COVER) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        DownloadRequestInfo.a r105 = r100;
    L9:
        if (r105 != null) goto L11;
    L18:
        DownloadRequestInfo r112 = new DownloadRequestInfo(r100.f232444a, r100.f232445b, r100.f232446c, r100.f232447d, r101, r100.f232448e, r111, r100.f232450g, r100.f232451h, r100.f232452i, r100.f232453j, r100.f232454k, r100.f232455l, r100.f232456m, r100.f232457n, r100.f232458o, null, r102, r110);
        return ((f) a.c(f.class, null, null, 6)).d0().g(r112);
    L11:
        if (r105.f232456m != null) goto L13;
        r103 = true;
    L13:
        if (r103 == true) goto L16;
        r105 = null;
    L16:
        if (r105 == null) goto L18;
        r105.f232456m = new DownloadRequestInfo.b(1280, 1280, CoverDownloadInfo.DEFAULT_POLICY, true);
        goto L18
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = false;
        goto L6
    }

    public final String getDataVersion() {
        return this.dataVersion;
    }

    public final DownloadCallback getDownloadCallback() {
        return this.downloadCallback;
    }

    public final DownloadRequestInfo.DownloadType getDownloadType() {
        return this.downloadType;
    }

    public final DriveBizScene getDriveBizScene() {
        return this.driveBizScene;
    }

    public final DriveWatermarkScene getDriveWatermarkScene() {
        return this.driveWatermarkScene;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getFileToken() {
        return this.fileToken;
    }

    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    public final String getMountNodePoint() {
        return this.mountNodePoint;
    }

    public final String getMountPoint() {
        return this.mountPoint;
    }

    public final DrivePriority$DownloadPriority getPriority() {
        return this.priority;
    }

    public RustDownloadToken(String r100, String r101, String r102, String r103, String r104, String r105, DownloadRequestInfo.DownloadType r106, DrivePriority$DownloadPriority r107, DownloadCallback r110, DriveBizScene r111, DriveWatermarkScene r112) {
        Intrinsics.checkNotNullParameter(r100, "localFilePath");
        Intrinsics.checkNotNullParameter(r102, "dataVersion");
        Intrinsics.checkNotNullParameter(r106, "downloadType");
        Intrinsics.checkNotNullParameter(r107, "priority");
        Intrinsics.checkNotNullParameter(r110, "downloadCallback");
        this.localFilePath = r100;
        this.fileToken = r101;
        this.dataVersion = r102;
        this.mountPoint = r103;
        this.mountNodePoint = r104;
        this.extra = r105;
        this.downloadType = r106;
        this.priority = r107;
        this.downloadCallback = r110;
        this.driveBizScene = r111;
        this.driveWatermarkScene = r112;
    }

    public /* synthetic */ RustDownloadToken(String r110, String r111, String r112, String r113, String r210, String r211, DownloadRequestInfo.DownloadType r212, DrivePriority$DownloadPriority r213, DownloadCallback r214, DriveBizScene r215, DriveWatermarkScene r216, int r217, DefaultConstructorMarker r218) {
        if ((r217 & 8) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r217 & 16) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r217 & 512) == 0) goto L13;
        DriveBizScene r114 = null;
    L15:
        if ((r217 & 1024) == 0) goto L17;
        DriveWatermarkScene r115 = null;
    L18:
        this(r110, r111, r112, r100, r101, r211, r212, r213, r214, r114, r115);
        return;
    L17:
        r115 = r216;
        goto L18
    L13:
        r114 = r215;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
