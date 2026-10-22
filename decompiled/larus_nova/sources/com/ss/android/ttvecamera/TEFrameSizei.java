package com.ss.android.ttvecamera;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Size;
import com.byted.cast.common.CastMonitor;

/* JADX INFO: loaded from: classes38.dex */
public class TEFrameSizei implements Parcelable {
    public static final Parcelable.Creator<TEFrameSizei> CREATOR = null;
    public int height;
    public int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int countOfPixels() {
        return this.width * this.height;
    }

    public boolean isValid() {
        if (this.width > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.height <= 0) goto L7;
        return true;
    }

    public Size toSize() {
        return new Size(this.width, this.height);
    }

    public String toString() {
        return this.width + "x" + this.height;
    }

    public TEFrameSizei() {
        this.width = 720;
        this.height = 1280;
    }

    public int hashCode() {
        return ((this.width * CastMonitor.EVENT_TRACK) + 1) + this.height;
    }

    public TEFrameSizei(Parcel r100) {
        this.width = 720;
        this.height = 1280;
        this.width = r100.readInt();
        this.height = r100.readInt();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof TEFrameSizei) == true) goto L5;
        return false;
    L5:
        TEFrameSizei r101 = (TEFrameSizei) r100;
        if (this.width == r101.width) goto L8;
        return false;
    L8:
        if (this.height != r101.height) goto L12;
        return true;
    L12:
        return false;
    }

    public void update(TEFrameSizei r100) {
        this.width = r100.width;
        this.height = r100.height;
    }

    public TEFrameSizei(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    }

    public void update(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.width);
        r100.writeInt(this.height);
    }
}
