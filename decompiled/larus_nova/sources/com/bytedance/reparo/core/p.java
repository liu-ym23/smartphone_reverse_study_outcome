package com.bytedance.reparo.core;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes21.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f267416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f267417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f267418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f267419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f267420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f267421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f267422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f267423h;

    public final c97.h b() {
        c97.h r100 = new c97.h();
        r100.f22887g = this.f267417b;
        r100.f22889i = this.f267418c;
        r100.f22890j = this.f267419d;
        r100.f22888h = this.f267420e;
        r100.f22891k = this.f267421f;
        r100.f22892l = this.f267422g;
        r100.f22893m = this.f267423h;
        return r100;
    }

    public final String toString() {
        return "{patchId = " + this.f267419d + ", issueId = " + this.f267420e + ", md5 = " + this.f267417b + ", hostAppVersion = " + this.f267421f + ", isAsyncLoad = " + this.f267422g + ", isSupportSubProcess = " + this.f267423h + com.alipay.sdk.m.u.i.f25855d;
    }

    public p() {
        this.f267417b = "";
        this.f267418c = "";
        this.f267419d = "";
        this.f267420e = "";
        this.f267421f = "";
        this.f267422g = true;
    }

    public final boolean a(c97.h r100) {
        if (TextUtils.equals(this.f267417b, r100.f22887g) == true) goto L5;
    L17:
        return false;
    L5:
        if (TextUtils.equals(this.f267421f, r100.f22891k) == false) goto L17;
        if (TextUtils.equals(this.f267419d, r100.f22890j) == false) goto L17;
        if (TextUtils.equals(this.f267420e, r100.f22888h) == false) goto L17;
        if (TextUtils.equals(this.f267418c, r100.f22889i) == false) goto L17;
        if (this.f267422g != r100.f22892l) goto L17;
        if (this.f267423h != r100.f22893m) goto L17;
        return true;
    }
}
