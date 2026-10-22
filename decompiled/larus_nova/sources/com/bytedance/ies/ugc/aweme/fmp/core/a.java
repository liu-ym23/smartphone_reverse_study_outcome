package com.bytedance.ies.ugc.aweme.fmp.core;

import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f248897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f248898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f248899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f248900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f248901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f248902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f248903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f248904h;

    public a(int r100, int r101, byte[] r102, byte[] r103) {
        long r104 = SystemClock.elapsedRealtime();
        long r105 = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullParameter(r102, "xArray");
        Intrinsics.checkNotNullParameter(r103, "yArray");
        this.f248897a = r100;
        this.f248898b = r101;
        this.f248899c = r102;
        this.f248900d = r103;
        this.f248901e = r104;
        this.f248902f = r105;
        this.f248903g = false;
        this.f248904h = false;
    }
}
