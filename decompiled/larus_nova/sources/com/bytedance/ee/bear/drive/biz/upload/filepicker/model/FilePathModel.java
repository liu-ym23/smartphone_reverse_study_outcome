package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class FilePathModel implements Parcelable {
    public static final Parcelable.Creator<FilePathModel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f223882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f223883b;

    public class a implements Parcelable.Creator<FilePathModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FilePathModel createFromParcel(Parcel r100) {
            return new FilePathModel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final FilePathModel[] newArray(int r100) {
            return new FilePathModel[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public FilePathModel() {
    }

    public FilePathModel(Parcel r100) {
        this.f223882a = r100.readString();
        this.f223883b = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f223882a);
        r100.writeString(this.f223883b);
    }
}
