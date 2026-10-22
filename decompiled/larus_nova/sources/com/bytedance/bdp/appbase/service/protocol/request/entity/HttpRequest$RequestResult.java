package com.bytedance.bdp.appbase.service.protocol.request.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes11.dex */
public final class HttpRequest$RequestResult implements Parcelable {
    public static final Parcelable.Creator<HttpRequest$RequestResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f200980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f200981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f200982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f200983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f200984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f200985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f200986h;

    public class a implements Parcelable.Creator<HttpRequest$RequestResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HttpRequest$RequestResult createFromParcel(Parcel r100) {
            return new HttpRequest$RequestResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final HttpRequest$RequestResult[] newArray(int r100) {
            return new HttpRequest$RequestResult[r100];
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
        return "{success: " + this.f200980b + ", requestId: " + this.f200979a + ", statusCode: " + this.f200981c + ", data: " + this.f200982d + ", header: null, responseType: " + this.f200983e + ", message: " + this.f200985g + ", failThrowable: null, prefetchStatus: " + this.f200986h + '}';
    }

    public HttpRequest$RequestResult(Parcel r100) {
        this.f200979a = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f200980b = r101;
        this.f200981c = r100.readInt();
        this.f200982d = r100.readString();
        this.f200983e = r100.readString();
        this.f200984f = r100.createByteArray();
        this.f200985g = r100.readString();
        this.f200986h = r100.readInt();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f200979a);
        r100.writeByte(this.f200980b ? 1 : 0);
        r100.writeInt(this.f200981c);
        r100.writeString(this.f200982d);
        r100.writeString(this.f200983e);
        r100.writeByteArray(this.f200984f);
        r100.writeString(this.f200985g);
        r100.writeInt(this.f200986h);
    }
}
