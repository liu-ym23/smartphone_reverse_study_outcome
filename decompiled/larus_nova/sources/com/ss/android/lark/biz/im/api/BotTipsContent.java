package com.ss.android.lark.biz.im.api;

import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class BotTipsContent implements Serializable {
    private String adminId;
    private String adminName;
    private String msg;

    public BotTipsContent() {
    }

    public String getAdminId() {
        return this.adminId;
    }

    public String getAdminName() {
        return this.adminName;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setAdminId(String r100) {
        this.adminId = r100;
    }

    public void setAdminName(String r100) {
        this.adminName = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }

    public BotTipsContent(String r100, String r101, String r102) {
        this.msg = r100;
        this.adminId = r101;
        this.adminName = r102;
    }
}
