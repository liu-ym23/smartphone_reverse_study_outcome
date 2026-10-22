package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.utils.CronHelper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "use TimerTaskV2 instead")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b \b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0001GBw\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019¢\u0006\u0004\bC\u0010DB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bC\u0010EJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\t\u0010\u000e\u001a\u00020\rHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010\u0010\u001a\u00020\rHÆ\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0012J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0012J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019HÆ\u0003J\u0084\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\b$\u0010%J\t\u0010&\u001a\u00020\rHÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003R\u0017\u0010\u001b\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b.\u0010-R\u0017\u0010\u001d\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b/\u0010-R$\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u00100\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u00103R$\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u00104\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u00107R$\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u00100\u001a\u0004\b8\u0010\u0012\"\u0004\b9\u00103R$\u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u00100\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u00103R$\u0010\"\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u00104\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u00107R0\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "Lcom/obric/eventkit/eventstaskmanager/BaseTask;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "isRepeat", "Lcom/obric/eventkit/eventstaskmanager/TimerTaskV2;", "toTimerTaskV2", "", "component1", "component2", "component3", "component4", "()Ljava/lang/Integer;", "", "component5", "()Ljava/lang/Long;", "component6", "component7", "component8", "", "component9", "cronExpr", "name", "action", "id", "nextScheduleTime", "taskStatus", "enableStatus", "createTime", "ext", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getCronExpr", "()Ljava/lang/String;", "getName", "getAction", "Ljava/lang/Integer;", "getId", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Long;", "getNextScheduleTime", "setNextScheduleTime", "(Ljava/lang/Long;)V", "getTaskStatus", "setTaskStatus", "getEnableStatus", "setEnableStatus", "getCreateTime", "setCreateTime", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class TimerTask extends BaseTask {
    public static final a CREATOR = null;
    private static final int INVALID_INT_VALUE = -1;
    private static final long INVALID_LONG_VALUE = -1;
    private final String action;
    private Long createTime;
    private final String cronExpr;
    private Integer enableStatus;
    private Map<String, String> ext;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Integer f396879id;
    private final String name;
    private Long nextScheduleTime;
    private Integer taskStatus;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<TimerTask> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TimerTask createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new TimerTask(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final TimerTask[] newArray(int r100) {
            return new TimerTask[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TimerTask(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(TimerTaskKt.a(r110), r110.readString(), TimerTaskKt.a(r110), Integer.valueOf(r110.readInt()), Long.valueOf(r110.readLong()), Integer.valueOf(r110.readInt()), Integer.valueOf(r110.readInt()), Long.valueOf(r110.readLong()), null, 256, null);
        if (Build.VERSION.SDK_INT < 33) goto L7;
        LinkedHashMap r100 = new LinkedHashMap();
        r110.readMap(r100, TimerTask.class.getClassLoader(), String.class, String.class);
        if ((!r100.isEmpty()) == false) goto L16;
    L6:
        this.ext = r100;
    L16:
        Integer r111 = this.f396879id;
        if (r111 != null) goto L20;
    L22:
        Long r112 = this.nextScheduleTime;
        if (r112 != null) goto L26;
    L28:
        Integer r113 = this.taskStatus;
        if (r113 != null) goto L32;
    L34:
        Integer r114 = this.enableStatus;
        if (r114 != null) goto L38;
    L40:
        Long r115 = this.createTime;
        if (r115 != null) goto L44;
        return;
    L44:
        if (r115.longValue() != (-1)) goto L50;
        this.createTime = null;
        return;
    L50:
        return;
    L38:
        if (r114.intValue() != (-1)) goto L40;
        this.enableStatus = null;
        goto L40
    L32:
        if (r113.intValue() != (-1)) goto L34;
        this.taskStatus = null;
        goto L34
    L26:
        if (r112.longValue() != (-1)) goto L28;
        this.nextScheduleTime = null;
        goto L28
    L20:
        if (r111.intValue() != (-1)) goto L22;
        this.f396879id = null;
        goto L22
    L7:
        Bundle r116 = r110.readBundle(TimerTask.class.getClassLoader());
        if (r116 == null) goto L16;
        r100 = new LinkedHashMap();
        Iterator<T> r101 = r116.keySet().iterator();
    L11:
        if (r101.hasNext() == false) goto L6;
        String r102 = (String) r101.next();
        String r103 = r116.getString(r102);
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        r100.put(r102, r103);
        goto L11
    }

    public TimerTask(String r100, String r101, String r102, Integer r103, Long r104, Integer r105, Integer r106, Long r107, Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r100, "cronExpr");
        Intrinsics.checkNotNullParameter(r102, "action");
        this.cronExpr = r100;
        this.name = r101;
        this.action = r102;
        this.f396879id = r103;
        this.nextScheduleTime = r104;
        this.taskStatus = r105;
        this.enableStatus = r106;
        this.createTime = r107;
        this.ext = r110;
    }

    public /* synthetic */ TimerTask(String r110, String r111, String r112, Integer r113, Long r114, Integer r115, Integer r210, Long r211, Map r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r213 & 8) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r213 & 16) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r213 & 32) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r213 & 64) == 0) goto L21;
        Integer r116 = null;
    L23:
        if ((r213 & 128) == 0) goto L25;
        Long r117 = null;
    L27:
        if ((r213 & 256) == 0) goto L29;
        Map r118 = null;
    L30:
        this(r110, r100, r112, r101, r102, r103, r116, r117, r118);
        return;
    L29:
        r118 = r212;
        goto L30
    L25:
        r117 = r211;
        goto L27
    L21:
        r116 = r210;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimerTask copy$default(TimerTask r110, String r111, String r112, String r113, Integer r114, Long r115, Integer r116, Integer r117, Long r118, Map r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.cronExpr;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.action;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r103 = r110.f396879id;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Long r104 = r110.nextScheduleTime;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Integer r105 = r110.taskStatus;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Integer r106 = r110.enableStatus;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Long r107 = r110.createTime;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Map r108 = r110.ext;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.cronExpr;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.action;
    }

    public final Integer component4() {
        return this.f396879id;
    }

    public final Long component5() {
        return this.nextScheduleTime;
    }

    public final Integer component6() {
        return this.taskStatus;
    }

    public final Integer component7() {
        return this.enableStatus;
    }

    public final Long component8() {
        return this.createTime;
    }

    public final Map<String, String> component9() {
        return this.ext;
    }

    public final TimerTask copy(String r110, String r111, String r112, Integer r113, Long r114, Integer r115, Integer r116, Long r117, Map<String, String> r210) {
        Intrinsics.checkNotNullParameter(r110, "cronExpr");
        Intrinsics.checkNotNullParameter(r112, "action");
        return new TimerTask(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimerTask) == true) goto L8;
        return false;
    L8:
        TimerTask r101 = (TimerTask) r100;
        if (Intrinsics.areEqual(this.cronExpr, r101.cronExpr) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f396879id, r101.f396879id) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.nextScheduleTime, r101.nextScheduleTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.taskStatus, r101.taskStatus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.enableStatus, r101.enableStatus) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getCronExpr() {
        return this.cronExpr;
    }

    public final Integer getEnableStatus() {
        return this.enableStatus;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final Integer getId() {
        return this.f396879id;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getNextScheduleTime() {
        return this.nextScheduleTime;
    }

    public final Integer getTaskStatus() {
        return this.taskStatus;
    }

    public int hashCode() {
        int r100 = this.cronExpr.hashCode() * 31;
        String r101 = this.name;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.action.hashCode()) * 31;
        Integer r105 = this.f396879id;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.nextScheduleTime;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.taskStatus;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.enableStatus;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Long r117 = this.createTime;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Map<String, String> r120 = this.ext;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final boolean isRepeat() {
        return CronHelper.INSTANCE.isTimeRecurring(this.cronExpr);
    }

    public final void setCreateTime(Long r100) {
        this.createTime = r100;
    }

    public final void setEnableStatus(Integer r100) {
        this.enableStatus = r100;
    }

    public final void setExt(Map<String, String> r100) {
        this.ext = r100;
    }

    public final void setId(Integer r100) {
        this.f396879id = r100;
    }

    public final void setNextScheduleTime(Long r100) {
        this.nextScheduleTime = r100;
    }

    public final void setTaskStatus(Integer r100) {
        this.taskStatus = r100;
    }

    public String toString() {
        return "TimerTask(cronExpr=" + this.cronExpr + ", name=" + this.name + ", action=" + this.action + ", id=" + this.f396879id + ", nextScheduleTime=" + this.nextScheduleTime + ", taskStatus=" + this.taskStatus + ", enableStatus=" + this.enableStatus + ", createTime=" + this.createTime + ", ext=" + this.ext + ')';
    }

    public final TimerTaskV2 toTimerTaskV2() {
        Integer r100 = this.f396879id;
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L7:
        return new TimerTaskV2(r101, this.name, this.taskStatus, this.enableStatus, this.createTime, this.ext, this.cronExpr, this.action, this.nextScheduleTime);
    L5:
        r101 = null;
        goto L7
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.cronExpr);
        r100.writeString(this.name);
        r100.writeString(this.action);
        Integer r102 = this.f396879id;
        int r103 = -1;
        if (r102 == null) goto L5;
        int r104 = r102.intValue();
    L6:
        r100.writeInt(r104);
        Long r105 = this.nextScheduleTime;
        long r106 = -1;
        if (r105 == null) goto L9;
        long r107 = r105.longValue();
    L10:
        r100.writeLong(r107);
        Integer r108 = this.taskStatus;
        if (r108 == null) goto L13;
        int r109 = r108.intValue();
    L14:
        r100.writeInt(r109);
        Integer r110 = this.enableStatus;
        if (r110 == null) goto L17;
        r103 = r110.intValue();
    L17:
        r100.writeInt(r103);
        Long r111 = this.createTime;
        if (r111 == null) goto L20;
        r106 = r111.longValue();
    L20:
        r100.writeLong(r106);
        if (Build.VERSION.SDK_INT < 33) goto L23;
        r100.writeMap(this.ext);
        return;
    L23:
        Bundle r112 = new Bundle();
        Map<String, String> r113 = this.ext;
        if (r113 == null) goto L29;
        Iterator<Map.Entry<String, String>> r114 = r113.entrySet().iterator();
    L27:
        if (r114.hasNext() == false) goto L29;
        Map.Entry<String, String> r115 = r114.next();
        r112.putString(r115.getKey(), r115.getValue());
    L29:
        r100.writeBundle(r112);
        return;
    L13:
        r109 = -1;
        goto L14
    L9:
        r107 = -1;
        goto L10
    L5:
        r104 = -1;
        goto L6
    }
}
