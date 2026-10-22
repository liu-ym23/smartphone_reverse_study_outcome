package com.larus.bmhome.upload.sdk.impl.engine;

import com.larus.bmhome.upload.sdk.api.model.UploadEngineType;
import com.monitor.cloudmessage.consts.CloudControlInf;
import is8.g;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class SkeletonUploadEngine implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UploadEngineType f314867a;

    public static final class a {
    }

    static {
    }

    public SkeletonUploadEngine(UploadEngineType r100) {
        this.f314867a = r100;
    }

    @Override // com.larus.bmhome.upload.sdk.impl.engine.c
    public final boolean a(is8.a r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        if (r100.f495637b != this.f314867a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.upload.sdk.impl.engine.c
    public final Object b(String r100, g r101, is8.a r102, js8.b r103, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> r104, Continuation<? super b> r105) {
        if ((r105 instanceof SkeletonUploadEngine$upload$1) == false) goto L7;
        SkeletonUploadEngine$upload$1 r106 = (SkeletonUploadEngine$upload$1) r105;
        int r107 = r106.label;
        if ((r107 & Integer.MIN_VALUE) == 0) goto L7;
        r106.label = r107 - Integer.MIN_VALUE;
    L8:
        Object r108 = r106.result;
        Object r109 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r110 = r106.label;
        if (r110 == 0) goto L14;
        if (r110 != 1) goto L12;
        r103 = (js8.b) r106.L$2;
        r102 = (is8.a) r106.L$1;
        r100 = (String) r106.L$0;
        ResultKt.throwOnFailure(r108);
    L18:
        throw new IllegalStateException("Skeleton upload engine is not bound to a concrete uploader yet. taskId=" + r100 + ", route=" + r102.f495637b + ", auth=" + r103.f500233a);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r108);
        Integer r111 = Boxing.boxInt(1);
        r106.L$0 = r100;
        r106.L$1 = r102;
        r106.L$2 = r103;
        r106.label = 1;
        if (r104.invoke(r111, r106) != r109) goto L18;
        return r109;
    L7:
        r106 = new SkeletonUploadEngine$upload$1(this, r105);
        goto L8
    }
}
