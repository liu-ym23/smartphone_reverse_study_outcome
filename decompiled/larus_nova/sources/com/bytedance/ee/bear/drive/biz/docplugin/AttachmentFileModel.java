package com.bytedance.ee.bear.drive.biz.docplugin;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class AttachmentFileModel implements NonProguard {

    @JSONField(name = "bussinessId")
    private String bussinessId;

    @JSONField(name = "encryptId")
    private String encryptId;

    @JSONField(name = "extra")
    private String extra;

    @JSONField(name = "file_mime_type")
    private String fileMimeType;

    @JSONField(name = "file_name")
    private String fileName;

    @JSONField(name = "file_size")
    private long fileSize;

    @JSONField(name = "file_token")
    private String fileToken;

    @JSONField(name = "host_token")
    private String hostToken;

    @JSONField(name = "host_type")
    private int hostType;

    @JSONField(name = DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN)
    private String mountNodeToken;

    @JSONField(name = DrivePreviewOpenItem.EXTRA_MOUNT_POINT)
    private String mountPoint;

    @JSONField(name = "srcObjToken")
    private String srcObjToken;

    @JSONField(name = "srcObjType")
    private int srcObjType;

    public AttachmentFileModel() {
    }

    public String toString() {
        return "AttachmentFileModel{fileToken='" + du5.b.i(this.fileToken) + "', fileName='" + du5.b.g(this.fileName) + "', fileSize=" + this.fileSize + ", hostToken='" + du5.b.i(this.hostToken) + "', hostType=" + this.hostType + ", srcObjToken='" + du5.b.i(this.srcObjToken) + "', srcObjType=" + this.srcObjType + ", encryptId='" + du5.b.i(this.encryptId) + "', fileMimeType='" + this.fileMimeType + "', mountNodeToken='" + du5.b.g(this.mountNodeToken) + "', mountPoint='" + this.mountPoint + "', bussinessId='" + this.bussinessId + "'}";
    }

    public String getBussinessId() {
        return this.bussinessId;
    }

    public String getEncryptId() {
        return this.encryptId;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getFileMmeType() {
        return this.fileMimeType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public String getHostToken() {
        return this.hostToken;
    }

    public int getHostType() {
        return this.hostType;
    }

    public String getMountNodeToken() {
        return this.mountNodeToken;
    }

    public String getMountPoint() {
        return this.mountPoint;
    }

    public String getSrcObjToken() {
        return this.srcObjToken;
    }

    public int getSrcObjType() {
        return this.srcObjType;
    }

    public void setBussinessId(String r100) {
        this.bussinessId = r100;
    }

    public void setEncryptId(String r100) {
        this.encryptId = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setFileMemeType(String r100) {
        this.fileMimeType = r100;
    }

    public void setFileName(String r100) {
        this.fileName = r100;
    }

    public void setFileSize(long r100) {
        this.fileSize = r100;
    }

    public void setFileToken(String r100) {
        this.fileToken = r100;
    }

    public void setHostToken(String r100) {
        this.hostToken = r100;
    }

    public void setHostType(int r100) {
        this.hostType = r100;
    }

    public void setMountNodeToken(String r100) {
        this.mountNodeToken = r100;
    }

    public void setMountPoint(String r100) {
        this.mountPoint = r100;
    }

    public void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public void setSrcObjType(int r100) {
        this.srcObjType = r100;
    }
}
