package com.larus.bot.impl.common.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.InputStream;
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

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.BitmapHelperKt$convertImageToJpeg$2", f = "BitmapHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BitmapHelperKt$convertImageToJpeg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ File $outputFile;
    final /* synthetic */ Uri $source;
    private /* synthetic */ Object L$0;
    int label;

    public BitmapHelperKt$convertImageToJpeg$2(Activity r100, Uri r101, File r102, Continuation<? super BitmapHelperKt$convertImageToJpeg$2> r103) {
        this.$activity = r100;
        this.$source = r101;
        this.$outputFile = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        BitmapHelperKt$convertImageToJpeg$2 r102 = new BitmapHelperKt$convertImageToJpeg$2(this.$activity, this.$source, this.$outputFile, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((BitmapHelperKt$convertImageToJpeg$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Activity r102 = this.$activity;
        Uri r103 = this.$source;
        File r104 = this.$outputFile;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L13
        if (r102 == null) goto L10;
        ContentResolver r106 = r102.getContentResolver();     // Catch: Throwable -> L13
        if (r106 == null) goto L10;
        InputStream r107 = ContentResolverWrapper.openInputStream(r106, r103);     // Catch: Throwable -> L13
    L11:
        Bitmap r108 = BitmapFactory.decodeStream(r107);     // Catch: Throwable -> L13
        PolarisFileOutputStreamWrapper r109 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L13
        r108.compress(Bitmap.CompressFormat.JPEG, 100, r109);     // Catch: Throwable -> L13
        r109.close();     // Catch: Throwable -> L13
        Object r110 = Result.m9449constructorimpl(Boxing.boxBoolean(true));     // Catch: Throwable -> L13
    L15:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L19;
        FLogger.f375446a.e("BitmapHelper", "convertImageToJpeg failed", r111);
    L19:
        if (Result.m9452exceptionOrNullimpl(r110) != null) goto L22;
        return r110;
    L22:
        return Boxing.boxBoolean(false);
    L10:
        r107 = null;
    L13:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
