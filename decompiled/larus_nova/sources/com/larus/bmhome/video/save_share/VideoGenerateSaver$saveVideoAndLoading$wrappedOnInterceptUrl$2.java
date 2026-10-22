package com.larus.bmhome.video.save_share;

import com.larus.platform.spi.IAIChatUgcAIGCService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.save_share.VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2", f = "VideoGenerateSaver.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
public final class VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $subScene;
    final /* synthetic */ nr9.g $videoContent;
    int label;

    public VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2(nr9.g r100, String r101, Continuation<? super VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2> r102) {
        this.$videoContent = r100;
        this.$subScene = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2(this.$videoContent, this.$subScene, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super String> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super String> r100) {
        return ((VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L20:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IAIChatUgcAIGCService.Companion r103 = IAIChatUgcAIGCService.f365905a;
        nr9.g r104 = this.$videoContent;
        if (r104 == null) goto L11;
        String r105 = r104.f520259c;
    L12:
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        String r106 = this.$subScene;
        if (r106 != null) goto L17;
        r106 = "video";
    L17:
        this.label = 1;
        r100 = IAIChatUgcAIGCService.a.d(r103, r105, "Creation", r106, this);
        if (r100 != r101) goto L20;
        return r101;
    L11:
        r105 = null;
        goto L12
    }
}
