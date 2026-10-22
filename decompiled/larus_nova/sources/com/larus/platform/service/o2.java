package com.larus.platform.service;

import com.larus.im.bean.message.Message;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class o2 implements com.larus.platform.api.i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o2 f365782a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365783b = null;

    public o2() {
    }

    static {
        f365782a = new o2();
        f365783b = LazyKt.lazy(new n2());
    }

    public static com.larus.platform.api.i3 h() {
        return (com.larus.platform.api.i3) f365783b.getValue();
    }

    @Override // com.larus.platform.api.i3
    public final Integer a() {
        com.larus.platform.api.i3 r100 = h();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.i3
    public final Integer c() {
        com.larus.platform.api.i3 r100 = h();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    @Override // com.larus.platform.api.i3
    public final Integer d() {
        com.larus.platform.api.i3 r100 = h();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.d();
    }

    @Override // com.larus.platform.api.i3
    public final String e() {
        com.larus.platform.api.i3 r100 = h();
        if (r100 == null) goto L6;
        String r101 = r100.e();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "default";
    }

    @Override // com.larus.platform.api.i3
    public final Integer g() {
        com.larus.platform.api.i3 r100 = h();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.g();
    }

    @Override // com.larus.platform.api.i3
    public final int b(int r100) {
        com.larus.platform.api.i3 r101 = h();     // Catch: AbstractMethodError -> L6
        if (r101 == null) goto L9;
        return r101.b(r100);
    L9:
        return r100;
    L10:
        return r100;
    }

    @Override // com.larus.platform.api.i3
    public final String f(Message r100) {
        com.larus.platform.api.i3 r101 = h();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f(r100);
    }
}
