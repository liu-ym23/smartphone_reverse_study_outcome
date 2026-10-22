package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils;

import cd4.k;
import cd4.m;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IXPayBaseMethod.b f202695a;

    @Override // cd4.k
    public final void onStart(m r100) {
    }

    public a(IXPayBaseMethod.b r100) {
        this.f202695a = r100;
    }

    @Override // cd4.k
    public final void onSuccess(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        IXPayBaseMethod.b r101 = this.f202695a;
        if (r101 == null) goto L6;
        ContainerUtils r102 = ContainerUtils.f202693a;
        r101.success(ContainerUtils.c(r100));
        return;
    }

    @Override // cd4.k
    public final void onFailed(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        Intrinsics.checkNotNullParameter(r101, "result");
        IXPayBaseMethod.b r102 = this.f202695a;
        if (r102 == null) goto L6;
        ContainerUtils r103 = ContainerUtils.f202693a;
        r102.a(ContainerUtils.c(r101), r100);
        return;
    }
}
