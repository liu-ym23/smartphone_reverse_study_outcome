package com.bytedance.iesgurd.update;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u0015\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/iesgurd/update/UpdateException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errorCode", "Lcom/bytedance/iesgurd/update/ErrorCode;", "msg", "", "(Lcom/bytedance/iesgurd/update/ErrorCode;Ljava/lang/String;)V", "code", "", "message", "(ILjava/lang/String;)V", "getCode", "()I", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class UpdateException extends RuntimeException {
    private final int code;

    public final int getCode() {
        return this.code;
    }

    public UpdateException(ErrorCode r100, String r101) {
        int r102 = r100.getCode();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        this(r102, r101);
    }

    public UpdateException(int r100, String r101) {
        super(r101);
        this.code = r100;
    }
}
