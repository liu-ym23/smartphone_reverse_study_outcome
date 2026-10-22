package com.hihonor.cloudservice.support.api.clients;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public final class Status implements Parcelable {
    public static final Parcelable.Creator<Status> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f276497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f276498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f276499c;

    public class a implements Parcelable.Creator<Status> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Status createFromParcel(Parcel r100) {
            return new Status(r100.readInt(), r100.readString(), PendingIntent.readPendingIntentOrNullFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public final Status[] newArray(int r100) {
            return new Status[r100];
        }
    }

    public Status() {
        this(0, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f276497a), this.f276498b, this.f276499c});
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "{statusCode: " + this.f276497a + ", statusMessage: " + this.f276498b + ", pendingIntent: " + this.f276499c + ", }";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L33:
        return false;
    L8:
        if ((r100 instanceof Status) == false) goto L33;
        Status r101 = (Status) r100;
        if (this.f276497a != r101.f276497a) goto L31;
        String r102 = this.f276498b;
        String r103 = r101.f276498b;
        if (r102 == r103) goto L19;
        if (r102 != null) goto L16;
    L18:
        boolean r104 = false;
    L20:
        if (r104 == false) goto L31;
        PendingIntent r105 = this.f276499c;
        PendingIntent r106 = r101.f276499c;
        if (r105 == r106) goto L28;
        if (r105 != null) goto L25;
    L27:
        boolean r107 = false;
    L29:
        if (r107 == false) goto L31;
        return true;
    L25:
        if (r105.equals(r106) == false) goto L27;
    L28:
        r107 = true;
        goto L29
    L16:
        if (r102.equals(r103) == false) goto L18;
    L19:
        r104 = true;
    L31:
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f276497a);
        r100.writeString(this.f276498b);
        PendingIntent.writePendingIntentOrNullToParcel(this.f276499c, r100);
    }

    public Status(int r100, String r101, PendingIntent r102) {
        this.f276497a = r100;
        this.f276498b = r101;
        this.f276499c = r102;
    }
}
