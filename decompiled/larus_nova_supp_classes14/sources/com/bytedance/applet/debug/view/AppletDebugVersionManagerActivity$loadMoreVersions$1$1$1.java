package com.bytedance.applet.debug.view;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppVersionList;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppVersionList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugVersionManagerActivity$loadMoreVersions$1$1$1", f = "AppletDebugVersionManagerActivity.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
public final class AppletDebugVersionManagerActivity$loadMoreVersions$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OpenPlatformPreviewAppVersionList>, Object> {
    final /* synthetic */ String $appKey;
    final /* synthetic */ String $cursor;
    int label;
    final /* synthetic */ AppletDebugVersionManagerActivity this$0;

    public AppletDebugVersionManagerActivity$loadMoreVersions$1$1$1(String r1, AppletDebugVersionManagerActivity r2, String r3, Continuation<? super AppletDebugVersionManagerActivity$loadMoreVersions$1$1$1> r4) {
        this.$appKey = r1;
        this.this$0 = r2;
        this.$cursor = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AppletDebugVersionManagerActivity$loadMoreVersions$1$1$1(this.$appKey, this.this$0, this.$cursor, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super OpenPlatformPreviewAppVersionList> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IAISDKDebugService.Companion r2 = IAISDKDebugService.a;
        int r11 = AppletDebugVersionManagerActivity.q;
        String r3 = this.$appKey;
        String r4 = com.larus.platform.service.o.a.getDeviceId();
        String r5 = AppletDebugVersionManagerActivity.N1(this.this$0);
        String r6 = this.$cursor;
        this.label = 1;
        r10 = r2.k(r11, r3, r4, r5, r6, 20, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
