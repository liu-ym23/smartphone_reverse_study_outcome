package io.ktor.utils.io.core.internal;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.core.internal.UTF8Kt", f = "UTF8.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {37}, m = "decodeUTF8LineLoopSuspend", n = {Argument.OUT, "nextChunk", "afterRead", "decoded", "size", SRStrategy.KEY_CURRENT_RESOLUTION, "end", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
public final class UTF8Kt$decodeUTF8LineLoopSuspend$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    public UTF8Kt$decodeUTF8LineLoopSuspend$1(Continuation<? super UTF8Kt$decodeUTF8LineLoopSuspend$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return UTF8Kt.a(null, 0, null, null, this);
    }
}
