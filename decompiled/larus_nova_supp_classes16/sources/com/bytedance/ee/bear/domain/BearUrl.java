package com.bytedance.ee.bear.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BearUrl implements Parcelable {
    public static final Parcelable.Creator<BearUrl> CREATOR = null;
    public String a;
    public String b;
    public String c;
    public Map<String, String> d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;

    public class a implements Parcelable.Creator<BearUrl> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BearUrl createFromParcel(Parcel r2) {
            return new BearUrl(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final BearUrl[] newArray(int r1) {
            return new BearUrl[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final int a() {
        return e.g(this.a);
    }

    public final boolean b() {
        if (TextUtils.isEmpty(this.e) == false) goto L7;
        return false;
    L7:
        return "appeal".equals(UriProtector.parse(this.e).getFragment());
    }

    public String getType() {
        return this.a;
    }

    public BearUrl(Parcel r3) {
        this.d = new HashMap();
        String r0 = r3.readString();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        tt5.a.d("BearUrl", "the document type is empty");
        r0 = e.e.getType();
    L5:
        this.a = r0;
        this.b = r3.readString();
        this.c = r3.readString();
        this.e = r3.readString();
        this.f = r3.readString();
        this.h = r3.readString();
        this.i = r3.readString();
        this.j = r3.readString();
        this.g = r3.readString();
        this.k = r3.readString();
        this.l = r3.readString();
        this.m = r3.readString();
        this.n = r3.readString();
        this.o = r3.readString();
        this.q = r3.readString();
        this.r = r3.readString();
        this.d = r3.readHashMap(getClass().getClassLoader());
        this.s = r3.readString();
    }

    public BearUrl(String r2) {
        this.d = new HashMap();
        this.e = r2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.e);
        r1.writeString(this.f);
        r1.writeString(this.h);
        r1.writeString(this.i);
        r1.writeString(this.j);
        r1.writeString(this.g);
        r1.writeString(this.k);
        r1.writeString(this.l);
        r1.writeString(this.m);
        r1.writeString(this.n);
        r1.writeString(this.o);
        r1.writeString(this.q);
        r1.writeString(this.r);
        Map<String, String> r3 = this.d;
        if (r3 == null) goto L5;
        r1.writeMap(r3);
    L5:
        r1.writeString(this.s);
    }
}
