package com.bytedance.ee.bear.document.render.node;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import k25.e0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.document.render.node.EditionRenderNode$run$2", f = "EditionRenderNode.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EditionRenderNode$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $context;
    final /* synthetic */ DocViewModel $docViewModel;
    final /* synthetic */ z05.g $metadata;
    int label;
    final /* synthetic */ EditionRenderNode this$0;

    public EditionRenderNode$run$2(EditionRenderNode r1, e r2, DocViewModel r3, z05.g r4, Continuation<? super EditionRenderNode$run$2> r5) {
        this.this$0 = r1;
        this.$context = r2;
        this.$docViewModel = r3;
        this.$metadata = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new EditionRenderNode$run$2(this.this$0, this.$context, this.$docViewModel, this.$metadata, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r5);
        EditionRenderNode r6 = this.this$0;
        e r0 = this.$context;
        DocViewModel r1 = this.$docViewModel;
        String r2 = this.$metadata.a;
        int r3 = EditionRenderNode.b;
        r6.getClass();
        if (TextUtils.isEmpty(r2) == true) goto L12;
        AccountService$Account r7 = ((h0) r0.a(h0.class)).G2();
        if (r7 == null) goto L12;
        BearUrl r4 = r1.getBearUrl();
        e0.m().o(r7, r2, r4.a, r4.d);
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
