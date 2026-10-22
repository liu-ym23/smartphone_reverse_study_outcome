package com.bytedance.ee.bear.integrator.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class FileClickModel implements Serializable {
    private String downLoadPath;
    private String drive_file_key;
    private String file_id;
    private String file_mime_type;
    private String file_name;
    private long file_size;
    private String mount_node_token;
    private String mount_point;
    private int type;

    public FileClickModel() {
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

    public String getMount_node_token() {
        return this.mount_node_token;
    }

    public String getMount_point() {
        return this.mount_point;
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

    public void setMount_node_token(String r100) {
        this.mount_node_token = r100;
    }

    public void setMount_point(String r100) {
        this.mount_point = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
