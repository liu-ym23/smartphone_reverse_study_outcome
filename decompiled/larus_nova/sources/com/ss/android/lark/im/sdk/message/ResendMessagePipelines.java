package com.ss.android.lark.im.sdk.message;

import com.ss.android.lark.im.sdk.message.resend.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes36.dex */
public class ResendMessagePipelines {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f425905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.im.sdk.message.resend.a f425906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f425907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f425908d;

    public static final class a {
    }

    public String b() {
        return "ImSdkResendPipelines";
    }

    static {
        new ResendMessagePipelines();
    }

    public ResendMessagePipelines() {
        this.f425905a = new g();
        this.f425906b = new com.ss.android.lark.im.sdk.message.resend.a();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.f425907c = LazyKt.lazy(r100, new ResendMessagePipelines$specialResendMessagePipelineMap$2(this));
        this.f425908d = LazyKt.lazy(r100, new ResendMessagePipelines$commonResendMessagePipeline$2(this));
    }

    public com.ss.android.lark.im.sdk.message.resend.a a() {
        return this.f425906b;
    }
}
