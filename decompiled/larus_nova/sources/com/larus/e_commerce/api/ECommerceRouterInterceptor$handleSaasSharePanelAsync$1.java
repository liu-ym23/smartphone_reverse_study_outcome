package com.larus.e_commerce.api;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.e_commerce.api.ECommerceRouterInterceptor", f = "ECommerceRouterInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {171}, m = "handleSaasSharePanelAsync", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "uri", "scene", "zlinkUrl", "title", "imageUrl", "contentId", "poiId", "liveRoomId", "trackInfo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"})
final class ECommerceRouterInterceptor$handleSaasSharePanelAsync$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECommerceRouterInterceptor this$0;

    public ECommerceRouterInterceptor$handleSaasSharePanelAsync$1(ECommerceRouterInterceptor r100, Continuation<? super ECommerceRouterInterceptor$handleSaasSharePanelAsync$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ECommerceRouterInterceptor.c(this.this$0, null, null, this);
    }
}
