package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VESize implements Parcelable {
    public static final Parcelable.Creator<VESize> CREATOR = null;
    public int height;
    public int width;

    public static final enum Ratio extends Enum<Ratio> {
        public static final Ratio RATIO_16_9 = null;
        public static final Ratio RATIO_1_1 = null;
        public static final Ratio RATIO_4_3 = null;
        public static final Ratio RATIO_ORIGINAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Ratio[] f455716a = null;

        static {
            Ratio r100 = new Ratio("RATIO_ORIGINAL", 0);
            RATIO_ORIGINAL = r100;
            Ratio r101 = new Ratio("RATIO_4_3", 1);
            RATIO_4_3 = r101;
            Ratio r102 = new Ratio("RATIO_16_9", 2);
            RATIO_16_9 = r102;
            Ratio r103 = new Ratio("RATIO_1_1", 3);
            RATIO_1_1 = r103;
            f455716a = new Ratio[]{r100, r101, r102, r103};
        }

        public static Ratio[] values() {
            return (Ratio[]) f455716a.clone();
        }

        public static Ratio valueOf(String r100) {
            return (Ratio) r27.a.a(Ratio.class, r100);
        }

        public Ratio(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Parcelable.Creator<VESize> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VESize createFromParcel(Parcel r100) {
            return new VESize(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VESize[] newArray(int r100) {
            return new VESize[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public boolean isValid() {
        if (this.width > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.height <= 0) goto L7;
        return true;
    }

    public String toString() {
        return this.width + "*" + this.height;
    }

    public VESize(Parcel r100) {
        this.width = 720;
        this.height = 1280;
        this.width = r100.readInt();
        this.height = r100.readInt();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof VESize) == false) goto L10;
        VESize r101 = (VESize) r100;
        if (this.width == r101.width) goto L7;
        return false;
    L7:
        if (this.height != r101.height) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public VESize(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.width);
        r100.writeInt(this.height);
    }
}
