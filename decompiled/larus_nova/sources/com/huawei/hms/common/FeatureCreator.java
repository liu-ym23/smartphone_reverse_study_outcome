package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes23.dex */
public final class FeatureCreator implements Parcelable.Creator<Feature> {
    public FeatureCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final Feature createFromParcel(Parcel r110) {
        String r100 = null;
        if (r110 != null) goto L5;
        return null;
    L5:
        int r101 = SafeParcelReader.validateObjectHeader(r110);
        int r102 = 0;
        long r103 = -1;
        int r104 = 0;
    L6:
        if (r102 > r101) goto L19;
        if (r110.dataPosition() >= r101) goto L19;
        r102 = r102 + 1;
        int r105 = SafeParcelReader.readHeader(r110);
        int r106 = SafeParcelReader.getFieldId(r105);
        if (r106 != 1) goto L12;
        r100 = SafeParcelReader.createString(r110, r105);
        goto L6
    L12:
        if (r106 != 2) goto L14;
        r104 = SafeParcelReader.readInt(r110, r105);
        goto L6
    L14:
        if (r106 != 3) goto L15;
        r103 = SafeParcelReader.readLong(r110, r105);
        goto L6
    L15:
        SafeParcelReader.skipUnknownField(r110, r105);
    L19:
        SafeParcelReader.ensureAtEnd(r110, r101);
        return new Feature(r100, r104, r103);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ Feature[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ Feature createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final Feature[] newArray(int r100) {
        return new Feature[r100];
    }
}
