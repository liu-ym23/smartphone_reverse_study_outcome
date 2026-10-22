package com.bytedance.ee.bear.bizwidget.sharepermissiondialog;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setActionSource(String r100) {
        this.actionSource = r100;
    }

    public void setCancelBtnText(String r100) {
        this.cancelBtnText = r100;
    }

    public void setConfirmBtnText(String r100) {
        this.confirmBtnText = r100;
    }

    public void setDes(String r100) {
        this.des = r100;
    }

    public void setSendLarkText(String r100) {
        this.sendLarkText = r100;
    }

    public void setShowCheckBox(boolean r100) {
        this.showCheckBox = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
