package com.bytedance.ee.eenet.httpclient.rust.exception;

import com.larksuite.framework.callback.Entity.ErrorResult;
import java.io.IOException;
import kr5.a;

/* JADX INFO: loaded from: classes16.dex */
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

    public RustIOException(ErrorResult r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getDisplayMsg();
    L5:
        super(r101);
        if (r100 == null) goto L9;
        this.mRustSdkErrorCode = r100.getErrorCode();
        this.mLarkErrorStatus = r100.getStatus();
        this.mLarkErrorCode = r100.getCode();
        this.mErrorResult = r100;
        return;
    L9:
        return;
    L4:
        r101 = "";
        goto L5
    }

    public void setRequestCallInfo(a r100) {
        this.mRequestCallInfo = r100;
    }

    public RustIOException(String r100, int r101) {
        super(r100);
        this.mRustSdkErrorCode = r101;
    }

    public RustIOException(Throwable r100, int r101) {
        super(r100);
        this.mRustSdkErrorCode = r101;
    }

    public RustIOException(String r100, int r101, int r102, int r103) {
        super(r100);
        this.mRustSdkErrorCode = r101;
        this.mLarkErrorStatus = r102;
        this.mLarkErrorCode = r103;
    }
}
