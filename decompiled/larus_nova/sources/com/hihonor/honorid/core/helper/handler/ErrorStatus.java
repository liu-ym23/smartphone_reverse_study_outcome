package com.hihonor.honorid.core.helper.handler;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class ErrorStatus implements Parcelable {
    public static final Parcelable.Creator<ErrorStatus> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f276629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f276630b;

    public class a implements Parcelable.Creator<ErrorStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorStatus createFromParcel(Parcel r100) {
            ErrorStatus r101 = new ErrorStatus();
            r101.f276629a = r100.readInt();
            r101.f276630b = r100.readString();
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorStatus[] newArray(int r100) {
            return new ErrorStatus[r100];
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
        return "[ErrorCode]:" + this.f276629a + "[DES]:" + this.f276630b;
    }

    public ErrorStatus() {
    }

    public ErrorStatus(int r100, String r101) {
        this.f276629a = r100;
        this.f276630b = r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f276629a);
        r100.writeString(this.f276630b);
    }
}
