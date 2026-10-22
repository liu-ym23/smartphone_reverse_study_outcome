package com.larus.bot.impl.feature.health;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.health.ChatHealthTipFragmentManager$judgeShouldShowDialog$1", f = "ChatHealthTipFragmentManager.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
final class ChatHealthTipFragmentManager$judgeShouldShowDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $backListener;
    final /* synthetic */ Function0<Unit> $showDialogCallback;
    final /* synthetic */ WeakReference<View> $view;
    int label;

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.health.ChatHealthTipFragmentManager$judgeShouldShowDialog$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.health.ChatHealthTipFragmentManager$judgeShouldShowDialog$1$1", f = "ChatHealthTipFragmentManager.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $backListener;
        final /* synthetic */ Function0<Unit> $showDialogCallback;
        final /* synthetic */ WeakReference<View> $view;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function0<Unit> r100, WeakReference<View> r101, Function1<? super String, Unit> r102, Continuation<? super AnonymousClass1> r103) {
            this.$showDialogCallback = r100;
            this.$view = r101;
            this.$backListener = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$showDialogCallback, this.$view, this.$backListener, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.bot.impl.feature.health.f] */
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
            g r103 = g.f319343a;
            final Function0<Unit> r104 = this.$showDialogCallback;
            final WeakReference<View> r105 = this.$view;
            final Function1<String, Unit> r106 = this.$backListener;
            ?? r107 = new f(r104, r105, r106);
            this.label = 1;
            if (g.a(r103, r107, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatHealthTipFragmentManager$judgeShouldShowDialog$1(Function0<Unit> r100, WeakReference<View> r101, Function1<? super String, Unit> r102, Continuation<? super ChatHealthTipFragmentManager$judgeShouldShowDialog$1> r103) {
        this.$showDialogCallback = r100;
        this.$view = r101;
        this.$backListener = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatHealthTipFragmentManager$judgeShouldShowDialog$1(this.$showDialogCallback, this.$view, this.$backListener, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChatHealthTipFragmentManager$judgeShouldShowDialog$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        CoroutineDispatcher r103 = Dispatchers.getIO();
        AnonymousClass1 r104 = new AnonymousClass1(this.$showDialogCallback, this.$view, this.$backListener, null);
        this.label = 1;
        if (BuildersKt.withContext(r103, r104, this) != r101) goto L12;
        return r101;
    }
}
