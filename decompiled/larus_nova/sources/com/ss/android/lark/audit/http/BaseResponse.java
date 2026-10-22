package com.ss.android.lark.audit.http;

import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class BaseResponse implements Serializable {
    public int code;
    public AuditResponseData data;
    public String message;

    public BaseResponse() {
    }
}
