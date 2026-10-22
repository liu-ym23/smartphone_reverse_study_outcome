package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ8\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001cHÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockTurnOffAlarmParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "targets", "", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "turnOffAll", "", NameKeys.LoadStrategy_Always, "([Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAlways", "()Ljava/lang/Boolean;", "setAlways", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/AlarmEntity;)V", "[Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "getTurnOffAll", "setTurnOffAll", "component1", "component2", "component3", "copy", "([Lcom/obric/capabilitykit/entity/app/AlarmEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ClockTurnOffAlarmParams;", "describeContents", "", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockTurnOffAlarmParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ClockTurnOffAlarmParams> CREATOR = null;
    private Boolean always;
    private AlarmEntity[] targets;
    private Boolean turnOffAll;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ClockTurnOffAlarmParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ClockTurnOffAlarmParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Boolean r102 = null;
            if (r100.readInt() != 0) goto L5;
            AlarmEntity[] r103 = null;
        L8:
            int r104 = 1;
            if (r100.readInt() != 0) goto L12;
            Boolean r105 = null;
        L17:
            if (r100.readInt() != 0) goto L20;
        L24:
            ClockTurnOffAlarmParams r106 = new ClockTurnOffAlarmParams(r103, r105, r102);
            int r107 = Math.min(r101, 0);
            ClassLoader r108 = a.class.getClassLoader();
        L25:
            if (r104 > r107) goto L27;
            r104 = r104 + 1;
        L27:
            if (r104 > r101) goto L29;
            joa.a.d(r100, r108);
            r104 = r104 + 1;
            goto L27
        L29:
            return r106;
        L20:
            if (r100.readInt() == 0) goto L22;
            boolean r109 = true;
        L23:
            r102 = Boolean.valueOf(r109);
            goto L24
        L22:
            r109 = false;
            goto L23
        L12:
            if (r100.readInt() == 0) goto L14;
            boolean r110 = true;
        L15:
            r105 = Boolean.valueOf(r110);
            goto L17
        L14:
            r110 = false;
            goto L15
        L5:
            int r111 = r100.readInt();
            r103 = new AlarmEntity[r111];
            int r112 = 0;
        L6:
            if (r112 == r111) goto L8;
            r103[r112] = (AlarmEntity) r100.readParcelable(ClockTurnOffAlarmParams.class.getClassLoader());
            r112 = r112 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ClockTurnOffAlarmParams[] newArray(int r100) {
            return new ClockTurnOffAlarmParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ClockTurnOffAlarmParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ClockTurnOffAlarmParams copy$default(ClockTurnOffAlarmParams r100, AlarmEntity[] r101, Boolean r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.targets;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.turnOffAll;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.always;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final AlarmEntity[] component1() {
        return this.targets;
    }

    public final Boolean component2() {
        return this.turnOffAll;
    }

    public final Boolean component3() {
        return this.always;
    }

    public final ClockTurnOffAlarmParams copy(AlarmEntity[] r100, Boolean r101, Boolean r102) {
        return new ClockTurnOffAlarmParams(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClockTurnOffAlarmParams) == true) goto L8;
        return false;
    L8:
        ClockTurnOffAlarmParams r101 = (ClockTurnOffAlarmParams) r100;
        if (Intrinsics.areEqual(this.targets, r101.targets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.turnOffAll, r101.turnOffAll) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.always, r101.always) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        AlarmEntity[] r100 = this.targets;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.turnOffAll;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.always;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = Arrays.hashCode(r100);
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "ClockTurnOffAlarmParams(targets=" + Arrays.toString(this.targets) + ", turnOffAll=" + this.turnOffAll + ", always=" + this.always + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        AlarmEntity[] r102 = this.targets;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L8:
        Boolean r103 = this.turnOffAll;
        if (r103 != null) goto L11;
        r100.writeInt(0);
    L12:
        Boolean r104 = this.always;
        if (r104 != null) goto L15;
        r100.writeInt(0);
        return;
    L15:
        r100.writeInt(1);
        r100.writeInt(r104.booleanValue() ? 1 : 0);
        return;
    L11:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        goto L12
    L5:
        r100.writeInt(1);
        int r105 = r102.length;
        r100.writeInt(r105);
        int r106 = 0;
    L6:
        if (r106 == r105) goto L8;
        r100.writeParcelable(r102[r106], r101);
        r106 = r106 + 1;
        goto L6
    }

    public final Boolean getAlways() {
        return this.always;
    }

    public final AlarmEntity[] getTargets() {
        return this.targets;
    }

    public final Boolean getTurnOffAll() {
        return this.turnOffAll;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof ClockTurnOffAlarmParams) == true) goto L5;
        return this;
    L5:
        AlarmEntity[] r101 = this.targets;
        if (r101 != null) goto L8;
        r101 = ((ClockTurnOffAlarmParams) r100).targets;
    L8:
        Boolean r102 = this.turnOffAll;
        if (r102 != null) goto L11;
        r102 = ((ClockTurnOffAlarmParams) r100).turnOffAll;
    L11:
        Boolean r103 = this.always;
        if (r103 != null) goto L15;
        r103 = ((ClockTurnOffAlarmParams) r100).always;
    L15:
        return new ClockTurnOffAlarmParams(r101, r102, r103);
    }

    public final void setAlways(Boolean r100) {
        this.always = r100;
    }

    public final void setTargets(AlarmEntity[] r100) {
        this.targets = r100;
    }

    public final void setTurnOffAll(Boolean r100) {
        this.turnOffAll = r100;
    }

    public ClockTurnOffAlarmParams(AlarmEntity[] r100, Boolean r101, Boolean r102) {
        this.targets = r100;
        this.turnOffAll = r101;
        this.always = r102;
    }

    public /* synthetic */ ClockTurnOffAlarmParams(AlarmEntity[] r100, Boolean r101, Boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
