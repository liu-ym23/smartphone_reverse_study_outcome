package com.larus.canvas.feature.component.resultdisplay.image.widget;

import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.canvas.feature.component.logic.loading.CanvasProgressState;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.resultdisplay.image.widget.LoadingProgressController$observeProgress$1", f = "LoadingProgressController.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
final class LoadingProgressController$observeProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ s this$0;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f323620a;

        public a(s r100) {
            this.f323620a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            int r102 = ((Number) r100).intValue();
            FLogger.f375446a.d("CanvasLoadingProgressController", "id: " + this.f323620a.f323666e + ", progress is " + r102);
            ((ISketchLoadingController) this.f323620a.f323664c.getValue()).setProgress(r102);
            return Unit.INSTANCE;
        }
    }

    public LoadingProgressController$observeProgress$1(s r100, String r101, Continuation<? super LoadingProgressController$observeProgress$1> r102) {
        this.this$0 = r100;
        this.$id = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LoadingProgressController$observeProgress$1(this.this$0, this.$id, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LoadingProgressController$observeProgress$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L18:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FLogger.f375446a.d("CanvasLoadingProgressController", "observeProgress, id: " + this.this$0.f323666e);
        CanvasProgressState r103 = this.this$0.f323663b.invoke();
        if (r103 == null) goto L20;
        Map<String, i1<Integer>> r104 = r103.flowMap;
        if (r104 == null) goto L20;
        i1<Integer> r105 = r104.get(this.$id);
        if (r105 == null) goto L20;
        a r106 = new a(this.this$0);
        this.label = 1;
        if (r105.collect(r106, this) != r101) goto L18;
        return r101;
    L20:
        return Unit.INSTANCE;
    }
}
