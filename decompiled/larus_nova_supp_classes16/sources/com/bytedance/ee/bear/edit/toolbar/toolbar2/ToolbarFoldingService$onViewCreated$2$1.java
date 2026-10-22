package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.edit.toolbar.toolbar2.ToolbarFoldingService$onViewCreated$2$1", f = "ToolbarFoldingService.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
final class ToolbarFoldingService$onViewCreated$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ v.b $delegate;
    final /* synthetic */ LifecycleOwner $this_run;
    int label;
    final /* synthetic */ v this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.edit.toolbar.toolbar2.ToolbarFoldingService$onViewCreated$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.edit.toolbar.toolbar2.ToolbarFoldingService$onViewCreated$2$1$1", f = "ToolbarFoldingService.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ v.b $delegate;
        int label;
        final /* synthetic */ v this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.edit.toolbar.toolbar2.ToolbarFoldingService$onViewCreated$2$1$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ v a;
            public final /* synthetic */ v.b b;

            public a(v r1, v.b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r2, Continuation r3) {
                v r4 = this.a;
                v.a(r4, (WindowLayoutInfo) r2, this.b);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Activity r1, v r2, v.b r3, Continuation<? super AnonymousClass1> r4) {
            this.$activity = r1;
            this.this$0 = r2;
            this.$delegate = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$activity, this.this$0, this.$delegate, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Flow r7 = WindowInfoTracker.Companion.getOrCreate(this.$activity).windowLayoutInfo(this.$activity);
            a r2 = new a(this.this$0, this.$delegate);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public ToolbarFoldingService$onViewCreated$2$1(LifecycleOwner r1, Activity r2, v r3, v.b r4, Continuation<? super ToolbarFoldingService$onViewCreated$2$1> r5) {
        this.$this_run = r1;
        this.$activity = r2;
        this.this$0 = r3;
        this.$delegate = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ToolbarFoldingService$onViewCreated$2$1(this.$this_run, this.$activity, this.this$0, this.$delegate, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        Lifecycle r10 = this.$this_run.getLifecycle();
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        AnonymousClass1 r3 = new AnonymousClass1(this.$activity, this.this$0, this.$delegate, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.a(r10, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
