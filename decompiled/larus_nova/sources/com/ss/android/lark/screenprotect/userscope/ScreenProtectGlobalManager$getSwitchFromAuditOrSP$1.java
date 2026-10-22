package com.ss.android.lark.screenprotect.userscope;

import androidx.lifecycle.MutableLiveData;
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

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.screenprotect.userscope.ScreenProtectGlobalManager$getSwitchFromAuditOrSP$1", f = "ScreenProtectGlobalManager.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME}, m = "invokeSuspend", n = {}, s = {})
final class ScreenProtectGlobalManager$getSwitchFromAuditOrSP$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $userId;
    Object L$0;
    int label;
    final /* synthetic */ ScreenProtectGlobalManager this$0;

    public ScreenProtectGlobalManager$getSwitchFromAuditOrSP$1(ScreenProtectGlobalManager r100, String r101, Continuation<? super ScreenProtectGlobalManager$getSwitchFromAuditOrSP$1> r102) {
        this.this$0 = r100;
        this.$userId = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ScreenProtectGlobalManager$getSwitchFromAuditOrSP$1(this.this$0, this.$userId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ScreenProtectGlobalManager$getSwitchFromAuditOrSP$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        MutableLiveData r103 = (MutableLiveData) this.L$0;
        ResultKt.throwOnFailure(r100);
    L12:
        r103.setValue(r100);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ScreenProtectGlobalManager r104 = this.this$0;
        MutableLiveData<Boolean> r105 = r104.f439835e;
        String r106 = this.$userId;
        this.L$0 = r105;
        this.label = 1;
        r100 = ScreenProtectGlobalManager.a(r104, r106, this);
        if (r100 != r101) goto L11;
        return r101;
    L11:
        r103 = r105;
        goto L12
    }
}
