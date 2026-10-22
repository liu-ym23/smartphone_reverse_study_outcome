package com.larus.agents.impl.webfetch;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    final /* synthetic */ String $logCommandId;
    final /* synthetic */ long $startedAtNanos;

    public WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$2(String r100, long r101) {
        this.$logCommandId = r100;
        this.$startedAtNanos = r101;
        super(1, Intrinsics.Kotlin.class, "log", "fetchWebPageHtml$log(Ljava/lang/String;JLjava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        WebPageFetcher.d(this.$logCommandId, this.$startedAtNanos, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
