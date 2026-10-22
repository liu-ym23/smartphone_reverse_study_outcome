package com.bytedance.applet.debug.view;

import com.larus.common.apphost.AppHost;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugVersionManagerActivity$submitChangedConfigs$2", f = "AppletDebugVersionManagerActivity.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugVersionManagerActivity$submitChangedConfigs$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<AppletDebugVersionAdapter.c> $changes;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppletDebugVersionManagerActivity this$0;

    public AppletDebugVersionManagerActivity$submitChangedConfigs$2(AppletDebugVersionManagerActivity r1, List<AppletDebugVersionAdapter.c> r2, Continuation<? super AppletDebugVersionManagerActivity$submitChangedConfigs$2> r3) {
        this.this$0 = r1;
        this.$changes = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        AppletDebugVersionManagerActivity$submitChangedConfigs$2 r0 = new AppletDebugVersionManagerActivity$submitChangedConfigs$2(this.this$0, this.$changes, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Activity, com.bytedance.applet.debug.view.AppletDebugVersionManagerActivity] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
    L13:
        Object r8 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r7).booleanValue()));     // Catch: Throwable -> L15
    L17:
        ?? r2 = this.this$0;
        if (Result.isSuccess-impl(r8) == false) goto L27;
        boolean r3 = ((Boolean) r8).booleanValue();
        AppletDebugVersionManagerActivity.O1(r2);
        if (r3 == false) goto L22;
        t19.s.a.g(AppHost.a.getApplication(), 2131894364, false);
    L23:
        if (r3 == false) goto L25;
        int r4 = 1001;
    L26:
        r2.setResult(r4);
        r2.finish();
        goto L27
    L25:
        r4 = -1;
        goto L26
    L22:
        t19.s.a.g(AppHost.a.getApplication(), 2131894365, false);
    L27:
        AppletDebugVersionManagerActivity r5 = this.this$0;
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L31;
        AppletDebugVersionManagerActivity.O1(r5);
        com.bytedance.ai.utils.g.a.e("AppletDebugVersionManager", "submitChangedConfigs failed: " + ExceptionsKt.stackTraceToString(r9));
        t19.s.a.g(AppHost.a.getApplication(), 2131894363, false);
    L31:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        AppletDebugVersionManagerActivity.P1(this.this$0);
        List<AppletDebugVersionAdapter.c> r11 = this.$changes;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
        CoroutineDispatcher r12 = Dispatchers.getIO();     // Catch: Throwable -> L15
        AppletDebugVersionManagerActivity$submitChangedConfigs$2$1$1 r13 = new AppletDebugVersionManagerActivity$submitChangedConfigs$2$1$1(r11, null);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r7 = BuildersKt.withContext(r12, r13, this);     // Catch: Throwable -> L15
        if (r7 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
