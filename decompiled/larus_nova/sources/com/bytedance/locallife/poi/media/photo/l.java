package com.bytedance.locallife.poi.media.photo;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f262775n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f262776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f262777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f262778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f262779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f262780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f262781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f262782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f262783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f262784i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f262785j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f262786k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f262787l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m f262788m;

    public interface a {
        boolean a();

        void b(float r100, float r101, long r102);
    }

    public static final class b {
    }

    static {
    }

    public final void a() {
        this.f262784i = 0;
        this.f262781f = 0.0f;
        this.f262782g = 0.0f;
        this.f262776a.removeCallbacks(this.f262788m);
    }

    public final void c() {
        long r100 = this.f262778c;
        float r101 = 100.0f;
        if (r100 <= 0) goto L5;
        r101 = 100.0f * (this.f262779d / r100);
    L5:
        this.f262780e = r101;
    }

    public l() {
        Intrinsics.checkNotNullParameter("slides_photos", "name");
        this.f262776a = new Handler(Looper.getMainLooper());
        this.f262778c = 3000;
        this.f262779d = 50;
        this.f262780e = (50 / 3000) * 100.0f;
        this.f262788m = new m(this);
    }

    public final void b(boolean r100, long r101, boolean r102) {
        a r103 = this.f262777b;
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L10;
        return;
    L10:
        if (r102 == false) goto L13;
        this.f262785j = false;
        this.f262786k = false;
        a();
    L13:
        if (this.f262785j == false) goto L16;
        if (r102 == true) goto L16;
        return;
    L16:
        this.f262787l = r100;
        this.f262778c = r101;
        c();
        this.f262781f = 0.0f;
        this.f262782g = 0.0f;
        this.f262784i = System.currentTimeMillis();
        this.f262785j = true;
        this.f262786k = false;
        this.f262776a.removeCallbacks(this.f262788m);
        this.f262776a.post(this.f262788m);
        return;
    L5:
        if (r103.a() == true) goto L7;
        r104 = true;
        goto L8
    }
}
