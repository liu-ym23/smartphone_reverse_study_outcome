package com.loc;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.net.Proxy;
import java.util.Map;
import n4a.n;

/* JADX INFO: loaded from: classes32.dex */
public abstract class bo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f379924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Proxy f379925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f379926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f379927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f379928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f379929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f379930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f379931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f379932i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f379933j;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f379934a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f379935b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f379936c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f379937d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f379938e = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ a[] f379939g = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f379940f;

        static {
            a r100 = new a(EffectConstants.NORMAL, 0, 0);
            f379934a = r100;
            a r101 = new a("INTERRUPT_IO", 1, 1);
            f379935b = r101;
            a r102 = new a("NEVER", 2, 2);
            f379936c = r102;
            a r103 = new a("FIX", 3, 3);
            f379937d = r103;
            a r104 = new a("SINGLE", 4, 4);
            f379938e = r104;
            f379939g = new a[]{r100, r101, r102, r103, r104};
        }

        public a(String r100, int r101, int r102) {
            super(r100, r101);
            this.f379940f = r102;
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        public static a[] values() {
            return (a[]) f379939g.clone();
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f379941a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f379942b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f379943c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f379944d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f379945e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f379946f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f379947g = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ b[] f379948i = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f379949h;

        static {
            b r100 = new b("FIRST_NONDEGRADE", 0, 0);
            f379941a = r100;
            b r101 = new b("NEVER_GRADE", 1, 1);
            f379942b = r101;
            b r102 = new b("DEGRADE_BYERROR", 2, 2);
            f379943c = r102;
            b r103 = new b("DEGRADE_ONLY", 3, 3);
            f379944d = r103;
            b r104 = new b("FIX_NONDEGRADE", 4, 4);
            f379945e = r104;
            b r105 = new b("FIX_DEGRADE_BYERROR", 5, 5);
            f379946f = r105;
            b r110 = new b("FIX_DEGRADE_ONLY", 6, 6);
            f379947g = r110;
            f379948i = new b[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public b(String r100, int r101, int r102) {
            super(r100, r101);
            this.f379949h = r102;
        }

        public static b valueOf(String r100) {
            return (b) r27.a.a(b.class, r100);
        }

        public static b[] values() {
            return (b[]) f379948i.clone();
        }

        public final int a() {
            return this.f379949h;
        }

        public final boolean b() {
            int r100 = this.f379949h;
            if (r100 != f379941a.f379949h) goto L5;
            return true;
        L5:
            if (r100 != f379942b.f379949h) goto L7;
            return true;
        L7:
            if (r100 == f379945e.f379949h) goto L14;
            return false;
        L14:
            return true;
        }

        public final boolean c() {
            int r100 = this.f379949h;
            if (r100 != f379943c.f379949h) goto L5;
            return true;
        L5:
            if (r100 != f379944d.f379949h) goto L7;
            return true;
        L7:
            if (r100 != f379946f.f379949h) goto L9;
            return true;
        L9:
            if (r100 == f379947g.f379949h) goto L17;
            return false;
        L17:
            return true;
        }

        public final boolean d() {
            int r100 = this.f379949h;
            if (r100 != f379943c.f379949h) goto L5;
            return true;
        L5:
            if (r100 == f379946f.f379949h) goto L11;
            return false;
        L11:
            return true;
        }

        public final boolean e() {
            if (this.f379949h != f379942b.f379949h) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f379950a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f379951b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ c[] f379952d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f379953c;

        static {
            c r100 = new c("HTTP", 0, 0);
            f379950a = r100;
            c r101 = new c("HTTPS", 1, 1);
            f379951b = r101;
            f379952d = new c[]{r100, r101};
        }

        public c(String r100, int r101, int r102) {
            super(r100, r101);
            this.f379953c = r102;
        }

        public static c valueOf(String r100) {
            return (c) r27.a.a(c.class, r100);
        }

        public static c[] values() {
            return (c[]) f379952d.clone();
        }
    }

    public bo() {
        this.f379924a = 20000;
        this.f379925b = null;
        this.f379926c = false;
        this.f379927d = 20000;
        this.f379928e = true;
        this.f379932i = a.f379934a;
        this.f379933j = b.f379941a;
    }

    public static String f(String r100) {
        String r101 = "";
    L29:
        th = move-exception;
        n.a(th, "ht", "pnfp");
    L31:
        return r101;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L31;
        String[] r102 = r100.split("&");     // Catch: Throwable -> L29
        if (r102.length <= 1) goto L31;
        int r103 = r102.length;     // Catch: Throwable -> L29
        int r104 = 0;
        String r105 = "";
    L8:
        if (r104 >= r103) goto L16;
        String r106 = r102[r104];     // Catch: Throwable -> L29
        if (r106.contains("sdkversion") == false) goto L13;
        r105 = r106;
    L13:
        if (r106.contains("product") == true) goto L18;
        r104 = r104 + 1;     // Catch: Throwable -> L29
    L18:
        if (TextUtils.isEmpty(r106) == true) goto L31;
        String[] r107 = r106.split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L29
        if (r107.length <= 1) goto L31;
        r101 = r107[1].trim();     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r105) == true) goto L31;
        if (TextUtils.isEmpty(n4a.c.a(r101)) == false) goto L31;
        String[] r108 = r105.split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L29
        if (r108.length <= 1) goto L31;
        n4a.c.b(r101, r108[1].trim());     // Catch: Throwable -> L29
        goto L31
    L16:
        r106 = "";
        goto L18
    }

    public abstract Map<String, String> a();

    public final void b(c r100) {
        if (r100 != c.f379951b) goto L5;
        boolean r101 = true;
    L6:
        this.f379931h = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public abstract String c();

    public final String d(String r100) {
        byte[] r101 = i();
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (r101.length == 0) goto L13;
        Map<String, String> r102 = h();
        if (r102 != null) goto L10;
        return r100;
    L10:
        String r103 = d.b(r102);
        StringBuffer r104 = new StringBuffer();
        r104.append(r100);
        r104.append("?");
        r104.append(r103);
        return r104.toString();
    L13:
        return r100;
    }

    public String e() {
        return c();
    }

    public boolean g() {
        return this.f379928e;
    }

    public abstract Map<String, String> h();

    public abstract byte[] i();

    public String j() {
        return "";
    }

    public String k() {
        return "";
    }
}
