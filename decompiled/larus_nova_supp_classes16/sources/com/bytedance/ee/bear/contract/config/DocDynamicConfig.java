package com.bytedance.ee.bear.contract.config;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocDynamicConfig implements Parcelable {
    public static final Parcelable.Creator<DocDynamicConfig> CREATOR = null;
    public final String a;
    public final TenantInfo b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final LoginInfo f;
    public final String g;
    public final String h;
    public final boolean i;

    public class a implements Parcelable.Creator<DocDynamicConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DocDynamicConfig createFromParcel(Parcel r2) {
            return new DocDynamicConfig(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DocDynamicConfig[] newArray(int r1) {
            return new DocDynamicConfig[r1];
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
        return "DocDynamicConfig{', deviceId='" + this.a + "', tenantInfo=" + this.b + ", showDocWatermark=" + this.c + ", isKABuildPackage=" + this.d + ", buildPackageChannel='" + this.e + ", userUnit='" + this.g + ", brand='" + this.h + "'}";
    }

    public DocDynamicConfig(Parcel r4) {
        boolean r0 = false;
        this.d = false;
        this.e = "normal";
        this.i = false;
        this.a = r4.readString();
        this.b = (TenantInfo) r4.readParcelable(TenantInfo.class.getClassLoader());
        if (r4.readByte() == 0) goto L5;
        boolean r1 = true;
    L6:
        this.c = r1;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.d = r2;
        this.e = r4.readString();
        this.g = r4.readString();
        this.h = r4.readString();
        this.f = (LoginInfo) r4.readParcelable(LoginInfo.class.getClassLoader());
        if (r4.readByte() == 0) goto L13;
        r0 = true;
    L13:
        this.i = r0;
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        r2.writeString(this.a);
        r2.writeParcelable(this.b, r3);
        r2.writeByte(this.c ? 1 : 0);
        r2.writeByte(this.d ? 1 : 0);
        r2.writeString(this.e);
        r2.writeString(this.g);
        r2.writeString(this.h);
        r2.writeParcelable(this.f, r3);
        r2.writeByte(this.i ? 1 : 0);
    }

    public DocDynamicConfig(LoginInfo r3, String r4, TenantInfo r5, boolean r6, boolean r7, String r8, String r9, String r10, boolean r11) {
        this.d = false;
        this.e = "normal";
        this.i = false;
        this.f = r3;
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }
}
