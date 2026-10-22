package com.ss.android.lark.biz.im.api.extension.list;

import java.util.ArrayList;
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

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.biz.im.api.extension.list.ListComponent$onCreate$2", f = "ListComponent.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
final class ListComponent$onCreate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ListComponent<Object, Object> this$0;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListComponent<Object, Object> f410157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList<Object> f410158b;

        public a(ListComponent<Object, Object> r100, ArrayList<Object> r101) {
            this.f410157a = r100;
            this.f410158b = r101;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            this.f410157a.getClass();
            this.f410157a.getClass();
            ((d) r100).getClass();
            this.f410157a.getClass();
            return Unit.INSTANCE;
        }
    }

    public ListComponent$onCreate$2(ListComponent<Object, Object> r100, Continuation<? super ListComponent$onCreate$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ListComponent$onCreate$2(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ListComponent$onCreate$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ArrayList r103 = new ArrayList();
        i1<d<Object>> r104 = this.this$0.a().d();
        a r105 = new a(this.this$0, r103);
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L12;
        return r101;
    }
}
