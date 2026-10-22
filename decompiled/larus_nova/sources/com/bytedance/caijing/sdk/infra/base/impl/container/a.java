package com.bytedance.caijing.sdk.infra.base.impl.container;

import com.bytedance.caijing.sdk.infra.base.api.container.IContainerHostDepend;
import com.bytedance.ies.bullet.service.base.l0;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements md4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BulletServiceImpl.b f202376a;

    @Override // md4.a
    public final boolean H() {
        XCoreBridgeMethod r100 = (XCoreBridgeMethod) this.f202376a.g(XCoreBridgeMethod.class);
        Object r101 = null;
        if (r100 == null) goto L5;
        m16.b r102 = (m16.b) r100.provideContext(m16.b.class);
    L6:
        if (r102 == null) goto L8;
        l0 r103 = (l0) r102.c(l0.class);
    L9:
        if (r103 == null) goto L32;
        r103.close();
        Unit r104 = Unit.INSTANCE;
        return true;
    L32:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L21
        IContainerHostDepend r106 = (IContainerHostDepend) ve4.b.b(IContainerHostDepend.class);     // Catch: Throwable -> L21
        if (r106 == null) goto L15;
        Boolean r107 = Boolean.valueOf(r106.closeAnnieXLive(r102));     // Catch: Throwable -> L21
    L16:
        if (r107 == null) goto L18;
        boolean r108 = r107.booleanValue();     // Catch: Throwable -> L21
    L19:
        Object r109 = Result.m9449constructorimpl(Boolean.valueOf(r108));     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r109) == true) goto L27;
        r101 = r109;
    L27:
        Boolean r110 = (Boolean) r101;
        if (r110 != null) goto L35;
        return false;
    L35:
        return r110.booleanValue();
    L18:
        r108 = false;
        goto L19
    L15:
        r107 = null;
    L21:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public a(BulletServiceImpl.b r100) {
        this.f202376a = r100;
    }
}
