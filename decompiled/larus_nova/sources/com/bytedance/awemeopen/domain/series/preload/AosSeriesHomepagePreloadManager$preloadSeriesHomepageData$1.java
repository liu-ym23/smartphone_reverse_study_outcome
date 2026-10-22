package com.bytedance.awemeopen.domain.series.preload;

import com.bytedance.awemeopen.bizmodels.series.preload.AosPreloadSeriesHomepageReason;
import com.bytedance.awemeopen.domain.series.r;
import com.bytedance.awemeopen.infra.support.AoCodeResult;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/awemeopen/infra/support/AoCodeResult;", "Lcom/bytedance/awemeopen/domain/series/r;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/awemeopen/infra/support/AoCodeResult;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class AosSeriesHomepagePreloadManager$preloadSeriesHomepageData$1 extends Lambda implements Function1<AoCodeResult<r>, Unit> {
    final /* synthetic */ AosPreloadSeriesHomepageReason $preloadReason;

    public AosSeriesHomepagePreloadManager$preloadSeriesHomepageData$1(AosPreloadSeriesHomepageReason r100) {
        this.$preloadReason = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AoCodeResult<r> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getSeriesHomepage");
        final AosPreloadSeriesHomepageReason r101 = this.$preloadReason;
        r100.b(new AnonymousClass1(r101));
        final AosPreloadSeriesHomepageReason r102 = this.$preloadReason;
        r100.a(new AnonymousClass2(r102));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AoCodeResult<r> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
