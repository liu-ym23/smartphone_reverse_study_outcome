package com.ss.android.lark.integrator.security.compliance.export;

import android.util.Pair;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/integrator/security/compliance/export/SecurityFileCryptoService$OperationResult;", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class SecurityFileCryptoService$writeBackEncrypted$1 extends Lambda implements Function0<SecurityFileCryptoService.c<String>> {
    final /* synthetic */ String $decryptedPath;
    final /* synthetic */ SecurityFileCryptoService this$0;

    public SecurityFileCryptoService$writeBackEncrypted$1(SecurityFileCryptoService r100, String r101) {
        this.this$0 = r100;
        this.$decryptedPath = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SecurityFileCryptoService.c<String> invoke() {
        SecurityFileCryptoService r100 = this.this$0;
        String r101 = this.$decryptedPath;
        int r102 = SecurityFileCryptoService.f428070e;
        r100.getClass();
        boolean r103 = SecurityFileCryptoService.c(r101);
        boolean r104 = false;
        String r105 = null;
        if (r103 == true) goto L7;
        Log.e("SecurityFileCryptoService", "[writeBackEncrypted] invalid input path");
        return new SecurityFileCryptoService.c(null, false, null, null);
    L7:
        if (new PolarisFileWrapper(this.$decryptedPath).isFile() == true) goto L10;
        Log.e("SecurityFileCryptoService", "[writeBackEncrypted] input is not a regular file");
        return new SecurityFileCryptoService.c(null, false, null, null);
    L10:
        SecurityFileCryptoService r106 = this.this$0;
        String r107 = this.$decryptedPath;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L13
        Object r109 = Result.m9449constructorimpl(r106.f428072b.Ec(r107));     // Catch: Throwable -> L13
    L15:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L19;
        Log.e("SecurityFileCryptoService", "[writeBackEncrypted] failed, error=".concat(r110.getClass().getSimpleName()));
    L19:
        if (Result.m9455isFailureimpl(r109) == false) goto L21;
        r109 = null;
    L21:
        Pair r111 = (Pair) r109;
        if (r111 == null) goto L24;
        SecurityFileCryptoService.b r112 = SecurityFileCryptoService.b(this.this$0, r111, "writeBackEncrypted");
        String r113 = r112.f428075a;
        if (r113 == null) goto L31;
        if (SecurityFileCryptoService.a(this.this$0, r113, "writeBackEncrypted") == false) goto L31;
        r105 = r113;
    L31:
        if (r105 == null) goto L34;
        r104 = true;
    L34:
        return new SecurityFileCryptoService.c(r105, r104, r112.f428076b, r112.f428077c);
    L24:
        return new SecurityFileCryptoService.c(null, false, null, null);
    L13:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SecurityFileCryptoService.c<String> invoke() {
        return invoke();
    }
}
