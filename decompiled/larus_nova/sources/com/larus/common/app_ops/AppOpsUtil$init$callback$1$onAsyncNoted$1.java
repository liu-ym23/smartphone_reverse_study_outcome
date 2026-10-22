package com.larus.common.app_ops;

import android.app.AsyncNotedAppOp;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.app_ops.AppOpsUtil$init$callback$1$onAsyncNoted$1", f = "AppOpsUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppOpsUtil$init$callback$1$onAsyncNoted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AsyncNotedAppOp $asyncOp;
    int label;

    public AppOpsUtil$init$callback$1$onAsyncNoted$1(AsyncNotedAppOp r100, Continuation<? super AppOpsUtil$init$callback$1$onAsyncNoted$1> r101) {
        this.$asyncOp = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AppOpsUtil$init$callback$1$onAsyncNoted$1(this.$asyncOp, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AppOpsUtil$init$callback$1$onAsyncNoted$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r100);
        Ref.ObjectRef r101 = new Ref.ObjectRef();     // Catch: Exception -> L23
        r101.element = "";     // Catch: Exception -> L23
        Ref.ObjectRef r102 = new Ref.ObjectRef();     // Catch: Exception -> L23
        r102.element = "";     // Catch: Exception -> L23
        Ref.ObjectRef r103 = new Ref.ObjectRef();     // Catch: Exception -> L23
        r103.element = "";     // Catch: Exception -> L23
        String r104 = this.$asyncOp.getAttributionTag();     // Catch: Exception -> L23
        if (r104 == null) goto L18;
        AsyncNotedAppOp r105 = this.$asyncOp;     // Catch: Exception -> L23
        if (Intrinsics.areEqual(r104, "busyTag") == false) goto L10;
        r101.element = "busyTag";     // Catch: Exception -> L23
        r102.element = "busyTag";     // Catch: Exception -> L23
        goto L18
    L10:
        c r106 = a.f326236a.c(r105.getOp(), r104);     // Catch: Exception -> L23
        if (r106 != null) goto L13;
        r101.element = "nullTag";     // Catch: Exception -> L23
        r102.element = "nullTag";     // Catch: Exception -> L23
        goto L18
    L13:
        r101.element = r106.f326265b;     // Catch: Exception -> L23
        List<? extends Throwable> r107 = r106.f326264a;     // Catch: Exception -> L23
        if (r107 == null) goto L16;
        T r108 = "" + e.b(r107);     // Catch: Exception -> L23
    L17:
        r102.element = r108;     // Catch: Exception -> L23
        r103.element = r106.f326266c;     // Catch: Exception -> L23
        goto L18
    L16:
        r108 = "";
    L18:
        JSONObject r109 = new JSONObject();     // Catch: Exception -> L23
        r109.put("opCode", this.$asyncOp.getOp());     // Catch: Exception -> L23
        r109.put("attributionTag", r101.element);     // Catch: Exception -> L23
        r109.put("message", this.$asyncOp.getMessage());     // Catch: Exception -> L23
        r109.put("type", "onAsyncNoted");     // Catch: Exception -> L23
        r109.put("asyncTime", this.$asyncOp.getTime());     // Catch: Exception -> L23
        r109.put("asyncuid", this.$asyncOp.getNotingUid());     // Catch: Exception -> L23
        a r110 = a.f326236a;     // Catch: Exception -> L23
        r109.put("check_op", a.a(this.$asyncOp.getOp()));     // Catch: Exception -> L23
        if (Intrinsics.areEqual(r102.element, "") == true) goto L21;
        r109.put("asyncStack", r102.element);     // Catch: Exception -> L23
    L21:
        r109.put("serviceName", r103.element);     // Catch: Exception -> L23
        a.j(r109);     // Catch: Exception -> L23
    L26:
        return Unit.INSTANCE;
    L23:
        e = move-exception;
        FLogger.f375446a.e("AppOpsUtil", "err occur:" + e.getMessage());
        goto L26
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
