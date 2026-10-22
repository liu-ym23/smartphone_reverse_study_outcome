package com.lynx.jsbridge;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.core.JSProxy;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f381355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSProxy f381356b;

    public c(String r100, JSProxy r101) {
        this.f381355a = r100;
        this.f381356b = r101;
    }

    public final void a(String r100, JavaOnlyArray r101) {
        if (r101 != null) goto L5;
        r101 = new JavaOnlyArray();
    L5:
        this.f381356b.b(this.f381355a, r100, r101);
    }
}
