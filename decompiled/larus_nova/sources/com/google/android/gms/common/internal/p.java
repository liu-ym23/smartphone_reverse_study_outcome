package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes23.dex */
public final class p implements Parcelable.Creator {
    public p() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel r210) {
        int r100 = SafeParcelReader.validateObjectHeader(r210);
        Scope[] r101 = GetServiceRequest.f274503o;
        Scope[] r110 = r101;
        Bundle r111 = new Bundle();
        Feature[] r112 = GetServiceRequest.f274504p;
        Feature[] r113 = r112;
        String r114 = null;
        IBinder r115 = null;
        Account r116 = null;
        String r211 = null;
        int r102 = 0;
        int r103 = 0;
        int r117 = 0;
        boolean r118 = false;
        int r119 = 0;
        boolean r212 = false;
    L4:
        if (r210.dataPosition() >= r100) goto L22;
        int r104 = SafeParcelReader.readHeader(r210);
        switch(SafeParcelReader.getFieldId(r104)) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L7;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            default: goto L7;
        };
    L8:
        r211 = SafeParcelReader.createString(r210, r104);
        goto L4
    L9:
        r212 = SafeParcelReader.readBoolean(r210, r104);
        goto L4
    L10:
        r119 = SafeParcelReader.readInt(r210, r104);
        goto L4
    L11:
        r118 = SafeParcelReader.readBoolean(r210, r104);
        goto L4
    L12:
        r113 = (Feature[]) SafeParcelReader.createTypedArray(r210, r104, Feature.CREATOR);
        goto L4
    L13:
        r112 = (Feature[]) SafeParcelReader.createTypedArray(r210, r104, Feature.CREATOR);
        goto L4
    L14:
        r116 = (Account) SafeParcelReader.createParcelable(r210, r104, Account.CREATOR);
        goto L4
    L15:
        r111 = SafeParcelReader.createBundle(r210, r104);
        goto L4
    L16:
        r110 = (Scope[]) SafeParcelReader.createTypedArray(r210, r104, Scope.CREATOR);
        goto L4
    L17:
        r115 = SafeParcelReader.readIBinder(r210, r104);
        goto L4
    L18:
        r114 = SafeParcelReader.createString(r210, r104);
        goto L4
    L19:
        r117 = SafeParcelReader.readInt(r210, r104);
        goto L4
    L20:
        r103 = SafeParcelReader.readInt(r210, r104);
        goto L4
    L21:
        r102 = SafeParcelReader.readInt(r210, r104);
        goto L4
    L7:
        SafeParcelReader.skipUnknownField(r210, r104);
        goto L4
    L22:
        SafeParcelReader.ensureAtEnd(r210, r100);
        return new GetServiceRequest(r102, r103, r117, r114, r115, r110, r111, r116, r112, r113, r118, r119, r212, r211);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r100) {
        return new GetServiceRequest[r100];
    }

    public static void a(GetServiceRequest r100, Parcel r101, int r102) {
        int r103 = SafeParcelWriter.beginObjectHeader(r101);
        SafeParcelWriter.writeInt(r101, 1, r100.f274505a);
        SafeParcelWriter.writeInt(r101, 2, r100.f274506b);
        SafeParcelWriter.writeInt(r101, 3, r100.f274507c);
        SafeParcelWriter.writeString(r101, 4, r100.f274508d, false);
        SafeParcelWriter.writeIBinder(r101, 5, r100.f274509e, false);
        SafeParcelWriter.writeTypedArray(r101, 6, r100.f274510f, r102, false);
        SafeParcelWriter.writeBundle(r101, 7, r100.f274511g, false);
        SafeParcelWriter.writeParcelable(r101, 8, r100.f274512h, r102, false);
        SafeParcelWriter.writeTypedArray(r101, 10, r100.f274513i, r102, false);
        SafeParcelWriter.writeTypedArray(r101, 11, r100.f274514j, r102, false);
        SafeParcelWriter.writeBoolean(r101, 12, r100.f274515k);
        SafeParcelWriter.writeInt(r101, 13, r100.f274516l);
        SafeParcelWriter.writeBoolean(r101, 14, r100.f274517m);
        SafeParcelWriter.writeString(r101, 15, r100.f274518n, false);
        SafeParcelWriter.finishObjectHeader(r101, r103);
    }
}
