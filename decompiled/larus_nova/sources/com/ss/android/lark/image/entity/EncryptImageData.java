package com.ss.android.lark.image.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes36.dex */
public class EncryptImageData implements Parcelable {
    public static final Parcelable.Creator<EncryptImageData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f426282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f426283b;

    public class a implements Parcelable.Creator<EncryptImageData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EncryptImageData createFromParcel(Parcel r100) {
            return new EncryptImageData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final EncryptImageData[] newArray(int r100) {
            return new EncryptImageData[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public EncryptImageData() {
    }

    public EncryptImageData(Parcel r100) {
        this.f426282a = r100.readString();
        this.f426283b = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f426282a);
        r100.writeString(this.f426283b);
    }
}
