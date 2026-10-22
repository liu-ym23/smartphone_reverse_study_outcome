package com.larus.agents.impl.webfetch;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$1 extends FunctionReferenceImpl implements Function0<Unit> {
    final /* synthetic */ AtomicBoolean $cancelled;
    final /* synthetic */ long $startedAtNanos;
    final /* synthetic */ WebPageFetcher this$0;

    public WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$1(AtomicBoolean r100, WebPageFetcher r101, long r102) {
        this.$cancelled = r100;
        this.this$0 = r101;
        this.$startedAtNanos = r102;
        super(0, Intrinsics.Kotlin.class, "checkRunning", "run$checkRunning(Ljava/util/concurrent/atomic/AtomicBoolean;Lcom/larus/agents/impl/webfetch/WebPageFetcher;J)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WebPageFetcher$fetchWebPageHtml$result$1$1$2.b(this.$cancelled, this.this$0, this.$startedAtNanos);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
