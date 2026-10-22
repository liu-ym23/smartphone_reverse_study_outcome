package com.bytedance.timon.calendar;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bC\u0010DR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R$\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR$\u0010-\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0012R\"\u00100\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R*\u00104\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u000e\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R$\u0010=\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0018\u001a\u0004\b>\u0010\u001a\"\u0004\b?\u0010\u001cR$\u0010@\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0018\u001a\u0004\bA\u0010\u001a\"\u0004\bB\u0010\u001c¨\u0006E"}, d2 = {"Lcom/bytedance/timon/calendar/EventRecord;", "", "", DyPayConstant.KEY_START_TIME, "J", "m", "()J", "C", "(J)V", "endTime", "e", "t", "", "title", "Ljava/lang/String;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/lang/String;", "D", "(Ljava/lang/String;)V", "description", "d", "s", "", "alarmMinutes", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "p", "(Ljava/lang/Integer;)V", com.heytap.mcssdk.constant.b.f276361k, "f", "u", "location", "h", "w", "", "allDay", "Z", "b", "()Z", "q", "(Z)V", "hasAlarm", ce.f26391f, BaseSwitches.V, "appUrl", "c", "r", "isRepeat", "o", "x", "", "scheduledWeekDays", "Ljava/util/List;", "l", "()Ljava/util/List;", "B", "(Ljava/util/List;)V", "repeatFrequency", ce.f26395j, MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "repeatInterval", ce.f26396k, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "repeatCount", RXScreenCaptureService.KEY_INDEX, "y", "<init>", "()V", "permission-keeper-calendar_release"}, k = 1, mv = {1, 7, 1})
public final class EventRecord {

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

    @SerializedName("has_alarm")
    private Integer hasAlarm;

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
        return ArraysKt.joinToString$default(EventRecord.class.getDeclaredFields(), null, "EventRecord(", ")", 0, null, new AnonymousClass1(this), 25, null);
    }

    public EventRecord() {
        this.eventId = "";
        this.appUrl = "";
    }

    public final Integer a() {
        return this.alarmMinutes;
    }

    public final boolean b() {
        return this.allDay;
    }

    public final String c() {
        return this.appUrl;
    }

    public final String d() {
        return this.description;
    }

    public final long e() {
        return this.endTime;
    }

    public final String f() {
        return this.eventId;
    }

    public final Integer g() {
        return this.hasAlarm;
    }

    public final String h() {
        return this.location;
    }

    public final Integer i() {
        return this.repeatCount;
    }

    public final String j() {
        return this.repeatFrequency;
    }

    public final Integer k() {
        return this.repeatInterval;
    }

    public final List<Integer> l() {
        return this.scheduledWeekDays;
    }

    public final long m() {
        return this.startTime;
    }

    public final String n() {
        return this.title;
    }

    public final boolean o() {
        return this.isRepeat;
    }

    public final void A(Integer r100) {
        this.repeatInterval = r100;
    }

    public final void B(List<Integer> r100) {
        this.scheduledWeekDays = r100;
    }

    public final void C(long r100) {
        this.startTime = r100;
    }

    public final void D(String r100) {
        this.title = r100;
    }

    public final void p(Integer r100) {
        this.alarmMinutes = r100;
    }

    public final void q(boolean r100) {
        this.allDay = r100;
    }

    public final void r(String r100) {
        this.appUrl = r100;
    }

    public final void s(String r100) {
        this.description = r100;
    }

    public final void t(long r100) {
        this.endTime = r100;
    }

    public final void u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eventId = r100;
    }

    public final void v(Integer r100) {
        this.hasAlarm = r100;
    }

    public final void w(String r100) {
        this.location = r100;
    }

    public final void x(boolean r100) {
        this.isRepeat = r100;
    }

    public final void y(Integer r100) {
        this.repeatCount = r100;
    }

    public final void z(String r100) {
        this.repeatFrequency = r100;
    }
}
