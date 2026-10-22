package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes23.dex */
public final class o implements Parcelable.Creator {
    public o() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel r110) {
        int r100 = SafeParcelReader.validateObjectHeader(r110);
        RootTelemetryConfiguration r101 = null;
        int[] r102 = null;
        int[] r103 = null;
        boolean r104 = false;
        boolean r105 = false;
        int r106 = 0;
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
        r103 = SafeParcelReader.createIntArray(r110, r107);
        goto L4
    L9:
        r106 = SafeParcelReader.readInt(r110, r107);
        goto L4
    L10:
        r102 = SafeParcelReader.createIntArray(r110, r107);
        goto L4
    L11:
        r105 = SafeParcelReader.readBoolean(r110, r107);
        goto L4
    L12:
        r104 = SafeParcelReader.readBoolean(r110, r107);
        goto L4
    L13:
        r101 = (RootTelemetryConfiguration) SafeParcelReader.createParcelable(r110, r107, RootTelemetryConfiguration.CREATOR);
        goto L4
    L7:
        SafeParcelReader.skipUnknownField(r110, r107);
        goto L4
    L14:
        SafeParcelReader.ensureAtEnd(r110, r100);
        return new ConnectionTelemetryConfiguration(r101, r104, r105, r102, r106, r103);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r100) {
        return new ConnectionTelemetryConfiguration[r100];
    }
}
