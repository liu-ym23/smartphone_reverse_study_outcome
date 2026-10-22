package com.ss.android.lark.integrator.security.compliance.export;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/integrator/security/compliance/export/SecurityFileCryptoService$OperationResult;", "Ljava/io/InputStream;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class SecurityFileCryptoService$openDecryptInputStream$1 extends Lambda implements Function0<SecurityFileCryptoService.c<InputStream>> {
    final /* synthetic */ File $file;
    final /* synthetic */ SecurityFileCryptoService this$0;

    public SecurityFileCryptoService$openDecryptInputStream$1(SecurityFileCryptoService r100, File r101) {
        this.this$0 = r100;
        this.$file = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SecurityFileCryptoService.c<InputStream> invoke() {
        return new SecurityFileCryptoService.c(this.this$0.f428072b.D5(this.$file), true, null, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SecurityFileCryptoService.c<InputStream> invoke() {
        return invoke();
    }
}
