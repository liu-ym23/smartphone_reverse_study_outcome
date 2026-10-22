package com.bytedance.ee.bear.bizwidget.sharepermissiondialog;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BottomPopupData implements NonProguard {
    public static final String Default = "default";
    public static final String GlobalComment = "globalComment";
    private String actionSource;
    private String cancelBtnText;
    private String confirmBtnText;
    private String des;
    private String sendLarkText;
    private boolean showCheckBox;
    private String title;

    public BottomPopupData() {
        this.showCheckBox = true;
    }

    public String getActionSource() {
        return this.actionSource;
    }

    public String getCancelBtnText() {
        return this.cancelBtnText;
    }

    public String getConfirmBtnText() {
        return this.confirmBtnText;
    }

    public String getDes() {
        return this.des;
    }

    public String getSendLarkText() {
        return this.sendLarkText;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isShowCheckBox() {
        return this.showCheckBox;
    }

    public void setActionSource(String r1) {
        this.actionSource = r1;
    }

    public void setCancelBtnText(String r1) {
        this.cancelBtnText = r1;
    }

    public void setConfirmBtnText(String r1) {
        this.confirmBtnText = r1;
    }

    public void setDes(String r1) {
        this.des = r1;
    }

    public void setSendLarkText(String r1) {
        this.sendLarkText = r1;
    }

    public void setShowCheckBox(boolean r1) {
        this.showCheckBox = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }
}
