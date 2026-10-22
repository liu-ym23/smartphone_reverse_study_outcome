package com.larus.bmhome.chat.layout.holder.image;

import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.bmhome.databinding.LarusImageScrollItemBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.ScrollImageViewHolder$refreshShareOrDownloadBtn$1$4$1", f = "ImageScrollAdapter.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
final class ScrollImageViewHolder$refreshShareOrDownloadBtn$1$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusImageScrollItemBinding $this_apply;
    final /* synthetic */ String $url;
    int label;

    public ScrollImageViewHolder$refreshShareOrDownloadBtn$1$4$1(String r100, LarusImageScrollItemBinding r101, Continuation<? super ScrollImageViewHolder$refreshShareOrDownloadBtn$1$4$1> r102) {
        this.$url = r100;
        this.$this_apply = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ScrollImageViewHolder$refreshShareOrDownloadBtn$1$4$1(this.$url, this.$this_apply, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ScrollImageViewHolder$refreshShareOrDownloadBtn$1$4$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        ImageDownloadLoadingMgr r103 = ImageDownloadLoadingMgr.f295963a;
        String r104 = this.$url;
        final LarusImageScrollItemBinding r105 = this.$this_apply;
        Function1<? super Boolean, Unit> r106 = new l1(r105);
        this.label = 1;
        if (r103.a(r104, r106, this) != r101) goto L12;
        return r101;
    }
}
