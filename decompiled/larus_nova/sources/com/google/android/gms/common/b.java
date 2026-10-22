package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements Parcelable.Creator {
    public b() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel r100) {
        int r101 = SafeParcelReader.validateObjectHeader(r100);
        long r102 = -1;
        int r103 = 0;
        String r104 = null;
    L4:
        if (r100.dataPosition() >= r101) goto L15;
        int r105 = SafeParcelReader.readHeader(r100);
        int r106 = SafeParcelReader.getFieldId(r105);
        if (r106 != 1) goto L8;
        r104 = SafeParcelReader.createString(r100, r105);
        goto L4
    L8:
        if (r106 != 2) goto L10;
        r103 = SafeParcelReader.readInt(r100, r105);
        goto L4
    L10:
        if (r106 != 3) goto L11;
        r102 = SafeParcelReader.readLong(r100, r105);
        goto L4
    L11:
        SafeParcelReader.skipUnknownField(r100, r105);
        goto L4
    L15:
        SafeParcelReader.ensureAtEnd(r100, r101);
        return new Feature(r104, r103, r102);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r100) {
        return new Feature[r100];
    }
}
