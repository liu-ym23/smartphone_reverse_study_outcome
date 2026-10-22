package com.larus.tts.impl;

import android.widget.PopupWindow;
import com.larus.audio.ttsV2.TtsGuideDelegate;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$initTtsGuideCheck$1", f = "ChatTitleTtsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleTtsComponent$initTtsGuideCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    public ChatTitleTtsComponent$initTtsGuideCheck$1(ChatTitleTtsComponent r100, Continuation<? super ChatTitleTtsComponent$initTtsGuideCheck$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatTitleTtsComponent$initTtsGuideCheck$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChatTitleTtsComponent$initTtsGuideCheck$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_tts_impl_ChatTitleTtsComponent$initTtsGuideCheck$1_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.tts.impl.t] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.tts.impl.u] */
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
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        TtsGuideDelegate r101 = TtsGuideDelegate.f289898b;
        ?? r102 = new t();
        final ChatTitleTtsComponent r103 = this.this$0;
        r101.b(r102, new u(r103));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
