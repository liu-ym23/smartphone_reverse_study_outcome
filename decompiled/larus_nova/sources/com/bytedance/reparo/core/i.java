package com.bytedance.reparo.core;

import android.app.Application;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f267371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f267372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PolarisFileWrapper f267373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PolarisFileWrapper f267374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PolarisFileWrapper f267375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PolarisFileWrapper f267376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f267377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f267378h;

    public final File a() {
        if (this.f267373c != null) goto L6;
        this.f267373c = new PolarisFileWrapper(b(), "local-record.info");
    L6:
        return this.f267373c;
    }

    public final File b() {
        if (this.f267372b != null) goto L6;
        this.f267372b = new PolarisFileWrapper(this.f267371a.getFilesDir(), "reparo-root");
    L6:
        return this.f267372b;
    }

    public i(Application r100) {
        this.f267377g = true;
        this.f267378h = false;
        this.f267371a = r100;
    }
}
