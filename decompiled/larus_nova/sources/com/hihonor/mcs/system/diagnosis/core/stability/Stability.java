package com.hihonor.mcs.system.diagnosis.core.stability;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public class Stability implements Parcelable {
    public static final Parcelable.Creator<Stability> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumSet<Kind> f276669a;

    public static final enum Kind extends Enum<Kind> {
        public static final Kind ANR = null;
        public static final Kind CRASH = null;
        public static final Kind FDLEAK = null;
        public static final Kind KILLED = null;
        public static final Kind MEMORYLEAK = null;
        public static final Kind THREADLEAK = null;
        public static final Kind TOMBSTONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Kind[] f276670a = null;

        static {
            Kind r100 = new Kind("ANR", 0);
            ANR = r100;
            Kind r101 = new Kind(SuggestPromptErrorType.ERROR_TYPE_CRASH, 1);
            CRASH = r101;
            Kind r102 = new Kind("TOMBSTONE", 2);
            TOMBSTONE = r102;
            Kind r103 = new Kind("FDLEAK", 3);
            FDLEAK = r103;
            Kind r104 = new Kind("MEMORYLEAK", 4);
            MEMORYLEAK = r104;
            Kind r105 = new Kind("THREADLEAK", 5);
            THREADLEAK = r105;
            Kind r110 = new Kind("KILLED", 6);
            KILLED = r110;
            f276670a = new Kind[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public Kind(String r100, int r101) {
            super(r100, r101);
        }

        public static Kind valueOf(String r100) {
            return (Kind) r27.a.a(Kind.class, r100);
        }

        public static Kind[] values() {
            return (Kind[]) f276670a.clone();
        }
    }

    public static class a implements Parcelable.Creator<Stability> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Stability createFromParcel(Parcel r100) {
            return new Stability(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Stability[] newArray(int r100) {
            return new Stability[r100];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EnumSet<Kind> f276671a;

        public b() {
            this.f276671a = EnumSet.noneOf(Kind.class);
        }
    }

    static {
        CREATOR = new a();
    }

    public Stability(Parcel r100) {
        this.f276669a = EnumSet.noneOf(Kind.class);
        this.f276669a = (EnumSet) r100.readSerializable();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeSerializable(this.f276669a);
    }

    public final int hashCode() {
        Iterator r100 = this.f276669a.iterator();
        int r101 = 1;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = (r101 * 31) + ((Kind) r100.next()).hashCode();
        goto L4
    L6:
        return r101;
    }

    public Stability(b r100) {
        this.f276669a = EnumSet.noneOf(Kind.class);
        this.f276669a = r100.f276671a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Stability) == true) goto L8;
        return false;
    L8:
        Stability r101 = (Stability) r100;
        if (this.f276669a.size() == r101.f276669a.size()) goto L11;
        return false;
    L11:
        Iterator r102 = r101.f276669a.iterator();
    L13:
        if (r102.hasNext() == false) goto L17;
        Kind r103 = (Kind) r102.next();
        if (this.f276669a.contains(r103) == true) goto L13;
        return false;
    L17:
        return true;
    }
}
