package com.larus.im.internal.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f350554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f350555b;

    public u() {
        this.f350554a = new Object();
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
        Object r101 = this.f350554a;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(this.f350555b, r100) == false) goto L7;
        boolean r102 = false;
    L9:
        monitor-exit(r101);
        return r102;
    L7:
        this.f350555b = r100;     // Catch: Throwable -> L11
        r102 = true;
        goto L9
    }
}
