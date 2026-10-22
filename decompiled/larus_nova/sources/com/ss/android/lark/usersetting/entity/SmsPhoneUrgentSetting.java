package com.ss.android.lark.usersetting.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class SmsPhoneUrgentSetting implements Serializable {
    private boolean accept;
    private boolean canModify;
    private boolean canSend;
    private boolean needConfirm;

    public SmsPhoneUrgentSetting() {
    }

    public boolean isAccept() {
        return this.accept;
    }

    public boolean isCanModify() {
        return this.canModify;
    }

    public boolean isCanSend() {
        return this.canSend;
    }

    public boolean isNeedConfirm() {
        return this.needConfirm;
    }

    public void setAccept(boolean r100) {
        this.accept = r100;
    }

    public void setCanModify(boolean r100) {
        this.canModify = r100;
    }

    public void setCanSend(boolean r100) {
        this.canSend = r100;
    }

    public void setNeedConfirm(boolean r100) {
        this.needConfirm = r100;
    }

    public SmsPhoneUrgentSetting(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.accept = r100;
        this.canModify = r101;
        this.needConfirm = r102;
        this.canSend = r103;
    }
}
