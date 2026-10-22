package com.larus.uaigc.createpage.utils;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.BufferedOutputStream;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.BitmapHelperKt$saveBitmapToCleanableDir$2", f = "BitmapHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BitmapHelperKt$saveBitmapToCleanableDir$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ String $fileName;
    int label;

    public BitmapHelperKt$saveBitmapToCleanableDir$2(String r100, Bitmap r101, Continuation<? super BitmapHelperKt$saveBitmapToCleanableDir$2> r102) {
        this.$fileName = r100;
        this.$bitmap = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BitmapHelperKt$saveBitmapToCleanableDir$2(this.$fileName, this.$bitmap, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super File> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super File> r101) {
        return ((BitmapHelperKt$saveBitmapToCleanableDir$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        PolarisFileWrapper r101 = new PolarisFileWrapper(aa9.a.f2357a.b("creation_attachment_cache", true), this.$fileName);
        BufferedOutputStream r102 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r101));     // Catch: Exception -> L7
        this.$bitmap.compress(Bitmap.CompressFormat.JPEG, 100, r102);     // Catch: Exception -> L7
        r102.flush();     // Catch: Exception -> L7
        r102.close();     // Catch: Exception -> L7
        return r101;
    L7:
        e = move-exception;
        FLogger.f375446a.e("saveBitmapToCleanableDir", "errorMsg: " + e.getMessage(), e);
        return null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
