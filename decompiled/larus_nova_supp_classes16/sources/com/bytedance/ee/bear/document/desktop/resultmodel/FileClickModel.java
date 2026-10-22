package com.bytedance.ee.bear.document.desktop.resultmodel;

import com.alibaba.fastjson.annotation.JSONField;
import du5.b;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileClickModel implements Serializable {
    private String downLoadPath;
    private String drive_file_key;
    private String file_id;
    private String file_mime_type;
    private String file_name;
    private long file_size;

    @JSONField(name = "host_token")
    private String hostToken;

    @JSONField(name = "host_type")
    private int hostType;
    private String mount_node_token;
    private String mount_point;
    private String preview_from;
    private int type;

    public String toString() {
        return "FileClickModel{, file_mime_type='" + this.file_mime_type + "', file_size=" + this.file_size + ", type=" + this.type + ", mount_node_token='" + b.g(this.mount_node_token) + "', preview_from=" + this.preview_from + ", host_token = ' " + b.g(this.hostToken) + "'}";
    }

    public FileClickModel() {
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

    public String getHostToken() {
        return this.hostToken;
    }

    public int getHostType() {
        return this.hostType;
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

    public void setDownLoadPath(String r1) {
        this.downLoadPath = r1;
    }

    public void setDrive_file_key(String r1) {
        this.drive_file_key = r1;
    }

    public void setFile_id(String r1) {
        this.file_id = r1;
    }

    public void setFile_mime_type(String r1) {
        this.file_mime_type = r1;
    }

    public void setFile_name(String r1) {
        this.file_name = r1;
    }

    public void setFile_size(long r1) {
        this.file_size = r1;
    }

    public void setHostToken(String r1) {
        this.hostToken = r1;
    }

    public void setHostType(int r1) {
        this.hostType = r1;
    }

    public void setMount_node_token(String r1) {
        this.mount_node_token = r1;
    }

    public void setMount_point(String r1) {
        this.mount_point = r1;
    }

    public void setPreview_from(String r1) {
        this.preview_from = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }
}
