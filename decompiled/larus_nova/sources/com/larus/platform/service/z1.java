package com.larus.platform.service;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class z1 implements com.larus.platform.api.b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z1 f365863a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365864b = null;

    public z1() {
    }

    static {
        f365863a = new z1();
        f365864b = LazyKt.lazy(new y1());
    }

    public static com.larus.platform.api.b3 i() {
        return (com.larus.platform.api.b3) f365864b.getValue();
    }

    @Override // com.larus.platform.api.b3
    public final boolean d() {
        com.larus.platform.api.b3 r100 = i();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.d() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.b3
    public final void c(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "mainActivity");
        com.larus.platform.api.b3 r101 = i();
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.larus.platform.api.b3
    public final void b(Fragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter("chat", "previousPage");
        Intrinsics.checkNotNullParameter("lead_toast", "enterFrom");
        com.larus.platform.api.b3 r102 = i();
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.b3
    public final boolean e(Fragment r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        com.larus.platform.api.b3 r102 = i();
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.e(r100, r101);
    }

    @Override // com.larus.platform.api.b3
    public final boolean f(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "extras");
        com.larus.platform.api.b3 r102 = i();
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.f(r100, r101);
    }

    @Override // com.larus.platform.api.b3
    public final boolean a(Bundle r100, Bundle r101, int r102) {
        com.larus.platform.api.b3 r103 = i();
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.a(r100, r101, r102);
    }

    @Override // com.larus.platform.api.b3
    public final void g(View r100, int r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "view");
        com.larus.platform.api.b3 r102 = i();
        if (r102 == null) goto L6;
        r102.g(r100, r101, r110, r111, r112);
        return;
    }

    @Override // com.larus.platform.api.b3
    public final void h(Fragment r110, String r111, String r112, String r113, String r114, String r115, boolean r116, String r117) {
        com.larus.platform.api.b3 r100 = i();
        if (r100 == null) goto L6;
        r100.h(r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    }
}
