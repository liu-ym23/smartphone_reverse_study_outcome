package com.vivo.push.model;

/* JADX INFO: loaded from: classes41.dex */
public class InsideNotificationItem extends UPSNotificationMessage {
    private int mAppType;
    private int mDisplayStyle;
    private int mInnerPriority;
    private boolean mIsShowBigPicOnMobileNet;
    private int mMessageBizType;
    private int mMessageType;
    private boolean mNoShowOnForeground;
    private int mNotifyDisplayStatus;
    private String mReactPackage;
    private String mSuitReactVersion;
    private String mWindowPeriod;

    public void noShowOnForeground() {
        this.mNoShowOnForeground = true;
    }

    private int parsingNotifyStyle() {
        int r100 = this.mDisplayStyle;
        if ((r100 & 32) == 0) goto L6;
        return 0;
    L6:
        if ((r100 & 16) == 0) goto L9;
        return 1;
    L9:
        return 0;
    }

    public boolean isOperateMsg() {
        if (this.mMessageBizType != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public InsideNotificationItem() {
        this.mNoShowOnForeground = false;
    }

    public int getAppType() {
        return this.mAppType;
    }

    public int getDisplayStyle() {
        return this.mDisplayStyle;
    }

    public int getInnerPriority() {
        return this.mInnerPriority;
    }

    public int getMessageBizType() {
        return this.mMessageBizType;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public int getNotifyDisplayStatus() {
        return this.mNotifyDisplayStatus;
    }

    public String getReactPackage() {
        return this.mReactPackage;
    }

    public String getSuitReactVersion() {
        return this.mSuitReactVersion;
    }

    public String getWindowPeriod() {
        return this.mWindowPeriod;
    }

    public boolean isNoShowOnForeground() {
        return this.mNoShowOnForeground;
    }

    public boolean isShowBigPicOnMobileNet() {
        return this.mIsShowBigPicOnMobileNet;
    }

    public void setAppType(int r100) {
        this.mAppType = r100;
    }

    public void setDisplayStyle(int r100) {
        this.mDisplayStyle = r100;
        this.mNotifyDisplayStatus = parsingNotifyStyle();
    }

    public void setInnerPriority(int r100) {
        this.mInnerPriority = r100;
    }

    public void setIsShowBigPicOnMobileNet(boolean r100) {
        this.mIsShowBigPicOnMobileNet = r100;
    }

    public void setMessageBizType(int r100) {
        this.mMessageBizType = r100;
    }

    public void setMessageType(int r100) {
        this.mMessageType = r100;
    }

    public void setReactPackage(String r100) {
        this.mReactPackage = r100;
    }

    public void setSuitReactVersion(String r100) {
        this.mSuitReactVersion = r100;
    }

    public void setWindowPeriod(String r100) {
        this.mWindowPeriod = r100;
    }
}
