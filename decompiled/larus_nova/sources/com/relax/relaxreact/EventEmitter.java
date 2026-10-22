package com.relax.relaxreact;

import com.lynx.rts.gen.CommonCallbackNG;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class EventEmitter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f405400g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mpa.l f405401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ArrayList<Function1<Map<String, Object>, Unit>>> f405402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, b1> f405403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f405404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super Function0<Unit>, Unit> f405405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f405406f;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (this.f405406f == false) goto L5;
        return;
    L5:
        int r100 = ContextType.kNative.getValue();
        if (com.bytedance.rts.kmp.foundation.j.d(this.f405403c, e("__DestroyLifetime", r100)) == false) goto L8;
        return;
    L8:
        final com.bytedance.rts.kmp.foundation.p r101 = new com.bytedance.rts.kmp.foundation.p(this);
        d("__DestroyLifetime", new EventEmitter$_ensureDestroyRuntimeListener$destroyCallback$1(r101), r100);
    }

    public EventEmitter(mpa.l r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f405402b = new LinkedHashMap();
        this.f405403c = new LinkedHashMap();
        this.f405404d = com.bytedance.rts.kmp.foundation.l.a(new String[0]);
        this.f405401a = r100;
        b();
    }

    public static String e(String r100, int r101) {
        return r101 + ':' + r100;
    }

    public final void a(String r100, Function1<? super Map<String, Object>, Unit> r101) {
        if (this.f405406f == false) goto L5;
        return;
    L5:
        ArrayList r102 = (ArrayList) com.bytedance.rts.kmp.foundation.j.c(this.f405402b, r100);
        if (r102 != null) goto L8;
        r102 = new ArrayList();
        com.bytedance.rts.kmp.foundation.j.e(this.f405402b, r100, r102);
    L8:
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.add(r101);
    }

    public final void c(final String r100, int r101) {
        if (this.f405406f == false) goto L6;
        return;
    L6:
        if (com.bytedance.rts.kmp.foundation.j.d(this.f405403c, e(r100, r101)) == false) goto L8;
        return;
    L8:
        final com.bytedance.rts.kmp.foundation.p r102 = new com.bytedance.rts.kmp.foundation.p(this);
        d(r100, new EventEmitter$_ensureRuntimeEventListener$callback$1(r102, r100), r101);
    }

    public final void g(String r100, Function1<? super Map<String, Object>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Set<String> r102 = this.f405404d;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r102.contains(r100) == true) goto L5;
        c(r100, ContextType.kEngine.getValue());
        Set<String> r103 = this.f405404d;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r103.add(r100);
    L5:
        a(r100, r101);
    }

    public final void h(String r100, Function1<? super Map<String, Object>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "handler");
        ArrayList r102 = (ArrayList) com.bytedance.rts.kmp.foundation.j.c(this.f405402b, r100);
        if (r102 == null) goto L24;
        int r103 = com.bytedance.rts.kmp.foundation.i.d(r102, r101);
        if (r103 == (-1)) goto L7;
        com.bytedance.rts.kmp.foundation.i.i(r102, r103, new Function1[0]);
    L7:
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r102.size() != 0) goto L25;
        com.bytedance.rts.kmp.foundation.j.a(this.f405402b, r100);
        Set<String> r104 = this.f405404d;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (r104.contains(r100) == false) goto L26;
        String r105 = e(r100, ContextType.kEngine.getValue());
        b1 r106 = (b1) com.bytedance.rts.kmp.foundation.j.c(this.f405403c, r105);
        if (r106 == null) goto L22;
        mpa.l r107 = this.f405401a;
        Function1<Object, Unit> r108 = null;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("_renderer");
        r107 = null;
    L17:
        String r109 = r106.f405466a;
        Function1<Object, Unit> r110 = r106.f405468c;
        if (r110 == null) goto L20;
        r108 = r110;
    L21:
        r107.b(r109, r108, r106.getType());
        com.bytedance.rts.kmp.foundation.j.a(this.f405403c, r105);
        goto L22
    L20:
        Intrinsics.throwUninitializedPropertyAccessException("callback");
    L22:
        Set<String> r111 = this.f405404d;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        r111.remove(r100);
        return;
    L26:
        return;
    L25:
        return;
    }

    public static final void f(EventEmitter r100, String r101, final Map r102) {
        if (r100.f405406f == true) goto L14;
        final ArrayList r103 = (ArrayList) com.bytedance.rts.kmp.foundation.j.c(r100.f405402b, r101);
        Function1<? super Function0<Unit>, Unit> r104 = r100.f405405e;
        Intrinsics.checkNotNullParameter(r102, "event");
        if (r103 == null) goto L15;
        Function0<Unit> r105 = new EventEmitterKt$emitListeners$emit$1(r103, r102);
        if (r104 == null) goto L11;
        r104.invoke(r105);
        return;
    L11:
        r105.invoke();
        return;
    L15:
        return;
    }

    public final void d(String r110, final Function1<? super Map<String, Object>, Unit> r111, int r112) {
        if (com.bytedance.rts.kmp.foundation.j.d(this.f405403c, e(r110, r112)) == false) goto L5;
        return;
    L5:
        Function1<Object, Unit> r100 = new EventEmitter$_registerRuntimeEventListener$runtimeCallback$1(r111);
        int r113 = com.relax.relaxreact.utils.a.f405592a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r100, "callback");
        AtomicLong r101 = mpa.j.f514756a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        mpa.c r114 = new mpa.c(r100);
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>{ com.relax.relaxreact.enginebinding.EngineBindingAliasesKt.CommonCallbackNG }");
        Function1 r115 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r114, 1);
        mpa.l r102 = this.f405401a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("_renderer");
        r102 = null;
    L8:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r115, "callback");
        int r103 = mpa.e.f514751a;
        mpa.k r104 = r102.f514759a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r115, "callback");
        CommonCallbackNG r105 = mpa.j.b(r115);
        if (r105 != null) goto L21;
        mpa.a r106 = mpa.a.f514744a;
        long r107 = r104.f514757a;
        monitor-enter(r106);
        Intrinsics.checkNotNullParameter(r110, "eventName");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r115, "callback");     // Catch: Throwable -> L18
        Map<mpa.m, CommonCallbackNG> r108 = mpa.a.f514746c;     // Catch: Throwable -> L18
        mpa.m r109 = new mpa.m(r107, r110, r115, r112);     // Catch: Throwable -> L18
        LinkedHashMap r116 = (LinkedHashMap) r108;     // Catch: Throwable -> L18
        Object r117 = r116.get(r109);     // Catch: Throwable -> L18
        if (r117 != null) goto L15;
        r117 = mpa.j.a(r115);     // Catch: Throwable -> L18
        r116.put(r109, r117);     // Catch: Throwable -> L18
    L15:
        r105 = (CommonCallbackNG) r117;     // Catch: Throwable -> L18
        monitor-exit(r106);
    L18:
        th = move-exception;
        throw th;
    L21:
        r104.a().J(r110, r105, r112);
        com.bytedance.rts.kmp.foundation.j.e(this.f405403c, e(r110, r112), new b1(r110, r112, r115));
    }
}
