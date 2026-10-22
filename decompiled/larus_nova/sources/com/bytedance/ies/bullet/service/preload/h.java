package com.bytedance.ies.bullet.service.preload;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Typeface f248106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f248107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f248108c;

    @Override // a36.d
    public final void release() {
        this.f248106a = null;
    }

    @Override // a36.d
    public final long size() {
        return this.f248107b;
    }

    @Override // com.bytedance.ies.bullet.service.preload.a
    public final boolean a(long r100) {
        Long r101 = this.f248108c;
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L7:
        if (r100 <= r102) goto L9;
        return true;
    L9:
        return false;
    L5:
        r102 = r100;
        goto L7
    }

    public h(Typeface r100, long r101) {
        this.f248106a = r100;
        this.f248107b = r101;
        this.f248108c = null;
    }
}
