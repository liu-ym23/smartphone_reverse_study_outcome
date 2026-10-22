package com.bytedance.ee.bear.drive.loader.download.platform.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public DriveVideoPreviewException(String r2, String r3, int r4, int r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2, r6);
        this.fileToken = r3;
        this.statusCode = r4;
        this.attempts = r5;
    }

    public /* synthetic */ DriveVideoPreviewException(String r7, String r8, int r9, int r10, Throwable r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r12 & 16) == 0) goto L9;
        r11 = null;
    L9:
        this(r7, r8, r9, r4, r11);
        return;
    L5:
        r4 = r10;
        goto L7
    }
}
