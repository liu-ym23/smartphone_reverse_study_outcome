package com.bytedance.ee.bear.drive.loader.download.platform.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/DriveVideoPreviewException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "fileToken", "statusCode", "", "attempts", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/Throwable;)V", "getFileToken", "()Ljava/lang/String;", "getStatusCode", "()I", "getAttempts", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveVideoPreviewException extends RuntimeException {
    private final int attempts;
    private final String fileToken;
    private final int statusCode;

    public final int getAttempts() {
        return this.attempts;
    }

    public final String getFileToken() {
        return this.fileToken;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public DriveVideoPreviewException(String r100, String r101, int r102, int r103, Throwable r104) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100, r104);
        this.fileToken = r101;
        this.statusCode = r102;
        this.attempts = r103;
    }

    public /* synthetic */ DriveVideoPreviewException(String r100, String r101, int r102, int r110, Throwable r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 8) == 0) goto L5;
        int r103 = 0;
    L7:
        if ((r112 & 16) == 0) goto L9;
        r111 = null;
    L9:
        this(r100, r101, r102, r103, r111);
        return;
    L5:
        r103 = r110;
        goto L7
    }
}
