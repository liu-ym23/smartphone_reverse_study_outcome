package com.hihonor.cloudservice.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class Scope implements Parcelable {
    public static final Parcelable.Creator<Scope> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f276503a;

    public class a implements Parcelable.Creator {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r100) {
            return new Scope(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new Scope[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final int hashCode() {
        String r100 = this.f276503a;
        if (r100 != null) goto L6;
        return super.hashCode();
    L6:
        return r100.hashCode();
    }

    public Scope() {
        this.f276503a = null;
    }

    public final String toString() {
        return this.f276503a;
    }

    public Scope(Parcel r100) {
        this.f276503a = r100.readString();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((r100 instanceof Scope) == true) goto L10;
        return false;
    L10:
        return ((Scope) r100).f276503a.equals(this.f276503a);
    }

    public Scope(String r100) {
        this.f276503a = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f276503a);
    }
}
