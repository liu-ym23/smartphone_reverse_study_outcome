package com.larus.avlink.e;

import com.larus.avlink.model.DoraVisionBizScene;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.e.DoraECameraDelegate$doUploadFileByHttp$1", f = "DoraECameraDelegate.kt", i = {}, l = {913}, m = "invokeSuspend", n = {}, s = {})
final class DoraECameraDelegate$doUploadFileByHttp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b49.h $imageInfo;
    final /* synthetic */ List<f98.l> $images;
    final /* synthetic */ int $mode;
    int label;

    public DoraECameraDelegate$doUploadFileByHttp$1(b49.h r100, int r101, List<f98.l> r102, Continuation<? super DoraECameraDelegate$doUploadFileByHttp$1> r103) {
        this.$imageInfo = r100;
        this.$mode = r101;
        this.$images = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraECameraDelegate$doUploadFileByHttp$1(this.$imageInfo, this.$mode, this.$images, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraECameraDelegate$doUploadFileByHttp$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.avlink.e.g] */
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
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L22:
        if (((m.a) r110).f291794a == true) goto L25;
        FLogger.f375446a.e("DoraE_Camera", "doUploadFile failed. imageId: " + this.$imageInfo.f17668a);
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        m r102 = m.f291793a;
        b49.h r111 = this.$imageInfo;
        int r103 = this.$mode;
        List<f98.l> r104 = this.$images;
        String r105 = a98.a.f2298a;
        String r106 = a98.a.f2299b;
        l r107 = l.f291786a;
        int r108 = l.d(Boxing.boxInt(r103));
        DoraVisionBizScene.a r109 = DoraVisionBizScene.Companion;
        int r112 = this.$mode;
        r109.getClass();
        if (r112 != 2) goto L11;
        DoraVisionBizScene r113 = DoraVisionBizScene.LIVE_AI;
    L15:
        if (r113 == null) goto L17;
        Integer r114 = Boxing.boxInt(r113.getValue());
    L18:
        int r115 = o.b();
        f r116 = new f();
        final b49.h r117 = this.$imageInfo;
        ?? r118 = new g(r117);
        this.label = 1;
        r110 = r102.a(r111, r103, r104, r105, r106, r108, r114, r115, r116, r118, this);
        if (r110 != r100) goto L22;
        return r100;
    L17:
        r114 = null;
        goto L18
    L11:
        if (r112 == 17) goto L13;
        r113 = DoraVisionBizScene.DEFAULT;
        goto L15
    L13:
        r113 = DoraVisionBizScene.ENV_OBSERVE;
        goto L15
    }
}
