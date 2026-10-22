package com.cmic.sso.sdk.a;

/* JADX INFO: loaded from: classes22.dex */
public class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f273272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f273273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f273274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f273275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f273276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f273277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f273278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f273279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f273280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f273281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f273282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f273283l;

    /* JADX INFO: renamed from: com.cmic.sso.sdk.a.a$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.cmic.sso.sdk.a.a$a, reason: collision with other inner class name */
    public static class C3819a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f273284a;

        public C3819a() {
            this.f273284a = new a(null);
        }

        public a a() {
            return this.f273284a;
        }

        public C3819a a(int r100) {
            a.a(this.f273284a, r100);
            return this;
        }

        public C3819a b(int r100) {
            a.b(this.f273284a, r100);
            return this;
        }

        public C3819a c(String r100) {
            a.c(this.f273284a, r100);
            return this;
        }

        public C3819a d(String r100) {
            a.d(this.f273284a, r100);
            return this;
        }

        public C3819a e(boolean r100) {
            a.e(this.f273284a, r100);
            return this;
        }

        public C3819a f(boolean r100) {
            a.f(this.f273284a, r100);
            return this;
        }

        public C3819a a(String r100) {
            a.a(this.f273284a, r100);
            return this;
        }

        public C3819a b(String r100) {
            a.b(this.f273284a, r100);
            return this;
        }

        public C3819a c(boolean r100) {
            a.c(this.f273284a, r100);
            return this;
        }

        public C3819a d(boolean r100) {
            a.d(this.f273284a, r100);
            return this;
        }

        public C3819a a(boolean r100) {
            a.a(this.f273284a, r100);
            return this;
        }

        public C3819a b(boolean r100) {
            a.b(this.f273284a, r100);
            return this;
        }
    }

    public String toString() {
        return "UmcConfigBean{mHttpsGetTokenHost='" + this.f273272a + "', mHttpsGetPhoneScripHost='" + this.f273273b + "', mConfigHost='" + this.f273274c + "', mLogHost='" + this.f273275d + "', mCloseCtccWork=" + this.f273276e + ", mCloseCuccWort=" + this.f273277f + ", mCloseM008Business=" + this.f273278g + ", mCloseGetPhoneIpv4=" + this.f273279h + ", mCloseGetPhoneIpv6=" + this.f273280i + ", mCloseLog=" + this.f273281j + ", mMaxFailedLogTimes=" + this.f273282k + ", mLogSuspendTime=" + this.f273283l + '}';
    }

    private a() {
        this.f273272a = "rcs.cmpassport.com";
        this.f273273b = "rcs.cmpassport.com";
        this.f273274c = "config2.cmpassport.com";
        this.f273275d = "log2.cmpassport.com:9443";
        this.f273276e = false;
        this.f273277f = false;
        this.f273278g = false;
        this.f273279h = false;
        this.f273280i = false;
        this.f273281j = false;
        this.f273282k = 3;
        this.f273283l = 1;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m();
    }

    public a m() throws CloneNotSupportedException {
        return (a) super.clone();
    }

    public String a() {
        return this.f273272a;
    }

    public String b() {
        return this.f273273b;
    }

    public String c() {
        return this.f273274c;
    }

    public String d() {
        return this.f273275d;
    }

    public boolean e() {
        return this.f273276e;
    }

    public boolean f() {
        return this.f273277f;
    }

    public boolean g() {
        return this.f273278g;
    }

    public boolean h() {
        return this.f273279h;
    }

    public boolean i() {
        return this.f273280i;
    }

    public boolean j() {
        return this.f273281j;
    }

    public int k() {
        return this.f273282k;
    }

    public int l() {
        return this.f273283l;
    }

    public /* synthetic */ a(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ int a(a r100, int r101) {
        r100.f273282k = r101;
        return r101;
    }

    public static /* synthetic */ int b(a r100, int r101) {
        r100.f273283l = r101;
        return r101;
    }

    public static /* synthetic */ String c(a r100, String r101) {
        r100.f273274c = r101;
        return r101;
    }

    public static /* synthetic */ String d(a r100, String r101) {
        r100.f273275d = r101;
        return r101;
    }

    public static /* synthetic */ boolean e(a r100, boolean r101) {
        r100.f273280i = r101;
        return r101;
    }

    public static /* synthetic */ boolean f(a r100, boolean r101) {
        r100.f273281j = r101;
        return r101;
    }

    public static /* synthetic */ String a(a r100, String r101) {
        r100.f273272a = r101;
        return r101;
    }

    public static /* synthetic */ String b(a r100, String r101) {
        r100.f273273b = r101;
        return r101;
    }

    public static /* synthetic */ boolean c(a r100, boolean r101) {
        r100.f273278g = r101;
        return r101;
    }

    public static /* synthetic */ boolean d(a r100, boolean r101) {
        r100.f273279h = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(a r100, boolean r101) {
        r100.f273276e = r101;
        return r101;
    }

    public static /* synthetic */ boolean b(a r100, boolean r101) {
        r100.f273277f = r101;
        return r101;
    }
}
