package com.larus.platform.service;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class r1 implements com.larus.platform.api.u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f365797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365798b = null;

    public r1() {
    }

    static {
        f365797a = new r1();
        f365798b = LazyKt.lazy(new q1());
    }

    public static com.larus.platform.api.u0 e() {
        return (com.larus.platform.api.u0) f365798b.getValue();
    }

    @Override // com.larus.platform.api.u0
    public final kotlinx.coroutines.flow.i1<Boolean> c() {
        com.larus.platform.api.u0 r100 = e();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    @Override // com.larus.platform.api.u0
    public final void onCreate() {
        com.larus.platform.api.u0 r100 = e();
        if (r100 == null) goto L6;
        r100.onCreate();
        return;
    }

    @Override // com.larus.platform.api.u0
    public final void onDestroy() {
        com.larus.platform.api.u0 r100 = e();
        if (r100 == null) goto L6;
        r100.onDestroy();
        return;
    }

    @Override // com.larus.platform.api.u0
    public final void attachBaseContext(Context r100) {
        com.larus.platform.api.u0 r101 = e();
        if (r101 == null) goto L6;
        r101.attachBaseContext(r100);
        return;
    }

    @Override // com.larus.platform.api.u0
    public final void a(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        com.larus.platform.api.u0 r102 = e();
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.u0
    public final void b(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
        com.larus.platform.api.u0 r102 = e();
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.u0
    public final void d(Activity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        com.larus.platform.api.u0 r102 = e();
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }
}
