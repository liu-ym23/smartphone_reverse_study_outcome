package com.larus.office.base.plugins.attachment;

import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR \u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR \u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR \u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR \u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR \u00104\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\t¨\u00067"}, d2 = {"Lcom/larus/office/base/plugins/attachment/AttachmentFileModel;", "", "<init>", "()V", "src", "", "getSrc", "()Ljava/lang/String;", "setSrc", "(Ljava/lang/String;)V", "fileToken", "getFileToken", "setFileToken", "fileName", "getFileName", "setFileName", "fileSize", "", "getFileSize", "()J", "setFileSize", "(J)V", "hostToken", "getHostToken", "setHostToken", "hostType", "", "getHostType", "()I", "setHostType", "(I)V", "srcObjToken", "getSrcObjToken", "setSrcObjToken", "srcObjType", "getSrcObjType", "setSrcObjType", "encryptId", "getEncryptId", "setEncryptId", "fileMmeType", "getFileMmeType", "setFileMmeType", "mountNodeToken", "getMountNodeToken", "setMountNodeToken", "mountPoint", "getMountPoint", "setMountPoint", "bussinessId", "getBussinessId", "setBussinessId", "extra", "getExtra", "setExtra", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentFileModel {

    @SerializedName("bussinessId")
    private String bussinessId;

    @SerializedName("encryptId")
    private String encryptId;

    @SerializedName("extra")
    private String extra;

    @SerializedName("file_mime_type")
    private String fileMmeType;

    @SerializedName("file_name")
    private String fileName;

    @SerializedName("file_size")
    private long fileSize;

    @SerializedName("file_token")
    private String fileToken;

    @SerializedName("host_token")
    private String hostToken;

    @SerializedName("host_type")
    private int hostType;

    @SerializedName(DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN)
    private String mountNodeToken;

    @SerializedName(DrivePreviewOpenItem.EXTRA_MOUNT_POINT)
    private String mountPoint;

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    @SerializedName("src")
    private String f360692src;

    @SerializedName("srcObjToken")
    private String srcObjToken;

    @SerializedName("srcObjType")
    private int srcObjType;

    public AttachmentFileModel() {
    }

    public final String getBussinessId() {
        return this.bussinessId;
    }

    public final String getEncryptId() {
        return this.encryptId;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getFileMmeType() {
        return this.fileMmeType;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final String getFileToken() {
        return this.fileToken;
    }

    public final String getHostToken() {
        return this.hostToken;
    }

    public final int getHostType() {
        return this.hostType;
    }

    public final String getMountNodeToken() {
        return this.mountNodeToken;
    }

    public final String getMountPoint() {
        return this.mountPoint;
    }

    public final String getSrc() {
        return this.f360692src;
    }

    public final String getSrcObjToken() {
        return this.srcObjToken;
    }

    public final int getSrcObjType() {
        return this.srcObjType;
    }

    public final void setBussinessId(String r100) {
        this.bussinessId = r100;
    }

    public final void setEncryptId(String r100) {
        this.encryptId = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setFileMmeType(String r100) {
        this.fileMmeType = r100;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setFileSize(long r100) {
        this.fileSize = r100;
    }

    public final void setFileToken(String r100) {
        this.fileToken = r100;
    }

    public final void setHostToken(String r100) {
        this.hostToken = r100;
    }

    public final void setHostType(int r100) {
        this.hostType = r100;
    }

    public final void setMountNodeToken(String r100) {
        this.mountNodeToken = r100;
    }

    public final void setMountPoint(String r100) {
        this.mountPoint = r100;
    }

    public final void setSrc(String r100) {
        this.f360692src = r100;
    }

    public final void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public final void setSrcObjType(int r100) {
        this.srcObjType = r100;
    }
}
