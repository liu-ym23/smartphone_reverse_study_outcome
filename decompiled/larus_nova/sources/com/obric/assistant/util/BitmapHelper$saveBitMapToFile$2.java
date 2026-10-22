package com.obric.assistant.util;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
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

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.util.BitmapHelper$saveBitMapToFile$2", f = "BitmapHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BitmapHelper$saveBitMapToFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fileName;
    int label;

    public BitmapHelper$saveBitMapToFile$2(Context r100, String r101, Bitmap r102, Continuation<? super BitmapHelper$saveBitMapToFile$2> r103) {
        this.$context = r100;
        this.$fileName = r101;
        this.$bitmap = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BitmapHelper$saveBitMapToFile$2(this.$context, this.$fileName, this.$bitmap, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super File> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super File> r101) {
        return ((BitmapHelper$saveBitMapToFile$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        Context r101 = this.$context;
        if (r101 != null) goto L7;
        r101 = AppHost.f326268a.getApplication();
    L7:
        File r102 = r101.getCacheDir();
        if (r102.exists() == false) goto L10;
    L12:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, this.$fileName);
        BufferedOutputStream r104 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r103));     // Catch: Exception -> L15
        this.$bitmap.compress(Bitmap.CompressFormat.JPEG, 100, r104);     // Catch: Exception -> L15
        r104.flush();     // Catch: Exception -> L15
        r104.close();     // Catch: Exception -> L15
        return r103;
    L15:
        e = move-exception;
        FLogger.f375446a.e("saveBitMapToFile", "errorMsg: " + e.getMessage(), e);
        return null;
    L10:
        if (r102.mkdirs() == true) goto L12;
        r102 = r101.getFilesDir();
        goto L12
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
