package com.larus.platform.service;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class u implements com.larus.platform.api.d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f365809a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365810b = null;

    public u() {
    }

    static {
        f365809a = new u();
        f365810b = LazyKt.lazy(new t());
    }

    @Override // com.larus.platform.api.d0
    public final void d() {
        com.larus.platform.api.d0 r100 = (com.larus.platform.api.d0) f365810b.getValue();
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.larus.platform.api.d0
    public final void c(Fragment r100, View r101, String r102, by7.e r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "currentPage");
        com.larus.platform.api.d0 r104 = (com.larus.platform.api.d0) f365810b.getValue();
        if (r104 != null) goto L12;
        if (r101 == null) goto L14;
        r101.setVisibility(8);
        return;
    L14:
        return;
    L12:
        r104.c(r100, r101, r102, r103);     // Catch: AbstractMethodError -> L9
        return;
    L9:
        if (r101 == null) goto L15;
        r101.setVisibility(8);
        return;
    }

    @Override // com.larus.platform.api.d0
    public final void b(Context r110, String r111, by7.e r112, String r113, String r114, String r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        com.larus.platform.api.d0 r100 = (com.larus.platform.api.d0) f365810b.getValue();
        if (r100 == null) goto L6;
        r100.b(r110, r111, r112, r113, r114, r115, r116);
        return;
    }
}
