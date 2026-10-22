package com.bytedance.ee.bear.drive.loader.download.model.drive;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/model/drive/DriveVideoPreviewResponse;", "", "transcodeUrls", "", "", "originUrl", "statusCode", "", "<init>", "(Ljava/util/Map;Ljava/lang/String;I)V", "getTranscodeUrls", "()Ljava/util/Map;", "getOriginUrl", "()Ljava/lang/String;", "getStatusCode", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "contentmanager-drive-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveVideoPreviewResponse {
    private final String originUrl;
    private final int statusCode;
    private final Map<String, String> transcodeUrls;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DriveVideoPreviewResponse copy$default(DriveVideoPreviewResponse r0, Map r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.transcodeUrls;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.originUrl;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.statusCode;
    L12:
        return r0.copy(r1, r2, r3);
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

    public final DriveVideoPreviewResponse copy(Map<String, String> r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "transcodeUrls");
        Intrinsics.checkNotNullParameter(r3, "originUrl");
        return new DriveVideoPreviewResponse(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DriveVideoPreviewResponse) == true) goto L8;
        return false;
    L8:
        DriveVideoPreviewResponse r6 = (DriveVideoPreviewResponse) r5;
        if (Intrinsics.areEqual(this.transcodeUrls, r6.transcodeUrls) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originUrl, r6.originUrl) == true) goto L15;
        return false;
    L15:
        if (this.statusCode == r6.statusCode) goto L17;
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

    public DriveVideoPreviewResponse(Map<String, String> r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "transcodeUrls");
        Intrinsics.checkNotNullParameter(r3, "originUrl");
        this.transcodeUrls = r2;
        this.originUrl = r3;
        this.statusCode = r4;
    }
}
