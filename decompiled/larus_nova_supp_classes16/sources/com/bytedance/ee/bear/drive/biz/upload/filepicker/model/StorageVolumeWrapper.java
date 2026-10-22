package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.storage.StorageVolume;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class StorageVolumeWrapper implements Parcelable {
    public static final Parcelable.Creator<StorageVolumeWrapper> CREATOR = null;
    public final StorageVolume a;
    public final int b;
    public final long c;
    public final long d;

    public class a implements Parcelable.Creator<StorageVolumeWrapper> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StorageVolumeWrapper createFromParcel(Parcel r2) {
            return new StorageVolumeWrapper(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final StorageVolumeWrapper[] newArray(int r1) {
            return new StorageVolumeWrapper[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "StorageVolumeWrapper{storageVolume=" + this.a + '}';
    }

    public StorageVolumeWrapper(Parcel r3) {
        this.a = (StorageVolume) r3.readParcelable(StorageVolume.class.getClassLoader());
        this.b = r3.readInt();
        this.c = r3.readLong();
        this.d = r3.readLong();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeParcelable(this.a, r4);
        r3.writeInt(this.b);
        r3.writeLong(this.c);
        r3.writeLong(this.d);
    }
}
