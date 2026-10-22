package com.bytedance.android.livesdk.livecommerce.utils;

import android.util.Base64;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.utils.FileUtils$encodeFileToBase64$2", f = "FileUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FileUtils$encodeFileToBase64$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ File $file;
    private /* synthetic */ Object L$0;
    int label;

    public FileUtils$encodeFileToBase64$2(File r1, Continuation r2) {
        this.$file = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        FileUtils$encodeFileToBase64$2 r0 = new FileUtils$encodeFileToBase64$2(this.$file, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L26
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(this.$file);     // Catch: Throwable -> L26
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();     // Catch: Throwable -> L21
        byte[] r3 = new byte[DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION];     // Catch: Throwable -> L16
    L9:
        int r4 = r1.read(r3);     // Catch: Throwable -> L16
        if (r4 == (-1)) goto L12;
        r2.write(r3, 0, r4);     // Catch: Throwable -> L16
        goto L9
    L12:
        String r5 = Base64.encodeToString(r2.toByteArray(), 0);     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L26
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L26
    L29:
        if (Result.exceptionOrNull-impl(r6) == null) goto L32;
        dm.a.a("FileUtils").b("encodeFileToBase64 error", null);
    L32:
        if (Result.isFailure-impl(r6) == false) goto L35;
        return null;
    L35:
        return r6;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
