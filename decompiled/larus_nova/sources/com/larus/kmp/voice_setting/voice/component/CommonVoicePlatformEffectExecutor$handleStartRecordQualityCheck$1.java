package com.larus.kmp.voice_setting.voice.component;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.component.CommonVoicePlatformEffectExecutor$handleStartRecordQualityCheck$1", f = "VoicePlatformEffectExecutor.kt", i = {0}, l = {238}, m = "invokeSuspend", n = {"modelFile"}, s = {"L$0"})
final class CommonVoicePlatformEffectExecutor$handleStartRecordQualityCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n0 $request;
    Object L$0;
    int label;
    final /* synthetic */ i this$0;

    public CommonVoicePlatformEffectExecutor$handleStartRecordQualityCheck$1(i r100, n0 r101, Continuation<? super CommonVoicePlatformEffectExecutor$handleStartRecordQualityCheck$1> r102) {
        this.this$0 = r100;
        this.$request = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommonVoicePlatformEffectExecutor$handleStartRecordQualityCheck$1(this.this$0, this.$request, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommonVoicePlatformEffectExecutor$handleStartRecordQualityCheck$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.larus.kmp.voice_setting.voice.component.k] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.kmp.voice_setting.voice.component.l] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.kmp.voice_setting.voice.component.m] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        com.larus.kmp.voice_setting.platform.c0 r102 = (com.larus.kmp.voice_setting.platform.c0) this.L$0;
        ResultKt.throwOnFailure(r110);
    L14:
        boolean r111 = ((Boolean) r110).booleanValue();
        this.this$0.b("[record] copy model result=" + r111 + " session=" + this.$request.f352385e);
        com.larus.kmp.voice_setting.platform.c0 r103 = r102;
    L16:
        com.larus.kmp.voice_setting.platform.c0 r104 = this.this$0.f352274b.f351697c.a(this.$request.f352382b);
        this.this$0.b("[record] checkAudioQuality record=" + StringsKt.substringAfterLast$default(r104.f351673a, '/', null, 2, null) + " session=" + this.$request.f352385e);
        final i r112 = this.this$0;
        com.larus.kmp.voice_setting.platform.t0 r105 = r112.f352274b.f351698d;
        final n0 r106 = this.$request;
        r105.c(r106.f352381a, r104, r103, new k(r112, r106), new l(r112, r106), new m(r112, r106));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        com.larus.kmp.voice_setting.platform.c0 r113 = this.this$0.f352274b.f351697c.d(this.$request.f352384d);
        if (this.this$0.f352274b.f351697c.c(r113) == true) goto L15;
        com.larus.kmp.voice_setting.platform.b0 r107 = this.this$0.f352274b.f351697c;
        String r108 = this.$request.f352383c;
        this.L$0 = r113;
        this.label = 1;
        Object r109 = r107.b(r108, r113, this);
        if (r109 != r100) goto L13;
        return r100;
    L13:
        r102 = r113;
        r110 = r109;
        goto L14
    L15:
        r103 = r113;
        goto L16
    }
}
