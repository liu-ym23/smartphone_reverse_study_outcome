package com.bytedance.ee.bear.document.render.loader;

import com.bytedance.ee.bear.document.x2;
import iu5.d;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3$terminate$1", f = "DocumentLoaderV3.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DocumentLoaderV3$terminate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $code;
    final /* synthetic */ Throwable $throwable;
    int label;
    final /* synthetic */ DocumentLoaderV3 this$0;

    public DocumentLoaderV3$terminate$1(DocumentLoaderV3 r1, int r2, Throwable r3, Continuation<? super DocumentLoaderV3$terminate$1> r4) {
        this.this$0 = r1;
        this.$code = r2;
        this.$throwable = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DocumentLoaderV3$terminate$1(this.this$0, this.$code, this.$throwable, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r8);
        Job r9 = this.this$0.g;
        if (r9 == null) goto L7;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L7:
        DocumentLoaderV3 r10 = this.this$0;
        int r0 = this.$code;
        Throwable r1 = this.$throwable;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r1, "e");
        a.h(r10.f, "dispatchLoadFailed, code: " + r0 + ", e: " + r1 + ", count=" + r10.b.size() + ", callbacks=" + r10.h());
        Iterator r2 = CollectionsKt.toMutableList(r10.b).iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        x2.b r3 = (x2.b) r2.next();
        a.h(r10.f, "dispatchLoadFailed callback=" + BaseDocumentLoader.g(r3));
        r3.onLoadFail(r0, r1);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        a.e(r10.f, "dispatchLoadFailed failed, e = " + e, e, false);
        d.a(r10.f, e);
        goto L9
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
