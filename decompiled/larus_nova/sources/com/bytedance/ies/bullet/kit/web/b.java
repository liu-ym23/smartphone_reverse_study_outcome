package com.bytedance.ies.bullet.kit.web;

import android.view.View;
import com.bytedance.ies.bullet.core.BulletContext;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements tz2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<BulletContext> f246953a;

    @Override // tz2.a
    public final void b(View r100, long r101) {
    }

    public b(WeakReference<BulletContext> r100) {
        Intrinsics.checkNotNullParameter(r100, "contextRef");
        this.f246953a = r100;
    }

    @Override // tz2.a
    public final void a(View r100, int r101) {
        BulletContext r102 = this.f246953a.get();
        if (r102 == null) goto L6;
        r102.f246435c.g(r102, Integer.valueOf(2 - r101), null);
        return;
    }
}
