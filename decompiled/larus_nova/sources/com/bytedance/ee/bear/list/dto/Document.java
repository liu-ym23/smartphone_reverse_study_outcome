package com.bytedance.ee.bear.list.dto;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f227867J;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f227868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f227869b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public String f227870b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public boolean f227871b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f227872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f227873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f227874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f227875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f227876g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public String f227877g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public int f227878g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f227879h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f227880h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public int f227881h2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f227882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f227883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f227884k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f227885k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final DocumentIcon f227886k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f227887l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f227888m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f227889n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f227890o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f227891p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f227892p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f227893p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public String f227894p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f227895q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f227896r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f227897s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f227898t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f227899u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f227900v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f227901v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public int f227902v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f227903w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f227904x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public String f227905x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public boolean f227906x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f227907y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public int f227908y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public boolean f227909y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f227910z;

    public static class DocumentIcon implements Parcelable {
        public static final Parcelable.Creator<DocumentIcon> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f227911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f227912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f227913c;

        public class a implements Parcelable.Creator<DocumentIcon> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final DocumentIcon createFromParcel(Parcel r100) {
                return new DocumentIcon(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final DocumentIcon[] newArray(int r100) {
                return new DocumentIcon[r100];
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
            return "DocumentIcon{iconKey='" + this.f227911a + "', iconType=" + this.f227912b + ", iconFsunit='" + this.f227913c + "'}";
        }

        public DocumentIcon() {
            this.f227912b = -1;
        }

        public DocumentIcon(Parcel r100) {
            this.f227912b = -1;
            this.f227911a = r100.readString();
            this.f227912b = r100.readInt();
            this.f227913c = r100.readString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.f227911a);
            r100.writeInt(this.f227912b);
            r100.writeString(this.f227913c);
        }
    }

    public class a implements Parcelable.Creator<Document> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Document createFromParcel(Parcel r100) {
            return new Document(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Document[] newArray(int r100) {
            return new Document[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f227869b), this.f227873d, this.f227899u});
    }

    static {
        CREATOR = new a();
    }

    public final String a() {
        String r100 = this.H1;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100;
    }

    public final boolean b() {
        int r100 = this.f227869b;
        if (r100 == 0) goto L5;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L19;
        if (r100 == 0) goto L13;
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
        r101 = true;
        goto L10
    }

    public final String toString() {
        return "Document{, type=" + this.f227869b + ", token='', objToken='', linkToken='', addTime='" + this.V + "', editTime='" + this.f227882i + "', createTime='" + this.f227883j + "', expireTime='" + this.f227884k + "', openTime='" + this.f227887l + "', spaceId='" + this.f227888m + "', url='', path='', fakeToken='" + this.f227899u + "', syncState=" + this.f227900v + ", hasDataCached=" + this.f227903w + ", documentIcon=" + this.f227886k1 + ", isExternal=" + this.f227904x + ", hasPermission=" + this.f227893p1 + ", showExternalHint=" + this.f227901v1 + ", appId=" + this.f227905x1 + ", ownerType=" + this.L1 + ", templateType=" + this.f227878g2 + ", objBizType=" + this.f227881h2 + ", isInsert=" + this.f227909y2 + ", organizationTagValue=" + this.E2 + '}';
    }

    public Document() {
        this.f227875f = "";
        this.f227896r = "";
        this.f227897s = "";
        this.Q = "";
        this.R = "";
        this.Z = "0";
        this.f227886k1 = new DocumentIcon();
    }

    public int getType() {
        return this.f227869b;
    }

    public Document(Parcel r100) {
        this.f227875f = "";
        this.f227896r = "";
        this.f227897s = "";
        this.Q = "";
        this.R = "";
        this.Z = "0";
        this.f227886k1 = new DocumentIcon();
        this.f227868a = r100.readString();
        this.f227869b = r100.readInt();
        this.f227872c = r100.readString();
        this.f227873d = r100.readString();
        this.f227874e = r100.readString();
        this.f227875f = r100.readString();
        this.f227876g = r100.readString();
        this.f227879h = r100.readString();
        this.f227882i = r100.readString();
        this.f227883j = r100.readString();
        this.f227884k = r100.readString();
        this.f227887l = r100.readString();
        this.f227888m = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f227889n = r102;
        this.f227890o = r100.readString();
        this.f227891p = r100.readString();
        this.f227895q = r100.readString();
        this.f227896r = r100.readString();
        this.f227897s = r100.readString();
        this.f227898t = r100.readString();
        this.f227899u = r100.readString();
        this.f227900v = r100.readInt();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f227903w = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.f227904x = r104;
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.f227910z = r105;
        if (r100.readByte() == 0) goto L21;
        boolean r106 = true;
    L22:
        this.A = r106;
        if (r100.readByte() == 0) goto L25;
        boolean r107 = true;
    L26:
        this.B = r107;
        this.C = r100.readString();
        this.D = r100.readString();
        this.E = r100.readString();
        this.F = r100.readString();
        this.H = r100.readString();
        this.I = r100.readString();
        this.f227867J = r100.readString();
        this.K = r100.readInt();
        if (r100.readByte() == 0) goto L29;
        boolean r108 = true;
    L30:
        this.L = r108;
        this.M = r100.readString();
        this.N = r100.readString();
        this.O = r100.readString();
        this.Q = r100.readString();
        this.R = r100.readString();
        if (r100.readByte() == 0) goto L33;
        boolean r109 = true;
    L34:
        this.S = r109;
        this.T = r100.readInt();
        this.U = r100.readInt();
        this.V = r100.readString();
        this.Z = r100.readString();
        if (r100.readByte() == 0) goto L37;
        boolean r110 = true;
    L38:
        this.f227885k0 = r110;
        if (r100.readByte() == 0) goto L41;
        boolean r111 = true;
    L42:
        this.f227892p0 = r111;
        this.H0 = r100.readInt();
        if (r100.readByte() == 0) goto L45;
        boolean r112 = true;
    L46:
        this.L0 = r112;
        if (r100.readByte() == 0) goto L49;
        boolean r113 = true;
    L50:
        this.P0 = r113;
        this.V0 = r100.readString();
        this.f227870b1 = r100.readString();
        this.f227877g1 = r100.readString();
        this.f227880h1 = r100.readInt();
        this.f227886k1 = (DocumentIcon) r100.readParcelable(DocumentIcon.class.getClassLoader());
        if (r100.readByte() == 0) goto L53;
        boolean r114 = true;
    L54:
        this.f227893p1 = r114;
        if (r100.readByte() == 0) goto L57;
        boolean r115 = true;
    L58:
        this.f227901v1 = r115;
        this.f227905x1 = r100.readString();
        this.f227908y1 = r100.readInt();
        this.G1 = r100.readString();
        this.M1 = r100.readInt();
        if (r100.readByte() == 0) goto L61;
        boolean r116 = true;
    L62:
        this.P1 = r116;
        if (r100.readByte() == 0) goto L65;
        boolean r117 = true;
    L66:
        this.Q1 = r117;
        this.S1 = r100.readString();
        this.H1 = r100.readString();
        this.T1 = r100.readString();
        this.V1 = r100.readInt();
        if (r100.readByte() == 0) goto L69;
        boolean r118 = true;
    L70:
        this.f227906x2 = r118;
        if (r100.readByte() == 0) goto L73;
        boolean r119 = true;
    L74:
        this.f227871b2 = r119;
        this.f227878g2 = r100.readInt();
        this.f227881h2 = r100.readInt();
        this.f227894p2 = r100.readString();
        if (r100.readByte() == 0) goto L77;
        boolean r120 = true;
    L78:
        this.f227909y2 = r120;
        this.E2 = r100.readString();
        this.F2 = r100.readString();
        this.G2 = r100.readString();
        this.X = r100.readString();
        this.Y = r100.readString();
        if (r100.readByte() == 0) goto L81;
        boolean r121 = true;
    L82:
        this.H2 = r121;
        if (r100.readByte() != 0) goto L86;
        r101 = false;
    L86:
        this.I2 = r101;
        this.J2 = r100.readString();
        this.K2 = r100.readString();
        this.L2 = r100.readString();
        this.G = r100.readLong();
        this.M2 = r100.readInt();
        return;
    L81:
        r121 = false;
        goto L82
    L77:
        r120 = false;
        goto L78
    L73:
        r119 = false;
        goto L74
    L69:
        r118 = false;
        goto L70
    L65:
        r117 = false;
        goto L66
    L61:
        r116 = false;
        goto L62
    L57:
        r115 = false;
        goto L58
    L53:
        r114 = false;
        goto L54
    L49:
        r113 = false;
        goto L50
    L45:
        r112 = false;
        goto L46
    L41:
        r111 = false;
        goto L42
    L37:
        r110 = false;
        goto L38
    L33:
        r109 = false;
        goto L34
    L29:
        r108 = false;
        goto L30
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L26:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L26;
        Document r101 = (Document) r100;
        if (TextUtils.isEmpty(this.f227873d) == true) goto L21;
        if (TextUtils.isEmpty(r101.f227873d) == true) goto L21;
        if (lbb.a.a(this.f227873d) == true) goto L21;
        if (lbb.a.a(r101.f227873d) == true) goto L21;
        return TextUtils.equals(this.f227873d, r101.f227873d);
    L21:
        if (TextUtils.isEmpty(this.f227899u) == true) goto L26;
        if (TextUtils.isEmpty(r101.f227899u) == true) goto L26;
        return TextUtils.equals(this.f227899u, r101.f227899u);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f227868a);
        r100.writeInt(this.f227869b);
        r100.writeString(this.f227872c);
        r100.writeString(this.f227873d);
        r100.writeString(this.f227874e);
        r100.writeString(this.f227875f);
        r100.writeString(this.f227876g);
        r100.writeString(this.f227879h);
        r100.writeString(this.f227882i);
        r100.writeString(this.f227883j);
        r100.writeString(this.f227884k);
        r100.writeString(this.f227887l);
        r100.writeString(this.f227888m);
        r100.writeByte(this.f227889n ? 1 : 0);
        r100.writeString(this.f227890o);
        r100.writeString(this.f227891p);
        r100.writeString(this.f227895q);
        r100.writeString(this.f227896r);
        r100.writeString(this.f227897s);
        r100.writeString(this.f227898t);
        r100.writeString(this.f227899u);
        r100.writeInt(this.f227900v);
        r100.writeByte(this.f227903w ? 1 : 0);
        r100.writeByte(this.f227904x ? 1 : 0);
        r100.writeByte(this.f227910z ? 1 : 0);
        r100.writeByte(this.A ? 1 : 0);
        r100.writeByte(this.B ? 1 : 0);
        r100.writeString(this.C);
        r100.writeString(this.D);
        r100.writeString(this.E);
        r100.writeString(this.F);
        r100.writeString(this.H);
        r100.writeString(this.I);
        r100.writeString(this.f227867J);
        r100.writeInt(this.K);
        r100.writeByte(this.L ? 1 : 0);
        r100.writeString(this.M);
        r100.writeString(this.N);
        r100.writeString(this.O);
        r100.writeString(this.Q);
        r100.writeString(this.R);
        r100.writeByte(this.S ? 1 : 0);
        r100.writeInt(this.T);
        r100.writeInt(this.U);
        r100.writeString(this.V);
        r100.writeString(this.Z);
        r100.writeByte(this.f227885k0 ? 1 : 0);
        r100.writeByte(this.f227892p0 ? 1 : 0);
        r100.writeInt(this.H0);
        r100.writeByte(this.L0 ? 1 : 0);
        r100.writeByte(this.P0 ? 1 : 0);
        r100.writeString(this.V0);
        r100.writeString(this.f227870b1);
        r100.writeString(this.f227877g1);
        r100.writeInt(this.f227880h1);
        r100.writeParcelable(this.f227886k1, r101);
        r100.writeByte(this.f227893p1 ? 1 : 0);
        r100.writeByte(this.f227901v1 ? 1 : 0);
        r100.writeString(this.f227905x1);
        r100.writeInt(this.f227908y1);
        r100.writeString(this.G1);
        r100.writeInt(this.M1);
        r100.writeByte(this.P1 ? 1 : 0);
        r100.writeByte(this.Q1 ? 1 : 0);
        r100.writeString(this.S1);
        r100.writeString(this.H1);
        r100.writeString(this.T1);
        r100.writeInt(this.V1);
        r100.writeByte(this.f227906x2 ? 1 : 0);
        r100.writeByte(this.f227871b2 ? 1 : 0);
        r100.writeInt(this.f227878g2);
        r100.writeInt(this.f227881h2);
        r100.writeString(this.f227894p2);
        r100.writeByte(this.f227909y2 ? 1 : 0);
        r100.writeString(this.E2);
        r100.writeString(this.F2);
        r100.writeString(this.G2);
        r100.writeString(this.X);
        r100.writeString(this.Y);
        r100.writeByte(this.H2 ? 1 : 0);
        r100.writeByte(this.I2 ? 1 : 0);
        r100.writeString(this.J2);
        r100.writeString(this.K2);
        r100.writeString(this.L2);
        r100.writeLong(this.G);
        r100.writeInt(this.M2);
    }
}
