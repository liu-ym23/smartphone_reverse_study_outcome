package com.bytedance.lark.sdk.refactor.state;

import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.sdk.InvokeResponse;
import com.bytedance.lark.sdk.refactor.m;
import com.bytedance.lark.sdk.refactor.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public abstract class j implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f254350a;

    public abstract SdkState a();

    @Override // com.bytedance.lark.sdk.refactor.l
    public void j(se6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        this.f254350a.j(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public int l(String r100, byte[] r101) {
        return this.f254350a.l(r100, r101);
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public int p(InitSDKRequest.Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "requestBuilder");
        return this.f254350a.p(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public InvokeResponse r(se6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return this.f254350a.r(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.h
    public final void v(q r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f254350a.v(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.h
    public final void y(com.bytedance.lark.sdk.refactor.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f254350a.y(r100);
    }

    public j(m r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f254350a = r100;
    }
}
