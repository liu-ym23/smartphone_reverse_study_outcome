package com.bytedance.ee.bear.route;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RouteBean implements Parcelable {
    public static final Parcelable.Creator<RouteBean> CREATOR = null;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public Bundle e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public Map<String, String> k;
    public String l;
    public String m;
    public Bundle n;
    public boolean o;
    public Fragment p;
    public DestStyle q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;

    public static final enum DestStyle extends Enum<DestStyle> {
        public static final DestStyle FLOAT = null;
        public static final DestStyle FULL_SCREEN = null;
        public static final DestStyle NORMAL = null;
        public static final /* synthetic */ DestStyle[] a = null;

        static {
            DestStyle r0 = new DestStyle("NORMAL", 0);
            NORMAL = r0;
            DestStyle r1 = new DestStyle("FLOAT", 1);
            FLOAT = r1;
            DestStyle r3 = new DestStyle("FULL_SCREEN", 2);
            FULL_SCREEN = r3;
            a = new DestStyle[]{r0, r1, r3};
        }

        public static DestStyle[] values() {
            return (DestStyle[]) a.clone();
        }

        public static DestStyle valueOf(String r1) {
            return (DestStyle) r27.a.a(DestStyle.class, r1);
        }

        public DestStyle(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a implements Parcelable.Creator<RouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RouteBean createFromParcel(Parcel r2) {
            return new RouteBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final RouteBean[] newArray(int r1) {
            return new RouteBean[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RouteBean() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.k = null;
        this.o = !ExpandDocHelperForKA.a();
        this.q = DestStyle.NORMAL;
        this.r = false;
        this.s = true;
        this.t = false;
        this.u = false;
    }

    public String getType() {
        return this.m;
    }

    public RouteBean(Parcel r4) {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.k = null;
        boolean r1 = true;
        this.o = !ExpandDocHelperForKA.a();
        this.q = DestStyle.NORMAL;
        this.r = false;
        this.s = true;
        this.t = false;
        this.u = false;
        this.a = r4.readInt();
        this.b = r4.readInt();
        this.c = r4.readInt();
        if (r4.readByte() == 0) goto L5;
        boolean r2 = true;
    L6:
        this.d = r2;
        this.e = r4.readBundle();
        this.f = r4.readString();
        this.g = r4.readString();
        this.h = r4.readString();
        this.i = r4.readString();
        this.l = r4.readString();
        this.m = r4.readString();
        this.n = r4.readBundle();
        if (r4.readByte() != 0) goto L10;
        r1 = false;
    L10:
        this.o = r1;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void a(Fragment r3) {
        tt5.a.h("RouteBean", "setSourceFragment() called with: sourceFragment = [" + r3 + "]");
        this.p = r3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.a);
        r1.writeInt(this.b);
        r1.writeInt(this.c);
        r1.writeByte(this.d ? 1 : 0);
        r1.writeBundle(this.e);
        r1.writeString(this.f);
        r1.writeString(this.g);
        r1.writeString(this.h);
        r1.writeString(this.i);
        r1.writeString(this.l);
        r1.writeString(this.m);
        r1.writeBundle(this.n);
        r1.writeByte(this.o ? 1 : 0);
    }
}
