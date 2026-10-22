package com.lynx.tasm.service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxMemoryInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f383736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f383737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f383738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f383739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f383740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f383741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f383742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f383743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f383744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f383745j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f383746k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f383747l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f383748m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f383749n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f383750o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f383751p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f383752q;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LynxMemoryType {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f383753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f383754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f383755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f383756d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f383757e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f383758f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f383759g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f383760h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f383761i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f383762j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f383763k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f383764l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f383765m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f383766n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f383767o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f383768p;

        public a() {
            this.f383753a = 0;
            this.f383754b = 0;
            this.f383755c = 0;
            this.f383756d = 0;
            this.f383757e = "";
            this.f383758f = "";
            this.f383759g = "";
            this.f383760h = 0.0f;
            this.f383761i = -1;
            this.f383762j = -1;
            this.f383763k = -1;
            this.f383764l = -1;
            this.f383765m = "";
            this.f383766n = "";
            this.f383767o = 1;
            this.f383768p = 0;
        }
    }

    public String getType() {
        return this.f383743h;
    }

    public LynxMemoryInfo(a r100) {
        this.f383736a = 0;
        this.f383737b = 0;
        this.f383738c = 0;
        this.f383739d = 0;
        this.f383740e = "";
        this.f383741f = "";
        this.f383742g = "";
        this.f383743h = "";
        this.f383744i = 0.0f;
        this.f383745j = 0;
        this.f383746k = 0;
        this.f383747l = 0;
        this.f383748m = 0;
        this.f383749n = "";
        this.f383750o = "";
        this.f383751p = 0;
        this.f383752q = 0;
        this.f383736a = r100.f383753a;
        this.f383737b = r100.f383754b;
        this.f383738c = r100.f383755c;
        this.f383739d = r100.f383756d;
        this.f383740e = "";
        String r101 = r100.f383757e;
        if (r101 == null) goto L5;
        this.f383741f = r101;
    L5:
        String r102 = r100.f383758f;
        if (r102 == null) goto L8;
        this.f383742g = r102;
    L8:
        String r103 = r100.f383759g;
        if (r103 == null) goto L11;
        this.f383743h = r103;
    L11:
        this.f383744i = r100.f383760h;
        this.f383746k = r100.f383762j;
        this.f383745j = r100.f383761i;
        this.f383747l = r100.f383763k;
        this.f383748m = r100.f383764l;
        String r104 = r100.f383765m;
        if (r104 == null) goto L14;
        this.f383749n = r104;
    L14:
        String r105 = r100.f383766n;
        if (r105 == null) goto L17;
        this.f383750o = r105;
    L17:
        this.f383751p = r100.f383767o;
        this.f383752q = r100.f383768p;
    }
}
