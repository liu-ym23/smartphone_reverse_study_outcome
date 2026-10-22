package com.heytap.msp.push.mode;

import android.text.TextUtils;
import com.heytap.mcssdk.utils.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class MessageStat {
    private static final String APP_PACKAGE = "appPackage";
    private static final String DATA_EXTRA = "data_extra";
    private static final String EVENT_ID = "eventID";
    private static final String EVENT_TIME = "eventTime";
    private static final String GLOBAL_ID = "globalID";
    private static final String MESSAGE_TYPE = "messageType";
    private static final String PROPERTY = "property";
    private static final String STATISTICS_EXTRA = "statistics_extra";
    private static final String TASK_ID = "taskID";
    private String mAppPackage;
    private String mDataExtra;
    private String mEventId;
    private long mEventTime;
    private String mGlobalId;
    private String mProperty;
    private String mStatisticsExtra;
    private String mTaskID;
    private int mType;

    public MessageStat() {
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
    }

    public MessageStat(int r100, String r101, String r110, String r111) {
        this(r100, r101, null, null, r110, r111);
    }

    public MessageStat(int r110, String r111, String r112, String r113, String r114, String r115) {
        this(r110, r111, r112, r113, r114, r115, "", "");
    }

    public MessageStat(int r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110) {
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
        setType(r100);
        setAppPackage(r101);
        setGlobalId(r102);
        setTaskID(r103);
        setEventId(r104);
        setProperty(r105);
        setStatisticsExtra(r106);
        setDataExtra(r110);
    }

    public MessageStat(String r100, String r101) {
        this(4096, r100, null, null, r101, "");
    }

    public MessageStat(String r100, String r101, String r110) {
        this(4096, r100, null, null, r101, r110);
    }

    public static MessageStat parse(String r100) {
        MessageStat r101 = new MessageStat();
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L5
        r101.setType(r102.optInt(MESSAGE_TYPE, 0));     // Catch: Exception -> L5
        r101.setAppPackage(r102.optString("appPackage"));     // Catch: Exception -> L5
        r101.setEventId(r102.optString(EVENT_ID));     // Catch: Exception -> L5
        r101.setGlobalId(r102.optString("globalID", ""));     // Catch: Exception -> L5
        r101.setTaskID(r102.optString("taskID", ""));     // Catch: Exception -> L5
        r101.setProperty(r102.optString("property", ""));     // Catch: Exception -> L5
        r101.setEventTime(r102.optLong(EVENT_TIME, System.currentTimeMillis()));     // Catch: Exception -> L5
        r101.setStatisticsExtra(r102.optString("statistics_extra"));     // Catch: Exception -> L5
        r101.setDataExtra(r102.optString("data_extra"));     // Catch: Exception -> L5
        return r101;
    L5:
        e = move-exception;
        d.e(e.getLocalizedMessage());
        return null;
    }

    public String getAppPackage() {
        return this.mAppPackage;
    }

    public String getDataExtra() {
        return this.mDataExtra;
    }

    public String getEventId() {
        return this.mEventId;
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public String getGlobalId() {
        return this.mGlobalId;
    }

    public String getProperty() {
        return this.mProperty;
    }

    public String getStatisticsExtra() {
        return this.mStatisticsExtra;
    }

    public String getTaskID() {
        return this.mTaskID;
    }

    public int getType() {
        return this.mType;
    }

    public void setAppPackage(String r100) {
        this.mAppPackage = r100;
    }

    public void setDataExtra(String r100) {
        this.mDataExtra = r100;
    }

    public void setEventId(String r100) {
        this.mEventId = r100;
    }

    public void setEventTime(long r100) {
        this.mEventTime = r100;
    }

    public void setGlobalId(String r100) {
        this.mGlobalId = r100;
    }

    public void setProperty(String r100) {
        this.mProperty = r100;
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

    public void setType(int r100) {
        this.mType = r100;
    }

    public String toJsonObject() {
        JSONObject r100 = new JSONObject();
        r100.putOpt(MESSAGE_TYPE, Integer.valueOf(this.mType));     // Catch: Exception -> L19
        r100.putOpt(EVENT_ID, this.mEventId);     // Catch: Exception -> L19
        r100.putOpt("appPackage", this.mAppPackage);     // Catch: Exception -> L19
        r100.putOpt(EVENT_TIME, Long.valueOf(this.mEventTime));     // Catch: Exception -> L19
        if (TextUtils.isEmpty(this.mGlobalId) == true) goto L7;
        r100.putOpt("globalID", this.mGlobalId);     // Catch: Exception -> L19
    L7:
        if (TextUtils.isEmpty(this.mTaskID) == true) goto L10;
        r100.putOpt("taskID", this.mTaskID);     // Catch: Exception -> L19
    L10:
        if (TextUtils.isEmpty(this.mProperty) == true) goto L13;
        r100.putOpt("property", this.mProperty);     // Catch: Exception -> L19
    L13:
        if (TextUtils.isEmpty(this.mStatisticsExtra) == true) goto L16;
        r100.putOpt("statistics_extra", this.mStatisticsExtra);     // Catch: Exception -> L19
    L16:
        if (TextUtils.isEmpty(this.mDataExtra) == true) goto L22;
        r100.putOpt("data_extra", this.mDataExtra);     // Catch: Exception -> L19
    L22:
        return r100.toString();
    L19:
        e = move-exception;
        d.e(e.getLocalizedMessage());
        goto L22
    }
}
