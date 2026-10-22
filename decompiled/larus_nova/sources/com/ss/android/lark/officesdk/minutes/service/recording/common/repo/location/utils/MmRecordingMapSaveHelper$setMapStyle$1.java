package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper", f = "MmRecordingMapSaveHelper.kt", i = {0, 0, 0}, l = {245}, m = "setMapStyle", n = {"uiLaunchMode", "isDarkMode", DyPayConstant.KEY_START_TIME}, s = {"L$0", "Z$0", "J$0"})
public final class MmRecordingMapSaveHelper$setMapStyle$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingMapSaveHelper this$0;

    public MmRecordingMapSaveHelper$setMapStyle$1(MmRecordingMapSaveHelper r100, Continuation<? super MmRecordingMapSaveHelper$setMapStyle$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MmRecordingMapSaveHelper r101 = this.this$0;
        int r102 = MmRecordingMapSaveHelper.f435009m;
        return r101.h(null, null, false, this);
    }
}
