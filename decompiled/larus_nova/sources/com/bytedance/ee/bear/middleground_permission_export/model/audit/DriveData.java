package com.bytedance.ee.bear.middleground_permission_export.model.audit;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010#\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001e\u0010%\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/audit/DriveData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "getType", "()Lcom/ss/android/lark/docs/icon/util/DocumentType;", "setType", "(Lcom/ss/android/lark/docs/icon/util/DocumentType;)V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "name", "getName", "setName", DBDefinition.MIME_TYPE, "getMimeType", "setMimeType", "appId", "getAppId", "setAppId", "appFileId", "getAppFileId", "setAppFileId", "localFile", "", "getLocalFile", "()Ljava/lang/Boolean;", "setLocalFile", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isImage", "setImage", "isVideo", "setVideo", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveData implements NonProguard {
    private String appFileId;
    private String appId;
    private Boolean isImage;
    private Boolean isVideo;
    private Boolean localFile;
    private String mimeType;
    private String name;
    private String token;
    private e type;

    public DriveData() {
        this.localFile = Boolean.FALSE;
    }

    public final String getAppFileId() {
        return this.appFileId;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Boolean getLocalFile() {
        return this.localFile;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getName() {
        return this.name;
    }

    public final String getToken() {
        return this.token;
    }

    public final e getType() {
        return this.type;
    }

    public final Boolean isImage() {
        return this.isImage;
    }

    public final Boolean isVideo() {
        return this.isVideo;
    }

    public final void setAppFileId(String r100) {
        this.appFileId = r100;
    }

    public final void setAppId(String r100) {
        this.appId = r100;
    }

    public final void setImage(Boolean r100) {
        this.isImage = r100;
    }

    public final void setLocalFile(Boolean r100) {
        this.localFile = r100;
    }

    public final void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }

    public final void setType(e r100) {
        this.type = r100;
    }

    public final void setVideo(Boolean r100) {
        this.isVideo = r100;
    }
}
