package com.lark.kmp.logger;

import android.os.Process;
import com.ss.android.rust.molten.ffi.LogConfig;
import com.ss.android.rust.molten.ffi.MoltenLogStatus;
import com.ss.android.rust.molten.ffi.MoltenLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.lark.kmp.logger.LarkLogger$log$1", f = "LarkLogger.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LarkLogger$log$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $formattedMessage;
    final /* synthetic */ LogLevel $level;
    final /* synthetic */ String $tag;
    final /* synthetic */ String $threadName;
    int label;

    public LarkLogger$log$1(LogLevel r100, String r101, String r102, String r103, Continuation<? super LarkLogger$log$1> r104) {
        this.$level = r100;
        this.$formattedMessage = r101;
        this.$tag = r102;
        this.$threadName = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LarkLogger$log$1(this.$level, this.$formattedMessage, this.$tag, this.$threadName, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LarkLogger$log$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L65;
        ResultKt.throwOnFailure(r210);
        LarkLogger r100 = LarkLogger.f278603a;
        MoltenLogger r101 = LarkLogger.f278607e;
        if (r101 == null) goto L7;
    L6:
        MoltenLogger r102 = r101;
    L35:
        if (r102 == null) goto L37;
        LarkLogger r103 = LarkLogger.f278603a;
        int r104 = LarkLogger.a.f278608a[this.$level.ordinal()];
        if (r104 != 2) goto L41;
        com.ss.android.rust.molten.ffi.LogLevel r105 = com.ss.android.rust.molten.ffi.LogLevel.Debug;
    L54:
        MoltenLogStatus r106 = MoltenLogger.logV2$default(r102, r105, this.$formattedMessage, this.$tag, null, null, System.currentTimeMillis(), null, null, 0, null, this.$threadName, Process.myPid(), 728, null);
        if (r106 == null) goto L60;
        if (r106 == MoltenLogStatus.Ok) goto L60;
        r106.toString();
    L60:
        return Unit.INSTANCE;
    L41:
        if (r104 != 3) goto L43;
        r105 = com.ss.android.rust.molten.ffi.LogLevel.Debug;
        goto L54
    L43:
        if (r104 != 4) goto L45;
        r105 = com.ss.android.rust.molten.ffi.LogLevel.Info;
        goto L54
    L45:
        if (r104 != 5) goto L47;
        r105 = com.ss.android.rust.molten.ffi.LogLevel.Warn;
        goto L54
    L47:
        if (r104 == 6) goto L49;
        r105 = com.ss.android.rust.molten.ffi.LogLevel.Info;
        goto L54
    L49:
        r105 = com.ss.android.rust.molten.ffi.LogLevel.Error;
        goto L54
    L37:
        return Unit.INSTANCE;
    L7:
        r102 = null;
        if (LarkLogger.f278606d.invoke().booleanValue() == false) goto L35;
        monitor-enter(r100);
        r101 = LarkLogger.f278607e;     // Catch: Throwable -> L61
        if (r101 != null) goto L33;
        LogConfig r107 = LarkLogger.f278605c;     // Catch: Throwable -> L61
        if (r107 != null) goto L68;
    L32:
        r101 = null;
        goto L33
    L68:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L17
        Object r109 = Result.m9449constructorimpl(MoltenLogger.Companion.newWithConfig(r107));     // Catch: Throwable -> L17
    L20:
        if (Result.m9456isSuccessimpl(r109) == false) goto L23;
        MoltenLogger r110 = (MoltenLogger) r109;     // Catch: Throwable -> L61
        r107.getName();     // Catch: Throwable -> L61
        r107.getPath();     // Catch: Throwable -> L61
    L23:
        if (Result.m9452exceptionOrNullimpl(r109) == null) goto L26;
        r107.getName();     // Catch: Throwable -> L61
        r107.getPath();     // Catch: Throwable -> L61
    L26:
        if (Result.m9455isFailureimpl(r109) == false) goto L28;
        r109 = null;
    L28:
        r101 = (MoltenLogger) r109;     // Catch: Throwable -> L61
        if (r101 == null) goto L32;
        LarkLogger.f278607e = r101;     // Catch: Throwable -> L61
    L17:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L61
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L61
    L33:
        monitor-exit(r100);
    L61:
        th = move-exception;
        throw th;
    L65:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
