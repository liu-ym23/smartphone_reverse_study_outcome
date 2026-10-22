package com.larus.platform.service;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.layout.item.u4;
import com.larus.platform.api.e4;
import com.larus.platform.api.f4;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c1 implements com.larus.platform.api.u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1 f365723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365724b = null;

    public c1() {
    }

    static {
        f365723a = new c1();
        f365724b = LazyKt.lazy(new b1());
    }

    public static com.larus.platform.api.u2 h() {
        return (com.larus.platform.api.u2) f365724b.getValue();
    }

    @Override // com.larus.platform.api.u2
    public final void f() {
        FLogger.f375446a.i("BackgroundLazyInit", "event=component_init_request, component=IvyKit, trigger=direct_use");
        com.larus.platform.api.u2 r100 = h();
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // com.larus.platform.api.u2
    public final List<Object> a() {
        com.larus.platform.api.u2 r100 = h();
        if (r100 == null) goto L7;
        List<Object> r101 = r100.a();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.platform.api.u2
    public final boolean d() {
        com.larus.platform.api.u2 r100 = h();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.d();
    }

    @Override // com.larus.platform.api.u2
    public final String b(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "channel");
        com.larus.platform.api.u2 r103 = h();
        if (r103 == null) goto L6;
        String r104 = r103.b(r100, r101, r102);
        if (r104 == null) goto L6;
        return r104;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.u2
    public final View c(Context r100, String r101, com.larus.bmhome.chat.layout.widget.handler.h r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "headerTransform");
        com.larus.platform.api.u2 r103 = h();
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.c(r100, r101, r102);
    }

    @Override // com.larus.platform.api.u2
    public final void e(String r100, String r101, u4 r102) {
        Intrinsics.checkNotNullParameter(r100, "bundleOrUrl");
        Intrinsics.checkNotNullParameter(r101, "channel");
        Intrinsics.checkNotNullParameter(r102, "onFinish");
        com.larus.platform.api.u2 r103 = h();
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.u2
    public final e4 g(Context r100, String r101, String r102, f4 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "templateUrl");
        com.larus.platform.api.u2 r104 = h();
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.g(r100, r101, r102, r103);
    }
}
