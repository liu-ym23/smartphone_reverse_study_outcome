package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes41.dex */
public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f464422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f464423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f464424c;

    public class a implements Parcelable.Creator<AspectRatio> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AspectRatio createFromParcel(Parcel r100) {
            return new AspectRatio(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AspectRatio[] newArray(int r100) {
            return new AspectRatio[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public AspectRatio(Parcel r100) {
        this.f464422a = r100.readString();
        this.f464423b = r100.readFloat();
        this.f464424c = r100.readFloat();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f464422a);
        r100.writeFloat(this.f464423b);
        r100.writeFloat(this.f464424c);
    }

    public AspectRatio(String r100, float r101, float r102) {
        this.f464422a = r100;
        this.f464423b = r101;
        this.f464424c = r102;
    }
}
