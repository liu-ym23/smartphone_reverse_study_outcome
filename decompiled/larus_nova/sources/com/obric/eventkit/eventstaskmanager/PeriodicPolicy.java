package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.heytap.mcssdk.constant.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003Jk\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010-\u001a\u00020\u0007HÖ\u0001J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u000100H\u0096\u0002J\b\u00101\u001a\u00020\u0007H\u0016J\t\u00102\u001a\u00020\tHÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R&\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\r\u0010\u0011\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017¨\u00068"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "Landroid/os/Parcelable;", "daily", "", "weekly", "", "monthly", "", "yearly", "", "everyOffDay", "everyWorkDay", "expireDate", "isSingleTask", b.f276369s, "(Z[IILjava/lang/String;ZZLjava/lang/String;ZLjava/lang/String;)V", "getDaily", "()Z", "getEveryOffDay", "getEveryWorkDay", "getExpireDate$annotations", "()V", "getExpireDate", "()Ljava/lang/String;", "setExpireDate", "(Ljava/lang/String;)V", "isSingleTask$annotations", "setSingleTask", "(Z)V", "getMonthly", "()I", "getStartDate", "getWeekly", "()[I", "getYearly", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PeriodicPolicy implements Parcelable {
    public static final Parcelable.Creator<PeriodicPolicy> CREATOR = null;
    private final boolean daily;
    private final boolean everyOffDay;
    private final boolean everyWorkDay;
    public String expireDate;
    public boolean isSingleTask;
    private final int monthly;
    private final String startDate;
    private final int[] weekly;
    private final String yearly;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PeriodicPolicy> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PeriodicPolicy createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            if (r110.readInt() == 0) goto L5;
            boolean r101 = true;
        L6:
            int[] r102 = r110.createIntArray();
            int r103 = r110.readInt();
            String r104 = r110.readString();
            if (r110.readInt() == 0) goto L9;
            boolean r105 = true;
        L11:
            if (r110.readInt() == 0) goto L13;
            boolean r111 = true;
        L14:
            String r112 = null;
            boolean r113 = false;
            boolean r106 = r101;
            boolean r107 = r105;
            boolean r108 = r111;
            PeriodicPolicy r109 = new PeriodicPolicy(r106, r102, r103, r104, r107, r108, r112, r113, r110.readString(), 192, null);
            int r114 = Math.min(r100, 2);
            ClassLoader r115 = a.class.getClassLoader();
            int r116 = 1;
        L15:
            if (r116 > r114) goto L25;
            if (r116 != 1) goto L20;
            Object r117 = joa.a.c(r110, r115);
            if (r117 == null) goto L24;
            r109.expireDate = (String) r117;
        L24:
            r116 = r116 + 1;
            goto L15
        L20:
            if (r116 != 2) goto L24;
            Object r118 = joa.a.c(r110, r115);
            if (r118 == null) goto L24;
            r109.isSingleTask = ((Boolean) r118).booleanValue();
        L25:
            if (r116 > r100) goto L27;
            joa.a.d(r110, r115);
            r116 = r116 + 1;
            goto L25
        L27:
            return r109;
        L13:
            r111 = false;
            goto L14
        L9:
            r105 = false;
            goto L11
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final PeriodicPolicy[] newArray(int r100) {
            return new PeriodicPolicy[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PeriodicPolicy() {
        this(false, null, 0, null, false, false, null, false, null, 511, null);
    }

    public PeriodicPolicy(boolean r100, int[] r101, int r102, String r103, boolean r104, boolean r105, String r106, boolean r107, String r108) {
        this.daily = r100;
        this.weekly = r101;
        this.monthly = r102;
        this.yearly = r103;
        this.everyOffDay = r104;
        this.everyWorkDay = r105;
        this.expireDate = r106;
        this.isSingleTask = r107;
        this.startDate = r108;
    }

    public /* synthetic */ PeriodicPolicy(boolean r110, int[] r111, int r112, String r113, boolean r114, boolean r115, String r116, boolean r117, String r210, int r211, DefaultConstructorMarker r212) {
        boolean r100 = false;
        if ((r211 & 1) == 0) goto L5;
        boolean r101 = false;
    L6:
        String r102 = null;
        if ((r211 & 2) == 0) goto L9;
        int[] r103 = null;
    L11:
        if ((r211 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r211 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r211 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r211 & 64) == 0) goto L29;
        String r108 = null;
    L31:
        if ((r211 & 128) != 0) goto L35;
        r100 = r117;
    L35:
        if ((r211 & 256) != 0) goto L38;
        r102 = r210;
    L38:
        this(r101, r103, r104, r105, r106, r107, r108, r100, r102);
        return;
    L29:
        r108 = r116;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }

    public static /* synthetic */ PeriodicPolicy copy$default(PeriodicPolicy r110, boolean r111, int[] r112, int r113, String r114, boolean r115, boolean r116, String r117, boolean r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        boolean r100 = r110.daily;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int[] r101 = r110.weekly;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.monthly;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.yearly;
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r104 = r110.everyOffDay;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r105 = r110.everyWorkDay;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.expireDate;
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r107 = r110.isSingleTask;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.startDate;
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

    public static /* synthetic */ void getExpireDate$annotations() {
    }

    public static /* synthetic */ void isSingleTask$annotations() {
    }

    public final boolean component1() {
        return this.daily;
    }

    public final int[] component2() {
        return this.weekly;
    }

    public final int component3() {
        return this.monthly;
    }

    public final String component4() {
        return this.yearly;
    }

    public final boolean component5() {
        return this.everyOffDay;
    }

    public final boolean component6() {
        return this.everyWorkDay;
    }

    public final String component7() {
        return this.expireDate;
    }

    public final boolean component8() {
        return this.isSingleTask;
    }

    public final String component9() {
        return this.startDate;
    }

    public final PeriodicPolicy copy(boolean r110, int[] r111, int r112, String r113, boolean r114, boolean r115, String r116, boolean r117, String r210) {
        return new PeriodicPolicy(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(PeriodicPolicy.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.PeriodicPolicy");
        PeriodicPolicy r102 = (PeriodicPolicy) r100;
        if (this.daily == r102.daily) goto L16;
        return false;
    L16:
        if (this.monthly == r102.monthly) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.weekly, r102.weekly) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.yearly, r102.yearly) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.expireDate, r102.expireDate) == true) goto L28;
        return false;
    L28:
        if (this.everyOffDay == r102.everyOffDay) goto L31;
        return false;
    L31:
        if (this.everyWorkDay == r102.everyWorkDay) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.startDate, r102.startDate) == true) goto L36;
        return false;
    L36:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final boolean getDaily() {
        return this.daily;
    }

    public final boolean getEveryOffDay() {
        return this.everyOffDay;
    }

    public final boolean getEveryWorkDay() {
        return this.everyWorkDay;
    }

    public final String getExpireDate() {
        return this.expireDate;
    }

    public final int getMonthly() {
        return this.monthly;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final int[] getWeekly() {
        return this.weekly;
    }

    public final String getYearly() {
        return this.yearly;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.daily == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.monthly) * 31;
        int[] r103 = this.weekly;
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = Arrays.hashCode(r103);
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.yearly;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.everyOffDay == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.everyWorkDay == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        String r114 = this.expireDate;
        if (r114 == null) goto L25;
        int r115 = r114.hashCode();
    L26:
        int r116 = (r113 + r115) * 31;
        if (this.isSingleTask == true) goto L30;
        r100 = 1237;
    L30:
        int r117 = (r116 + r100) * 31;
        String r118 = this.startDate;
        if (r118 == null) goto L34;
        r104 = r118.hashCode();
    L34:
        return r117 + r104;
    L25:
        r115 = 0;
        goto L26
    L21:
        r112 = 1237;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final boolean isSingleTask() {
        return this.isSingleTask;
    }

    public final void setExpireDate(String r100) {
        this.expireDate = r100;
    }

    public final void setSingleTask(boolean r100) {
        this.isSingleTask = r100;
    }

    public String toString() {
        return "PeriodicPolicy(daily=" + this.daily + ", weekly=" + Arrays.toString(this.weekly) + ", monthly=" + this.monthly + ", yearly=" + this.yearly + ", everyOffDay=" + this.everyOffDay + ", everyWorkDay=" + this.everyWorkDay + ", expireDate=" + this.expireDate + ", isSingleTask=" + this.isSingleTask + ", startDate=" + this.startDate + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(2);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeInt(this.daily ? 1 : 0);
        r100.writeIntArray(this.weekly);
        r100.writeInt(this.monthly);
        r100.writeString(this.yearly);
        r100.writeInt(this.everyOffDay ? 1 : 0);
        r100.writeInt(this.everyWorkDay ? 1 : 0);
        r100.writeString(this.startDate);
        r100.writeValue(this.expireDate);
        r100.writeValue(Boolean.valueOf(this.isSingleTask));
    }
}
