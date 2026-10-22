package kotlinx.coroutines.rx2;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxAwaitKt", f = "RxAwait.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE}, m = "awaitFirstOrElse", n = {"defaultValue"}, s = {"L$0"})
final class RxAwaitKt$awaitFirstOrElse$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public RxAwaitKt$awaitFirstOrElse$1(Continuation<? super RxAwaitKt$awaitFirstOrElse$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        RxAwaitKt$awaitFirstOrElse$1<T> r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        Function0 r105 = (Function0) r102.L$0;
        ResultKt.throwOnFailure(r103);
        if (r103 == null) goto L12;
        return r103;
    L12:
        return r105.invoke();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        Mode r106 = Mode.FIRST;
        r102.L$0 = null;
        r102.label = 1;
        new j(IntrinsicsKt.intercepted(r102), 1).C();
        throw null;
    L5:
        r102 = new RxAwaitKt$awaitFirstOrElse$1(this);
        goto L6
    }
}
