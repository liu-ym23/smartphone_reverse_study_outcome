package com.suite.lark.platform.component.storage.clean;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Class<? extends f>, m<? extends f>> f460605a;

    public h() {
        this.f460605a = new HashMap();
    }

    public final void a(m r100) {
        Intrinsics.checkNotNullParameter(r100, "eraser");
        this.f460605a.put(r100.a(), r100);
    }
}
