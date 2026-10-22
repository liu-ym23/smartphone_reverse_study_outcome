package com.bytedance.ies.bullet.lynx.resource.forest;

import com.bytedance.forest.model.Response;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import d8a.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/bytedance/forest/model/Response;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class GlobalForestTemplateProvider$loadTemplate$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ b.a $callback;

    public GlobalForestTemplateProvider$loadTemplate$1(b.a r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Response r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        if (r100.f244316r == false) goto L23;
        b.a r101 = this.$callback;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        byte[] r103 = r100.j();     // Catch: Throwable -> L17
        if (r103 == null) goto L8;
        int r104 = r103.length;     // Catch: Throwable -> L17
    L9:
        Unit r105 = null;
        if (r104 <= 0) goto L13;
        if (r101 == null) goto L15;
        r101.onSuccess(r103);     // Catch: Throwable -> L17
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L17
    L19:
        b.a r107 = this.$callback;
        Throwable r108 = Result.m9452exceptionOrNullimpl(r106);
        if (r108 == null) goto L29;
        if (r107 == null) goto L30;
        r107.onFailed("template load error, " + r108.getMessage());
        return;
    L30:
        return;
    L29:
        return;
    L13:
        if (r101 == null) goto L15;
        r101.onFailed("template load error, bytes is empty");     // Catch: Throwable -> L17
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L17
        goto L15
    L8:
        r104 = -1;
    L17:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L23:
        b.a r110 = this.$callback;
        if (r110 == null) goto L32;
        r110.onFailed("template load error, " + r100.f244317s);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Response r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
