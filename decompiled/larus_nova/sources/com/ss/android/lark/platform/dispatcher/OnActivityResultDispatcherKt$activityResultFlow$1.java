package com.ss.android.lark.platform.dispatcher;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.k;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/activity/result/ActivityResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.platform.dispatcher.OnActivityResultDispatcherKt$activityResultFlow$1", f = "OnActivityResultDispatcher.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
final class OnActivityResultDispatcherKt$activityResultFlow$1 extends SuspendLambda implements Function2<k<? super ActivityResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $this_activityResultFlow;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k<ActivityResult> f438644a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(k<? super ActivityResult> r100) {
            this.f438644a = r100;
        }

        @Override // com.ss.android.lark.platform.dispatcher.d
        public final boolean onActivityResult(int r100, int r101, Intent r102) {
            if (r100 == 0) goto L5;
            return false;
        L5:
            Object r103 = this.f438644a.mo10962trySendJP2dKIU(new ActivityResult(r101, r102));
            if ((r103 instanceof kotlinx.coroutines.channels.g.c) == false) goto L10;
            kotlinx.coroutines.channels.g.a(r103);
            return true;
        L10:
            return true;
        }
    }

    public OnActivityResultDispatcherKt$activityResultFlow$1(c r100, Continuation<? super OnActivityResultDispatcherKt$activityResultFlow$1> r101) {
        this.$this_activityResultFlow = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        OnActivityResultDispatcherKt$activityResultFlow$1 r102 = new OnActivityResultDispatcherKt$activityResultFlow$1(this.$this_activityResultFlow, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k<? super ActivityResult> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k<? super ActivityResult> r100, Continuation<? super Unit> r101) {
        return ((OnActivityResultDispatcherKt$activityResultFlow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        k r103 = (k) this.L$0;
        final a r104 = new a(r103);
        this.$this_activityResultFlow.a(r104);
        final c r105 = this.$this_activityResultFlow;
        Function0<Unit> r106 = new AnonymousClass1(r105, r104);
        this.label = 1;
        if (ProduceKt.a(r103, r106, this) != r101) goto L12;
        return r101;
    }
}
