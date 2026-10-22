package com.bytedance.ee.bear.drive.loader.download.model.drive;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/model/drive/DriveVideoPreviewResponse;", "", "transcodeUrls", "", "", "originUrl", "statusCode", "", "<init>", "(Ljava/util/Map;Ljava/lang/String;I)V", "getTranscodeUrls", "()Ljava/util/Map;", "getOriginUrl", "()Ljava/lang/String;", "getStatusCode", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "contentmanager-drive-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveVideoPreviewResponse {
    private final String originUrl;
    private final int statusCode;
    private final Map<String, String> transcodeUrls;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DriveVideoPreviewResponse copy$default(DriveVideoPreviewResponse r100, Map r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.transcodeUrls;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.originUrl;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.statusCode;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Map<String, String> component1() {
        return this.transcodeUrls;
    }

    public final String component2() {
        return this.originUrl;
    }

    public final int component3() {
        return this.statusCode;
    }

    public final DriveVideoPreviewResponse copy(Map<String, String> r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "transcodeUrls");
        Intrinsics.checkNotNullParameter(r101, "originUrl");
        return new DriveVideoPreviewResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DriveVideoPreviewResponse) == true) goto L8;
        return false;
    L8:
        DriveVideoPreviewResponse r101 = (DriveVideoPreviewResponse) r100;
        if (Intrinsics.areEqual(this.transcodeUrls, r101.transcodeUrls) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originUrl, r101.originUrl) == true) goto L15;
        return false;
    L15:
        if (this.statusCode == r101.statusCode) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.transcodeUrls.hashCode() * 31) + this.originUrl.hashCode()) * 31) + this.statusCode;
    }

    public String toString() {
        return "DriveVideoPreviewResponse(transcodeUrls=" + this.transcodeUrls + ", originUrl=" + this.originUrl + ", statusCode=" + this.statusCode + ')';
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final Map<String, String> getTranscodeUrls() {
        return this.transcodeUrls;
    }

    public DriveVideoPreviewResponse(Map<String, String> r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "transcodeUrls");
        Intrinsics.checkNotNullParameter(r101, "originUrl");
        this.transcodeUrls = r100;
        this.originUrl = r101;
        this.statusCode = r102;
    }
}
