package com.bytedance.ee.bear.document.offline.sync.preloadtask;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadtask/EmbedDocList;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fileType", "", "getFileType", "()Ljava/lang/Integer;", "setFileType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmbedDocList implements NonProguard {
    private Integer fileType;
    private String token;

    public EmbedDocList() {
    }

    public String toString() {
        return "EmbedDocList(fileType=" + this.fileType + ", token=" + b.g(this.token) + ')';
    }

    public final Integer getFileType() {
        return this.fileType;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setFileType(Integer r1) {
        this.fileType = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }
}
