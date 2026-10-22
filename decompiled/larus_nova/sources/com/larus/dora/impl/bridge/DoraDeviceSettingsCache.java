package com.larus.dora.impl.bridge;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraDeviceSettingsCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraDeviceSettingsCache f332061a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutexImpl f332062b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f332063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile n f332064d;

    public DoraDeviceSettingsCache() {
    }

    static {
        f332061a = new DoraDeviceSettingsCache();
        f332062b = kotlinx.coroutines.sync.b.a();
    }

    public static String b(String r100) {
        if (r100 != null) goto L4;
    L6:
        return null;
    L4:
        if ((!StringsKt.isBlank(r100)) == false) goto L6;
        return r100;
    }

    public final void update(String r100, Function1<? super n, n> r101) {
        Intrinsics.checkNotNullParameter(r101, "updater");
        monitor-enter(this);
        f332061a.getClass();     // Catch: Throwable -> L21
        String r102 = b(r100);     // Catch: Throwable -> L21
        n r103 = null;
        if (Intrinsics.areEqual(f332063c, r102) == false) goto L7;
        n r104 = f332064d;     // Catch: Throwable -> L21
    L8:
        n r105 = r101.invoke(r104);     // Catch: Throwable -> L21
        f332063c = r102;     // Catch: Throwable -> L21
        if (r105 != null) goto L11;
    L18:
        f332064d = r103;     // Catch: Throwable -> L21
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L11:
        if (r105.f332104a == null) goto L13;
    L15:
        boolean r107 = false;
    L16:
        if (r107 == true) goto L18;
        r103 = r105;
        goto L18
    L13:
        if (r105.f332105b != null) goto L15;
        r107 = true;
        goto L16
    L7:
        r104 = null;
    L21:
        th = move-exception;
        throw th;
    }

    public final Object a(String r100, Function1<? super Continuation<? super n>, ? extends Object> r110, Continuation<? super n> r111) {
        if ((r111 instanceof DoraDeviceSettingsCache$getOrLoad$1) == false) goto L7;
        DoraDeviceSettingsCache$getOrLoad$1 r101 = (DoraDeviceSettingsCache$getOrLoad$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 != 2) goto L18;
        DoraDeviceSettingsCache r106 = (DoraDeviceSettingsCache) r101.L$2;
        String r113 = (String) r101.L$1;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L15
    L42:
        n r114 = (n) r112;     // Catch: Throwable -> L15
        r106.getClass();     // Catch: Throwable -> L15
        f332063c = r113;     // Catch: Throwable -> L15
        if (r114 != null) goto L45;
    L52:
        r114 = null;
    L53:
        f332064d = r114;     // Catch: Throwable -> L15
        n r108 = f332064d;     // Catch: Throwable -> L15
        kotlinx.coroutines.sync.a r109 = r107;
    L55:
        r109.unlock(null);
        return r108;
    L45:
        if (r114.f332104a == null) goto L47;
    L49:
        r105 = false;
    L50:
        if (r105 == true) goto L52;
    L47:
        if (r114.f332105b != null) goto L49;
    L15:
        th = move-exception;
        th = th;
        r109 = r107;
    L58:
        r109.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r109 = (kotlinx.coroutines.sync.a) r101.L$2;
        r113 = (String) r101.L$1;
        Function1<? super Continuation<? super n>, ? extends Object> r115 = (Function1) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L62:
        DoraDeviceSettingsCache r116 = f332061a;     // Catch: Throwable -> L33
        r116.getClass();     // Catch: Throwable -> L33
        if (Intrinsics.areEqual(f332063c, r113) == false) goto L35;
        r108 = f332064d;     // Catch: Throwable -> L33
    L36:
        if (r108 != null) goto L55;
        r101.L$0 = r109;     // Catch: Throwable -> L33
        r101.L$1 = r113;     // Catch: Throwable -> L33
        r101.L$2 = r116;     // Catch: Throwable -> L33
        r101.label = 2;     // Catch: Throwable -> L33
        Object r117 = r115.invoke(r101);     // Catch: Throwable -> L33
        if (r117 != r103) goto L41;
        return r103;
    L41:
        r107 = r109;
        r106 = r116;
        r112 = r117;
        goto L42
    L35:
        r108 = null;
    L33:
        th = th;
        goto L58
    L20:
        ResultKt.throwOnFailure(r112);
        String r118 = b(r100);
        if (Intrinsics.areEqual(f332063c, r118) == false) goto L23;
        n r119 = f332064d;
    L24:
        if (r119 == null) goto L26;
        return r119;
    L26:
        MutexImpl r120 = f332062b;
        r101.L$0 = r110;
        r101.L$1 = r118;
        r101.L$2 = r120;
        r101.label = 1;
        if (r120.a(null, r101) != r103) goto L29;
        return r103;
    L29:
        r115 = r110;
        r113 = r118;
        r109 = r120;
        goto L62
    L23:
        r119 = null;
    L7:
        r101 = new DoraDeviceSettingsCache$getOrLoad$1(this, r111);
        goto L8
    }
}
