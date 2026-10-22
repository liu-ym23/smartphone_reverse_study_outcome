package com.hihonor.mcs.system.diagnosis.core.powerthermal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public class PowerThermal implements Parcelable {
    public static final Parcelable.Creator<PowerThermal> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumSet<Kind> f276660a;

    public static final enum Kind extends Enum<Kind> {
        public static final Kind POWER_EXCESSIVE_DRAIN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Kind[] f276661a = null;

        static {
            Kind r100 = new Kind();
            POWER_EXCESSIVE_DRAIN = r100;
            f276661a = new Kind[]{r100};
        }

        public Kind() {
            super("POWER_EXCESSIVE_DRAIN", 0);
        }

        public static Kind valueOf(String r100) {
            return (Kind) r27.a.a(Kind.class, r100);
        }

        public static Kind[] values() {
            return (Kind[]) f276661a.clone();
        }
    }

    public static class a implements Parcelable.Creator<PowerThermal> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PowerThermal createFromParcel(Parcel r100) {
            return new PowerThermal(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final PowerThermal[] newArray(int r100) {
            return new PowerThermal[r100];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EnumSet<Kind> f276662a;

        public b() {
            this.f276662a = EnumSet.noneOf(Kind.class);
        }
    }

    static {
        CREATOR = new a();
    }

    public PowerThermal(Parcel r100) {
        this.f276660a = EnumSet.noneOf(Kind.class);
        this.f276660a = (EnumSet) r100.readSerializable();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeSerializable(this.f276660a);
    }

    public final int hashCode() {
        Iterator r100 = this.f276660a.iterator();
        int r101 = 1;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = (r101 * 31) + ((Kind) r100.next()).hashCode();
        goto L4
    L6:
        return r101;
    }

    public PowerThermal(b r100) {
        this.f276660a = EnumSet.noneOf(Kind.class);
        this.f276660a = r100.f276662a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PowerThermal) == true) goto L8;
        return false;
    L8:
        PowerThermal r101 = (PowerThermal) r100;
        if (this.f276660a.size() == r101.f276660a.size()) goto L11;
        return false;
    L11:
        Iterator r102 = r101.f276660a.iterator();
    L13:
        if (r102.hasNext() == false) goto L17;
        Kind r103 = (Kind) r102.next();
        if (this.f276660a.contains(r103) == true) goto L13;
        return false;
    L17:
        return true;
    }
}
