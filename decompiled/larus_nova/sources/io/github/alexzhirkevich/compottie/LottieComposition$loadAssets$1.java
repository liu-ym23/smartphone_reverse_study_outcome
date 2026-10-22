package io.github.alexzhirkevich.compottie;

import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.github.alexzhirkevich.compottie.LottieComposition", f = "LottieComposition.kt", i = {0}, l = {255}, m = "loadAssets$compottie_release", n = {ChameleonAssertResManager.ASSET_FOLDER}, s = {"L$0"})
public final class LottieComposition$loadAssets$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LottieComposition this$0;

    public LottieComposition$loadAssets$1(LottieComposition r100, Continuation<? super LottieComposition$loadAssets$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, false, this);
    }
}
