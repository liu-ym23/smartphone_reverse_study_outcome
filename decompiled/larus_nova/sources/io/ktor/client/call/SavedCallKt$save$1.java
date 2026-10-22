package io.ktor.client.call;

import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.call.SavedCallKt", f = "SavedCall.kt", i = {0}, l = {73}, m = SVGRenderEngine.SAVE, n = {"$this$save"}, s = {"L$0"})
public final class SavedCallKt$save$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public SavedCallKt$save$1(Continuation<? super SavedCallKt$save$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SavedCallKt.a(null, this);
    }
}
