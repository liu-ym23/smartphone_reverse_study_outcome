package com.larus.bmhome.upload.sdk.impl;

import com.larus.bmhome.upload.sdk.ResourceCenterRegisterPostAction;
import com.monitor.cloudmessage.consts.CloudControlInf;
import hs8.d;
import is8.g;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class ApiPostUploadActionAdapter implements com.larus.bmhome.upload.sdk.impl.post.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hs8.c f314842a;

    public ApiPostUploadActionAdapter(ResourceCenterRegisterPostAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f314842a = r100;
    }

    @Override // com.larus.bmhome.upload.sdk.impl.post.b
    public final boolean a(is8.a r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        return this.f314842a.a(r100);
    }

    @Override // com.larus.bmhome.upload.sdk.impl.post.b
    public final Object b(com.larus.bmhome.upload.sdk.impl.post.c r110, Continuation<? super com.larus.bmhome.upload.sdk.impl.post.c> r111) {
        if ((r111 instanceof ApiPostUploadActionAdapter$execute$1) == false) goto L7;
        ApiPostUploadActionAdapter$execute$1 r100 = (ApiPostUploadActionAdapter$execute$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L17:
        d r113 = (d) r112;
        g r104 = r113.f487073a;
        is8.a r105 = r113.f487074b;
        hs8.a r106 = r113.f487075c;
        return new com.larus.bmhome.upload.sdk.impl.post.c(r104, r105, r106.f487071a, r106.f487072b, r113.f487076d, r113.f487077e);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        hs8.c r114 = this.f314842a;
        d r107 = new d(r110.f314872a, r110.f314873b, new hs8.a(r110.f314874c, r110.f314875d), r110.f314876e, r110.f314877f);
        r100.label = 1;
        r112 = r114.b(r107, r100);
        if (r112 != r102) goto L17;
        return r102;
    L7:
        r100 = new ApiPostUploadActionAdapter$execute$1(this, r111);
        goto L8
    }
}
