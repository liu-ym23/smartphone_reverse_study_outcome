package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraAdapterExtKt", f = "DoraAdapterExt.kt", i = {}, l = {940}, m = "requestAlbumListSync", n = {}, s = {})
final class DoraAdapterExtKt$requestAlbumListSync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public DoraAdapterExtKt$requestAlbumListSync$1(Continuation<? super DoraAdapterExtKt$requestAlbumListSync$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        DoraAdapterExtKt$requestAlbumListSync$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L12;
        if (r105 != 1) goto L11;
        ResultKt.throwOnFailure(r103);
    L15:
        v39.b r106 = (v39.b) r103;
        if ((r106 instanceof v39.b.f) == false) goto L18;
        byte[] r107 = ((v39.b.f) r106).f552961b.f552952d;
    L20:
        return r107;
    L18:
        r107 = new byte[0];
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r103);
        s0 r108 = s0.f332257a;
        qk4.c r109 = new qk4.c(null);
        r102.label = 1;
        r103 = r108.a(r109, 0, r102);
        if (r103 != r104) goto L15;
        return r104;
    L5:
        r102 = new DoraAdapterExtKt$requestAlbumListSync$1(this);
        goto L6
    }
}
