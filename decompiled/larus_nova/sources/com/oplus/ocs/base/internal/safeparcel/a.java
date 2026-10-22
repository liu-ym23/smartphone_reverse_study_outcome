package com.oplus.ocs.base.internal.safeparcel;

import android.os.Parcel;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: com.oplus.ocs.base.internal.safeparcel.a$a, reason: collision with other inner class name */
    public static class C4690a extends RuntimeException {
        public C4690a(String r100) {
            super(r100);
        }
    }

    public static int a(Parcel r100, int r101) {
        c(r100, r101);
        return r100.readInt();
    }

    public static int b(Parcel r100, int r101) {
        if ((r101 & (-65536)) == (-65536)) goto L7;
        return (r101 >> 16) & 65535;
    L7:
        return r100.readInt();
    }

    private static void c(Parcel r100, int r101) {
        int r102 = b(r100, r101);
        if (r102 != 4) goto L6;
        return;
    L6:
        throw new C4690a("Expected size 4 got " + r102 + " (0x" + Integer.toHexString(r102) + ")");
    }
}
