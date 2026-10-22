package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.storage.StorageVolume;

/* JADX INFO: loaded from: classes16.dex */
public final class StorageVolumeWrapper implements Parcelable {
    public static final Parcelable.Creator<StorageVolumeWrapper> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StorageVolume f223884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f223885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f223886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f223887d;

    public class a implements Parcelable.Creator<StorageVolumeWrapper> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StorageVolumeWrapper createFromParcel(Parcel r100) {
            return new StorageVolumeWrapper(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final StorageVolumeWrapper[] newArray(int r100) {
            return new StorageVolumeWrapper[r100];
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
        return "StorageVolumeWrapper{storageVolume=" + this.f223884a + '}';
    }

    public StorageVolumeWrapper(Parcel r100) {
        this.f223884a = (StorageVolume) r100.readParcelable(StorageVolume.class.getClassLoader());
        this.f223885b = r100.readInt();
        this.f223886c = r100.readLong();
        this.f223887d = r100.readLong();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f223884a, r101);
        r100.writeInt(this.f223885b);
        r100.writeLong(this.f223886c);
        r100.writeLong(this.f223887d);
    }
}
