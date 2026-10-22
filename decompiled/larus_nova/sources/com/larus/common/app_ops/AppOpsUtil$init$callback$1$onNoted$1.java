package com.larus.common.app_ops;

import android.app.SyncNotedAppOp;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.app_ops.AppOpsUtil$init$callback$1$onNoted$1", f = "AppOpsUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppOpsUtil$init$callback$1$onNoted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Throwable> $fullStackTrace;
    final /* synthetic */ SyncNotedAppOp $op;
    final /* synthetic */ Ref.ObjectRef<String> $serviceName;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AppOpsUtil$init$callback$1$onNoted$1(List<? extends Throwable> r100, SyncNotedAppOp r101, Ref.ObjectRef<String> r102, Continuation<? super AppOpsUtil$init$callback$1$onNoted$1> r103) {
        this.$fullStackTrace = r100;
        this.$op = r101;
        this.$serviceName = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AppOpsUtil$init$callback$1$onNoted$1(this.$fullStackTrace, this.$op, this.$serviceName, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AppOpsUtil$init$callback$1$onNoted$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        String r101 = "";
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r100);
        Ref.ObjectRef r102 = new Ref.ObjectRef();     // Catch: Exception -> L19
        r102.element = "";     // Catch: Exception -> L19
        List<Throwable> r103 = this.$fullStackTrace;     // Catch: Exception -> L19
        if (r103 == null) goto L8;
        r102.element = e.b(r103);     // Catch: Exception -> L19
    L8:
        String r104 = this.$op.getAttributionTag();     // Catch: Exception -> L19
        if (r104 == null) goto L17;
        Ref.ObjectRef<String> r105 = this.$serviceName;     // Catch: Exception -> L19
        c r106 = a.f326236a.c(this.$op.getOp(), r104);     // Catch: Exception -> L19
        T r107 = r101;
        if (r106 == null) goto L16;
        String r108 = r106.f326266c;     // Catch: Exception -> L19
        if (r108 != null) goto L15;
        r107 = r101;
        goto L16
    L15:
        r107 = r108;
    L16:
        r105.element = r107;     // Catch: Exception -> L19
    L17:
        JSONObject r109 = new JSONObject();     // Catch: Exception -> L19
        r109.put("opCode", this.$op.getOp());     // Catch: Exception -> L19
        r109.put("type", "onNoted");     // Catch: Exception -> L19
        r109.put("message", r102.element);     // Catch: Exception -> L19
        r109.put("serviceName", this.$serviceName.element);     // Catch: Exception -> L19
        r109.put("dealType", 3);     // Catch: Exception -> L19
        a r110 = a.f326236a;     // Catch: Exception -> L19
        r109.put("check_op", a.a(this.$op.getOp()));     // Catch: Exception -> L19
        a.j(r109);     // Catch: Exception -> L19
        FLogger.f375446a.e("AppOpsUtil", r109.toString());     // Catch: Exception -> L19
    L22:
        return Unit.INSTANCE;
    L19:
        e = move-exception;
        FLogger.f375446a.e("AppOpsUtil", "err occur:" + e.getMessage());
        goto L22
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
