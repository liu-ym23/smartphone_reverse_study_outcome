package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes35.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f461844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f461845b;

    /* JADX INFO: renamed from: com.tencent.open.utils.f$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static f f461846a;

        static {
            f461846a = new f(null);
        }

        public static /* synthetic */ f a() {
            return f461846a;
        }
    }

    private f() {
        this.f461844a = "";
        this.f461845b = "";
    }

    public static f a() {
        return a.a();
    }

    public String b() {
        return this.f461845b;
    }

    public /* synthetic */ f(AnonymousClass1 r100) {
        this();
    }

    public void a(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        SharedPreferences r101 = r100.getSharedPreferences("device_info_file", 0);
        String r102 = this.f461845b;
        if (r102 != null) goto L7;
    L8:
        this.f461845b = r101.getString("build_model", "");
    L9:
        String r103 = this.f461844a;
        if (r103 != null) goto L12;
    L13:
        this.f461844a = r101.getString("build_device", "");
        return;
    L12:
        if (r103.trim().isEmpty() == true) goto L13;
        return;
    L7:
        if (r102.trim().isEmpty() == false) goto L9;
        goto L8
    }

    public String b(Context r100) {
        return this.f461844a;
    }

    public String c(Context r100) {
        return this.f461845b;
    }

    public void a(Context r100, String r101) {
        if (r101 != null) goto L5;
    L15:
        this.f461845b = "";
        if (r100 == null) goto L21;
        r100.getSharedPreferences("device_info_file", 0).edit().remove("build_model").apply();
        return;
    L21:
        return;
    L5:
        if (r101.trim().isEmpty() == true) goto L15;
        String r102 = this.f461845b;
        if (r102 != null) goto L10;
    L12:
        this.f461845b = r101;
        if (r100 == null) goto L19;
        r100.getSharedPreferences("device_info_file", 0).edit().putString("build_model", this.f461845b).apply();
        return;
    L19:
        return;
    L10:
        if (r102.equals(r101) == false) goto L12;
    }
}
