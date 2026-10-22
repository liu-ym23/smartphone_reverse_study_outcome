package com.oplus.ocs.base.internal.safeparcel;

import android.os.Parcel;

/* JADX INFO: loaded from: classes34.dex */
public final class b {
    public static void a(Parcel r100, int r101) {
        int r102 = r100.dataPosition();
        r100.setDataPosition(r101 - 4);
        r100.writeInt(r102 - r101);
        r100.setDataPosition(r102);
    }

    public static int b(Parcel r100, int r101) {
        r100.writeInt(r101 | (-65536));
        r100.writeInt(0);
        return r100.dataPosition();
    }

    private static void c(Parcel r100, int r101) {
        r100.writeInt(r101 | 262144);
    }

    public static void a(Parcel r100, int r101, int r102) {
        c(r100, r101);
        r100.writeInt(r102);
    }
}
