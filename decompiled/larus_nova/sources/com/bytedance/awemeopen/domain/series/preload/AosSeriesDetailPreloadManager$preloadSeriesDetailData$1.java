package com.bytedance.awemeopen.domain.series.preload;

import com.bytedance.awemeopen.bizmodels.series.preload.AosPreloadSeriesDetailReason;
import com.bytedance.awemeopen.domain.series.q;
import com.bytedance.awemeopen.infra.support.AoCodeResult;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/awemeopen/infra/support/AoCodeResult;", "Lcom/bytedance/awemeopen/domain/series/q;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/awemeopen/infra/support/AoCodeResult;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class AosSeriesDetailPreloadManager$preloadSeriesDetailData$1 extends Lambda implements Function1<AoCodeResult<q>, Unit> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ AosPreloadSeriesDetailReason $preloadReason;

    public AosSeriesDetailPreloadManager$preloadSeriesDetailData$1(String r100, AosPreloadSeriesDetailReason r101) {
        this.$cacheKey = r100;
        this.$preloadReason = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AoCodeResult<q> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getSeriesDetail");
        final String r101 = this.$cacheKey;
        final AosPreloadSeriesDetailReason r102 = this.$preloadReason;
        r100.b(new AnonymousClass1(r101, r102));
        final AosPreloadSeriesDetailReason r103 = this.$preloadReason;
        final String r104 = this.$cacheKey;
        r100.a(new AnonymousClass2(r103, r104));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AoCodeResult<q> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
