package com.oplus.ocs.base.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes34.dex */
final class b implements Parcelable.Creator<Status> {
    public b() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel r110) {
        int r100 = r110.readInt();
        int r101 = com.oplus.ocs.base.internal.safeparcel.a.b(r110, r100);
        int r102 = r110.dataPosition();
        if ((r100 & 65535) != 20293) goto L40;
        int r103 = r101 + r102;
        if (r103 < r102) goto L38;
        if (r103 > r110.dataSize()) goto L38;
        int r104 = 0;
        String r105 = null;
        PendingIntent r106 = null;
        int r107 = 0;
    L10:
        if (r110.dataPosition() >= r103) goto L12;
        int r108 = r110.readInt();
        int r109 = r108 & 65535;
        if (r109 != 1) goto L20;
        r107 = com.oplus.ocs.base.internal.safeparcel.a.a(r110, r108);
        goto L10
    L20:
        if (r109 != 2) goto L22;
        int r111 = com.oplus.ocs.base.internal.safeparcel.a.b(r110, r108);
        int r112 = r110.dataPosition();
        if (r111 == 0) goto L34;
        String r113 = r110.readString();
        r110.setDataPosition(r112 + r111);
        r105 = r113;
        goto L10
    L34:
        r105 = null;
        goto L10
    L22:
        if (r109 != 3) goto L24;
        Parcelable.Creator r114 = PendingIntent.CREATOR;
        int r115 = com.oplus.ocs.base.internal.safeparcel.a.b(r110, r108);
        int r116 = r110.dataPosition();
        if (r115 != 0) goto L30;
        Parcelable r117 = null;
    L31:
        r106 = (PendingIntent) r117;
        goto L10
    L30:
        r117 = (Parcelable) r114.createFromParcel(r110);
        r110.setDataPosition(r116 + r115);
        goto L31
    L24:
        if (r109 != 1000) goto L25;
        r104 = com.oplus.ocs.base.internal.safeparcel.a.a(r110, r108);
        goto L10
    L25:
        r110.setDataPosition(r110.dataPosition() + com.oplus.ocs.base.internal.safeparcel.a.b(r110, r108));
        goto L10
    L12:
        if (r110.dataPosition() != r103) goto L16;
        return new Status(r104, r107, r105, r106);
    L16:
        throw new com.oplus.ocs.base.internal.safeparcel.a.C4690a("Overread allowed size end=".concat(String.valueOf(r103)));
    L38:
        throw new com.oplus.ocs.base.internal.safeparcel.a.C4690a("Size read is invalid start=" + r102 + " end=" + r103);
    L40:
        throw new com.oplus.ocs.base.internal.safeparcel.a.C4690a("Expected object header. Got 0x" + Integer.toHexString(r100));
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Status[] newArray(int r100) {
        return new Status[r100];
    }
}
