package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapReadHelper", f = "MmRecordingMapReadHelper.kt", i = {0}, l = {90}, m = "encodeBitMap", n = {DyPayConstant.KEY_START_TIME}, s = {"J$0"})
final class MmRecordingMapReadHelper$encodeBitMap$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingMapReadHelper this$0;

    public MmRecordingMapReadHelper$encodeBitMap$1(MmRecordingMapReadHelper r100, Continuation<? super MmRecordingMapReadHelper$encodeBitMap$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingMapReadHelper.a(this.this$0, null, this);
    }
}
