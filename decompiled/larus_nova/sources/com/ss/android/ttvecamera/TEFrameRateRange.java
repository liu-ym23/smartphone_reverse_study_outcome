package com.ss.android.ttvecamera;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Range;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class TEFrameRateRange implements Parcelable {
    public static final Parcelable.Creator<TEFrameRateRange> CREATOR = null;
    public int fpsUnitFactor;
    public int max;
    public int min;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int[] getRealFpsRange() {
        int r100 = this.min;
        int r101 = this.fpsUnitFactor;
        return new int[]{r100 / r101, this.max / r101};
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public boolean isValid() {
        int r100 = this.min;
        if (r100 >= 0) goto L5;
    L9:
        return false;
    L5:
        if (this.max < r100) goto L9;
        if (this.fpsUnitFactor <= 0) goto L9;
        return true;
    }

    public String toString() {
        return "[" + (this.min / this.fpsUnitFactor) + ", " + (this.max / this.fpsUnitFactor) + "]";
    }

    public int hashCode() {
        return ((this.min * CastMonitor.EVENT_TRACK) + 1) + this.max;
    }

    public TEFrameRateRange(Parcel r100) {
        this.fpsUnitFactor = 1;
        this.min = r100.readInt();
        this.max = r100.readInt();
        this.fpsUnitFactor = r100.readInt();
    }

    public static int getFpsUnitFactor(List<int[]> r100) {
        if (r100.size() > 0) goto L6;
        return 1;
    L6:
        if (((int[]) ListProtector.get(r100, 0))[1] <= 1000) goto L9;
        return 1000;
    L9:
        return 1;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof TEFrameRateRange) == true) goto L5;
        return false;
    L5:
        TEFrameRateRange r101 = (TEFrameRateRange) r100;
        if (this.min == r101.min) goto L8;
        return false;
    L8:
        if (this.max != r101.max) goto L12;
        return true;
    L12:
        return false;
    }

    public int[] mulFactor(int r100) {
        int r101 = this.min;
        int r102 = this.fpsUnitFactor;
        return new int[]{(r101 / r102) * r100, (this.max / r102) * r100};
    }

    public int setFpsUnitFactor(Range<Integer>[] r100) {
        if (r100.length > 0) goto L6;
        return 1;
    L6:
        if (((Integer) r100[0].getUpper()).intValue() >= 1000) goto L9;
        return 1000;
    L9:
        return 1;
    }

    public int setFpsUnitFactor(List<int[]> r100) {
        if (r100.size() > 0) goto L6;
        return 1;
    L6:
        if (((int[]) ListProtector.get(r100, 0))[1] <= 1000) goto L9;
        return 1000;
    L9:
        return 1;
    }

    public TEFrameRateRange(int r100, int r101) {
        int r102 = 1;
        this.fpsUnitFactor = 1;
        this.min = r100;
        this.max = r101;
        if (r101 <= 1000) goto L5;
        r102 = 1000;
    L5:
        this.fpsUnitFactor = r102;
    }

    public static TEFrameRateRange mul(TEFrameRateRange r100, int r101) {
        return new TEFrameRateRange(r100.min * r101, r100.max * r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.min);
        r100.writeInt(this.max);
        r100.writeInt(this.fpsUnitFactor);
    }
}
