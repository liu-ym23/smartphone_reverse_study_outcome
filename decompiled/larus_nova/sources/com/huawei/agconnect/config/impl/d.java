package com.huawei.agconnect.config.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes23.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f276717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f276718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f276719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f276720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f276721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f276722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f276723g;

    public d(String r100, String r101, String r102, String r103, String r104, int r105) {
        this.f276723g = 0;
        this.f276717a = r100;
        this.f276718b = r101;
        this.f276719c = r102;
        this.f276720d = r103;
        this.f276721e = r104;
        this.f276722f = r105;
        if (r100 == null) goto L6;
        this.f276723g = r100.length() / 2;
        return;
    }

    public boolean a() {
        if (TextUtils.isEmpty(this.f276717a) == false) goto L5;
    L26:
        return false;
    L5:
        if (TextUtils.isEmpty(this.f276718b) == true) goto L26;
        if (TextUtils.isEmpty(this.f276719c) == true) goto L26;
        if (TextUtils.isEmpty(this.f276720d) == true) goto L26;
        if (this.f276717a.length() != this.f276718b.length()) goto L26;
        if (this.f276718b.length() != this.f276719c.length()) goto L26;
        if (this.f276719c.length() != (this.f276723g * 2)) goto L26;
        if (this.f276722f >= 0) goto L22;
        return false;
    L22:
        if (TextUtils.isEmpty(this.f276721e) == false) goto L24;
        return false;
    L24:
        return true;
    }

    public String b() {
        return this.f276717a;
    }

    public String c() {
        return this.f276718b;
    }

    public String d() {
        return this.f276719c;
    }

    public String e() {
        return this.f276720d;
    }

    public String f() {
        return this.f276721e;
    }

    public int g() {
        return this.f276722f;
    }

    public int h() {
        return this.f276723g;
    }
}
