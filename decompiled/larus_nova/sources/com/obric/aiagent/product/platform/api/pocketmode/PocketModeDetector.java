package com.obric.aiagent.product.platform.api.pocketmode;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v9a.f;

/* JADX INFO: loaded from: classes4.dex */
public final class PocketModeDetector implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PocketModeDetector f385009a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f385010b = null;

    public PocketModeDetector() {
    }

    static {
        f385009a = new PocketModeDetector();
        f.a r100 = f.f553878h;     // Catch: Throwable -> L19
        if (r100.a().b() == false) goto L10;
        ServiceManager.get().bind(a.class, new SingletonProvider(new b()));     // Catch: Throwable -> L7
    L17:
        ILogDepend.f384986a.i("PocketModeDetector", "bind IPocketModeDetector isOs=" + f.f553878h.a().b());     // Catch: Throwable -> L19
    L21:
        a r101 = (a) ServiceManager.get().getService(a.class, false);     // Catch: Throwable -> L23
        f385010b = r101;     // Catch: Throwable -> L23
        ILogDepend.f384986a.i("PocketModeDetector", "IPocketModeDetector instance: " + r101);     // Catch: Throwable -> L23
        return;
    L7:
        th = move-exception;
        ILogDepend.f384986a.e("PocketModeDetector", "bind ObricPocketModeDetector failed", th);     // Catch: Throwable -> L19
        goto L17
    L10:
        if (Intrinsics.areEqual(r100.a().d(), "Genesis-R") == false) goto L12;
    L29:
        ServiceManager.get().bind(a.class, new SingletonProvider(new c()));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ILogDepend.f384986a.e("PocketModeDetector", "bind GRPocketModeDetector failed", th);     // Catch: Throwable -> L19
        goto L17
    L12:
        if (Intrinsics.areEqual(r100.a().d(), "Genesis-M") == false) goto L17;
    L19:
        th = move-exception;
        ILogDepend.f384986a.e("PocketModeDetector", "init IPocketModeDetector failed", th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        f385010b = null;
        ILogDepend.f384986a.e("PocketModeDetector", "init IPocketModeDetector failed", th);
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final void b() {
        a r100 = f385010b;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final boolean c() {
        a r100 = f385010b;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.c());
    L7:
        return a(r101, "isCheckPassed");
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final void g() {
        a r100 = f385010b;
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final void init() {
        a r100 = f385010b;
        if (r100 == null) goto L6;
        r100.init();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final Object d(Continuation<? super Boolean> r100) {
        if ((r100 instanceof PocketModeDetector$awaitCheckPassed$1) == false) goto L7;
        PocketModeDetector$awaitCheckPassed$1 r101 = (PocketModeDetector$awaitCheckPassed$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        PocketModeDetector r106 = (PocketModeDetector) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L20:
        Boolean r107 = (Boolean) r103;
    L22:
        r106.getClass();
        return Boxing.boxBoolean(a(r107, "awaitCheckPassed"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        a r108 = f385010b;
        if (r108 == null) goto L21;
        r101.L$0 = this;
        r101.label = 1;
        r103 = r108.d(r101);
        if (r103 != r104) goto L19;
        return r104;
    L19:
        r106 = this;
        goto L20
    L21:
        r107 = null;
        r106 = this;
    L7:
        r101 = new PocketModeDetector$awaitCheckPassed$1(this, r100);
        goto L8
    }

    public static boolean a(Boolean r100, String r101) {
        if (r100 != null) goto L6;
        ILogDepend.f384986a.e("PocketModeDetector", "instance?." + r101 + "() is null, return true");
        return true;
    L6:
        ILogDepend.f384986a.i("PocketModeDetector", r101 + ": " + r100);
        return r100.booleanValue();
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.a
    public final void f(boolean r100, boolean r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "showToastAction");
        a r103 = f385010b;
        if (r103 == null) goto L6;
        r103.f(r100, r101, r102);
        return;
    }
}
