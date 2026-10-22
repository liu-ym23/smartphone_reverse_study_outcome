package com.bytedance.ee.bear.contract.drive;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class DriveOfflineDoc implements Parcelable {
    public static final Parcelable.Creator<DriveOfflineDoc> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f216996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f216997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f216998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f216999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f217000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f217001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f217002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f217003h;

    public class a implements Parcelable.Creator<DriveOfflineDoc> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DriveOfflineDoc createFromParcel(Parcel r100) {
            return new DriveOfflineDoc(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DriveOfflineDoc[] newArray(int r100) {
            return new DriveOfflineDoc[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f216996a, this.f216997b});
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "DriveOfflineDoc{objToken='" + this.f216996a + "', subType='" + this.f216997b + "', permission=" + this.f216998c + ", url='" + this.f216999d + "', fileSize=" + this.f217000e + ", dataVersion='" + this.f217001f + "', mountPoint='" + this.f217003h + "'}";
    }

    public DriveOfflineDoc() {
        this.f216996a = "";
        this.f216997b = "";
        this.f216999d = "";
        this.f217001f = "";
        this.f217003h = "";
    }

    public DriveOfflineDoc(Parcel r100) {
        this.f216996a = "";
        this.f216997b = "";
        this.f216999d = "";
        this.f217001f = "";
        this.f217003h = "";
        this.f216996a = r100.readString();
        this.f216997b = r100.readString();
        this.f216998c = r100.readInt();
        this.f216999d = r100.readString();
        this.f217000e = r100.readLong();
        this.f217001f = r100.readString();
        this.f217002g = r100.readLong();
        this.f217003h = r100.readString();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        DriveOfflineDoc r101 = (DriveOfflineDoc) r100;
        if (Objects.equals(this.f216996a, r101.f216996a) == true) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.f216997b, r101.f216997b) == false) goto L15;
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f216996a);
        r100.writeString(this.f216997b);
        r100.writeInt(this.f216998c);
        r100.writeString(this.f216999d);
        r100.writeLong(this.f217000e);
        r100.writeString(this.f217001f);
        r100.writeLong(this.f217002g);
        r100.writeString(this.f217003h);
    }

    public DriveOfflineDoc(String r100, String r101, String r102) {
        this.f216996a = "";
        this.f216997b = "";
        this.f216999d = "";
        this.f217001f = "";
        this.f217003h = "";
        this.f216996a = r100;
        this.f216999d = r101;
        this.f216997b = r102;
    }
}
