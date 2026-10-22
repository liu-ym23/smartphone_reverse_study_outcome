package com.larus.bmhome.upload.sdk.impl;

import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import hs8.e;
import hs8.f;
import is8.g;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class ApiCredentialProviderAdapter implements js8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f314841a;

    public ApiCredentialProviderAdapter(f r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f314841a = r100;
    }

    @Override // js8.c
    public final boolean b(AuthMode r100) {
        Intrinsics.checkNotNullParameter(r100, "authMode");
        return this.f314841a.b(r100);
    }

    @Override // js8.c
    public final Object a(g r100, is8.a r101, Continuation<? super js8.b> r102) {
        if ((r102 instanceof ApiCredentialProviderAdapter$fetch$1) == false) goto L7;
        ApiCredentialProviderAdapter$fetch$1 r103 = (ApiCredentialProviderAdapter$fetch$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        e r108 = (e) r105;
        return new js8.b(r108.f487078a, r108.f487079b);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        f r109 = this.f314841a;
        r103.label = 1;
        r105 = r109.a(r100, r101, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new ApiCredentialProviderAdapter$fetch$1(this, r102);
        goto L8
    }
}
