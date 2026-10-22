package com.lynx.tasm.base;

import com.lynx.base.log.AbsBaseLogDelegate;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends AbsBaseLogDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AbsLogDelegate f381856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f381857b;

    public static b a() {
        if (f381857b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f381857b != null) goto L9;
        f381857b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f381857b;
    }

    public b() {
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public final void d(String r100, String r101) {
        AbsLogDelegate r102 = f381856a;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.d(r100, r101);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public final void e(String r100, String r101) {
        AbsLogDelegate r102 = f381856a;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.e(r100, r101);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public final void i(String r100, String r101) {
        AbsLogDelegate r102 = f381856a;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.i(r100, r101);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public final void v(String r100, String r101) {
        AbsLogDelegate r102 = f381856a;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.v(r100, r101);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public final void w(String r100, String r101) {
        AbsLogDelegate r102 = f381856a;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.w(r100, r101);
    }
}
