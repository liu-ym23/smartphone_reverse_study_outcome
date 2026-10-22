package com.larus.home.impl.sdk;

import com.larus.im.bean.message.Message;
import com.larus.platform.model.showcase.Case;
import com.larus.showcase.api.ICaseService;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h1 f346183a = null;

    static {
        f346183a = new h1();
    }

    public h1() {
    }

    public final boolean c() {
        return ICaseService.f369257a.k();
    }

    public final boolean d() {
        return ICaseService.f369257a.f();
    }

    public final List<Case> i() {
        return ICaseService.f369257a.i();
    }

    public final Object e(Continuation<? super Unit> r100) {
        Object r101 = ICaseService.f369257a.c(r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final Case h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caseId");
        return ICaseService.f369257a.l(r100);
    }

    public final void j(com.larus.platform.api.j1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ICaseService.f369257a.o(r100);
    }

    public final void k(com.larus.platform.api.j1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ICaseService.f369257a.g(r100);
    }

    public final Object a(String r100, Continuation<? super Boolean> r101) {
        return ICaseService.f369257a.p(r100, r101);
    }

    public final Object b(String r100, Continuation<? super Boolean> r101) {
        return ICaseService.f369257a.j(r100, r101);
    }

    public final List<Message> f(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "caseId");
        return ICaseService.f369257a.a(r100, r101);
    }

    public final Object l(String r100, Continuation<? super Unit> r101) {
        Object r102 = ICaseService.f369257a.d(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object g(String r100, boolean r101, Continuation<? super List<Message>> r102) {
        return ICaseService.f369257a.b(r100, r101, r102);
    }
}
