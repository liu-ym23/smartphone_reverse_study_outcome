package com.bytedance.bdinstall;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f199644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f199645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f199646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f199647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f199648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f199649g;

    public class a extends i84.r<PackageInfo> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f199650c;

        public a(h r100) {
            this.f199650c = r100;
        }

        @Override // i84.r
        public final PackageInfo a(Object[] r100) {
            return this.f199650c.f199648f.getPackageManager().getPackageInfo(this.f199650c.f199648f.getPackageName(), 0);
        L4:
            th = move-exception;
            t.c("AppVersionCompat#getPackageInfo error", th);
            return null;
        }
    }

    public h(l r100) {
        this.f199649g = new a(this);
        this.f199648f = r100.f199700k;
        this.f199643a = r100.f199703n;
        if (TextUtils.isEmpty(r100.f199704o) == false) goto L5;
        String r101 = "";
    L6:
        this.f199644b = r101;
        this.f199645c = r100.f199705p;
        this.f199646d = r100.f199706q;
        this.f199647e = r100.f199707r;
        return;
    L5:
        r101 = r100.f199704o;
        goto L6
    }
}
