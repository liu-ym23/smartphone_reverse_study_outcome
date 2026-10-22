package com.bytedance.ies.argus.strategy.provider.client;

import android.webkit.WebResourceResponse;
import com.bytedance.ies.argus.api.params.c0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/ies/argus/strategy/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ies/argus/strategy/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class FallbackWebMainFrameInterceptStrategyProvider$calculate$1 extends Lambda implements Function1<com.bytedance.ies.argus.strategy.a, Unit> {
    final /* synthetic */ WebResourceResponse $response;
    final /* synthetic */ com.bytedance.ies.argus.strategy.a $rewritePayload;

    public FallbackWebMainFrameInterceptStrategyProvider$calculate$1(com.bytedance.ies.argus.strategy.a r100, WebResourceResponse r101) {
        this.$rewritePayload = r100;
        this.$response = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.ies.argus.strategy.a r100) {
        c0 r101 = (c0) this.$rewritePayload;
        r101.f245730b = this.$response;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.ies.argus.strategy.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
