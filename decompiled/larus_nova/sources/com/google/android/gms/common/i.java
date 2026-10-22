package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes23.dex */
public final class i implements Parcelable.Creator {
    public i() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel r100) {
        int r101 = SafeParcelReader.validateObjectHeader(r100);
        boolean r102 = false;
        String r103 = null;
        IBinder r104 = null;
        boolean r105 = false;
    L4:
        if (r100.dataPosition() >= r101) goto L18;
        int r106 = SafeParcelReader.readHeader(r100);
        int r107 = SafeParcelReader.getFieldId(r106);
        if (r107 != 1) goto L8;
        r103 = SafeParcelReader.createString(r100, r106);
        goto L4
    L8:
        if (r107 != 2) goto L10;
        r104 = SafeParcelReader.readIBinder(r100, r106);
        goto L4
    L10:
        if (r107 != 3) goto L12;
        r102 = SafeParcelReader.readBoolean(r100, r106);
        goto L4
    L12:
        if (r107 != 4) goto L13;
        r105 = SafeParcelReader.readBoolean(r100, r106);
        goto L4
    L13:
        SafeParcelReader.skipUnknownField(r100, r106);
        goto L4
    L18:
        SafeParcelReader.ensureAtEnd(r100, r101);
        return new zzs(r103, r104, r102, r105);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r100) {
        return new zzs[r100];
    }
}
