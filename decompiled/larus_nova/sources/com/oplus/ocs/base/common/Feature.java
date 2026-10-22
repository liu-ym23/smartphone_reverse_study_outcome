package com.oplus.ocs.base.common;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes34.dex */
public class Feature implements Parcelable {
    public static final Parcelable.Creator<Feature> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f404148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f404149b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public long getVersion() {
        long r100 = this.f404149b;
        if (r100 != (-1)) goto L5;
        return -1;
    L5:
        return r100;
    }

    public String getName() {
        return this.f404148a;
    }

    public Feature(Parcel r100) {
        this.f404148a = r100.readString();
        this.f404149b = r100.readLong();
    }

    public Feature(String r100, long r101) {
        this.f404148a = r100;
        this.f404149b = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f404148a);
        r100.writeLong(this.f404149b);
    }
}
