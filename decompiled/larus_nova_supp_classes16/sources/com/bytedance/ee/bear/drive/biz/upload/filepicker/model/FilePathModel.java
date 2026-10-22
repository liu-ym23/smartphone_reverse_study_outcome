package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FilePathModel implements Parcelable {
    public static final Parcelable.Creator<FilePathModel> CREATOR = null;
    public final String a;
    public final String b;

    public class a implements Parcelable.Creator<FilePathModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FilePathModel createFromParcel(Parcel r2) {
            return new FilePathModel(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final FilePathModel[] newArray(int r1) {
            return new FilePathModel[r1];
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

    public FilePathModel(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
    }
}
