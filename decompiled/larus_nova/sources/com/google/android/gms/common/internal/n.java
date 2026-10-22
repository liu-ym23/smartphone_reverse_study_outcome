package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes23.dex */
public final class n implements Parcelable.Creator {
    public n() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel r100) {
        int r101 = SafeParcelReader.validateObjectHeader(r100);
        Bundle r102 = null;
        Feature[] r103 = null;
        ConnectionTelemetryConfiguration r104 = null;
        int r105 = 0;
    L4:
        if (r100.dataPosition() >= r101) goto L18;
        int r106 = SafeParcelReader.readHeader(r100);
        int r107 = SafeParcelReader.getFieldId(r106);
        if (r107 != 1) goto L8;
        r102 = SafeParcelReader.createBundle(r100, r106);
        goto L4
    L8:
        if (r107 != 2) goto L10;
        r103 = (Feature[]) SafeParcelReader.createTypedArray(r100, r106, Feature.CREATOR);
        goto L4
    L10:
        if (r107 != 3) goto L12;
        r105 = SafeParcelReader.readInt(r100, r106);
        goto L4
    L12:
        if (r107 != 4) goto L13;
        r104 = (ConnectionTelemetryConfiguration) SafeParcelReader.createParcelable(r100, r106, ConnectionTelemetryConfiguration.CREATOR);
        goto L4
    L13:
        SafeParcelReader.skipUnknownField(r100, r106);
        goto L4
    L18:
        SafeParcelReader.ensureAtEnd(r100, r101);
        return new zzk(r102, r103, r105, r104);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r100) {
        return new zzk[r100];
    }
}
