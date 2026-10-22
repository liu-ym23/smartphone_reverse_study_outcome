package com.bytedance.ee.bear.drive.loader.download.platform.abs.rust;

import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.java.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J_\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/abs/rust/RustDownloadPreviewUrl;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/abs/rust/IRustDownload;", "localFilePath", "", "fileSize", "", "previewUrl", "dataVersion", "mountPoint", "extra", "priority", "Lcom/bytedance/ee/bear/middleground/drive/export/DrivePriority$DownloadPriority;", "downloadCallback", "Lcom/bytedance/ee/bear/middleground/drive/export/DownloadCallback;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/middleground/drive/export/DrivePriority$DownloadPriority;Lcom/bytedance/ee/bear/middleground/drive/export/DownloadCallback;)V", "getLocalFilePath", "()Ljava/lang/String;", "getFileSize", "()J", "getPreviewUrl", "getDataVersion", "getMountPoint", "getExtra", "getPriority", "()Lcom/bytedance/ee/bear/middleground/drive/export/DrivePriority$DownloadPriority;", "getDownloadCallback", "()Lcom/bytedance/ee/bear/middleground/drive/export/DownloadCallback;", "execute", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RustDownloadPreviewUrl implements IRustDownload {
    private final String dataVersion;
    private final DownloadCallback downloadCallback;
    private final String extra;
    private final long fileSize;
    private final String localFilePath;
    private final String mountPoint;
    private final String previewUrl;
    private final DrivePriority.DownloadPriority priority;

    public RustDownloadPreviewUrl(String r14, long r16, String r17, String r18, String r19, DrivePriority.DownloadPriority r20, DownloadCallback r21) {
        Intrinsics.checkNotNullParameter(r14, "localFilePath");
        Intrinsics.checkNotNullParameter(r18, "dataVersion");
        Intrinsics.checkNotNullParameter(r20, "priority");
        Intrinsics.checkNotNullParameter(r21, "downloadCallback");
        this(r14, r16, r17, r18, null, r19, r20, r21, 16, null);
    }

    public RustDownloadPreviewUrl(String r14, String r16, String r17, String r18, DrivePriority.DownloadPriority r19, DownloadCallback r110) {
        Intrinsics.checkNotNullParameter(r14, "localFilePath");
        Intrinsics.checkNotNullParameter(r17, "dataVersion");
        Intrinsics.checkNotNullParameter(r19, "priority");
        Intrinsics.checkNotNullParameter(r110, "downloadCallback");
        this(r14, 0, r16, r17, null, r18, r19, r110, 18, null);
    }

    public static /* synthetic */ RustDownloadPreviewUrl copy$default(RustDownloadPreviewUrl r10, String r11, long r12, String r14, String r16, String r17, String r18, DrivePriority.DownloadPriority r19, DownloadCallback r110, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.localFilePath;
    L7:
        if ((r20 & 2) == 0) goto L9;
        long r3 = r10.fileSize;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r5 = r10.previewUrl;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r6 = r10.dataVersion;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r7 = r10.mountPoint;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r8 = r10.extra;
    L27:
        if ((r20 & 64) == 0) goto L29;
        DrivePriority.DownloadPriority r9 = r10.priority;
    L31:
        if ((r20 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        DownloadCallback r1 = r10.downloadCallback;
    L35:
        return r10.copy(r2, r3, r5, r6, r7, r8, r9, r1);
    L33:
        r1 = r110;
        goto L35
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
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

    public final DrivePriority.DownloadPriority component7() {
        return this.priority;
    }

    public final DownloadCallback component8() {
        return this.downloadCallback;
    }

    public final RustDownloadPreviewUrl copy(String r12, long r13, String r16, String r17, String r18, String r19, DrivePriority.DownloadPriority r110, DownloadCallback r20) {
        Intrinsics.checkNotNullParameter(r12, "localFilePath");
        Intrinsics.checkNotNullParameter(r17, "dataVersion");
        Intrinsics.checkNotNullParameter(r110, "priority");
        Intrinsics.checkNotNullParameter(r20, "downloadCallback");
        return new RustDownloadPreviewUrl(r12, r13, r16, r17, r18, r19, r110, r20);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof RustDownloadPreviewUrl) == true) goto L8;
        return false;
    L8:
        RustDownloadPreviewUrl r9 = (RustDownloadPreviewUrl) r8;
        if (Intrinsics.areEqual(this.localFilePath, r9.localFilePath) == true) goto L12;
        return false;
    L12:
        if (this.fileSize == r9.fileSize) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewUrl, r9.previewUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dataVersion, r9.dataVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mountPoint, r9.mountPoint) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r9.extra) == true) goto L27;
        return false;
    L27:
        if (this.priority == r9.priority) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.downloadCallback, r9.downloadCallback) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = this.localFilePath.hashCode() * 31;
        long r1 = this.fileSize;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.previewUrl;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (((r2 + r5) * 31) + this.dataVersion.hashCode()) * 31;
        String r7 = this.mountPoint;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.extra;
        if (r10 == null) goto L15;
        r4 = r10.hashCode();
    L15:
        return ((((r9 + r4) * 31) + this.priority.hashCode()) * 31) + this.downloadCallback.hashCode();
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public String toString() {
        return "RustDownloadPreviewUrl(localFilePath=" + this.localFilePath + ", fileSize=" + this.fileSize + ", previewUrl=" + this.previewUrl + ", dataVersion=" + this.dataVersion + ", mountPoint=" + this.mountPoint + ", extra=" + this.extra + ", priority=" + this.priority + ", downloadCallback=" + this.downloadCallback + ')';
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.rust.IRustDownload
    public String execute() {
        DrivePriority.DownloadPriority.DEFAULT.getPriority();
        DownloadRequestInfo.DownloadType r8 = DownloadRequestInfo.DownloadType.DRIVE;
        DriveBizScene r20 = DriveBizScene.DriveBizScene_UNKNOWN;
        String r2 = this.localFilePath;
        String r9 = this.previewUrl;
        String r7 = this.dataVersion;
        String r5 = this.mountPoint;
        String r1 = this.extra;
        DownloadCallback r16 = this.downloadCallback;
        DownloadRequestInfo r3 = new DownloadRequestInfo(r2, "", "", r5, this.priority.getPriority(), r7, r8, r9, this.fileSize, true, "", 2, r16, null, false, r1, null, r20, null);
        return ((f) a.c(f.class, null, null, 6)).d0().f(r3);
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

    public final DrivePriority.DownloadPriority getPriority() {
        return this.priority;
    }

    public RustDownloadPreviewUrl(String r2, long r3, String r5, String r6, String r7, String r8, DrivePriority.DownloadPriority r9, DownloadCallback r10) {
        Intrinsics.checkNotNullParameter(r2, "localFilePath");
        Intrinsics.checkNotNullParameter(r6, "dataVersion");
        Intrinsics.checkNotNullParameter(r9, "priority");
        Intrinsics.checkNotNullParameter(r10, "downloadCallback");
        this.localFilePath = r2;
        this.fileSize = r3;
        this.previewUrl = r5;
        this.dataVersion = r6;
        this.mountPoint = r7;
        this.extra = r8;
        this.priority = r9;
        this.downloadCallback = r10;
    }

    public /* synthetic */ RustDownloadPreviewUrl(String r13, long r14, String r16, String r17, String r18, String r19, DrivePriority.DownloadPriority r20, DownloadCallback r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 2) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r22 & 16) == 0) goto L9;
        String r8 = "";
    L10:
        this(r13, r4, r16, r17, r8, r19, r20, r21);
        return;
    L9:
        r8 = r18;
        goto L10
    L5:
        r4 = r14;
        goto L7
    }
}
