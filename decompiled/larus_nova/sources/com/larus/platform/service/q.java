package com.larus.platform.service;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.search.api.event.HybridEventParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements com.larus.platform.api.s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f365787a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365788b = null;

    public q() {
    }

    static {
        f365787a = new q();
        f365788b = LazyKt.lazy(new p());
    }

    public static com.larus.platform.api.s1 j() {
        return (com.larus.platform.api.s1) f365788b.getValue();
    }

    @Override // com.larus.platform.api.s1
    public final AbsWebFragment c() {
        com.larus.platform.api.s1 r100 = j();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    @Override // com.larus.platform.api.s1
    public final ts9.a f() {
        com.larus.platform.api.s1 r100 = j();
        if (r100 == null) goto L7;
        ts9.a r101 = r100.f();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new ts9.a(0);
    }

    @Override // com.larus.platform.api.s1
    public final String h() {
        com.larus.platform.api.s1 r100 = j();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    @Override // com.larus.platform.api.s1
    public final void b(ts9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "searchModel");
        com.larus.platform.api.s1 r101 = j();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.larus.platform.api.s1
    public final boolean g(Activity r100) {
        com.larus.platform.api.s1 r101 = j();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.g(r100);
    }

    @Override // com.larus.platform.api.s1
    public final void i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("feedback_doubao_apps", "source");
        com.larus.platform.api.s1 r101 = j();
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    @Override // com.larus.platform.api.s1
    public final void a(AppletAppActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("feedback_doubao_apps", "source");
        com.larus.platform.api.s1 r102 = j();
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.s1
    public final void d(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        com.larus.platform.api.s1 r102 = j();
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.s1
    public final Object o(String r100, Continuation<? super String> r101) {
        com.larus.platform.api.s1 r102 = j();
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.o(r100, r101);
    }

    @Override // com.larus.platform.api.s1
    public final void e(Context r100, Bundle r101, HybridEventParams r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.larus.platform.api.s1 r103 = j();
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102);
        return;
    }
}
