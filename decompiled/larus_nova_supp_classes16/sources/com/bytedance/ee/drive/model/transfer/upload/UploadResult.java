package com.bytedance.ee.drive.model.transfer.upload;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/drive/model/transfer/upload/UploadResult;", "Ljava/io/Serializable;", "fileToken", "", "(Ljava/lang/String;)V", "getFileToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "drive-model_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UploadResult implements Serializable {
    private final String fileToken;

    public static /* synthetic */ UploadResult copy$default(UploadResult r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.fileToken;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.fileToken;
    }

    public final UploadResult copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        return new UploadResult(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof UploadResult) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.fileToken, ((UploadResult) r4).fileToken) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.fileToken.hashCode();
    }

    public String toString() {
        return "UploadResult(fileToken=" + this.fileToken + ')';
    }

    public final String getFileToken() {
        return this.fileToken;
    }

    public UploadResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        this.fileToken = r2;
    }
}
