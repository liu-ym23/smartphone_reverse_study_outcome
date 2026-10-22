package com.larus.bmhome.social.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.j;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.b;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.utils.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.social.utils.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.utils.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {171}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Lifecycle r100, Lifecycle.State r101, CoroutineScope r102, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r103, Continuation<? super AnonymousClass1> r104) {
            this.$this_repeatOnLifecycle = r100;
            this.$state = r101;
            this.$$this$coroutineScope = r102;
            this.$block = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.lifecycle.LifecycleObserver, com.larus.bmhome.social.utils.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
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
            if (r101 == 0) goto L12;
            if (r101 != 1) goto L11;
            Function2 r102 = (Function2) this.L$5;
            CoroutineScope r103 = (CoroutineScope) this.L$4;
            Lifecycle r104 = (Lifecycle) this.L$3;
            Lifecycle.State r105 = (Lifecycle.State) this.L$2;
            Ref.ObjectRef r106 = (Ref.ObjectRef) this.L$1;
            Ref.ObjectRef r107 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L8
        L23:
            Job r108 = (Job) r107.element;
            if (r108 == null) goto L26;
            Job.DefaultImpls.cancel$default(r108, null, 1, null);
        L26:
            LifecycleEventObserver r109 = (LifecycleEventObserver) r106.element;
            if (r109 == null) goto L30;
            this.$this_repeatOnLifecycle.removeObserver(r109);
        L30:
            return Unit.INSTANCE;
        L8:
            th = th;
        L33:
            Job r111 = (Job) r107.element;
            if (r111 == null) goto L36;
            Job.DefaultImpls.cancel$default(r111, null, 1, null);
        L36:
            LifecycleEventObserver r112 = (LifecycleEventObserver) r106.element;
            if (r112 == null) goto L39;
            this.$this_repeatOnLifecycle.removeObserver(r112);
        L39:
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r110);
            if (this.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
            final Ref.ObjectRef r113 = new Ref.ObjectRef();
            Ref.ObjectRef r114 = new Ref.ObjectRef();
            Lifecycle.State r115 = this.$state;     // Catch: Throwable -> L31
            Lifecycle r116 = this.$this_repeatOnLifecycle;     // Catch: Throwable -> L31
            final CoroutineScope r117 = this.$$this$coroutineScope;     // Catch: Throwable -> L31
            final Function2<CoroutineScope, Continuation<? super Unit>, Object> r118 = this.$block;     // Catch: Throwable -> L31
            this.L$0 = r113;     // Catch: Throwable -> L31
            this.L$1 = r114;     // Catch: Throwable -> L31
            this.L$2 = r115;     // Catch: Throwable -> L31
            this.L$3 = r116;     // Catch: Throwable -> L31
            this.L$4 = r117;     // Catch: Throwable -> L31
            this.L$5 = r118;     // Catch: Throwable -> L31
            this.label = 1;     // Catch: Throwable -> L31
            final j r119 = new j(IntrinsicsKt.intercepted(this), 1);     // Catch: Throwable -> L31
            r119.C();     // Catch: Throwable -> L31
            Lifecycle.Event.Companion r120 = Lifecycle.Event.Companion;     // Catch: Throwable -> L31
            final Lifecycle.Event r121 = r120.upTo(r115);     // Catch: Throwable -> L31
            final Lifecycle.Event r122 = r120.downFrom(r115);     // Catch: Throwable -> L31
            final MutexImpl r123 = b.a();     // Catch: Throwable -> L31
            ?? r124 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(r121, r113, r117, r122, r119, r123, r118);     // Catch: Throwable -> L31
            r114.element = r124;     // Catch: Throwable -> L31
            Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");     // Catch: Throwable -> L31
            r116.addObserver(r124);     // Catch: Throwable -> L31
            Object r125 = r119.B();     // Catch: Throwable -> L31
            if (r125 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
            DebugProbesKt.probeCoroutineSuspended(this);     // Catch: Throwable -> L31
        L20:
            if (r125 != r100) goto L22;
            return r100;
        L22:
            r107 = r113;
            r106 = r114;
        L31:
            th = th;
            r107 = r113;
            r106 = r114;
            goto L33
        L15:
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle r100, Lifecycle.State r101, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> r103) {
        this.$this_repeatOnLifecycle = r100;
        this.$state = r101;
        this.$block = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 r102 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        CoroutineScope r102 = (CoroutineScope) this.L$0;
        MainCoroutineDispatcher r111 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r103 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, r102, this.$block, null);
        this.label = 1;
        if (BuildersKt.withContext(r111, r103, this) != r100) goto L12;
        return r100;
    }
}
