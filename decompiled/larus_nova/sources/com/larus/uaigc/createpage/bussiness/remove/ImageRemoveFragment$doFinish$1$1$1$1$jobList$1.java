package com.larus.uaigc.createpage.bussiness.remove;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$doFinish$1$1$1$1$jobList$1", f = "ImageRemoveFragment.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OPENED_TIME}, m = "invokeSuspend", n = {"sendImgPath"}, s = {"L$0"})
public final class ImageRemoveFragment$doFinish$1$1$1$1$jobList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $pathBitmap;
    final /* synthetic */ ImageEditDataWithMask $resultData;
    final /* synthetic */ Bitmap $viewBitmap;
    Object L$0;
    int label;

    public ImageRemoveFragment$doFinish$1$1$1$1$jobList$1(Bitmap r100, ImageEditDataWithMask r101, Bitmap r102, Continuation<? super ImageRemoveFragment$doFinish$1$1$1$1$jobList$1> r103) {
        this.$pathBitmap = r100;
        this.$resultData = r101;
        this.$viewBitmap = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ImageRemoveFragment$doFinish$1$1$1$1$jobList$1(this.$pathBitmap, this.$resultData, this.$viewBitmap, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ImageRemoveFragment$doFinish$1$1$1$1$jobList$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        String r102 = (String) this.L$0;
        ResultKt.throwOnFailure(r110);
    L26:
        if (((Boolean) r110).booleanValue() == false) goto L28;
        this.$resultData.setSendMsgImgStoragePath(r102);
    L30:
        return Unit.INSTANCE;
    L28:
        FLogger.f375446a.d("ImageRemoveFragment", "save send image failed");
        goto L30
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        Bitmap r111 = this.$pathBitmap;
        Bitmap r103 = this.$viewBitmap;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r111, "other");
        long r104 = System.currentTimeMillis();
        Object r105 = null;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        Bitmap r107 = Bitmap.createBitmap(r103.getWidth(), r103.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L11
        Canvas r108 = new Canvas(r107);     // Catch: Throwable -> L11
        r108.drawBitmap(r103, 0.0f, 0.0f, null);     // Catch: Throwable -> L11
        r108.drawBitmap(r111, 0.0f, 0.0f, null);     // Catch: Throwable -> L11
        FLogger.f375446a.d("BitmapHelper", "concat bitmap cost " + (System.currentTimeMillis() - r104) + "ms");     // Catch: Throwable -> L11
        Object r112 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r112) == true) goto L17;
        r105 = r112;
    L17:
        Bitmap r109 = (Bitmap) r105;
        if (r109 == null) goto L20;
        String r113 = IAIChatUploadMediaService.f365908a.a(LoadParams.ImageFormat.JPEG, false);
        this.L$0 = r113;
        this.label = 1;
        Object r114 = BitmapHelperKt.e(r109, r113, 85, this);
        if (r114 != r100) goto L24;
        return r100;
    L24:
        r102 = r113;
        r110 = r114;
        goto L26
    L20:
        return Unit.INSTANCE;
    L11:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
