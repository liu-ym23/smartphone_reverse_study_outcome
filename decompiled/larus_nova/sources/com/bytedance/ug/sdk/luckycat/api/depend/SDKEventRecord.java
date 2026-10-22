package com.bytedance.ug.sdk.luckycat.api.depend;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010@R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R$\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R\"\u0010-\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010%\u001a\u0004\b-\u0010'\"\u0004\b.\u0010)R*\u00100\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u000e\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012R$\u00109\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0018\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001cR$\u0010<\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0018\u001a\u0004\b=\u0010\u001a\"\u0004\b>\u0010\u001c¨\u0006A"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/api/depend/SDKEventRecord;", "", "", DyPayConstant.KEY_START_TIME, "J", "getStartTime", "()J", "setStartTime", "(J)V", "endTime", "getEndTime", "setEndTime", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "", "alarmMinutes", "Ljava/lang/Integer;", "getAlarmMinutes", "()Ljava/lang/Integer;", "setAlarmMinutes", "(Ljava/lang/Integer;)V", com.heytap.mcssdk.constant.b.f276361k, "getEventId", "setEventId", "location", "getLocation", "setLocation", "", "allDay", "Z", "getAllDay", "()Z", "setAllDay", "(Z)V", "appUrl", "getAppUrl", "setAppUrl", "isRepeat", "setRepeat", "", "scheduledWeekDays", "Ljava/util/List;", "getScheduledWeekDays", "()Ljava/util/List;", "setScheduledWeekDays", "(Ljava/util/List;)V", "repeatFrequency", "getRepeatFrequency", "setRepeatFrequency", "repeatInterval", "getRepeatInterval", "setRepeatInterval", "repeatCount", "getRepeatCount", "setRepeatCount", "<init>", "()V", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class SDKEventRecord {

    @SerializedName("alarm_minutes")
    private Integer alarmMinutes;

    @SerializedName("all_day")
    private boolean allDay;

    @SerializedName("url")
    private String appUrl;

    @SerializedName("description")
    private String description;

    @SerializedName("end_time")
    private long endTime;

    @SerializedName("event_id")
    private String eventId;

    @SerializedName("is_repeat")
    private boolean isRepeat;

    @SerializedName("location")
    private String location;

    @SerializedName("repeat_count")
    private Integer repeatCount;

    @SerializedName("repeat_frequency")
    private String repeatFrequency;

    @SerializedName("repeat_interval")
    private Integer repeatInterval;

    @SerializedName("scheduled_weekdays")
    private List<Integer> scheduledWeekDays;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long startTime;

    @SerializedName("title")
    private String title;

    public final String toString() {
        return ArraysKt.joinToString$default(SDKEventRecord.class.getDeclaredFields(), null, "EventRecord(", ")", 0, null, new AnonymousClass1(this), 25, null);
    }

    public SDKEventRecord() {
        this.eventId = "";
        this.appUrl = "";
    }
}
