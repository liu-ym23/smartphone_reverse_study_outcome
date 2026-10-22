package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes23.dex */
public final class g implements Parcelable.Creator {
    public g() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel r100) {
        int r101 = SafeParcelReader.validateObjectHeader(r100);
        int r102 = 0;
    L4:
        if (r100.dataPosition() >= r101) goto L9;
        int r103 = SafeParcelReader.readHeader(r100);
        if (SafeParcelReader.getFieldId(r103) != 1) goto L7;
        r102 = SafeParcelReader.readInt(r100, r103);
        goto L4
    L7:
        SafeParcelReader.skipUnknownField(r100, r103);
        goto L4
    L9:
        SafeParcelReader.ensureAtEnd(r100, r101);
        return new zzak(r102);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r100) {
        return new zzak[r100];
    }
}
