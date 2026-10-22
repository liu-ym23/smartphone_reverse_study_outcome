package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes23.dex */
public final class f implements Parcelable.Creator {
    public f() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel r110) {
        int r100 = SafeParcelReader.validateObjectHeader(r110);
        int r101 = 0;
        boolean r102 = false;
        boolean r103 = false;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r110.dataPosition() >= r100) goto L21;
        int r106 = SafeParcelReader.readHeader(r110);
        int r107 = SafeParcelReader.getFieldId(r106);
        if (r107 != 1) goto L8;
        r101 = SafeParcelReader.readInt(r110, r106);
        goto L4
    L8:
        if (r107 != 2) goto L10;
        r102 = SafeParcelReader.readBoolean(r110, r106);
        goto L4
    L10:
        if (r107 != 3) goto L12;
        r103 = SafeParcelReader.readBoolean(r110, r106);
        goto L4
    L12:
        if (r107 != 4) goto L14;
        r104 = SafeParcelReader.readInt(r110, r106);
        goto L4
    L14:
        if (r107 != 5) goto L15;
        r105 = SafeParcelReader.readInt(r110, r106);
        goto L4
    L15:
        SafeParcelReader.skipUnknownField(r110, r106);
        goto L4
    L21:
        SafeParcelReader.ensureAtEnd(r110, r100);
        return new RootTelemetryConfiguration(r101, r102, r103, r104, r105);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r100) {
        return new RootTelemetryConfiguration[r100];
    }
}
