package com.bytedance.ies.bullet.pool.impl;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f247492a;

    public e(int r100) {
        this.f247492a = new d(r100);
    }

    public final com.bytedance.ies.bullet.service.base.e a(Object r100, boolean r101) {
        Uri r102 = (Uri) r100;
        Intrinsics.checkNotNullParameter(r102, "uniqueSchema");
        if (r101 == false) goto L6;
        return this.f247492a.remove(r102);
    L6:
        return this.f247492a.get(r102);
    }
}
