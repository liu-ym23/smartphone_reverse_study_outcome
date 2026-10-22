package com.larus.bmhome.social.page.datasource;

import androidx.exifinterface.media.ExifInterface;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T, Key] */
/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/social/page/datasource/PagingResult;", ExifInterface.GPS_DIRECTION_TRUE, "Key", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.LoadStateHolder$checkLoad$result$1", f = "FlowPagingManager.kt", i = {}, l = {234, VideoRef.VALUE_VIDEO_REF_CONST_DEPTH}, m = "invokeSuspend", n = {}, s = {})
public final class LoadStateHolder$checkLoad$result$1<Key, T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g<T, Key>>, Object> {
    final /* synthetic */ com.larus.bmhome.social.page.datasource.event.e.a $operation;
    final /* synthetic */ e<Key> $request;
    int label;
    final /* synthetic */ LoadStateHolder<T, Key> this$0;

    public LoadStateHolder$checkLoad$result$1(com.larus.bmhome.social.page.datasource.event.e.a r100, LoadStateHolder<T, Key> r101, e<Key> r102, Continuation<? super LoadStateHolder$checkLoad$result$1> r103) {
        this.$operation = r100;
        this.this$0 = r101;
        this.$request = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LoadStateHolder$checkLoad$result$1(this.$operation, this.this$0, this.$request, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
        return invoke(r100, (Continuation) r101);
    }

    public final Object invoke(CoroutineScope r100, Continuation<? super g<T, Key>> r101) {
        return ((LoadStateHolder$checkLoad$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 == 1) goto L10;
        if (r102 != 2) goto L9;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L24
    L29:
        return (g) r100;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L24
    L28:
        return (g) r100;
    L12:
        ResultKt.throwOnFailure(r100);
        if ((this.$operation instanceof com.larus.bmhome.social.page.datasource.event.e.a.C4103a) == false) goto L19;
        f<T, Key> r103 = this.this$0.f313993a;     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        r100 = r103.a();     // Catch: Throwable -> L24
        if (r100 != r101) goto L28;
        return r101;
    L19:
        f<T, Key> r104 = this.this$0.f313993a;     // Catch: Throwable -> L24
        this.label = 2;     // Catch: Throwable -> L24
        r100 = r104.b();     // Catch: Throwable -> L24
        if (r100 != r101) goto L29;
        return r101;
    L24:
        th = move-exception;
        int r105 = g.f314041b;
        return new g.c(th);
    }
}
