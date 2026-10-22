package com.google.android.gms.internal.common;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f274647a = 0;

    public h() {
    }

    static {
        h.class.getClassLoader();
    }

    public static void b(Parcel r100) {
        int r101 = r100.dataAvail();
        if (r101 > 0) goto L6;
        return;
    L6:
        throw new BadParcelableException("Parcel data not fully consumed, unread size: " + r101);
    }

    public static Parcelable a(Parcel r100, Parcelable.Creator r101) {
        if (r100.readInt() != 0) goto L7;
        return null;
    L7:
        return (Parcelable) r101.createFromParcel(r100);
    }

    public static void c(Parcel r100, Parcelable r101) {
        if (r101 != null) goto L6;
        r100.writeInt(0);
        return;
    L6:
        r100.writeInt(1);
        r101.writeToParcel(r100, 0);
    }

    public static void d(Parcel r100, IInterface r101) {
        if (r101 != null) goto L5;
        r100.writeStrongBinder(null);
        return;
    L5:
        r100.writeStrongBinder(r101.asBinder());
    }
}
