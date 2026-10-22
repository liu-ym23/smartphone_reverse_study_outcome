package com.hihonor.mcs.system.diagnosis.core.performance;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public class Performance implements Parcelable {
    public static final Parcelable.Creator<Performance> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumSet<Kind> f276658a;

    public static final enum Kind extends Enum<Kind> {
        public static final Kind ACTIVITY_START_TIMEOUT = null;
        public static final Kind ANIMATION_JANK_FRAME = null;
        public static final Kind APP_SKIP_FRAME = null;
        public static final Kind APP_STARTUP_SLOW = null;
        public static final Kind FLING_JANK_FRAME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Kind[] f276659a = null;

        static {
            Kind r100 = new Kind("APP_STARTUP_SLOW", 0);
            APP_STARTUP_SLOW = r100;
            Kind r101 = new Kind("APP_SKIP_FRAME", 1);
            APP_SKIP_FRAME = r101;
            Kind r102 = new Kind("FLING_JANK_FRAME", 2);
            FLING_JANK_FRAME = r102;
            Kind r103 = new Kind("ANIMATION_JANK_FRAME", 3);
            ANIMATION_JANK_FRAME = r103;
            Kind r104 = new Kind("ACTIVITY_START_TIMEOUT", 4);
            ACTIVITY_START_TIMEOUT = r104;
            f276659a = new Kind[]{r100, r101, r102, r103, r104};
        }

        public Kind(String r100, int r101) {
            super(r100, r101);
        }

        public static Kind valueOf(String r100) {
            return (Kind) r27.a.a(Kind.class, r100);
        }

        public static Kind[] values() {
            return (Kind[]) f276659a.clone();
        }
    }

    public static class a implements Parcelable.Creator<Performance> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Performance createFromParcel(Parcel r100) {
            return new Performance(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Performance[] newArray(int r100) {
            return new Performance[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public Performance(Parcel r100) {
        this.f276658a = EnumSet.noneOf(Kind.class);
        this.f276658a = (EnumSet) r100.readSerializable();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeSerializable(this.f276658a);
    }

    public final int hashCode() {
        Iterator r100 = this.f276658a.iterator();
        int r101 = 1;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = (r101 * 31) + ((Kind) r100.next()).hashCode();
        goto L4
    L6:
        return r101;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Performance) == true) goto L8;
        return false;
    L8:
        Performance r101 = (Performance) r100;
        if (this.f276658a.size() == r101.f276658a.size()) goto L11;
        return false;
    L11:
        Iterator r102 = r101.f276658a.iterator();
    L13:
        if (r102.hasNext() == false) goto L17;
        Kind r103 = (Kind) r102.next();
        if (this.f276658a.contains(r103) == true) goto L13;
        return false;
    L17:
        return true;
    }
}
