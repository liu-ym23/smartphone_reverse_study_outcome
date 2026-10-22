package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#Jh\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00105J\t\u00106\u001a\u00020\nHÖ\u0001J\u0013\u00107\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\nHÖ\u0001J\u0012\u0010;\u001a\u00020\u00012\b\u0010<\u001a\u0004\u0018\u000109H\u0016J\t\u0010=\u001a\u00020\u0006HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\nHÖ\u0001R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010&\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockUpdateAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", PickerReporterConstants.KEY.TARGET, "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "time", "", "date", "repeatDayOfWeek", "", "", "closeInHoliday", "", "name", "repeatType", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getCloseInHoliday", "()Ljava/lang/Boolean;", "setCloseInHoliday", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getName", "setName", "getRepeatDayOfWeek", "()[Ljava/lang/Integer;", "setRepeatDayOfWeek", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getRepeatType$annotations", "()V", "getRepeatType", "()Ljava/lang/Integer;", "setRepeatType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTarget", "()Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/ClockUpdateAlarmParams;", "describeContents", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockUpdateAlarmParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ClockUpdateAlarmParams> CREATOR = null;
    private Boolean closeInHoliday;
    private String date;
    private String name;
    private Integer[] repeatDayOfWeek;
    Integer repeatType;
    private AlarmEntity target;
    private String time;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ClockUpdateAlarmParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ClockUpdateAlarmParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            AlarmEntity r101 = (AlarmEntity) r110.readParcelable(ClockUpdateAlarmParams.class.getClassLoader());
            String r102 = r110.readString();
            String r103 = r110.readString();
            boolean r104 = false;
            if (r110.readInt() != 0) goto L5;
            Integer[] r105 = null;
        L9:
            if (r110.readInt() != 0) goto L12;
            Boolean r106 = null;
        L15:
            ClockUpdateAlarmParams r111 = new ClockUpdateAlarmParams(r101, r102, r103, r105, r106, r110.readString(), null, 64, null);
            int r107 = Math.min(r100, 1);
            ClassLoader r108 = a.class.getClassLoader();
            int r109 = 1;
        L16:
            if (r109 > r107) goto L22;
            if (r109 != 1) goto L21;
            Object r112 = joa.a.c(r110, r108);
            if (r112 == null) goto L21;
            r111.repeatType = (Integer) r112;
        L21:
            r109 = r109 + 1;
        L22:
            if (r109 > r100) goto L24;
            joa.a.d(r110, r108);
            r109 = r109 + 1;
            goto L22
        L24:
            return r111;
        L12:
            if (r110.readInt() == 0) goto L14;
            r104 = true;
        L14:
            r106 = Boolean.valueOf(r104);
            goto L15
        L5:
            int r113 = r110.readInt();
            r105 = new Integer[r113];
            int r114 = 0;
        L6:
            if (r114 == r113) goto L9;
            r105[r114] = Integer.valueOf(r110.readInt());
            r114 = r114 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ClockUpdateAlarmParams[] newArray(int r100) {
            return new ClockUpdateAlarmParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ClockUpdateAlarmParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ClockUpdateAlarmParams copy$default(ClockUpdateAlarmParams r100, AlarmEntity r101, String r102, String r103, Integer[] r104, Boolean r110, String r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.target;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.time;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.date;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.repeatDayOfWeek;
    L14:
        Integer[] r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.closeInHoliday;
    L17:
        Boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.name;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.repeatType;
    L23:
        AlarmEntity r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public static /* synthetic */ void getRepeatType$annotations() {
    }

    public final AlarmEntity component1() {
        return this.target;
    }

    public final String component2() {
        return this.time;
    }

    public final String component3() {
        return this.date;
    }

    public final Integer[] component4() {
        return this.repeatDayOfWeek;
    }

    public final Boolean component5() {
        return this.closeInHoliday;
    }

    public final String component6() {
        return this.name;
    }

    public final Integer component7() {
        return this.repeatType;
    }

    public final ClockUpdateAlarmParams copy(AlarmEntity r110, String r111, String r112, Integer[] r113, Boolean r114, String r115, Integer r116) {
        return new ClockUpdateAlarmParams(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClockUpdateAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockUpdateAlarmParams r101 = (ClockUpdateAlarmParams) r100;
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.time, r101.time) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.date, r101.date) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.repeatDayOfWeek, r101.repeatDayOfWeek) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.closeInHoliday, r101.closeInHoliday) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.repeatType, r101.repeatType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        AlarmEntity r100 = this.target;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.time;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.date;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer[] r110 = this.repeatDayOfWeek;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.closeInHoliday;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.name;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.repeatType;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = Arrays.hashCode(r110);
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "ClockUpdateAlarmParams(target=" + this.target + ", time=" + this.time + ", date=" + this.date + ", repeatDayOfWeek=" + Arrays.toString(this.repeatDayOfWeek) + ", closeInHoliday=" + this.closeInHoliday + ", name=" + this.name + ", repeatType=" + this.repeatType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(1);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeParcelable(this.target, r101);
        r100.writeString(this.time);
        r100.writeString(this.date);
        Integer[] r102 = this.repeatDayOfWeek;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L8:
        Boolean r103 = this.closeInHoliday;
        if (r103 != null) goto L11;
        r100.writeInt(0);
    L12:
        r100.writeString(this.name);
        r100.writeValue(this.repeatType);
        return;
    L11:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        goto L12
    L5:
        r100.writeInt(1);
        int r104 = r102.length;
        r100.writeInt(r104);
        int r105 = 0;
    L6:
        if (r105 == r104) goto L8;
        r100.writeInt(r102[r105].intValue());
        r105 = r105 + 1;
        goto L6
    }

    public final Boolean getCloseInHoliday() {
        return this.closeInHoliday;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer[] getRepeatDayOfWeek() {
        return this.repeatDayOfWeek;
    }

    public final Integer getRepeatType() {
        return this.repeatType;
    }

    public final AlarmEntity getTarget() {
        return this.target;
    }

    public final String getTime() {
        return this.time;
    }

    public IntentParams mergeParams(Object r110) {
        if ((r110 instanceof ClockUpdateAlarmParams) == true) goto L5;
        return this;
    L5:
        AlarmEntity r100 = this.target;
        if (r100 != null) goto L8;
        r100 = ((ClockUpdateAlarmParams) r110).target;
    L8:
        AlarmEntity r101 = r100;
        String r102 = this.time;
        if (r102 != null) goto L11;
        r102 = ((ClockUpdateAlarmParams) r110).time;
    L11:
        String r103 = r102;
        String r104 = this.date;
        if (r104 != null) goto L14;
        r104 = ((ClockUpdateAlarmParams) r110).date;
    L14:
        String r105 = r104;
        Integer[] r106 = this.repeatDayOfWeek;
        if (r106 != null) goto L17;
        r106 = ((ClockUpdateAlarmParams) r110).repeatDayOfWeek;
    L17:
        Integer[] r107 = r106;
        Boolean r108 = this.closeInHoliday;
        if (r108 != null) goto L20;
        r108 = ((ClockUpdateAlarmParams) r110).closeInHoliday;
    L20:
        Boolean r109 = r108;
        String r111 = this.name;
        if (r111 != null) goto L23;
        r111 = ((ClockUpdateAlarmParams) r110).name;
    L23:
        String r112 = r111;
        Integer r113 = this.repeatType;
        if (r113 != null) goto L26;
        Integer r114 = ((ClockUpdateAlarmParams) r110).repeatType;
    L28:
        return new ClockUpdateAlarmParams(r101, r103, r105, r107, r109, r112, r114);
    L26:
        r114 = r113;
        goto L28
    }

    public final void setCloseInHoliday(Boolean r100) {
        this.closeInHoliday = r100;
    }

    public final void setDate(String r100) {
        this.date = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setRepeatDayOfWeek(Integer[] r100) {
        this.repeatDayOfWeek = r100;
    }

    public final void setRepeatType(Integer r100) {
        this.repeatType = r100;
    }

    public final void setTarget(AlarmEntity r100) {
        this.target = r100;
    }

    public final void setTime(String r100) {
        this.time = r100;
    }

    public ClockUpdateAlarmParams(AlarmEntity r100, String r101, String r102, Integer[] r103, Boolean r104, String r105, Integer r106) {
        this.target = r100;
        this.time = r101;
        this.date = r102;
        this.repeatDayOfWeek = r103;
        this.closeInHoliday = r104;
        this.name = r105;
        this.repeatType = r106;
    }

    public /* synthetic */ ClockUpdateAlarmParams(AlarmEntity r100, String r101, String r102, Integer[] r110, Boolean r111, String r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        AlarmEntity r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Integer[] r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Boolean r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
