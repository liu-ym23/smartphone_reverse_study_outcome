package com.bytedance.android.livesdk.livecommerce.utils;

import android.util.Base64;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.utils.FileUtils$base64ToByteArray$2", f = "FileUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FileUtils$base64ToByteArray$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ String $base64Str;
    final /* synthetic */ int $flags;
    private /* synthetic */ Object L$0;
    int label;

    public FileUtils$base64ToByteArray$2(String r1, int r2, Continuation r3) {
        this.$base64Str = r1;
        this.$flags = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "completion");
        FileUtils$base64ToByteArray$2 r0 = new FileUtils$base64ToByteArray$2(this.$base64Str, this.$flags, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L7
        Object r7 = Result.constructor-impl(Base64.decode(this.$base64Str, this.$flags));     // Catch: Throwable -> L7
    L10:
        if (Result.exceptionOrNull-impl(r7) == null) goto L13;
        dm.a.a("FileUtils").b("base64ToByteArray error", null);
    L13:
        if (Result.isFailure-impl(r7) == true) goto L15;
        return r7;
    L15:
        return null;
    L7:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
