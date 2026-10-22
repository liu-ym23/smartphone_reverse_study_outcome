package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* JADX INFO: loaded from: classes23.dex */
public class m1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static m1 f277406b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f277407a;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f277408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f277409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f277410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ m1 f277411d;

        public a(m1 r100) {
            this.f277411d = r100;
            this.f277410c = 0;
        }

        public void a(long r100) {
            m1.a(this.f277411d).f277410c = r100;
        }

        public void a(String r100) {
            m1.a(this.f277411d).f277409b = r100;
        }

        public void b(String r100) {
            m1.a(this.f277411d).f277408a = r100;
        }
    }

    static {
        f277406b = new m1();
    }

    public m1() {
        this.f277407a = new a(this);
    }

    public static /* synthetic */ a a(m1 r100) {
        return r100.f277407a;
    }

    public static m1 d() {
        return f277406b;
    }

    public String a() {
        return this.f277407a.f277409b;
    }

    public void a(String r100, String r101) {
        long r102 = b();
        String r103 = w0.c(r100, r101);
        if (r103 != null) goto L5;
    L15:
        v.e("WorkKeyHandler", "get rsa pubkey config error");
        return;
    L5:
        if (r103.isEmpty() == true) goto L15;
        if (r102 != 0) goto L12;
        r102 = System.currentTimeMillis();
    L10:
        String r104 = EncryptUtil.generateSecureRandomStr(16);
        String r105 = h0.a(r103, r104);
        this.f277407a.a(r102);
        this.f277407a.b(r104);
        this.f277407a.a(r105);
        return;
    L12:
        if ((System.currentTimeMillis() - r102) > com.heytap.mcssdk.constant.a.f276320g) goto L10;
    }

    public long b() {
        return this.f277407a.f277410c;
    }

    public String c() {
        return this.f277407a.f277408a;
    }
}
