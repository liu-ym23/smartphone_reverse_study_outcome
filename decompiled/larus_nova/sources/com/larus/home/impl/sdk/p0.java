package com.larus.home.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class p0 implements com.larus.platform.api.u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f346222a = null;

    static {
        f346222a = new p0();
    }

    public p0() {
    }

    @Override // com.larus.platform.api.u0
    public final void a(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // com.larus.platform.api.u0
    public final void attachBaseContext(Context r100) {
    }

    @Override // com.larus.platform.api.u0
    public final void b(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // com.larus.platform.api.u0
    public final kotlinx.coroutines.flow.i1<Boolean> c() {
        return null;
    }

    @Override // com.larus.platform.api.u0
    public final void d(Activity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // com.larus.platform.api.u0
    public final void onCreate() {
    }

    @Override // com.larus.platform.api.u0
    public final void onDestroy() {
    }
}
