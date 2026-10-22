package com.ss.android.lark.integrator.security.compliance.export;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/integrator/security/compliance/export/SecurityFileCryptoService$OperationResult;", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class SecurityFileCryptoService$decryptUri$1 extends Lambda implements Function0<SecurityFileCryptoService.c<String>> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    final /* synthetic */ SecurityFileCryptoService this$0;

    public SecurityFileCryptoService$decryptUri$1(SecurityFileCryptoService r100, Context r101, Uri r102) {
        this.this$0 = r100;
        this.$context = r101;
        this.$uri = r102;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SecurityFileCryptoService.c<String> invoke() {
        SecurityFileCryptoService r100 = this.this$0;
        Context r101 = this.$context;
        Uri r102 = this.$uri;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(r100.f428072b.Gd(r101, r102));     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L11;
        Log.e("SecurityFileCryptoService", "[decryptUri] failed, error=".concat(r105.getClass().getSimpleName()));
    L11:
        if (Result.m9455isFailureimpl(r104) == false) goto L13;
        r104 = null;
    L13:
        Pair r106 = (Pair) r104;
        boolean r107 = false;
        if (r106 == null) goto L16;
        SecurityFileCryptoService.b r108 = SecurityFileCryptoService.b(this.this$0, r106, "decryptUri");
        String r109 = r108.f428075a;
        if (r109 == null) goto L21;
        r107 = true;
    L21:
        return new SecurityFileCryptoService.c(r109, r107, r108.f428076b, r108.f428077c);
    L16:
        return new SecurityFileCryptoService.c(null, false, null, null);
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SecurityFileCryptoService.c<String> invoke() {
        return invoke();
    }
}
