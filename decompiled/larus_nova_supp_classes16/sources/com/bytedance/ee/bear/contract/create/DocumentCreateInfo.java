package com.bytedance.ee.bear.contract.create;

import android.os.Parcel;
import android.os.Parcelable;
import du5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocumentCreateInfo implements Parcelable {
    public static final Parcelable.Creator<DocumentCreateInfo> CREATOR = null;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public int g;
    public final String h;
    public boolean i;

    public class a implements Parcelable.Creator<DocumentCreateInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DocumentCreateInfo createFromParcel(Parcel r2) {
            return new DocumentCreateInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DocumentCreateInfo[] newArray(int r1) {
            return new DocumentCreateInfo[r1];
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
        return "DocumentCreateInfo{token='" + b.g(this.a) + "', objToken='" + b.g(this.b) + "', templateToken='" + b.g(this.c) + "', isWiki='" + this.i + "'}";
    }

    public DocumentCreateInfo() {
    }

    public int getType() {
        return this.f;
    }

    public DocumentCreateInfo(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
        this.c = r2.readString();
        this.d = r2.readString();
        this.e = r2.readString();
        this.f = r2.readInt();
        this.h = r2.readString();
        if (r2.readInt() == 0) goto L5;
        boolean r3 = true;
    L6:
        this.i = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
        r1.writeString(this.e);
        r1.writeInt(this.f);
        r1.writeString(this.h);
        r1.writeInt(this.i ? 1 : 0);
    }

    public DocumentCreateInfo(String r1, String r2, String r3, String r4, String r5, int r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.g = r6;
        this.f = r7;
    }
}
