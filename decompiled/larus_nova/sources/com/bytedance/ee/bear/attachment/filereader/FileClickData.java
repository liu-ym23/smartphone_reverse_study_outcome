package com.bytedance.ee.bear.attachment.filereader;

import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes15.dex */
public class FileClickData implements Serializable {
    private String downLoadPath;
    private String drive_file_key;
    private String file_id;
    private String file_mime_type;
    private String file_name;
    private long file_size;
    private HostDocumentInfo hostDocumentInfo;
    private String mount_node_token;
    private String mount_point;
    private String preview_from;
    private int type;

    public String toString() {
        return "FileClickModel{, file_mime_type='" + this.file_mime_type + "', file_size=" + this.file_size + ", type=" + this.type + ", mount_node_token='" + du5.b.g(this.mount_node_token) + "', preview_from=" + this.preview_from + '}';
    }

    public FileClickData() {
        this.preview_from = "docs_attach";
    }

    public String getDownLoadPath() {
        return this.downLoadPath;
    }

    public String getDrive_file_key() {
        return this.drive_file_key;
    }

    public String getFile_id() {
        return this.file_id;
    }

    public String getFile_mime_type() {
        return this.file_mime_type;
    }

    public String getFile_name() {
        return this.file_name;
    }

    public long getFile_size() {
        return this.file_size;
    }

    public HostDocumentInfo getHostDocumentInfo() {
        return this.hostDocumentInfo;
    }

    public String getMount_node_token() {
        return this.mount_node_token;
    }

    public String getMount_point() {
        return this.mount_point;
    }

    public String getPreview_from() {
        return this.preview_from;
    }

    public int getType() {
        return this.type;
    }

    public void setDownLoadPath(String r100) {
        this.downLoadPath = r100;
    }

    public void setDrive_file_key(String r100) {
        this.drive_file_key = r100;
    }

    public void setFile_id(String r100) {
        this.file_id = r100;
    }

    public void setFile_mime_type(String r100) {
        this.file_mime_type = r100;
    }

    public void setFile_name(String r100) {
        this.file_name = r100;
    }

    public void setFile_size(long r100) {
        this.file_size = r100;
    }

    public void setHostDocumentInfo(HostDocumentInfo r100) {
        this.hostDocumentInfo = r100;
    }

    public void setMount_node_token(String r100) {
        this.mount_node_token = r100;
    }

    public void setMount_point(String r100) {
        this.mount_point = r100;
    }

    public void setPreview_from(String r100) {
        this.preview_from = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public FileClickData(String r100, String r101, String r102, String r103, long r104, int r105, String r106, String r110, String r111) {
        this.preview_from = "docs_attach";
        this.file_id = r100;
        this.drive_file_key = r101;
        this.file_name = r102;
        this.file_mime_type = r103;
        this.file_size = r104;
        this.type = r105;
        this.mount_node_token = r106;
        this.mount_point = r110;
        this.downLoadPath = r111;
    }

    public FileClickData(String r100, String r101, String r102, String r103, long r104, int r105, String r106, String r107, String r110, String r111) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110);
        this.preview_from = r111;
    }
}
