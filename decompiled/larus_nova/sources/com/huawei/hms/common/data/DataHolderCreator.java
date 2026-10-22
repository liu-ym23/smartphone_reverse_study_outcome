package com.huawei.hms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes23.dex */
public final class DataHolderCreator implements Parcelable.Creator<DataHolder> {
    public DataHolderCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final DataHolder createFromParcel(Parcel r110) {
        int r100 = SafeParcelReader.validateObjectHeader(r110);
        int r101 = 0;
        String[] r102 = null;
        CursorWindow[] r103 = null;
        Bundle r104 = null;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r101 > r100) goto L22;
        if (r110.dataPosition() >= r100) goto L22;
        r101 = r101 + 1;
        int r107 = SafeParcelReader.readHeader(r110);
        int r108 = SafeParcelReader.getFieldId(r107);
        if (r108 != 1000) goto L9;
        r105 = SafeParcelReader.readInt(r110, r107);
        goto L3
    L9:
        if (r108 != 1) goto L11;
        r102 = SafeParcelReader.createStringArray(r110, r107);
        goto L3
    L11:
        if (r108 != 2) goto L13;
        r103 = (CursorWindow[]) SafeParcelReader.createTypedArray(r110, r107, CursorWindow.CREATOR);
        goto L3
    L13:
        if (r108 != 3) goto L15;
        r106 = SafeParcelReader.readInt(r110, r107);
        goto L3
    L15:
        if (r108 != 4) goto L16;
        r104 = SafeParcelReader.createBundle(r110, r107);
        goto L3
    L16:
        SafeParcelReader.skipUnknownField(r110, r107);
    L22:
        SafeParcelReader.ensureAtEnd(r110, r100);
        return new DataHolder(r105, r102, r103, r106, r104);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ DataHolder[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ DataHolder createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final DataHolder[] newArray(int r100) {
        return new DataHolder[r100];
    }
}
