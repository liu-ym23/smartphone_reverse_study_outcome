package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraAdapterExtKt", f = "DoraAdapterExt.kt", i = {}, l = {956}, m = "requestAlbumThumbnailDataSync", n = {}, s = {})
final class DoraAdapterExtKt$requestAlbumThumbnailDataSync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public DoraAdapterExtKt$requestAlbumThumbnailDataSync$1(Continuation<? super DoraAdapterExtKt$requestAlbumThumbnailDataSync$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        int r111 = this.label | Integer.MIN_VALUE;
        this.label = r111;
        if ((r111 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r111 - Integer.MIN_VALUE;
        DoraAdapterExtKt$requestAlbumThumbnailDataSync$1 r112 = this;
    L6:
        Object r100 = r112.result;
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r112.label;
        if (r102 == 0) goto L12;
        if (r102 != 1) goto L11;
        ResultKt.throwOnFailure(r100);
    L15:
        v39.b r103 = (v39.b) r100;
        if ((r103 instanceof v39.b.f) == false) goto L18;
        byte[] r113 = ((v39.b.f) r103).f552961b.f552952d;
    L20:
        return r113;
    L18:
        r113 = new byte[0];
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r100);
        s0 r104 = s0.f332257a;
        qk4.d r114 = new qk4.d(null, 0, 0, (byte) 0);
        r112.label = 1;
        r100 = r104.a(r114, 0, r112);
        if (r100 != r101) goto L15;
        return r101;
    L5:
        r112 = new DoraAdapterExtKt$requestAlbumThumbnailDataSync$1(this);
        goto L6
    }
}
