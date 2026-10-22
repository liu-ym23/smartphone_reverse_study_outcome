package com.larus.avatar.impl.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.upload.DigitalAvatarPreGenManager", f = "DigitalAvatarPreGenManager.kt", i = {0}, l = {177}, m = "ensurePreGenBitmap", n = {"cacheItem"}, s = {"L$0"})
public final class DigitalAvatarPreGenManager$ensurePreGenBitmap$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DigitalAvatarPreGenManager this$0;

    public DigitalAvatarPreGenManager$ensurePreGenBitmap$1(DigitalAvatarPreGenManager r100, Continuation<? super DigitalAvatarPreGenManager$ensurePreGenBitmap$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DigitalAvatarPreGenManager r101 = this.this$0;
        int r102 = DigitalAvatarPreGenManager.f291225d;
        return r101.b(null, this);
    }
}
