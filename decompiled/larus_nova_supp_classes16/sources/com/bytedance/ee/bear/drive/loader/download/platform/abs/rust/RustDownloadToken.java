package com.bytedance.ee.bear.drive.loader.download.platform.abs.rust;

import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.java.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    private final DrivePriority.DownloadPriority priority;

    public RustDownloadToken(String r16, String r17, String r18, String r19, DownloadRequestInfo.DownloadType r20, DrivePriority.DownloadPriority r21, DownloadCallback r22) {
        Intrinsics.checkNotNullParameter(r16, "localFilePath");
        Intrinsics.checkNotNullParameter(r18, "dataVersion");
        Intrinsics.checkNotNullParameter(r20, "downloadType");
        Intrinsics.checkNotNullParameter(r21, "priority");
        Intrinsics.checkNotNullParameter(r22, "downloadCallback");
        this(r16, r17, r18, null, null, r19, r20, r21, r22, null, null, 1560, null);
    }

    public RustDownloadToken(String r16, String r17, String r18, String r19, String r20, DownloadRequestInfo.DownloadType r21, DrivePriority.DownloadPriority r22, DownloadCallback r23) {
        Intrinsics.checkNotNullParameter(r16, "localFilePath");
        Intrinsics.checkNotNullParameter(r18, "dataVersion");
        Intrinsics.checkNotNullParameter(r21, "downloadType");
        Intrinsics.checkNotNullParameter(r22, "priority");
        Intrinsics.checkNotNullParameter(r23, "downloadCallback");
        this(r16, r17, r18, r19, null, r20, r21, r22, r23, null, null, 1552, null);
    }

    public RustDownloadToken(String r16, String r17, String r18, String r19, String r20, String r21, DownloadRequestInfo.DownloadType r22, DrivePriority.DownloadPriority r23, DownloadCallback r24) {
        Intrinsics.checkNotNullParameter(r16, "localFilePath");
        Intrinsics.checkNotNullParameter(r18, "dataVersion");
        Intrinsics.checkNotNullParameter(r22, "downloadType");
        Intrinsics.checkNotNullParameter(r23, "priority");
        Intrinsics.checkNotNullParameter(r24, "downloadCallback");
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, null, null, 1536, null);
    }

    public RustDownloadToken(String r16, String r17, String r18, String r19, String r20, String r21, DownloadRequestInfo.DownloadType r22, DrivePriority.DownloadPriority r23, DownloadCallback r24, DriveBizScene r26) {
        Intrinsics.checkNotNullParameter(r16, "localFilePath");
        Intrinsics.checkNotNullParameter(r18, "dataVersion");
        Intrinsics.checkNotNullParameter(r22, "downloadType");
        Intrinsics.checkNotNullParameter(r23, "priority");
        Intrinsics.checkNotNullParameter(r24, "downloadCallback");
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, null, 1024, null);
    }

    public static /* synthetic */ RustDownloadToken copy$default(RustDownloadToken r12, String r13, String r14, String r16, String r17, String r18, String r19, DownloadRequestInfo.DownloadType r110, DrivePriority.DownloadPriority r20, DownloadCallback r21, DriveBizScene r22, DriveWatermarkScene r23, int r24, Object r26) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = r12.localFilePath;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.fileToken;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.dataVersion;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = r12.mountPoint;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.mountNodePoint;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = r12.extra;
    L27:
        if ((r24 & 64) == 0) goto L29;
        DownloadRequestInfo.DownloadType r8 = r12.downloadType;
    L31:
        if ((r24 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        DrivePriority.DownloadPriority r9 = r12.priority;
    L35:
        if ((r24 & 256) == 0) goto L37;
        DownloadCallback r10 = r12.downloadCallback;
    L39:
        if ((r24 & 512) == 0) goto L41;
        DriveBizScene r11 = r12.driveBizScene;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        DriveWatermarkScene r1 = r12.driveWatermarkScene;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r110;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
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

    public final DrivePriority.DownloadPriority component8() {
        return this.priority;
    }

    public final DownloadCallback component9() {
        return this.downloadCallback;
    }

    public final RustDownloadToken copy(String r14, String r16, String r17, String r18, String r19, String r110, DownloadRequestInfo.DownloadType r20, DrivePriority.DownloadPriority r21, DownloadCallback r22, DriveBizScene r23, DriveWatermarkScene r24) {
        Intrinsics.checkNotNullParameter(r14, "localFilePath");
        Intrinsics.checkNotNullParameter(r17, "dataVersion");
        Intrinsics.checkNotNullParameter(r20, "downloadType");
        Intrinsics.checkNotNullParameter(r21, "priority");
        Intrinsics.checkNotNullParameter(r22, "downloadCallback");
        return new RustDownloadToken(r14, r16, r17, r18, r19, r110, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RustDownloadToken) == true) goto L8;
        return false;
    L8:
        RustDownloadToken r6 = (RustDownloadToken) r5;
        if (Intrinsics.areEqual(this.localFilePath, r6.localFilePath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileToken, r6.fileToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.dataVersion, r6.dataVersion) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mountPoint, r6.mountPoint) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mountNodePoint, r6.mountNodePoint) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L27;
        return false;
    L27:
        if (this.downloadType == r6.downloadType) goto L30;
        return false;
    L30:
        if (this.priority == r6.priority) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.downloadCallback, r6.downloadCallback) == true) goto L36;
        return false;
    L36:
        if (this.driveBizScene == r6.driveBizScene) goto L39;
        return false;
    L39:
        if (this.driveWatermarkScene == r6.driveWatermarkScene) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = this.localFilePath.hashCode() * 31;
        String r1 = this.fileToken;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.dataVersion.hashCode()) * 31;
        String r5 = this.mountPoint;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.mountNodePoint;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.extra;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((((((r10 + r12) * 31) + this.downloadType.hashCode()) * 31) + this.priority.hashCode()) * 31) + this.downloadCallback.hashCode()) * 31;
        DriveBizScene r14 = this.driveBizScene;
        if (r14 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r13 + r16) * 31;
        DriveWatermarkScene r18 = this.driveWatermarkScene;
        if (r18 == null) goto L27;
        r2 = r18.hashCode();
    L27:
        return r17 + r2;
    L21:
        r16 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "RustDownloadToken(localFilePath=" + this.localFilePath + ", fileToken=" + this.fileToken + ", dataVersion=" + this.dataVersion + ", mountPoint=" + this.mountPoint + ", mountNodePoint=" + this.mountNodePoint + ", extra=" + this.extra + ", downloadType=" + this.downloadType + ", priority=" + this.priority + ", downloadCallback=" + this.downloadCallback + ", driveBizScene=" + this.driveBizScene + ", driveWatermarkScene=" + this.driveWatermarkScene + ')';
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.rust.IRustDownload
    public String execute() {
        DownloadRequestInfo.a r1 = new DownloadRequestInfo.a();
        r1.a = this.localFilePath;
        r1.b = this.fileToken;
        r1.e = this.dataVersion;
        r1.d = this.mountPoint;
        r1.c = this.mountNodePoint;
        r1.o = this.extra;
        r1.f = this.downloadType;
        r1.l = this.downloadCallback;
        int r8 = this.priority.getPriority();
        DriveBizScene r2 = this.driveBizScene;
        DriveWatermarkScene r10 = this.driveWatermarkScene;
        DownloadRequestInfo.DownloadType r16 = r1.f;
        boolean r4 = false;
        if (r16 != DownloadRequestInfo.DownloadType.COVER) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        DownloadRequestInfo.a r5 = r1;
    L9:
        if (r5 != null) goto L11;
    L18:
        DownloadRequestInfo r14 = new DownloadRequestInfo(r1.a, r1.b, r1.c, r1.d, r8, r1.e, r16, r1.g, r1.h, r1.i, r1.j, r1.k, r1.l, r1.m, r1.n, r1.o, null, r2, r10);
        return ((f) a.c(f.class, null, null, 6)).d0().g(r14);
    L11:
        if (r5.m != null) goto L13;
        r4 = true;
    L13:
        if (r4 == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
        r5.m = new DownloadRequestInfo.b(1280, 1280, "equal", true);
        goto L18
    L8:
        r5 = null;
        goto L9
    L5:
        r3 = false;
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

    public final DrivePriority.DownloadPriority getPriority() {
        return this.priority;
    }

    public RustDownloadToken(String r2, String r3, String r4, String r5, String r6, String r7, DownloadRequestInfo.DownloadType r8, DrivePriority.DownloadPriority r9, DownloadCallback r10, DriveBizScene r11, DriveWatermarkScene r12) {
        Intrinsics.checkNotNullParameter(r2, "localFilePath");
        Intrinsics.checkNotNullParameter(r4, "dataVersion");
        Intrinsics.checkNotNullParameter(r8, "downloadType");
        Intrinsics.checkNotNullParameter(r9, "priority");
        Intrinsics.checkNotNullParameter(r10, "downloadCallback");
        this.localFilePath = r2;
        this.fileToken = r3;
        this.dataVersion = r4;
        this.mountPoint = r5;
        this.mountNodePoint = r6;
        this.extra = r7;
        this.downloadType = r8;
        this.priority = r9;
        this.downloadCallback = r10;
        this.driveBizScene = r11;
        this.driveWatermarkScene = r12;
    }

    public /* synthetic */ RustDownloadToken(String r16, String r17, String r18, String r19, String r20, String r21, DownloadRequestInfo.DownloadType r22, DrivePriority.DownloadPriority r23, DownloadCallback r24, DriveBizScene r26, DriveWatermarkScene r27, int r28, DefaultConstructorMarker r29) {
        if ((r28 & 8) == 0) goto L5;
        String r7 = "";
    L7:
        if ((r28 & 16) == 0) goto L9;
        String r8 = "";
    L11:
        if ((r28 & 512) == 0) goto L13;
        DriveBizScene r13 = null;
    L15:
        if ((r28 & 1024) == 0) goto L17;
        DriveWatermarkScene r14 = null;
    L18:
        this(r16, r17, r18, r7, r8, r21, r22, r23, r24, r13, r14);
        return;
    L17:
        r14 = r27;
        goto L18
    L13:
        r13 = r26;
        goto L15
    L9:
        r8 = r20;
        goto L11
    L5:
        r7 = r19;
        goto L7
    }
}
