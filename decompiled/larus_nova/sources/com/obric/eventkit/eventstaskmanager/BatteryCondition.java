package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/BatteryCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "percent", "", "isCharging", "", "(DZ)V", "()Z", "getPercent", "()D", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BatteryCondition implements Condition, Parcelable {
    public static final Parcelable.Creator<BatteryCondition> CREATOR = null;
    private final boolean isCharging;
    private final double percent;

    public static final class a implements Parcelable.Creator<BatteryCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BatteryCondition createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            double r102 = r100.readDouble();
            int r103 = 1;
            if (r100.readInt() == 0) goto L5;
            boolean r104 = true;
        L6:
            BatteryCondition r105 = new BatteryCondition(r102, r104);
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
        L7:
            if (r103 > r106) goto L9;
            r103 = r103 + 1;
        L9:
            if (r103 > r101) goto L11;
            joa.a.d(r100, r107);
            r103 = r103 + 1;
            goto L9
        L11:
            return r105;
        L5:
            r104 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final BatteryCondition[] newArray(int r100) {
            return new BatteryCondition[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BatteryCondition(double r100, boolean r101) {
        this.percent = r100;
        this.isCharging = r101;
    }

    public /* synthetic */ BatteryCondition(double r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101);
    }

    public static /* synthetic */ BatteryCondition copy$default(BatteryCondition r100, double r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.percent;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isCharging;
    L9:
        return r100.copy(r101, r102);
    }

    public final double component1() {
        return this.percent;
    }

    public final boolean component2() {
        return this.isCharging;
    }

    public final BatteryCondition copy(double r100, boolean r101) {
        return new BatteryCondition(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BatteryCondition) == true) goto L8;
        return false;
    L8:
        BatteryCondition r101 = (BatteryCondition) r100;
        if (Double.compare(this.percent, r101.percent) == 0) goto L12;
        return false;
    L12:
        if (this.isCharging == r101.isCharging) goto L14;
        return false;
    L14:
        return true;
    }

    public final double getPercent() {
        return this.percent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.percent);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.isCharging;
        ?? r103 = r102;
        if (r102 == false) goto L6;
        r103 = 1;
    L6:
        return r101 + r103;
    }

    public final boolean isCharging() {
        return this.isCharging;
    }

    public String toString() {
        return "BatteryCondition(percent=" + this.percent + ", isCharging=" + this.isCharging + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeDouble(this.percent);
        r100.writeInt(this.isCharging ? 1 : 0);
    }
}
