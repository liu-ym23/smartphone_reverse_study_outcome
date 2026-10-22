package com.ss.android.lark.location.dto;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes36.dex */
public class LocationClientConfig implements Parcelable {
    public static final Parcelable.Creator<LocationClientConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f431186a;

    public class a implements Parcelable.Creator<LocationClientConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocationClientConfig createFromParcel(Parcel r100) {
            return new LocationClientConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationClientConfig[] newArray(int r100) {
            return new LocationClientConfig[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public LocationClientConfig() {
    }

    public LocationClientConfig(Parcel r100) {
        if (r100.readInt() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f431186a = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f431186a ? 1 : 0);
    }
}
