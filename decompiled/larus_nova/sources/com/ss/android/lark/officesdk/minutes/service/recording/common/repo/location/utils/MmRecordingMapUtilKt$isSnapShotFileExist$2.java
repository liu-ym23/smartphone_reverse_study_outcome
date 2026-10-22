package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
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

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapUtilKt$isSnapShotFileExist$2", f = "MmRecordingMapUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingMapUtilKt$isSnapShotFileExist$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isDarkMode;
    int label;

    public MmRecordingMapUtilKt$isSnapShotFileExist$2(boolean r100, Context r101, Continuation<? super MmRecordingMapUtilKt$isSnapShotFileExist$2> r102) {
        this.$isDarkMode = r100;
        this.$context = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordingMapUtilKt$isSnapShotFileExist$2(this.$isDarkMode, this.$context, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((MmRecordingMapUtilKt$isSnapShotFileExist$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r100);
        if (this.$isDarkMode == false) goto L7;
        String r101 = "mm_map_snapshot_dark.png";
    L8:
        PolarisFileWrapper r102 = new PolarisFileWrapper(MmRecordingMapUtilKt.c(this.$context), r101);
        if (r102.exists() == true) goto L11;
    L13:
        boolean r103 = false;
    L15:
        return Boxing.boxBoolean(r103);
    L11:
        if (r102.length() <= 0) goto L13;
        r103 = true;
        goto L15
    L7:
        r101 = "mm_map_snapshot_light.png";
        goto L8
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
