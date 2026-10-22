package com.larus.bmhome.social.page.datasource;

import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes26.dex */
public final class LoadStateHolder<T, Key> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f<T, Key> f313993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<T, Key> f313994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutexImpl f313995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile com.larus.bmhome.social.page.datasource.event.e f313996d;

    public LoadStateHolder(f<T, Key> r100, a<T, Key> r101) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f313993a = r100;
        this.f313994b = r101;
        r101.getClass();
        this.f313995c = kotlinx.coroutines.sync.b.a();
    }

    public final Object a(com.larus.bmhome.social.page.datasource.event.e.a r100, Continuation<? super g<T, Key>> r101) {
        if ((r101 instanceof LoadStateHolder$checkLoad$1) == false) goto L7;
        LoadStateHolder$checkLoad$1 r102 = (LoadStateHolder$checkLoad$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L40;
        if (r106 != 1) goto L12;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r102.L$1;
        com.larus.bmhome.social.page.datasource.event.e.a r108 = (com.larus.bmhome.social.page.datasource.event.e.a) r102.L$0;
        ResultKt.throwOnFailure(r104);
        kotlinx.coroutines.sync.a r109 = r107;
        r100 = r108;
    L51:
        Intrinsics.areEqual(r100, com.larus.bmhome.social.page.datasource.event.e.a.C4103a.f314038a);     // Catch: Throwable -> L46
        int r110 = g.f314041b;     // Catch: Throwable -> L46
        g.b r111 = new g.b(null);     // Catch: Throwable -> L46
        r109.unlock(null);
        return r111;
    L46:
        th = move-exception;
        r109.unlock(null);
        throw th;
    L12:
        if (r106 == 2) goto L17;
        if (r106 != 3) goto L16;
        kotlinx.coroutines.sync.a r112 = (kotlinx.coroutines.sync.a) r102.L$2;
        g r113 = (g) r102.L$1;
        com.larus.bmhome.social.page.datasource.event.e.a r114 = (com.larus.bmhome.social.page.datasource.event.e.a) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L49:
    L36:
        th = move-exception;
        r112.unlock(null);
        throw th;
    L22:
        if ((r113 instanceof g.d) == false) goto L31;
        if (Intrinsics.areEqual(r114, com.larus.bmhome.social.page.datasource.event.e.a.C4103a.f314038a) == false) goto L26;
        ((g.d) r113).getClass();     // Catch: Throwable -> L36
    L28:
        if (Intrinsics.areEqual(this.f313996d, r114) == false) goto L33;
        this.f313996d = null;     // Catch: Throwable -> L36
    L33:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L36
        r112.unlock(null);
        return r113;
    L26:
        ((g.d) r113).getClass();     // Catch: Throwable -> L36
        goto L28
    L31:
        if ((r113 instanceof g.c) == false) goto L33;
        this.f313996d = r114;     // Catch: Throwable -> L36
        goto L33
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        com.larus.bmhome.social.page.datasource.event.e.a r116 = (com.larus.bmhome.social.page.datasource.event.e.a) r102.L$0;
        ResultKt.throwOnFailure(r104);
        g r117 = (g) r104;
        MutexImpl r118 = this.f313995c;
        r102.L$0 = r116;
        r102.L$1 = r117;
        r102.L$2 = r118;
        r102.label = 3;
        if (r118.a(null, r102) != r105) goto L20;
        return r105;
    L20:
        r114 = r116;
        r113 = r117;
        r112 = r118;
        goto L49
    L40:
        ResultKt.throwOnFailure(r104);
        r109 = this.f313995c;
        r102.L$0 = r100;
        r102.L$1 = r109;
        r102.label = 1;
        if (r109.a(null, r102) != r105) goto L51;
        return r105;
    L7:
        r102 = new LoadStateHolder$checkLoad$1(this, r101);
        goto L8
    }

    public final Object b(boolean r110, Continuation<? super g<T, Key>> r111) {
        if ((r111 instanceof LoadStateHolder$checkRefresh$1) == false) goto L7;
        LoadStateHolder$checkRefresh$1 r100 = (LoadStateHolder$checkRefresh$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L19;
        if (r103 == 4) goto L18;
        if (r103 != 5) goto L17;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r100.L$1;
        g r104 = (g) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L70:
    L61:
        th = move-exception;
        r113.unlock(null);
        throw th;
    L53:
        if ((r104 instanceof g.d) == false) goto L56;
        ((g.d) r104).getClass();     // Catch: Throwable -> L61
        ((g.d) r104).getClass();     // Catch: Throwable -> L61
        this.f313996d = null;     // Catch: Throwable -> L61
    L58:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L61
        r113.unlock(null);
        return r104;
    L56:
        if ((r104 instanceof g.c) == false) goto L58;
        this.f313996d = new com.larus.bmhome.social.page.datasource.event.e.b(true);     // Catch: Throwable -> L61
        goto L58
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
    L48:
        g r115 = (g) r112;
        MutexImpl r116 = this.f313995c;
        r100.L$0 = r115;
        r100.L$1 = r116;
        r100.label = 5;
        if (r116.a(null, r100) != r102) goto L51;
        return r102;
    L51:
        r104 = r115;
        r113 = r116;
        goto L70
    L19:
        kotlinx.coroutines.sync.a r117 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L72:
        this.f313996d = null;     // Catch: Throwable -> L64
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L64
        r117.unlock(null);
        this.f313994b.getClass();
        this.f313994b.getClass();
        e r119 = new e();
        CoroutineDispatcher r120 = Dispatchers.getIO();
        LoadStateHolder$checkRefresh$result$1 r105 = new LoadStateHolder$checkRefresh$result$1(this, r119, null);
        r100.L$0 = null;
        r100.label = 4;
        r112 = BuildersKt.withContext(r120, r105, r100);
        if (r112 != r102) goto L48;
        return r102;
    L64:
        th = move-exception;
        r117.unlock(null);
        throw th;
    L20:
        ResultKt.throwOnFailure(r112);
    L38:
        return r112;
    L21:
        r110 = r100.Z$0;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L74:
        com.larus.bmhome.social.page.datasource.event.e r121 = this.f313996d;     // Catch: Throwable -> L67
        r106.unlock(null);
        if (r110 == false) goto L41;
        if (r121 == null) goto L41;
        r100.L$0 = null;
        r100.label = 2;
        if ((r121 instanceof com.larus.bmhome.social.page.datasource.event.e.b) == false) goto L34;
        Object r122 = b(false, r100);
    L32:
        r112 = r122;
        if (r112 != r102) goto L38;
        return r102;
    L34:
        if ((r121 instanceof com.larus.bmhome.social.page.datasource.event.e.a) == false) goto L40;
        r122 = a((com.larus.bmhome.social.page.datasource.event.e.a) r121, r100);
        goto L32
    L40:
        throw new NoWhenBranchMatchedException();
    L41:
        r117 = this.f313995c;
        r100.L$0 = r117;
        r100.label = 3;
        if (r117.a(null, r100) != r102) goto L72;
        return r102;
    L67:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L22:
        ResultKt.throwOnFailure(r112);
        r106 = this.f313995c;
        r100.L$0 = r106;
        r100.Z$0 = r110;
        r100.label = 1;
        if (r106.a(null, r100) != r102) goto L74;
        return r102;
    L7:
        r100 = new LoadStateHolder$checkRefresh$1(this, r111);
        goto L8
    }
}
