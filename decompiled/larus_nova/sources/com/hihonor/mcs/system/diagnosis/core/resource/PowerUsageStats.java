package com.hihonor.mcs.system.diagnosis.core.resource;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes23.dex */
public class PowerUsageStats implements Parcelable {
    public static final Parcelable.Creator<PowerUsageStats> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f276664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f276665b;

    public static class a implements Parcelable.Creator<PowerUsageStats> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PowerUsageStats createFromParcel(Parcel r100) {
            return new PowerUsageStats(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final PowerUsageStats[] newArray(int r100) {
            return new PowerUsageStats[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PowerUsageStats(Parcel r100) {
        int r101 = r100.readInt();
        this.f276665b = r101;
        this.f276664a = new double[r101];
        int r102 = 0;
    L4:
        if (r102 >= this.f276665b) goto L6;
        this.f276664a[r102] = r100.readDouble();
        r102 = r102 + 1;
        goto L4
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        int r102 = this.f276664a.length;
        r100.writeInt(r102);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.writeDouble(this.f276664a[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("PowerUsageStats{Audio:");
        double r101 = -1.0d;
        if (this.f276665b >= 0) goto L5;
        double r102 = -1.0d;
    L6:
        r100.append(r102);
        r100.append(",Bluetooth:");
        if (this.f276665b > 0) goto L9;
        double r103 = -1.0d;
    L10:
        r100.append(r103);
        r100.append(",Camera:");
        if (2 <= this.f276665b) goto L13;
        double r104 = -1.0d;
    L14:
        r100.append(r104);
        r100.append(",Cpu:");
        if (3 <= this.f276665b) goto L17;
        double r105 = -1.0d;
    L18:
        r100.append(r105);
        r100.append(",Display:");
        if (4 <= this.f276665b) goto L21;
        double r106 = -1.0d;
    L22:
        r100.append(r106);
        r100.append(",Gnss:");
        if (5 <= this.f276665b) goto L25;
        double r107 = -1.0d;
    L26:
        r100.append(r107);
        r100.append(",Modem:");
        if (6 <= this.f276665b) goto L29;
        double r108 = -1.0d;
    L30:
        r100.append(r108);
        r100.append(",Sensor:");
        if (7 <= this.f276665b) goto L33;
        double r109 = -1.0d;
    L34:
        r100.append(r109);
        r100.append(",Wifi:");
        if (8 <= this.f276665b) goto L37;
        double r110 = -1.0d;
    L38:
        r100.append(r110);
        r100.append(",Gpu:");
        if (9 <= this.f276665b) goto L41;
        double r111 = -1.0d;
    L42:
        r100.append(r111);
        r100.append(",Other:");
        if (10 > this.f276665b) goto L46;
        r101 = this.f276664a[10];
    L46:
        r100.append(r101);
        r100.append(i.f25855d);
        return r100.toString();
    L41:
        r111 = this.f276664a[9];
        goto L42
    L37:
        r110 = this.f276664a[8];
        goto L38
    L33:
        r109 = this.f276664a[7];
        goto L34
    L29:
        r108 = this.f276664a[6];
        goto L30
    L25:
        r107 = this.f276664a[5];
        goto L26
    L21:
        r106 = this.f276664a[4];
        goto L22
    L17:
        r105 = this.f276664a[3];
        goto L18
    L13:
        r104 = this.f276664a[2];
        goto L14
    L9:
        r103 = this.f276664a[1];
        goto L10
    L5:
        r102 = this.f276664a[0];
        goto L6
    }
}
