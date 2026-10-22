package com.ss.android.downloadlib.am.m2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes34.dex */
public class AidlMsg implements Parcelable {
    public static final Parcelable.Creator<AidlMsg> CREATOR = null;
    public int action;
    public int code;
    public String data;
    public int hostVersionCode;
    public String sourceApk;
    public String sourceApkInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "";
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int hashCode() {
        int r100 = ((this.action * 31) + this.code) * 31;
        String r101 = this.data;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public AidlMsg() {
        this.data = "";
        this.sourceApk = "";
        this.sourceApkInfo = "";
    }

    public AidlMsg(Parcel r100) {
        this.data = "";
        this.sourceApk = "";
        this.sourceApkInfo = "";
        this.action = r100.readInt();
        this.code = r100.readInt();
        this.data = r100.readString();
        this.sourceApk = r100.readString();
        this.sourceApkInfo = r100.readString();
        this.hostVersionCode = r100.readInt();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L22:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L22;
        AidlMsg r101 = (AidlMsg) r100;
        if (this.action != r101.action) goto L22;
        if (this.code != r101.code) goto L22;
        String r102 = this.data;
        if (r102 == null) goto L20;
        return r102.equals(r101.data);
    L20:
        if (r101.data != null) goto L22;
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.action);
        r100.writeInt(this.code);
        r100.writeString(this.data);
        r100.writeString(this.sourceApk);
        r100.writeString(this.sourceApkInfo);
        r100.writeInt(this.hostVersionCode);
    }
}
