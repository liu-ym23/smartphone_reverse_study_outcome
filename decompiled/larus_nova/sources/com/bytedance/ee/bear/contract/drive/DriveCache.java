package com.bytedance.ee.bear.contract.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.vfs.VFSFile;
import z75.b;

/* JADX INFO: loaded from: classes16.dex */
public class DriveCache implements Parcelable {
    public static final Parcelable.Creator<DriveCache> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f216967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DriveFilePath f216968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DriveFilePath f216969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f216970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f216971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f216972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f216973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f216974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f216975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f216976j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f216977k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f216978l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f216979m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f216980n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f216981o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f216982p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f216983q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f216984r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f216985s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f216986t;

    public class a implements Parcelable.Creator<DriveCache> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DriveCache createFromParcel(Parcel r100) {
            return new DriveCache(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final DriveCache[] newArray(int r100) {
            return new DriveCache[r100];
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
        return "DriveCache{key='" + this.f216967a + "', file=" + this.f216968b + ", tempFile=" + this.f216969c + ", previewExt='" + this.f216970d + "', dataVersion='" + this.f216971e + "', sourceFrom='" + this.f216972f + "', cacheSourceFrom='" + this.f216973g + "', sourceExt='" + this.f216974h + "', type=" + this.f216975i + ", fileName='" + this.f216976j + "', objToken='" + this.f216977k + "', modificationTime=" + this.f216978l + ", previewExtra=" + this.f216979m + ", cacheHost='" + this.f216980n + "', sdkExtra=" + this.f216981o + ", sdkAppId=" + this.f216982p + ", mimeType=" + this.f216983q + ", webOffice=" + this.f216984r + ", isThumb=" + this.f216985s + ", riskStatus=" + this.f216986t + '}';
    }

    public DriveCache() {
        this.f216967a = "";
        this.f216970d = "";
        this.f216971e = "";
        this.f216972f = "";
        this.f216973g = "";
        this.f216974h = "";
        this.f216975i = -1;
        this.f216976j = "";
        this.f216977k = "";
    }

    public int getType() {
        return this.f216975i;
    }

    public DriveCache(Parcel r100) {
        this.f216967a = "";
        this.f216970d = "";
        this.f216971e = "";
        this.f216972f = "";
        this.f216973g = "";
        this.f216974h = "";
        this.f216975i = -1;
        this.f216976j = "";
        this.f216977k = "";
        this.f216967a = r100.readString();
        this.f216968b = (DriveFilePath) r100.readSerializable();
        this.f216969c = (DriveFilePath) r100.readSerializable();
        this.f216970d = r100.readString();
        this.f216971e = r100.readString();
        this.f216972f = r100.readString();
        this.f216973g = r100.readString();
        this.f216974h = r100.readString();
        this.f216975i = r100.readInt();
        this.f216976j = r100.readString();
        this.f216977k = r100.readString();
        this.f216978l = r100.readLong();
        this.f216979m = r100.readString();
        this.f216980n = r100.readInt();
        this.f216981o = r100.readString();
        this.f216982p = r100.readString();
        boolean r101 = false;
        if (r100.readInt() != 1) goto L5;
        boolean r102 = true;
    L6:
        this.f216984r = r102;
        if (r100.readInt() != 1) goto L9;
        r101 = true;
    L9:
        this.f216985s = r101;
        this.f216986t = r100.readInt();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final long a(UserSession r100) {
        VFSFile r101 = b.e(this.f216968b, r100);
        if (r101.exists() == true) goto L5;
        VFSFile r102 = b.e(this.f216969c, r100);
        if (r102.exists() == true) goto L9;
        return 0;
    L9:
        return r102.length();
    L5:
        return r101.length();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f216967a);
        r100.writeSerializable(this.f216968b);
        r100.writeSerializable(this.f216969c);
        r100.writeString(this.f216970d);
        r100.writeString(this.f216971e);
        r100.writeString(this.f216972f);
        r100.writeString(this.f216973g);
        r100.writeString(this.f216974h);
        r100.writeInt(this.f216975i);
        r100.writeString(this.f216976j);
        r100.writeString(this.f216977k);
        r100.writeLong(this.f216978l);
        r100.writeString(this.f216979m);
        r100.writeInt(this.f216980n);
        r100.writeString(this.f216981o);
        r100.writeString(this.f216982p);
        r100.writeInt(this.f216984r ? 1 : 0);
        r100.writeInt(this.f216985s ? 1 : 0);
        r100.writeInt(this.f216986t);
    }
}
