package com.bytedance.applet.debug.view;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugVersionManagerActivity$loadFirstPage$1$1$1", f = "AppletDebugVersionManagerActivity.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
public final class AppletDebugVersionManagerActivity$loadFirstPage$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OpenPlatformPreviewAppInfoList>, Object> {
    int label;
    final /* synthetic */ AppletDebugVersionManagerActivity this$0;

    public AppletDebugVersionManagerActivity$loadFirstPage$1$1$1(AppletDebugVersionManagerActivity r1, Continuation<? super AppletDebugVersionManagerActivity$loadFirstPage$1$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AppletDebugVersionManagerActivity$loadFirstPage$1$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super OpenPlatformPreviewAppInfoList> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        IAISDKDebugService.Companion r2 = IAISDKDebugService.a;
        int r10 = AppletDebugVersionManagerActivity.q;
        String r3 = com.larus.platform.service.o.a.getDeviceId();
        String r4 = AppletDebugVersionManagerActivity.N1(this.this$0);
        this.label = 1;
        r9 = r2.w(r10, r3, r4, "", 20, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
