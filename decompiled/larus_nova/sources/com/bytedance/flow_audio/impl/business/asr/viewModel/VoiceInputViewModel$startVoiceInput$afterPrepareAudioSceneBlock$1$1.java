package com.bytedance.flow_audio.impl.business.asr.viewModel;

import com.bytedance.flow_audio.api.business.asr.voiceInput.FlowVoiceInputStatus;
import com.bytedance.flow_audio.api.service.common.IKMPFlowAudioSceneService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow_audio.impl.business.asr.viewModel.VoiceInputViewModel$startVoiceInput$afterPrepareAudioSceneBlock$1$1", f = "VoiceInputViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceInputViewModel$startVoiceInput$afterPrepareAudioSceneBlock$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ lw5.d $generator;
    int label;
    final /* synthetic */ VoiceInputViewModel this$0;

    public VoiceInputViewModel$startVoiceInput$afterPrepareAudioSceneBlock$1$1(VoiceInputViewModel r100, lw5.d r101, Continuation<? super VoiceInputViewModel$startVoiceInput$afterPrepareAudioSceneBlock$1$1> r102) {
        this.this$0 = r100;
        this.$generator = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new VoiceInputViewModel$startVoiceInput$afterPrepareAudioSceneBlock$1$1(this.this$0, this.$generator, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((VoiceInputViewModel$startVoiceInput$afterPrepareAudioSceneBlock$1$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.bytedance.flow_audio.impl.business.asr.viewModel.d] */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.bytedance.flow_audio.impl.business.asr.viewModel.c] */
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
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L66;
        ResultKt.throwOnFailure(r110);
        final VoiceInputViewModel r111 = this.this$0;
        final lw5.d r100 = this.$generator;
        if (r100 != null) goto L7;
        r100 = new b();
    L7:
        FlowVoiceInputStatus r101 = r111.f244036l;
        FlowVoiceInputStatus r102 = FlowVoiceInputStatus.Idle;
        final jw5.a r103 = null;
        String r104 = null;
        String r105 = "";
        if (r101 != r102) goto L10;
    L18:
        r111.h3("start voice input locked: status=" + r111.f244036l);
        jw5.a r106 = r111.f244032h;
        if (r106 == null) goto L22;
        String r107 = r106.getTaskId();
        if (r107 == null) goto L22;
    L30:
        r111.n3(FlowVoiceInputStatus.Starting);
        StringBuilder r108 = new StringBuilder("start voice input session resolved: taskId=");
        r108.append(r107);
        r108.append(" reused=");
        boolean r109 = true;
        if (r111.f244032h == null) goto L33;
        boolean r112 = true;
    L34:
        r108.append(r112);
        r111.h3(r108.toString());
        jw5.a r113 = r111.f244032h;
        if (r113 != null) goto L46;
        lw5.f r114 = r111.f244035k;
        if (r114 != null) goto L39;
        r111.H2("create voice input session failed: delegate is null taskId=".concat(r107));
        r113 = null;
    L44:
        if (r113 == null) goto L47;
        r113.v2(r111);
        r111.f244032h = r113;
        r111.l3("create session during start: taskId=".concat(r107));
    L47:
        if (r103 != null) goto L49;
        r111.H2("start ignored: no IFlowVoiceInputDelegate or session");
        r111.n3(r102);
    L64:
        return Unit.INSTANCE;
    L49:
        final ?? r115 = new c(r111, r103, r100);
        if (r111.f244027c == false) goto L55;
        ?? r116 = new d(r111, r103, r115);
        IKMPFlowAudioSceneService r117 = xw5.d.f565229a;
        if (r117 != null) goto L54;
        r111.l3("[activateAudioSceneResourceAsync] activate audio scene ignored: FlowAudioSceneService is null");
        goto L64
    L54:
        r111.h3("[activateAudioSceneResourceAsync] activate audio scene begin: scene=" + r111.f244026b);
        r117.L2(r111.f244026b, 0, new g(r111, r116));
        goto L64
    L55:
        IKMPFlowAudioSceneService r118 = xw5.d.f565229a;
        if (r118 != null) goto L58;
        r111.l3("activate audio scene ignored: FlowAudioSceneService is null");
    L62:
        r115.invoke();
        goto L64
    L58:
        r111.h3("activate audio scene begin: scene=" + r111.f244026b);
        xw5.f r119 = r118.m0(r111.f244026b);
        if (r119.f565230a == false) goto L61;
        r111.h3("activate audio scene success: scene=" + r111.f244026b + " hasResource=false");
        goto L62
    L61:
        r111.l3("activate audio scene failed: scene=" + r111.f244026b + " error=" + r119.f565231b);
        goto L62
    L39:
        r111.h3("create voice input session begin: taskId=".concat(r107));
        r113 = r114.K(r107, r114.b3(r107));
        StringBuilder r120 = new StringBuilder("create voice input session end: taskId=");
        r120.append(r107);
        r120.append(" created=");
        if (r113 != null) goto L43;
        r109 = false;
    L43:
        r120.append(r109);
        r111.h3(r120.toString());
    L46:
        r103 = r113;
        goto L47
    L33:
        r112 = false;
    L22:
        Function0<String> r121 = r111.f244028d;
        if (r121 == null) goto L25;
        String r122 = r121.invoke();
    L26:
        if (r122 == null) goto L29;
        r105 = r122;
    L29:
        r107 = r105;
        goto L30
    L25:
        r122 = null;
        goto L26
    L10:
        if (r101 == FlowVoiceInputStatus.Prepare) goto L18;
        StringBuilder r123 = new StringBuilder("start voice input ignored: status=");
        r123.append(r111.f244036l);
        r123.append(" currentTaskId=");
        jw5.a r124 = r111.f244032h;
        if (r124 == null) goto L14;
        r104 = r124.getTaskId();
    L14:
        if (r104 == null) goto L17;
        r105 = r104;
    L17:
        r123.append(r105);
        r111.l3(r123.toString());
        goto L64
    L66:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
