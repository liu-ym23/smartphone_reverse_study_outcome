package com.bytedance.ee.eenet.httpclient.rust.exception;

import com.larksuite.framework.callback.Entity.ErrorResult;
import java.io.IOException;
import kr5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RustIOException extends IOException {
    public static final int REQUEST_EENET_CANCEL = -3331001;
    public static final int REQUEST_EENET_INNER_ERROR = -3331002;
    public static final int REQUEST_EENET_INNER_MEMORY_LIMIT = -3331003;
    public static final int REQUEST_EENET_UNKNOWN = -3331000;
    private ErrorResult mErrorResult;
    private int mLarkErrorCode;
    private int mLarkErrorStatus;
    private a mRequestCallInfo;
    private int mRustSdkErrorCode;

    public ErrorResult getErrorResult() {
        return this.mErrorResult;
    }

    public int getLarkErrorCode() {
        return this.mLarkErrorCode;
    }

    public int getLarkErrorStatus() {
        return this.mLarkErrorStatus;
    }

    public a getRequestCallInfo() {
        return this.mRequestCallInfo;
    }

    public int getRustSdkErrorCode() {
        return this.mRustSdkErrorCode;
    }

    public RustIOException(ErrorResult r2) {
        if (r2 == null) goto L4;
        String r0 = r2.getDisplayMsg();
    L5:
        super(r0);
        if (r2 == null) goto L9;
        this.mRustSdkErrorCode = r2.getErrorCode();
        this.mLarkErrorStatus = r2.getStatus();
        this.mLarkErrorCode = r2.getCode();
        this.mErrorResult = r2;
        return;
    L9:
        return;
    L4:
        r0 = "";
        goto L5
    }

    public void setRequestCallInfo(a r1) {
        this.mRequestCallInfo = r1;
    }

    public RustIOException(String r1, int r2) {
        super(r1);
        this.mRustSdkErrorCode = r2;
    }

    public RustIOException(Throwable r1, int r2) {
        super(r1);
        this.mRustSdkErrorCode = r2;
    }

    public RustIOException(String r1, int r2, int r3, int r4) {
        super(r1);
        this.mRustSdkErrorCode = r2;
        this.mLarkErrorStatus = r3;
        this.mLarkErrorCode = r4;
    }
}
