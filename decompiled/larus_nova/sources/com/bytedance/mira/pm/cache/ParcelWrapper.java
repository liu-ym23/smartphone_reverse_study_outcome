package com.bytedance.mira.pm.cache;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class ParcelWrapper {
    private static final int POOL_SIZE = 6;
    private static final ParcelWrapper[] mPool = null;
    Parcel mInner;
    private boolean mIsReadMode;
    Parcel mOut;

    static {
        mPool = new ParcelWrapper[6];
    }

    private void recycle() {
        this.mInner = null;
        this.mOut = null;
        int r100 = 0;
        this.mIsReadMode = false;
        ParcelWrapper[] r101 = mPool;
        monitor-enter(r101);
    L5:
        if (r100 >= 6) goto L12;
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r101[r100] == null) goto L8;
        r100 = r100 + 1;     // Catch: Throwable -> L14
        goto L5
    L8:
        r101[r100] = this;     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
    }

    private void finish() {
        if (this.mIsReadMode == false) goto L6;
        this.mInner.recycle();
        return;
    L6:
        if (this.mOut != null) goto L8;
        return;
    L8:
        int r100 = this.mInner.dataSize();
        this.mOut.writeInt(r100);
        this.mOut.appendFrom(this.mInner, 0, r100);
        this.mInner.recycle();
    }

    public int readInt() {
        Parcel r100 = this.mInner;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.readInt();
    }

    public String readString() {
        Parcel r100 = this.mInner;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.readString();
    }

    public void start() {
        Parcel r100 = this.mOut;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mIsReadMode == false) goto L8;
        int r101 = r100.readInt();
        int r102 = this.mOut.dataPosition();
        this.mOut.setDataPosition(r102 + r101);
        Parcel r103 = Parcel.obtain();
        this.mInner = r103;
        r103.setDataPosition(0);
        this.mInner.appendFrom(this.mOut, r102, r101);
        this.mInner.setDataPosition(0);
        return;
    L8:
        this.mInner = Parcel.obtain();
    }

    public void finishAndRecycle() {
        finish();
        recycle();
    }

    public Bundle readBundle(ClassLoader r100) {
        Parcel r101 = this.mInner;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.readBundle(r100);
    }

    public <T extends Parcelable> T readParcelable(ClassLoader r100) {
        Parcel r101 = this.mInner;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.readParcelable(r100);
    }

    public void readStringList(List<String> r100) {
        Parcel r101 = this.mInner;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.readStringList(r100);
    }

    public void writeBundle(Bundle r100) {
        Parcel r101 = this.mInner;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.writeBundle(r100);
    }

    public void writeInt(int r100) {
        Parcel r101 = this.mInner;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.writeInt(r100);
    }

    public void writeString(String r100) {
        Parcel r101 = this.mInner;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.writeString(r100);
    }

    public void writeStringList(List<String> r100) {
        Parcel r101 = this.mInner;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.writeStringList(r100);
    }

    private ParcelWrapper(Parcel r100, boolean r101) {
        this.mOut = r100;
        this.mIsReadMode = r101;
    }

    public static ParcelWrapper obtain(Parcel r100, boolean r101) {
        ParcelWrapper[] r102 = mPool;
        monitor-enter(r102);
        int r103 = 0;
    L6:
        if (r103 >= 6) goto L13;
        ParcelWrapper r104 = r102[r103];     // Catch: Throwable -> L16
        if (r104 != null) goto L9;
        r103 = r103 + 1;     // Catch: Throwable -> L16
        goto L6
    L9:
        r102[r103] = null;     // Catch: Throwable -> L16
        r104.mOut = r100;     // Catch: Throwable -> L16
        r104.mIsReadMode = r101;     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r104;
    L16:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L16
        return new ParcelWrapper(r100, r101);
    }

    private <T> List<T> readParcelableListInternal(List<T> r100, ClassLoader r101) {
        int r102 = readInt();
        if (r102 != (-1)) goto L6;
        r100.clear();
        return r100;
    L6:
        int r103 = r100.size();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L10;
        if (r104 >= r102) goto L10;
        ListProtector.set(r100, r104, readParcelable(r101));
        r104 = r104 + 1;
    L10:
        if (r104 >= r102) goto L12;
        r100.add(readParcelable(r101));
        r104 = r104 + 1;
    L12:
        if (r104 >= r103) goto L14;
        ListProtector.remove(r100, r102);
        r104 = r104 + 1;
        goto L12
    L14:
        return r100;
    }

    private <T extends Parcelable> void writeParcelableListInternal(List<T> r100, int r101) {
        if (r100 != null) goto L5;
        writeInt(-1);
        return;
    L5:
        int r102 = r100.size();
        writeInt(r102);
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        writeParcelable((Parcelable) ListProtector.get(r100, r103), r101);
        r103 = r103 + 1;
        goto L6
    }

    public <T> List<T> readParcelableList(List<T> r100, ClassLoader r101) {
        return readParcelableListInternal(r100, r101);
    }

    public void writeIntentInfoToParcel(Parcelable r100, int r101) {
        Parcel r102 = this.mInner;
        if (r102 != null) goto L5;
        return;
    L5:
        r100.writeToParcel(r102, r101);
    }

    public void writeParcelable(Parcelable r100, int r101) {
        Parcel r102 = this.mInner;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.writeParcelable(r100, r101);
    }

    public <T extends Parcelable> void writeParcelableList(List<T> r100, int r101) {
        if (this.mInner != null) goto L5;
        return;
    L5:
        writeParcelableListInternal(r100, r101);
    }
}
