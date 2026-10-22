package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapReadHelper", f = "MmRecordingMapReadHelper.kt", i = {}, l = {34}, m = "readFromCache", n = {}, s = {})
public final class MmRecordingMapReadHelper$readFromCache$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingMapReadHelper this$0;

    public MmRecordingMapReadHelper$readFromCache$1(MmRecordingMapReadHelper r100, Continuation<? super MmRecordingMapReadHelper$readFromCache$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(false, this);
    }
}
