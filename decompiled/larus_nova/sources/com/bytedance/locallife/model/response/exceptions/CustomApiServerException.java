package com.bytedance.locallife.model.response.exceptions;

import android.text.TextUtils;
import tb2.c;

/* JADX INFO: loaded from: classes21.dex */
public class CustomApiServerException extends ApiServerException {
    private String traceId;
    private String url;
    private String xTtLogId;

    @Override // java.lang.Throwable
    public String getMessage() {
        return " TYPE = CustomApiServerException, url = " + this.url + ", xTtLogId = " + this.xTtLogId + "  , traceId = " + this.traceId + c.DEFAULT_TEXT + super.getMessage();
    }

    public String getTraceId() {
        return this.traceId;
    }

    @Override // com.bytedance.locallife.model.response.exceptions.ApiServerException
    public String getUrl() {
        return this.url;
    }

    public String getXTtLogId() {
        return this.xTtLogId;
    }

    public CustomApiServerException(int r100, String r101, String r102, String r103) {
        super(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        this.url = "";
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L9;
        this.xTtLogId = "";
    L11:
        if (TextUtils.isEmpty(r103) == false) goto L13;
        this.traceId = "";
        return;
    L13:
        this.traceId = r103;
        return;
    L9:
        this.xTtLogId = r102;
        goto L11
    L5:
        this.url = r101;
        goto L7
    }
}
