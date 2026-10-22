package com.bytedance.ies.argus.strategy.provider.client;

import android.webkit.WebResourceResponse;
import com.bytedance.ies.argus.api.params.c0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/ies/argus/strategy/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/ies/argus/strategy/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class WebMainFrameScriptInjectStrategyProvider$calculate$6 extends Lambda implements Function1<com.bytedance.ies.argus.strategy.a, Unit> {
    final /* synthetic */ Map.Entry<String, String> $cspHeader;
    final /* synthetic */ WebResourceResponse $currentResponse;
    final /* synthetic */ List<t06.i> $needInjectScriptList;
    final /* synthetic */ String $newCSPValue;
    final /* synthetic */ com.bytedance.ies.argus.strategy.a $rewritePayload;
    final /* synthetic */ WebMainFrameScriptInjectStrategyProvider this$0;

    public WebMainFrameScriptInjectStrategyProvider$calculate$6(WebMainFrameScriptInjectStrategyProvider r100, WebResourceResponse r101, List<t06.i> r102, Map.Entry<String, String> r103, String r104, com.bytedance.ies.argus.strategy.a r105) {
        this.this$0 = r100;
        this.$currentResponse = r101;
        this.$needInjectScriptList = r102;
        this.$cspHeader = r103;
        this.$newCSPValue = r104;
        this.$rewritePayload = r105;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.ies.argus.strategy.a r100) {
        WebMainFrameScriptInjectStrategyProvider r101 = this.this$0;
        WebResourceResponse r102 = this.$currentResponse;
        List<t06.i> r103 = this.$needInjectScriptList;
        Pair<String, String> r104 = TuplesKt.to(this.$cspHeader.getKey(), this.$newCSPValue);
        int r105 = WebMainFrameScriptInjectStrategyProvider.f246204a;
        WebResourceResponse r106 = r101.c(r102, r103, r104);
        int r107 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("WebMainFrameScriptInjectStrategyProvider", "inject script success with handle csp, new csp value: " + this.$newCSPValue);
        ((c0) this.$rewritePayload).f245730b = r106;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.ies.argus.strategy.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
