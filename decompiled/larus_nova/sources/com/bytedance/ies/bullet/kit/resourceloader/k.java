package com.bytedance.ies.bullet.kit.resourceloader;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f246833a;

    public final m a() {
        a r100 = this.f246833a;
        if ((r100 instanceof m) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        return (m) r100;
    }

    public k(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "sourceUri");
    }
}
