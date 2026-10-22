package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.obric.sva.sdk.controller.Global;
import com.ss.android.lark.vfs.VFSFile;
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

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent$deletePcmFile$2", f = "MmRecordingAudioPersistent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioPersistent$deletePcmFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ int $sliceDurationInSec;
    int label;
    final /* synthetic */ MmRecordingAudioPersistent this$0;

    public MmRecordingAudioPersistent$deletePcmFile$2(MmRecordingAudioPersistent r100, int r101, int r102, Continuation<? super MmRecordingAudioPersistent$deletePcmFile$2> r103) {
        this.this$0 = r100;
        this.$index = r101;
        this.$sliceDurationInSec = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordingAudioPersistent$deletePcmFile$2(this.this$0, this.$index, this.$sliceDurationInSec, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MmRecordingAudioPersistent$deletePcmFile$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        File r101 = this.this$0.f434296e;
        if (r101 == null) goto L7;
        String r102 = this.$index + '_' + (this.$sliceDurationInSec * 1000) + Global.SUFFIX_PCM_FILE;
        lvb.a.e(this.this$0.f434294c, "deletePcmFile, index:" + this.$index + ", fileName:" + r102 + ", sliceDurationInSec:" + this.$sliceDurationInSec);
        VFSFile r103 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r101, r102);
        if (r103.exists() == false) goto L12;
        r103.delete();
    L12:
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
