package com.larus.avlink.gallery.gecko;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.gecko.MorphoGeckoFileHelper", f = "MorphoGeckoFileHelper.kt", i = {}, l = {91}, m = "queryLocalFaceSrModelFromGecko", n = {}, s = {})
public final class MorphoGeckoFileHelper$queryLocalFaceSrModelFromGecko$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MorphoGeckoFileHelper this$0;

    public MorphoGeckoFileHelper$queryLocalFaceSrModelFromGecko$1(MorphoGeckoFileHelper r100, Continuation<? super MorphoGeckoFileHelper$queryLocalFaceSrModelFromGecko$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MorphoGeckoFileHelper r101 = this.this$0;
        MorphoGeckoFileHelper r102 = MorphoGeckoFileHelper.f292575a;
        return r101.j(this);
    }
}
