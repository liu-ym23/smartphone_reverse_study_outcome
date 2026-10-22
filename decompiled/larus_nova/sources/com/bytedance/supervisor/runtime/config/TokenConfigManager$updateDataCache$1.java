package com.bytedance.supervisor.runtime.config;

import android.content.Context;
import com.bytedance.supervisor.runtime.common.Logger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.IOException;
import kf7.e;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import lf7.d;
import nf7.c;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.bytedance.supervisor.runtime.config.TokenConfigManager$updateDataCache$1", f = "TokenConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TokenConfigManager$updateDataCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $data;
    int label;

    public TokenConfigManager$updateDataCache$1(Context r100, String r101, Continuation<? super TokenConfigManager$updateDataCache$1> r102) {
        this.$context = r100;
        this.$data = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TokenConfigManager$updateDataCache$1(this.$context, this.$data, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TokenConfigManager$updateDataCache$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r100);
        int r101 = c.f518961a;
        Context r102 = this.$context;
        String r103 = this.$data;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "data");
        Intrinsics.checkNotNullParameter("token_config_cache", "fileName");
        lf7.b r104 = d.f509087a;     // Catch: IOException -> L13
        if (r104 != null) goto L8;
        e r105 = null;
    L9:
        if (r105 == null) goto L19;
        r105.b(r102, r103);     // Catch: IOException -> L13
    L19:
        return Unit.INSTANCE;
    L8:
        r105 = r104.f509068b;     // Catch: IOException -> L13
    L13:
        e = move-exception;
        int r106 = Logger.f270338a;
        Logger.b("file", e.getMessage());
        int r107 = nf7.d.f518962a;
        String r108 = e.getMessage();
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        nf7.d.b("update_local_data", r108, null);
        goto L19
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
