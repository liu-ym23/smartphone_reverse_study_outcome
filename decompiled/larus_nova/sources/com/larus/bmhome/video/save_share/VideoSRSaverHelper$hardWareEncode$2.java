package com.larus.bmhome.video.save_share;

import android.graphics.Bitmap;
import com.larus.bmhome.music.save_video.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.save_share.VideoSRSaverHelper$hardWareEncode$2", f = "VideoSRSaverHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoSRSaverHelper$hardWareEncode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ List<Bitmap> $bitmaps;
    final /* synthetic */ q $muxerConfig;
    final /* synthetic */ String $tempPath;
    int label;
    final /* synthetic */ h this$0;

    public VideoSRSaverHelper$hardWareEncode$2(h r100, q r101, List<Bitmap> r102, String r103, Continuation<? super VideoSRSaverHelper$hardWareEncode$2> r104) {
        this.$muxerConfig = r101;
        this.$bitmaps = r102;
        this.$tempPath = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VideoSRSaverHelper$hardWareEncode$2(null, this.$muxerConfig, this.$bitmaps, this.$tempPath, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Object> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<Object> r101) {
        return ((VideoSRSaverHelper$hardWareEncode$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        throw null;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
