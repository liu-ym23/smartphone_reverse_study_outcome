package com.bytedance.iesgurd.exception;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/iesgurd/exception/ExceptionWithCode;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class ExceptionWithCode extends RuntimeException {
    private final int code;

    public final int getCode() {
        return this.code;
    }

    public ExceptionWithCode(int r100, String r101) {
        super(r101);
        this.code = r100;
    }
}
