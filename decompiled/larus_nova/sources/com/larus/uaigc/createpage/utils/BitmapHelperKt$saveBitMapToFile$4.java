package com.larus.uaigc.createpage.utils;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.utils.logger.FLogger;
import java.io.BufferedOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.BitmapHelperKt$saveBitMapToFile$4", f = "BitmapHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BitmapHelperKt$saveBitMapToFile$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ String $filePath;
    final /* synthetic */ int $quality;
    int label;

    public BitmapHelperKt$saveBitMapToFile$4(String r100, Bitmap r101, int r102, Continuation<? super BitmapHelperKt$saveBitMapToFile$4> r103) {
        this.$filePath = r100;
        this.$bitmap = r101;
        this.$quality = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BitmapHelperKt$saveBitMapToFile$4(this.$filePath, this.$bitmap, this.$quality, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((BitmapHelperKt$saveBitMapToFile$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        BufferedOutputStream r101 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(this.$filePath));     // Catch: Exception -> L7
        this.$bitmap.compress(Bitmap.CompressFormat.JPEG, this.$quality, r101);     // Catch: Exception -> L7
        r101.flush();     // Catch: Exception -> L7
        r101.close();     // Catch: Exception -> L7
        return Boxing.boxBoolean(true);
    L7:
        e = move-exception;
        FLogger.f375446a.e("saveBitMapToFile", "errorMsg: " + e.getMessage(), e);
        return Boxing.boxBoolean(false);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
