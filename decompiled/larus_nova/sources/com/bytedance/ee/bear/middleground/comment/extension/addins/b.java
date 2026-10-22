package com.bytedance.ee.bear.middleground.comment.extension.addins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class b implements gf5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cf5.a f231427a;

    public b() {
    }

    @Override // gf5.b
    public void onDestroy() {
    }

    public final cf5.a b() {
        cf5.a r100 = this.f231427a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("host");
        return null;
    L6:
        return r100;
    }

    public final gf5.a getContext() {
        cf5.a r100 = this.f231427a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("host");
        r100 = null;
    L6:
        return r100.a();
    }

    @Override // gf5.b
    public void a(cf5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f231427a = r100;
    }
}
