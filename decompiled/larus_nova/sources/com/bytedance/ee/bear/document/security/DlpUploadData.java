package com.bytedance.ee.bear.document.security;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/document/security/DlpUploadData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "result", "", "getResult", "()Z", "setResult", "(Z)V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "msg", "getMsg", "setMsg", "type", "getType", "setType", "attachmentToken", "getAttachmentToken", "setAttachmentToken", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DlpUploadData implements NonProguard {
    private String attachmentToken;
    private String msg;
    private boolean result;
    private String token;
    private String type;

    public DlpUploadData() {
    }

    public String toString() {
        return "sensitive " + this.result;
    }

    public final String getAttachmentToken() {
        return this.attachmentToken;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final boolean getResult() {
        return this.result;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getType() {
        return this.type;
    }

    public final void setAttachmentToken(String r100) {
        this.attachmentToken = r100;
    }

    public final void setMsg(String r100) {
        this.msg = r100;
    }

    public final void setResult(boolean r100) {
        this.result = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
