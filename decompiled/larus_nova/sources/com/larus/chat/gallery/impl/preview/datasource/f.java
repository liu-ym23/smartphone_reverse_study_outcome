package com.larus.chat.gallery.impl.preview.datasource;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.coroutines.i<g> f324259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.chat.gallery.api.i f324260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f324261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f324262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveData<Integer> f324263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LiveData<Integer> f324264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f324265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f324266h;

    public final void a(g r100) {
        if (this.f324262d == false) goto L5;
        return;
    L5:
        if (this.f324259a.isActive() == false) goto L9;
        this.f324262d = true;
        new Handler(Looper.getMainLooper()).post(new e(this));
        this.f324259a.resumeWith(Result.m9449constructorimpl(r100));
        return;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.chat.gallery.impl.preview.datasource.a] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.chat.gallery.impl.preview.datasource.b] */
    public f(kotlinx.coroutines.j r100, com.larus.chat.gallery.api.i r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "cont");
        Intrinsics.checkNotNullParameter(r101, "dataBridge");
        this.f324259a = r100;
        this.f324260b = r101;
        this.f324261c = r102;
        this.f324263e = r101.d();
        this.f324264f = r101.c();
        this.f324265g = new a(this);
        this.f324266h = new b(this);
    }
}
