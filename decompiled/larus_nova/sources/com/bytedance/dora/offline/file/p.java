package com.bytedance.dora.offline.file;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f204634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f204635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f204636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f204637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f204638e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f204639f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f204640g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f204641h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f204642i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f204643j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f204644k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f204645l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f204646m;

        public a(b r100, String r101, int r102, String r103, long r104, long r105) {
            this.f204634a = r100;
            this.f204635b = r101;
            this.f204636c = r102;
            this.f204637d = r103;
            this.f204639f = Math.max(0, r104);
            this.f204638e = r105;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f204647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f204648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f204649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Integer> f204650d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, Integer> f204651e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Set<String> f204652f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f204653g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f204654h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f204655i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f204656j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f204657k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f204658l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f204659m;

        public final void b() {
            int r100 = this.f204657k;
            if (r100 == 0) goto L6;
            this.f204658l = r100;
            return;
        L6:
            this.f204658l = 0;
            Iterator r101 = ((LinkedHashMap) this.f204651e).values().iterator();
        L8:
            if (r101.hasNext() == false) goto L16;
            int r102 = ((Integer) r101.next()).intValue();
            if (r102 == 0) goto L8;
            this.f204658l = r102;
            return;
        }

        public final int a(int r100) {
            Iterator r101 = ((LinkedHashMap) this.f204650d).values().iterator();
            int r102 = 0;
        L4:
            if (r101.hasNext() == false) goto L8;
            if (((Integer) r101.next()).intValue() != r100) goto L4;
            r102 = r102 + 1;
            goto L4
        L8:
            return r102;
        }

        public b(String r100, int r101, long r102) {
            this.f204650d = new LinkedHashMap();
            this.f204651e = new LinkedHashMap();
            this.f204652f = new LinkedHashSet();
            this.f204656j = 0;
            this.f204657k = 0;
            this.f204658l = 0;
            this.f204647a = r100;
            this.f204648b = r101;
            this.f204649c = r102;
        }
    }

    public p() {
    }
}
