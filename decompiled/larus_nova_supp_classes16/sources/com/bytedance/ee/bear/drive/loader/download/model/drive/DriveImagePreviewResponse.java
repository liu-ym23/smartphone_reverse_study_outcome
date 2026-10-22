package com.bytedance.ee.bear.drive.loader.download.model.drive;

import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/model/drive/DriveImagePreviewResponse;", "", "fileInfo", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/drive/FileInfoV1Puller$Result;", "url", "", "<init>", "(Lcom/bytedance/ee/bear/drive/loader/download/platform/api/drive/FileInfoV1Puller$Result;Ljava/lang/String;)V", "getFileInfo", "()Lcom/bytedance/ee/bear/drive/loader/download/platform/api/drive/FileInfoV1Puller$Result;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "contentmanager-drive-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImagePreviewResponse {
    private final FileInfoV1Puller.Result fileInfo;
    private final String url;

    public static /* synthetic */ DriveImagePreviewResponse copy$default(DriveImagePreviewResponse r0, FileInfoV1Puller.Result r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.fileInfo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.url;
    L9:
        return r0.copy(r1, r2);
    }

    public final FileInfoV1Puller.Result component1() {
        return this.fileInfo;
    }

    public final String component2() {
        return this.url;
    }

    public final DriveImagePreviewResponse copy(FileInfoV1Puller.Result r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileInfo");
        Intrinsics.checkNotNullParameter(r3, "url");
        return new DriveImagePreviewResponse(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DriveImagePreviewResponse) == true) goto L8;
        return false;
    L8:
        DriveImagePreviewResponse r6 = (DriveImagePreviewResponse) r5;
        if (Intrinsics.areEqual(this.fileInfo, r6.fileInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.fileInfo.hashCode() * 31) + this.url.hashCode();
    }

    public String toString() {
        return "DriveImagePreviewResponse(fileInfo=" + this.fileInfo + ", url=" + this.url + ')';
    }

    public final FileInfoV1Puller.Result getFileInfo() {
        return this.fileInfo;
    }

    public final String getUrl() {
        return this.url;
    }

    public DriveImagePreviewResponse(FileInfoV1Puller.Result r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileInfo");
        Intrinsics.checkNotNullParameter(r3, "url");
        this.fileInfo = r2;
        this.url = r3;
    }

    public /* synthetic */ DriveImagePreviewResponse(FileInfoV1Puller.Result r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        this(r1, r2);
    }
}
