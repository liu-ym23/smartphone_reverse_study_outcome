package com.ss.android.lark.flow.chat.message.image;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1", f = "FlowYunPanFileUtils.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY}, m = "invokeSuspend", n = {}, s = {})
public final class FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $localPath;
    final /* synthetic */ String $token;
    int label;

    public FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1(String r100, String r101, Continuation<? super FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1> r102) {
        this.$token = r100;
        this.$localPath = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1(this.$token, this.$localPath, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FlowYunPanFileUtils r103 = FlowYunPanFileUtils.f422568a;
        String r104 = this.$token;
        String r105 = this.$localPath;
        this.label = 1;
        r100 = FlowYunPanFileUtils.a(r103, r104, r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
