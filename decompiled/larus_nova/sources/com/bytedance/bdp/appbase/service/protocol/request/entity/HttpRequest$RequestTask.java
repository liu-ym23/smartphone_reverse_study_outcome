package com.bytedance.bdp.appbase.service.protocol.request.entity;

import android.os.Parcel;
import android.os.Parcelable;
import e94.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class HttpRequest$RequestTask implements Parcelable {
    public static final Parcelable.Creator<HttpRequest$RequestTask> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f200988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f200989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f200990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f200991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f200992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f200993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f200994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f200995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f200996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f200997k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f200998l;

    public class a implements Parcelable.Creator<HttpRequest$RequestTask> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HttpRequest$RequestTask createFromParcel(Parcel r100) {
            return new HttpRequest$RequestTask(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final HttpRequest$RequestTask[] newArray(int r100) {
            return new HttpRequest$RequestTask[r100];
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
        return "{requestId: " + this.f200987a + ", url: " + this.f200988b + ", method: " + this.f200989c + ", usePrefetchCache: " + this.f200990d + ", data: " + this.f200991e + ", header: " + this.f200993g + ", responseType: " + this.f200994h + ", isSDKRequest: " + this.f200995i + '}';
    }

    public HttpRequest$RequestTask(Parcel r100) {
        this.f200987a = r100.readInt();
        this.f200988b = r100.readString();
        this.f200989c = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f200990d = r102;
        this.f200991e = r100.readString();
        this.f200992f = r100.createByteArray();
        this.f200993g = new b(r100.readString()).f471488a;
        this.f200994h = r100.readString();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f200995i = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.f200996j = r104;
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.f200997k = r105;
        if (r100.readByte() != 0) goto L22;
        r101 = false;
    L22:
        this.f200998l = r101;
        return;
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f200987a);
        r100.writeString(this.f200988b);
        r100.writeString(this.f200989c);
        r100.writeByte(this.f200990d ? 1 : 0);
        r100.writeString(this.f200991e);
        r100.writeByteArray(this.f200992f);
        JSONObject r102 = this.f200993g;
        if (r102 == null) goto L5;
        r100.writeString(r102.toString());
    L6:
        r100.writeString(this.f200994h);
        r100.writeByte(this.f200995i ? 1 : 0);
        r100.writeByte(this.f200996j ? 1 : 0);
        r100.writeByte(this.f200997k ? 1 : 0);
        r100.writeByte(this.f200998l ? 1 : 0);
        return;
    L5:
        r100.writeString(null);
        goto L6
    }
}
