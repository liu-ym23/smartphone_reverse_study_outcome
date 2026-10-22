package com.bytedance.iesgurd.meta;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f250770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f250771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f250772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f250773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f250774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f250775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f250776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f250777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f250778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f250779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, a> f250780k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f250781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f250782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f250783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f250784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f250785e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f250786f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f250787g;

        public a(String r100) {
            this.f250787g = r100;
            this.f250786f = System.currentTimeMillis();
        }

        public final void setResult(boolean r100) {
            this.f250781a = r100;
        }
    }

    public c() {
        this.f250780k = new HashMap();
    }

    public final a a(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = "patch_";
    L5:
        a r102 = (a) ((HashMap) this.f250780k).get(r101);
        if (r102 != null) goto L9;
        a r103 = new a(r101);
        ((HashMap) this.f250780k).put(r101, r103);
        return r103;
    L9:
        return r102;
    L4:
        r101 = "full_";
        goto L5
    }
}
