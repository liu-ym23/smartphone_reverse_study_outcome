package com.bytedance.ee.bear.drive.biz.permission.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class ThirdPartyAttachmentPermission implements Serializable {
    public static final int FLAG_ENABLE = 1;
    private int copy;
    private int edit;
    private int export;
    private PermissionV2 permV2;
    private String permV2Json;
    private int view;

    public static class PermissionV2 implements Serializable {
        private int copy;
        private int edit;
        private int export;
        private int view;

        public PermissionV2() {
        }

        public String toString() {
            return "PermissionV2{edit=" + this.edit + ", view=" + this.view + ", export=" + this.export + ", copy=" + this.copy + '}';
        }

        public int getCopy() {
            return this.copy;
        }

        public int getEdit() {
            return this.edit;
        }

        public int getExport() {
            return this.export;
        }

        public int getView() {
            return this.view;
        }

        public void setCopy(int r100) {
            this.copy = r100;
        }

        public void setEdit(int r100) {
            this.edit = r100;
        }

        public void setExport(int r100) {
            this.export = r100;
        }

        public void setView(int r100) {
            this.view = r100;
        }
    }

    public ThirdPartyAttachmentPermission() {
    }

    public String toString() {
        return "ThirdPartyAttachmentPermission{edit=" + this.edit + ", view=" + this.view + ", export=" + this.export + ", copy=" + this.copy + ", permV2=" + this.permV2 + '}';
    }

    public int getCopy() {
        return this.copy;
    }

    public int getEdit() {
        return this.edit;
    }

    public int getExport() {
        return this.export;
    }

    public PermissionV2 getPermV2() {
        return this.permV2;
    }

    public String getPermV2Json() {
        return this.permV2Json;
    }

    public int getView() {
        return this.view;
    }

    public void setCopy(int r100) {
        this.copy = r100;
    }

    public void setEdit(int r100) {
        this.edit = r100;
    }

    public void setExport(int r100) {
        this.export = r100;
    }

    public void setPermV2(PermissionV2 r100) {
        this.permV2 = r100;
    }

    public void setPermV2Json(String r100) {
        this.permV2Json = r100;
    }

    public void setView(int r100) {
        this.view = r100;
    }
}
