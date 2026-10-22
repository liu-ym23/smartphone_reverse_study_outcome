package com.bytedance.pia.core.setting;

import com.bytedance.pia.core.api.bridge.PiaMethod;
import java.io.InputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes21.dex */
public final class e<T> implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f266300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l47.a<Unit> f266301b;

    public e() {
        this.f266300a = null;
        this.f266301b = null;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        i47.e r101 = (i47.e) r100;
        g.f266309g.set(false);
        g.f266310h.set(true);
        g.f266308f = System.currentTimeMillis();
        if (r101 == null) goto L25;
        InputStream r102 = r101.getData();
        if (r102 == null) goto L26;
        l47.a<PiaMethod.Error> r103 = this.f266300a;
        l47.a<Unit> r104 = this.f266301b;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L9
        g.a(g.f266303a, r102);     // Catch: Throwable -> L9
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L17;
        if (r103 == null) goto L15;
        r103.accept(new PiaMethod.Error(-10002, r107.getMessage()));
    L15:
        com.bytedance.pia.core.utils.d.f("[PIASettings] Exception happened when handling settings stream. Error: " + r107, null, null, 14);
    L17:
        if (Result.m9456isSuccessimpl(r106) == false) goto L27;
        Unit r108 = (Unit) r106;
        if (r104 == null) goto L21;
        r104.accept(null);
    L21:
        com.bytedance.pia.core.utils.d.l("[PIASettings] Update Async settings success.", null, 14);
        return;
    L27:
        return;
    L9:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L26:
        return;
    }
}
