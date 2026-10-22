package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.widget.RtlSpacingHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl", f = "LazyLayoutPrefetchState.kt", i = {}, l = {564, 565}, m = "await", n = {}, s = {})
public final class PrefetchHandleProvider$HandleAndRequestImpl$await$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PrefetchHandleProvider.HandleAndRequestImpl this$0;

    public PrefetchHandleProvider$HandleAndRequestImpl$await$1(PrefetchHandleProvider.HandleAndRequestImpl r1, Continuation<? super PrefetchHandleProvider$HandleAndRequestImpl$await$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= RtlSpacingHelper.UNDEFINED;
        return this.this$0.await(this);
    }
}
