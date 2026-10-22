package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes23.dex */
public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = null;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelableSparseArray() {
    }

    public ParcelableSparseArray(Parcel r100, ClassLoader r101) {
        int r102 = r100.readInt();
        int[] r103 = new int[r102];
        r100.readIntArray(r103);
        Parcelable[] r104 = r100.readParcelableArray(r101);
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        put(r103[r105], r104[r105]);
        r105 = r105 + 1;
        goto L3
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = size();
        int[] r103 = new int[r102];
        Parcelable[] r104 = new Parcelable[r102];
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L5;
        r103[r105] = keyAt(r105);
        r104[r105] = valueAt(r105);
        r105 = r105 + 1;
        goto L3
    L5:
        r100.writeInt(r102);
        r100.writeIntArray(r103);
        r100.writeParcelableArray(r104, r101);
    }
}
