package com.larus.bmhome.social.page.datasource;

import androidx.exifinterface.media.ExifInterface;
import com.ss.ttm.player.MediaPlayer;
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
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.LoadStateHolder$checkRefresh$result$1", f = "FlowPagingManager.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE}, m = "invokeSuspend", n = {}, s = {})
public final class LoadStateHolder$checkRefresh$result$1<Key, T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g<T, Key>>, Object> {
    final /* synthetic */ e<Key> $request;
    int label;
    final /* synthetic */ LoadStateHolder<T, Key> this$0;

    public LoadStateHolder$checkRefresh$result$1(LoadStateHolder<T, Key> r100, e<Key> r101, Continuation<? super LoadStateHolder$checkRefresh$result$1> r102) {
        this.this$0 = r100;
        this.$request = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LoadStateHolder$checkRefresh$result$1(this.this$0, this.$request, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
        return invoke(r100, (Continuation) r101);
    }

    public final Object invoke(CoroutineScope r100, Continuation<? super g<T, Key>> r101) {
        return ((LoadStateHolder$checkRefresh$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        return (g) r100;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        f<T, Key> r103 = this.this$0.f313993a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r100 = r103.refresh();     // Catch: Throwable -> L15
        if (r100 != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        int r104 = g.f314041b;
        return new g.c(th);
    }
}
