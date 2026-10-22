package com.larus.dora.impl.feedback;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes27.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f335676a = null;

    static {
        f335676a = new t0();
    }

    public t0() {
    }

    public final Object a(String r100, String r101, DoraFeedbackImage$compressImage$2$compressionJob$1.a r102, Continuation r103) {
        if ((r103 instanceof VideoCompressor$compressVideo$1) == false) goto L7;
        VideoCompressor$compressVideo$1 r104 = (VideoCompressor$compressVideo$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L18:
        return ((Result) r106).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        CoroutineDispatcher r109 = Dispatchers.getIO();
        VideoCompressor$compressVideo$2 r110 = new VideoCompressor$compressVideo$2(r100, r101, r102, null);
        r104.label = 1;
        r106 = BuildersKt.withContext(r109, r110, r104);
        if (r106 != r107) goto L18;
        return r107;
    L7:
        r104 = new VideoCompressor$compressVideo$1(this, r103);
        goto L8
    }
}
