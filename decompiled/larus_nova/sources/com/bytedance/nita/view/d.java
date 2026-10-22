package com.bytedance.nita.view;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.bytedance.nita.api.NitaSchdulerType;
import com.bytedance.nita.exception.NitaViewNotFindException;
import com.bytedance.nita.schduler.f;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.bytedance.nita.api.c> f266017a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f266018b = null;

    public d() {
    }

    static {
        f266018b = new d();
        f266017a = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r2v9, types: [T, android.view.View] */
    public static Object a(final String r110, final int r210, final Context r211, final boolean r212) {
        System.currentTimeMillis();
        final Ref.ObjectRef r111 = new Ref.ObjectRef();
        q37.a r100 = q37.a.f531525i;
        r111.element = r100.a(r110, r210, r211, r212);
        final com.bytedance.nita.api.c r112 = f266017a.get(r110);
        if (r112 == null) goto L47;
        View r101 = (View) r111.element;
        if (r101 == null) goto L11;
        c(r112, r210, r101, r211, true);
        o37.c.f521918e.getClass();
        com.bytedance.nita.api.b r102 = o37.c.d();
        if (r102 == null) goto L10;
        System.currentTimeMillis();
        r102.c(r112, r210, r211);
    L10:
        return (View) r111.element;
    L11:
        final Ref.BooleanRef r113 = new Ref.BooleanRef();
        r113.element = false;
        final Ref.BooleanRef r103 = new Ref.BooleanRef();
        r103.element = false;
        o37.b r104 = o37.a.f521912a;
        if ((o37.a.a() & 4) == 0) goto L28;
        ?? r105 = r100.a(r110, r210, r211, r212);
        r111.element = r105;
        if (r105 != 0) goto L27;
        Object r114 = r112.g(r210);
        monitor-enter(r114);
        ?? r106 = r100.a(r110, r210, r211, r212);     // Catch: Throwable -> L24
        r111.element = r106;     // Catch: Throwable -> L24
        if (r106 != 0) goto L20;
        final boolean r115 = true;
        r111.element = b(r112, r210, r211, new ViewManager$getView$$inlined$synchronized$lambda$1(r111, r110, r210, r211, r212, r112, r115, r103, r113));     // Catch: Throwable -> L24
        r103.element = true;     // Catch: Throwable -> L24
        r113.element = false;     // Catch: Throwable -> L24
    L21:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r114);
    L36:
        o37.c.f521918e.getClass();
        com.bytedance.nita.api.b r108 = o37.c.d();
        if (r108 == null) goto L39;
        System.currentTimeMillis();
        r108.c(r112, r210, r211);
    L39:
        View r109 = (View) r111.element;
        if (r109 != null) goto L42;
        Intrinsics.throwNpe();
    L42:
        return r109;
    L20:
        c(r112, r210, r106, r211, true);     // Catch: Throwable -> L24
        r103.element = true;     // Catch: Throwable -> L24
        r113.element = true;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L27:
        c(r112, r210, r105, r211, true);
        r103.element = false;
        r113.element = true;
        goto L36
    L28:
        Object r116 = r112.g(r210);
        monitor-enter(r116);
        ?? r117 = r100.a(r110, r210, r211, r212);     // Catch: Throwable -> L43
        r111.element = r117;     // Catch: Throwable -> L43
        if (r117 != 0) goto L33;
        r111.element = b(r112, r210, r211, null);     // Catch: Throwable -> L43
        r103.element = true;     // Catch: Throwable -> L43
        r113.element = false;     // Catch: Throwable -> L43
    L34:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L43
        monitor-exit(r116);
        goto L36
    L33:
        c(r112, r210, r117, r211, true);     // Catch: Throwable -> L43
        r103.element = true;     // Catch: Throwable -> L43
        r113.element = true;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L47:
        throw new NitaViewNotFindException(r110);
    }

    public static View b(com.bytedance.nita.api.c r100, int r110, Context r111, Function1 r112) {
        long r101 = System.currentTimeMillis();
        o37.b r102 = o37.a.f521912a;
        if ((o37.a.a() & 32) != 0) goto L5;
    L33:
        View r113 = r100.c().c(r111, r100.d(r111), r110);
        if ((o37.a.a() & 16) == 0) goto L41;
        ConcurrentHashMap<NitaSchdulerType, com.bytedance.nita.schduler.d> r103 = f.f266015a;
        NitaSchdulerType r104 = NitaSchdulerType.AT_ONCE;
        ConcurrentHashMap<NitaSchdulerType, com.bytedance.nita.schduler.d> r105 = f.f266015a;
        com.bytedance.nita.schduler.d r106 = r105.get(r104);
        if (r106 == null) goto L38;
        r106.c(r100.h());
    L38:
        com.bytedance.nita.schduler.d r107 = r105.get(NitaSchdulerType.IDEL);
        if (r107 == null) goto L41;
        r107.c(r100.h());
    L41:
        o37.c.f521918e.getClass();
        com.bytedance.nita.api.b r108 = o37.c.d();
        if (r108 == null) goto L44;
        r108.e(System.currentTimeMillis() - r101, r100, r110, r111);
    L44:
        return r113;
    L5:
        if ((r100.c() instanceof c) == false) goto L33;
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L33;
        b r109 = r100.c();
        if (r109 == null) goto L32;
        if (((c) r109).a() != null) goto L17;
        b r114 = r100.c();
        if (r114 == null) goto L16;
        return ((c) r114).c(r111, r100.d(r111), r110);
    L16:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.nita.view.NitaViewRelayFactory");
    L17:
        b r115 = r100.c();
        if (r115 == null) goto L30;
        r100.d(r111);
        View r116 = ((c) r115).b();
        if (r116 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        if (r112 == null) goto L24;
        Unit r117 = (Unit) r112.invoke(r116);
    L24:
        o37.c.f521918e.getClass();
        com.bytedance.nita.api.b r118 = o37.c.d();
        if (r118 == null) goto L28;
        r118.e(System.currentTimeMillis() - r101, r100, r110, r111);
    L28:
        return r116;
    L30:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.nita.view.NitaViewRelayFactory");
    L32:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.nita.view.NitaViewRelayFactory");
    }

    public static void c(com.bytedance.nita.api.c r100, int r101, View r102, Context r103, boolean r104) {
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r103 instanceof Activity) == true) goto L9;
        int r105 = r37.c.f535886a;
        "nitaView currentContext is ApplicationContext,view type is ".concat(r102.getClass().getSimpleName());
        o37.c.f521918e.getClass();
        o37.c.c();
        return;
    L9:
        if ((r102.getContext() instanceof p37.a) == false) goto L19;
        Context r106 = r102.getContext();
        if (r106 == null) goto L18;
        WeakReference<Context> r107 = new WeakReference(r103);
        ((p37.a) r106).f527595a = r107;
        if (r104 == false) goto L20;
        Field r108 = r37.d.f535887a;
        Activity r109 = (Activity) r103;
        int r110 = r37.c.f535886a;
        System.currentTimeMillis();
        o37.c r111 = o37.c.f521918e;
        r111.getClass();
        o37.c.c();
        r37.d.c(r102, r109);
        System.currentTimeMillis();
        r111.getClass();
        o37.c.c();
        if (r100 == null) goto L21;
        r100.e(r102, r109);
        return;
    L21:
        return;
    L20:
        return;
    L18:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.nita.context.NitaContext");
    }
}
