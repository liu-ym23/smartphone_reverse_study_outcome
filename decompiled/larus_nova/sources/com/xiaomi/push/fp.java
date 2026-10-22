package com.xiaomi.push;

import android.os.Bundle;

/* JADX INFO: loaded from: classes41.dex */
public class fp extends fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f463577a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f586a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private b f587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f463578b;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f463579a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private static final /* synthetic */ a[] f588a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f463580b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f463581c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f463582d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f463583e = null;

        static {
            a r100 = new a("chat", 0);
            f463579a = r100;
            a r101 = new a("available", 1);
            f463580b = r101;
            a r102 = new a("away", 2);
            f463581c = r102;
            a r103 = new a("xa", 3);
            f463582d = r103;
            a r104 = new a("dnd", 4);
            f463583e = r104;
            f588a = new a[]{r100, r101, r102, r103, r104};
        }

        public static a[] values() {
            return (a[]) f588a.clone();
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        private a(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f463584a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private static final /* synthetic */ b[] f589a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f463585b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f463586c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f463587d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f463588e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f463589f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f463590g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f463591h = null;

        static {
            b r100 = new b("available", 0);
            f463584a = r100;
            b r101 = new b("unavailable", 1);
            f463585b = r101;
            b r102 = new b("subscribe", 2);
            f463586c = r102;
            b r103 = new b("subscribed", 3);
            f463587d = r103;
            b r104 = new b("unsubscribe", 4);
            f463588e = r104;
            b r105 = new b("unsubscribed", 5);
            f463589f = r105;
            b r110 = new b("error", 6);
            f463590g = r110;
            b r111 = new b("probe", 7);
            f463591h = r111;
            f589a = new b[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static b[] values() {
            return (b[]) f589a.clone();
        }

        public static b valueOf(String r100) {
            return (b) r27.a.a(b.class, r100);
        }

        private b(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.xiaomi.push.fn
    /* JADX INFO: renamed from: a */
    public String mo9099a() {
        StringBuilder r100 = new StringBuilder("<presence");
        if (p() == null) goto L6;
        r100.append(" xmlns=\"");
        r100.append(p());
        r100.append("\"");
    L6:
        if (j() == null) goto L9;
        r100.append(" id=\"");
        r100.append(j());
        r100.append("\"");
    L9:
        if (l() == null) goto L12;
        r100.append(" to=\"");
        r100.append(fw.a(l()));
        r100.append("\"");
    L12:
        if (m() == null) goto L15;
        r100.append(" from=\"");
        r100.append(fw.a(m()));
        r100.append("\"");
    L15:
        if (k() == null) goto L18;
        r100.append(" chid=\"");
        r100.append(fw.a(k()));
        r100.append("\"");
    L18:
        if (this.f587a == null) goto L20;
        r100.append(" type=\"");
        r100.append(this.f587a);
        r100.append("\"");
    L20:
        r100.append(">");
        if (this.f463578b == null) goto L24;
        r100.append("<status>");
        r100.append(fw.a(this.f463578b));
        r100.append("</status>");
    L24:
        if (this.f463577a == Integer.MIN_VALUE) goto L26;
        r100.append("<priority>");
        r100.append(this.f463577a);
        r100.append("</priority>");
    L26:
        a r101 = this.f586a;
        if (r101 != null) goto L29;
    L31:
        r100.append(o());
        fr r102 = m9100a();
        if (r102 == null) goto L34;
        r100.append(r102.m9103a());
    L34:
        r100.append("</presence>");
        return r100.toString();
    L29:
        if (r101 == a.f463580b) goto L31;
        r100.append("<show>");
        r100.append(this.f586a);
        r100.append("</show>");
        goto L31
    }

    @Override // com.xiaomi.push.fn
    public Bundle a() {
        Bundle r100 = super.a();
        b r101 = this.f587a;
        if (r101 == null) goto L5;
        r100.putString("ext_pres_type", r101.toString());
    L5:
        String r102 = this.f463578b;
        if (r102 == null) goto L8;
        r100.putString("ext_pres_status", r102);
    L8:
        int r103 = this.f463577a;
        if (r103 == Integer.MIN_VALUE) goto L11;
        r100.putInt("ext_pres_prio", r103);
    L11:
        a r104 = this.f586a;
        if (r104 != null) goto L14;
    L16:
        return r100;
    L14:
        if (r104 == a.f463580b) goto L16;
        r100.putString("ext_pres_mode", r104.toString());
        goto L16
    }

    public fp(Bundle r100) {
        super(r100);
        this.f587a = b.f463584a;
        this.f463578b = null;
        this.f463577a = Integer.MIN_VALUE;
        this.f586a = null;
        if (r100.containsKey("ext_pres_type") == false) goto L6;
        this.f587a = b.valueOf(r100.getString("ext_pres_type"));
    L6:
        if (r100.containsKey("ext_pres_status") == false) goto L9;
        this.f463578b = r100.getString("ext_pres_status");
    L9:
        if (r100.containsKey("ext_pres_prio") == false) goto L12;
        this.f463577a = r100.getInt("ext_pres_prio");
    L12:
        if (r100.containsKey("ext_pres_mode") == false) goto L15;
        this.f586a = a.valueOf(r100.getString("ext_pres_mode"));
        return;
    }

    public void a(int r100) {
        if (r100 < (-128)) goto L9;
        if (r100 > 128) goto L9;
        this.f463577a = r100;
        return;
    L9:
        throw new IllegalArgumentException("Priority value " + r100 + " is not valid. Valid range is -128 through 128.");
    }

    public fp(b r100) {
        this.f587a = b.f463584a;
        this.f463578b = null;
        this.f463577a = Integer.MIN_VALUE;
        this.f586a = null;
        a(r100);
    }

    public void a(b r100) {
        if (r100 == null) goto L6;
        this.f587a = r100;
        return;
    L6:
        throw new NullPointerException("Type cannot be null");
    }

    public void a(a r100) {
        this.f586a = r100;
    }

    public void a(String r100) {
        this.f463578b = r100;
    }
}
