package com.hihonor.mcs.system.diagnosis.core;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class CallbackPayload implements Parcelable {
    public static final Parcelable.Creator<CallbackPayload> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ParcelFileDescriptor f276636a;

    public static class a implements Parcelable.Creator<CallbackPayload> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CallbackPayload createFromParcel(Parcel r100) {
            return new CallbackPayload(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final CallbackPayload[] newArray(int r100) {
            return new CallbackPayload[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public CallbackPayload(Parcel r100) {
        this.f276636a = (ParcelFileDescriptor) r100.readParcelable(ParcelFileDescriptor.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f276636a, r101);
    }
}
