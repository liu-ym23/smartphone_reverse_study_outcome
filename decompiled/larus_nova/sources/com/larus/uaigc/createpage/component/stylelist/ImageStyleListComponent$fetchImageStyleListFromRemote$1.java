package com.larus.uaigc.createpage.component.stylelist;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.stylelist.ImageStyleListComponent", f = "ImageStyleListComponent.kt", i = {}, l = {213}, m = "fetchImageStyleListFromRemote", n = {}, s = {})
public final class ImageStyleListComponent$fetchImageStyleListFromRemote$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageStyleListComponent this$0;

    public ImageStyleListComponent$fetchImageStyleListFromRemote$1(ImageStyleListComponent r100, Continuation<? super ImageStyleListComponent$fetchImageStyleListFromRemote$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ImageStyleListComponent r101 = this.this$0;
        int r102 = ImageStyleListComponent.f372462p;
        return r101.F2(null, this);
    }
}
