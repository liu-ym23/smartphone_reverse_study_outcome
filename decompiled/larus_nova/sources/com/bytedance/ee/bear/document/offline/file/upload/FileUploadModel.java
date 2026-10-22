package com.bytedance.ee.bear.document.offline.file.upload;

import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class FileUploadModel implements NonProguard {
    public static final String EXTRA_PARAMS_KEY = "extraParams";
    public static final String EXTRA_RUST_KEY = "extRust";
    public static final int FILE_PASTE_DRIVE = 2;
    public static final int FILE_UPLOAD_DOC = 0;
    public static final int FILE_UPLOAD_DRIVE = 1;
    public static final String FROM_COMMENT = "comment";
    private static final String TAG = "FileUploadModel";
    private String contentType;
    private String doc_url;
    private Boolean exitStillUpload;
    private String fileName;
    private String file_url;
    private String from;
    private Map<String, String> headers;
    private String method;
    private Map<String, String> multiparts;
    private String pencilKitToken;
    private Boolean progress;
    private int size;
    private String token;
    private String type;
    private Map<String, String> uploadParams;
    private int uploadType;
    private String url;
    private String[] uuids;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FILE_UPLOAD_TYPE {
    }

    public boolean isFolderBlockScene() {
        Map<String, String> r100 = this.uploadParams;     // Catch: Exception -> L12
        if (r100 != null) goto L6;
        return false;
    L6:
        String r101 = r100.get("isFolderBlockScene");     // Catch: Exception -> L12
        if (r101 == null) goto L17;
        if (Boolean.parseBoolean(r101) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        e = move-exception;
        tt5.a.d(TAG, "isFolderBlockScene fail: " + e);
        return false;
    }

    public String getDriveToken() {
        Map<String, String> r100 = this.uploadParams;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.get("drive_token");
    }

    public String getMountNodeToken() {
        Map<String, String> r100 = this.uploadParams;
        if (r100 == null) goto L7;
        String r101 = r100.get(DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN);
        if (r101 == null) goto L9;
        return r101;
    L9:
        return "";
    L7:
        return "";
    }

    public String getMountPoint() {
        Map<String, String> r100 = this.uploadParams;
        if (r100 == null) goto L7;
        String r101 = r100.get(DrivePreviewOpenItem.EXTRA_MOUNT_POINT);
        if (r101 == null) goto L9;
        return r101;
    L9:
        return "";
    L7:
        return "";
    }

    public int getObjType() {
        sbb.e r100 = sbb.e.f541296g;
        int r101 = r100.f541317b;
        Map<String, String> r102 = this.uploadParams;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return yu5.c.f(r102.get("obj_type"), r100.f541317b);
    }

    public String toString() {
        return "FileUploadModel{url='" + yu5.c.j(this.url) + "', uuids=" + Arrays.toString(this.uuids) + ", method='" + this.method + "', file_url='" + yu5.c.j(this.file_url) + "', token='" + yu5.c.j(this.token) + "', driveToken='" + yu5.c.j(getDriveToken()) + "', pencilKitToken='" + yu5.c.j(this.pencilKitToken) + "', doc_url='" + yu5.c.j(this.doc_url) + "', type='" + this.type + "', size=" + this.size + ", uploadType=" + this.uploadType + ", contentType=" + this.contentType + ", exitStillUpload=" + this.exitStillUpload + '}';
    }

    public FileUploadModel() {
        this.contentType = "image";
        Boolean r100 = Boolean.FALSE;
        this.progress = r100;
        this.exitStillUpload = r100;
    }

    public String fetchFirstUuid() {
        if (getUuids() != null) goto L5;
        return "";
    L5:
        if (getUuids().length != 0) goto L8;
        return "";
    L8:
        return getUuids()[0];
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getDoc_url() {
        return this.doc_url;
    }

    public Boolean getExitStillUpload() {
        return this.exitStillUpload;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFile_url() {
        return this.file_url;
    }

    public String getFrom() {
        return this.from;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public Map<String, String> getMultiparts() {
        return this.multiparts;
    }

    public String getPencilKitToken() {
        return this.pencilKitToken;
    }

    public Boolean getProgress() {
        return this.progress;
    }

    public int getSize() {
        return this.size;
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public Map<String, String> getUploadParams() {
        return this.uploadParams;
    }

    public int getUploadType() {
        return this.uploadType;
    }

    public String getUrl() {
        return this.url;
    }

    public String[] getUuids() {
        return this.uuids;
    }

    public FileUploadModel(Map<String, String> r100) {
        this.contentType = "image";
        Boolean r101 = Boolean.FALSE;
        this.progress = r101;
        this.exitStillUpload = r101;
        this.uploadParams = r100;
    }

    public void setContentType(String r100) {
        this.contentType = r100;
    }

    public void setDoc_url(String r100) {
        this.doc_url = r100;
    }

    public void setExitStillUpload(Boolean r100) {
        this.exitStillUpload = r100;
    }

    public void setFileName(String r100) {
        this.fileName = r100;
    }

    public void setFile_url(String r100) {
        this.file_url = r100;
    }

    public void setFrom(String r100) {
        this.from = r100;
    }

    public void setHeaders(Map<String, String> r100) {
        this.headers = r100;
    }

    public void setMethod(String r100) {
        this.method = r100;
    }

    public void setMultiparts(Map<String, String> r100) {
        this.multiparts = r100;
    }

    public void setPencilKitToken(String r100) {
        this.pencilKitToken = r100;
    }

    public void setProgress(Boolean r100) {
        this.progress = r100;
    }

    public void setSize(int r100) {
        this.size = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public void setUploadParams(Map<String, String> r100) {
        this.uploadParams = r100;
    }

    public void setUploadType(int r100) {
        this.uploadType = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setUuids(String[] r100) {
        this.uuids = r100;
    }
}
