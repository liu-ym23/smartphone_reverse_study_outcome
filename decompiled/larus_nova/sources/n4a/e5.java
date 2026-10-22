package n4a;

import android.text.TextUtils;
import com.loc.av;
import com.loc.aw;
import com.ss.android.cert.manager.constants.BytedCertConstant;

/* JADX INFO: loaded from: classes32.dex */
@av(a = BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY)
public final class e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @aw(a = "a1", b = 6)
    public final String f517259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @aw(a = "a2", b = 6)
    public final String f517260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @aw(a = "a6", b = 2)
    public int f517261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @aw(a = "a4", b = 6)
    public final String f517262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @aw(a = "a5", b = 6)
    public final String f517263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f517264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f517265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f517266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f517267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String[] f517268j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f517269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f517270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f517271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f517272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String[] f517273e;

        public a(String r100, String r101, String r102) {
            this.f517273e = null;
            this.f517269a = r101;
            this.f517270b = r101;
            this.f517272d = r102;
            this.f517271c = r100;
        }

        public final e5 a() throws com.loc.l {
            if (this.f517273e == null) goto L7;
            return new e5(this);
        L7:
            throw new com.loc.l("sdk packages is null");
        }
    }

    public e5() {
        this.f517261c = 1;
        this.f517268j = null;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f517266h) == false) goto L8;
        if (TextUtils.isEmpty(this.f517259a) == true) goto L8;
        this.f517266h = f5.o(this.f517259a);
    L8:
        return this.f517266h;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.f517265g) == false) goto L8;
        if (TextUtils.isEmpty(this.f517260b) == true) goto L8;
        this.f517265g = f5.o(this.f517260b);
    L8:
        return this.f517265g;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.f517267i) == false) goto L8;
        if (TextUtils.isEmpty(this.f517263e) == true) goto L8;
        this.f517267i = f5.o(this.f517263e);
    L8:
        if (TextUtils.isEmpty(this.f517267i) == false) goto L11;
        this.f517267i = "standard";
    L11:
        return this.f517267i;
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100 != this) goto L9;
        return true;
    L9:
        if (e5.class == r100.getClass()) goto L20;
        return false;
    L20:
        if (this.f517266h.equals(((e5) r100).f517266h) == false) goto L18;
        if (this.f517264f.equals(((e5) r100).f517264f) == false) goto L18;
        if (this.f517265g.equals(((e5) r100).f517265g) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final String[] d() {
        String[] r100 = this.f517268j;
        if (r100 == null) goto L7;
        if (r100.length == 0) goto L7;
    L15:
        return (String[]) this.f517268j.clone();
    L7:
        if (TextUtils.isEmpty(this.f517262d) == true) goto L15;
        String[] r101 = f5.o(this.f517262d).split(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L11
    L13:
        this.f517268j = r101;
    L11:
        th = move-exception;
        th.printStackTrace();
        r101 = null;
        goto L13
    }

    public e5(a r100) {
        this.f517261c = 1;
        String r101 = null;
        this.f517268j = null;
        this.f517264f = r100.f517269a;
        String r102 = r100.f517270b;
        this.f517265g = r102;
        this.f517266h = r100.f517271c;
        String r103 = r100.f517272d;
        this.f517261c = 1;
        this.f517267i = "standard";
        this.f517268j = r100.f517273e;
        this.f517260b = f5.k(r102);
        this.f517259a = f5.k(this.f517266h);
        f5.k(r103);
        String[] r104 = this.f517268j;
        if (r104 != null) goto L14;
    L12:
        this.f517262d = f5.k(r101);
        this.f517263e = f5.k(this.f517267i);
        return;
    L14:
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L10
        int r106 = r104.length;     // Catch: Throwable -> L10
        int r107 = 0;
    L6:
        if (r107 >= r106) goto L8;
        r105.append(r104[r107]);     // Catch: Throwable -> L10
        r105.append(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L10
        r107 = r107 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        r101 = r105.toString();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }
}
