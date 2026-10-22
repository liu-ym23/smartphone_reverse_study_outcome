package com.bytedance.ee.bear.document.plugin.upload;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/upload/DownloadFileModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fileToken", "", "getFileToken", "()Ljava/lang/String;", "setFileToken", "(Ljava/lang/String;)V", "mountPointType", "getMountPointType", "setMountPointType", "suffix", "getSuffix", "setSuffix", "fileName", "getFileName", "setFileName", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DownloadFileModel implements NonProguard {
    private String fileName;
    private String fileToken;
    private String mountPointType;
    private String suffix;

    public DownloadFileModel() {
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFileToken() {
        return this.fileToken;
    }

    public final String getMountPointType() {
        return this.mountPointType;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setFileToken(String r100) {
        this.fileToken = r100;
    }

    public final void setMountPointType(String r100) {
        this.mountPointType = r100;
    }

    public final void setSuffix(String r100) {
        this.suffix = r100;
    }
}
