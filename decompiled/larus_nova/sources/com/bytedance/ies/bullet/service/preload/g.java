package com.bytedance.ies.bullet.service.preload;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CloseableReference<Bitmap> f248103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f248104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f248105c;

    public g() {
        throw null;
    }

    @Override // a36.d
    public final void release() {
        CloseableReference<Bitmap> r100 = this.f248103a;
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    @Override // a36.d
    public final long size() {
        return this.f248104b;
    }

    @Override // com.bytedance.ies.bullet.service.preload.a
    public final boolean a(long r100) {
        Long r101 = this.f248105c;
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

    public g(CloseableReference r100, long r101) {
        this.f248103a = r100;
        this.f248104b = r101;
        this.f248105c = null;
    }
}
