package com.heytap.msp.push.mode;

/* JADX INFO: loaded from: classes23.dex */
public class DataMessage extends BaseMode {
    private String mAppId;
    private String mAppPackage;
    private String mBalanceTime;
    private String mContent;
    private String mDataExtra;
    private String mDescription;
    private String mDistinctContent;
    private String mEndDate;
    private String mEventId;
    private String mForcedDelivery;
    private String mGlobalId;
    private String mMessageID;
    private int mMessageType;
    private String mMiniProgramPkg;
    private int mMsgCommand;
    private int mNotifyID;
    private String mRule;
    private String mStartDate;
    private String mStatisticsExtra;
    private String mTaskID;
    private String mTimeRanges;
    private String mTitle;

    public DataMessage() {
        this.mTaskID = "";
        this.mMiniProgramPkg = "";
    }

    public DataMessage(String r100, String r101) {
        this.mTaskID = "";
        this.mMiniProgramPkg = "";
        this.mAppPackage = r100;
        this.mGlobalId = r101;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppPackage() {
        return this.mAppPackage;
    }

    public String getBalanceTime() {
        return this.mBalanceTime;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getDataExtra() {
        return this.mDataExtra;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getDistinctContent() {
        return this.mDistinctContent;
    }

    public String getEndDate() {
        return this.mEndDate;
    }

    public String getEventId() {
        return this.mEventId;
    }

    public String getForcedDelivery() {
        return this.mForcedDelivery;
    }

    public String getGlobalId() {
        return this.mGlobalId;
    }

    public String getMessageID() {
        return this.mMessageID;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public String getMiniProgramPkg() {
        return this.mMiniProgramPkg;
    }

    public int getMsgCommand() {
        return this.mMsgCommand;
    }

    public int getNotifyID() {
        return this.mNotifyID;
    }

    public String getRule() {
        return this.mRule;
    }

    public String getStartDate() {
        return this.mStartDate;
    }

    public String getStatisticsExtra() {
        return this.mStatisticsExtra;
    }

    public String getTaskID() {
        return this.mTaskID;
    }

    public String getTimeRanges() {
        return this.mTimeRanges;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return 4103;
    }

    public void setAppId(String r100) {
        this.mAppId = r100;
    }

    public void setAppPackage(String r100) {
        this.mAppPackage = r100;
    }

    public void setBalanceTime(String r100) {
        this.mBalanceTime = r100;
    }

    public void setContent(String r100) {
        this.mContent = r100;
    }

    public void setDataExtra(String r100) {
        this.mDataExtra = r100;
    }

    public void setDescription(String r100) {
        this.mDescription = r100;
    }

    public void setDistinctContent(String r100) {
        this.mDistinctContent = r100;
    }

    public void setEndDate(String r100) {
        this.mEndDate = r100;
    }

    public void setEventId(String r100) {
        this.mEventId = r100;
    }

    public void setForcedDelivery(String r100) {
        this.mForcedDelivery = r100;
    }

    public void setGlobalId(String r100) {
        this.mGlobalId = r100;
    }

    public void setMessageID(String r100) {
        this.mMessageID = r100;
    }

    public void setMessageType(int r100) {
        this.mMessageType = r100;
    }

    public void setMiniProgramPkg(String r100) {
        this.mMiniProgramPkg = r100;
    }

    public void setMsgCommand(int r100) {
        this.mMsgCommand = r100;
    }

    public void setNotifyID(int r100) {
        this.mNotifyID = r100;
    }

    public void setRule(String r100) {
        this.mRule = r100;
    }

    public void setStartDate(String r100) {
        this.mStartDate = r100;
    }

    public void setStatisticsExtra(String r100) {
        this.mStatisticsExtra = r100;
    }

    public void setTaskID(int r100) {
        this.mTaskID = r100 + "";
    }

    public void setTaskID(String r100) {
        this.mTaskID = r100;
    }

    public void setTimeRanges(String r100) {
        this.mTimeRanges = r100;
    }

    public void setTitle(String r100) {
        this.mTitle = r100;
    }

    public String toString() {
        return "DataMessage{mMessageID='" + this.mMessageID + "'mMessageType='" + this.mMessageType + "'mAppPackage='" + this.mAppPackage + "', mTaskID='" + this.mTaskID + "'mTitle='" + this.mTitle + "'mNotifyID='" + this.mNotifyID + "', mContent='" + this.mContent + "', mGlobalId='" + this.mGlobalId + "', mBalanceTime='" + this.mBalanceTime + "', mStartDate='" + this.mStartDate + "', mEndDate='" + this.mEndDate + "', mTimeRanges='" + this.mTimeRanges + "', mRule='" + this.mRule + "', mForcedDelivery='" + this.mForcedDelivery + "', mDistinctContent='" + this.mDistinctContent + "', mAppId='" + this.mAppId + "'}";
    }
}
