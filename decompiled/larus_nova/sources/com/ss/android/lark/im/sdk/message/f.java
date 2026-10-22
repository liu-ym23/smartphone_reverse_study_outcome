package com.ss.android.lark.im.sdk.message;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.im.sdk.message.send.FinalSendMessageStep;
import com.ss.android.lark.im.sdk.message.send.SdkCreatePreMessageStep$Companion$rustClientQuasiMessageCreator$1;
import com.ss.android.lark.im.sdk.message.send.j;
import com.ss.android.lark.im.sdk.message.send.n;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f extends SendMessagePipelines {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final l f425943n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.ss.android.lark.im.sdk.service.e f425944o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f425945p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final n f425946q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j f425947r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final FinalSendMessageStep f425948s;

    @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines
    public final FinalSendMessageStep b() {
        return this.f425948s;
    }

    @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines
    public final String c() {
        return this.f425945p;
    }

    @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines
    public final j d() {
        return this.f425947r;
    }

    @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines
    public final jkb.d e() {
        return this.f425946q;
    }

    @Inject
    public f(final l r100, com.ss.android.lark.im.sdk.service.e r101) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        Intrinsics.checkNotNullParameter(r101, "voiceTextPostProcessService");
        this.f425943n = r100;
        this.f425944o = r101;
        this.f425945p = "ImSdkSendPipelinesV2";
        this.f425946q = new n(r101);
        int r102 = j.f425985b;
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f425947r = new j(new SdkCreatePreMessageStep$Companion$rustClientQuasiMessageCreator$1(r100));
        int r103 = FinalSendMessageStep.f425969b;
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f425948s = new FinalSendMessageStep(new com.ss.android.lark.im.sdk.message.send.f(r100));
    }
}
