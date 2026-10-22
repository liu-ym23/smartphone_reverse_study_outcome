package com.oplus.ocs.base.common;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes34.dex */
public class AuthResult implements Parcelable {
    public static final Parcelable.Creator<AuthResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f404139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f404140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f404141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f404142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f404143e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int getErrrorCode() {
        return this.f404142d;
    }

    public String getPackageName() {
        return this.f404139a;
    }

    public byte[] getPermitBits() {
        return this.f404143e;
    }

    public int getPid() {
        return this.f404141c;
    }

    public int getUid() {
        return this.f404140b;
    }

    public AuthResult(Parcel r100) {
        this.f404139a = r100.readString();
        this.f404140b = r100.readInt();
        this.f404141c = r100.readInt();
        this.f404142d = r100.readInt();
        this.f404143e = r100.createByteArray();
    }

    public void setErrrorCode(int r100) {
        this.f404142d = r100;
    }

    public void setPackageName(String r100) {
        this.f404139a = r100;
    }

    public void setPermitBits(byte[] r100) {
        this.f404143e = r100;
    }

    public void setPid(int r100) {
        this.f404141c = r100;
    }

    public void setUid(int r100) {
        this.f404140b = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f404139a);
        r100.writeInt(this.f404140b);
        r100.writeInt(this.f404141c);
        r100.writeInt(this.f404142d);
        r100.writeByteArray(this.f404143e);
    }

    public AuthResult(String r100, int r101, int r102, int r103, byte[] r104) {
        this.f404139a = r100;
        this.f404140b = r101;
        this.f404141c = r102;
        this.f404142d = r103;
        this.f404143e = r104;
    }
}
