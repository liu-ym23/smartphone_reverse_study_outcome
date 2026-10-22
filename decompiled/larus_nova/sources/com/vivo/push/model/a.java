package com.vivo.push.model;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f462417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f462418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f462419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f462420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f462421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f462422f;

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f462417a + ", mPushVersion=" + this.f462418b + ", mPackageVersion=" + this.f462419c + ", mInBlackList=" + this.f462421e + ", mPushEnable=" + this.f462422f + i.f25855d;
    }

    public final String a() {
        return this.f462417a;
    }

    public final long b() {
        return this.f462418b;
    }

    public final boolean c() {
        return this.f462421e;
    }

    public final boolean d() {
        return this.f462422f;
    }

    public a(String r100) {
        this.f462418b = -1;
        this.f462419c = -1;
        this.f462421e = false;
        this.f462422f = false;
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.f462417a = r100;
        return;
    L7:
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final void a(int r100) {
        this.f462419c = r100;
    }

    public final void a(long r100) {
        this.f462418b = r100;
    }

    public final void a(String r100) {
        this.f462420d = r100;
    }

    public final void a(boolean r100) {
        this.f462422f = r100;
    }
}
