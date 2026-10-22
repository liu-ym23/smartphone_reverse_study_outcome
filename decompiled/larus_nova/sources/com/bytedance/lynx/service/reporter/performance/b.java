package com.bytedance.lynx.service.reporter.performance;

import android.content.Context;
import b8a.l;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements a {
    public b() {
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final void onInitialize(Context r100) {
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final Map<String, Object> a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        int r101 = e.f264926a;
        return e.c(r100.f18217d, null);
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final boolean b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        if (Intrinsics.areEqual(r100.f18215b, "js_blocking") == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual(r100.f18215b, "resource") == true) goto L11;
        return false;
    L11:
        return true;
    }
}
