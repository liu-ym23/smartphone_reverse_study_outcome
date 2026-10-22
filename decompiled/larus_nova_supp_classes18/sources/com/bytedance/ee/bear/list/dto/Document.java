package com.bytedance.ee.bear.list.dto;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Document implements Parcelable {
    public static final Parcelable.Creator<Document> CREATOR = null;
    public boolean A;
    public final boolean B;
    public final String C;
    public final String D;
    public final String E;
    public String E2;
    public String F;
    public String F2;
    public long G;
    public String G1;
    public String G2;
    public String H;
    public int H0;
    public String H1;
    public boolean H2;
    public String I;
    public boolean I2;
    public String J;
    public String J2;
    public int K;
    public String K2;
    public boolean L;
    public boolean L0;
    public int L1;
    public String L2;
    public String M;
    public int M1;
    public int M2;
    public String N;
    public String O;
    public String P;
    public boolean P0;
    public boolean P1;
    public final String Q;
    public boolean Q1;
    public final String R;
    public boolean S;
    public String S1;
    public int T;
    public String T1;
    public int U;
    public String V;
    public String V0;
    public int V1;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public String a;
    public int b;
    public String b1;
    public boolean b2;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String g1;
    public int g2;
    public String h;
    public int h1;
    public int h2;
    public String i;
    public String j;
    public final String k;
    public boolean k0;
    public final DocumentIcon k1;
    public String l;
    public String m;
    public boolean n;
    public String o;
    public String p;
    public boolean p0;
    public boolean p1;
    public String p2;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public int v;
    public boolean v1;
    public int v2;
    public boolean w;
    public boolean x;
    public String x1;
    public boolean x2;
    public boolean y;
    public int y1;
    public boolean y2;
    public boolean z;

    public static class DocumentIcon implements Parcelable {
        public static final Parcelable.Creator<DocumentIcon> CREATOR = null;
        public String a;
        public int b;
        public String c;

        public class a implements Parcelable.Creator<DocumentIcon> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final DocumentIcon createFromParcel(Parcel r2) {
                return new DocumentIcon(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final DocumentIcon[] newArray(int r1) {
                return new DocumentIcon[r1];
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
            return "DocumentIcon{iconKey='" + this.a + "', iconType=" + this.b + ", iconFsunit='" + this.c + "'}";
        }

        public DocumentIcon() {
            this.b = -1;
        }

        public DocumentIcon(Parcel r2) {
            this.b = -1;
            this.a = r2.readString();
            this.b = r2.readInt();
            this.c = r2.readString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            r1.writeString(this.a);
            r1.writeInt(this.b);
            r1.writeString(this.c);
        }
    }

    public class a implements Parcelable.Creator<Document> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Document createFromParcel(Parcel r2) {
            return new Document(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final Document[] newArray(int r1) {
            return new Document[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.b), this.d, this.u});
    }

    static {
        CREATOR = new a();
    }

    public final String a() {
        String r0 = this.H1;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0;
    }

    public final boolean b() {
        int r0 = this.b;
        if (r0 == 0) goto L5;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == true) goto L19;
        if (r0 == 0) goto L13;
    L17:
        return false;
    L13:
        if (this.M1 != 0) goto L17;
        if (this.G != 141) goto L17;
        return true;
    L19:
        return true;
    L5:
        if (this.M1 != 0) goto L9;
        if (this.G != 140) goto L9;
        r3 = true;
        goto L10
    }

    public final String toString() {
        return "Document{, type=" + this.b + ", token='', objToken='', linkToken='', addTime='" + this.V + "', editTime='" + this.i + "', createTime='" + this.j + "', expireTime='" + this.k + "', openTime='" + this.l + "', spaceId='" + this.m + "', url='', path='', fakeToken='" + this.u + "', syncState=" + this.v + ", hasDataCached=" + this.w + ", documentIcon=" + this.k1 + ", isExternal=" + this.x + ", hasPermission=" + this.p1 + ", showExternalHint=" + this.v1 + ", appId=" + this.x1 + ", ownerType=" + this.L1 + ", templateType=" + this.g2 + ", objBizType=" + this.h2 + ", isInsert=" + this.y2 + ", organizationTagValue=" + this.E2 + '}';
    }

    public Document() {
        this.f = "";
        this.r = "";
        this.s = "";
        this.Q = "";
        this.R = "";
        this.Z = "0";
        this.k1 = new DocumentIcon();
    }

    public int getType() {
        return this.b;
    }

    public Document(Parcel r4) {
        this.f = "";
        this.r = "";
        this.s = "";
        this.Q = "";
        this.R = "";
        this.Z = "0";
        this.k1 = new DocumentIcon();
        this.a = r4.readString();
        this.b = r4.readInt();
        this.c = r4.readString();
        this.d = r4.readString();
        this.e = r4.readString();
        this.f = r4.readString();
        this.g = r4.readString();
        this.h = r4.readString();
        this.i = r4.readString();
        this.j = r4.readString();
        this.k = r4.readString();
        this.l = r4.readString();
        this.m = r4.readString();
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.n = r0;
        this.o = r4.readString();
        this.p = r4.readString();
        this.q = r4.readString();
        this.r = r4.readString();
        this.s = r4.readString();
        this.t = r4.readString();
        this.u = r4.readString();
        this.v = r4.readInt();
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.w = r2;
        if (r4.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.x = r3;
        if (r4.readByte() == 0) goto L17;
        boolean r5 = true;
    L18:
        this.z = r5;
        if (r4.readByte() == 0) goto L21;
        boolean r6 = true;
    L22:
        this.A = r6;
        if (r4.readByte() == 0) goto L25;
        boolean r7 = true;
    L26:
        this.B = r7;
        this.C = r4.readString();
        this.D = r4.readString();
        this.E = r4.readString();
        this.F = r4.readString();
        this.H = r4.readString();
        this.I = r4.readString();
        this.J = r4.readString();
        this.K = r4.readInt();
        if (r4.readByte() == 0) goto L29;
        boolean r8 = true;
    L30:
        this.L = r8;
        this.M = r4.readString();
        this.N = r4.readString();
        this.O = r4.readString();
        this.Q = r4.readString();
        this.R = r4.readString();
        if (r4.readByte() == 0) goto L33;
        boolean r9 = true;
    L34:
        this.S = r9;
        this.T = r4.readInt();
        this.U = r4.readInt();
        this.V = r4.readString();
        this.Z = r4.readString();
        if (r4.readByte() == 0) goto L37;
        boolean r10 = true;
    L38:
        this.k0 = r10;
        if (r4.readByte() == 0) goto L41;
        boolean r11 = true;
    L42:
        this.p0 = r11;
        this.H0 = r4.readInt();
        if (r4.readByte() == 0) goto L45;
        boolean r12 = true;
    L46:
        this.L0 = r12;
        if (r4.readByte() == 0) goto L49;
        boolean r13 = true;
    L50:
        this.P0 = r13;
        this.V0 = r4.readString();
        this.b1 = r4.readString();
        this.g1 = r4.readString();
        this.h1 = r4.readInt();
        this.k1 = (DocumentIcon) r4.readParcelable(DocumentIcon.class.getClassLoader());
        if (r4.readByte() == 0) goto L53;
        boolean r14 = true;
    L54:
        this.p1 = r14;
        if (r4.readByte() == 0) goto L57;
        boolean r15 = true;
    L58:
        this.v1 = r15;
        this.x1 = r4.readString();
        this.y1 = r4.readInt();
        this.G1 = r4.readString();
        this.M1 = r4.readInt();
        if (r4.readByte() == 0) goto L61;
        boolean r16 = true;
    L62:
        this.P1 = r16;
        if (r4.readByte() == 0) goto L65;
        boolean r17 = true;
    L66:
        this.Q1 = r17;
        this.S1 = r4.readString();
        this.H1 = r4.readString();
        this.T1 = r4.readString();
        this.V1 = r4.readInt();
        if (r4.readByte() == 0) goto L69;
        boolean r18 = true;
    L70:
        this.x2 = r18;
        if (r4.readByte() == 0) goto L73;
        boolean r19 = true;
    L74:
        this.b2 = r19;
        this.g2 = r4.readInt();
        this.h2 = r4.readInt();
        this.p2 = r4.readString();
        if (r4.readByte() == 0) goto L77;
        boolean r20 = true;
    L78:
        this.y2 = r20;
        this.E2 = r4.readString();
        this.F2 = r4.readString();
        this.G2 = r4.readString();
        this.X = r4.readString();
        this.Y = r4.readString();
        if (r4.readByte() == 0) goto L81;
        boolean r21 = true;
    L82:
        this.H2 = r21;
        if (r4.readByte() != 0) goto L86;
        r1 = false;
    L86:
        this.I2 = r1;
        this.J2 = r4.readString();
        this.K2 = r4.readString();
        this.L2 = r4.readString();
        this.G = r4.readLong();
        this.M2 = r4.readInt();
        return;
    L81:
        r21 = false;
        goto L82
    L77:
        r20 = false;
        goto L78
    L73:
        r19 = false;
        goto L74
    L69:
        r18 = false;
        goto L70
    L65:
        r17 = false;
        goto L66
    L61:
        r16 = false;
        goto L62
    L57:
        r15 = false;
        goto L58
    L53:
        r14 = false;
        goto L54
    L49:
        r13 = false;
        goto L50
    L45:
        r12 = false;
        goto L46
    L41:
        r11 = false;
        goto L42
    L37:
        r10 = false;
        goto L38
    L33:
        r9 = false;
        goto L34
    L29:
        r8 = false;
        goto L30
    L25:
        r7 = false;
        goto L26
    L21:
        r6 = false;
        goto L22
    L17:
        r5 = false;
        goto L18
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

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L26:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L26;
        Document r5 = (Document) r4;
        if (TextUtils.isEmpty(this.d) == true) goto L21;
        if (TextUtils.isEmpty(r5.d) == true) goto L21;
        if (lbb.a.a(this.d) == true) goto L21;
        if (lbb.a.a(r5.d) == true) goto L21;
        return TextUtils.equals(this.d, r5.d);
    L21:
        if (TextUtils.isEmpty(this.u) == true) goto L26;
        if (TextUtils.isEmpty(r5.u) == true) goto L26;
        return TextUtils.equals(this.u, r5.u);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.a);
        r3.writeInt(this.b);
        r3.writeString(this.c);
        r3.writeString(this.d);
        r3.writeString(this.e);
        r3.writeString(this.f);
        r3.writeString(this.g);
        r3.writeString(this.h);
        r3.writeString(this.i);
        r3.writeString(this.j);
        r3.writeString(this.k);
        r3.writeString(this.l);
        r3.writeString(this.m);
        r3.writeByte(this.n ? 1 : 0);
        r3.writeString(this.o);
        r3.writeString(this.p);
        r3.writeString(this.q);
        r3.writeString(this.r);
        r3.writeString(this.s);
        r3.writeString(this.t);
        r3.writeString(this.u);
        r3.writeInt(this.v);
        r3.writeByte(this.w ? 1 : 0);
        r3.writeByte(this.x ? 1 : 0);
        r3.writeByte(this.z ? 1 : 0);
        r3.writeByte(this.A ? 1 : 0);
        r3.writeByte(this.B ? 1 : 0);
        r3.writeString(this.C);
        r3.writeString(this.D);
        r3.writeString(this.E);
        r3.writeString(this.F);
        r3.writeString(this.H);
        r3.writeString(this.I);
        r3.writeString(this.J);
        r3.writeInt(this.K);
        r3.writeByte(this.L ? 1 : 0);
        r3.writeString(this.M);
        r3.writeString(this.N);
        r3.writeString(this.O);
        r3.writeString(this.Q);
        r3.writeString(this.R);
        r3.writeByte(this.S ? 1 : 0);
        r3.writeInt(this.T);
        r3.writeInt(this.U);
        r3.writeString(this.V);
        r3.writeString(this.Z);
        r3.writeByte(this.k0 ? 1 : 0);
        r3.writeByte(this.p0 ? 1 : 0);
        r3.writeInt(this.H0);
        r3.writeByte(this.L0 ? 1 : 0);
        r3.writeByte(this.P0 ? 1 : 0);
        r3.writeString(this.V0);
        r3.writeString(this.b1);
        r3.writeString(this.g1);
        r3.writeInt(this.h1);
        r3.writeParcelable(this.k1, r4);
        r3.writeByte(this.p1 ? 1 : 0);
        r3.writeByte(this.v1 ? 1 : 0);
        r3.writeString(this.x1);
        r3.writeInt(this.y1);
        r3.writeString(this.G1);
        r3.writeInt(this.M1);
        r3.writeByte(this.P1 ? 1 : 0);
        r3.writeByte(this.Q1 ? 1 : 0);
        r3.writeString(this.S1);
        r3.writeString(this.H1);
        r3.writeString(this.T1);
        r3.writeInt(this.V1);
        r3.writeByte(this.x2 ? 1 : 0);
        r3.writeByte(this.b2 ? 1 : 0);
        r3.writeInt(this.g2);
        r3.writeInt(this.h2);
        r3.writeString(this.p2);
        r3.writeByte(this.y2 ? 1 : 0);
        r3.writeString(this.E2);
        r3.writeString(this.F2);
        r3.writeString(this.G2);
        r3.writeString(this.X);
        r3.writeString(this.Y);
        r3.writeByte(this.H2 ? 1 : 0);
        r3.writeByte(this.I2 ? 1 : 0);
        r3.writeString(this.J2);
        r3.writeString(this.K2);
        r3.writeString(this.L2);
        r3.writeLong(this.G);
        r3.writeInt(this.M2);
    }
}
