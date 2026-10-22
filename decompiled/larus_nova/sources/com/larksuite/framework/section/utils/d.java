package com.larksuite.framework.section.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larksuite.framework.section.c f285713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f285714b;

    public d(com.larksuite.framework.section.c r100) {
        Intrinsics.checkNotNullParameter(r100, "dispatcher");
        this.f285713a = r100;
        this.f285714b = 0;
    }

    public static void a(d r100, com.ss.android.lark.todo.impl.features.detail.viewmodel.a r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "action");
        if ((System.currentTimeMillis() - r100.f285714b) <= 1000) goto L6;
        r100.f285714b = System.currentTimeMillis();
        r100.f285713a.a(r101);
        return;
    }
}
