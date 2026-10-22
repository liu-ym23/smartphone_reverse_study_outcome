package com.larus.xbridge.custom;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.xbridge.custom.MediaGetVideoThumbnailMethod$convertImageToJpeg$2", f = "MediaGetVideoThumbnailMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaGetVideoThumbnailMethod$convertImageToJpeg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ File $outputFile;
    private /* synthetic */ Object L$0;
    int label;

    public MediaGetVideoThumbnailMethod$convertImageToJpeg$2(File r100, Bitmap r101, Continuation<? super MediaGetVideoThumbnailMethod$convertImageToJpeg$2> r102) {
        this.$outputFile = r100;
        this.$bitmap = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MediaGetVideoThumbnailMethod$convertImageToJpeg$2 r102 = new MediaGetVideoThumbnailMethod$convertImageToJpeg$2(this.$outputFile, this.$bitmap, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((MediaGetVideoThumbnailMethod$convertImageToJpeg$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        File r102 = this.$outputFile;
        Bitmap r103 = this.$bitmap;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Throwable -> L7
        r103.compress(Bitmap.CompressFormat.JPEG, 100, r105);     // Catch: Throwable -> L7
        r105.close();     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(Boxing.boxBoolean(true));     // Catch: Throwable -> L7
    L9:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L13;
        FLogger.f375446a.e("BitmapHelper", "convertImageToJpeg failed", r107);
    L13:
        if (Result.m9452exceptionOrNullimpl(r106) != null) goto L16;
        return r106;
    L16:
        return Boxing.boxBoolean(false);
    L7:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
