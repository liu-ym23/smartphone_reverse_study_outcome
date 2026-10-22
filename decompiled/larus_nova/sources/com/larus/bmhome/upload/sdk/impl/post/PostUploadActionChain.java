package com.larus.bmhome.upload.sdk.impl.post;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class PostUploadActionChain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f314871a;

    /* JADX WARN: Multi-variable type inference failed */
    public PostUploadActionChain(List<? extends b> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        this.f314871a = r100;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005e -> B:23:0x0061). Please report as a decompilation issue!!! */
    public final Object a(c r100, Continuation<? super c> r101) {
        if ((r101 instanceof PostUploadActionChain$execute$1) == false) goto L7;
        PostUploadActionChain$execute$1 r102 = (PostUploadActionChain$execute$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        Iterator<b> r107 = (Iterator) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L23:
        c r108 = (c) r104;
    L16:
        if (r107.hasNext() == false) goto L24;
        b r109 = r107.next();
        if (r109.a(r108.f314873b) == false) goto L16;
        r102.L$0 = r107;
        r102.label = 1;
        r104 = r109.b(r108, r102);
        if (r104 != r105) goto L23;
        return r105;
    L24:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Iterator<b> r110 = this.f314871a.iterator();
        r108 = r100;
        r107 = r110;
    L7:
        r102 = new PostUploadActionChain$execute$1(this, r101);
        goto L8
    }
}
