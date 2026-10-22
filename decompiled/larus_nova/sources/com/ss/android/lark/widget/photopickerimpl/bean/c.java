package com.ss.android.lark.widget.photopickerimpl.bean;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Object> f447756a;

    public c() {
        this.f447756a = new HashMap();
    }

    public final <T> T a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (T) this.f447756a.get(r100);
    }

    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 != null) goto L5;
        return;
    L5:
        this.f447756a.put(r100, r101);
    }
}
