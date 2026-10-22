package io.ktor.utils.io;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME}, m = "joinToImplSuspend", n = {"dst", "close"}, s = {"L$0", "Z$0"})
final class ByteReadChannelJVMKt$joinToImplSuspend$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    public ByteReadChannelJVMKt$joinToImplSuspend$1(Continuation<? super ByteReadChannelJVMKt$joinToImplSuspend$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        ByteReadChannelJVMKt$joinToImplSuspend$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L12;
        if (r105 != 1) goto L11;
        boolean r106 = r102.Z$0;
        d r107 = (d) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L16:
        if (r106 == false) goto L18;
        e.a(r107);
    L20:
        return Unit.INSTANCE;
    L18:
        r107.flush();
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r103);
        r102.L$0 = null;
        r102.Z$0 = false;
        r102.label = 1;
        if (ByteReadChannelJVMKt.a(null, null, Long.MAX_VALUE, r102) == r104) goto L21;
        r107 = null;
        r106 = false;
        goto L16
    L21:
        return r104;
    L5:
        r102 = new ByteReadChannelJVMKt$joinToImplSuspend$1(this);
        goto L6
    }
}
