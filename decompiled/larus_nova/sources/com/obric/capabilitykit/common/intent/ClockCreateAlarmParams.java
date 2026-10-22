package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\\\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010.J\t\u0010/\u001a\u00020\bHÖ\u0001J\u0013\u00100\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\n\u00103\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u00104\u001a\u00020\bHÖ\u0001J\u0012\u00105\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u000102H\u0016J\t\u00107\u001a\u00020\u0004HÖ\u0001J\u0019\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\bHÖ\u0001R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010$\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016¨\u0006="}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockCreateAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "time", "", "date", "repeatDayOfWeek", "", "", "closeInHoliday", "", "name", "repeatType", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getCloseInHoliday", "()Ljava/lang/Boolean;", "setCloseInHoliday", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getName", "setName", "getRepeatDayOfWeek", "()[Ljava/lang/Integer;", "setRepeatDayOfWeek", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getRepeatType$annotations", "()V", "getRepeatType", "()Ljava/lang/Integer;", "setRepeatType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/ClockCreateAlarmParams;", "describeContents", "equals", "other", "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockCreateAlarmParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ClockCreateAlarmParams> CREATOR = null;
    private Boolean closeInHoliday;
    private String date;
    private String name;
    private Integer[] repeatDayOfWeek;
    Integer repeatType;
    private String time;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ClockCreateAlarmParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ClockCreateAlarmParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            String r102 = r110.readString();
            boolean r103 = false;
            if (r110.readInt() != 0) goto L5;
            Integer[] r104 = null;
        L9:
            if (r110.readInt() != 0) goto L12;
            Boolean r105 = null;
        L15:
            ClockCreateAlarmParams r111 = new ClockCreateAlarmParams(r101, r102, r104, r105, r110.readString(), null, 32, null);
            int r106 = Math.min(r100, 1);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L16:
            if (r108 > r106) goto L22;
            if (r108 != 1) goto L21;
            Object r109 = joa.a.c(r110, r107);
            if (r109 == null) goto L21;
            r111.repeatType = (Integer) r109;
        L21:
            r108 = r108 + 1;
        L22:
            if (r108 > r100) goto L24;
            joa.a.d(r110, r107);
            r108 = r108 + 1;
            goto L22
        L24:
            return r111;
        L12:
            if (r110.readInt() == 0) goto L14;
            r103 = true;
        L14:
            r105 = Boolean.valueOf(r103);
            goto L15
        L5:
            int r112 = r110.readInt();
            r104 = new Integer[r112];
            int r113 = 0;
        L6:
            if (r113 == r112) goto L9;
            r104[r113] = Integer.valueOf(r110.readInt());
            r113 = r113 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ClockCreateAlarmParams[] newArray(int r100) {
            return new ClockCreateAlarmParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ClockCreateAlarmParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ClockCreateAlarmParams copy$default(ClockCreateAlarmParams r100, String r101, String r102, Integer[] r103, Boolean r104, String r105, Integer r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.time;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.date;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.repeatDayOfWeek;
    L11:
        Integer[] r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.closeInHoliday;
    L14:
        Boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.name;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.repeatType;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public static /* synthetic */ void getRepeatType$annotations() {
    }

    public final String component1() {
        return this.time;
    }

    public final String component2() {
        return this.date;
    }

    public final Integer[] component3() {
        return this.repeatDayOfWeek;
    }

    public final Boolean component4() {
        return this.closeInHoliday;
    }

    public final String component5() {
        return this.name;
    }

    public final Integer component6() {
        return this.repeatType;
    }

    public final ClockCreateAlarmParams copy(String r100, String r110, Integer[] r111, Boolean r112, String r113, Integer r114) {
        return new ClockCreateAlarmParams(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClockCreateAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockCreateAlarmParams r101 = (ClockCreateAlarmParams) r100;
        if (Intrinsics.areEqual(this.time, r101.time) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.date, r101.date) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.repeatDayOfWeek, r101.repeatDayOfWeek) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.closeInHoliday, r101.closeInHoliday) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.repeatType, r101.repeatType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.time;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.date;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer[] r107 = this.repeatDayOfWeek;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.closeInHoliday;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.name;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.repeatType;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = Arrays.hashCode(r107);
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
        return "ClockCreateAlarmParams(time=" + this.time + ", date=" + this.date + ", repeatDayOfWeek=" + Arrays.toString(this.repeatDayOfWeek) + ", closeInHoliday=" + this.closeInHoliday + ", name=" + this.name + ", repeatType=" + this.repeatType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(1);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
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

    public String getSubActionValue() {
        StringBuilder r100 = new StringBuilder();
        String r101 = this.time;
        String r102 = null;
        if (r101 != null) goto L6;
        r101 = null;
    L6:
        r100.append(r101);
        r100.append('|');
        String r103 = this.date;
        if (r103 != null) goto L10;
        r103 = null;
    L10:
        r100.append(r103);
        r100.append('|');
        Integer[] r104 = this.repeatDayOfWeek;
        if (r104 == null) goto L13;
        r102 = ArraysKt.joinToString$default(r104, null, null, null, 0, null, null, 63, null);
    L13:
        r100.append(r102);
        return r100.toString();
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

    public final String getTime() {
        return this.time;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof ClockCreateAlarmParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.time;
        if (r101 != null) goto L8;
        r101 = ((ClockCreateAlarmParams) r100).time;
    L8:
        String r102 = r101;
        String r103 = this.date;
        if (r103 != null) goto L11;
        r103 = ((ClockCreateAlarmParams) r100).date;
    L11:
        String r104 = r103;
        Integer[] r105 = this.repeatDayOfWeek;
        if (r105 != null) goto L14;
        r105 = ((ClockCreateAlarmParams) r100).repeatDayOfWeek;
    L14:
        Integer[] r106 = r105;
        Boolean r107 = this.closeInHoliday;
        if (r107 != null) goto L17;
        r107 = ((ClockCreateAlarmParams) r100).closeInHoliday;
    L17:
        Boolean r108 = r107;
        String r109 = this.name;
        if (r109 != null) goto L20;
        r109 = ((ClockCreateAlarmParams) r100).name;
    L20:
        String r110 = r109;
        Integer r111 = this.repeatType;
        if (r111 != null) goto L23;
        Integer r112 = ((ClockCreateAlarmParams) r100).repeatType;
    L25:
        return new ClockCreateAlarmParams(r102, r104, r106, r108, r110, r112);
    L23:
        r112 = r111;
        goto L25
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

    public final void setTime(String r100) {
        this.time = r100;
    }

    public ClockCreateAlarmParams(String r100, String r101, Integer[] r102, Boolean r103, String r104, Integer r105) {
        this.time = r100;
        this.date = r101;
        this.repeatDayOfWeek = r102;
        this.closeInHoliday = r103;
        this.name = r104;
        this.repeatType = r105;
    }

    public /* synthetic */ ClockCreateAlarmParams(String r100, String r101, Integer[] r102, Boolean r103, String r110, Integer r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Integer[] r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Boolean r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Integer r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
