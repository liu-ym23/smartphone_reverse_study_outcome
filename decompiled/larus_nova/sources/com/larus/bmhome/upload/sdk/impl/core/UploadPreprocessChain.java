package com.larus.bmhome.upload.sdk.impl.core;

import is8.g;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class UploadPreprocessChain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f314858a;

    /* JADX WARN: Multi-variable type inference failed */
    public UploadPreprocessChain(List<? extends c> r100) {
        Intrinsics.checkNotNullParameter(r100, "preprocessors");
        this.f314858a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0070 -> B:21:0x0071). Please report as a decompilation issue!!! */
    public final Object a(g r100, Continuation<? super g> r101) {
        if ((r101 instanceof UploadPreprocessChain$process$1) == false) goto L7;
        UploadPreprocessChain$process$1 r102 = (UploadPreprocessChain$process$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        Ref.ObjectRef r107 = (Ref.ObjectRef) r102.L$2;
        Iterator r108 = (Iterator) r102.L$1;
        Ref.ObjectRef r109 = (Ref.ObjectRef) r102.L$0;
        ResultKt.throwOnFailure(r104);
        T r110 = r104;
    L21:
        r107.element = r110;
        r107 = r109;
    L16:
        if (r108.hasNext() == false) goto L23;
        c r111 = (c) r108.next();
        g r112 = (g) r107.element;
        r102.L$0 = r107;
        r102.L$1 = r108;
        r102.L$2 = r107;
        r102.label = 1;
        g r113 = r111.a(r112);
        if (r113 != r105) goto L20;
        return r105;
    L20:
        r109 = r107;
        r110 = r113;
        goto L21
    L23:
        return r107.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Ref.ObjectRef r114 = new Ref.ObjectRef();
        r114.element = r100;
        r108 = this.f314858a.iterator();
        r107 = r114;
    L7:
        r102 = new UploadPreprocessChain$process$1(this, r101);
        goto L8
    }
}
