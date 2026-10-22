package com.bytedance.ee.bear.document.security;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/document/security/DeleteImageData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "fileToken", "getFileToken", "setFileToken", "fileUrl", "getFileUrl", "setFileUrl", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeleteImageData implements NonProguard {

    @JSONField(name = "file_token")
    private String fileToken;

    @JSONField(name = ShareType.FILE_URL)
    private String fileUrl;
    private String token;

    public DeleteImageData() {
    }

    public final String getFileToken() {
        return this.fileToken;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setFileToken(String r100) {
        this.fileToken = r100;
    }

    public final void setFileUrl(String r100) {
        this.fileUrl = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }
}
