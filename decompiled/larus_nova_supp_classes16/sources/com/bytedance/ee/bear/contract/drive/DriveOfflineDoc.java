package com.bytedance.ee.bear.contract.drive;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveOfflineDoc implements Parcelable {
    public static final Parcelable.Creator<DriveOfflineDoc> CREATOR = null;
    public final String a;
    public final String b;
    public final int c;
    public final String d;
    public final long e;
    public final String f;
    public final long g;
    public String h;

    public class a implements Parcelable.Creator<DriveOfflineDoc> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DriveOfflineDoc createFromParcel(Parcel r2) {
            return new DriveOfflineDoc(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DriveOfflineDoc[] newArray(int r1) {
            return new DriveOfflineDoc[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b});
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "DriveOfflineDoc{objToken='" + this.a + "', subType='" + this.b + "', permission=" + this.c + ", url='" + this.d + "', fileSize=" + this.e + ", dataVersion='" + this.f + "', mountPoint='" + this.h + "'}";
    }

    public DriveOfflineDoc() {
        this.a = "";
        this.b = "";
        this.d = "";
        this.f = "";
        this.h = "";
    }

    public DriveOfflineDoc(Parcel r3) {
        this.a = "";
        this.b = "";
        this.d = "";
        this.f = "";
        this.h = "";
        this.a = r3.readString();
        this.b = r3.readString();
        this.c = r3.readInt();
        this.d = r3.readString();
        this.e = r3.readLong();
        this.f = r3.readString();
        this.g = r3.readLong();
        this.h = r3.readString();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        DriveOfflineDoc r6 = (DriveOfflineDoc) r5;
        if (Objects.equals(this.a, r6.a) == true) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.b, r6.b) == false) goto L15;
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeInt(this.c);
        r3.writeString(this.d);
        r3.writeLong(this.e);
        r3.writeString(this.f);
        r3.writeLong(this.g);
        r3.writeString(this.h);
    }

    public DriveOfflineDoc(String r2, String r3, String r4) {
        this.a = "";
        this.b = "";
        this.d = "";
        this.f = "";
        this.h = "";
        this.a = r2;
        this.d = r3;
        this.b = r4;
    }
}
