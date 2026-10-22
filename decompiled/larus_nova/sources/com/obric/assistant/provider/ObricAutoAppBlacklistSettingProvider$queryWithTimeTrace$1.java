package com.obric.assistant.provider;

import android.database.Cursor;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.reporter.IObricReporter;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {0}, l = {151}, m = "invokeSuspend", n = {DyPayConstant.KEY_START_TIME}, s = {"J$0"})
public final class ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Cursor>, Object> $block;
    final /* synthetic */ String $methodName;
    final /* synthetic */ CompletableDeferred<Cursor> $result;
    long J$0;
    int label;
    final /* synthetic */ ObricAutoAppBlacklistSettingProvider this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1(String r100, Function1<? super Continuation<? super Cursor>, ? extends Object> r101, CompletableDeferred<Cursor> r102, ObricAutoAppBlacklistSettingProvider r103, Continuation<? super ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1> r104) {
        this.$methodName = r100;
        this.$block = r101;
        this.$result = r102;
        this.this$0 = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1(this.$methodName, this.$block, this.$result, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 != 1) goto L11;
        long r102 = this.J$0;
        ResultKt.throwOnFailure(r110);     // Catch: Exception -> L8
    L17:
        Cursor r111 = (Cursor) r110;     // Catch: Exception -> L8
        long r112 = SystemClock.elapsedRealtime() - r102;     // Catch: Exception -> L8
        this.$result.complete(r111);     // Catch: Exception -> L8
        FLogger.f375446a.i("ObricAutoAppBlacklistSettingProvider", "query, " + this.$methodName + ", end, cost = " + r112 + "ms, " + r111);     // Catch: Exception -> L8
        ObricAutoAppBlacklistSettingProvider r113 = this.this$0;     // Catch: Exception -> L8
        String r103 = this.$methodName;     // Catch: Exception -> L8
        List<k> r104 = ObricAutoAppBlacklistSettingProvider.f391174b;     // Catch: Exception -> L8
        r113.getClass();     // Catch: Exception -> L8
        IObricReporter.f391335a.getClass();     // Catch: Exception -> L8
        IObricReporter r105 = IObricReporter.a.a();     // Catch: Exception -> L8
        if (r105 == null) goto L27;
        IObricReporter.b.a(r105, "OAuto_Settings", r103, r112, true, 16);     // Catch: Exception -> L8
    L27:
        return Unit.INSTANCE;
    L8:
        e = e;
        long r106 = r102;
    L23:
        long r114 = SystemClock.elapsedRealtime() - r106;
        this.$result.complete(null);
        FLogger.f375446a.e("ObricAutoAppBlacklistSettingProvider", "query, " + this.$methodName + ", failed, cost = " + r114 + "ms", e);
        ObricAutoAppBlacklistSettingProvider r115 = this.this$0;
        String r107 = this.$methodName;
        List<k> r108 = ObricAutoAppBlacklistSettingProvider.f391174b;
        r115.getClass();
        IObricReporter.f391335a.getClass();
        IObricReporter r109 = IObricReporter.a.a();
        if (r109 == null) goto L27;
        IObricReporter.b.a(r109, "OAuto_Settings", r107, r114, false, 16);
        goto L27
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r110);
        r106 = SystemClock.elapsedRealtime();
        FLogger.f375446a.i("ObricAutoAppBlacklistSettingProvider", "query, " + this.$methodName + ", start");     // Catch: Exception -> L22
        Function1<Continuation<? super Cursor>, Object> r116 = this.$block;     // Catch: Exception -> L22
        this.J$0 = r106;     // Catch: Exception -> L22
        this.label = 1;     // Catch: Exception -> L22
        r110 = r116.invoke(this);     // Catch: Exception -> L22
        if (r110 != r100) goto L16;
        return r100;
    L16:
        r102 = r106;
    L22:
        e = e;
        goto L23
    }
}
