package com.bytedance.relax.ttmlstatic;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.rts.gen.CommonCallbackNG;
import com.lynx.rts.gen.FiberEventListenerOption;
import com.lynx.rts.gen.RendererFunctionNG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import s87.i;
import s87.j;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f267236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f267237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f267238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<c> f267239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<Function1<Object, Unit>> f267240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<Object, Unit> f267241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f267242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f267243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f267244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f267245j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f267246k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f267247l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<Long, Long> f267248m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f267249n;

    public final void g() {
        if (this.f267249n == false) goto L5;
        return;
    L5:
        this.f267249n = true;
        j r100 = null;
        this.f267248m = null;
        if (this.f267245j == false) goto L21;
        this.f267245j = false;
        this.f267244i++;
        if (this.f267242g == 0) goto L15;
        j r101 = this.f267236a;
        if (r101 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L13:
        long r102 = this.f267242g;
        r101.getClass();
        int r103 = s87.e.f540981a;
        i r104 = r101.f540987a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        r104.a().d(r102);
    L15:
        if (this.f267243h == 0) goto L20;
        j r105 = this.f267236a;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r105 = null;
    L19:
        r105.a(this.f267243h);
    L20:
        this.f267242g = 0;
        this.f267243h = 0;
        this.f267241f = null;
        this.f267246k = null;
    L21:
        IntCompanionObject r106 = IntCompanionObject.INSTANCE;
        int r107 = com.bytedance.rts.kmp.foundation.i.a(this.f267239d);
        Intrinsics.checkNotNullParameter(r106, "<this>");
        int r108 = r107 - 1;
    L22:
        if (r108 < 0) goto L24;
        k(r108);
        r108 = r108 - 1;
        goto L22
    L24:
        this.f267239d = com.bytedance.rts.kmp.foundation.i.b(new c[0]);
        this.f267240e = new ArrayList();
        j r109 = this.f267236a;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
    L28:
        long r110 = this.f267237b;
        r100.getClass();
        int r111 = s87.e.f540981a;
        i r112 = r100.f540987a;
        Intrinsics.checkNotNullParameter(r112, "renderer");
        r112.a().p(r110);
        return;
    L27:
        r100 = r109;
        goto L28
    }

    public h(j r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f267239d = com.bytedance.rts.kmp.foundation.i.b(new c[0]);
        this.f267240e = new ArrayList();
        this.f267236a = r100;
        Intrinsics.checkNotNullParameter("page", "tag");
        int r101 = s87.e.f540981a;
        i r102 = r100.f540987a;
        Intrinsics.checkNotNullParameter(r102, "renderer");
        Intrinsics.checkNotNullParameter("page", "tag");
        long r103 = r102.a().j();
        this.f267237b = r103;
        i r104 = r100.f540987a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        this.f267238c = r104.a().q(r103);
    }

    public final long d(long r100) {
        j r101 = this.f267236a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L5:
        r101.getClass();
        int r102 = s87.e.f540981a;
        i r103 = r101.f540987a;
        Intrinsics.checkNotNullParameter(r103, "renderer");
        return r103.a().l(r100);
    }

    public final long e(long r100) {
        j r101 = this.f267236a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L5:
        r101.getClass();
        int r102 = s87.e.f540981a;
        i r103 = r101.f540987a;
        Intrinsics.checkNotNullParameter(r103, "renderer");
        return r103.a().m(r100);
    }

    public final long f(long r100) {
        j r101 = this.f267236a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L5:
        Map<String, Object> r102 = d.f267227a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "options");
        int r103 = s87.e.f540981a;
        i r104 = r101.f540987a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        return r104.a().n(r100, new HashMap());
    }

    public final void h(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        if (this.f267249n == false) goto L6;
        return;
    L6:
        if (this.f267245j == false) goto L9;
        this.f267246k = r100;
        return;
    L9:
        j r101 = this.f267236a;
        if (r101 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L12:
        long r102 = this.f267237b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "options");
        int r103 = s87.e.f540981a;
        i r104 = r101.f540987a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        Intrinsics.checkNotNullParameter(r100, "options");
        r104.a().o(r102, r100);
    }

    public final void i(long r100) {
        Map<Long, Long> r101 = this.f267248m;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        com.bytedance.rts.kmp.foundation.j.a(r101, Long.valueOf(r100));
    L5:
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        int r103 = com.bytedance.rts.kmp.foundation.i.a(this.f267239d);
        Intrinsics.checkNotNullParameter(r102, "<this>");
    L6:
        r103 = r103 - 1;
        if (r103 < 0) goto L13;
        c r104 = (c) ListProtector.get(this.f267239d, r103);
        if (r104.f267226e == false) goto L6;
        if (r104.f267222a != r100) goto L6;
        k(r103);
        goto L6
    L13:
        j r105 = this.f267236a;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r105 = null;
    L16:
        r105.getClass();
        int r106 = s87.e.f540981a;
        i r107 = r105.f540987a;
        Intrinsics.checkNotNullParameter(r107, "renderer");
        r107.a().p(r100);
    }

    public final void k(int r210) {
        c r100 = (c) ListProtector.get(this.f267239d, r210);
        if (r100.f267226e == true) goto L5;
        int r101 = 0;
    L24:
        com.bytedance.rts.kmp.foundation.i.i(this.f267239d, r210, new c[r101]);
        com.bytedance.rts.kmp.foundation.i.i(this.f267240e, r210, new Function1[r101]);
        return;
    L5:
        r100.f267226e = false;
        j r102 = this.f267236a;
        s87.d r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r102 = null;
    L8:
        long r110 = r100.f267222a;
        String r111 = r100.f267223b;
        Function1<Object, Unit> r104 = r100.f267224c;
        if (r104 == null) goto L11;
        Function1<Object, Unit> r112 = r104;
    L12:
        s87.d r105 = r100.f267225d;
        if (r105 == null) goto L15;
        r103 = r105;
    L16:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r103, "options");
        int r106 = s87.e.f540981a;
        i r107 = r102.f540987a;
        Intrinsics.checkNotNullParameter(r107, "renderer");
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r103, "options");
        s87.h.b(r112);
        s87.a r108 = s87.a.f540972a;
        long r109 = r107.f540985a;
        monitor-enter(r108);
        Intrinsics.checkNotNullParameter(r111, "name");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r112, "callback");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r103, "options");     // Catch: Throwable -> L26
        Map<s87.c, CommonCallbackNG> r113 = s87.a.f540973b;     // Catch: Throwable -> L26
        r103.getClass();     // Catch: Throwable -> L26
        Function1<Object, Unit> r114 = r112;
        CommonCallbackNG r115 = r113.remove(new s87.c(r109, r110, r111, r112, false, 0));     // Catch: Throwable -> L26
        if (r115 != null) goto L21;
        r115 = s87.h.a(r114);     // Catch: Throwable -> L26
    L21:
        CommonCallbackNG r116 = r115;
        monitor-exit(r108);
        RendererFunctionNG r117 = r107.a();
        r101 = 0;
        r117.u(r110, r111, r116, new FiberEventListenerOption(false, 0));
    L26:
        th = move-exception;
        throw th;
    L15:
        Intrinsics.throwUninitializedPropertyAccessException("options");
        goto L16
    L11:
        Intrinsics.throwUninitializedPropertyAccessException("callback");
        r112 = null;
        goto L12
    }

    public final void b(long r100, long r101) {
        j r102 = this.f267236a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r102 = null;
    L5:
        r102.getClass();
        int r103 = s87.e.f540981a;
        i r104 = r102.f540987a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        r104.a().h(r100, r101);
    }

    public final long c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        j r102 = this.f267236a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r102 = null;
    L5:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "tag");
        int r103 = s87.e.f540981a;
        i r104 = r102.f540987a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        Intrinsics.checkNotNullParameter(r100, "tag");
        return r104.a().i(r100, r101);
    }

    public final void j(long r100, long r101) {
        j r102 = this.f267236a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r102 = null;
    L5:
        r102.getClass();
        int r103 = s87.e.f540981a;
        i r104 = r102.f540987a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        r104.a().t(r100, r101);
    }

    public final void n(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "ids");
        j r102 = this.f267236a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r102 = null;
    L5:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "value");
        int r103 = s87.e.f540981a;
        i r104 = r102.f540987a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        Intrinsics.checkNotNullParameter(r101, "value");
        r104.a().L(r100, r101.toString());
    }

    public final void o(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        j r102 = this.f267236a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r102 = null;
    L5:
        r102.b(r100, "text", r101);
    }

    public final void a(long r110, String r210, Function1<Object, Unit> r211) {
        Intrinsics.checkNotNullParameter(r210, "name");
        Intrinsics.checkNotNullParameter(r211, "callback");
        Intrinsics.checkNotNullParameter(r210, "<this>");
        String r100 = r210.toLowerCase(Locale.ROOT);
        s87.d r111 = new s87.d();
        j r101 = this.f267236a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r211, "callback");
        Intrinsics.checkNotNullParameter(r111, "options");
        int r102 = s87.e.f540981a;
        i r112 = r101.f540987a;
        Intrinsics.checkNotNullParameter(r112, "renderer");
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r211, "callback");
        Intrinsics.checkNotNullParameter(r111, "options");
        s87.h.b(r211);
        s87.a r113 = s87.a.f540972a;
        long r103 = r112.f540985a;
        monitor-enter(r113);
        Intrinsics.checkNotNullParameter(r100, "name");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r211, "callback");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r111, "options");     // Catch: Throwable -> L14
        Map<s87.c, CommonCallbackNG> r114 = s87.a.f540973b;     // Catch: Throwable -> L14
        s87.c r104 = new s87.c(r103, r110, r100, r211, false, 0);     // Catch: Throwable -> L14
        LinkedHashMap r115 = (LinkedHashMap) r114;     // Catch: Throwable -> L14
        Object r105 = r115.get(r104);     // Catch: Throwable -> L14
        if (r105 != null) goto L10;
        r105 = s87.h.a(r211);     // Catch: Throwable -> L14
        r115.put(r104, r105);     // Catch: Throwable -> L14
    L10:
        CommonCallbackNG r106 = (CommonCallbackNG) r105;     // Catch: Throwable -> L14
        monitor-exit(r113);
        r112.a().g(r110, r100, r106, new FiberEventListenerOption(false, 0));
        com.bytedance.rts.kmp.foundation.i.f(this.f267239d, new c(r110, r100, r211, r111));
        com.bytedance.rts.kmp.foundation.i.f(this.f267240e, r211);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void l(long r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "value");
        j r103 = this.f267236a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r103 = null;
    L5:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        int r104 = s87.e.f540981a;
        i r105 = r103.f540987a;
        Intrinsics.checkNotNullParameter(r105, "renderer");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        r105.a().x(r100, r101, r102);
    }

    public final void m(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "value");
        j r103 = null;
        if (Intrinsics.areEqual(r101, "id") == false) goto L10;
        j r104 = this.f267236a;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
    L8:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "value");
        int r105 = s87.e.f540981a;
        i r106 = r103.f540987a;
        Intrinsics.checkNotNullParameter(r106, "renderer");
        Intrinsics.checkNotNullParameter(r102, "value");
        r106.a().y(r100, r102);
        return;
    L7:
        r103 = r104;
        goto L8
    L10:
        j r107 = this.f267236a;
        if (r107 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
    L14:
        r103.b(r100, r101, r102);
        return;
    L13:
        r103 = r107;
        goto L14
    }
}
