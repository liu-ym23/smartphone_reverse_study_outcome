package com.bytedance.ee.bear.contract.config;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TenantInfo implements Parcelable {
    public static final Parcelable.Creator<TenantInfo> CREATOR = null;
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final InterfaceDomain e;
    public final String f;
    public final List<String> g;
    public final String h;
    public final String i;
    public final String j;
    public final int k;

    public class a implements Parcelable.Creator<TenantInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TenantInfo createFromParcel(Parcel r2) {
            return new TenantInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final TenantInfo[] newArray(int r1) {
            return new TenantInfo[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "TenantInfo{hostDomain='" + this.a + "', country='" + this.b + "', isOversea=" + this.d + ", interfaceDomain=" + this.e + ", mainPersistentConnectionDomain='" + this.f + "', persistentConnectionKey='" + this.h + "', configPlatformURL='" + this.i + "', frontendHotFixDomain='" + this.j + '}';
    }

    public TenantInfo(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
        if (r2.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.d = r0;
        this.e = (InterfaceDomain) r2.readParcelable(InterfaceDomain.class.getClassLoader());
        this.f = r2.readString();
        this.h = r2.readString();
        this.i = r2.readString();
        this.j = r2.readString();
        this.k = r2.readInt();
        this.g = r2.createStringArrayList();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        r2.writeString(this.a);
        r2.writeString(this.b);
        r2.writeByte(this.d ? 1 : 0);
        r2.writeParcelable(this.e, r3);
        r2.writeString(this.f);
        r2.writeString(this.h);
        r2.writeString(this.i);
        r2.writeString(this.j);
        r2.writeInt(this.k);
        r2.writeStringList(this.g);
    }

    public TenantInfo(String r1, String r2, boolean r3, InterfaceDomain r4, String r5, List r6, String r7, String r8, int r9, String r10) {
        this.a = r1;
        this.c = r2;
        this.b = "";
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.h = r10;
    }
}
