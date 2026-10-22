package com.bytedance.bdp.bdpbase.ipc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes11.dex */
public final class Response<T> implements Parcelable {
    public static final Parcelable.Creator<Response<Object>> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f201125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f201126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f201127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f201128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f201129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f201130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f201131g;

    public class a implements Parcelable.Creator<Response<Object>> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Response<Object> createFromParcel(Parcel r100) {
            return new Response(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Response<Object>[] newArray(int r100) {
            return new Response[r100];
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
        StringBuilder r100 = new StringBuilder("Response{mRequestId='");
        r100.append(this.f201127c);
        r100.append("', mIsCallback='");
        if (this.f201128d == 0) goto L5;
        boolean r101 = true;
    L6:
        r100.append(r101);
        r100.append("', mStatusCode=");
        r100.append(this.f201125a);
        r100.append(", mStatusMessage='");
        r100.append(this.f201126b);
        r100.append("', mResult=");
        r100.append(this.f201129e);
        r100.append('}');
        return r100.toString();
    L5:
        r101 = false;
        goto L6
    }

    public Response(Parcel r100) {
        this.f201128d = 0;
        this.f201130f = -1;
        this.f201131g = -1;
        this.f201125a = r100.readInt();
        this.f201126b = r100.readString();
        this.f201129e = (T) r100.readValue(com.bytedance.bdp.bdpbase.util.b.a());
        this.f201127c = r100.readLong();
        this.f201128d = r100.readInt();
    }

    public void setResult(T r100) {
        this.f201129e = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f201125a);
        r100.writeString(this.f201126b);
        r100.writeValue(this.f201129e);
        r100.writeLong(this.f201127c);
        r100.writeInt(this.f201128d);
    }

    public Response(int r100, String r101, T r102, long r103, boolean r104) {
        this.f201128d = 0;
        this.f201130f = -1;
        this.f201131g = -1;
        this.f201125a = r100;
        this.f201126b = r101;
        this.f201129e = r102;
        this.f201127c = r103;
        this.f201128d = r104 ? 1 : 0;
    }
}
