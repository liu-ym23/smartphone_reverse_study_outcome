package com.hihonor.cloudservice.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class PermissionInfo implements Parcelable {
    public static final Parcelable.Creator<PermissionInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f276500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f276501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f276502c;

    public class a implements Parcelable.Creator {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r100) {
            return new PermissionInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new PermissionInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public PermissionInfo() {
    }

    public PermissionInfo(Parcel r100) {
        this.f276500a = r100.readString();
        this.f276501b = r100.readString();
        this.f276502c = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f276500a);
        r100.writeString(this.f276501b);
        r100.writeString(this.f276502c);
    }
}
