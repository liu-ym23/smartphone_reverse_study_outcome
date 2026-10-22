package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements Parcelable.Creator {
    public a() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel r100) {
        int r101 = SafeParcelReader.validateObjectHeader(r100);
        String r102 = null;
        int r103 = 0;
    L4:
        if (r100.dataPosition() >= r101) goto L12;
        int r104 = SafeParcelReader.readHeader(r100);
        int r105 = SafeParcelReader.getFieldId(r104);
        if (r105 != 1) goto L8;
        r103 = SafeParcelReader.readInt(r100, r104);
        goto L4
    L8:
        if (r105 != 2) goto L9;
        r102 = SafeParcelReader.createString(r100, r104);
        goto L4
    L9:
        SafeParcelReader.skipUnknownField(r100, r104);
        goto L4
    L12:
        SafeParcelReader.ensureAtEnd(r100, r101);
        return new Scope(r103, r102);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r100) {
        return new Scope[r100];
    }
}
