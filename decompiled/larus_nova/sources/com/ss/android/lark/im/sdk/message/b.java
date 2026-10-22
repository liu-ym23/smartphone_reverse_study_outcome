package com.ss.android.lark.im.sdk.message;

import com.bytedance.lark.rustclient.api.l;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends ResendMessagePipelines {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f425932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.im.sdk.message.resend.e f425933f;

    @Override // com.ss.android.lark.im.sdk.message.ResendMessagePipelines
    public final com.ss.android.lark.im.sdk.message.resend.a a() {
        return this.f425933f;
    }

    @Override // com.ss.android.lark.im.sdk.message.ResendMessagePipelines
    public final String b() {
        return this.f425932e;
    }

    @Inject
    public b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f425932e = "ImSdkResendPipelinesV2";
        this.f425933f = new com.ss.android.lark.im.sdk.message.resend.e(r100);
    }
}
