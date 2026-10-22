package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.e;
import vv4.k;

/* JADX INFO: loaded from: classes35.dex */
public final class RenderGoneHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<k.a> f411285a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Channel<Pair<Boolean, Integer>> f411286b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f411287c;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper$1", f = "RenderGoneHelper.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper$1$1", f = "RenderGoneHelper.kt", i = {0, 1}, l = {40, 41}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
        public static final class C47841 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Boolean, ? extends Integer>>, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            public C47841(Continuation<? super C47841> r100) {
                super(2, r100);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                C47841 r102 = new C47841(r101);
                r102.L$0 = r100;
                return r102;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Pair<? extends Boolean, ? extends Integer>> r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(FlowCollector<? super Pair<Boolean, Integer>> r100, Continuation<? super Unit> r101) {
                return ((C47841) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006a -> B:12:0x003e). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r102 = this.label;
                if (r102 == 0) goto L10;
                if (r102 == 1) goto L9;
                if (r102 != 2) goto L8;
                ChannelIterator<Pair<Boolean, Integer>> r103 = (ChannelIterator) this.L$1;
                FlowCollector r104 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(r100);
                FlowCollector r105 = r104;
            L11:
                C47841 r106 = this;
            L12:
                r106.L$0 = r105;
                r106.L$1 = r103;
                r106.label = 1;
                Object r107 = r103.hasNext(r106);
                if (r107 != r101) goto L15;
                return r101;
            L15:
                C47841 r108 = r106;
                FlowCollector r109 = r105;
                r100 = r107;
                C47841 r110 = r108;
            L17:
                if (((Boolean) r100).booleanValue() == false) goto L23;
                Pair<Boolean, Integer> r111 = r103.next();
                r110.L$0 = r109;
                r110.L$1 = r103;
                r110.label = 2;
                if (r109.emit(r111, r110) != r101) goto L21;
                return r101;
            L21:
                r105 = r109;
                r106 = r110;
                goto L12
            L23:
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                r103 = (ChannelIterator) this.L$1;
                r109 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(r100);
                r110 = this;
                goto L17
            L10:
                ResultKt.throwOnFailure(r100);
                r105 = (FlowCollector) this.L$0;
                r103 = RenderGoneHelper.f411286b.iterator();
                goto L11
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<T> f411288a = null;

            static {
                f411288a = new a();
            }

            public a() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                Pair r102 = (Pair) r100;
                boolean r103 = ((Boolean) r102.component1()).booleanValue();
                int r104 = ((Number) r102.component2()).intValue();
                Log.i("CML_TAG_RenderGoneHelper", "onRenderProcessGone execute " + r103 + ' ' + r104);
                RenderGoneHelper.f411287c = true;
                Iterator<k.a> r105 = RenderGoneHelper.f411285a.iterator();     // Catch: Throwable -> L8
            L5:
                if (r105.hasNext() == false) goto L11;
                r105.next().a(r103, r104);     // Catch: Throwable -> L8
            L11:
                return Unit.INSTANCE;
            L8:
                th = move-exception;
                Log.e("CML_TAG_RenderGoneHelper", th);
                goto L11
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            Flow r103 = e.m(new c1(new C47841(null)), 200);
            FlowCollector r104 = a.f411288a;
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    static {
        f411285a = new CopyOnWriteArrayList();
        f411286b = ChannelKt.Channel$default(0, null, null, 7, null);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(null), 2, null);
    }
}
