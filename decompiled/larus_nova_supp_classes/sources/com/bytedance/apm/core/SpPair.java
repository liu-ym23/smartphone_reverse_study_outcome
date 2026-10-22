package com.bytedance.apm.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class SpPair implements Parcelable {
    public static final Parcelable.Creator<SpPair> CREATOR = null;
    public final String a;
    public final Object b;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SpPair(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readValue(getClass().getClassLoader());
    }

    public SpPair(String r1, Object r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeValue(this.b);
    }
}
