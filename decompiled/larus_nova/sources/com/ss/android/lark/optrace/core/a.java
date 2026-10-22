package com.ss.android.lark.optrace.core;

import com.ss.android.lark.optrace.api.TracingCoreSpan;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TracingCoreSpan f437604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f437605b;

    public a(b r100, TracingCoreSpan r101) {
        this.f437604a = r101;
        this.f437605b = r100.f437606a.get();
        r100.f437606a.set(this);
    }
}
