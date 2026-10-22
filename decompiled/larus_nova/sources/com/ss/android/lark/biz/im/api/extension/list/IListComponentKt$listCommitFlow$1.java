package com.ss.android.lark.biz.im.api.extension.list;

import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.channels.k;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", "Lcom/ss/android/lark/biz/im/api/extension/list/ListExtraData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.biz.im.api.extension.list.IListComponentKt$listCommitFlow$1", f = "IListComponent.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
final class IListComponentKt$listCommitFlow$1 extends SuspendLambda implements Function2<k<? super List<Object>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ IListComponent<?> $this_listCommitFlow;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements IListComponent.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k<List<Object>> f410152a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(k<? super List<Object>> r100) {
            this.f410152a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.extension.list.IListComponent.b
        public final void a(List<Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "extra");
            Object r101 = this.f410152a.mo10962trySendJP2dKIU(r100);
            if ((r101 instanceof g.c) == false) goto L6;
            Log.e("IListComponent", "listCommitFlow send failed", g.a(r101));
            return;
        }
    }

    public IListComponentKt$listCommitFlow$1(IListComponent<?> r100, Continuation<? super IListComponentKt$listCommitFlow$1> r101) {
        this.$this_listCommitFlow = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        IListComponentKt$listCommitFlow$1 r102 = new IListComponentKt$listCommitFlow$1(this.$this_listCommitFlow, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k<? super List<Object>> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k<? super List<Object>> r100, Continuation<? super Unit> r101) {
        return ((IListComponentKt$listCommitFlow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        this.$this_listCommitFlow.uj(r104);
        final IListComponent<?> r105 = this.$this_listCommitFlow;
        Function0<Unit> r106 = new AnonymousClass1(r105, r104);
        this.label = 1;
        if (ProduceKt.a(r103, r106, this) != r101) goto L12;
        return r101;
    }
}
