package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.utils.CronHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b!\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0001NBw\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0019\u0012\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c\u0012\u0006\u0010'\u001a\u00020\u0013\u0012\u0006\u0010(\u001a\u00020\u0013\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\bJ\u0010KBY\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0019\u0012\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bJ\u0010LJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0011J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001cHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0013HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0013HÆ\u0003J\u0012\u0010 \u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b \u0010\u001bJ\u0084\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c2\b\b\u0002\u0010'\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u00132\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\b*\u0010+J\t\u0010,\u001a\u00020\u0013HÖ\u0001J\t\u0010-\u001a\u00020\u0004HÖ\u0001J\u0013\u00100\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010.HÖ\u0003R$\u0010!\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b6\u00103R$\u0010#\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u00107\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010:R$\u0010$\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u00107\u001a\u0004\b;\u0010\u0017\"\u0004\b<\u0010:R$\u0010%\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b%\u0010=\u001a\u0004\b>\u0010\u001b\"\u0004\b?\u0010@R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0017\u0010'\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b'\u00101\u001a\u0004\bF\u00103R\u0017\u0010(\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b(\u00101\u001a\u0004\bG\u00103R$\u0010)\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010=\u001a\u0004\bH\u0010\u001b\"\u0004\bI\u0010@¨\u0006O"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTaskV2;", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "", "isRepeat", "Lcom/obric/eventkit/eventstaskmanager/TimerTask;", "toTimerTask", "", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "", "component5", "()Ljava/lang/Long;", "", "component6", "component7", "component8", "component9", "id", "name", "taskStatus", "enableStatus", "createTime", "ext", "cronExpr", "action", "nextScheduleTime", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/eventkit/eventstaskmanager/TimerTaskV2;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "Ljava/lang/Integer;", "getTaskStatus", "setTaskStatus", "(Ljava/lang/Integer;)V", "getEnableStatus", "setEnableStatus", "Ljava/lang/Long;", "getCreateTime", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getCronExpr", "getAction", "getNextScheduleTime", "setNextScheduleTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class TimerTaskV2 extends EventTask {
    public static final Parcelable.Creator<TimerTaskV2> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    private final String action;
    private Long createTime;
    private final String cronExpr;
    private Integer enableStatus;
    private Map<String, String> ext;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f396882id;
    private final String name;
    private Long nextScheduleTime;
    private Integer taskStatus;

    public static final class a implements Parcelable.Creator<TimerTaskV2> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TimerTaskV2 createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            EventTask r101 = EventTask.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.TimerTaskV2");
            return (TimerTaskV2) r101;
        }

        @Override // android.os.Parcelable.Creator
        public final TimerTaskV2[] newArray(int r100) {
            return new TimerTaskV2[r100];
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public TimerTaskV2(String r110, String r111, Integer r112, Integer r113, Long r210, Map<String, String> r211, Parcel r212) {
        Intrinsics.checkNotNullParameter(r212, "parcel");
        if (r112 != null) goto L6;
    L8:
        Integer r100 = r112;
    L9:
        if (r113 != null) goto L12;
    L14:
        Integer r101 = r113;
    L16:
        if (r210 != null) goto L19;
    L21:
        Long r102 = r210;
    L22:
        String r103 = TimerTaskKt.a(r212);
        String r104 = TimerTaskKt.a(r212);
        Long r105 = Long.valueOf(r212.readLong());
        if (r105.longValue() == (-1)) goto L25;
        boolean r106 = true;
    L26:
        if (r106 == false) goto L28;
        Long r107 = r105;
    L29:
        this(r110, r111, r100, r101, r102, r211, r103, r104, r107);
        readExtensionFieldFromParcel$eventstaskkit_release(r212);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r212, 0);
        return;
    L28:
        r107 = null;
        goto L29
    L25:
        r106 = false;
        goto L26
    L19:
        if (r210.longValue() != (-1)) goto L21;
        r102 = null;
        goto L22
    L12:
        if (r113.intValue() != (-1)) goto L14;
        r101 = null;
        goto L16
    L6:
        if (r112.intValue() != (-1)) goto L8;
        r100 = null;
        goto L9
    }

    public TimerTaskV2(String r110, String r111, Integer r112, Integer r113, Long r114, Map<String, String> r115, String r116, String r117, Long r210) {
        Intrinsics.checkNotNullParameter(r116, "cronExpr");
        Intrinsics.checkNotNullParameter(r117, "action");
        super(1, r110, r111, r112, r113, r114, r115);
        this.f396882id = r110;
        this.name = r111;
        this.taskStatus = r112;
        this.enableStatus = r113;
        this.createTime = r114;
        this.ext = r115;
        this.cronExpr = r116;
        this.action = r117;
        this.nextScheduleTime = r210;
    }

    public /* synthetic */ TimerTaskV2(String r110, String r111, Integer r112, Integer r113, Long r114, Map r115, String r210, String r211, Long r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r213 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r213 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r213 & 16) == 0) goto L21;
        Long r104 = null;
    L23:
        if ((r213 & 32) == 0) goto L25;
        Map r105 = null;
    L27:
        if ((r213 & 256) == 0) goto L29;
        Long r116 = null;
    L30:
        this(r100, r101, r102, r103, r104, r105, r210, r211, r116);
        return;
    L29:
        r116 = r212;
        goto L30
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimerTaskV2 copy$default(TimerTaskV2 r110, String r111, String r112, Integer r113, Integer r114, Long r115, Map r116, String r117, String r118, Long r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.getId();
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.getName();
    L11:
        if ((r210 & 4) == 0) goto L13;
        Integer r102 = r110.getTaskStatus();
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r103 = r110.getEnableStatus();
    L19:
        if ((r210 & 16) == 0) goto L21;
        Long r104 = r110.getCreateTime();
    L23:
        if ((r210 & 32) == 0) goto L25;
        Map r105 = r110.getExt();
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.cronExpr;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.action;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Long r108 = r110.nextScheduleTime;
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
        return getId();
    }

    public final String component2() {
        return getName();
    }

    public final Integer component3() {
        return getTaskStatus();
    }

    public final Integer component4() {
        return getEnableStatus();
    }

    public final Long component5() {
        return getCreateTime();
    }

    public final Map<String, String> component6() {
        return getExt();
    }

    public final String component7() {
        return this.cronExpr;
    }

    public final String component8() {
        return this.action;
    }

    public final Long component9() {
        return this.nextScheduleTime;
    }

    public final TimerTaskV2 copy(String r110, String r111, Integer r112, Integer r113, Long r114, Map<String, String> r115, String r116, String r117, Long r210) {
        Intrinsics.checkNotNullParameter(r116, "cronExpr");
        Intrinsics.checkNotNullParameter(r117, "action");
        return new TimerTaskV2(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimerTaskV2) == true) goto L8;
        return false;
    L8:
        TimerTaskV2 r101 = (TimerTaskV2) r100;
        if (Intrinsics.areEqual(getId(), r101.getId()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getName(), r101.getName()) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(getTaskStatus(), r101.getTaskStatus()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getEnableStatus(), r101.getEnableStatus()) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(getCreateTime(), r101.getCreateTime()) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(getExt(), r101.getExt()) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cronExpr, r101.cronExpr) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.nextScheduleTime, r101.nextScheduleTime) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Long getCreateTime() {
        return this.createTime;
    }

    public final String getCronExpr() {
        return this.cronExpr;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Map<String, String> getExt() {
        return this.ext;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public String getId() {
        return this.f396882id;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public String getName() {
        return this.name;
    }

    public final Long getNextScheduleTime() {
        return this.nextScheduleTime;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public int hashCode() {
        int r100 = 0;
        if (getId() != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (getName() != null) goto L9;
        int r103 = 0;
    L10:
        int r104 = (r102 + r103) * 31;
        if (getTaskStatus() != null) goto L13;
        int r105 = 0;
    L14:
        int r106 = (r104 + r105) * 31;
        if (getEnableStatus() != null) goto L17;
        int r107 = 0;
    L18:
        int r108 = (r106 + r107) * 31;
        if (getCreateTime() != null) goto L21;
        int r109 = 0;
    L22:
        int r110 = (r108 + r109) * 31;
        if (getExt() != null) goto L25;
        int r111 = 0;
    L26:
        int r112 = (((((r110 + r111) * 31) + this.cronExpr.hashCode()) * 31) + this.action.hashCode()) * 31;
        Long r113 = this.nextScheduleTime;
        if (r113 == null) goto L31;
        r100 = r113.hashCode();
    L31:
        return r112 + r100;
    L25:
        r111 = getExt().hashCode();
        goto L26
    L21:
        r109 = getCreateTime().hashCode();
        goto L22
    L17:
        r107 = getEnableStatus().hashCode();
        goto L18
    L13:
        r105 = getTaskStatus().hashCode();
        goto L14
    L9:
        r103 = getName().hashCode();
        goto L10
    L5:
        r101 = getId().hashCode();
        goto L6
    }

    public final boolean isRepeat() {
        return CronHelper.INSTANCE.isTimeRecurring(this.cronExpr);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setCreateTime(Long r100) {
        this.createTime = r100;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setEnableStatus(Integer r100) {
        this.enableStatus = r100;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setExt(Map<String, String> r100) {
        this.ext = r100;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setId(String r100) {
        this.f396882id = r100;
    }

    public final void setNextScheduleTime(Long r100) {
        this.nextScheduleTime = r100;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setTaskStatus(Integer r100) {
        this.taskStatus = r100;
    }

    public String toString() {
        return "TimerTaskV2(id=" + getId() + ", name=" + getName() + ", taskStatus=" + getTaskStatus() + ", enableStatus=" + getEnableStatus() + ", createTime=" + getCreateTime() + ", ext=" + getExt() + ", cronExpr=" + this.cronExpr + ", action=" + this.action + ", nextScheduleTime=" + this.nextScheduleTime + ')';
    }

    public final TimerTask toTimerTask() {
        String r100 = this.cronExpr;
        String r101 = getName();
        String r102 = this.action;
        String r103 = getId();
        if (r103 == null) goto L5;
        Integer r104 = StringsKt.toIntOrNull(r103);
    L7:
        return new TimerTask(r100, r101, r102, r104, this.nextScheduleTime, getTaskStatus(), getEnableStatus(), getCreateTime(), getExt());
    L5:
        r104 = null;
        goto L7
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        r100.writeString(this.cronExpr);
        r100.writeString(this.action);
        Long r102 = this.nextScheduleTime;
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        r100.writeLong(r103);
        writeExtensionFieldToParcel$eventstaskkit_release(r100);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r100);
        return;
    L5:
        r103 = -1;
        goto L6
    }
}
