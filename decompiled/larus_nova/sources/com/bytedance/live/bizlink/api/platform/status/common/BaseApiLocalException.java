package com.bytedance.live.bizlink.api.platform.status.common;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/live/bizlink/api/platform/status/common/BaseApiLocalException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "(I)V", LynxError.LYNX_THROWABLE, "", "(ILjava/lang/Throwable;)V", "getErrorCode", "()I", "setErrorCode", "message", "", "getMessage", "()Ljava/lang/String;", "multi-biz-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BaseApiLocalException extends Exception {
    private int errorCode;

    @Override // java.lang.Throwable
    public String getMessage() {
        return " TYPE = BaseApiLocalException, errorCode = " + this.errorCode + " " + super.getMessage();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public BaseApiLocalException(int r100) {
        this.errorCode = r100;
    }

    public final void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public BaseApiLocalException(int r100, Throwable r101) {
        super(r101);
        this.errorCode = r100;
    }
}
