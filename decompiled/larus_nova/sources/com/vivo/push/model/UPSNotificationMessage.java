package com.vivo.push.model;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class UPSNotificationMessage {
    public static final int CUSTOM = 3;
    public static final int ISMACROREPLACE = 1;
    public static final int OPENACTIVITY = 4;
    public static final int OPENAPP = 1;
    public static final int OPENURL = 2;
    public static final int UNKNOWN = 0;
    private String mAdClickCheckUrl;
    private int mCompatibleType;
    private String mContent;
    private String mCoverUrl;
    private String mCustomValue;
    private int mExtentStatus;
    private String mIconUrl;
    private int mIsMacroReplace;
    private long mMsgArriveTime;
    private long mMsgId;
    private int mNotifyType;
    private Map<String, String> mParams;
    private String mPurePicUrl;
    private boolean mShowTime;
    private String mSkipContent;
    private int mSkipType;
    private int mTargetType;
    private String mTitle;
    private String mTragetContent;

    public interface ExtentStatusFlag {
        public static final int APP_INSTALL_SHOW_NOTIFICATION = 1;
    }

    public void clearCoverUrl() {
        this.mIconUrl = "";
    }

    public void clearPurePicUrl() {
        this.mPurePicUrl = "";
    }

    public boolean isMacroReplace() {
        if (this.mIsMacroReplace != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "UPSNotificationMessage{mTargetType=" + this.mTargetType + ", mTragetContent='" + this.mTragetContent + "', mTitle='" + this.mTitle + "', mContent='" + this.mContent + "', mNotifyType=" + this.mNotifyType + ", mPurePicUrl='" + this.mPurePicUrl + "', mIconUrl='" + this.mIconUrl + "', mCoverUrl='" + this.mCoverUrl + "', mSkipContent='" + this.mSkipContent + "', mSkipType=" + this.mSkipType + ", mShowTime=" + this.mShowTime + ", mMsgId=" + this.mMsgId + ", mParams=" + this.mParams + ", mIsMacroReplace=" + this.mIsMacroReplace + ", mAdClickCheckUrl='" + this.mAdClickCheckUrl + "', mCompatibleType=" + this.mCompatibleType + ", mExtentStatus=" + this.mExtentStatus + ", mCustomValue='" + this.mCustomValue + "', mMsgArriveTime=" + this.mMsgArriveTime + '}';
    }

    public UPSNotificationMessage() {
        this.mParams = new HashMap();
    }

    public String getThirdPackageName() {
        if (getExtentStatus() == 1) goto L5;
        return null;
    L5:
        return getCustomValue();
    }

    public boolean isAppInstallCompleteMsg() {
        if (getExtentStatus() == 1) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(getCustomValue()) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public String getAdClickCheckUrl() {
        return this.mAdClickCheckUrl;
    }

    public int getCompatibleType() {
        return this.mCompatibleType;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public String getCustomValue() {
        return this.mCustomValue;
    }

    public int getExtentStatus() {
        return this.mExtentStatus;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public int getIsMacroReplace() {
        return this.mIsMacroReplace;
    }

    public long getMsgArriveTime() {
        return this.mMsgArriveTime;
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public int getNotifyType() {
        return this.mNotifyType;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public String getPurePicUrl() {
        return this.mPurePicUrl;
    }

    public String getSkipContent() {
        return this.mSkipContent;
    }

    public int getSkipType() {
        return this.mSkipType;
    }

    public String getTargetContent() {
        return this.mTragetContent;
    }

    public int getTargetType() {
        return this.mTargetType;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isShowTime() {
        return this.mShowTime;
    }

    public void setAdClickCheckUrl(String r100) {
        this.mAdClickCheckUrl = r100;
    }

    public void setCompatibleType(int r100) {
        this.mCompatibleType = r100;
    }

    public void setContent(String r100) {
        this.mContent = r100;
    }

    public void setCoverUrl(String r100) {
        this.mCoverUrl = r100;
    }

    public void setCustomValue(String r100) {
        this.mCustomValue = r100;
    }

    public void setExtentStatus(int r100) {
        this.mExtentStatus = r100;
    }

    public void setIconUrl(String r100) {
        this.mIconUrl = r100;
    }

    public void setIsMacroReplace(int r100) {
        this.mIsMacroReplace = r100;
    }

    public void setMsgArriveTime(long r100) {
        this.mMsgArriveTime = r100;
    }

    public void setMsgId(long r100) {
        this.mMsgId = r100;
    }

    public void setNotifyType(int r100) {
        this.mNotifyType = r100;
    }

    public void setParams(Map<String, String> r100) {
        this.mParams = r100;
    }

    public void setPurePicUrl(String r100) {
        this.mPurePicUrl = r100;
    }

    public void setShowTime(boolean r100) {
        this.mShowTime = r100;
    }

    public void setSkipContent(String r100) {
        this.mSkipContent = r100;
    }

    public void setSkipType(int r100) {
        this.mSkipType = r100;
    }

    public void setTargetContent(String r100) {
        this.mTragetContent = r100;
    }

    public void setTargetType(int r100) {
        this.mTargetType = r100;
    }

    public void setTitle(String r100) {
        this.mTitle = r100;
    }
}
