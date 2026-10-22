package com.bytedance.ee.bear.contract.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.vfs.VFSFile;
import z75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveCache implements Parcelable {
    public static final Parcelable.Creator<DriveCache> CREATOR = null;
    public String a;
    public DriveFilePath b;
    public DriveFilePath c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public String j;
    public String k;
    public long l;
    public String m;
    public int n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public boolean s;
    public int t;

    public class a implements Parcelable.Creator<DriveCache> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DriveCache createFromParcel(Parcel r2) {
            return new DriveCache(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DriveCache[] newArray(int r1) {
            return new DriveCache[r1];
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
        return "DriveCache{key='" + this.a + "', file=" + this.b + ", tempFile=" + this.c + ", previewExt='" + this.d + "', dataVersion='" + this.e + "', sourceFrom='" + this.f + "', cacheSourceFrom='" + this.g + "', sourceExt='" + this.h + "', type=" + this.i + ", fileName='" + this.j + "', objToken='" + this.k + "', modificationTime=" + this.l + ", previewExtra=" + this.m + ", cacheHost='" + this.n + "', sdkExtra=" + this.o + ", sdkAppId=" + this.p + ", mimeType=" + this.q + ", webOffice=" + this.r + ", isThumb=" + this.s + ", riskStatus=" + this.t + '}';
    }

    public DriveCache() {
        this.a = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = -1;
        this.j = "";
        this.k = "";
    }

    public int getType() {
        return this.i;
    }

    public DriveCache(Parcel r4) {
        this.a = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = -1;
        this.j = "";
        this.k = "";
        this.a = r4.readString();
        this.b = (DriveFilePath) r4.readSerializable();
        this.c = (DriveFilePath) r4.readSerializable();
        this.d = r4.readString();
        this.e = r4.readString();
        this.f = r4.readString();
        this.g = r4.readString();
        this.h = r4.readString();
        this.i = r4.readInt();
        this.j = r4.readString();
        this.k = r4.readString();
        this.l = r4.readLong();
        this.m = r4.readString();
        this.n = r4.readInt();
        this.o = r4.readString();
        this.p = r4.readString();
        boolean r1 = false;
        if (r4.readInt() != 1) goto L5;
        boolean r0 = true;
    L6:
        this.r = r0;
        if (r4.readInt() != 1) goto L9;
        r1 = true;
    L9:
        this.s = r1;
        this.t = r4.readInt();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final long a(UserSession r3) {
        VFSFile r0 = b.e(this.b, r3);
        if (r0.exists() == true) goto L5;
        VFSFile r4 = b.e(this.c, r3);
        if (r4.exists() == true) goto L9;
        return 0;
    L9:
        return r4.length();
    L5:
        return r0.length();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.a);
        r3.writeSerializable(this.b);
        r3.writeSerializable(this.c);
        r3.writeString(this.d);
        r3.writeString(this.e);
        r3.writeString(this.f);
        r3.writeString(this.g);
        r3.writeString(this.h);
        r3.writeInt(this.i);
        r3.writeString(this.j);
        r3.writeString(this.k);
        r3.writeLong(this.l);
        r3.writeString(this.m);
        r3.writeInt(this.n);
        r3.writeString(this.o);
        r3.writeString(this.p);
        r3.writeInt(this.r ? 1 : 0);
        r3.writeInt(this.s ? 1 : 0);
        r3.writeInt(this.t);
    }
}
