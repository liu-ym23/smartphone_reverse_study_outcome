package com.larus.avatar.impl.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.upload.DigitalAvatarPreGenManager", f = "DigitalAvatarPreGenManager.kt", i = {0, 0, 0}, l = {115}, m = "collectBitmapPairs", n = {"result", "cacheItem", "onlyPending"}, s = {"L$0", "L$2", "Z$0"})
public final class DigitalAvatarPreGenManager$collectBitmapPairs$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DigitalAvatarPreGenManager this$0;

    public DigitalAvatarPreGenManager$collectBitmapPairs$1(DigitalAvatarPreGenManager r100, Continuation<? super DigitalAvatarPreGenManager$collectBitmapPairs$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(false, this);
    }
}
