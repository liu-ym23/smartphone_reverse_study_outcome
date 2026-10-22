package com.ss.android.lark.chameleonv2.lkapi.resource;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$ResourceUploadRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", PickerReporterConstants.KEY.TARGET, "", "filePath", "fileName", "uploadId", "mountPoint", "mountPointToken", "ext", "Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$ResourceUploadExtInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$ResourceUploadExtInfo;)V", "getTarget", "()Ljava/lang/String;", "getFilePath", "getFileName", "getUploadId", "getMountPoint", "getMountPointToken", "getExt", "()Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$ResourceUploadExtInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IResource$Internal$ResourceUploadRequest implements NonProguard {
    private final IResource$Internal$ResourceUploadExtInfo ext;
    private final String fileName;
    private final String filePath;
    private final String mountPoint;
    private final String mountPointToken;
    private final String target;
    private final String uploadId;

    public static /* synthetic */ IResource$Internal$ResourceUploadRequest copy$default(IResource$Internal$ResourceUploadRequest r100, String r101, String r102, String r103, String r104, String r110, String r111, IResource$Internal$ResourceUploadExtInfo r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.target;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.filePath;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.fileName;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.uploadId;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.mountPoint;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.mountPointToken;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.ext;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.target;
    }

    public final String component2() {
        return this.filePath;
    }

    public final String component3() {
        return this.fileName;
    }

    public final String component4() {
        return this.uploadId;
    }

    public final String component5() {
        return this.mountPoint;
    }

    public final String component6() {
        return this.mountPointToken;
    }

    public final IResource$Internal$ResourceUploadExtInfo component7() {
        return this.ext;
    }

    public final IResource$Internal$ResourceUploadRequest copy(String r110, String r111, String r112, String r113, String r114, String r115, IResource$Internal$ResourceUploadExtInfo r116) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r111, "filePath");
        Intrinsics.checkNotNullParameter(r112, "fileName");
        Intrinsics.checkNotNullParameter(r113, "uploadId");
        Intrinsics.checkNotNullParameter(r114, "mountPoint");
        Intrinsics.checkNotNullParameter(r115, "mountPointToken");
        return new IResource$Internal$ResourceUploadRequest(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IResource$Internal$ResourceUploadRequest) == true) goto L8;
        return false;
    L8:
        IResource$Internal$ResourceUploadRequest r101 = (IResource$Internal$ResourceUploadRequest) r100;
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.filePath, r101.filePath) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uploadId, r101.uploadId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mountPoint, r101.mountPoint) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mountPointToken, r101.mountPointToken) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((this.target.hashCode() * 31) + this.filePath.hashCode()) * 31) + this.fileName.hashCode()) * 31) + this.uploadId.hashCode()) * 31) + this.mountPoint.hashCode()) * 31) + this.mountPointToken.hashCode()) * 31;
        IResource$Internal$ResourceUploadExtInfo r101 = this.ext;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ResourceUploadRequest(target=" + this.target + ", filePath=" + this.filePath + ", fileName=" + this.fileName + ", uploadId=" + this.uploadId + ", mountPoint=" + this.mountPoint + ", mountPointToken=" + this.mountPointToken + ", ext=" + this.ext + ')';
    }

    public final IResource$Internal$ResourceUploadExtInfo getExt() {
        return this.ext;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getMountPoint() {
        return this.mountPoint;
    }

    public final String getMountPointToken() {
        return this.mountPointToken;
    }

    public final String getTarget() {
        return this.target;
    }

    public final String getUploadId() {
        return this.uploadId;
    }

    public IResource$Internal$ResourceUploadRequest(String r100, String r101, String r102, String r103, String r104, String r105, IResource$Internal$ResourceUploadExtInfo r106) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "filePath");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Intrinsics.checkNotNullParameter(r103, "uploadId");
        Intrinsics.checkNotNullParameter(r104, "mountPoint");
        Intrinsics.checkNotNullParameter(r105, "mountPointToken");
        this.target = r100;
        this.filePath = r101;
        this.fileName = r102;
        this.uploadId = r103;
        this.mountPoint = r104;
        this.mountPointToken = r105;
        this.ext = r106;
    }
}
