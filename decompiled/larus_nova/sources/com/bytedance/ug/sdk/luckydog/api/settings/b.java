package com.bytedance.ug.sdk.luckydog.api.settings;

import il7.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f271596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f271597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile C3804b f271598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f271599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile JSONObject f271600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f271601f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f271602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f271603b;

        public a(int r100, int r101) {
            boolean r102 = true;
            if (r100 == 1) goto L6;
            r102 = false;
        L6:
            this.f271602a = r102;
            this.f271603b = r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ug.sdk.luckydog.api.settings.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes22.dex */
    public static final class C3804b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f271604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f271605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f271606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f271607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f271608e;

        public C3804b(int r100, int r101, int r102, int r103, int r104) {
            boolean r105 = true;
            if (r100 == 1) goto L6;
            r105 = false;
        L6:
            this.f271604a = r105;
            this.f271605b = r101;
            this.f271606c = r102;
            this.f271607d = r103;
            this.f271608e = r104;
        }
    }

    public static boolean a() {
        return m.a().f("enable_intercept_network_request", Boolean.FALSE);
    }
}
