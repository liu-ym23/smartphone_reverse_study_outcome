package com.bytedance.bdp.appbase.request.contextservice.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes11.dex */
public final class RequestData implements Parcelable {
    public static final Parcelable.Creator<RequestData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f200955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f200956b;

    public class a implements Parcelable.Creator<RequestData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RequestData createFromParcel(Parcel r100) {
            return new RequestData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RequestData[] newArray(int r100) {
            return new RequestData[r100];
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
        return "{stringData: " + this.f200955a + '}';
    }

    public RequestData(Parcel r100) {
        this.f200955a = r100.readString();
        this.f200956b = r100.createByteArray();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f200955a);
        r100.writeByteArray(this.f200956b);
    }
}
