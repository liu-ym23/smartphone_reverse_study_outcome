package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes23.dex */
public final class g implements Parcelable.Creator {
    public g() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel r110) {
        int r100 = SafeParcelReader.validateObjectHeader(r110);
        String r101 = null;
        IBinder r102 = null;
        boolean r103 = false;
        boolean r104 = false;
        boolean r105 = false;
        boolean r106 = false;
    L4:
        if (r110.dataPosition() >= r100) goto L14;
        int r107 = SafeParcelReader.readHeader(r110);
        switch(SafeParcelReader.getFieldId(r107)) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        r106 = SafeParcelReader.readBoolean(r110, r107);
        goto L4
    L9:
        r105 = SafeParcelReader.readBoolean(r110, r107);
        goto L4
    L10:
        r102 = SafeParcelReader.readIBinder(r110, r107);
        goto L4
    L11:
        r104 = SafeParcelReader.readBoolean(r110, r107);
        goto L4
    L12:
        r103 = SafeParcelReader.readBoolean(r110, r107);
        goto L4
    L13:
        r101 = SafeParcelReader.createString(r110, r107);
        goto L4
    L7:
        SafeParcelReader.skipUnknownField(r110, r107);
        goto L4
    L14:
        SafeParcelReader.ensureAtEnd(r110, r100);
        return new zzo(r101, r103, r104, r102, r105, r106);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r100) {
        return new zzo[r100];
    }
}
