package com.larus.platform.service;

import com.larus.platform.model.TriggerLoginScene;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i3 implements com.larus.platform.api.s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i3 f365750a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365751b = null;

    public i3() {
    }

    static {
        f365750a = new i3();
        f365751b = LazyKt.lazy(new h3());
    }

    public static com.larus.platform.api.s3 k() {
        return (com.larus.platform.api.s3) f365751b.getValue();
    }

    @Override // com.larus.platform.api.s3
    public final boolean a() {
        com.larus.platform.api.s3 r100 = k();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.s3
    public final void b() {
        com.larus.platform.api.s3 r100 = k();
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.larus.platform.api.s3
    public final boolean c() {
        com.larus.platform.api.s3 r100 = k();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.c();
    }

    @Override // com.larus.platform.api.s3
    public final void e() {
        com.larus.platform.api.s3 r100 = k();
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    @Override // com.larus.platform.api.s3
    public final boolean f() {
        com.larus.platform.api.s3 r100 = k();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f();
    }

    @Override // com.larus.platform.api.s3
    public final boolean h() {
        com.larus.platform.api.s3 r100 = k();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.h();
    }

    @Override // com.larus.platform.api.s3
    public final boolean i() {
        com.larus.platform.api.s3 r100 = k();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.i();
    }

    @Override // com.larus.platform.api.s3
    public final void g(TriggerLoginScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        com.larus.platform.api.s3 r101 = k();
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }

    @Override // com.larus.platform.api.s3
    public final void d(TriggerLoginScene r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        com.larus.platform.api.s3 r102 = k();
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    public static void j(TriggerLoginScene r100, Function0 r101, Function0 r102, int r103) {
        i3 r104 = f365750a;
        if ((r103 & 1) == 0) goto L6;
        r100 = TriggerLoginScene.TRIGGER_LOGIN_CLICK_OTHERS;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (r104.i() == false) goto L16;
        if (r101 == null) goto L15;
        r101.invoke();
    L15:
        r104.g(r100);
        return;
    L16:
        if (r102 == null) goto L20;
        r102.invoke();
        return;
    }
}
