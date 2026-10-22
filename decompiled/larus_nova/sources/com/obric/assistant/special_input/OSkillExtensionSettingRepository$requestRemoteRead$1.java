package com.obric.assistant.special_input;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
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

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.OSkillExtensionSettingRepository$requestRemoteRead$1", f = "OSkillExtensionSettingRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OSkillExtensionSettingRepository$requestRemoteRead$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    int label;

    public OSkillExtensionSettingRepository$requestRemoteRead$1(String r100, Continuation<? super OSkillExtensionSettingRepository$requestRemoteRead$1> r101) {
        this.$reason = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OSkillExtensionSettingRepository$requestRemoteRead$1(this.$reason, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OSkillExtensionSettingRepository$requestRemoteRead$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r100);
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = this.$reason;
    L27:
        AtomicBoolean r102 = OSkillExtensionSettingRepository.f392548f;     // Catch: Throwable -> L18
        r102.set(false);     // Catch: Throwable -> L18
        ReentrantLock r103 = OSkillExtensionSettingRepository.f392546d;     // Catch: Throwable -> L18
        r103.lock();     // Catch: Throwable -> L18
        OSkillExtensionSettingRepository r104 = OSkillExtensionSettingRepository.f392543a;     // Catch: Throwable -> L15
        String r105 = (String) r101.element;     // Catch: Throwable -> L15
        r104.getClass();     // Catch: Throwable -> L15
        OSkillExtensionSettingRepository.f(r105);     // Catch: Throwable -> L15
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r103.unlock();     // Catch: Throwable -> L18
        r101.element = "pending_force_refresh";     // Catch: Throwable -> L18
        if (r102.get() == true) goto L27;
        OSkillExtensionSettingRepository.f392547e.set(false);
        if (r102.get() == false) goto L14;
        OSkillExtensionSettingRepository.d("pending_force_refresh", false);
    L14:
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        r103.unlock();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        OSkillExtensionSettingRepository.f392547e.set(false);
        if (OSkillExtensionSettingRepository.f392548f.get() == false) goto L22;
        OSkillExtensionSettingRepository.f392543a.getClass();
        OSkillExtensionSettingRepository.d("pending_force_refresh", false);
    L22:
        throw th;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
