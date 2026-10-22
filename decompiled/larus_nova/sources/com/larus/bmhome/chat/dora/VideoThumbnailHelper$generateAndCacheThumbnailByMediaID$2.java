package com.larus.bmhome.chat.dora;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.larus.bmhome.chat.dora.VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2", f = "VideoThumbnailHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $mediaID;
    final /* synthetic */ String $videoPath;
    int label;

    public VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2(String r100, String r101, Context r102, Continuation<? super VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2> r103) {
        this.$videoPath = r100;
        this.$mediaID = r101;
        this.$context = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2(this.$videoPath, this.$mediaID, this.$context, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r110);
    L23:
        e = move-exception;
        FLogger.f375446a.e("VideoThumbnailHelper", "Error generating thumbnail for mediaID: " + this.$mediaID + ", error: " + e.getMessage());
        e.printStackTrace();
    L25:
        return null;
    L6:
        if (new PolarisFileWrapper(this.$videoPath).exists() == true) goto L9;
        FLogger.f375446a.w("VideoThumbnailHelper", "Video file not exists: " + this.$videoPath);     // Catch: Exception -> L23
        return null;
    L9:
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.$context.getCacheDir(), "video_thumb_" + this.$mediaID.hashCode() + ".jpg");     // Catch: Exception -> L23
        if (r100.exists() == false) goto L13;
        FLogger.f375446a.i("VideoThumbnailHelper", "Thumbnail cache already exists for mediaID: " + this.$mediaID);     // Catch: Exception -> L23
        return r100.getAbsolutePath();
    L13:
        FLogger r101 = FLogger.f375446a;     // Catch: Exception -> L23
        r101.i("VideoThumbnailHelper", "Generating thumbnail for mediaID: " + this.$mediaID + ", path: " + this.$videoPath);     // Catch: Exception -> L23
        int r102 = VideoThumbnailHelper.f302937a;     // Catch: Exception -> L23
        String r103 = this.$videoPath;     // Catch: Exception -> L23
        MediaMetadataRetriever r104 = new MediaMetadataRetriever();     // Catch: Exception -> L16
        r104.setDataSource(r103);     // Catch: Exception -> L16
        Bitmap r105 = r104.getFrameAtTime(0, 2);     // Catch: Exception -> L16
        r104.release();     // Catch: Exception -> L16
    L18:
        if (r105 == null) goto L21;
        String r106 = this.$mediaID;     // Catch: Exception -> L23
        VideoThumbnailHelper.c(r105, r100, 20);     // Catch: Exception -> L23
        r101.i("VideoThumbnailHelper", "Thumbnail generated successfully for mediaID: " + r106);     // Catch: Exception -> L23
        return r100.getAbsolutePath();
    L21:
        r101.w("VideoThumbnailHelper", "Failed to extract thumbnail for mediaID: " + this.$mediaID);     // Catch: Exception -> L23
        goto L25
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L23
        r105 = null;
        goto L18
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
