package io.github.alexzhirkevich.compottie;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.github.alexzhirkevich.compottie.LruMap$getOrPutSuspend$2", f = "LruMap.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
final class LruMap$getOrPutSuspend$2 extends SuspendLambda implements Function1<Continuation<Object>, Object> {
    final /* synthetic */ Object $key;
    final /* synthetic */ Function1<Continuation<Object>, Object> $put;
    int label;
    final /* synthetic */ c0<Object> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public LruMap$getOrPutSuspend$2(c0<Object> r100, Object r101, Function1<? super Continuation<Object>, ? extends Object> r102, Continuation<? super LruMap$getOrPutSuspend$2> r103) {
        this.this$0 = r100;
        this.$key = r101;
        this.$put = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new LruMap$getOrPutSuspend$2(this.this$0, this.$key, this.$put, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<Object> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<Object> r100) {
        return ((LruMap$getOrPutSuspend$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L16:
        this.this$0.a(this.$key, r100);
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        c0<Object> r103 = this.this$0;
        Object r104 = this.$key;
        Object r105 = r103.f490734a.remove(r104);
        if (r105 != null) goto L11;
        r105 = null;
    L12:
        if (r105 != null) goto L18;
        Function1<Continuation<Object>, Object> r106 = this.$put;
        this.label = 1;
        r100 = r106.invoke(this);
        if (r100 != r101) goto L16;
        return r101;
    L18:
        return r105;
    L11:
        r103.a(r104, r105);
        goto L12
    }
}
