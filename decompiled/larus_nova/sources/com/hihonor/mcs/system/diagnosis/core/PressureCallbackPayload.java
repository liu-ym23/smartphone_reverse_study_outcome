package com.hihonor.mcs.system.diagnosis.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.mcs.system.diagnosis.core.pressure.PressurePayload;

/* JADX INFO: loaded from: classes23.dex */
public class PressureCallbackPayload implements Parcelable {
    public static final Parcelable.Creator<PressureCallbackPayload> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PressurePayload f276637a;

    public static class a implements Parcelable.Creator<PressureCallbackPayload> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PressureCallbackPayload createFromParcel(Parcel r100) {
            return new PressureCallbackPayload(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final PressureCallbackPayload[] newArray(int r100) {
            return new PressureCallbackPayload[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PressureCallbackPayload() {
    }

    public PressureCallbackPayload(Parcel r100) {
        this.f276637a = (PressurePayload) r100.readParcelable(PressurePayload.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.f276637a, r101);
    }
}
