package com.bytedance.ee.bear.middleground.permission.setting.linkshare;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class LinkShareItem implements NonProguard {
    public static final int BITABLE_SHARE_LINK_ITEM = 14;
    public static final int CLOSE_LINK_SHARE = 1;
    public static final int CONSUMER_LINK_CAN_EDIT = 8;
    public static final int CONSUMER_LINK_CAN_READ = 7;
    public static final int FORM_KNOW_LINK_CAN_CAN_FILL_IN = 11;
    public static final int FORM_ONLY_INVITEE_CAN_FILL_IN = 9;
    public static final int FORM_ORG_CAN_FILL_IN = 10;
    public static final int KNOWN_LINK_CAN_EDIT = 6;
    public static final int KNOWN_LINK_CAN_READ = 5;
    public static final int NOT_OWNER_CLOSE_LINK_SHARE = 2;
    public static final int NO_SET_ITEM = -1;
    public static final int ORG_CAN_EDIT = 4;
    public static final int ORG_CAN_READ = 3;
    public static final int PARTNER_TENANT_CAN_EDIT = 13;
    public static final int PARTNER_TENANT_CAN_READ = 12;
    private String description;
    private String disableTips;
    private boolean enable;
    private int type;

    public String toString() {
        return "LinkShareItem{type=" + this.type + ", description='" + this.description + "', enable=" + this.enable + ", disableTips='" + this.disableTips + "'}";
    }

    public String getDescription() {
        return this.description;
    }

    public String getDisableTips() {
        return this.disableTips;
    }

    public int getType() {
        return this.type;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setDisableTips(String r100) {
        this.disableTips = r100;
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public LinkShareItem(int r100, String r101) {
        this.enable = true;
        this.disableTips = "";
        this.type = r100;
        this.description = r101;
    }

    public LinkShareItem(int r100, String r101, boolean r102, String r103) {
        this.type = r100;
        this.description = r101;
        this.enable = r102;
        this.disableTips = r103;
    }
}
