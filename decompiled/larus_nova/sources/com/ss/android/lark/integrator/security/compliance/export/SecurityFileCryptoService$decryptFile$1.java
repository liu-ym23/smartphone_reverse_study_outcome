package com.ss.android.lark.integrator.security.compliance.export;

import android.util.Pair;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.log.Log;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/integrator/security/compliance/export/SecurityFileCryptoService$OperationResult;", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class SecurityFileCryptoService$decryptFile$1 extends Lambda implements Function0<SecurityFileCryptoService.c<String>> {
    final /* synthetic */ File $file;
    final /* synthetic */ SecurityFileCryptoService this$0;

    public SecurityFileCryptoService$decryptFile$1(SecurityFileCryptoService r100, File r101) {
        this.this$0 = r100;
        this.$file = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SecurityFileCryptoService.c<String> invoke() {
        SecurityFileCryptoService r100 = this.this$0;
        File r101 = this.$file;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(r100.f428072b.m3(r101));     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L11;
        Log.e("SecurityFileCryptoService", "[decryptFile] failed, error=".concat(r104.getClass().getSimpleName()));
    L11:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = null;
    L13:
        Pair r105 = (Pair) r103;
        boolean r106 = false;
        if (r105 == null) goto L16;
        SecurityFileCryptoService.b r107 = SecurityFileCryptoService.b(this.this$0, r105, "decryptFile");
        String r108 = r107.f428075a;
        if (r108 == null) goto L21;
        r106 = true;
    L21:
        return new SecurityFileCryptoService.c(r108, r106, r107.f428076b, r107.f428077c);
    L16:
        return new SecurityFileCryptoService.c(null, false, null, null);
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SecurityFileCryptoService.c<String> invoke() {
        return invoke();
    }
}
