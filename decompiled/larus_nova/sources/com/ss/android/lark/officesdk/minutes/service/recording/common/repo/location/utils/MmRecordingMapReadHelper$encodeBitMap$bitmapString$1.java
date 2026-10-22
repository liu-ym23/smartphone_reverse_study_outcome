package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.graphics.Bitmap;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapReadHelper$encodeBitMap$bitmapString$1", f = "MmRecordingMapReadHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingMapReadHelper$encodeBitMap$bitmapString$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    int label;

    public MmRecordingMapReadHelper$encodeBitMap$bitmapString$1(Bitmap r100, Continuation<? super MmRecordingMapReadHelper$encodeBitMap$bitmapString$1> r101) {
        this.$bitmap = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordingMapReadHelper$encodeBitMap$bitmapString$1(this.$bitmap, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((MmRecordingMapReadHelper$encodeBitMap$bitmapString$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        Bitmap r102 = this.$bitmap;
        r102.compress(Bitmap.CompressFormat.PNG, 80, r101);     // Catch: Throwable -> L8
        String r103 = Base64.encodeToString(r101.toByteArray(), 2);     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r101, null);
        return r103;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
