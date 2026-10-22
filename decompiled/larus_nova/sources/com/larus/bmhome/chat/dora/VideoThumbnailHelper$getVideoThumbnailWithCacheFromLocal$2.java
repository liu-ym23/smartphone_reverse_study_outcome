package com.larus.bmhome.chat.dora;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.dora.VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2", f = "VideoThumbnailHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $videoPath;
    int label;

    public VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2(String r100, Context r101, Continuation<? super VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2> r102) {
        this.$videoPath = r100;
        this.$context = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2(this.$videoPath, this.$context, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r100);
    L20:
        e = move-exception;
        e.printStackTrace();
    L22:
        return null;
    L6:
        if (new PolarisFileWrapper(this.$videoPath).exists() == true) goto L8;
        return null;
    L8:
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.$context.getCacheDir(), "video_thumb_" + this.$videoPath.hashCode() + ".jpg");     // Catch: Exception -> L20
        if (r101.exists() == true) goto L11;
        int r102 = VideoThumbnailHelper.f302937a;     // Catch: Exception -> L20
        String r103 = this.$videoPath;     // Catch: Exception -> L20
        MediaMetadataRetriever r104 = new MediaMetadataRetriever();     // Catch: Exception -> L15
        r104.setDataSource(r103);     // Catch: Exception -> L15
        Bitmap r105 = r104.getFrameAtTime(0, 2);     // Catch: Exception -> L15
        r104.release();     // Catch: Exception -> L15
    L17:
        if (r105 == null) goto L22;
        VideoThumbnailHelper.c(r105, r101, 85);     // Catch: Exception -> L20
        return r101.getAbsolutePath();
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L20
        r105 = null;
        goto L17
    L11:
        return r101.getAbsolutePath();
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
