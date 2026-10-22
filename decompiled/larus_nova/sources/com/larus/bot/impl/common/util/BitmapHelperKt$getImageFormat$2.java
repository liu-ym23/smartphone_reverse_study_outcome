package com.larus.bot.impl.common.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.utils.logger.FLogger;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.BitmapHelperKt$getImageFormat$2", f = "BitmapHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BitmapHelperKt$getImageFormat$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Uri $imageUri;
    int label;

    public BitmapHelperKt$getImageFormat$2(Activity r100, Uri r101, Continuation<? super BitmapHelperKt$getImageFormat$2> r102) {
        this.$activity = r100;
        this.$imageUri = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BitmapHelperKt$getImageFormat$2(this.$activity, this.$imageUri, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((BitmapHelperKt$getImageFormat$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r100);
        Activity r101 = this.$activity;
        Uri r102 = this.$imageUri;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        if (r101 == null) goto L10;
        ContentResolver r104 = r101.getContentResolver();     // Catch: Throwable -> L13
        if (r104 == null) goto L10;
        InputStream r105 = ContentResolverWrapper.openInputStream(r104, r102);     // Catch: Throwable -> L13
    L11:
        BitmapFactory.Options r106 = new BitmapFactory.Options();     // Catch: Throwable -> L13
        r106.inJustDecodeBounds = true;     // Catch: Throwable -> L13
        BitmapFactory.decodeStream(r105, null, r106);     // Catch: Throwable -> L13
        Object r107 = Result.m9449constructorimpl(r106.outMimeType);     // Catch: Throwable -> L13
    L15:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L19;
        FLogger.f375446a.e("BitmapHelper", "getImageFormat failed", r108);
    L19:
        if (Result.m9455isFailureimpl(r107) == false) goto L22;
        return null;
    L22:
        return r107;
    L10:
        r105 = null;
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
