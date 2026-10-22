package com.bytedance.ee.bear.drive.biz.cache.manual.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class ManualOfflineSyncData implements Serializable {
    public static final String ACTION_UPDATE = "offWatchDriveUpdate";
    public static final String CHANNEL_DELETE = "delete";
    public static final String CHANNEL_IN_TRASH = "in_trash";
    public static final String CHANNEL_PERMISSION = "obj_permission_channel";
    public static final String CHANNEL_VERSION_UPDATE = "engine_channel";
    public static final String DRIVE_TYPE = "BOX";
    private static final long serialVersionUID = -4013248832365144741L;
    private DataBean data;
    private String token;
    private int type;

    public static class DataBean implements Serializable {
        private String channel;
        private int revision;
        private String token;
        private String type;

        public DataBean() {
        }

        public String getChannel() {
            return this.channel;
        }

        public int getRevision() {
            return this.revision;
        }

        public String getToken() {
            return this.token;
        }

        public String getType() {
            return this.type;
        }

        public void setChannel(String r100) {
            this.channel = r100;
        }

        public void setRevision(int r100) {
            this.revision = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }

        public void setType(String r100) {
            this.type = r100;
        }
    }

    public ManualOfflineSyncData() {
    }

    public DataBean getData() {
        return this.data;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public void setData(DataBean r100) {
        this.data = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
