package com.bytedance.ee.bear.middleground.comment.extension.addins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class b implements gf5.b {
    public cf5.a a;

    public b() {
    }

    @Override // gf5.b
    public void onDestroy() {
    }

    public final cf5.a b() {
        cf5.a r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("host");
        return null;
    L6:
        return r0;
    }

    public final gf5.a getContext() {
        cf5.a r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("host");
        r0 = null;
    L6:
        return r0.a();
    }

    @Override // gf5.b
    public void a(cf5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.a = r2;
    }
}
