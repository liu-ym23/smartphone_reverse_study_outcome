package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f461481a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f461482d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f461483e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, a> f461484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f461485c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IUiListener f461486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.tencent.connect.auth.a f461487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f461488c;

        public a() {
        }
    }

    static {
        f461482d = true;
        f461483e = 0;
    }

    public static b a() {
        if (f461481a != null) goto L6;
        f461481a = new b();
    L6:
        return f461481a;
    }

    public static int b() {
        int r100 = f461483e + 1;
        f461483e = r100;
        return r100;
    }

    public b() {
        this.f461484b = new HashMap();
        this.f461485c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    }

    public String c() {
        int r100 = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] r101 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int r102 = r101.length;
        StringBuffer r103 = new StringBuffer();
        int r104 = 0;
    L3:
        if (r104 >= r100) goto L6;
        r103.append(r101[(int) (Math.random() * ((double) r102))]);
        r104 = r104 + 1;
        goto L3
    L6:
        return r103.toString();
    }

    public String a(a r100) {
        int r101 = b();
        this.f461484b.put("" + r101, r100);     // Catch: Throwable -> L5
    L8:
        return "" + r101;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }
}
