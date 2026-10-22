package io.ktor.client.call;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.k;
import io.ktor.utils.io.core.v;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class SavedCallKt {
    public static final Object a(HttpClientCall r100, Continuation<? super HttpClientCall> r101) {
        if ((r101 instanceof SavedCallKt$save$1) == false) goto L7;
        SavedCallKt$save$1 r102 = (SavedCallKt$save$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (HttpClientCall) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        byte[] r107 = v.b((k) r104);
        return new a(r100.f491622a, r100.c(), r100.d(), r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        ByteReadChannel r108 = r100.d().a();
        r102.L$0 = r100;
        r102.label = 1;
        r104 = ByteReadChannel.a.a(r108, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new SavedCallKt$save$1(r101);
        goto L8
    }
}
