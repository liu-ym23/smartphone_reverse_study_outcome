package com.bytedance.bdp.bdpbase.ipc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes11.dex */
public class CallbackRequest implements Parcelable {
    public static final Parcelable.Creator<CallbackRequest> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f201098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f201099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ParameterList f201100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f201101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f201102e;

    public class a implements Parcelable.Creator<CallbackRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CallbackRequest createFromParcel(Parcel r100) {
            return new CallbackRequest(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final CallbackRequest[] newArray(int r100) {
            return new CallbackRequest[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String a() {
        if (this.f201102e != null) goto L6;
        this.f201102e = this.f201098a + '-' + this.f201099b;
    L6:
        return this.f201102e;
    }

    public final String b() {
        return "{Callback requestId='" + this.f201101d + "', method='" + a() + "'}";
    }

    public final String toString() {
        return "{Callback requestId='" + this.f201101d + "', method='" + this.f201099b + "', targetClass='" + this.f201098a + "'}";
    }

    public CallbackRequest(Parcel r100) {
        this.f201102e = null;
        this.f201098a = r100.readString();
        this.f201099b = r100.readString();
        this.f201100c = (ParameterList) r100.readParcelable(com.bytedance.bdp.bdpbase.util.b.a());
        this.f201101d = r100.readLong();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f201098a);
        r100.writeString(this.f201099b);
        r100.writeParcelable(this.f201100c, r101);
        r100.writeLong(this.f201101d);
    }

    public CallbackRequest(String r100, String r101, ParameterList r102, long r103) {
        this.f201102e = null;
        this.f201098a = r100;
        this.f201099b = r101;
        this.f201100c = r102;
        this.f201101d = r103;
    }
}
