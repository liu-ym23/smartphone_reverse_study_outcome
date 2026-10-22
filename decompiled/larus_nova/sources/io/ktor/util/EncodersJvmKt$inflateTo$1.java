package io.ktor.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.EncodersJvmKt", f = "EncodersJvm.kt", i = {0}, l = {157}, m = "inflateTo", n = {"inflated"}, s = {"I$0"})
final class EncodersJvmKt$inflateTo$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;

    public EncodersJvmKt$inflateTo$1(Continuation<? super EncodersJvmKt$inflateTo$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return m.a(null, null, null, null, this);
    }
}
