package com.bytedance.ee.bear.wikiv2.selector;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiSelectorBean implements Parcelable {
    public static final Parcelable.Creator<WikiSelectorBean> CREATOR = null;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public String i;
    public int j;
    public long k;
    public boolean l;
    public int m;
    public boolean n;
    public boolean o;
    public WikNodePerm p;

    public class a implements Parcelable.Creator<WikiSelectorBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WikiSelectorBean createFromParcel(Parcel r2) {
            return new WikiSelectorBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final WikiSelectorBean[] newArray(int r1) {
            return new WikiSelectorBean[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public WikiSelectorBean() {
    }

    public WikiSelectorBean(Parcel r6) {
        this.a = r6.readString();
        this.b = r6.readString();
        this.d = r6.readString();
        this.f = r6.readString();
        this.g = r6.readString();
        boolean r1 = true;
        if (r6.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.h = r0;
        this.p = r6.readSerializable();
        this.i = r6.readString();
        this.j = r6.readInt();
        this.c = r6.readString();
        this.e = r6.readString();
        this.k = r6.readLong();
        if (r6.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.l = r2;
        this.m = r6.readInt();
        if (r6.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.n = r3;
        if (r6.readByte() != 0) goto L18;
        r1 = false;
    L18:
        this.o = r1;
        return;
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeString(this.d);
        r3.writeString(this.f);
        r3.writeString(this.g);
        r3.writeByte(this.h ? 1 : 0);
        r3.writeSerializable(this.p);
        r3.writeString(this.i);
        r3.writeInt(this.j);
        r3.writeString(this.c);
        r3.writeString(this.e);
        r3.writeLong(this.k);
        r3.writeByte(this.l ? 1 : 0);
        r3.writeInt(this.m);
        r3.writeByte(this.n ? 1 : 0);
        r3.writeByte(this.o ? 1 : 0);
    }
}
